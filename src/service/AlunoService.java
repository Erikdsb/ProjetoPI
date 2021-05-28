package service;

import java.sql.SQLException;

import dao.AlunoDAO;
import model.Aluno;

public class AlunoService {

 	AlunoDAO dao;		
	
	public AlunoService() {
		dao = new AlunoDAO();
	}
	
	public void criar(Aluno to) {
		dao.criar(to);
	}
	
	public void atualizar(Aluno to) {
		dao.atualizar(to);
	}
	
	public void excluir(Aluno to) {
		dao.excluir(to);
	}
	
	public Aluno carregar(int id) throws SQLException {
		Aluno to = dao.carregar(id);
	return to;
	}
}

