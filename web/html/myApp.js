var app = angular.module('myApp', []);

app.controller('myCtrl', function ($scope, $http) {

    this.sendPost = function () {
        $http.get("http://localhost:8080/html/AddLevel").then(function (response) {
            alert("Controller Hit" + response);
        });
    }
    
});