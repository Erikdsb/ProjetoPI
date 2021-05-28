package model;


public class Professor extends Usuario{
	//atributos
	private int id;
	private int administrador;
	private String matricula;
	
	
	//construtores
	public Professor() {
		
	}
	
	public Professor(int id) {
		this.id = id;
	}
	
	public Professor(int id, String nome, String email, String senha, int id2, int administrador, String matricula) {
		super(id, nome, email, senha);
		id = id2;
		this.administrador = administrador;
		this.matricula = matricula;
	}


	//getters e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAdministrador() {
		return administrador;
	}

	public void setAdministrador(int administrador) {
		this.administrador = administrador;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
}
