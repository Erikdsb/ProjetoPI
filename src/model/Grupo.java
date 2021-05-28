package model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Grupo {
	//atributos
	private int id;
	private int numero;
	private String nome;
	private Professor professor;
	
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	//construtores
	public Grupo() {
		
	}
	
	public Grupo(int id, int numero, String nome, Professor professor) {
		super();
		this.id = id;
		this.numero = numero;
		this.nome = nome;
		this.professor = professor;
	}
	
	public Grupo(int id) {
		this.id = id;
	}
	
	//getters e setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
	//toString
	@Override
	public String toString() {
		return "Grupo [id=" + id + ", numero=" + numero + ", nome=" + nome + "]";
	}
	
	//metodos de conexao com o BD/persistencia
	public Connection obtemConexao() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost/Aula02?user=alunos&password=alunos");
	}// fim obtemConexao()
	
	
	
}
