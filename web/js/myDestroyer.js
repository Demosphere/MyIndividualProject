var app = angular.module('myDestroyer', []);

app.controller('myCtrl', ['$scope', '$http', function ($scope, $http) {

    var baseURL = 'http://localhost:8080/html/';
    $scope.deleteLevel = {};

    // These Functions are duplicated because I can't figure out how to get the "data" variable to be set to an onject.
    $scope.sendLevelOne = function (method) {
            $http({
                method: method,
                url: baseURL + 'Level/One',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelOneID': $scope.deleteLevel.levelOneID,
                    'listingName': '',
                    'listingDescription': '',
                    'versionID': 0,
                    'bookName': '',
                    'pageNumber': 0,
                    'levelTwo': []
                }
            }).success(function (response) {
                var data = angular.fromJson(response);
                $scope.parsedData = data;
                $scope.getDataFromServer();
            }).error(function (response) {
                alert(response);
                // called asynchronously if an error occurs or server returns response with an error status.
            });
    }

    $scope.sendLevelTwo = function (method) {
            $http({
                method: method,
                url: baseURL + 'Level/Two',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelTwoID': $scope.deleteLevel.levelTwoID,
                    'levelOneID': $scope.deleteLevel.levelOneID,
                    'listingName': '',
                    'listingDescription': '',
                    'versionID': 0,
                    'bookName': '',
                    'pageNumber': 0,
                    'levelThree': $scope.deleteLevel.levelThree
                }
            }).success(function (response) {
                var data = angular.fromJson(response);
                $scope.parsedData = data;
                $scope.getDataFromServer();
            }).error(function (response) {
                alert(response);
                // called asynchronously if an error occurs or server returns response with an error status.
            });
    }

    // These Functions are duplicated because I can't figure out how to get the "data" variable to be set to an onject.
    $scope.sendLevelThree = function (method) {
            $http({
                method: method,
                url: baseURL +  'Level/Three',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelThreeID': $scope.deleteLevel.levelThreeID,
                    'levelTwoID': $scope.deleteLevel.levelTwoID,
                    'listingName': '',
                    'listingDescription': '',
                    'versionID': 0,
                    'bookName': '',
                    'pageNumber': 0,
                    'levelFour': $scope.deleteLevel.levelFour
                }
            }).success(function (response) {
                var data = angular.fromJson(response);
                $scope.parsedData = data;
                $scope.getDataFromServer();
            }).error(function (response) {
                alert(response);
                // called asynchronously if an error occurs or server returns response with an error status.
            });
    }

    // These Functions are duplicated because I can't figure out how to get the "data" variable to be set to an onject.
    $scope.sendLevelFour = function (method) {
        $http({
            method: method,
            url: baseURL + 'Level/Four',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            data: {
                'levelFourID': $scope.deleteLevel.levelFourID,
                'levelThreeID': $scope.deleteLevel.levelThreeID,
                'listingName': '',
                'listingDescription': '',
                'versionID': 0,
                'bookName': '',
                'pageNumber': 0
            }
        }).success(function (response) {
            var data = angular.fromJson(response);
            $scope.parsedData = data;
            $scope.getDataFromServer();
        }).error(function (response) {
            alert(response);
            // called asynchronously if an error occurs or server returns response with an error status.
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

    $scope.setDeleteLevel = function (inLevel) {
        $scope.deleteLevel = angular.fromJson(inLevel);
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