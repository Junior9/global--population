angular.module('iwa-main', ['ngRoute','ngResource','countryService'])
.config(function($routeProvider,$locationProvider) {
	
	 $routeProvider.when('/home', {
         templateUrl: 'public/partials/iwa-home.html',
         controller: 'HomeController'
     });	 
	 //$routeProvider.otherwise({redirectTo:'/home'});
});