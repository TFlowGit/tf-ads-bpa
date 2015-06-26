drugflowApp.controller('mainCtrl', ['$scope', '$q','drugsService', 'smoothScroll','$timeout', function ($scope, $q, drugsService, smoothScroll, $timeout) {
  $scope.events = [];
  $scope.totalEvents;
  $scope.query ='';
  $scope.result = '';
  $scope.infoVisibility = false;
  $scope.loadingVisibility = false;
  $scope.searchBarVisibility = true;
  $scope.scroll = false;
  $scope.didInitialLoad = false;
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
  
  $scope.eventLabels = [{key: 'hospitialization', label:'Hospitalizations'}, 
                        {key: 'congenitalAnomali', label:'Congenital Anomalies'},
                        {key: 'disabling', label:'Disabling'}, 
                        {key: 'lifeThreatening', label:'Life Threatening'}, 
                        {key: 'death', label:'Deaths'}, 
                        {key: 'other', label:'Other'}] 
            
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
	  $scope.searchBarVisibility = false;
	  if ($scope.didInitialLoad) {
	  	$("#bs-example-navbar-collapse-1").collapse('hide');
	  	$scope.loadOverlay = true;
	  } else {
	  	$scope.loading = true;
	  }
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
	        	$scope.totalEvents = response.data.total;
	        	$scope.events = transformTo2DArray(response.data);
		  		$scope.infoVisibility = true;
	  			$scope.scroll = true;
	  			$scope.loading = false;
	  			$scope.searchBarVisibility = true;
	  			$timeout(function(){
	  				plotAdverse('adversePlot',$scope.events);
	  		  	});
	  			$scope.loadOverlay = false;
	        },
	        function error2(response) {
	        	requestErrorHandler(response.status);
	        }
	    );
	  $scope.scroll = false;
	  $scope.didInitialLoad = true;
  };
  

  function requestErrorHandler(status){
	    $scope.infoVisibility = false;
		$scope.loading = false;
		$scope.loadOverlay = false;
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
	  for(var i=0; i<$scope.eventLabels.length; i++){
		  var data = [];
		  data.push($scope.eventLabels[i].label);
		  data.push(obj[$scope.eventLabels[i].key]);
		  array.push(data);
	  }
	  return array;
  }
}]);

