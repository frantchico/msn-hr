package nosi.webapps.gestao_de_recursos_humanos.pages.dashboard_one;

import nosi.core.webapp.Model;
import nosi.core.webapp.View;
import nosi.core.gui.components.*;
import nosi.core.gui.fields.*;
import static nosi.core.i18n.Translator.gt;
import nosi.core.webapp.Core;

public class Dashboard_oneView extends View {

	public Field timeline_1_icon;
	public Field timeline_1_hd;
	public Field timeline_1_date;
	public Field timeline_1_text;
	public Field timeline_1_btn;
	public Field paragraph_1_text;
	public Field departamento_id;
	public Field funcao_id;
	public IGRPTimeline timeline_1;
	public IGRPParagraph paragraph_1;
	public IGRPForm form_1;

	public IGRPButton btn_filtrar;

	public Dashboard_oneView(){

		this.setPageTitle("Dashboard 1");
			
		timeline_1 = new IGRPTimeline("timeline_1","Evolução de Contratação");

		paragraph_1 = new IGRPParagraph("paragraph_1","");

		form_1 = new IGRPForm("form_1","Filtrar por...");

		timeline_1_icon = new TextField(model,"timeline_1_icon");
		timeline_1_icon.setLabel(gt("Icon"));
		timeline_1_icon.propertie().add("type","img").add("maxlength","30");
		
		timeline_1_hd = new TextField(model,"timeline_1_hd");
		timeline_1_hd.setLabel(gt("Header"));
		timeline_1_hd.propertie().add("type","text").add("maxlength","40");
		
		timeline_1_date = new DateField(model,"timeline_1_date");
		timeline_1_date.setLabel(gt("Date"));
		timeline_1_date.propertie().add("type","date").add("maxlength","40");
		
		timeline_1_text = new TextField(model,"timeline_1_text");
		timeline_1_text.setLabel(gt("Content"));
		timeline_1_text.propertie().add("type","text").add("maxlength","4000");
		
		timeline_1_btn = new LinkField(model,"timeline_1_btn");
		timeline_1_btn.setLabel(gt("Button"));
		timeline_1_btn.propertie().add("type","link").add("target","_self").add("maxlength","4000");
		
		paragraph_1_text = new TextField(model,"paragraph_1_text");
		paragraph_1_text.setLabel(gt(""));
		paragraph_1_text.setValue(gt("<p><span style='font-family:Comic Sans MS,cursive;'><span style='font-size:22px;'>A empresa tem crescido vamos ver o hist&oacute;rico de contrata&ccedil;&otilde;es.</span></span></p>"));
		paragraph_1_text.propertie().add("type","text").add("name","p_paragraph_1_text").add("maxlength","4000");
		
		departamento_id = new ListField(model,"departamento_id");
		departamento_id.setLabel(gt("Departamento"));
		departamento_id.propertie().add("name","p_departamento_id").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","").add("maxlength","250").add("required","false").add("disabled","false").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		
		funcao_id = new ListField(model,"funcao_id");
		funcao_id.setLabel(gt("Função"));
		funcao_id.propertie().add("name","p_funcao_id").add("type","select").add("multiple","false").add("tags","false").add("load_service_data","false").add("domain","").add("maxlength","250").add("required","false").add("disabled","false").add("java-type","").add("tooltip","false").add("disable_copy_paste","false");
		


		btn_filtrar = new IGRPButton("Filtrar","gestao_de_recursos_humanos","Dashboard_one","filtrar","submit_ajax","grey|fa-filter","","");
		btn_filtrar.propertie.add("id","button_3487_9a97").add("type","form").add("class","grey").add("rel","filtrar").add("refresh_components","timeline_1");

		
	}
		
	@Override
	public void render(){
		
		timeline_1.addField(timeline_1_icon);
		timeline_1.addField(timeline_1_hd);
		timeline_1.addField(timeline_1_date);
		timeline_1.addField(timeline_1_text);
		timeline_1.addField(timeline_1_btn);

		paragraph_1.addField(paragraph_1_text);

		form_1.addField(departamento_id);
		form_1.addField(funcao_id);

		form_1.addButton(btn_filtrar);
		this.addToPage(timeline_1);
		this.addToPage(paragraph_1);
		this.addToPage(form_1);
	}
		
	@Override
	public void setModel(Model model) {
		
		timeline_1_icon.setValue(model);
		timeline_1_hd.setValue(model);
		timeline_1_date.setValue(model);
		timeline_1_text.setValue(model);
		timeline_1_btn.setValue(model);
		departamento_id.setValue(model);
		funcao_id.setValue(model);	

		timeline_1.loadModel(((Dashboard_one) model).getTimeline_1());
		}
}
