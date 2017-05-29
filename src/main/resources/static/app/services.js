(function(angular) {
	var ShipFactory = function($resource) {
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
	};

	ShipFactory.$inject = [ '$resource' ];
	angular.module("myApp").factory("ShipFactory", ShipFactory);
}(angular));