(function() {
  "use strict";
  var app = angular.module("autocomplete");
  var searchController = function(SearchService, $scope) {
    var vm = this;
    vm.results = [];
    vm.name = "";
    vm.search = function() {
      SearchService.search(vm.name).then(function(response){
        vm.results = response.data.length > 0 ? response.data : null;
      });
    }
    vm.add = function() {
      SearchService.add(vm.name).then(function(response){
        vm.search();
      })
    }
  }
  app.controller("SearchController", searchController);
})()
