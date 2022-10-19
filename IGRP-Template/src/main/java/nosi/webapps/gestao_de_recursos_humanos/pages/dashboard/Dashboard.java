package nosi.webapps.gestao_de_recursos_humanos.pages.dashboard;

import nosi.core.gui.components.IGRPLink;
import nosi.core.webapp.Report;
import nosi.core.gui.components.IGRPTable;
import nosi.core.webapp.Model;
import nosi.core.webapp.RParam;
import nosi.core.webapp.databse.helpers.BaseQueryInterface;
import java.util.ArrayList;
import java.util.List;

public class Dashboard extends Model{		

	@RParam(rParamName = "p_paragraph_1_text")
	private String paragraph_1_text;

	@RParam(rParamName = "p_departamento_id")
	private String departamento_id;

	@RParam(rParamName = "p_funcao_id")
	private String funcao_id;
	
	private List<Timeline_1> timeline_1 = new ArrayList<>();	
	public void setTimeline_1(List<Timeline_1> timeline_1){
		this.timeline_1 = timeline_1;
	}
	public List<Timeline_1> getTimeline_1(){
		return this.timeline_1;
	}

	
	public void setParagraph_1_text(String paragraph_1_text){
		this.paragraph_1_text = paragraph_1_text;
	}
	public String getParagraph_1_text(){
		return this.paragraph_1_text;
	}
	
	public void setDepartamento_id(String departamento_id){
		this.departamento_id = departamento_id;
	}
	public String getDepartamento_id(){
		return this.departamento_id;
	}
	
	public void setFuncao_id(String funcao_id){
		this.funcao_id = funcao_id;
	}
	public String getFuncao_id(){
		return this.funcao_id;
	}


	public static class Timeline_1 extends IGRPTable.Table{
		private String timeline_1_icon="";
		private String timeline_1_icon_uuid;
		private String timeline_1_hd;
		private String timeline_1_date;
		private String timeline_1_text;
		private IGRPLink timeline_1_btn;
		private String timeline_1_btn_desc= "Button";
		public void setTimeline_1_icon(String timeline_1_icon){
			this.timeline_1_icon = timeline_1_icon;
		}
		public String getTimeline_1_icon(){
			return this.timeline_1_icon;
		}
		public void setTimeline_1_icon_uuid(String timeline_1_icon_uuid){
			this.timeline_1_icon_uuid = timeline_1_icon_uuid;
		}
		public String getTimeline_1_icon_uuid(){
			return this.timeline_1_icon_uuid;
		}

		public void setTimeline_1_hd(String timeline_1_hd){
			this.timeline_1_hd = timeline_1_hd;
		}
		public String getTimeline_1_hd(){
			return this.timeline_1_hd;
		}

		public void setTimeline_1_date(String timeline_1_date){
			this.timeline_1_date = timeline_1_date;
		}
		public String getTimeline_1_date(){
			return this.timeline_1_date;
		}

		public void setTimeline_1_text(String timeline_1_text){
			this.timeline_1_text = timeline_1_text;
		}
		public String getTimeline_1_text(){
			return this.timeline_1_text;
		}

		public IGRPLink setTimeline_1_btn(String app,String page,String action){
			this.timeline_1_btn = new IGRPLink(app,page,action);
			return this.timeline_1_btn;
		}
		public IGRPLink getTimeline_1_btn(){
			return this.timeline_1_btn;
		}
		public void setTimeline_1_btn_desc(String timeline_1_btn_desc){
			this.timeline_1_btn_desc = timeline_1_btn_desc;
		}
		public String getTimeline_1_btn_desc(){
			return this.timeline_1_btn_desc;
		}
	public IGRPLink setTimeline_1_btn(String link){
		this.timeline_1_btn = new IGRPLink(link);
		return this.timeline_1_btn;
	}
	public IGRPLink setTimeline_1_btn(Report link){
		this.timeline_1_btn = new IGRPLink(link);
		return this.timeline_1_btn;
	}

	}

	public void loadTimeline_1(BaseQueryInterface query) {
		this.setTimeline_1(this.loadTable(query,Timeline_1.class));
	}

}
