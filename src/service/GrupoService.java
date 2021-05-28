package service;

import dao.GrupoDAO;
import model.Grupo;

public class GrupoService {
	GrupoDAO dao;
	
	public GrupoService() {
		dao = new GrupoDAO();
	}
	
	public void criar(Grupo to) {
		dao.inserir(to);
	}
	
	public void atualizar(Grupo to) {
		dao.atualizar(to);
	}
	
	public void excluir(Grupo to) {
		dao.excluir(to);
	}
		
	public Grupo carregar(int id) {
		Grupo to = dao.carregar(id);
	return to;
	}
}

