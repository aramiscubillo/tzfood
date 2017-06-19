var cedula = "";
var nombre = "";
var entregado = "";
var pagado = "";
var pageSize = 0;

$( document ).ready(function() {
	cedula = $('#cedula').val();
	nombre = $('#nombrePersona').val();
	entregado = $('#entregado').find(":selected").attr('value');
	pagado = $('#pagado').find(":selected").attr('value');
	pageSize = $('#pageSize').find(":selected").attr('value');
	
	
	 $( "#buscar" ).click(function() {
		 $('#pageNumber').val(0);
		 console.log($('#pageNumber').val());
		 console.log('asdfasdf');
	    $( "#frmBuscar" ).submit();
	 });
	
	 
	 $( "#verNormal" ).click(function() {
		 $('.extra').show();
		 $('.mobil').hide();
		 $('.normal').show();
		 $('#verNormal').hide();
		 $('#verMobil').show();
	 });
	 
	 $( "#verMobil" ).click(function() {
		 $('.extra').hide();
		 $('.mobil').show();
		 $('.normal').hide();
		 $('#verNormal').show();
		 $('#verMobil').hide();
	 });
	
	 
	 if($( window ).width() <= 992){
		 $('.extra').hide();
		 $('.mobil').show();
		 $('.normal').hide();
		 $('#verNormal').show();
		 $('#verMobil').hide();
	 }else{
		 $('.extra').show();
		 $('.mobil').hide();
		 $('.normal').show();
		 $('#verNormal').hide();
		 $('#verMobil').show();
	 }
	 
	 
	 $('.picker').datepicker({
	      dateFormat: 'dd-mm-yy'
	});
	 
	 
	 $('#provincias').change(
			 function() {
				 var pathname = window.location.pathname;
				 $.getJSON("/ubicacion/getRegionByRegionPapa", {
					 regionPapa : $(this).val(),
					 ajax : 'true'
				 }, function(data) {
					 var html = '<option value="">--selecione un canton--</option>';
					 var len = data.length;
					 for ( var i = 0; i < len; i++) {
						 html += '<option value="' + data[i].id + '">'
						 + data[i].nombre + '</option>';
					 }
					 html += '</option>';
					 $('#cantones').html(html);
				 });
			 });

	 
});

/*
function search(){
	 $('#pageNumber').val(0);
	 $('#buscar').trigger('click');
}*/

function setPaging(pageNumber){
	cedula2 = $('#cedula').val();
	nombre2 = $('#nombrePersona').val();
	entregado2 = $('#entregado').find(":selected").attr('value');
	pagado2 = $('#pagado').find(":selected").attr('value');
	pageSize2 = $('#pageSize').find(":selected").attr('value');
	console.log(cedula, cedula2);
	if((cedula != cedula2) || (nombre2 != nombre) || (entregado2 != entregado) ||
			(pagado2 != pagado) || (pageSize != pageSize2)){

		$('#newSearch').val('new');
	}else{
		$('#newSearch').val('old');
	}
	
	 $('#pageNumber').val(pageNumber-1);
	 //$('#buscar').trigger('click');
	 $( "#frmBuscar" ).submit();
}


function pagar(id){
	
	var r = confirm("¿Está seguro que desea marcar la orden como pagada?");
	
	if (r == true) {

		  $.getJSON("/pedido/pagar", {
          	id : id,
              ajax : 'true'
          }, function(data) {
        	  
        	  if(data == '200'){
        		  $( "#frmBuscar" ).submit();  
        	  }
        	 
          });

	}
}

function confirmar(id){
	
	var r = confirm("¿Está seguro que desea marcar la orden como confirmada?");
	
	if (r == true) {

		  $.getJSON("/pedido/confirmar", {
          	id : id,
              ajax : 'true'
          }, function(data) {
        	  
        	  if(data == '200'){
        		  $( "#frmBuscar" ).submit();  
        	  }
        	 
          });

	}
}


function entregar(id){
	
	var r = confirm("¿Está seguro que desea entregar la orden?");
	
	if (r == true) {

		  $.getJSON("/pedido/entregar", {
          	id : id,
              ajax : 'true'
          }, function(data) {
        	  
        	  if(data == '200'){
        		  $( "#frmBuscar" ).submit();  
        	  }
        	 
          });

	}
}


function eliminar(id){
	
	var r = confirm("¿Está seguro que desea eliminar la orden? Una vez eliminada no podrá recuperarla");
	
	if (r == true) {

		  $.getJSON("/pedido/eliminar", {
          	id : id,
              ajax : 'true'
          }, function(data) {
        	  
        	  if(data == '200'){
        		  $( "#frmBuscar" ).submit();  
        	  }
        	 
          });

	}
}