angular.module('header',[])
	.directive('mainHeader',function () {
		var  ddo = {};	
		ddo.restrict = 'AE';		
		ddo.scope = {
			perfil:'@perfil'
		};
		ddo.transclude = true;
		ddo.templateUrl ='public/js/directives/header.html';
		return ddo;
	});