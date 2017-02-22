(function() {
  "use strict";
  var app = angular.module("autocomplete");
  var dbsearchController = function(SearchService, $scope) {
    var vm = this;
    vm.results = [];
    vm.name = "";
    vm.search = function() {
      SearchService.searchFromDB(vm.name).then(function(response){
        vm.results = response.data.length > 0 ? response.data : null;
      });
    }
    vm.add = function() {
      console.log("Nothing");
    }
  }
  app.controller("DBSearchController", dbsearchController);
})()
