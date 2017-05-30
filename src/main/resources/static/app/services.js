(function(angular) {
	angular.module("myApp").factory("ShipFactory", ['$resource',function($resource) {
		console.log("ShipFactory")
		return $resource('/ships/:id', {
			id : '@id'
		}, {
			update : {
				method : "PUT"
			},
			remove : {
				method : "DELETE"
			}
		});
	}]);
}(angular));