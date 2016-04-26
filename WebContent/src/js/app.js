'use strict';

angular.module('poll', ['poll.controller', 'poll.service', 'ui.router']).
    config(['$urlRouterProvider', '$stateProvider', function ($urlRouterProvider,  $stateProvider) {
      
    	$urlRouterProvider.otherwise('/vote');
        $stateProvider
        .state('vote', {
            url: "/vote",
            templateUrl: "src/html/vote.html",
            controller: "VoteController"
          })
          .state('score', {
            url: "/score",
            templateUrl: "src/html/score.html",
            controller: "ScoreController"
          }) 
    }]);


angular.module('poll.service',[]);
angular.module('poll.controller',[]);
