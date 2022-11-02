package nosi.webapps.gestao_de_compras.restapi;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * frant 26/10/2022
 */
@ApplicationPath("rest")
public class Configuration extends ResourceConfig {
	public Configuration() {
		packages("nosi.webapps.gestao_de_compras.restapi");
	}
}
