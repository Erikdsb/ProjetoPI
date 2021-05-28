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

public class ExcluirTurma implements Command{
	
	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String pId = request.getParameter("id");
		String pSemestre = request.getParameter("semestre");
		String pAno = request.getParameter("ano");
		String pSigla = request.getParameter("sigla");
		int id = -1, semestre = -1, ano = -1;
		try {
        	id = Integer.parseInt(pId);
        }catch(NumberFormatException e) {
        }
        try {
        	semestre = Integer.parseInt(pSemestre);
        	ano = Integer.parseInt(pAno);
        }catch(NumberFormatException e) {
        }
        
        Turma turma = new Turma();
        turma.setId(id);
        turma.setSemestreLetivo(semestre);
        turma.setAnoLetivo(ano);
        turma.setSigla(pSigla);
        TurmaService ts = new TurmaService();
        
        RequestDispatcher view = null;
        HttpSession session = request.getSession();
        
        ts.excluir(turma);
        @SuppressWarnings("unchecked")
		ArrayList<Turma> lista = (ArrayList<Turma>) session.getAttribute("lista");
		lista.remove(busca(turma, lista));
		session.setAttribute("lista", lista);
		view = request.getRequestDispatcher("ListarTurma.jsp");
		view.forward(request, response);
	}
	
	public int busca(Turma turma, ArrayList<Turma> lista) {
		Turma to;
		for (int i = 0; i < lista.size(); i++) {
			to = lista.get(i);
			if (to.getId() == turma.getId()) {
				return i;
			}
		}
		return -1;
	}
}
