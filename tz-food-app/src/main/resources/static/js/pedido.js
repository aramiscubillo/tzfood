$( document ).ready(function() {

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
		 //$("#marcas option:first-child").attr("selected", true);
		
		 
		 var tempOption = "<option disabled='disabled' selected='selected' value=''>--seleccione un producto--</option>";
		 $('#presentacion').html(tempOption);
		 
		 tempOption = "<option disabled='disabled' selected='selected' value=''>--seleccione una marca--</option>";
		 $('#productos').html(tempOption);
		 
		 $('#productosList').val(encodeURIComponent(JSON.stringify(productos)));

		 buildTable();
	});
	 
		
});

var productos = [];

function buildTable(){
	 html = '<table>'+
				'<tr>'+
					'<th>Producto</th>'+
					'<th>Marca</th>'+
					'<th>Presentacion</th>'+
					'<th>Precio unitario</th>'+
					'<th>Cantidad</th>'+
					'<th>Precio Total</th>'+
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