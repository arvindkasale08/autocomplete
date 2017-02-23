(function() {
  "use strict";
  var app = angular.module("autocomplete");
  var searchController = function(SearchService, $scope) {
    var vm = this;
    vm.results = [];
    vm.name = "";
    vm.trie = "";
    vm.trieConstructTime = 0;
    vm.trieSearchTime = 0;
    vm.trie = true;
    vm.home = function() {
      var t0 = new Date().getTime();
      var t1;
      SearchService.home().then(function(response){
        vm.trie = response.data;
        t1 = new Date().getTime();
        vm.trieConstructTime = t1-t0;
      });
    }
    vm.home();

    vm.search = function() {
      var t0 = new Date().getTime();
      var t1;
      SearchService.search(vm.name).then(function(response){
        vm.results = response.data.length > 0 ? response.data : null;
        t1 = new Date().getTime();
        vm.trieSearchTime = t1-t0;
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
