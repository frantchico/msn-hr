package nosi.webapps.gestao_de_recursos_humanos.dao;

import javax.validation.constraints.NotNull;
import nosi.base.ActiveRecord.BaseActiveRecord;
import javax.persistence.Column;
import java.time.LocalDateTime;
import java.time.LocalDate;
import javax.validation.constraints.Size;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.NamedQuery;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

/**
 * @author: Nositeste 30-09-2022
*/

@Entity
@Table(name = "t_vacations", schema = "public")
@NamedQuery(name = "TVacations.findAll", query = "SELECT t FROM TVacations t")
public class TVacations extends BaseActiveRecord<TVacations> {

	private static final long serialVersionUID = 1L;

	// Change Integer type to BigDecimal if the number is very large!

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
 	private Integer id;
	@Column(name = "analises_date")
	private LocalDateTime analisesDate;
	@Size(max = 255)
	@Column(name = "analises_obs")
	private String analisesObs;
	@Column(name = "analises_user_id")
	private Integer analisesUserId;
	@Column(name = "authorization_date")
	private LocalDateTime authorizationDate;
	@Size(max = 255)
	@Column(name = "authorization_obs")
	private String authorizationObs;
	@Column(name = "authorization_user_id")
	private Integer authorizationUserId;
	@Column(name = "cancel_date")
	private LocalDate cancelDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	@Column(name = "num_of_days")
	private Integer numOfDays;
	@Column(name = "proposition_date")
	private LocalDate propositionDate;
	@Column(name = "request_date")
	private LocalDateTime requestDate;
	@Column(name = "request_user_id")
	private Integer requestUserId;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Size(max = 255)
	@Column(name = "status")
	private String status;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "employee_id", foreignKey = @ForeignKey(name = "t_vacations_fk"), referencedColumnName="employee_id")
	private TEmployees employeeId;

	public Integer getId() { 
		return this.id;
	}

	public void setId(Integer id) {
		 this.id = id;
	}

	public LocalDateTime getAnalisesDate() { 
		return this.analisesDate;
	}

	public void setAnalisesDate(LocalDateTime analisesDate) {
		 this.analisesDate = analisesDate;
	}

	public String getAnalisesObs() { 
		return this.analisesObs;
	}

	public void setAnalisesObs(String analisesObs) {
		 this.analisesObs = analisesObs;
	}

	public Integer getAnalisesUserId() { 
		return this.analisesUserId;
	}

	public void setAnalisesUserId(Integer analisesUserId) {
		 this.analisesUserId = analisesUserId;
	}

	public LocalDateTime getAuthorizationDate() { 
		return this.authorizationDate;
	}

	public void setAuthorizationDate(LocalDateTime authorizationDate) {
		 this.authorizationDate = authorizationDate;
	}

	public String getAuthorizationObs() { 
		return this.authorizationObs;
	}

	public void setAuthorizationObs(String authorizationObs) {
		 this.authorizationObs = authorizationObs;
	}

	public Integer getAuthorizationUserId() { 
		return this.authorizationUserId;
	}

	public void setAuthorizationUserId(Integer authorizationUserId) {
		 this.authorizationUserId = authorizationUserId;
	}

	public LocalDate getCancelDate() { 
		return this.cancelDate;
	}

	public void setCancelDate(LocalDate cancelDate) {
		 this.cancelDate = cancelDate;
	}

	public LocalDate getEndDate() { 
		return this.endDate;
	}

	public void setEndDate(LocalDate endDate) {
		 this.endDate = endDate;
	}

	public Integer getNumOfDays() { 
		return this.numOfDays;
	}

	public void setNumOfDays(Integer numOfDays) {
		 this.numOfDays = numOfDays;
	}

	public LocalDate getPropositionDate() { 
		return this.propositionDate;
	}

	public void setPropositionDate(LocalDate propositionDate) {
		 this.propositionDate = propositionDate;
	}

	public LocalDateTime getRequestDate() { 
		return this.requestDate;
	}

	public void setRequestDate(LocalDateTime requestDate) {
		 this.requestDate = requestDate;
	}

	public Integer getRequestUserId() { 
		return this.requestUserId;
	}

	public void setRequestUserId(Integer requestUserId) {
		 this.requestUserId = requestUserId;
	}

	public LocalDate getStartDate() { 
		return this.startDate;
	}

	public void setStartDate(LocalDate startDate) {
		 this.startDate = startDate;
	}

	public String getStatus() { 
		return this.status;
	}

	public void setStatus(String status) {
		 this.status = status;
	}

	public TEmployees getEmployeeId() { 
		return this.employeeId;
	}

	public void setEmployeeId(TEmployees employeeId) {
		 this.employeeId = employeeId;
	}

}