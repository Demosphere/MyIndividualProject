var app = angular.module('myApp', ['ui.bootstrap']);

app.filter('unsafe', function($sce) { return $sce.trustAsHtml; });

app.controller('myCtrl', ['$scope', '$http', function ($scope, $http) {

    $scope.clientLevel = {};
    var baseURL = 'http://localhost:8080/html/';

    $scope.sendLevelOne = function (method) {

        if ($scope.children == "True") {
            $http({
                method: method,
                url: baseURL + 'Level/One',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelOneID': 0,
                    'listingName': $scope.clientLevel.name,
                    'listingDescription': '',
                    'versionID': 0,
                    'bookName': '',
                    'pageNumber': 0,
                    'levelTwo' : []
                }
            }).success(function (response) {
                var data = angular.fromJson(response);
                $scope.parsedData = data;
            }).error(function (response) {
                alert("Error: " + response);
            });
        } else {
            $http({
                method: method,
                url: baseURL + 'Level/One',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelOneID': 0,
                    'listingName': $scope.clientLevel.name,
                    'listingDescription': $scope.clientLevel.description,
                    'versionID': 0,
                    'bookName': $scope.clientLevel.bookName,
                    'pageNumber': parseInt($scope.clientLevel.pageNumber),
                    'levelTwo' : []
                }
            }).success(function (response) {
                var data = angular.fromJson(response);
                $scope.parsedData = data;
            }).error(function (response) {
                alert("Error: " + response);
            });
        }
    }

    $scope.sendLevelTwo = function (method) {
        if ($scope.children == "True") {
            $http({
                method: method,
                url: baseURL + 'Level/Two',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelTwoID': 0,
                    'levelOneID': parseInt($scope.clientLevel.parent),
                    'listingName': $scope.clientLevel.name,
                    'listingDescription': '',
                    'versionID': 0,
                    'bookName': '',
                    'pageNumber': 0,
                    'levelThree': []
                }
            }).success(function (response) {
                $scope.parsedData= angular.fromJson(response);
                $scope.getDataFromServer();
            }).error(function (response) {
                alert("Error: " + response);
            });
        } else {
            $http({
                method: method,
                url: baseURL + 'Level/Two',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelTwoID': 0,
                    'levelOneID': parseInt($scope.clientLevel.parent),
                    'listingName': $scope.clientLevel.name,
                    'listingDescription': $scope.clientLevel.description,
                    'versionID': 0,
                    'bookName': $scope.clientLevel.bookName,
                    'pageNumber': parseInt($scope.clientLevel.pageNumber),
                    'levelThree': []
                }
            }).success(function (response) {
                $scope.parsedData= angular.fromJson(response);
                $scope.getDataFromServer();
                alert(data);
            }).error(function (response) {
                alert("Error: " + response);
            });
        }
    }

    // These Functions are duplicated because I can't figure out how to get the "data" variable to be set to an onject.
    $scope.sendLevelThree = function (method) {
        if ($scope.children == "True") {
            $http({
                method: method,
                url: baseURL + 'Level/Three',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelThreeID': 0,
                    'levelTwoID': $scope.clientLevel.parent,
                    'listingName': $scope.clientLevel.name,
                    'listingDescription': '',
                    'versionID': 0,
                    'bookName': '',
                    'pageNumber': 0,
                    'levelFour': []
                }
            }).success(function (response) {
                $scope.parsedData= angular.fromJson(response);
                $scope.getDataFromServer();
            }).error(function (response) {
                alert("Error: " + response);
            });
        } else {
            $http({
                method: method,
                url: baseURL + 'Level/Three',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelThreeID': 0,
                    'levelTwoID': $scope.clientLevel.parent,
                    'listingName': $scope.clientLevel.name,
                    'listingDescription': $scope.clientLevel.description,
                    'versionID': 0,
                    'bookName': $scope.clientLevel.bookName,
                    'pageNumber': parseInt($scope.clientLevel.pageNumber),
                    'levelFour': []
                }
            }).success(function (response) {
                $scope.parsedData= angular.fromJson(response);
                $scope.getDataFromServer();
            }).error(function (response) {
                alert("Error: " + response);
            });
        }
    }

    // These Functions are duplicated because I can't figure out how to get the "data" variable to be set to an onject.
    $scope.sendLevelFour = function (method) {
            $http({
                method: method,
                url: baseURL + 'Level/Four',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelFourID': 0,
                    'levelThreeID': $scope.clientLevel.parent,
                    'listingName': $scope.clientLevel.name,
                    'listingDescription': $scope.clientLevel.description,
                    'versionID': 0,
                    'bookName': $scope.clientLevel.bookName,
                    'pageNumber': parseInt($scope.clientLevel.pageNumber)
                }
            }).success(function (response) {
                var data = angular.fromJson(response);
                $scope.parsedData = data;
                $scope.getDataFromServer();
            }).error(function (response) {
                alert("Error: " + response);
            });
    }

    $scope.resetForm = function () {
        $scope.child.level = "Two";
        $scope.child.parent = null;
        $scope.child.name = "No";
        $scope.child.description = "";
        $scope.child.bookName = "";
        $scope.child.pageNumber = "";
        $scope.children = "True";
    }

    $scope.getDataFromServer = function () {
        $http({
            method: 'GET',
            url: baseURL + 'Level/One'
        }).success(function (response) {
            $scope.serverData = angular.fromJson(response);
            $scope.response = response;
        }).error(function (response) {
            alert("Error: " + response);
        });
    };

}]);