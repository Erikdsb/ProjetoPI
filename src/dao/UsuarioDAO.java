package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;
import model.Professor;
import model.Usuario;
import service.ConnectionFactory;

public class UsuarioDAO {
	
	public void incluir(Usuario to) {
		String sqlInsert = "INSERT INTO Usuario(id, nome, email, senha) VALUES (?, ?, ?, ?)";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, to.getId());
			stm.setString(2, to.getNome());
			stm.setString(3, to.getEmail());
			stm.setString(4, to.getSenha());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizar(Usuario to) {
		String sqlUpdate = "UPDATE Usuario SET nome=?, email=? , senha=? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, to.getNome());
			stm.setString(2, to.getEmail());
			stm.setString(3, to.getSenha());
			stm.setInt(4, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluir(Usuario to) {
		String sqlDelete = "DELETE FROM Usuario WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, to.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Usuario carregar(int id) {
		Usuario to = new Usuario();
		String sqlSelect = "SELECT nome, email, senha FROM Usuario WHERE Usuario.id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao(); PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, id);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					to.setNome(rs.getString("nome"));
					to.setEmail(rs.getString("email"));
					to.setSenha(Integer.toString(rs.getInt("senha")));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return to;
	}
	public Usuario carregar(String uEmail) {
		String sqlSelect = "SELECT * FROM usuario LEFT JOIN aluno ON aluno.aluno_id = usuario.id LEFT JOIN professor ON professor.professor_id = usuario.id WHERE (usuario.email) LIKE ?";
		Usuario to = null;
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setString(1, uEmail);
			try(ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					int id = rs.getInt(1);
					String nome = rs.getString(2);
					String email = rs.getString(3);
					String senha = rs.getString(4);
					
					if(rs.getInt(5) == 0) {
						int id2 = rs.getInt(7), adm = rs.getInt(8);
						String matr = rs.getString(9);
						to = new Professor(id, nome, email, senha, id2, adm, matr);
						
					}else {
						int id2 = rs.getInt(5);
						String ra = rs.getString(6);
						to = new Aluno(id, nome, email, senha, id2, ra);
					}
				}else {
					to = new Professor();
					to.setEmail("erro");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return to;
	}
	
}