package service;

//import java.util.ArrayList;
import java.util.ArrayList;

import dao.TurmaDAO;
import model.Turma;

public class TurmaService {
	TurmaDAO dao = new TurmaDAO();

	public int criar(Turma turma) {
		int id = dao.criar(turma);
		return id;
	}
	
	public void atualizar(Turma to) {
		dao.atualizar(to);
	}
	
	public void excluir(Turma to) {
		dao.excluir(to);
	}
	
	public Turma carregar(int id) {
		Turma to = dao.carregar(id);
		return to;
	}
	
	public ArrayList<Turma> carregar(String sigla) {
		ArrayList<Turma> lista = dao.carregar(sigla);
		return lista;
	}	
	public ArrayList<Turma> findAll() {
		ArrayList<Turma> lista = dao.FindAll();
		return lista;
	}
}
