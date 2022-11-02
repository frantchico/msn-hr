package nosi.webapps.gestao_de_compras.dao;

import javax.persistence.Entity;
import javax.persistence.CascadeType;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.ForeignKey;
import nosi.base.ActiveRecord.BaseActiveRecord;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Size;
import java.util.List;
import javax.persistence.ManyToOne;

/**
 * @author: Nositeste 19-10-2022
*/

@Entity
@Table(name = "tbl_purchase", schema = "public")
@NamedQuery(name = "TblPurchase.findAll", query = "SELECT t FROM TblPurchase t")
public class TblPurchase extends BaseActiveRecord<TblPurchase> {

	private static final long serialVersionUID = 1L;

	// Change Integer type to BigDecimal if the number is very large!

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
 	private Integer id;
	@ManyToOne
	@JoinColumn(name = "id_product", foreignKey = @ForeignKey(name = "product_fk"))
	private TblProduct idProduct;
	@ManyToOne
	@JoinColumn(name = "id_store", foreignKey = @ForeignKey(name = "store_fk"))
	private TblStore idStore;
	@Column(name = "quantity")
	private Integer quantity;
	@Column(name = "id_user")
	private Integer idUser;
	@Column(name = "price")
	private Integer price;
	@Size(max = 255)
	@Column(name = "id_process")
	private String idProcess;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "idStore")
	private List<TblPurchase> tblpurchaseList;

	public Integer getId() { 
		return this.id;
	}

	public void setId(Integer id) {
		 this.id = id;
	}

	public TblProduct getIdProduct() { 
		return this.idProduct;
	}

	public void setIdProduct(TblProduct idProduct) {
		 this.idProduct = idProduct;
	}

	public TblStore getIdStore() { 
		return this.idStore;
	}

	public void setIdStore(TblStore idStore) {
		 this.idStore = idStore;
	}

	public Integer getQuantity() { 
		return this.quantity;
	}

	public void setQuantity(Integer quantity) {
		 this.quantity = quantity;
	}

	public Integer getIdUser() { 
		return this.idUser;
	}

	public void setIdUser(Integer idUser) {
		 this.idUser = idUser;
	}

	public Integer getPrice() { 
		return this.price;
	}

	public void setPrice(Integer price) {
		 this.price = price;
	}

	public String getIdProcess() { 
		return this.idProcess;
	}

	public void setIdProcess(String idProcess) {
		 this.idProcess = idProcess;
	}

	@XmlTransient
	public List<TblPurchase> gettblpurchaseList() {
		return tblpurchaseList;
	}
	public void settblpurchaseList(List<TblPurchase> tblpurchaseList) {
		this.tblpurchaseList = tblpurchaseList;
	}

}