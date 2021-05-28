package model;

import java.util.Date;
public class Tema {
	private int id;
	private Date dt_cadastro;
	private String introducao;
	private String requisitos;
	private String titulo;
	
	public Tema() {
		
	}
	
	public Tema(int id) {
		this.id = id;
	}
	public Tema(int id, Date dt_cadastro, String introducao, String requisitos, String titulo) {
		this.id = id;
		this.dt_cadastro = dt_cadastro;
		this.introducao = introducao;
		this.requisitos = requisitos;
		this.titulo = titulo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDt_cadastro() {
		return dt_cadastro;
	}

	public void setDt_cadastro(Date dt_cadastro) {
		this.dt_cadastro = dt_cadastro;
	}

	public String getIntroducao() {
		return introducao;
	}

	public void setIntroducao(String introducao) {
		this.introducao = introducao;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


}
