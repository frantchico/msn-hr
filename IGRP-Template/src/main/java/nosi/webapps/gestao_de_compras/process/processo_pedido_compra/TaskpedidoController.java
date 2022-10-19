package nosi.webapps.gestao_de_compras.process.processo_pedido_compra;

import java.io.IOException;//
import java.util.List;//
import nosi.core.webapp.Response;//
import javax.servlet.ServletException;//
import nosi.core.webapp.Core;//
import nosi.core.webapp.databse.helpers.ResultSet;//
import nosi.core.webapp.databse.helpers.QueryInterface;//
import nosi.webapps.igrp.dao.TipoDocumentoEtapa;//
import nosi.core.webapp.bpmn.BPMNTaskController;//
import nosi.webapps.gestao_de_compras.pages.pedido_form.Pedido_form;
import nosi.webapps.gestao_de_compras.pages.pedido_form.Pedido_formView;
/*----#start-code(packages_import)----*/

/*----#end-code----*/



/**
 *demo@nosi.cv
 *05-10-2022
*/

public class TaskpedidoController extends BPMNTaskController {

	public Response actionIndex() throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {
		Pedido_formView view = new Pedido_formView();
		Pedido_form model = new Pedido_form();
		model.load();

		/*----#start-code(index)----*/

		/*----#end-code----*/

		return super.index("gestao_de_compras",model,view,this);
	}

	public Response actionSave() throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {

		/*----#start-code(save)----*/

		/*----#end-code----*/

		return super.save();
	}

	public List<TipoDocumentoEtapa> getInputDocumentType() {
		return super.getInputDocumentType();
	}

	public List<TipoDocumentoEtapa> getOutputDocumentType() {
		return super.getOutputDocumentType();
	}



	/*----#start-code(custom_actions)----*/

	/*----#end-code----*/



}
