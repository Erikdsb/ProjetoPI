package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Turma;
import service.TurmaService;

public class VisualizarTurma implements Command{
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
        
        turma = ts.carregar(turma.getId());
        request.setAttribute("turma", turma);
        view = request.getRequestDispatcher("VisualizarTurma.jsp");
        
        view.forward(request, response);
        
	}
}
