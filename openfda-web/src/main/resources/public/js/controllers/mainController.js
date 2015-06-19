
drugflowApp.controller('mainCtrl', ['$scope', 'drugsService', function ($scope, drugsService) {

  $scope.query ='';
  $scope.result = '';
  $scope.visibility = false;
  $scope.searchDrug = function() {
	  $scope.queryFailedMsg = '';
	  drugsService.getDrugInfo($scope.query).
	  	success(function(response){
	  		$scope.visibility = true;
			transformResponse(response);
		}).
		error(function(response){
			$scope.visibility = false;
			$scope.queryFailedMsg = "Drug not found";
		});
  };
  
  var transformResponse = function(response){
	  	var result = {};
	  	var labelInfo = {};
		for( key in response ) {
			if(key == 'name') result['name'] = response[key];
			else if(key == 'purpose') result['purpose'] = response[key];
			else if (response[key] !== null) {
				labelInfo[key] = response[key];
			}
		}
		result['labelInfo'] = labelInfo;	
		$scope.result = result;
		console.log(result);
  }
}]);

