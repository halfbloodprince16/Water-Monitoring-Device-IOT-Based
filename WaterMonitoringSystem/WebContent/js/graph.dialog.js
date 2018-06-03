function openGraph (titleText, graphData) {
	var $dialog = $("#graphDialogBox").dialog({
		title: titleText,
		autoOpen: false,
		modal: true,
		draggable: true,
		resizable: false,
		dialogClass: "graphClass",
	}).load("Pages/graph.container.html", function() {
		$dialog.find(".graphCloseButton").on("click", function(e) {
			$().dialog("destroy");
			$dialog.dialog("close");
			$dialog.dialog("destroy");
		});
		$dialog.dialog("open");
		$('.graphClass').css({'position': 'absolute', 'background-color': 'white', 'height': '100%', 'width': '100%', 'top': '0px', 'left': '0px'});
		loadGraph (graphData);
	});
}

function loadGraph (graphData) {
	var xAxisLabels = [];
	var tempratures = [];
	var phs = [];
	
	for (i = 0; i < graphData.length; i++) {  
		xAxisLabels[i] = graphData[i].time;
		tempratures[i] = graphData[i].temprature;
		phs[i] = graphData[i].pH;
	}
	var config = {
		type: 'line',
		data: {
			labels: xAxisLabels,
			datasets: [{
				label: 'Temprature',
				backgroundColor: window.chartColors.red,
				borderColor: window.chartColors.red,
				data: tempratures,
				fill: false,
			}, {
				label: 'PH',
				fill: false,
				backgroundColor: window.chartColors.blue,
				borderColor: window.chartColors.blue,
				data: phs,
			}]
		},
		options: {
			responsive: true,
			title: {
				display: true,
				text: 'Temprature and PH v/s time chart'
			},
			tooltips: {
				mode: 'index',
				intersect: false,
			},
			hover: {
				mode: 'nearest',
				intersect: true
			},
			scales: {
				xAxes: [{
					display: true,
					scaleLabel: {
						display: true,
						labelString: 'Month'
					}
				}],
				yAxes: [{
					display: true,
					scaleLabel: {
						display: true,
						labelString: 'Temprature and PH'
					}
				}]
			}
		}
	};

		var ctx = document.getElementById('canvas').getContext('2d');
		window.myLine = new Chart(ctx, config);
}