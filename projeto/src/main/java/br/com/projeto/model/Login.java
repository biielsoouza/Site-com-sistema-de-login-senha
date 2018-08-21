package br.com.projeto.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LOGIN")
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="CODUSU")
	private int codusu;
	@Column(name="NOMEUSU")
	private String nome;
	@Column(name="SENHAUSU")
	private String senha;
	
	

	public int getCodusu() {
		return codusu;
	}
	public void setCodusu(int codusu) {
		this.codusu = codusu;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

}
