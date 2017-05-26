(function(angular) {
	var AppController = function($scope, Ship) {
		Ship.query(function(response) {
			console.log("response", response);
			$scope.items = response ? response : [];
		});

		$scope.addItem = function(description) {
			new Ship({
				description : description,
				checked : false
			}).$save(function(item) {
				console.log("save item", item);
				$scope.items.push(item);
			});
			$scope.newItem = "";
		};

		$scope.updateItem = function(item) {
			item.$update();
		};

		$scope.deleteItem = function(item) {
			item.$remove(function() {
				$scope.items.splice($scope.items.indexOf(item), 1);
			});
		};
	};

	AppController.$inject = [ '$scope', 'Ship' ];
	angular.module("myApp.controllers").controller("AppController",
			AppController);
}(angular));