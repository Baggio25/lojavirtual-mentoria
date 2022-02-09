package com.baggio.lojavirtualbackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "pessoa_fisica")
@PrimaryKeyJoinColumn( name = "id")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento")
	private Date dataNascimento;
	
	public PessoaFisica(Long id, String nome, String email, String telefone, String cpf, Date dataNascimento) {
		super(id, nome, email, telefone);
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
