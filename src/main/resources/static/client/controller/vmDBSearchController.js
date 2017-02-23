(function() {
  "use strict";
  var app = angular.module("autocomplete");
  var dbsearchController = function(SearchService, $scope) {
    var vm = this;
    vm.results = [];
    vm.name = "";
    vm.dbSearchTime = 0;
    vm.db = true;
    vm.search = function() {
      var t0 = new Date().getTime();
      var t1;
      SearchService.searchFromDB(vm.name).then(function(response){
        vm.results = response.data.length > 0 ? response.data : null;
        t1 = new Date().getTime();
        vm.dbSearchTime = t1-t0;
      });
    }
    vm.add = function() {
      console.log("Nothing");
    }
  }
  app.controller("DBSearchController", dbsearchController);
})()
