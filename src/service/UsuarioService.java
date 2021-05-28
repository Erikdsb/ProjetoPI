package service;

import dao.UsuarioDAO;
import model.Usuario;

public class UsuarioService {
	UsuarioDAO dao;
	
	public UsuarioService() {
		dao = new UsuarioDAO();
	}
	public void criar(Usuario to) {
		dao.incluir(to);
	}
	public void atualizar(Usuario to) {
		dao.atualizar(to);
	}
	public void excluir(Usuario to) {
		dao.excluir(to);
	}
	public Usuario carregar(int id) {
		Usuario to = dao.carregar(id);
		return to;
	}
	
	public Usuario carregar(String email) {
		Usuario to = dao.carregar(email);
		return to;
	}
}