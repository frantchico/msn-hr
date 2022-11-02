package nosi.webapps.gestao_de_compras.process.purchases;

import static nosi.core.i18n.Translator.gt;

import java.io.IOException;//
import java.time.LocalDate;
import java.util.List;//
import nosi.core.webapp.Response;//
import javax.servlet.ServletException;//

import org.hibernate.Session;
import org.hibernate.Transaction;

import nosi.core.webapp.Core;//
import nosi.core.webapp.databse.helpers.ResultSet;//
import nosi.core.webapp.databse.helpers.QueryInterface;//
import nosi.webapps.igrp.dao.TipoDocumentoEtapa;//
import nosi.core.webapp.bpmn.BPMNTaskController;//

import java.util.ArrayList;
import java.util.Arrays;
/*----#start-code(packages_import)----*/
import java.util.LinkedHashMap;
import nosi.webapps.gestao_de_compras.dao.TblProduct;
import nosi.webapps.gestao_de_compras.dao.TblPurchase;
import nosi.webapps.gestao_de_compras.dao.TblStore;
import nosi.webapps.gestao_de_compras.pages.requisicao.Requisicao;
import nosi.webapps.gestao_de_compras.pages.requisicao.RequisicaoView;
/*----#end-code----*/

/**
 * demo@nosi.cv 22-10-2022
 */

public class TaskrequisicaoController extends BPMNTaskController {

	public Response actionIndex()
			throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {
		RequisicaoView view = new RequisicaoView();
		Requisicao model = new Requisicao();
		model.load();

		/*----#start-code(index)----*/
		try {
			TblStore tblstorefilter = new TblStore().find();
			List<TblStore> tblstoreList = tblstorefilter.all();
			LinkedHashMap<String, String> loja = new LinkedHashMap<>();
			loja.put(null, gt("-- Selecionar --"));
			for (TblStore tblstore : tblstoreList) {
				loja.put(tblstore.getId().toString(), gt(tblstore.getDescription()));
			}
			view.loja.setValue(loja);
		} catch (Exception e) {
			e.printStackTrace();
		}

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
		/*----#end-code----*/

		return super.index("gestao_de_compras", model, view, this);
	}

	public Response actionSave()
			throws IOException, ServletException, IllegalArgumentException, IllegalAccessException {

		/*----#start-code(save)----*/
		Requisicao model = new Requisicao();
		model.load();

		Session session = null;
		Transaction transaction = null;
		try {
			if (model.validate()) {
				session = Core.getSession(Core.defaultConnection());
				transaction = session.getTransaction();
				if (!transaction.isActive())
					transaction.begin();
				List<String> tblpurchaseeditList = new ArrayList<>();
				if (model.getP_separatorlist_1_edit() != null) {
					tblpurchaseeditList = new ArrayList<>(Arrays.asList(model.getP_separatorlist_1_edit()));
				}
				for (Requisicao.Separatorlist_1 row : model.getSeparatorlist_1()) {
					TblPurchase tblpurchase = new TblPurchase();
					if (Core.isNotNullOrZero(row.getSeparatorlist_1_id().getKey())) {
						if (!tblpurchaseeditList.isEmpty()
								&& tblpurchaseeditList.remove(row.getSeparatorlist_1_id().getKey())) {
							tblpurchase = session.find(TblPurchase.class,
									Core.toInt(row.getSeparatorlist_1_id().getKey()));
						} else
							continue;
					}

					TblProduct tblproductForeign = session.find(TblProduct.class,
							Core.toInt(row.getProduto().getKey()));
					tblpurchase.setIdProduct(tblproductForeign);
					TblStore tblstoreForeign = session.find(TblStore.class, model.getLoja());
					tblpurchase.setIdStore(tblstoreForeign);
					tblpurchase.setQuantity(Core.toInt(row.getQuantidade().getKey()));
					tblpurchase.setPrice(Core.toInt(row.getSub_total().getKey()));
					tblpurchase.setIdProcess(Core.getProcessVariableId("purchase"));
					
					session.persist(tblpurchase);
				}
				String[] tblpurchasedeletedIdsArray = model.getP_separatorlist_1_del();
				if (Core.isNotNull(tblpurchasedeletedIdsArray)) {
					for (String docId : tblpurchasedeletedIdsArray) {
						if (Core.isNotNull(docId) && !docId.isEmpty()) {
							TblPurchase tblpurchase = session.find(TblPurchase.class, Core.toInt(docId));
							session.delete(tblpurchase);
						}
					}
				}

				transaction.commit();
			} 
		} catch (Exception e) {
			e.printStackTrace();
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
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
