var oldFunction = jQuery.fn.DataTable.ext.type.search.string;

jQuery.fn.DataTable.ext.type.search.string = function(data) {
	return neutraliseAccent(data);
}; 

function neutraliseAccent(data){
	data = oldFunction(data);
	return ! data ?
	        '' :
	        typeof data === 'string' ?
	            data
	            .replace( /Á/g, 'A' )
                .replace( /É/g, 'E' )
                .replace( /Í/g, 'I' )
                .replace( /Ó/g, 'O' )
                .replace( /Ú/g, 'U' ):
	    data;	
}

//Sigue sin funcionar
$.fn.dataTableExt.ofnSearch = function(data){
	debugger;
	return neutraliseAccent(data);
}
