package nosi.webapps.gestao_de_recursos_humanos.dao;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import nosi.base.ActiveRecord.BaseActiveRecord;

/**
 * frant
 * 29/09/2022
 */
@Entity
@Table(name = "t_vacations", schema = "public")
@NamedQuery(name = "TVacations.findAll", query = "SELECT t FROM TVacations t")
public class TVacationsAlt extends BaseActiveRecord<TVacationsAlt> {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, updatable = false)
	private Integer id;
	
	@Column(name = "employee_id")
	@NotNull
	//@ManyToOne()
	@JoinColumn(name = "employee_id", referencedColumnName = "employee_id", foreignKey = @ForeignKey(name = "t_vacations_employees_id_fkey"))
	private TEmployees employeeId;
	
	@Column(name = "request_date")
	private LocalDateTime requestDate;
	@Column(name = "request_user_id")
	private Integer requestUserId;
	@Column(name = "proposition_date")
	private LocalDate propositionDate;
	@Column(name = "num_of_days")
	private Integer numOfDays;
	@Column(name = "status")
	private String status;
	@Column(name = "analises_user_id")
	private Integer analisesUserId;
	@Column(name = "analises_date")
	private LocalDateTime analisesDate;
	@Column(name = "analises_obs")
	private String analisesObs;
	@Column(name = "authorization_user_id")
	private Integer authorizationUserId;
	@Column(name = "authorization_date")
	private LocalDateTime authorizationDate;
	@Column(name = "authorization_obs")
	private String authorizationObs;
	@Column(name = "start_date")
	private LocalDate startDate;
	@Column(name = "end_date")
	private LocalDate endDate;
	@Column(name = "cancel_date")
	private LocalDate cancelDate;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(LocalDateTime requestDate) {
		this.requestDate = requestDate;
	}
	public Integer getRequestUserId() {
		return requestUserId;
	}
	public void setRequestUserId(Integer requestUserId) {
		this.requestUserId = requestUserId;
	}
	public LocalDate getPropositionDate() {
		return propositionDate;
	}
	public void setPropositionDate(LocalDate propositionDate) {
		this.propositionDate = propositionDate;
	}
	public Integer getNumOfDays() {
		return numOfDays;
	}
	public void setNumOfDays(Integer numOfDays) {
		this.numOfDays = numOfDays;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Integer getAnalisesUserId() {
		return analisesUserId;
	}
	public void setAnalisesUserId(Integer analisesUserId) {
		this.analisesUserId = analisesUserId;
	}
	public LocalDateTime getAnalisesDate() {
		return analisesDate;
	}
	public void setAnalisesDate(LocalDateTime analisesDate) {
		this.analisesDate = analisesDate;
	}
	public String getAnalisesObs() {
		return analisesObs;
	}
	public void setAnalisesObs(String analisesObs) {
		this.analisesObs = analisesObs;
	}
	public Integer getAuthorizationUserId() {
		return authorizationUserId;
	}
	public void setAuthorizationUserId(Integer authorizationUserId) {
		this.authorizationUserId = authorizationUserId;
	}
	public LocalDateTime getAuthorizationDate() {
		return authorizationDate;
	}
	public void setAuthorizationDate(LocalDateTime authorizationDate) {
		this.authorizationDate = authorizationDate;
	}
	public String getAuthorizationObs() {
		return authorizationObs;
	}
	public void setAuthorizationObs(String authorizationObs) {
		this.authorizationObs = authorizationObs;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public LocalDate getCancelDate() {
		return cancelDate;
	}
	public void setCancelDate(LocalDate cancelDate) {
		this.cancelDate = cancelDate;
	}
	public TEmployees getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(TEmployees employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
