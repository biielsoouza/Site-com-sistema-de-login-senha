package br.com.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties
({"hibernateLazyInitializer", "handler"})

@Entity
@Table(name="ESTOQUE")
public class Estoque{

	
	@Id
	@Column(name="CODPRODUTO")
	private int cod;
	@Column(name="NOMEPROD")
	private String nome;
	@Column(name="QUANTIDADE")
	private int qnt;
	@Column(name="VALOR")
	private int valor;
	@Column(name="VALIDADEPDT")
	private String vali;
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQnt() {
		return qnt;
	}
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public String getVali() {
		return vali;
	}
	public void setVali(String vali) {
		this.vali = vali;
	}
	




}
