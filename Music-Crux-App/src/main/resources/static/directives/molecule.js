(function() {
	angular.module("molecule", []).directive("molecule", function() {
		return {
			restrict: "E",
			templateUrl: "directives/molecule-template.html",
			controller: function($scope, $http) {
				this.refresh = function() {
					$http.get("/api/molecules").then(function(response) {
						$scope.data = response.data;
					});
				}
				
				$scope.$watch("data", function(data) {
					if(!data) return;
					
					molecule.nodes(data.entities);
					molecule.force("link", d3.forceLink(data.relationships));
				});
				
				var molecule = d3.forceSimulation();
				molecule.force("center", d3.forceCenter(250, 250));
				molecule.force("charge", d3.forceManyBody());
				molecule.on("tick", function() {
					$scope.$digest();
				});
				
				this.refresh();
			}
		}
	});
})();