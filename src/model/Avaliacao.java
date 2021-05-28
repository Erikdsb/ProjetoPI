package model;

//NAO MEXER A MENOS QUE SAIBA O QUE ESTA FAZENDO - CARMELO E JAPA
import java.util.ArrayList;
import java.util.Date;

public class Avaliacao {
	private int id;
	private ArrayList<Turma> turma;
	private ArrayList<Aluno> aluno;
	private double nota;
	private Date data;
	private String comentarios;
	private Entrega entrega;
	
public Avaliacao(int id, ArrayList<Turma> turma, ArrayList<Aluno> aluno, double nota, Date data, String comentarios, Entrega entrega) {
	this.id = id;
	this.turma = turma; 
	this.aluno = aluno;
	this.nota = nota;
	this.data = data;
	this.comentarios = comentarios;
	this.entrega = entrega;
}
	public Avaliacao(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Turma> getTurma() {
		return turma;
	}
	public void setTurma(ArrayList<Turma> turma) {
		this.turma = turma;
	}
	public ArrayList<Aluno> getAluno() {
		return aluno;
	}
	public void setAluno(ArrayList<Aluno> aluno) {
		this.aluno = aluno;
	}
	public double getNota() {
		return nota;
	}
	public void setNota(double nota) {
		this.nota = nota;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getComentarios() {
		return comentarios;
	}
	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}
	
	public Entrega getEntrega() {
		return entrega;
	}
	public void setEntrega(Entrega entrega) {
		this.entrega = entrega;
	}
 
	

}