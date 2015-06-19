
drugflowApp.controller('mainCtrl', ['$scope', 'drugsService', function ($scope, drugsService) {
  $scope.labelName = "LABEL NAMEs";
  $scope.query ='';
  $scope.result = '';
  $scope.searchDrug = function() {
	  drugsService.getDrugInfo($scope.query).success(function(response){
			var result = {};
			var labelInfo = {};
			for( key in response ) {
				if(key == 'name') result['name'] = response[key];
				else if(key == 'purpose') result['purpose'] = response[key];
				else {
					labelInfo[key] = response[key];
				}
			}
			result['labelInfo'] = labelInfo;	
			$scope.result = result;
			console.log(result);
		});
  };
}]);

