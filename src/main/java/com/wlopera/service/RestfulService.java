/**
 * La clase que va a ser nuestro servicio Web, con métodos. 
 * Únicamente hay que poner las anotaciones específicas de JAX-RS para que el contenedor de aplicaciones lo convierta en servicio web 
 * cuando arranque. Las anotaciones son las siguientes:
 *   @Path para indicar el path en la url donde estará nuestro servicio web
 *   @Produces para indicar el formato en el que el servicio web nos devuelve el resultado. Son habituales "application/xml" y "application/json".
 *   @Consumes para indicar el formato en el que nuestro servicio web admite los datos. Igual que @Produces, son habituales "application/xml" y "application/json".
 * El protocolo http define varios métodos para las peticiones http. En los web services son habituales las cuatro siguientes:
 *   @GET Cuando queremos pedir datos al servicio web. Por ejemplo, 
 *        una petición @GET a http://localhost:8080/ExampleRestFull/resources/service/grow => devolver la lista de productos cultivados y una llamada a 
 *        http://localhost:8080/ExampleRestFull/resources/service/grow/23 podría devolver los datos del cultivo cuyo identificador es 23.
 *   @POST Cuando enviamos datos al servicio web para que el servicio web haga con ellos lo que considere oportuno. 
 *   Por ejemplo, una llamada @POST a http://localhost:8080/ExampleRestFull/resources/service/agregar_cultivos
 *   pasando los datos de un cultivo, puede crear el empleo en base de datos.
 *   @PUT Cuando queremos guardar datos en una url específica. Si esos datos no existen en esa URL, se crean. 
 *   	Si ya existen, deben modificarse para que sean lo que nosotros hemos pasado. 
 *   	Por ejemplo, una llamada @PUT a http://localhost:8080/ExampleRestFull/resources/service/agregar_cultivo/23 pasándole datos de un cultivo, 
 *   	modificaría los datos del producto cultivado cuyo identificador es el 23 para que sean los que nosotros pasamos. 
 *   	Si no hay ningún producto con identificador 23, debería crearse un nuevo rubro de ese producto y asignarle un identificador.
 *   @DELETE Para borrar los datos de una url específica. Por ejemplo, una llamada @DELETE a 
 *   http://localhost:8080/ExampleRestFull/resources/service/grow/delete/23 debería eliminar el producto de identificador 23.
 */
package com.wlopera.service;

import java.util.LinkedList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.wlopera.model.Product;

@Path("/service/")
public class RestfulService {

	@GET()
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("/grow/")
	public  List<Product> getProductosCultivados() {
		
		System.out.println("##=> Conectado /service/cultivar/");
		
		List<Product> result = new LinkedList<Product>();
		result.add(new Product(1, "Tomate", 50.0));
		result.add(new Product(2, "Papa", 20.0));
		result.add(new Product(3, "Cebolla", 30.0));
		result.add(new Product(4, "Pimeton", 40.0));
		result.add(new Product(5, "Ajo", 25.0));
		
		System.out.println(result.toString());
		// return new JSONObject().put("productos", result).toString();
		return result;
	}

	@GET()
	@Path("/import/")
	public String getProductosImportados() {
		System.out.println("##=> Conectado /service/importar/");
		
		List<Product> result = new LinkedList<Product>();
		result.add(new Product(1, "Tomate", 5.0)); 
		result.add(new Product(2, "Papa", 12.0));
		result.add(new Product(3, "Cebolla", 4.0));
		result.add(new Product(4, "Pimeton", 6.0));
		result.add(new Product(5, "Ajo", 3.0));
		
		System.out.println(result.toString());
		return new JSONObject().put("productos", result).toString();
	}
	
	// TODO: Falta servicios. POST - PUT - DElETE - otros GET

}