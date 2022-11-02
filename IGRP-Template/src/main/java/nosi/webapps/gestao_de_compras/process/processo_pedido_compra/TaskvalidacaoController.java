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
import nosi.webapps.gestao_de_compras.pages.validacao_form.Validacao_form;
import nosi.webapps.gestao_de_compras.pages.validacao_form.Validacao_formView;
/*----#start-code(packages_import)----*/

/*----#end-code----*/

/**
 * demo@nosi.cv 19-10-2022
 */

public class TaskvalidacaoController extends BPMNTaskController {

	public Response actionIndex()
			throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {
		Validacao_formView view = new Validacao_formView();
		Validacao_form model = new Validacao_form();
		model.load();

		/*----#start-code(index)----*/
		model.loadFromTask("pedido");

		Core.setMessageInfo("Process Variable p_justificacao=["
				+ Core.getProcessVariable("processo_pedido_compra", "pedido_p_justificacao") + "]");

		Core.setMessageWarning(
				"Task Variable p_justificacao=[" + Core.getTaskVariable("pedido", "p_justificacao") + "]");
		/*----#end-code----*/

		return super.index("gestao_de_compras", model, view, this);
	}

	public Response actionSave()
			throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {

		/*----#start-code(save)----*/
		Validacao_form model = new Validacao_form();
		model.load();
		int total = 0;

		if (model.getAprovar().equals("S"))
			total = model.getFormlist_1().stream().mapToInt(f -> Core.toInt(f.getQuantidade().getKey())).sum();

		Core.setTaskVariableInt("p_total", total);
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
