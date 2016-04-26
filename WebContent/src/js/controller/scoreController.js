angular.module('poll.controller').
controller('ScoreController',[ '$scope', 'ScoreService', function($scope, ScoreService) {

    console.log("Score Controller");

    ScoreService
        .success(function(data) {

        	var player = {};
        	var percentage = {};
        	var total = 0;
        	var voted;
        	
        	for (i = 0; i < data.length; i++) { 
        		console.log("name : " + data[i]._id);
        	    console.log("count : " + data[i].count);
        	    
        	    player[ data[i]._id] = data[i].count        	  
        	    total = data[i].count + total;
        	}

        	percentage ["participante1"] = Math.floor((player["participante1"] *100)/total);
        	percentage ["participante2"] = 100 - percentage ["participante1"];
        	
        	$scope.player = player;
        	$scope.percentage = percentage;
        	
            })
        .error(function(data){});
}]);

