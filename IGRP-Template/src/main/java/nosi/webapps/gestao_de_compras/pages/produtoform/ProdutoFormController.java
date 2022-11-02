package nosi.webapps.gestao_de_compras.pages.produtoform;

import nosi.core.webapp.Controller;//
import nosi.core.webapp.databse.helpers.ResultSet;//
import nosi.core.webapp.databse.helpers.QueryInterface;//
import java.io.IOException;//
import nosi.core.webapp.Core;//
import nosi.core.webapp.Response;//
/* Start-Code-Block (import) */
/* End-Code-Block */
/*----#start-code(packages_import)----*/
import org.hibernate.Session; //block import
import org.hibernate.Transaction; //block import
import nosi.webapps.gestao_de_compras.dao.TblProduct; //block import
/*----#end-code----*/
		
public class ProdutoFormController extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		ProdutoForm model = new ProdutoForm();
		model.load();
		ProdutoFormView view = new ProdutoFormView();
		/* Start-Code-Block (index) *//* End-Code-Block (index) */
		/*----#start-code(index)----*/
		if (Core.isNotNullOrZero(Core.getParamInt("p_id"))) {

			try {
				String isEdit = Core.getParam("isEdit");
				if (Core.isNotNull(isEdit)) {
					TblProduct tblproduct = new TblProduct().findOne(Core.getParamInt("p_id"));
					if (tblproduct != null && !tblproduct.hasError()) {
						view.foto.setValue(Core.getLinkFileByUuid(tblproduct.getIdFile()));
						model.setDescricao(tblproduct.getDescription());
						model.setReferencia(tblproduct.getReference());
						model.setRegistado_por(Core.getUsernameById(tblproduct.getIdUser()).toString());
						model.setId(tblproduct.getId());
						model.setId_user(tblproduct.getIdUser());
						model.setPreco_unitario(tblproduct.getUnitPrice());

						view.btn_guardar.addParameter("isEdit", "true");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			model.setId_user(Core.getCurrentUser().getId());
			model.setRegistado_por(Core.getCurrentUser().getName());
		}

		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	
	public Response actionGuardar() throws IOException, IllegalArgumentException, IllegalAccessException{
		ProdutoForm model = new ProdutoForm();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  return this.forward("gestao_de_compras","ProdutoForm","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (guardar)  *//* End-Code-Block  */
		/*----#start-code(guardar)----*/

		Session session = null;
		Transaction transaction = null;
		String isEdit = Core.getParam("isEdit");
		try {
			if (model.validate()) {
				session = Core.getSession(Core.defaultConnection());
				transaction = session.getTransaction();
				if (!transaction.isActive())
					transaction.begin();
				TblProduct tblproduct = new TblProduct();
				if (Core.isNotNull(isEdit)) {
					tblproduct = session.find(TblProduct.class, model.getId());
				}
				if (tblproduct != null) {
					tblproduct.setDescription(model.getDescricao());
					tblproduct.setReference(model.getReferencia());

					if (Core.isNullOrZero(model.getId())) {
						tblproduct.setIdUser(Core.getCurrentUser().getId());
					} else {
						tblproduct.setIdUser(model.getId_user());
					}
					String uuid = Core.saveFileNGetUuid(model.getFile());
					
					
					tblproduct.setIdFile(model.getFoto_uuid());
					tblproduct.setUnitPrice(model.getPreco_unitario());
				}
				session.persist(tblproduct);
				model.setId(tblproduct.getId());
				transaction.commit();
				Core.setMessageSuccess();
			} else
				Core.setMessageError();
		} catch (Exception e) {
			e.printStackTrace();
			Core.setMessageError("Error: " + e.getMessage());
			if (transaction != null)
				transaction.rollback();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		if (Core.isNotNull(isEdit)) {
			this.addQueryString("isEdit", "true");
			return this.forward("gestao_de_compras", "ProdutoForm", "index", this.queryString());
		}

		this.addQueryString("p_id", model.getId());
		this.addQueryString("isEdit", "true");
		/*----#end-code----*/
		return this.redirect("gestao_de_compras","ProdutoForm","index", this.queryString());	
	}
	/* Start-Code-Block (custom-actions)  *//* End-Code-Block  */
/*----#start-code(custom_actions)----*/
	
	/*----#end-code----*/
}
