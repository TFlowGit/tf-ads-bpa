
drugflowApp.controller('mainCtrl', ['$scope', 'drugsService', 'smoothScroll', function ($scope, drugsService, smoothScroll) {

  $scope.query ='';
  $scope.result = '';
  $scope.infoVisibility = false;
  $scope.searchDrug = function() {
	  $scope.queryFailedMsg = '';
	  drugsService.getDrugInfo($scope.query)
		  .success(function(response){
		  		$scope.infoVisibility = true;
				transformResponse(response);
		  })
		  .error(function(data, status, headers, config){
				$scope.infoVisibility = false;
				
				switch(status){
					case 404:
						$scope.queryFailedMsg = "Drug not found";
						break;
					default:
						$scope.queryFailedMsg = "There was an unknown error. Please try again later.";
						break;
				}
		  });
  };
  
  function transformResponse(response){
	  	//console.log(response);
	  	var result = {};
	  	var labelInfo = {};
	  	var warnings = {};
		for( key in response ) {
			if(key == 'name') 
				result['name'] = response[key];
			else if(key == 'purpose') 
				result['purpose'] = response[key];
			else if(key == 'warnings' || key == 'doNotUse' || key == 'askDoctor' || key == 'askDoctorOrPharmacist')
				warnings[key] = response[key];
			else if (response[key] !== null && key !== 'notFound') 
				labelInfo[key] = response[key];
		}
		result['labelInfo'] = labelInfo;

		// if (key == 'active') key = 'ActiveIngredients';
		// if(key == 'active') result['active'] = 'Active Ingredients';

		result['warnings'] = warnings;

		$scope.result = result;
		console.log(result);
  }
  
  
	
		
}]);

