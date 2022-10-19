package nosi.webapps.gestao_de_recursos_humanos.dao;

import javax.persistence.ForeignKey;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import java.util.List;
import javax.persistence.NamedQuery;
import javax.persistence.ManyToOne;
import nosi.base.ActiveRecord.BaseActiveRecord;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.GenerationType;

/**
 * @author: Nositeste 17-09-2022
*/

@Entity
@Table(name = "t_departments", schema = "public")
@NamedQuery(name = "TDepartments.findAll", query = "SELECT t FROM TDepartments t")
public class TDepartments extends BaseActiveRecord<TDepartments> {

	private static final long serialVersionUID = 1L;

	// Change Integer type to BigDecimal if the number is very large!

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "department_id", nullable = false, updatable = false)
 	private Integer departmentId;
	@NotBlank
	@Size(min = 1, max = 30)
	@Column(name = "department_name")
	private String departmentName;
	@ManyToOne
	@JoinColumn(name = "location_id", foreignKey = @ForeignKey(name = "t_departments_location_id_fkey"), referencedColumnName="location_id")
	private TLocations locationId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "locationId")
	private List<TDepartments> tdepartmentsList;

	public Integer getDepartmentId() { 
		return this.departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		 this.departmentId = departmentId;
	}

	public String getDepartmentName() { 
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		 this.departmentName = departmentName;
	}

	public TLocations getLocationId() { 
		return this.locationId;
	}

	public void setLocationId(TLocations locationId) {
		 this.locationId = locationId;
	}

	@XmlTransient
	public List<TDepartments> gettdepartmentsList() {
		return tdepartmentsList;
	}
	public void settdepartmentsList(List<TDepartments> tdepartmentsList) {
		this.tdepartmentsList = tdepartmentsList;
	}

}