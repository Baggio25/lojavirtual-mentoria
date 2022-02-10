package com.baggio.lojavirtualbackend.model;

import java.io.Serializable;
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
@Table(name = "item_venda_loja_virtual")
@SequenceGenerator(name = "seq_item_venda_loja_virtual", sequenceName = "seq_item_venda_loja_virtual", allocationSize = 1, initialValue = 1)
public class ItemVendaLojaVirtual implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_item_venda_loja_virtual")
	private Long id;

	@Column(nullable = false)
	private Double quantidade;

	@ManyToOne
	@JoinColumn(name = "venda_loja_virtual_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "venda_loja_virtual_fk"))
	private VendaLojaVirtual vendaLojaVirtual;

	@ManyToOne(targetEntity = Produto.class)
	@JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "produto_fk"))
	private Produto produto;

	public ItemVendaLojaVirtual() {
	}

	public ItemVendaLojaVirtual(Long id, Double quantidade, VendaLojaVirtual vendaLojaVirtual, Produto produto) {
		this.id = id;
		this.quantidade = quantidade;
		this.vendaLojaVirtual = vendaLojaVirtual;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public VendaLojaVirtual getVendaLojaVirtual() {
		return vendaLojaVirtual;
	}

	public void setVendaLojaVirtual(VendaLojaVirtual vendaLojaVirtual) {
		this.vendaLojaVirtual = vendaLojaVirtual;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
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
		ItemVendaLojaVirtual other = (ItemVendaLojaVirtual) obj;
		return Objects.equals(id, other.id);
	}

}
