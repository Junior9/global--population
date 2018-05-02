angular.module('iwa-main').controller('HomeController',function ($scope, $http,countryService){

	$scope.countries = {};
	$scope.country = {};
	$scope.dashbordLine = {};
	
	$http.get('country/basic/all')
	.success(function(data){	
		$scope.countries = data;
	})
	.catch(function(error){
		console.log(error)
	});	
	
	countryService.createDashBoardPopulationLine();
	countryService.createDashBoardPopulationPie();
	
	$scope.filterCountry = function(id){
		countryService.createDashBoardPopulationFilter(id)
	}
	
});