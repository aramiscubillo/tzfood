$( document ).ready(function() {

	 $.validate({
	    validateOnBlur : false, // disable validation when input looses focus
	    scrollToTopOnError : false // Set this property to true on longer forms
	  });
	
	
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

	 
	 
	 
	 $('#productos').change(
		        function() {
		        	var pathname = window.location.pathname;
		            $.getJSON("/producto/getByNombre", {
		            	nombre : $(this).val(),
		                ajax : 'true'
		            }, function(data) {
		                var html = '<option value="">--seleccione una presentación--</option>';
		                var len = data.length;
		                
		                for ( var i = 0; i < len; i++) {
		                	
		                	var stringObject = JSON.stringify(data[i]);
		                	
		                	
		                    html += '<option data-value=\'' + stringObject +'\'>'
		                            + data[i].presentacion + '</option>';
		                }
		                html += '</option>';
		                $('#presentacion').html(html);
		            });
    	});

	 
	 $( "#btnAgregar" ).click(function() {
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
	});
	 
		
});

var productos = [];

function buildTable(){
	 html = '<table class="table table-striped">'+
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
		 			'<td>'+productos[i].precio+'</td>'+
		 			'<td>'+productos[i].cantidad+'</td>'+
		 			'<td>'+productos[i].precioTotal+'</td>'+
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
	 		'</tr>'
	 html+='</table>'
		 
	
				
	 $('#tbl-productos').html(html);
	 
	 
}

function eliminar(e){
	 id = $(e).attr("id");
	 productos.splice(id, 1);
	 buildTable();
}