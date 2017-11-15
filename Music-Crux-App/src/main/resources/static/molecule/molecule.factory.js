(function(){
	
	angular
		.module("molecule")
		.factory("moleculeData", function($http) {
			
			var getAllMolecules = function() {
				return $http.get("/api/entity");
			};
			
			return {
				getAllMolecules: getAllMolecules
			};
		});
	
})();