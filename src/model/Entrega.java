package model;

import java.util.Date;

public class Entrega {
	private int id;
	private Date dt_cadastro;
	private Grupo grupo;
	private Atividade atividade;
	
	public Entrega(int id){
		this.id = id;
	}
	public Entrega() {
		
	}
	public Entrega(int id, Date dt_cadastro, Grupo grupo, Atividade atividade) {
		this.id = id;
		this.dt_cadastro = dt_cadastro;
		this.grupo = grupo;
		this.atividade = atividade;
		
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
	public Grupo getGrupo() {
		return grupo;
	}
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	public Atividade getAtividade() {
		return atividade;
	}
	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}
}
