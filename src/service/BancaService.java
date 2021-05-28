package service;

import dao.BancaDAO;
import model.Banca;

public class BancaService {
	 	BancaDAO dao;		
		
		public BancaService() {
			dao = new BancaDAO();
		}
		
		public void criar(Banca to) {
			dao.insert(to);
		}
		
		public void atualizar(Banca to) {
			dao.atualizar(to);
		}
		
		public void excluir(Banca to) {
			dao.excluir(to);
		}
		
		public Banca carregar(int id) {
			Banca to = dao.carregar(id);
		return to;
		}
	}
