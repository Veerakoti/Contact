$(document).ready(function(event) {
$('#entity').change(function() {
$("#stateEntity").find('option').remove();
$('<option>').val('').text('-Select-').appendTo("#stateEntity");

$("#cityEntity").find('option').remove();
$('<option>').val('').text('-Select-').appendTo("#cityEntity");

var entity=$("#entity").val();
		$.ajax({
			type :"GET",
			url :"/getStates?cid="+ entity,
			success:function(response){
			$.each(response,function(stateId,stateName){
			$('<option>').val(stateId).text(stateName).appendTo("#stateEntity");
			});
		}
		});
});
