drugflowApp.service('drugsService', ['$http', function($http){
	var baseURL = '/api/drugs?name=';
	
	this.getDrugInfo = function(name){
		return $http.get(baseURL+name);		
	};
	
	
}]);
