package nosi.webapps.gestao_de_recursos_humanos.pages.lista_de_empregados;

import nosi.core.webapp.Controller;//
import nosi.core.webapp.databse.helpers.ResultSet;//
import nosi.core.webapp.databse.helpers.QueryInterface;//
import java.io.IOException;//
import nosi.core.webapp.Core;//
import nosi.core.webapp.Response;//
/* Start-Code-Block (import) */
/* End-Code-Block */
/*----#start-code(packages_import)----*/
import java.util.ArrayList; //block import
import java.util.List; //block import
import java.util.List; //block import
import java.util.LinkedHashMap; //block import
import static nosi.core.i18n.Translator.gt; //block import
import nosi.webapps.gestao_de_recursos_humanos.dao.TDepartments; //block import
import nosi.webapps.gestao_de_recursos_humanos.dao.TJobs; //block import
import nosi.webapps.gestao_de_recursos_humanos.dao.TEmployees; //block import
/*----#end-code----*/
		
public class Lista_de_empregadosController extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		Lista_de_empregados model = new Lista_de_empregados();
		model.load();
		Lista_de_empregadosView view = new Lista_de_empregadosView();
		view.id.setParam(true);
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		model.loadTable_1(Core.query(null,"SELECT 'Sit accusantium ut sed deserun' as departamento,'Mollit ut unde rem anim' as funcao,'Omnis adipiscing omnis sed des' as nome,'Mollit elit aperiam sit stract' as apelido,'Sit rem voluptatem deserunt om' as email,'14' as salario,'/IGRP-Template/images/IGRP/IGRP2.3/app/gestao_de_recursos_humanos/lista_de_empregados/Lista_de_empregados.xml' as ver_foto,'hidden-0d18_ac41' as id "));
		view.departamento_id.setQuery(Core.query(null,"SELECT 'id' as ID,'name' as NAME "));
		view.funcao_id.setQuery(Core.query(null,"SELECT 'id' as ID,'name' as NAME "));
		  ----#gen-example */
		/* Start-Code-Block (index) *//* End-Code-Block (index) */
		/*----#start-code(index)----*/
		try {
			TDepartments tdepartmentsfilter = new TDepartments().find();
			List<TDepartments> tdepartmentsList = tdepartmentsfilter.all();
			LinkedHashMap<String, String> departamento_id = new LinkedHashMap<>();
			departamento_id.put(null, gt("-- Selecionar --"));
			for (TDepartments tdepartments : tdepartmentsList) {
				departamento_id.put(tdepartments.getDepartmentId().toString(), gt(tdepartments.getDepartmentName()));
			}
			view.departamento_id.setValue(departamento_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			TJobs tjobsfilter = new TJobs().find();
			List<TJobs> tjobsList = tjobsfilter.all();
			LinkedHashMap<String, String> funcao_id = new LinkedHashMap<>();
			funcao_id.put(null, gt("-- Selecionar --"));
			for (TJobs tjobs : tjobsList) {
				funcao_id.put(tjobs.getJobId().toString(), gt(tjobs.getJobTitle()));
			}
			view.funcao_id.setValue(funcao_id);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			TEmployees temployeesfilter = new TEmployees().find();
			if (Core.isNotNullOrZero(model.getDepartamento_id())) {
				temployeesfilter.andWhere("departmentId.departmentId", "=", Core.toInt(model.getDepartamento_id()));
			}
			List<TEmployees> temployeesList = temployeesfilter.orderByAsc("firstName").all();
			List<Lista_de_empregados.Table_1> temployeesTable = new ArrayList<>();
			if (Core.isNotNull(temployeesList)) {
				for (TEmployees temployees : temployeesList) {
					Lista_de_empregados.Table_1 row = new Lista_de_empregados.Table_1();
					row.setDepartamento(temployees.getDepartmentId().getDepartmentName());
					row.setFuncao(temployees.getJobId().getJobTitle());
					row.setNome(temployees.getFirstName());
					row.setApelido(temployees.getLastName());
					row.setEmail(temployees.getEmail());
					row.setSalario(temployees.getSalary());
					row.setId(temployees.getEmployeeId().toString());
					if( Core.isNotNullOrZero(temployees.getIdPhoto()))
						row.setVer_foto(Core.getLinkFileByUuid(temployees.getIdPhoto()));
					
					temployeesTable.add(row);
				}
				model.setTable_1(temployeesTable);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	
	public Response actionNovo() throws IOException, IllegalArgumentException, IllegalAccessException{
		Lista_de_empregados model = new Lista_de_empregados();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  this.addQueryString("p_id",Core.getParam("p_id"));
		  return this.forward("gestao_de_recursos_humanos","Funcionario","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (novo)  *//* End-Code-Block  */
		/*----#start-code(novo)----*/

		/*----#end-code----*/
		return this.redirect("gestao_de_recursos_humanos","Funcionario","index", this.queryString());	
	}
	
	public Response actionFiltrar() throws IOException, IllegalArgumentException, IllegalAccessException{
		Lista_de_empregados model = new Lista_de_empregados();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  this.addQueryString("p_id",Core.getParam("p_id"));
		  return this.forward("gestao_de_recursos_humanos","Lista_de_empregados","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (filtrar)  *//* End-Code-Block  */
		/*----#start-code(filtrar)----*/
		return this.forward("gestao_de_recursos_humanos", "Lista_de_empregados", "index", this.queryString());

		/*----#end-code----*/
			
	}
	
	public Response actionEditar() throws IOException, IllegalArgumentException, IllegalAccessException{
		Lista_de_empregados model = new Lista_de_empregados();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  this.addQueryString("p_id",Core.getParam("p_id"));
		  return this.forward("gestao_de_recursos_humanos","Funcionario","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (editar)  *//* End-Code-Block  */
		/*----#start-code(editar)----*/

		this.addQueryString("p_id", Core.getParam("p_id"));

		this.addQueryString("isEdit", "true");
		/*----#end-code----*/
		return this.redirect("gestao_de_recursos_humanos","Funcionario","index", this.queryString());	
	}
	
	public Response actionEliminar() throws IOException, IllegalArgumentException, IllegalAccessException{
		Lista_de_empregados model = new Lista_de_empregados();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  this.addQueryString("p_id",Core.getParam("p_id"));
		  return this.forward("gestao_de_recursos_humanos","Lista_de_empregados","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (eliminar)  *//* End-Code-Block  */
		/*----#start-code(eliminar)----*/
		try {
			TEmployees temployees = new TEmployees().findOne(Core.getParamInt("p_id"));
			if (temployees != null && !temployees.hasError()) {
				temployees.setStatus("R");
				temployees.update();
				Core.setMessageSuccess();
			} else
				Core.setMessageError();
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*----#end-code----*/
		return this.redirect("gestao_de_recursos_humanos","Lista_de_empregados","index", this.queryString());	
	}
	
	public Response actionDeclaracao_vencimento() throws IOException, IllegalArgumentException, IllegalAccessException{
		Lista_de_empregados model = new Lista_de_empregados();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  this.addQueryString("p_id",Core.getParam("p_id"));
		  return this.forward("gestao_de_recursos_humanos","Lista_de_empregados","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (declaracao_vencimento)  *//* End-Code-Block  */
		/*----#start-code(declaracao_vencimento)----*/
		// Core.getLinkReport("dec_venc").addParam("employee_id","?");
		// or Response=> Core.getLinkReport("dec_venc",new nosi.core.webapp.Report().addParam("employee_id","?"));
		// or Beta PDF report - Response=> Core.getLinkReportPDF("dec_venc",new nosi.core.webapp.Report().addParam("employee_id","?"));
		return Core.getLinkReportPDF("declaracao",
				new nosi.core.webapp.Report().addParam("employee_id", Core.getParamInt("p_id")));
		/*----#end-code----*/
			
	}
	/* Start-Code-Block (custom-actions)  *//* End-Code-Block  */
/*----#start-code(custom_actions)----*/

	/*----#end-code----*/
}
