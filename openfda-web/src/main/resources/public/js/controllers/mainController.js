
drugflowApp.controller('mainCtrl', ['$scope', 'drugsService', function ($scope, drugsService) {

  $scope.query ='';
  $scope.result = '';
  $scope.infoVisibility = false;
  $scope.searchDrug = function() {
	  $scope.queryFailedMsg = '';
	  drugsService.getDrugInfo($scope.query).
	  	success(function(response){
	  		// implement scroll to labeling section
	  		// $('html, body').animate({
	  		// 	scrollTop: $("#labeling").offset().scrollTop
	  		// }, 2000);
	  		$scope.infoVisibility = true;
			transformResponse(response);
		}).
		error(function(data, status, headers, config){
			$scope.infoVisibility = false;
			$scope.queryFailedMsg = "Drug not found";
		});
  };
  
  var transformResponse = function(response){
	  	var result = {};
	  	var labelInfo = {};
		for( key in response ) {
			if(key == 'name') result['name'] = response[key];
			else if(key == 'purpose') result['purpose'] = response[key];
			else if (response[key] !== null && key !== 'notFound' ) {
				labelInfo[key] = response[key];
			}
		}
		result['labelInfo'] = labelInfo;	
		$scope.result = result;
		console.log(result);
  }
}]);

