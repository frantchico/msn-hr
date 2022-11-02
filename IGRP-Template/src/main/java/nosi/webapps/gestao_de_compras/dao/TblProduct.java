package nosi.webapps.gestao_de_compras.dao;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import nosi.base.ActiveRecord.BaseActiveRecord;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author: Nositeste 19-10-2022
*/

@Entity
@Table(name = "tbl_product", schema = "public")
@NamedQuery(name = "TblProduct.findAll", query = "SELECT t FROM TblProduct t")
//@XmlRootElement
//@XmlAccessorType(XmlAccessType.FIELD)
public class TblProduct extends BaseActiveRecord<TblProduct> {

	private static final long serialVersionUID = 1L;

	// Change Integer type to BigDecimal if the number is very large!

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	//@XmlElement
 	private Integer id;
	@Size(max = 255)	
	@Column(name = "description")
	//@XmlElement
	private String description;
	@Size(max = 255)
	@Column(name = "reference")
	//@XmlElement
	private String reference;
	@Column(name = "id_user")
	//@XmlElement
	private Integer idUser;
	@Size(max = 255)
	@Column(name = "id_file")
	//@XmlElement
	private String idFile;
	
	@Column(name = "unit_price")
	//@XmlElement
	private BigDecimal unitPrice;
	

	public Integer getId() { 
		return this.id;
	}

	public void setId(Integer id) {
		 this.id = id;
	}

	public String getDescription() { 
		return this.description;
	}

	public void setDescription(String description) {
		 this.description = description;
	}

	public String getReference() { 
		return this.reference;
	}

	public void setReference(String reference) {
		 this.reference = reference;
	}

	public Integer getIdUser() { 
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		 this.idUser = idUser;
	}

	public String getIdFile() { 
		return this.idFile;
	}

	public void setIdFile(String idFile) {
		 this.idFile = idFile;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

}