$(document).ready(function() {
    var entity = null;

    $('.entity').on('change', function() {
        entity = $(".entity").val();
        alert('data :'+entity);
        console.log(entity);
         $.ajax({
                    type: "GET",
                    url: "getStates?cid=" + entity,
                    success: function(response) {
                    alert('response:'+response);
                        $.each(response, function(stateId, stateName) {
                            $('<option>').val(stateId).text(stateName).appendTo("#stateEntity");
                        });
                    }
                });
    });
});

$(document).ready(function() {
    var stateEntity = null;

    $('.stateEntity').on('change', function() {
        stateEntity = $(".stateEntity").val();
        alert('data :'+stateEntity);
        console.log(stateEntity);
         $.ajax({
                    type: "GET",
                    url: "getCitys?sid=" + stateEntity,
                    success: function(response) {
                    alert('response:'+response);
                        $.each(response, function(cityId, cityName) {
                            $('<option>').val(cityId).text(cityName).appendTo("#cityEntity");
                        });
                    }
                });
    });
    
   
});