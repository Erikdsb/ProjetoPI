package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.ArrayList;

import model.Turma;
import service.ConnectionFactory;

public class TurmaDAO {
	public int criar(Turma turma) {
		String sqlInsert = "INSERT INTO turma(semestre_letivo, ano_letivo, sigla, tema_id) VALUES (?, ?, ?,?)";

		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, turma.getSemestreLetivo());
			stm.setInt(2, turma.getAnoLetivo());
			stm.setString(3, turma.getSigla());
			stm.setInt(4, turma.getTemaId());
			stm.execute();
			
			String sqlSelect = "SELECT last_insert_id()";
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
				if(rs.next()) {
					turma.setId(rs.getInt(1));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return turma.getId();
	}

	public void atualizar(Turma turma) {
		String sqlUpdate = "UPDATE turma SET semestre_letivo=?, ano_letivo=?, sigla=?, tema_id = ? WHERE id=?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt(1, turma.getSemestreLetivo());
			stm.setInt(2, turma.getAnoLetivo());
			stm.setString(3, turma.getSigla());
			stm.setInt(4, turma.getTemaId());
			stm.setInt(5, turma.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void excluir(Turma turma) {
		String sqlDelete = "DELETE FROM turma WHERE id = ?";
		try (Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			stm.setInt(1, turma.getId());
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Turma carregar(int id) {
		String sqlSelect = "SELECT semestre_letivo, ano_letivo, sigla, id, tema_id FROM turma WHERE id = ?";
		Turma turma = new Turma(id);
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, turma.getId());
			
			try(ResultSet rs = stm.executeQuery()){
				if(rs.next()) {
					turma.setSemestreLetivo(rs.getInt(1));
					turma.setAnoLetivo(rs.getInt(2));
					turma.setSigla(rs.getString(3));
					turma.setId(rs.getInt(4));
					turma.setTemaId(rs.getInt(5));
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return turma;
	}
	
	public ArrayList<Turma> carregar(String sigla) {
		String sqlSelect = "SELECT id, semestre_letivo, ano_letivo, sigla, tema_id FROM turma WHERE upper(sigla) LIKE ?";
		ArrayList<Turma> lista = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setString(1, "%" + sigla.toUpperCase() + "%");
			try(ResultSet rs = stm.executeQuery()){
				while(rs.next()) {
					Turma t = new Turma();
					t.setId(rs.getInt(1));
					t.setSemestreLetivo(rs.getInt(2));
					t.setAnoLetivo(rs.getInt(3));
					t.setSigla(rs.getString(4));
					t.setTemaId(rs.getInt(5));
					lista.add(t);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(SQLException e1){
			System.out.println(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<Turma> FindAll() {
		String sqlSelect = "SELECT semestre_letivo, ano_letivo, sigla, id, tema_id from turma";
		ArrayList<Turma> lista = new ArrayList<Turma>();
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			
			try(ResultSet rs = stm.executeQuery()){
				while(rs.next()) {
					Turma turma = new Turma();
					turma.setSemestreLetivo(rs.getInt(1));
					turma.setAnoLetivo(rs.getInt(2));
					turma.setSigla(rs.getString(3));
					turma.setId(rs.getInt(4));
					turma.setTemaId(5);
					lista.add(turma);
				}
			}catch(Exception e) {
				e.printStackTrace();
			}
		}catch(SQLException e1) {
			System.out.println(e1.getStackTrace());
		}
		return lista;
	}
}