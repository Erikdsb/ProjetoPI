package service;

import dao.AvaliacaoDAO;
import model.Avaliacao;

public class AvaliacaoService {
	 	AvaliacaoDAO dao;		
		
		public AvaliacaoService() {
			dao = new AvaliacaoDAO();
		}
		
		public void criar(Avaliacao to) {
			dao.inserir(to);
		}
		
		public void atualizar(Avaliacao to) {
			dao.atualizar(to);
		}
		
		public void excluir(Avaliacao to) {
			dao.excluir(to);
		}
		
		public Avaliacao carregar(int id) {
			Avaliacao to = dao.carregar(id);
		return to;
		}
	}
