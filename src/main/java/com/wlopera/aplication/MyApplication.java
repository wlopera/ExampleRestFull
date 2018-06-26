/**
 * Para que el contenedor web las localice y publique como servicios web. 
 * Hay varias opciones, como indicarlas en el fichero web.xml, 
 * aquí vamos a optar por otra opción. 
 * Crear una clase que herede de Application y sobreescribir el método getClasses(). 
 */
package com.wlopera.aplication;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.wlopera.service.RestfulService;

@ApplicationPath("product")
public class MyApplication extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> classes = new HashSet<>();
		classes.add(RestfulService.class);
		return classes;
	}
}
