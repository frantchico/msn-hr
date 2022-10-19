package nosi.webapps.gestao_de_recursos_humanos.pages.dashboard;

import nosi.core.webapp.Controller;//
import nosi.core.webapp.databse.helpers.ResultSet;//
import nosi.core.webapp.databse.helpers.QueryInterface;//
import java.io.IOException;//
import nosi.core.webapp.Core;//
import nosi.core.webapp.Response;//
/* Start-Code-Block (import) */
import java.util.ArrayList; //block import
import java.util.List; //block import
import java.util.List; //block import
import java.util.LinkedHashMap; //block import
import static nosi.core.i18n.Translator.gt; //block import
import nosi.webapps.gestao_de_recursos_humanos.dao.TDepartments; //block import
import nosi.webapps.gestao_de_recursos_humanos.dao.TJobs; //block import
import nosi.webapps.gestao_de_recursos_humanos.dao.TEmployees; //block import
import java.time.LocalDate; //block import
/* End-Code-Block */
/*----#start-code(packages_import)----*/


/*----#end-code----*/
		
public class DashboardController extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		Dashboard model = new Dashboard();
		model.load();
		DashboardView view = new DashboardView();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		view.departamento_id.setQuery(Core.query(null,"SELECT 'id' as ID,'name' as NAME "));
		view.funcao_id.setQuery(Core.query(null,"SELECT 'id' as ID,'name' as NAME "));
		  ----#gen-example */
		/* Start-Code-Block (index) */
	try{
	TDepartments tdepartmentsfilter = new TDepartments().find();
	List<TDepartments> tdepartmentsList = tdepartmentsfilter.all();
	LinkedHashMap<String, String> departamento_id = new LinkedHashMap<>();
	departamento_id.put(null, gt("-- Selecionar --"));
	for(TDepartments tdepartments : tdepartmentsList){
		departamento_id.put(tdepartments.getDepartmentId().toString(), gt(tdepartments.getDepartmentName()));
	}
	view.departamento_id.setValue(departamento_id);
	}catch ( Exception e ) {
		e.printStackTrace();
	}
	
	try{
	TJobs tjobsfilter = new TJobs().find();
	List<TJobs> tjobsList = tjobsfilter.all();
	LinkedHashMap<String, String> funcao_id = new LinkedHashMap<>();
	funcao_id.put(null, gt("-- Selecionar --"));
	for(TJobs tjobs : tjobsList){
		funcao_id.put(tjobs.getJobId().toString(), gt(tjobs.getJobTitle()));
	}
	view.funcao_id.setValue(funcao_id);
	}catch ( Exception e ) {
		e.printStackTrace();
	}
	
	try{
		TEmployees temployeesfilter = new TEmployees().find();
	if(Core.isNotNullOrZero(model.getDepartamento_id())){
		temployeesfilter.andWhere("departmentId.departmentId","=",Core.toInt(model.getDepartamento_id()));
	}
	List<TEmployees> temployeesList = temployeesfilter.orderByDesc("hireDate").all();
	List<Dashboard.Timeline_1> temployeesTable = new ArrayList<>();
	if(Core.isNotNull(temployeesList)){
		for(TEmployees temployees : temployeesList){
			Dashboard.Timeline_1 row  = new Dashboard.Timeline_1();
			row.setTimeline_1_icon("fa-check");
			row.setTimeline_1_hd(temployees.getDepartmentId().getDepartmentName());
			row.setTimeline_1_date(Core.convertLocalDateToString(temployees.getHireDate(), Core.DD_MM_YYYY));
			row.setTimeline_1_text(temployees.getFirstName().concat(" ").concat(temployees.getLastName()));
			row.setTimeline_1_btn(Core.getIGRPLink("gestao_de_recursos_humanos", "Funcionario", "index"));
			//row.setTimeline_1_btn_desc("Ver Detalhes");
			temployeesTable.add(row);
		}
		model.setTimeline_1(temployeesTable);
	}
	}catch(Exception e){
		e.printStackTrace();
	}/* End-Code-Block (index) */
		/*----#start-code(index)----*/
		
		
		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	
	public Response actionFiltrar() throws IOException, IllegalArgumentException, IllegalAccessException{
		Dashboard model = new Dashboard();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  return this.forward("gestao_de_recursos_humanos","Lista_de_empregados","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (filtrar)  */
	return this.forward("gestao_de_recursos_humanos","Dashboard","index",this.queryString());/* End-Code-Block  */
		/*----#start-code(filtrar)----*/
		
		
		/*----#end-code----*/
			
	}
	/* Start-Code-Block (custom-actions)  *//* End-Code-Block  */
/*----#start-code(custom_actions)----*/


/*----#end-code----*/
}
