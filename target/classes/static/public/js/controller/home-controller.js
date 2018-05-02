angular.module('iwa-main').controller('HomeController',function ($scope, $http,countryService){

	$scope.country = {};
	$scope.dashbordLine = {};
	
	countryService.createDashBoardPopulationLine();
	countryService.createDashBoardPopulationPie();
	
	$scope.filterCountry = function(id){
		countryService.createDashBoardPopulationFilter(id)
	}
	
});