(function() {

	angular
		.module("molecule")
		.directive("molecule", function() {
			return {
				restrict : "E",
				templateUrl : "/molecule/molecule.template.html",
				controller : "moleculeCtrl",
				controllerAs: "vm"
			};
		})

})();