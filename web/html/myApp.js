var app = angular.module('myApp', []);

app.controller('myCtrl', ['$scope', '$http', function ($scope, $http){

    this.sendGet = function () {
        $http.get("http://localhost:8080/html/AddLevel").then(function (response) {
            alert("Controller Hit" + response.toString());
        });
    }

    this.sendPost = function () {
        $http.post("http://localhost:8080/html/AddLevel", "Stuff").success(function (response) {

            alert("Controller Hit " + data + " " + status);
        });
    }

    this.getDataFromServer = function() {

        $http({
            method : 'POST',
            url : 'http://localhost:8080/html/AddLevel',
        }).success(function(response) {
            var data = angular.fromJson(response);
            $scope.parsedData = data;

            $scope.levelOneID = data.levelOneID;
            $scope.listingName = data.listingName;
            $scope.listingDescription = data.listingDescription;
            $scope.versionID = data.versionID;
            $scope.bookName = data.bookName;
            $scope.pageNumber = data.pageNumber;

            $scope.response = response;

            alert(response);
        }).error(function(data, status, headers, config) {
            // called asynchronously if an error occurs
            // or server returns response with an error status.
        });

    };


}]);