package nosi.webapps.gestao_de_compras.soapservices.server;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import nosi.webapps.gestao_de_compras.dao.TblProduct;

/**
 * frant
 * 27/10/2022
 */

@WebService(name="product_service", targetNamespace = "http:/msn.cv")
public class SoapProductService {
	
	private List<TblProduct> products;
	
	
	@WebMethod(operationName = "list_products",action = "list_products" )
	@WebResult(name = "TblProduct")
	public List<TblProduct> getProducts(){
		TblProduct p = new TblProduct();
		p.setApplicationName("gestao_de_compras");		
		//TblProducts ps = new TblProducts();		
		//ps.setEntries(p.findAll());
		return p.findAll();
	}
	

	
	
	
	
	
	
	
	
	
	/*@XmlRootElement
	@XmlAccessorType(XmlAccessType.PROPERTY)
	class TblProducts {
		public TblProducts() {
			entries = new ArrayList<>();
		}
		
	    
	    private List<TblProduct> entries;
	    
	    @XmlElement(name="product")
	    public List<TblProduct> getEntries() {
	        return this.entries;
	    }
	    
	    public void setEntries(List<TblProduct> list) {
	    	entries = list;
	    }
	}*/
}
