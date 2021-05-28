package command;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Tema;
import service.TemaService;

public class CriarTema implements Command {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pId = request.getParameter("id");
		String pTitulo = request.getParameter("titulo");
		String pDtCadastro = request.getParameter("dt_cadastro");
		String pIntroducao = request.getParameter("introducao");
		String pRequisitos = request.getParameter("requisitos");
		int id = -1;
		Date dt_cadastro = null;
		//converter ID
		try {
			id = Integer.parseInt(pId);
		}catch(NumberFormatException e) {
		}
		//converter a data
		try {
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			dt_cadastro = (Date) formato.parse(pDtCadastro);
		}catch(Exception e1) {
		}
		
		Tema tema = new Tema();
		tema.setId(id);
		tema.setTitulo(pTitulo);
		tema.setDt_cadastro(dt_cadastro);
		tema.setIntroducao(pIntroducao);
		tema.setRequisitos(pRequisitos);
		TemaService ts = new TemaService();
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ts.criar(tema);
		ArrayList<Tema> lista = new ArrayList<>();
		lista.add(tema);
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarTema.jsp");
		view.forward(request, response);

	}

}
