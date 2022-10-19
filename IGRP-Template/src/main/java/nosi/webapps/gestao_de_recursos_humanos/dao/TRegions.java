package nosi.webapps.gestao_de_recursos_humanos.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.NamedQuery;
import nosi.base.ActiveRecord.BaseActiveRecord;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GenerationType;

/**
 * @author: Nositeste 17-09-2022
*/

@Entity
@Table(name = "t_regions", schema = "public")
@NamedQuery(name = "TRegions.findAll", query = "SELECT t FROM TRegions t")
public class TRegions extends BaseActiveRecord<TRegions> {

	private static final long serialVersionUID = 1L;

	// Change Integer type to BigDecimal if the number is very large!

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "region_id", nullable = false, updatable = false)
 	private Integer regionId;
	@Size(max = 25)
	@Column(name = "region_name")
	private String regionName;

	public Integer getRegionId() { 
		return this.regionId;
	}

	public void setRegionId(Integer regionId) {
		 this.regionId = regionId;
	}

	public String getRegionName() { 
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		 this.regionName = regionName;
	}

}