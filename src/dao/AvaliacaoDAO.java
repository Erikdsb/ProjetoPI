package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Avaliacao;
import model.Entrega;
import service.ConnectionFactory;

public class AvaliacaoDAO {

	public void inserir(Avaliacao avaliacao) {
		String sqlInsert = "INSERT INTO Avaliacao(id, entrega_id, turma_aluno_id, nota, dt_avaliacao, comentarios)VALUES (?, ?, ?, ?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, avaliacao.getId());
			stm.setInt(2, avaliacao.getEntrega().getId());
			stm.setDouble(3, avaliacao.getNota());
			stm.setDate(4, (Date) avaliacao.getData());
			stm.setString(5, avaliacao.getComentarios());
			stm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Avaliacao avaliacao) {
		String sqlUpdate = "UPDATE Avaliacao SET nota = ?, dt_avaliacao=?, comentarios = ? WHERE id=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setDouble(1, avaliacao.getNota());
			stm.setDate(2, (Date) avaliacao.getData());
			stm.setString(3, avaliacao.getComentarios());
			stm.setInt(4, avaliacao.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Avaliacao To) {
		String sqlDelete = "DELETE FROM avaliacao WHERE id = ?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, To.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Avaliacao carregar(int id) {
		String sqlSelect = "SELECT id, entrega_id, turma_aluno_id, nota, dt_avaliacao, comentarios FROM avaliacao WHERE id = ?";
		Avaliacao avaliacao = new Avaliacao(id);

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, avaliacao.getId());
			try (ResultSet rs = stm.executeQuery()) {
				if (rs.next()) {
					avaliacao.setId(rs.getInt(1));

					Entrega entrega = new Entrega(rs.getInt(2));
					avaliacao.setEntrega(entrega);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return avaliacao;
	}

}
