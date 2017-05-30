(function(angular) {

	angular.module("myApp").controller("ShipController", ['$scope', 'ShipFactory', function($scope, ShipFactory) {
		$scope.minTonnage = 0;
		$scope.maxTonnage = 1000;
		$scope.markers = [];
		var limitSet = false;

		$scope.slider = {
			options : {
				floor : $scope.minTonnage,
				ceil : $scope.maxTonnage,
				step : 10,
				id : 'mySlider',
				onEnd : function(sliderId, modelValue, highValue, pointerType) {
					// console.log('on end sliderId ' + sliderId); // logs 'on
					// start slider-id'
					// console.log('on end modelValue ' + modelValue); // logs
					// 'on start slider-id'
					// console.log('on end highValue ' + highValue); // logs 'on
					// start slider-id'
					// console.log('on end pointerType ' + pointerType); // logs
					// 'on start slider-id'
					$scope.sliderMinValue = modelValue;
					$scope.sliderMaxValue = highValue;
					updateMarkers($scope.items);
				}
			}
		};

		var icons = {
			'cargo' : {
				type : 'div',
				iconSize : [ 10, 10 ],
				className : 'cargoMarker',
				iconAnchor : [ 5, 5 ]
			},
			'tanker' : {
				type : 'div',
				iconSize : [ 10, 10 ],
				className : 'tankerMarker',
				iconAnchor : [ 5, 5 ]
			},
			'passengers ship' : {
				type : 'div',
				iconSize : [ 10, 10 ],
				className : 'passengersMarker',
				iconAnchor : [ 5, 5 ]
			},
			'high speed craft' : {
				type : 'div',
				iconSize : [ 10, 10 ],
				className : 'highSpeedMarker',
				iconAnchor : [ 5, 5 ]
			},
			'fishing' : {
				type : 'div',
				iconSize : [ 10, 10 ],
				className : 'fishingMarker',
				iconAnchor : [ 5, 5 ]
			},
			'sailing vessel' : {
				type : 'div',
				iconSize : [ 10, 10 ],
				className : 'sailingMarker',
				iconAnchor : [ 5, 5 ]
			}
		}

		ShipFactory.query(function(response) {
			console.log("response", response);
			$scope.items = response ? response : [];
			var grossTonnages = _.map(response, function(value) {
				return value.grossTonnage;
			})
			var minT = _.min(grossTonnages);
			var maxT = _.max(grossTonnages);
			$scope.minTonnage = minT;
			$scope.maxTonnage = maxT;
			if (!limitSet) {
				limitSet = true;
				$scope.sliderMinValue = minT;
				$scope.sliderMaxValue = maxT;
				$scope.slider.options.floor = $scope.minTonnage;
				$scope.slider.options.ceil = $scope.maxTonnage;
			}
			updateMarkers($scope.items);
		});

		var overlays = {
			'cargo' : {
				type : 'group',
				name : 'Cargo Vessels',
				visible : true
			},
			'tanker' : {
				type : 'group',
				name : 'Tankers',
				visible : true
			},
			'passengers ship' : {
				type : 'group',
				name : 'Passenger Vessels',
				visible : true
			},
			'high speed craft' : {
				type : 'group',
				name : 'High Speed Craft',
				visible : true
			},
			'fishing' : {
				type : 'group',
				name : 'Fishing',
				visible : true
			},
			'sailing vessel' : {
				type : 'group',
				name : 'Sailing vessels',
				visible : true
			}
		}

		$scope.layers = {
			baselayers : {
				openStreetMap : {
					name : 'OpenStreetMap',
					type : 'xyz',
					url : 'http://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png'
				}
			},
			overlays : overlays
		}

		function updateMarkers(items) {
			console.log("updateMarkers", items);
			$scope.markers = []; // clear the array
			_.forEach(items, function(value) {
				var myObj = {
					lat : value.latitude,
					lng : value.longitude,
					icon : icons[value.shipClass],
					layer : value.shipClass,
					message : value.name,
				}
				if (value.grossTonnage > $scope.sliderMinValue
						&& value.grossTonnage < $scope.sliderMaxValue) {
					$scope.markers.push(myObj);
				}
			})
			console.log("$scope.markers", $scope.markers)
		}
	}]);
}(angular));