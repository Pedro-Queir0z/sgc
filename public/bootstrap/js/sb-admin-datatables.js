// Call the dataTables jQuery plugin
$(document).ready(function() {
  $('.dataTable').DataTable(
		  {
			    "sEmptyTable":   "Nenhum registro encontrado",
			    "sProcessing":   "A processar...",
			    "sLengthMenu":   "Mostrar _MENU_ registos",
			    "sZeroRecords":  "Não foram encontrados resultados",
			    "sInfo":         "Mostrando de _START_ até _END_ de _TOTAL_ registos",
			    "sInfoEmpty":    "Mostrando de 0 até 0 de 0 registos",
			    "sInfoFiltered": "(filtrado de _MAX_ registos no total)",
			    "sInfoPostFix":  "",
			    "sSearch":       "Procurar:",
			    "sUrl":          "",
			    "oPaginate": {
			        "sFirst":    "Primeiro",
			        "sPrevious": "Anterior",
			        "sNext":     "Seguinte",
			        "sLast":     "Último"
			    },
			    "oAria": {
			        "sSortAscending":  ": Ordenar colunas de forma ascendente",
			        "sSortDescending": ": Ordenar colunas de forma descendente"
			    }
			}

	  language: {
	        processing:     "A processar...",
	        search:         "Buscar:",
	        lengthMenu:    "Afficher _MENU_ &eacute;l&eacute;ments",
	        info:           "Affichage de l'&eacute;lement _START_ &agrave; _END_ sur _TOTAL_ &eacute;l&eacute;ments",
	        infoEmpty:      "Affichage de l'&eacute;lement 0 &agrave; 0 sur 0 &eacute;l&eacute;ments",
	        infoFiltered:   "(filtr&eacute; de _MAX_ &eacute;l&eacute;ments au total)",
	        infoPostFix:    "",
	        loadingRecords: "Chargement en cours...",
	        zeroRecords:    "Aucun &eacute;l&eacute;ment &agrave; afficher",
	        emptyTable:     "Nenhum registro encontrado",
	        paginate: {
	            first:      "Primeiro",
	            previous:   "Anterior",
	            next:       "Próximo",
	            last:       "Último"
	        },
	  } 
  );
});
