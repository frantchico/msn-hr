package nosi.webapps.gestao_de_recursos_humanos.dao;

import javax.persistence.ForeignKey;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.validation.constraints.NotBlank;
import javax.persistence.JoinColumn;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import javax.persistence.NamedQuery;
import javax.persistence.ManyToOne;
import nosi.base.ActiveRecord.BaseActiveRecord;
import java.math.BigDecimal;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

/**
 * @author: Nositeste 17-09-2022
*/

@Entity
@Table(name = "t_employees", schema = "public")
@NamedQuery(name = "TEmployees.findAll", query = "SELECT t FROM TEmployees t")
public class TEmployees extends BaseActiveRecord<TEmployees> {

	private static final long serialVersionUID = 1L;

	// Change Integer type to BigDecimal if the number is very large!

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id", nullable = false, updatable = false)
 	private Integer employeeId;
	@Size(max = 20)
	@Column(name = "first_name")
	private String firstName;
	@NotBlank
	@Size(min = 1, max = 25)
	@Column(name = "last_name")
	private String lastName;
	

	@NotBlank
	@Size(min = 1, max = 100)
	@Column(name = "email")
	private String email;
	@Size(max = 20)
	@Column(name = "phone_number")
	private String phoneNumber;
	@NotNull
	@Column(name = "hire_date")
	private LocalDate hireDate;
	@NotNull
	@ManyToOne
	@JoinColumn(name = "job_id", foreignKey = @ForeignKey(name = "t_employees_job_id_fkey"), referencedColumnName="job_id")
	private TJobs jobId;
	@NotNull
	@Column(name = "salary")
	private BigDecimal salary;
	@Column(name = "manager_id")
	private Integer managerId;
	@ManyToOne
	@JoinColumn(name = "department_id", foreignKey = @ForeignKey(name = "t_employees_department_id_fkey"), referencedColumnName="department_id")
	private TDepartments departmentId;
	@Column(name = "status")
	private String status;
	@Column(name = "id_photo")
	private String idPhoto;
	
	public String getIdPhoto() {
		return idPhoto;
	}

	public void setIdPhoto(String idPhoto) {
		this.idPhoto = idPhoto;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getEmployeeId() { 
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		 this.employeeId = employeeId;
	}

	public String getFirstName() { 
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		 this.firstName = firstName;
	}

	public String getLastName() { 
		return this.lastName;
	}

	public void setLastName(String lastName) {
		 this.lastName = lastName;
	}

	public String getEmail() { 
		return this.email;
	}

	public void setEmail(String email) {
		 this.email = email;
	}

	public String getPhoneNumber() { 
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		 this.phoneNumber = phoneNumber;
	}

	public LocalDate getHireDate() { 
		return this.hireDate;
	}

	public void setHireDate(LocalDate hireDate) {
		 this.hireDate = hireDate;
	}

	public TJobs getJobId() { 
		return this.jobId;
	}

	public void setJobId(TJobs jobId) {
		 this.jobId = jobId;
	}

	public BigDecimal getSalary() { 
		return this.salary;
	}

	public void setSalary(BigDecimal salary) {
		 this.salary = salary;
	}

	public Integer getManagerId() { 
		return this.managerId;
	}

	public void setManagerId(Integer managerId) {
		 this.managerId = managerId;
	}

	public TDepartments getDepartmentId() { 
		return this.departmentId;
	}

	public void setDepartmentId(TDepartments departmentId) {
		 this.departmentId = departmentId;
	}

}