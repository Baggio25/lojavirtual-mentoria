package com.baggio.lojavirtualbackend.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "cupom_desconto")
@SequenceGenerator(name = "seq_cupom_desconto", sequenceName = "seq_cupom_desconto", allocationSize = 1, initialValue = 1)
public class CupomDesconto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_cupom_desconto")
	private Long id;

	@Column(name = "codigo_desconto", nullable = false)
	private String codigoDesconto;

	@Column(name = "valor_real_desconto", nullable = false)
	private BigDecimal valorRealDesconto;

	@Column(name = "valor_percentual_desconto", nullable = false)
	private BigDecimal valorPercentualDesconto;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_validade_cupom", nullable = false)
	private Date dataValidadeCupom;

	public CupomDesconto() {
	}

	public CupomDesconto(Long id, String codigoDesconto, BigDecimal valorRealDesconto,
			BigDecimal valorPercentualDesconto, Date dataValidadeCupom) {
		this.id = id;
		this.codigoDesconto = codigoDesconto;
		this.valorRealDesconto = valorRealDesconto;
		this.valorPercentualDesconto = valorPercentualDesconto;
		this.dataValidadeCupom = dataValidadeCupom;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCodigoDesconto() {
		return codigoDesconto;
	}

	public void setCodigoDesconto(String codigoDesconto) {
		this.codigoDesconto = codigoDesconto;
	}

	public BigDecimal getValorRealDesconto() {
		return valorRealDesconto;
	}

	public void setValorRealDesconto(BigDecimal valorRealDesconto) {
		this.valorRealDesconto = valorRealDesconto;
	}

	public BigDecimal getValorPercentualDesconto() {
		return valorPercentualDesconto;
	}

	public void setValorPercentualDesconto(BigDecimal valorPercentualDesconto) {
		this.valorPercentualDesconto = valorPercentualDesconto;
	}

	public Date getDataValidadeCupom() {
		return dataValidadeCupom;
	}

	public void setDataValidadeCupom(Date dataValidadeCupom) {
		this.dataValidadeCupom = dataValidadeCupom;
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
		CupomDesconto other = (CupomDesconto) obj;
		return Objects.equals(id, other.id);
	}

}
