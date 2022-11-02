package nosi.webapps.gestao_de_compras.restapi;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import nosi.webapps.gestao_de_compras.dao.TblProduct;

/**
 * frant
 * 26/10/2022
 */
@Path("/products")
public class ProductsApi {
	@Path("/")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TblProduct> allProducts(){
		TblProduct p = new TblProduct();
		p.setApplicationName("gestao_de_compras");
		return p.findAll();
	}
	
	@Path("/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public TblProduct getProduct(@PathParam("id") Integer id){
		TblProduct p = new TblProduct();
		p.setApplicationName("gestao_de_compras");
		return p.findOne(id);
	}
	
	@Path("/")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TblProduct createProduct(TblProduct p){
		p.setApplicationName("gestao_de_compras");
		return p.insert();
	}
	
	@Path("/")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public TblProduct updateProduct(TblProduct p){
		p.setApplicationName("gestao_de_compras");		
		return p.update();
	}
	
	
	@Path("/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProduct(@PathParam("id") Integer id){
		TblProduct p = new TblProduct();
		p.setApplicationName("gestao_de_compras");
		return Response.status(200).entity(p.delete(id)).build();
	}
}
