package model;

import java.util.ArrayList;
//NAO MEXER A MENOS QUE SAIBA O QUE ESTA FAZENDO - CARMELO E JAPA
import java.util.Date;

public class Banca{
	private int id;
	private Date dt_cadastro;
	private String sala;
	private ArrayList<Grupo> grupos;
	
	public Banca() {
		
	}
	public Banca(ArrayList<Grupo> grupos, int id, Date dt_cadastro, String sala) {
		super();
		this.grupos = grupos;
		this.id = id;
		this.dt_cadastro = dt_cadastro;
		this.sala = sala;
	}
	public Banca(int id) {
		this.id = id;
	}
	
	//getters e setters	
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
	public String getSala() {
		return sala;
	}
	public void setSala(String sala) {
		this.sala = sala;
	}
	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}
	public void setGrupos(ArrayList<Grupo> grupos) {
		this.grupos = grupos;
	}
	
}