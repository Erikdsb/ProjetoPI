package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Tema;
import service.ConnectionFactory;

public class TemaDAO {

	public int insert(Tema tema) {
		String sqlInsert = "INSERT INTO Tema(dt_cadastro, titulo, introducao, requisitos)VALUES (current_date(), ?, ?, ?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setString(1, tema.getTitulo());
			stm.setString(2, tema.getIntroducao());
			stm.setString(3, tema.getRequisitos());
			stm.execute();
			
			String sqlSelect = "SELECT last_insert_id()";
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
				if(rs.next()) {
					tema.setId(rs.getInt(1));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tema.getId();
	}

	public void atualizar(Tema tema) {
		String sqlUpdate = "UPDATE Tema SET introducao=?, titulo=?, requisitos=?  WHERE id=?";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setString(1, tema.getIntroducao());
			stm.setString(2, tema.getTitulo());
			stm.setString(3, tema.getRequisitos());
			stm.setInt(4, tema.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Tema tema) {
		String sqlDelete = "DELETE FROM Tema WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, tema.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Tema carregar(int id) {
		String sqlSelect = "SELECT dt_cadastro, introducao, titulo, requisitos FROM Tema WHERE id = ?";
		Tema tema = new Tema(id);

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, tema.getId());
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					tema.setDt_cadastro(rs.getDate("dt_cadastro"));
					tema.setIntroducao(rs.getString("introducao"));
					tema.setTitulo(rs.getString("titulo"));
					tema.setRequisitos(rs.getString("requisitos"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return tema;
	}
	
	public ArrayList<Tema> carregar(String titulo) {
		String sqlSelect = "SELECT id, dt_cadastro, titulo, introducao, requisitos FROM tema WHERE (titulo) LIKE %?%";
		ArrayList<Tema> lista = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setString(1, titulo);
			try(ResultSet rs = stm.executeQuery()){
				while(rs.next()) {
					Tema t = new Tema();
					t.setId(rs.getInt(1));
					t.setDt_cadastro(rs.getDate(2));
					t.setTitulo(rs.getString(3));
					t.setIntroducao(rs.getString(4));
					t.setRequisitos(rs.getString(5));
					lista.add(t);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(SQLException e1) {
			System.out.println(e1.getStackTrace());;
		}
		return lista;
	}
	
	public ArrayList<Tema> findAll() {
		String sqlSelect = "SELECT id, dt_cadastro, titulo, introducao, requisitos FROM tema";
		ArrayList<Tema> lista = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){

			try(ResultSet rs = stm.executeQuery()){
				while(rs.next()) {
					Tema t = new Tema();
					t.setId(rs.getInt(1));
					t.setDt_cadastro(rs.getDate(2));
					t.setTitulo(rs.getString(3));
					t.setIntroducao(rs.getString(4));
					t.setRequisitos(rs.getString(5));
					lista.add(t);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(SQLException e1) {
			System.out.println(e1.getStackTrace());;
		}
		return lista;
	}
	
}
