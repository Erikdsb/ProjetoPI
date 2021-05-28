package service;

import java.util.ArrayList;

import dao.TemaDAO;
import model.Tema;

public class TemaService {

	TemaDAO dao;
			
	public TemaService() {
		dao = new TemaDAO();
	}
	
	public int criar(Tema to) {
		int id = dao.insert(to);
		return id;
	}
	
	public void atualizar(Tema to) {
		dao.atualizar(to);
	}
	
	public void excluir(Tema to) {
		dao.excluir(to);
	}
	
	public Tema carregar(int id){
		Tema to =  dao.carregar(id);
		return to;
	}
	public ArrayList<Tema> carregar(String titulo){
		ArrayList<Tema> lista = dao.carregar(titulo);
		return lista;
	}
	public ArrayList<Tema> findAll(){
		ArrayList<Tema> lista = dao.findAll();
		return lista;
	}

}


