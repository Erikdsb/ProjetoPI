package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Atividade;
import model.Tema;
import service.ConnectionFactory;

public class AtividadeDAO {
	public void inserir(Atividade atividade) {
		String sqlInsert = "INSERT INTO atividade(tema_id, numero, descricao)";
		Tema t = new Tema();
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlInsert);){
			t = atividade.getTema().get(0);
			
			stm.setInt(1, t.getId());
			stm.setInt(2, atividade.getNumero());
			stm.setString(3, atividade.getDescricao());
			stm.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}//fim inserir()
	
	public void excluir(Atividade atividade) {
		String sqlDelete = "DELETE FROM atividade WHERE id = ?";
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlDelete);){
			stm.setInt(1, atividade.getId());
			stm.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}//fim excluir()
	
	public void atualizar(Atividade atividade) {
		String sqlUpdate = "UPDATE atividade SET numero = ?, descricao = ?, formato_entrega = ?, dt_inicio =  ?, dt_fim = ?";
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlUpdate);){
			
			stm.setInt(1, atividade.getNumero());
			stm.setString(2, atividade.getDescricao());
			stm.setString(3, atividade.getFormato_entrega());
			stm.setDate(4, (Date) atividade.getDt_inicio());
			stm.setDate(5, (Date) atividade.getDt_fim());
			stm.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}//fim atualizar()
	
	public Atividade carregar(int id) {
		String sqlSelect = "SELECT id, tema_id, numero, descricao, formato_entrega, dt_inicio, dt_fim FROM atividade WHERE id = ?";
		ArrayList<Tema> temas = new ArrayList<Tema>();
		Atividade atividade = new Atividade(id);
		
		try(Connection conn = ConnectionFactory.obtemConexao();
				PreparedStatement stm = conn.prepareStatement(sqlSelect);){
			stm.setInt(1, atividade.getId());
			try(ResultSet rs = stm.executeQuery();){
				if(rs.next()) {
					Tema t = new Tema();
					atividade.setId(rs.getInt(1));
					
					t.setId(rs.getInt(2));
					temas.add(t);
					atividade.setTema(temas);
					
					atividade.setNumero(rs.getInt(3));
					atividade.setDescricao(rs.getString(4));
					atividade.setFormato_entrega(rs.getString(5));
					atividade.setDt_inicio(rs.getDate(6));
					atividade.setDt_fim(rs.getDate(7));
				}
			}catch(Exception e1) {
				e1.printStackTrace();
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return atividade;
	}//fim carregar()
}
