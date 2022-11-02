package nosi.webapps.gestao_de_compras.process.purchases;

import java.io.IOException;//
import java.util.List;//
import nosi.core.webapp.Response;//
import javax.servlet.ServletException;//
import nosi.core.webapp.Core;//
import nosi.core.webapp.databse.helpers.ResultSet;//
import nosi.core.webapp.databse.helpers.QueryInterface;//
import nosi.webapps.igrp.dao.TipoDocumentoEtapa;//
import nosi.core.webapp.bpmn.BPMNTaskController;//
import nosi.webapps.gestao_de_compras.pages.entrega.Entrega;
import nosi.webapps.gestao_de_compras.pages.entrega.EntregaView;
/*----#start-code(packages_import)----*/

/*----#end-code----*/



/**
 *demo@nosi.cv
 *22-10-2022
*/

public class TaskentregaController extends BPMNTaskController {

	public Response actionIndex() throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {
		EntregaView view = new EntregaView();
		Entrega model = new Entrega();
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
