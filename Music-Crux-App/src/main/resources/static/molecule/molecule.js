(function() {
	angular
	.module("molecule")
	.directive("molecule", function() {
		return {
			restrict: "E",
			templateUrl: "/molecule/molecule.html",
			controller: function($scope, $http) {
				//setup the molecule
				var molecule = d3.forceSimulation();
				molecule.force("center", d3.forceCenter(250, 250));
				molecule.force("charge", d3.forceManyBody());
				molecule.on("tick", function() {
					//kick angular so it will animate the molecule
					$scope.$digest();
				});
				
				//re-focus on seleciton events
				$scope.$on("selection", function(event, entity) {
					$http.get("/api/molecule", {
						params: {
							focus: entity.id,
							depth: 2
						}
					}).then(function(response) {						
						$scope.data = response.data;
					});
				});
				
				//kick d3 when the data changes
				$scope.$watch("data", function(data) {
					if(!data) return;
					
					molecule.nodes(data.entities);
					molecule.force("link", d3.forceLink(data.relationships));
					molecule.alpha(1).restart();
				});
			}
		}
	});
})();