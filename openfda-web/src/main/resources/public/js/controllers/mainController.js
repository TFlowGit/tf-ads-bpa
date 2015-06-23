
drugflowApp.controller('mainCtrl', ['$scope', 'drugsService', 'smoothScroll', function ($scope, drugsService, smoothScroll) {

  $scope.query ='';
  $scope.result = '';
  $scope.infoVisibility = false;
  $scope.scroll = false;
  $scope.headers = {
	  indicationsAndUsage :"Indication and Usage",
	  brandName : "Brand Name",
	  genericName : "Generic Name",
	  purpose : "Purpose",
	  active : "Active Ingredients",
	  adverseReactions: "Adverse Reactions",
	  askDoctor: "Ask Doctor",
	  doNotUse: "Do Not Use",
	  dosage: "Dosage",
	  inactive: "Inactive Ingrdients",
	  warnings: "Warnings",
	  askDoctorOrPharmacist: "Ask Doctor or Pharmacist",
	  stopUse: "Stop Use",
	  manufacturerName : "Manufacturer"
  };
  
  $scope.searchDrug = function() {
	  $scope.queryFailedMsg = '';
	  drugsService.getDrugInfo($scope.query)
		  .success(function(response){
			  	$scope.infoVisibility = true;
	  			$scope.scroll = true;
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
	  $scope.scroll = false;
  };
  
  function transformResponse(response){
	  	console.log(response);
	  	var result = {};
	  	var labelInfo = {};
	  	var warnings = {};
		for( key in response ) {
			if(key == 'brandName') 
				result['name'] = response[key];
			else if(key == 'purpose') 
				result['purpose'] = response[key];
			else if(key == 'warnings' || key == 'doNotUse' || key == 'askDoctor' || key == 'askDoctorOrPharmacist'){
				if(response[key] != null){
					warnings[key] = response[key];
				}
			}
			else if (response[key] !== null && key !== 'notFound') 
				labelInfo[key] = response[key];
		}
		result['labelInfo'] = labelInfo;
		result['warnings'] = warnings;
		$scope.result = result;
		console.log(result);
		//console.log(result);
  }	
}]);

