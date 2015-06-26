drugflowApp.controller('mainCtrl', ['$scope', '$q','drugsService', 'smoothScroll','$timeout', function ($scope, $q, drugsService, smoothScroll, $timeout) {

  $scope.query ='';
  $scope.result = '';
  $scope.infoVisibility = false;
  $scope.loadingVisibility = false;
  $scope.searchBarVisibility = true;
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
	  inactive: "Inactive Ingredients",
	  warnings: "Warnings",
	  askDoctorOrPharmacist: "Ask Doctor or Pharmacist",
	  stopUse: "Stop Use",
	  manufacturerName : "Manufacturer",
	  events: "Adverse Reaction"
  };
  
$scope.labelHeight = {
	  indicationsAndUsage : 0,
	  brandName : 0,
	  genericName : 0,
	  purpose : 0,
	  active : 0,
	  adverseReactions: 0,
	  askDoctor: 0,
	  doNotUse: 0,
	  dosage: 0,
	  inactive: 0,
	  warnings: 0,
	  askDoctorOrPharmacist: 0,
	  stopUse: 0,
	  manufacturerName : 0,
	  events: 0
};

  $scope.readMore = function(elem) {
  	$scope.labelHeight[elem]
  	var height = $("#labeling-"+elem+"-label").height();
  };

  $scope.searchDrug = function() {
	  $scope.queryFailedMsg = '';
	  $scope.loading = true;
	  $scope.searchBarVisibility = false;
	  
	  drugsService.getDrugInfo($scope.query)
	    .then(
	        function success1(response) {
	            transformResponse(response.data);
	            return drugsService.getDrugAdverseEvents(response.data['productNdc']);
	        },
	        function error1(response) {
	            return $q.reject(response);
	        }
	    )
	    .then(
	        function success2(response) {
	        	console.log(response.data);
	        	$scope.events = transformTo2DArray(response.data);
		  		$scope.infoVisibility = true;
	  			$scope.scroll = true;
	  			$scope.loading = false;
	  			$scope.searchBarVisibility = true;
	  			$timeout(function(){
	  				plotAdverse('adversePlot',$scope.events);
	  		  	});
	        },
	        function error2(response) {
	        	requestErrorHandler(response.status);
	        }
	    );
	  $scope.scroll = false;
  };
  

  function requestErrorHandler(status){
	    $scope.infoVisibility = false;
		$scope.loading = false;
		$scope.searchBarVisibility = true;
		switch(status){
			case 404:
				$scope.queryFailedMsg = "Drug not found";
				break;
			default:
				$scope.queryFailedMsg = "There was an unknown error. Please try again later.";
				break;
		}
  }
   
  function transformResponse(response){
	  	var result = {};
	  	var labelInfo = {};
	  	var warnings = {};
		for( key in response ) {
			if($scope.headers[key]){
				if(key == 'brandName') 
					result['name'] = response[key];
				else if(key == 'purpose') 
					result['purpose'] = response[key];
				else if(key == 'warnings' || key == 'doNotUse' || key == 'askDoctor' || key == 'askDoctorOrPharmacist'){
					if(response[key] != null){
						warnings[key] = response[key];
					}
				}
				else if (response[key] != null && key != 'notFound' ) 
					labelInfo[key] = response[key];
			}
		}
		result['labelInfo'] = labelInfo;
		result['warnings'] = warnings;
		$scope.result = result;
  }	
  
  function transformTo2DArray(obj){
	  var array = [];
	  for(key in obj){
		  var data = [];
		  data.push(key);
		  data.push(obj[key]);
		  array.push(data);
	  }
	  return array;
  }
/*
  $scope.$on('finishedRender',function(finishedRenderEvent){
  	console.log('ello');
  	console.log($scope.events);
 	plotAdverse('adversePlot',$scope.events);
  });
*/
}]);

