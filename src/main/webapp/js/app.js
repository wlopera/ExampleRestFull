// Modulo angular
// scope: Alcance de variables 
// hhtp: libreria HTPP consulta de servicios REST
angular.module("MyApp", [])
    .controller("MyController",["$scope", "$http", function($scope, $http){
    	
    	$scope.mostrar = false; 	// Variable para mostrar resultados
    	$scope.acionProducto = ""; 	// Variable para mostrar tipo de producto cultivado/importado
    	$scope.productos = {};     	// Productos encontrados en la consulta

    	// Permite consultar cantidad de productos cultivados - prtocolo HTTP
    	$scope.cultivar = function(){
    	  $http.get("product/service/grow")        // URI de llamada
    	  .then(function onSuccess(response) {     // Respuesta OK
    		$scope.mostrar = true;
    		$scope.acionProducto = "Cultivadas";
    	    $scope.productos=response.data.productos;
    	    console.log("##=> Productos cultivados: ", $scope.producto);
    	  }).catch(function onError(response) {   // Respuesta Error
    		$scope.mostrar = false;
    	    console.log("##=> Error: ", response);
    	  });       
    	}
    	
    	// Permite consultar cantidad de productos importados - prtocolo HTTP
    	$scope.importar = function(){
      	  $http.get("product/service/import")   // URI de llamada
      	  .then(function onSuccess(response) {	// Respuesta OK
      		$scope.mostrar = true;
      		$scope.acionProducto = "Importadas";
      	    $scope.productos=response.data.productos;
      	    console.log("##=> Productos importados: ", $scope.producto);
      	  }).catch(function onError(response) { // Respuesta Error
      		$scope.mostrar = false;
      	    console.log("##=> Error: ", response);
      	  });       
      	}

    }]);