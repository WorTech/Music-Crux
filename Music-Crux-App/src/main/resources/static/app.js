
// Configure application

(function() {

	angular.module("molecule", []);
	angular.module("entity-search", ["ui.bootstrap"]);
	
	angular.module("musiccrux", ["molecule", "entity-search"])
	
})();