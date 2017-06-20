



function eliminar(id, token){
	
	var r = confirm("¿Está seguro que desea eliminar la orden? Una vez eliminada no podrá recuperarla");
	
	if (r == true) {

		  $.getJSON("/pedido/eliminarCliente", {
          	id : id,
          	token: token,
              ajax : 'true'
          }, function(data) {
        	  
        	  window.location.href = "/";
          });

	}
}