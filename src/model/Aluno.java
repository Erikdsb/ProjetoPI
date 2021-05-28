package model;



public class Aluno extends Usuario{
	//atributos
	private int id;
	private String ra;
	
	//construtores
	public Aluno() {
		
	}
	
	public Aluno(int id) {
		this.id = id;
	}
	
	public Aluno(int id, String nome, String email, String senha, int id2, String ra) {
		super(id, nome, email, senha);
		this.id = id2;
		this.ra = ra;
	}

	
	//getters e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}
	
}
