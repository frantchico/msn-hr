package nosi.webapps.gestao_de_compras.process.purchases;


import java.io.IOException;//
import nosi.core.webapp.Response;//
import javax.servlet.ServletException;//
import java.util.List;//
import nosi.core.webapp.Core;//
import nosi.core.webapp.databse.helpers.ResultSet;//
import nosi.core.webapp.databse.helpers.QueryInterface;//
import nosi.webapps.igrp.dao.TipoDocumentoEtapa;//
import nosi.core.webapp.bpmn.BPMNTaskController;//
/*----#start-code(packages_import)----*/
import nosi.core.gui.components.IGRPSeparatorList.Pair; //block import
import java.util.List; //block import
import java.util.ArrayList; //block import
import java.util.Map; //block import
import java.util.HashMap; //block import
import java.util.LinkedHashMap;
import nosi.webapps.gestao_de_compras.pages.verificacao.Verificacao;
import nosi.webapps.gestao_de_compras.pages.verificacao.VerificacaoView;
import nosi.webapps.gestao_de_compras.dao.TblPurchase; //block import
import nosi.webapps.gestao_de_compras.dao.TblProduct; //block import
import java.math.BigInteger;
import static nosi.core.i18n.Translator.gt;
/*----#end-code----*/

/**
 * demo@nosi.cv 22-10-2022
 */

public class TaskverificacaoController extends BPMNTaskController {
	private int total = 0;
	private double custo = 0;
	
	public Response actionIndex()
			throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {
		VerificacaoView view = new VerificacaoView();
		Verificacao model = new Verificacao();
		model.load();

		/*----#start-code(index)----*/
		
		try {
			TblProduct tblproductfilter = new TblProduct().find();
			List<TblProduct> tblproductList = tblproductfilter.all();
			LinkedHashMap<String, String> produto = new LinkedHashMap<>();
			produto.put(null, gt("-- Selecionar --"));
			for (TblProduct tblproduct : tblproductList) {
				produto.put(tblproduct.getId().toString(), gt(tblproduct.getDescription()));
			}
			view.produto.setValue(produto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			TblPurchase tblpurchasefilter = new TblPurchase().find();
			if (Core.isNotNullOrZero(Core.getProcessVariableId("purchase"))) {
				tblpurchasefilter.andWhere("idProcess", "=", Core.getProcessVariableId("purchase"));
			}
			List<TblPurchase> tblpurchaseList = tblpurchasefilter.all();
			
			
			if (Core.isNotNull(tblpurchaseList)) {
				List<Verificacao.Separatorlist_1> separatorlistDocs = new ArrayList<>();
				tblpurchaseList.forEach(tblpurchase -> {
					Verificacao.Separatorlist_1 row = new Verificacao.Separatorlist_1();

					row.setProduto(new Pair(tblpurchase.getIdProduct().getId().toString(),
							tblpurchase.getIdProduct().getDescription()));
					row.setPreco_unitario(new Pair(tblpurchase.getIdProduct().getUnitPrice().toString(),
							tblpurchase.getIdProduct().getUnitPrice().toString()));
					row.setQuantidade(
							new Pair(tblpurchase.getQuantity().toString(), tblpurchase.getQuantity().toString()));
					row.setSeparatorlist_1_id(new Pair(tblpurchase.getId().toString(), tblpurchase.getId().toString()));
					separatorlistDocs.add(row);
					
					total += tblpurchase.getQuantity().intValue();
					custo += tblpurchase.getPrice();
					
				});
				model.setSeparatorlist_1(separatorlistDocs);
				
				model.setTotal_de_item(Core.toBigInteger(""+total));
				model.setCusto(Core.toBigDecimal(""+custo));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*----#end-code----*/

		return super.index("gestao_de_compras", model, view, this);
	}

	public Response actionSave()
			throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {

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
