(function() {
  "use strict";
  var app = angular.module("autocomplete");
  var searchService = function($http) {
    function search(name) {
      name = name === undefined ? "" : name;
      var url = "/search?name="+name;
      return $http.get(url);
    }

    function searchFromDB(name) {
      var url = "/search/db?name="+name;
      return $http.get(url);
    }

    function add(name) {
      var url = "/search/add?name="+name;
      return $http.get(url);
    }

    function home() {
      var url = "/home";
      return $http.get(url);
    }

    return {
      search : search,
      add : add,
      searchFromDB : searchFromDB,
      home : home
    }
  }
  app.service("SearchService", ["$http", searchService]);
}());
