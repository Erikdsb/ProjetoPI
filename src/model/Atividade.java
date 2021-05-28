package model;

import java.util.ArrayList;
import java.util.Date;

	public class Atividade {
		private int id;
		private ArrayList<Tema> tema;
		private int numero;
		private String descricao;
		private String formato_entrega;
		private Date dt_inicio;
		private Date dt_fim;
		
	public Atividade(int id) {
		this.id = id;
	}
	public Atividade() {
		
	}
	public Atividade(int id, ArrayList<Tema> tema, int numero, String descricao, String formato_entrega, Date dt_inicio, Date dt_fim) {
		this.id = id;
		this.tema = tema;
		this.numero = numero;
		this.descricao = descricao;
		this.formato_entrega = formato_entrega;
		this.dt_inicio = dt_inicio;
		this.dt_fim = dt_fim;
		
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Tema> getTema() {
		return tema;
	}
	public void setTema(ArrayList<Tema> tema) {
		this.tema = tema;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getFormato_entrega() {
		return formato_entrega;
	}
	public void setFormato_entrega(String formato_entrega) {
		this.formato_entrega = formato_entrega;
	}
	public Date getDt_inicio() {
		return dt_inicio;
	}
	public void setDt_inicio(Date dt_inicio) {
		this.dt_inicio = dt_inicio;
	}
	public Date getDt_fim() {
		return dt_fim;
	}
	public void setDt_fim(Date dt_fim) {
		this.dt_fim = dt_fim;
	}
	
}
