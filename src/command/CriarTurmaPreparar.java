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

public class CriarTurmaPreparar implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		TemaService ts = new TemaService();
		ArrayList<Tema> lista = new ArrayList<>();
		lista = ts.findAll();
		HttpSession session = request.getSession();
		session.setAttribute("lista", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("CriarTurma.jsp");
		dispatcher.forward(request, response);

	}

}
