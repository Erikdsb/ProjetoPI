package model;

import java.io.Serializable;

/*
 * @author Gustavo Silva
 * */

import java.util.ArrayList;
public class Turma implements Serializable{

	private static final long serialVersionUID = 1L;
	//atributos
	private ArrayList<Aluno> alunos;
	private int id;
	private int semestreLetivo;
	private int anoLetivo;
	private String sigla;
	private int temaId;
	
	//construtores
	public Turma() {
		
	}
	
	public Turma(ArrayList<Aluno> alunos, int id, int semestreLetivo, int anoLetivo, String sigla, int temaId) {
		super();
		this.alunos = alunos;
		this.id = id;
		this.semestreLetivo = semestreLetivo;
		this.anoLetivo = anoLetivo;
		this.sigla = sigla;
		this.temaId = temaId;
	}
	
	public Turma(int id) {
		this.id = id;
	}


	//getters e setters
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}

	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSemestreLetivo() {
		return semestreLetivo;
	}

	public void setSemestreLetivo(int semestreLetivo) {
		this.semestreLetivo = semestreLetivo;
	}

	public int getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(int anoLetivo) {
		this.anoLetivo = anoLetivo;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public int getTemaId() {
		return temaId;
	}

	public void setTemaId(int temaId) {
		this.temaId = temaId;
	}
	
	
}
