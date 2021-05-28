package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Grupo;
import model.Professor;
import service.ConnectionFactory;

public class GrupoDAO {

	public void inserir(Grupo grupo) {
		String sqlInsert = "INSERT INTO Grupo(id, numero, nome, orientador_id)VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			System.out.println(grupo.getId());
			stm.setInt(1, grupo.getId());
			stm.setInt(2, grupo.getNumero());
			stm.setString(3, grupo.getNome());
			stm.setInt(4, grupo.getProfessor().getId());
			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Grupo grupo) {
		String sqlUpdate = "UPDATE Grupo SET numero=?, nome = ? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, grupo.getNumero());
			stm.setString(2, grupo.getNome());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Grupo to) {
		String sqlDelete = "DELETE FROM Grupo WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Grupo carregar(int id) {
		String sqlSelect = "SELECT numero, nome, orientador FROM grupo WHERE id = ?";

		Grupo to = new Grupo(id);
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, to.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					Professor p = new Professor();
					to.setNumero(rs.getInt("numero"));
					to.setNome(rs.getString("nome"));
					p.setNome(rs.getString("orientador"));
					to.setProfessor(p);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}

}
