package nosi.webapps.gestao_de_compras.pages.produtoslist;

import nosi.core.webapp.Controller;//
import nosi.core.webapp.databse.helpers.ResultSet;//
import nosi.core.webapp.databse.helpers.QueryInterface;//
import java.io.IOException;//
import nosi.core.webapp.Core;//
import nosi.core.webapp.Response;//
/* Start-Code-Block (import) */
import java.util.ArrayList; //block import
import java.util.List; //block import
import nosi.webapps.gestao_de_compras.dao.TblProduct; //block import
/* End-Code-Block */
/*----#start-code(packages_import)----*/


/*----#end-code----*/
		
public class ProdutosListController extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		ProdutosList model = new ProdutosList();
		model.load();
		ProdutosListView view = new ProdutosListView();
		view.id.setParam(true);
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		model.loadTable_1(Core.query(null,"SELECT '../images/IGRP/IGRP2.3/assets/img/jon_doe.jpg' as foto,'Stract mollit magna elit ipsum aperiam lorem adipiscing mollit sed elit doloremque officia laudantium totam' as produto,'Officia totam sed sit voluptatem' as referencia,'Deserunt dolor aliqua ipsum laudantium' as registado_por,'hidden-f128_17d6' as id,'hidden-0561_961d' as id_user "));
		  ----#gen-example */
		/* Start-Code-Block (index) */
	try{
		TblProduct tblproductfilter = new TblProduct().find();
	List<TblProduct> tblproductList = tblproductfilter.orderByAsc("description").all();
	List<ProdutosList.Table_1> tblproductTable = new ArrayList<>();
	if(Core.isNotNull(tblproductList)){
		for(TblProduct tblproduct : tblproductList){
			ProdutosList.Table_1 row  = new ProdutosList.Table_1();
			row.setFoto(Core.getLinkFileByUuid(tblproduct.getIdFile()));
			row.setProduto(tblproduct.getDescription());
			row.setReferencia(tblproduct.getReference());
			row.setRegistado_por(Core.getUsernameById(tblproduct.getIdUser()).toString());
			row.setId(tblproduct.getId());
			row.setId_user(tblproduct.getIdUser());
	
	this.addQueryString("p_id", Core.getParam("p_id"));
	
	this.addQueryString("isEdit", "true");
			tblproductTable.add(row);
		}
		model.setTable_1(tblproductTable);
	}
	}catch(Exception e){
		e.printStackTrace();
	}/* End-Code-Block (index) */
		/*----#start-code(index)----*/
		
		
		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	
	public Response actionAdicionar_produto() throws IOException, IllegalArgumentException, IllegalAccessException{
		ProdutosList model = new ProdutosList();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  this.addQueryString("p_id",Core.getParam("p_id"));
		  return this.forward("gestao_de_compras","ProdutoForm","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (adicionar_produto)  *//* End-Code-Block  */
		/*----#start-code(adicionar_produto)----*/
		
		
		/*----#end-code----*/
		return this.redirect("gestao_de_compras","ProdutoForm","index", this.queryString());	
	}
	
	public Response actionFiltar() throws IOException, IllegalArgumentException, IllegalAccessException{
		ProdutosList model = new ProdutosList();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  this.addQueryString("p_id",Core.getParam("p_id"));
		  return this.forward("gestao_de_compras","ProdutosList","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (filtar)  */
	return this.forward("gestao_de_compras","ProdutosList","index",this.queryString());/* End-Code-Block  */
		/*----#start-code(filtar)----*/
		
		
		/*----#end-code----*/
			
	}
	
	public Response actionEditar() throws IOException, IllegalArgumentException, IllegalAccessException{
		ProdutosList model = new ProdutosList();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  this.addQueryString("p_id",Core.getParam("p_id"));
		  return this.forward("gestao_de_compras","ProdutoForm","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (editar)  */
	this.addQueryString("p_id", Core.getParam("p_id"));
	
	this.addQueryString("isEdit", "true");/* End-Code-Block  */
		/*----#start-code(editar)----*/
		
		
		/*----#end-code----*/
		return this.redirect("gestao_de_compras","ProdutoForm","index", this.queryString());	
	}
	
	public Response actionEliminar() throws IOException, IllegalArgumentException, IllegalAccessException{
		ProdutosList model = new ProdutosList();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  this.addQueryString("p_id",Core.getParam("p_id"));
		  return this.forward("gestao_de_compras","ProdutosList","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (eliminar)  *//* End-Code-Block  */
		/*----#start-code(eliminar)----*/
		
		
		/*----#end-code----*/
		return this.redirect("gestao_de_compras","ProdutosList","index", this.queryString());	
	}
	/* Start-Code-Block (custom-actions)  *//* End-Code-Block  */
/*----#start-code(custom_actions)----*/


/*----#end-code----*/
}
