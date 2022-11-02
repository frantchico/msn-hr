package nosi.webapps.gestao_de_compras.pages.requisicao;

import nosi.core.webapp.Controller;//
import nosi.core.webapp.databse.helpers.ResultSet;//
import nosi.core.webapp.databse.helpers.QueryInterface;//
import java.io.IOException;//
import nosi.core.webapp.Core;//
import nosi.core.webapp.Response;//
/* Start-Code-Block (import) */
/* End-Code-Block */
/*----#start-code(packages_import)----*/
import java.util.List; //block import
import java.util.LinkedHashMap; //block import
import static nosi.core.i18n.Translator.gt; //block import
import nosi.webapps.gestao_de_compras.dao.TblStore; //block import
import nosi.webapps.gestao_de_compras.dao.TblProduct; //block import
/*----#end-code----*/
		
public class RequisicaoController extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		Requisicao model = new Requisicao();
		model.load();
		RequisicaoView view = new RequisicaoView();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		model.loadSeparatorlist_1(Core.query(null,"SELECT '2' as produto,'191' as preco_unitario,'135' as quantidade,'88' as sub_total "));
		view.loja.setQuery(Core.query(null,"SELECT 'id' as ID,'name' as NAME "));
		view.produto.setQuery(Core.query(null,"SELECT 'id' as ID,'name' as NAME "));
		  ----#gen-example */
		/* Start-Code-Block (index) *//* End-Code-Block (index) */
		/*----#start-code(index)----*/
		

		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	/* Start-Code-Block (custom-actions)  *//* End-Code-Block  */
/*----#start-code(custom_actions)----*/
	public Response actionCarregarPreco() throws IOException, IllegalArgumentException, IllegalAccessException {
		Integer id_produto = Core.getParamInt("p_produto");
		nosi.core.webapp.helpers.RemoteXML remoteXml = Core.remoteXml();

		TblProduct p = new TblProduct().findOne(id_produto);

		remoteXml.addPropertie("preco_unitario", p.getUnitPrice().toString());

		String xml = remoteXml.build();
		this.format = Response.FORMAT_XML;
		return this.renderView(xml);
	}

	/*----#end-code----*/
}
