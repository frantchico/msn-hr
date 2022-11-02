package nosi.webapps.gestao_de_compras.pages.lojaform;

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
import nosi.webapps.gestao_de_compras.dao.TblStore; //block import
/*----#end-code----*/
		
public class LojaFormController extends Controller {
	public Response actionIndex() throws IOException, IllegalArgumentException, IllegalAccessException{
		LojaForm model = new LojaForm();
		model.load();
		LojaFormView view = new LojaFormView();
		/* Start-Code-Block (index) *//* End-Code-Block (index) */
		/*----#start-code(index)----*/
		if (Core.isNotNullOrZero(Core.getParamInt("p_id"))) {

			try {
				String isEdit = Core.getParam("isEdit");
				if (Core.isNotNull(isEdit)) {
					TblStore tblstore = new TblStore().findOne(Core.getParamInt("p_id"));
					if (tblstore != null && !tblstore.hasError()) {
						model.setDesignacao(tblstore.getDescription());
						model.setLocalizacao(tblstore.getLocation());
						model.setRegistado_por(Core.getUsernameById(tblstore.getIdUser()).toString());
						model.setId(tblstore.getId());
						model.setId_user(tblstore.getIdUser());

						view.btn_gravar.addParameter("isEdit", "true");
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			model.setRegistado_por(Core.getCurrentUser().getName());
			model.setId_user(Core.getCurrentUser().getId());
		}
		/*----#end-code----*/
		view.setModel(model);
		return this.renderView(view);	
	}
	
	public Response actionGravar() throws IOException, IllegalArgumentException, IllegalAccessException{
		LojaForm model = new LojaForm();
		model.load();
		/*----#gen-example
		  EXAMPLES COPY/PASTE:
		  INFO: Core.query(null,... change 'null' to your db connection name, added in Application Builder.
		  this.addQueryString("p_id","12"); //to send a query string in the URL
		  return this.forward("gestao_de_compras","LojaForm","index",this.queryString()); //if submit, loads the values
		  Use model.validate() to validate your model
		  ----#gen-example */
		/* Start-Code-Block (gravar)  *//* End-Code-Block  */
		/*----#start-code(gravar)----*/
		Session session = null;
		Transaction transaction = null;
		String isEdit = Core.getParam("isEdit");
		try {
			if (model.validate()) {
				session = Core.getSession(Core.defaultConnection());
				transaction = session.getTransaction();
				if (!transaction.isActive())
					transaction.begin();
				TblStore tblstore = new TblStore();
				if (Core.isNotNull(isEdit)) {
					tblstore = session.find(TblStore.class, model.getId());
				}
				if (tblstore != null) {
					tblstore.setDescription(model.getDesignacao());
					tblstore.setLocation(model.getLocalizacao());
					tblstore.setIdUser(model.getId_user());
				}
				session.persist(tblstore);
				model.setId(tblstore.getId());

				this.addQueryString("p_id", model.getId());

				this.addQueryString("isEdit", "true");
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
			return this.forward("gestao_de_compras", "LojaForm", "index", this.queryString());
		}
		/*----#end-code----*/
		return this.redirect("gestao_de_compras","LojaForm","index", this.queryString());	
	}
	/* Start-Code-Block (custom-actions)  *//* End-Code-Block  */
/*----#start-code(custom_actions)----*/

	/*----#end-code----*/
}
