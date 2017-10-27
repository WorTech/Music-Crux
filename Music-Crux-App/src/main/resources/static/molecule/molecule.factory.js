(function(){
	
	angular
		.module("molecule")
		.factory("moleculeData", function($http) {
			
			var getAllMolecules = function() {
				return $http.get("/api/molecules");
			};
			
			return {
				getAllMolecules: getAllMolecules
			};
		});
	
})();