angular.module('menu',[])
	.directive('mainMenu',function () {
		var  ddo = {};	
		ddo.restrict = 'AE';	
		ddo.scope = {
			perfil:'@perfil'
		};
		ddo.transclude = true;
		ddo.templateUrl ='public/js/directives/menu.html';
		return ddo;
	});