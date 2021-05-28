package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Professor;
import service.ConnectionFactory;

public class ProfessorDAO {

	public void incluir(Professor to) {
		String sqlInsert = "INSERT INTO Professor(id, administrador, matricula) VALUES (?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getId());
			stm.setInt(2, to.getAdministrador());
			stm.setString(3, to.getMatricula());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Professor to) {
		String sqlUpdate = "UPDATE Professor SET nome=?, fone=? WHERE id=?";

		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, to.getAdministrador());
			stm.setString(2, to.getMatricula());
			stm.setInt(3, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Professor to) {
		String sqlDelete = "DELETE FROM Professor WHERE id = ?";

		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Professor carregar(int id) {
		Professor to = new Professor();
		String sqlSelect = "SELECT administrador, matricula FROM Professor WHERE Professor.id = ?";
		
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setAdministrador(rs.getInt("administrador"));
					to.setMatricula(rs.getString("matricula"));
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