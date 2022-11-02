package nosi.webapps.gestao_de_compras.pages.lojaslist;

import nosi.core.webapp.Controller;//
import nosi.core.webapp.databse.helpers.ResultSet;//
import nosi.core.webapp.databse.helpers.QueryInterface;//
import java.io.IOException;//
import nosi.core.webapp.Core;//
import nosi.core.webapp.Response;//
/* Start-Code-Block (import) */
import java.util.ArrayList; //block import
import java.util.List; //block import
import nosi.webapps.gestao_de_compras.dao.TblStore; //block import
/* End-Code-Block */
/*----#start-code(packages_import)----*/


/*----#end-code----*/
		
public class LojasListController extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		LojasList model = new LojasList();
		model.load();
		LojasListView view = new LojasListView();
		view.id.setParam(true);
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		model.loadTable_1(Core.query(null,"SELECT 'Deserunt perspiciatis lorem amet natus' as nome,'Lorem aliqua adipiscing doloremque magna' as localizacao,'Omnis perspiciatis lorem magna accusantium' as registado_por,'hidden-18d6_87cd' as id "));
		  ----#gen-example */
		/* Start-Code-Block (index) */
	try{
		TblStore tblstorefilter = new TblStore().find();
	List<TblStore> tblstoreList = tblstorefilter.orderByAsc("description").all();
	List<LojasList.Table_1> tblstoreTable = new ArrayList<>();
	if(Core.isNotNull(tblstoreList)){
		for(TblStore tblstore : tblstoreList){
			LojasList.Table_1 row  = new LojasList.Table_1();
			row.setNome(tblstore.getDescription());
			row.setLocalizacao(tblstore.getLocation());
			row.setRegistado_por(Core.getUsernameById(tblstore.getIdUser()).toString());
			row.setId(tblstore.getId());
	
	view.btn_editar.addParameter("isEdit", "true");
			tblstoreTable.add(row);
		}
		model.setTable_1(tblstoreTable);
	}
	}catch(Exception e){
		e.printStackTrace();
	}/* End-Code-Block (index) */
		/*----#start-code(index)----*/
		
		
		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	
	public Response actionAdicionr_loja() throws IOException, IllegalArgumentException, IllegalAccessException{
		LojasList model = new LojasList();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  this.addQueryString("p_id",Core.getParam("p_id"));
		  return this.forward("gestao_de_compras","LojaForm","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (adicionr_loja)  *//* End-Code-Block  */
		/*----#start-code(adicionr_loja)----*/
		
		
		/*----#end-code----*/
		return this.redirect("gestao_de_compras","LojaForm","index", this.queryString());	
	}
	
	public Response actionFiltrar() throws IOException, IllegalArgumentException, IllegalAccessException{
		LojasList model = new LojasList();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  this.addQueryString("p_id",Core.getParam("p_id"));
		  return this.forward("gestao_de_compras","LojasList","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (filtrar)  */
	return this.forward("gestao_de_compras","LojasList","index",this.queryString());/* End-Code-Block  */
		/*----#start-code(filtrar)----*/
		
		
		/*----#end-code----*/
			
	}
	
	public Response actionEditar() throws IOException, IllegalArgumentException, IllegalAccessException{
		LojasList model = new LojasList();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  this.addQueryString("p_id",Core.getParam("p_id"));
		  return this.forward("gestao_de_compras","LojaForm","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (editar)  */
	this.addQueryString("p_id", Core.getParam("p_id"));
	
	this.addQueryString("isEdit", "true");/* End-Code-Block  */
		/*----#start-code(editar)----*/
		
		
		/*----#end-code----*/
		return this.redirect("gestao_de_compras","LojaForm","index", this.queryString());	
	}
	
	public Response actionEliminar() throws IOException, IllegalArgumentException, IllegalAccessException{
		LojasList model = new LojasList();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  this.addQueryString("p_id",Core.getParam("p_id"));
		  return this.forward("gestao_de_compras","LojasList","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (eliminar)  *//* End-Code-Block  */
		/*----#start-code(eliminar)----*/
		
		
		/*----#end-code----*/
		return this.redirect("gestao_de_compras","LojasList","index", this.queryString());	
	}
	/* Start-Code-Block (custom-actions)  *//* End-Code-Block  */
/*----#start-code(custom_actions)----*/


/*----#end-code----*/
}
