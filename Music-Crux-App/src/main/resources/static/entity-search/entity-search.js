(function() {
	angular
	.module("entity-search")
	.directive("entitySearch", function() {
		return {
			restrict : "E",
			templateUrl : "/entity-search/entity-search.html",
			controller: function($scope, $http) {
				
				//find by name
				$scope.findEntities = function(query) {
					return $http.get("/api/entity", {
						params: {
							name: query,
							limit: 10
						}
					}).then(function(response) {
						return response.data;
					})
				}
				
				//broadcast when we pick something
				$scope.select = function(entity) {
					$scope.$root.$broadcast("selection", entity);
					$scope.selection = undefined;
				}
			}
		}
	});
})();