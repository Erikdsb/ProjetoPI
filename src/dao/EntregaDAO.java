package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Atividade;
import model.Entrega;
import model.Grupo;
import service.ConnectionFactory;

public class EntregaDAO {

	public void insert(Entrega entrega) {
		String sqlInsert = "INSERT INTO Entrega(id, dt_cadastro, grupo_id, atividade_id)VALUES (?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			System.out.println(entrega.getId());
			stm.setInt(1, entrega.getId());
			stm.setDate(2, (Date) entrega.getDt_cadastro());
			stm.setInt(3, entrega.getGrupo().getId());
			stm.setInt(4, entrega.getAtividade().getId());
			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Entrega entrega) {
		String sqlUpdate = "UPDATE Entrega SET dt_cadastro=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setDate(1, (Date) entrega.getDt_cadastro());
			stm.setInt(2, entrega.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Entrega entrega) {
		String sqlDelete = "DELETE FROM entrega WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, entrega.getId());
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Entrega carregar(int id) {
		String sqlSelect = "SELECT grupo_id, atividade_id, id, dt_cadastro FROM entrega WHERE id = ?";

		Entrega entrega = new Entrega(id);
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, entrega.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					Grupo g = new Grupo();
					Atividade a = new Atividade();
					g.setId(rs.getInt(1));
					a.setId(rs.getInt(2));
					entrega.setId(rs.getInt(3));
					entrega.setDt_cadastro(rs.getDate(4));
					entrega.setAtividade(a);
					entrega.setGrupo(g);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return entrega;
	}

}
