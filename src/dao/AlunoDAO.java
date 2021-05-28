package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;
import service.ConnectionFactory;

public class AlunoDAO {
	public void criar(Aluno to) {
		String sqlInsert = "INSERT INTO aluno (id,ra) VALUES (?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getId());
			stm.setString(2, to.getRa());
			stm.execute();
			String sqlQuery = "SELECT LAST_INSERT_ID()";
			try (PreparedStatement stm2 = conn.prepareStatement(sqlQuery); ResultSet rs = stm2.executeQuery();) {
				if (rs.next()) {
					to.setId(rs.getInt(1));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Aluno to) {
		String sqlUpdate = "UPDATE Aluno SET id=?, ra=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, to.getId());
			stm.setString(2, to.getRa());
			stm.setInt(4, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Aluno to) {
		String sqlDelete = "DELETE FROM cliente WHERE id = ? ";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Aluno carregar(int id) throws SQLException {
		String sqlSelect = "SELECT id, ra, FROM Aluno WHERE id = ?";

		Aluno to = new Aluno(id);
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, to.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setId(Integer.parseInt(rs.getString(1)));
					to.setRa(rs.getString(2));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return to;
		}
	}
}
