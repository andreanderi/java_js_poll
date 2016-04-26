angular.module('poll.service').
service('VoteService',[ '$http', function($http) {
  
	var doRequest = function (voteNumber){
    	console.log("Post vote");
    	
    	
    	var req = {
    			 method: 'POST',
    			 url: 'api/vote',
    			 headers: {
    			   'Content-Type': 'application/json'
    			 },
    			 data: { 
    				 "name":"participante"+voteNumber,
    				 "number":voteNumber,
    				 "key":"for captcha" 
    			}
    	    }

    	    var response = $http(req);
    		return response;
    }
	
	return {
		events: doRequest
	};
    
}]);


