package br.com.projeto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties
({"hibernateLazyInitializer", "handler"})

@Entity
@Table(name="VENDAS")
public class Vendas{
	
	@Id
	@Column(name="CODVENDA")
	private int cod;
	@Column(name="QUANTIDADE")
	private int qnt;
	@Column(name="DATAVENDA")
	private String datavenda;
	@Column(name="CODPDT")
	private int codpdt;
	@Column(name="VALORTOTAL")
	private String valortotal;
	
	public Vendas()
	{}

	
	public int getCod() {
		return cod;
	}
	public void setCod(int cod) {
		this.cod = cod;
	}
	

	public int getQnt() {
		return qnt;
	}
	public void setQnt(int qnt) {
		this.qnt = qnt;
	}
	public String getDatavenda() {
		return datavenda;
	}
	public void setDatavenda(String datavenda) {
		this.datavenda = datavenda;
	}
	public int getCodpdt() {
		return codpdt;
	}
	public void setCodpdt(int codpdt) {
		this.codpdt = codpdt;
	}
	public String getValortotal() {
		return valortotal;
	}
	public void setValortotal(String valortotal) {
		this.valortotal = valortotal;
	}
}