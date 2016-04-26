angular.module('poll.service').
service('ScoreService',[ '$http', function( $http) {

    console.log("Score Service");
    var response = $http.get('api/total');
    
    return response;
}]);
