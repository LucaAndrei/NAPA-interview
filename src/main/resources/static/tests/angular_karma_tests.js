describe('Ship factory', function() {
	var ShipFactory;
	beforeEach(angular.mock.module('myApp'));
	beforeEach(inject(function(_ShipFactory_) {
		ShipFactory = _ShipFactory_;
	}));

	it('should exist', function() {
		expect(ShipFactory).toBeDefined();
	})

	describe('.query()', function() {
		it('should exist', function() {
			expect(ShipFactory.query).toBeDefined();
		})
	})

});

describe('Ship Controller', function() {
	var $controller, ShipController, ShipFactory, scope;	

	beforeEach(angular.mock.module('myApp'));

	beforeEach(inject(function(_$controller_, $rootScope, _ShipFactory_) {
		scope = $rootScope.$new();
		ShipFactory = _ShipFactory_;
		$controller = _$controller_;

		spyOn(ShipFactory, 'query').andCallFake(function() {
			return [];
		});

		ShipController = $controller('ShipController', {
			$scope : scope,
			$ShipFactory : ShipFactory
		});
	}));

	// Verify our controller exists
	it('should be defined', function() {
		expect(ShipController).toBeDefined();
	});

	it('should initialize with a call to ShipFactory.query()', function() {
		expect(ShipFactory.query).toHaveBeenCalled();
	});
})