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