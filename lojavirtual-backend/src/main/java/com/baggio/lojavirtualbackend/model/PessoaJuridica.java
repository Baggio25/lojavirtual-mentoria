package com.baggio.lojavirtualbackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa_juridica")
@PrimaryKeyJoinColumn( name = "id")
public class PessoaJuridica extends Pessoa{

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String cnpj;
	
	@Column(name = "inscricao_estadual")
	private String inscricaoEstadual;
	
	@Column(name = "inscricao_municipal")
	private String inscricaoMunicipal;
	
	@Column(nullable = false, name = "nome_fantasia")	
	private String nomeFantasia;
	
	@Column(nullable = false, name = "razao_social")
	private String razaoSocial;
	
	private String categoria;
	
	public PessoaJuridica(Long id, String nome, String email, String telefone, String cnpj, String inscricaoEstadual,
			String inscricaoMunicipal, String nomeFantasia, String razaoSocial, String categoria) {
		super(id, nome, email, telefone);
		this.cnpj = cnpj;
		this.inscricaoEstadual = inscricaoEstadual;
		this.inscricaoMunicipal = inscricaoMunicipal;
		this.nomeFantasia = nomeFantasia;
		this.razaoSocial = razaoSocial;
		this.categoria = categoria;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}

	public String getInscricaoMunicipal() {
		return inscricaoMunicipal;
	}

	public void setInscricaoMunicipal(String inscricaoMunicipal) {
		this.inscricaoMunicipal = inscricaoMunicipal;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
