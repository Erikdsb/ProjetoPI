package service;

import dao.AtividadeDAO;
import model.Atividade;

public class AtividadeService {
	 	AtividadeDAO dao;		
		
		public AtividadeService() {
			dao = new AtividadeDAO();
		}
		
		public void criar(Atividade to) {
			dao.inserir(to);
		}
		
		public void atualizar(Atividade to) {
			dao.atualizar(to);
		}
		
		public void excluir(Atividade to) {
			dao.excluir(to);
		}
		
		public Atividade carregar(int id) {
			Atividade to = dao.carregar(id);
		return to;
		}
	}
