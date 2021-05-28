package command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Turma;
import service.TurmaService;

public class ListarTurmaBuscar implements Command{
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String sigla = request.getParameter("data[search]");
		TurmaService ts = new TurmaService();
		ArrayList<Turma> lista = null;
		HttpSession session = request.getSession();
		
		if(sigla != null && sigla.length()>0) {
			lista = ts.carregar(sigla);
		}else {
			lista = ts.findAll();
		}
		session.setAttribute("lista", lista);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("ListarTurma.jsp");
		dispatcher.forward(request, response);
	}
}
