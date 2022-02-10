package com.baggio.lojavirtualbackend.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
@SequenceGenerator(name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1)
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_produto")
	private Long id;

	@Column(name = "tipo_unidade", nullable = false)
	private String tipoUnidade;

	@Column(nullable = false)
	private String nome;

	@Column(columnDefinition = "TEXT", length = 2000, nullable = false)
	private String descricao;

	@Column(nullable = false)
	private Double peso;

	@Column(nullable = false)
	private Double largura;

	@Column(nullable = false)
	private Double altura;

	@Column(nullable = false)
	private Double profundidade;

	@Column(name = "valor_venda", nullable = false)
	private BigDecimal valorVenda = BigDecimal.ZERO;

	@Column(name = "quantidade_estoque", nullable = false)
	private Integer quantidadeEstoque = 0;

	@Column(name = "quantidade_alerta_estoque", nullable = false)
	private Integer quantidadeAlertaEstoque = 0;

	@Column(name = "link_youtube")
	private String linkYoutube;

	@Column(name = "alerta_quantidade_estoque")
	private Boolean alertaQuantidadeEstoque = Boolean.FALSE;

	@Column(name = "quantidade_clique")
	private Integer quantidadeClique = 0;
	
	private Boolean ativo = Boolean.TRUE;

	@ManyToOne(targetEntity = MarcaProduto.class)
	@JoinColumn(name = "marca_produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "marca_produto_fk"))
	private MarcaProduto marcaProduto;

	@ManyToOne(targetEntity = MarcaProduto.class)
	@JoinColumn(name = "categoria_produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "categoria_produto_fk"))
	private CategoriaProduto categoriaProduto;

	public Produto() {
	}

	public Produto(Long id, String tipoUnidade, String nome, String descricao, Double peso, Double largura,
			Double altura, Double profundidade, BigDecimal valorVenda, Integer quantidadeEstoque,
			Integer quantidadeAlertaEstoque, String linkYoutube, Boolean alertaQuantidadeEstoque,
			Integer quantidadeClique, Boolean ativo,  MarcaProduto marcaProduto, CategoriaProduto categoriaProduto) {
		this.id = id;
		this.tipoUnidade = tipoUnidade;
		this.nome = nome;
		this.descricao = descricao;
		this.peso = peso;
		this.largura = largura;
		this.altura = altura;
		this.profundidade = profundidade;
		this.valorVenda = valorVenda;
		this.quantidadeEstoque = quantidadeEstoque;
		this.quantidadeAlertaEstoque = quantidadeAlertaEstoque;
		this.linkYoutube = linkYoutube;
		this.alertaQuantidadeEstoque = alertaQuantidadeEstoque;
		this.quantidadeClique = quantidadeClique;
		this.ativo = ativo;
		this.marcaProduto = marcaProduto;
		this.categoriaProduto = categoriaProduto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoUnidade() {
		return tipoUnidade;
	}

	public void setTipoUnidade(String tipoUnidade) {
		this.tipoUnidade = tipoUnidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Integer getQuantidadeAlertaEstoque() {
		return quantidadeAlertaEstoque;
	}

	public void setQuantidadeAlertaEstoque(Integer quantidadeAlertaEstoque) {
		this.quantidadeAlertaEstoque = quantidadeAlertaEstoque;
	}

	public String getLinkYoutube() {
		return linkYoutube;
	}

	public void setLinkYoutube(String linkYoutube) {
		this.linkYoutube = linkYoutube;
	}

	public Boolean getAlertaQuantidadeEstoque() {
		return alertaQuantidadeEstoque;
	}

	public void setAlertaQuantidadeEstoque(Boolean alertaQuantidadeEstoque) {
		this.alertaQuantidadeEstoque = alertaQuantidadeEstoque;
	}

	public Integer getQuantidadeClique() {
		return quantidadeClique;
	}

	public void setQuantidadeClique(Integer quantidadeClique) {
		this.quantidadeClique = quantidadeClique;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public MarcaProduto getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(MarcaProduto marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	public CategoriaProduto getCategoriaProduto() {
		return categoriaProduto;
	}

	public void setCategoriaProduto(CategoriaProduto categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

}
