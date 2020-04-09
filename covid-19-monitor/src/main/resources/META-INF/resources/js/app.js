$('#country').change(function(){
    sendRequest("/usa/historical/"+$(this).val(),"","GET");
})

function sendRequest(url, method) {
  $.ajax({
    url: url,
    async: false,
    
    success: function(response) {
      console.log("Successful");
//      let results = response.split(", ").map(Number);
      
      loadChart(response, $('#country').val);
    },
//    error: function(response) {
//      console.log("Error");

//    },
    error: function(xhr, textStatus, errorThrown){
    	console.log(xhr.responseText);
    },
    type: method,
    headers: {
      Accept: 'application/json;charset=utf-8',
      'Content-Type': 'text/plain'
    },
    dataType: 'text'
  });
 }




//------------------------------
// Chart to display predictions
//------------------------------
var chart = "";

function loadChart(dp, state) {
	var chart = new CanvasJS.Chart("chartContainer", {
		title:{
			text: "COVID-19 confirmed cases over time for " + state              
		},
		data: [              
		{
			// Change type to "doughnut", "line", "splineArea", etc.
			type: "column",
			dataPoints: dp
		}
		]
	});
	chart.render();
}

//----------------------------
// display chart with updated
// drawing from canvas
//----------------------------
function displayChart(data) {
	
}


