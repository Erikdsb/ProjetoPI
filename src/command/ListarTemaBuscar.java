package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Tema;
import service.TemaService;

public class ListarTemaBuscar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String titulo = request.getParameter("data[search]");
		TemaService ts = new TemaService();
		ArrayList<Tema> lista = null;
		HttpSession session = request.getSession();
		
		if(titulo != null && titulo.length() > 0) {
			lista = ts.carregar(titulo);
		}else {
			lista = ts.findAll();
		}
		session.setAttribute("lista", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarTema.jsp");
		dispatcher.forward(request, response);

	}
}
