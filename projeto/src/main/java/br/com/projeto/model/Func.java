package br.com.projeto.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties
({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="FUNCIONARIO")


public class Func {
		@Id
		@Column(name="CODFUNC")
		private int codfunc;
		@Column(name="NOME")
		private String nome;
		@Column(name="DATA_NASC")
		private String data;
		@Column(name="SALARIO")
		private int salario;
		@Column(name="CARGO")
		private String cargo;
		@Column(name="CPF")
		private int cpf;
		public int getCodfunc() {
			return codfunc;
		}
		public void setCodfunc(int codfunc) {
			this.codfunc = codfunc;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getData() {
			return data;
		}
		public void setData(String data) {
			this.data = data;
		}
		public int getSalario() {
			return salario;
		}
		public void setSalario(int salario) {
			this.salario = salario;
		}
		public String getCargo() {
			return cargo;
		}
		public void setCargo(String cargo) {
			this.cargo = cargo;
		}
		public int getCpf() {
			return cpf;
		}
		public void setCpf(int cpf) {
			this.cpf = cpf;
		}

		


}

