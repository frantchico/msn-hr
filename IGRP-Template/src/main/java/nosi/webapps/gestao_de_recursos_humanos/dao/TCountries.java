package nosi.webapps.gestao_de_recursos_humanos.dao;

import javax.persistence.ForeignKey;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import java.util.List;
import javax.persistence.NamedQuery;
import javax.persistence.ManyToOne;
import nosi.base.ActiveRecord.BaseActiveRecord;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 * @author: Nositeste 17-09-2022
*/

@Entity
@Table(name = "t_countries", schema = "public")
@NamedQuery(name = "TCountries.findAll", query = "SELECT t FROM TCountries t")
public class TCountries extends BaseActiveRecord<TCountries> {

	private static final long serialVersionUID = 1L;

	// Change Integer type to BigDecimal if the number is very large!

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id", nullable = false, updatable = false)
 	private String countryId;
	@Size(max = 40)
	@Column(name = "country_name")
	private String countryName;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "region_id", foreignKey = @ForeignKey(name = "t_countries_region_id_fkey"), referencedColumnName="region_id")
	private TRegions regionId;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "regionId")
	private List<TCountries> tcountriesList;

	public String getCountryId() { 
		return this.countryId;
	}

	public void setCountryId(String countryId) {
		 this.countryId = countryId;
	}

	public String getCountryName() { 
		return this.countryName;
	}

	public void setCountryName(String countryName) {
		 this.countryName = countryName;
	}

	public TRegions getRegionId() { 
		return this.regionId;
	}

	public void setRegionId(TRegions regionId) {
		 this.regionId = regionId;
	}

	@XmlTransient
	public List<TCountries> gettcountriesList() {
		return tcountriesList;
	}
	public void settcountriesList(List<TCountries> tcountriesList) {
		this.tcountriesList = tcountriesList;
	}

}