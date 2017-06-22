$( document ).ready(function() {

	 $.validate({
	    validateOnBlur : false, // disable validation when input looses focus
	    scrollToTopOnError : false // Set this property to true on longer forms
	  });
	
	 $( "#errorCantidad" ).hide();
	 $( "#errorPresentacion" ).hide();
	 $( "#errorProducto" ).hide();
	 $( "#errorMarca" ).hide();
	 
	 $( "#fechaEntrega" ).hide();
	
	 $( "#hiddenCanton" ).hide();
		
	 
	 $('#marcas').change(
		        function() {
		        	var pathname = window.location.pathname;
		            $.getJSON("/producto/getByMarca", {
		            	marca : $(this).val(),
		                ajax : 'true'
		            }, function(data) {
		                var html = '<option value="">--selecione un producto--</option>';
		                var len = data.length;
		                for ( var i = 0; i < len; i++) {
		                    html += '<option value="' + data[i] + '">'
		                            + data[i] + '</option>';
		                }
		                html += '</option>';
		                $('#productos').html(html);
		            });
    });
	 
	 
	 $('#provincias').change(
			 function() {
				 $( "#fechaEntrega" ).hide();
				 var pathname = window.location.pathname;
				 $.getJSON("/ubicacion/getRegionByRegionPapa", {
					 regionPapa : $(this).val(),
					 ajax : 'true'
				 }, function(data) {
					 var html = '<option value="">--selecione un canton--</option>';
					 var len = data.length;
					 for ( var i = 0; i < len; i++) {
						 html += '<option value="' + data[i].id +','+data[i].fechaEntrega  + '">'
						 + data[i].nombre + '</option>';
					 }
					 html += '</option>';
					 $('#cantones').html(html);
					 
					 
					 
				 });
			 });

	 $('#cantones').change(
			 function() {
				 //var pathname = window.location.pathname;

				 var html='';

				 var place= $(this).val().substring($(this).val().lastIndexOf(",")+1);

				 if(place=='null'){
					 html= '<p> Las entregas para este cant&oacute;n se realizan por medio de encomienda y tienen un valor de  ₡2500 de env&iacute;o</p>'
				 }else{
					 html= '<p> Las entregas para este cant&oacute;n se realizan los siguientes d&iacute;as: '+ place +'</p>';

				 }

				 $('#fechaEntrega').html(html);
				 $( "#fechaEntrega" ).show();

			 });

	 $('#presentacion').change(
			 function() {
				 //var pathname = window.location.pathname;
				 
				 producto = $('#presentacion').find(":selected").data("value");
				 
				 var html='';

				 var precio= producto.precio

				 html= '<span>₡ '+ precio + '</span>'
				 

				 $('#precioProducto').html(html);
				 

			 });



	 $('#productos').change(
		        function() {
		        	var pathname = window.location.pathname;
		            $.getJSON("/producto/getByNombre", {
		            	nombre : $(this).val(),
		            	marca: $('#marcas').val(),
		                ajax : 'true'
		            }, function(data) {
		                var html = '<option value="">--seleccione una presentación--</option>';
		                var len = data.length;
		                
		                for ( var i = 0; i < len; i++) {
		                	
		                	var stringObject = JSON.stringify(data[i]);
		                	
		                	
		                    html += '<option data-value=\'' + stringObject +'\'>'
		                            + data[i].presentacion+' ' +data[i].nombre +' '+data[i].marca+ '</option>';
		                }
		                html += '</option>';
		                $('#presentacion').html(html);
		            });
    	});

	 var validator = $('#productoForm').validate();

	
	 
	 $( "#btnAgregar" ).click(function() {
		 validateProductForm();

	});
	 
		
});


function validateProductForm(){
	valid = true;   

	if ($('#marcas').val() == '') {
		$( "#errorMarca" ).show();
        valid = false;
    }else{
    	$( "#errorMarca" ).hide();
    }

    if ($('#productos').val() == '') {
    	$( "#errorProducto" ).show();
         valid = false;
    }else{
    	$( "#errorProducto" ).hide();
    }    
    
    if ($('#presentacion').val() == '') {
    	$( "#errorPresentacion" ).show();
         valid = false;
    }else{
    	$( "#errorPresentacion" ).hide();
    }    
    
    if ($('#cantidad').val() == '') {
    	$( "#errorCantidad" ).show();
         valid = false;
    }else{
    	$( "#errorCantidad" ).hide();
    }    
	
    if(valid){
    	createProduct();
    }
    
}


function createProduct(){
	producto = $('#presentacion').find(":selected").data("value");
	 cantidad = $('#cantidad').val();


	 producto.precioTotal = producto.precio * cantidad;
	 producto.cantidad = cantidad;
	 productos.push(producto);
	 
	 $("#marcas").val($("#marcas option:first").val());
	 
	 var tempOption = "<option disabled='disabled' selected='selected' value=''>--seleccione un producto--</option>";
	 $('#presentacion').html(tempOption);
	 
	 tempOption = "<option disabled='disabled' selected='selected' value=''>--seleccione una marca--</option>";
	 $('#productos').html(tempOption);
	 
	 $('#productosList').val(encodeURIComponent(JSON.stringify(productos)));
	 
	 $('#cantidad').val('');
	 
	 $("div").removeClass("hidden");
	 
	 buildTable();
}

var productos = [];

function buildTable(){
	 html = '<div class="table-responsive"> '+
		 	'<table class="table table-striped ">'+
				'<tr>'+
					'<th>Producto</th>'+
					'<th>Marca</th>'+
					'<th>Presentacion</th>'+
					'<th>Unitario</th>'+
					'<th>Cantidad</th>'+
					'<th>Total</th>'+
					'<th></th>'
				'</tr>';
	  
	 length = productos.length;
	 totalSum = 0;
	 for ( var i = 0; i < length; i++) {
		 totalSum+= productos[i].precioTotal;
		 html+= '<tr>'+
		 			'<td>'+productos[i].nombre+'</td>'+
		 			'<td>'+productos[i].marca+'</td>'+
		 			'<td>'+productos[i].presentacion+'</td>'+
		 			'<td> ₡ '+productos[i].precio+'</td>'+
		 			'<td>'+productos[i].cantidad+'</td>'+
		 			'<td> ₡ '+productos[i].precioTotal+'</td>'+
		 			'<td>'+
		 				'<button type="button" id="'+i+'" onClick="eliminar(this)" class="eliminar-producto btn btn-default">Eliminar</button>'+
	 				'</td>'+
		 		'<tr>'		
	 }
	 
	 html += '<tr>'+
	 			'<td></td>'+
	 			'<td></td>'+
	 			'<td></td>'+
	 			'<td></td>'+
	 			'<td></td>'+
	 			'<td>'+totalSum+'</td>'+
	 		'</tr>'+
 		'</table>'
	 html+='</div>'
	
				
	 $('#tbl-productos').html(html);
	 
	 
}

function eliminar(e){
	 id = $(e).attr("id");
	 productos.splice(id, 1);
	 buildTable();
}