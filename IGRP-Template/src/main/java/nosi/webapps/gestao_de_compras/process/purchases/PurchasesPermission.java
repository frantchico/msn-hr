package nosi.webapps.gestao_de_compras.process.purchases;

import nosi.core.webapp.bpmn.TaskPermissionInterface;
import nosi.webapps.igrp.dao.ActivityExecute;

/**
 * demo@nosi.cv
 * 22-10-2022
 */
public class PurchasesPermission implements TaskPermissionInterface {

		@Override
		public boolean allowTask(ActivityExecute task) {
				/**
		 		* Custom implement permission
		 		*/
				return true;
		}


/** Exemple Implementation
*
		 @Override
		public boolean allowTask(ActivityExecute task) {
				
				if(Core.isNotNull(task.getCustomPermission())) {
					String cc = centro_custo.get(Core.getCurrentUser().getEmail());
					return cc!=null && cc.compareTo(task.getCustomPermission())==0;			
				}
				return true;
		}

		private static final Map<String,String> centro_custo = new HashMap<>();
		
		static {
			centro_custo.put("c1@gmail.com", "c1");
			centro_custo.put("c2@gmail.com", "c2");
			centro_custo.put("c11@gmail.com", "c2");
		}*/

}