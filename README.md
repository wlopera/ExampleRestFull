# ExampleRestFull - RESTFULL - JAX-RS 

Ejercicio básico de RestFull con JAX-RS
url: 
  - http://chuwiki.chuidiang.org/index.php?title=Ejemplo_de_servicios_REST_con_JSON_y_contenedor_JEE
  - http://www.webtutoriales.com/articulos/servicios-rest-con-java-usando-jax-rs-y-jersey
  
La clase con el servicio web
La clase que va a ser nuestro servicio Web no es más que una clase normal de java, con métodos. Únicamente hay que poner las anotaciones específicas de JAX-RS para que el contenedor de aplicaciones lo convierta en servicio web cuando arranque. Las anotaciones son las siguientes:

@Path para indicar el path en la url donde estará nuestro servicio web.
@Produces para indicar el formato en el que el servicio web nos devuelve el resultado. Son habituales "application/xml" y "application/json".
@Consumes para indicar el formato en el que nuestro servicio web admite los datos. Igual que @Produces, son habituales "application/xml" y "application/json".
El protocolo http define varios métodos para las peticiones http. En los web services son habituales las cuatro siguientes:
@GET Cuando queremos pedir datos al servicio web. Por ejemplo, una petición @GET a http://servidor/webservice/empleados podría devolver la lista de empleados y una llamada a http://servidor/webservice/empleados/23 podría devolver los datos del empleado cuyo identificador es 23.
@POST Cuando enviamos datos al servicio web para que el servicio web haga con ellos lo que considere oportuno. Por ejemplo, una llamada @POST a http://servidor/webservice/crea_empleado pasando los datos de un empleado, puede crear el empleado en base de datos.
@PUT Cuando queremos guardar datos en una url específica. Si esos datos no existen en esa URL, se crean. Si ya existen, deben modificarse para que sean lo que nosotros hemos pasado. Por ejemplo, una llamada @PUT a http://servidor/webservice/empleados/23 pasándole datos de un empleado, modificaría los datos del empleado cuyo identificador es el 23 para que sean los que nosotros pasamos. Si no hay ningún empleado con identificador 23, debería crearse un nuevo empleado y asignarle ese identificador concreto.
@DELETE Para borrar los datos de una url específica. Por ejemplo, una llamada @DELETE a http://servidor/webservice/empleados/23 debería eliminar el empleado de identificador 23.


La clase Application
Una vez que tenemos nuestras clases de servicio web adecuadamente anotadas, debemos darlas de alta de alguna forma para que el contenedor web las localice y las publique como servicios web. Hay varias opciones, como indicarlas en el fichero web.xml, pero aquí vamos a optar por otra opción. Basta crear una clase que herede de Application y sobreescribir el método getClasses(). El siguiente código puede ser un ejemplo

TODO: Los servicios rest debe retornar Json con @Produces({MediaType.APPLICATION_JSON}) eliminar uso de gson para conversion, no es necesario 

Links: para CRUD java
http://www.chuidiang.org/java/mysql/BasicDataSource-Pool-Conexiones.php
https://www.ecodeup.com/crud-java-manual-completo/
http://www.javamexico.org/blogs/marco_antonio_trejo_lemus/conexion_sql_por_jdbc
