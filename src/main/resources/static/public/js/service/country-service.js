angular.module('countryService', ['ngResource'])
.factory('countryService', function($resource,$q,$http) {
	var service = {};
	
	service.createDashBoardPopulationLine = function(){
		$http.get('country/all')
		.success(function(data){	
			service.createDashbordLine(data);
		})
		.catch(function(error){
			console.log(error)
		});	
	}
	
	service.createDashBoardPopulationPie = function(){
		$http.get('country/all/pie')
		.success(function(data){	
			service.createDashbordPie(data);
		})
		.catch(function(error){
			console.log(error)
		});	
	}

	service.createDashBoardPopulationFilter = function(id){
		$http.get('country/'+id)
		.success(function(data){	
			service.createDashbordLine(data);
		})
		.catch(function(error){
			console.log(error)
		});	
	}
	
	service.createDashbordLine = function(data){
		Highcharts.chart('dashboardWorldPopulation', {
		    title: {
		        text: data.title
		    },
		    subtitle: {
		        text: data.subTitle
		    },
		    xAxis: {
		        categories: data.categories
		    },
		    yAxis: {
		        min: 0,
		        title: {
		            text: 'Population'
		        }	
		    },
		    series: [{
		        data: data.series 
		    }]
		});
	}
	
	service.createDashbordPie = function(data){
		Highcharts.chart('dashboardWorldPopulationPie', {
		    chart: {
		        plotBackgroundColor: null,
		        plotBorderWidth: null,
		        plotShadow: false,
		        type: 'pie'
		    },
		    title: {
		        text: data.title
		    },
		    tooltip: {
		        pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
		    },
		    plotOptions: {
		        pie: {
		            allowPointSelect: true,
		            cursor: 'pointer',
		            dataLabels: {
		                enabled: true,
		                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
		                style: {
		                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
		                }
		            }
		        }
		    },
		    series: [{
		        name: 'Brands',
		        colorByPoint: true,
		        data: data.data
		    }]
		});
	}
	
	return service;
});	