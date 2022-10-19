package nosi.webapps.gestao_de_recursos_humanos.pages.dashboard_2;

import nosi.core.webapp.Controller;//
import nosi.core.webapp.databse.helpers.ResultSet;//
import nosi.core.webapp.databse.helpers.QueryInterface;//
import java.io.IOException;//
import nosi.core.webapp.Core;//
import nosi.core.webapp.Response;//
/* Start-Code-Block (import) */
import java.util.ArrayList; //block import
import java.util.List; //block import
import java.util.stream.Collectors; //block import
import java.util.LongSummaryStatistics; //block import
import nosi.webapps.gestao_de_recursos_humanos.pages.dashboard_2.Dashboard_2.Chart_1; //block import
import java.util.Map; //block import
import java.util.ArrayList; //block import
import java.util.List; //block import
import java.util.stream.Collectors; //block import
import java.util.LongSummaryStatistics; //block import
import nosi.webapps.gestao_de_recursos_humanos.pages.dashboard_2.Dashboard_2.Chart_2; //block import
import java.util.Map; //block import
import java.util.List; //block import
import java.util.stream.Collectors; //block import
import java.util.LongSummaryStatistics; //block import
import java.util.Map; //block import
import nosi.webapps.gestao_de_recursos_humanos.dao.TEmployees; //block import
import nosi.webapps.gestao_de_recursos_humanos.dao.TDepartments; //block import
import nosi.webapps.gestao_de_recursos_humanos.dao.TJobs; //block import
/* End-Code-Block */
/*----#start-code(packages_import)----*/


/*----#end-code----*/
		
public class Dashboard_2Controller extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		Dashboard_2 model = new Dashboard_2();
		model.load();
		model.setStatbox_1_title("Total Funcionários");
		model.setStatbox_1_val("663");
		model.setStatbox_1_txt("Ver Lista");
		model.setStatbox_1_url("http://www.example.com");
		model.setStatbox_1_bg("cp-fresh");
		model.setStatbox_1_icn("fa-users");
		Dashboard_2View view = new Dashboard_2View();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		view.chart_1.loadQuery(Core.query(null,"SELECT 'X1' as EixoX, 'Y1' as EixoY, 15 as EixoZ"
                                      +" UNION SELECT 'X2' as EixoX, 'Y2' as EixoY, 10 as EixoZ"
                                      +" UNION SELECT 'X2' as EixoX, 'Y2' as EixoY, 23 as EixoZ"
                                      +" UNION SELECT 'X3' as EixoX, 'Y3' as EixoY, 40 as EixoZ"));
		view.chart_2.loadQuery(Core.query(null,"SELECT 'X1' as EixoX, 'Y1' as EixoY, 15 as EixoZ"
                                      +" UNION SELECT 'X2' as EixoX, 'Y2' as EixoY, 10 as EixoZ"
                                      +" UNION SELECT 'X2' as EixoX, 'Y2' as EixoY, 23 as EixoZ"
                                      +" UNION SELECT 'X3' as EixoX, 'Y3' as EixoY, 40 as EixoZ"));
		model.setStatbox_1_url(Core.getIGRPLink("your app","your page","your action"));
		  ----#gen-example */
		/* Start-Code-Block (index) */
	try{
	TEmployees temployeesfilter = new TEmployees().find();
	Object value  = temployeesfilter.getCount();
	if(Core.isNotNull(value)){
		model.setStatbox_1_val(String.valueOf(value));
			model.setStatbox_1_url(Core.getIGRPLink("gestao_de_recursos_humanos", "Lista_de_empregados", "index"));
	}
	}catch ( Exception e ) {
		e.printStackTrace();
	}
	
	
	try{
	TEmployees temployeesfilter = new TEmployees().find();
	List<TEmployees> temployeesList  = temployeesfilter.all();
	Map<String, LongSummaryStatistics> value = temployeesList.stream().collect(Collectors.groupingBy(temployees -> temployees.getDepartmentId().getDepartmentName() , Collectors.summarizingLong(temployees -> Core.toLong(temployees.getDepartmentId().getDepartmentName()))));
	if(Core.isNotNull(temployeesList)){
		model.setChart_1(new ArrayList<>());
		temployeesList.stream().forEach(temployees->{
			Chart_1 c = new Chart_1();
			c.setEixoX(temployees.getDepartmentId().getDepartmentName());
	
			c.setEixoY(value.get(temployees.getDepartmentId().getDepartmentName()).getCount());
			model.getChart_1().add(c);
		});
	}
	}catch ( Exception e ) {
		e.printStackTrace();
	}
	
	
	try{
	TEmployees temployeesfilter = new TEmployees().find();
	List<TEmployees> temployeesList  = temployeesfilter.all();
	Map<String, LongSummaryStatistics> value = temployeesList.stream().collect(Collectors.groupingBy(temployees -> temployees.getJobId().getJobTitle() , Collectors.summarizingLong(temployees -> Core.toLong(temployees.getJobId().getJobTitle()))));
	if(Core.isNotNull(temployeesList)){
		model.setChart_2(new ArrayList<>());
		temployeesList.stream().forEach(temployees->{
			Chart_2 c = new Chart_2();
			c.setEixoY(temployees.getJobId().getJobTitle());
	
			c.setEixoZ(value.get(temployees.getJobId().getJobTitle()).getCount());
			model.getChart_2().add(c);
		});
	}
	}catch ( Exception e ) {
		e.printStackTrace();
	}
	/* End-Code-Block (index) */
		/*----#start-code(index)----*/
		
		
		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	/* Start-Code-Block (custom-actions)  *//* End-Code-Block  */
/*----#start-code(custom_actions)----*/


/*----#end-code----*/
}
