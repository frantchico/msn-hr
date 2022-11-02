package nosi.webapps.gestao_de_compras.dao;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.validation.constraints.Size;
import nosi.base.ActiveRecord.BaseActiveRecord;
import javax.persistence.GenerationType;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author: Nositeste 19-10-2022
*/

@Entity
@Table(name = "tbl_store", schema = "public")
@NamedQuery(name = "TblStore.findAll", query = "SELECT t FROM TblStore t")
public class TblStore extends BaseActiveRecord<TblStore> {

	private static final long serialVersionUID = 1L;

	// Change Integer type to BigDecimal if the number is very large!

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
 	private Integer id;
	@Size(max = 255)
	@Column(name = "description")
	private String description;
	@Size(max = 255)
	@Column(name = "location")
	private String location;
	@Column(name = "id_user")
	private Integer idUser;

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

	public String getLocation() { 
		return this.location;
	}

	public void setLocation(String location) {
		 this.location = location;
	}

	public Integer getIdUser() { 
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		 this.idUser = idUser;
	}

}