angular.module('poll.controller').
controller('VoteController',[ '$scope', 'VoteService',  function($scope, VoteService) {

    console.log("Vote Controller");
    
    $(document).ready(function () {
        $("select").imagepicker();   
        console.log("image picker ready!");
    });

    $scope.voteNow = function(){
    	console.log('Vote Event!');
    	var voteNumber = $("#selectImage").val();
    	
    	console.log('Option number: '+voteNumber);
    	
    	 VoteService.events(voteNumber)
    	 .success(function(data,voteNumber) {
    			console.log("of items: " + data.length)
    	 });
    }
    
}]);
