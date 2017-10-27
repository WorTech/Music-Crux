(function() {

	angular
		.module("molecule")
		.controller("moleculeCtrl", function($scope, moleculeData) {

			var vm = this;
			vm.data = undefined;

			vm.refresh = function() {

				moleculeData.getAllMolecules()
					.then(function(response) {
						vm.data = response.data;
					})
					.catch(function(reason) {
						console.log("Error getting molecules: " + reason.data.message);
					})

			};

			$scope.$watch("vm.data", function(data) {
				
				if (!data) return;
				
				console.log(data);
				molecule.nodes(data.entities);
				molecule.force("link", d3.forceLink(data.relationships));
			});

			var molecule = d3.forceSimulation();
			molecule.force("center", d3.forceCenter(250, 250));
			molecule.force("charge", d3.forceManyBody());
			molecule.on("tick", function() {
				$scope.$digest();
			});

			vm.refresh();

		});

})();
