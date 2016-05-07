var app = angular.module('myDestroyer', []);

app.controller('myCtrl', ['$scope', '$http', function ($scope, $http) {

    var baseURL = 'http://localhost:8080/html/';
    $scope.clientLevel = {};

    // These Functions are duplicated because I can't figure out how to get the "data" variable to be set to an onject.
    $scope.sendLevelOne = function (method) {
            $http({
                method: method,
                url: baseURL + 'Level/One',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelOneID': $scope.clientLevel.levelOneID,
                    'listingName': $scope.clientLevel.listingName,
                    'listingDescription': $scope.clientLevel.listingName,
                    'versionID': $scope.clientLevel.versionID,
                    'bookName': $scope.clientLevel.bookName,
                    'pageNumber': $scope.clientLevel.pageNumber,
                    'levelTwo': $scope.clientLevel.levelTwo
                }
            }).success(function (response) {
                var data = angular.fromJson(response);
                $scope.parsedData = data;
                $scope.getDataFromServer();
            }).error(function (response) {
                alert(response);
            });
    }

    $scope.sendLevelTwo = function (method) {
            $http({
                method: method,
                url: baseURL + 'Level/Two',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelTwoID': $scope.clientLevel.levelTwoID,
                    'levelOneID': $scope.clientLevel.levelOneID,
                    'listingName': $scope.clientLevel.listingName,
                    'listingDescription': $scope.clientLevel.listingName,
                    'versionID': $scope.clientLevel.versionID,
                    'bookName': $scope.clientLevel.bookName,
                    'pageNumber': $scope.clientLevel.pageNumber,
                    'levelThree': $scope.clientLevel.levelThree
                }
            }).success(function (response) {
                var data = angular.fromJson(response);
                $scope.parsedData = data;
                $scope.getDataFromServer();
            }).error(function (response) {
                alert(response);
            });
    }

    // These Functions are duplicated because I can't figure out how to get the "data" variable to be set to an onject.
    $scope.sendLevelThree = function (method) {
            $http({
                method: method,
                url: baseURL +  'Level/Three',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelThreeID': $scope.clientLevel.levelThreeID,
                    'levelTwoID': $scope.clientLevel.levelTwoID,
                    'listingName': $scope.clientLevel.listingName,
                    'listingDescription': $scope.clientLevel.listingName,
                    'versionID': $scope.clientLevel.versionID,
                    'bookName': $scope.clientLevel.bookName,
                    'pageNumber': $scope.clientLevel.pageNumber,
                    'levelFour': $scope.clientLevel.levelFour
                }
            }).success(function (response) {
                var data = angular.fromJson(response);
                $scope.parsedData = data;
                $scope.getDataFromServer();
            }).error(function (response) {
                alert(response);
            });
    }

    // These Functions are duplicated because I can't figure out how to get the "data" variable to be set to an onject.
    $scope.sendLevelFour = function (method) {
        $http({
            method: method,
            url: baseURL + 'Level/Four',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            data: {
                'levelFourID': $scope.clientLevel.levelFourID,
                'levelThreeID': $scope.clientLevel.levelThreeID,
                'listingName': $scope.clientLevel.listingName,
                'listingDescription': $scope.clientLevel.listingName,
                'versionID': $scope.clientLevel.versionID,
                'bookName': $scope.clientLevel.bookName,
                'pageNumber': $scope.clientLevel.pageNumber,
            }
        }).success(function (response) {
            var data = angular.fromJson(response);
            $scope.parsedData = data;
            $scope.getDataFromServer();
        }).error(function (response) {
            alert(response);
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

    $scope.setClientLevel = function (inLevel) {
        $scope.clientLevel = angular.fromJson(inLevel);
    }

    $scope.getDataFromServer = function () {
        $http({
            method: 'GET',
            url: baseURL + '/Level/One'
        }).success(function (response) {
            var listings = angular.fromJson(response);
            $scope.serverData = listings;
            $scope.response = response;
        }).error(function (data, status, headers, config) {
            alert(data);
            // called asynchronously if an error occurs or server returns response with an error status.
        });

    };

}]);