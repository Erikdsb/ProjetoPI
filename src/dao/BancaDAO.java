package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Banca;
import model.Grupo;
import service.ConnectionFactory;

public class BancaDAO {

	public void insert(Banca banca) {
		String sqlInsert = "INSERT INTO Banca(id, grupo_id, data, sala)VALUES (?, ?, ?, ?)";
		Grupo g = new Grupo();

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			System.out.println(banca.getId());
			stm.setInt(1, banca.getId());

			g = banca.getGrupos().get(0);
			stm.setInt(2, g.getId());
			stm.setDate(3, (Date) banca.getDt_cadastro());
			stm.setString(4, banca.getSala());
			stm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Banca banca) {
		String sqlUpdate = "UPDATE banca SET data = ?, grupo_id = ?, sala = ?, WHERE id=?";
		Grupo g = new Grupo();

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setDate(1, (Date) banca.getDt_cadastro());

			g = banca.getGrupos().get(0);
			stm.setInt(2, g.getId());
			stm.setString(3, banca.getSala());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Banca to) {
		String sqlDelete = "DELETE FROM Banca WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Banca carregar(int id) {
		String sqlSelect = "SELECT id, data, sala, grupo_id FROM banca WHERE id = ?";
		Banca banca = new Banca(id);

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, banca.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					Grupo g = new Grupo();
					banca.setId(rs.getInt(1));
					banca.setDt_cadastro(rs.getDate(2));
					banca.setSala(rs.getString(3));

					g.setId(rs.getInt(4));
					banca.getGrupos().add(g);

				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return banca;
	}

}
