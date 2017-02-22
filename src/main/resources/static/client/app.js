(function() {
  "use strict";
  var app = angular.module("autocomplete",["ui.router","ngResource"]);

  app.config(["$stateProvider","$urlRouterProvider",function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/");

    $stateProvider.state("home",{
      url : "/",
      views:{
        "header" : {templateUrl : "client/views/header.html"},
        "body" : {templateUrl : "client/views/home.html", controller : "SearchController as vm"},
        "footer" : {templateUrl : "client/views/footer.html"}
      }
    });

    $stateProvider.state("db",{
      url : "/db",
      views:{
        "header" : {templateUrl : "client/views/header.html"},
        "body" : {templateUrl : "client/views/home.html", controller : "DBSearchController as vm"},
        "footer" : {templateUrl : "client/views/footer.html"}
      }
    });

  }]);
})();
