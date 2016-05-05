var app = angular.module('myDestroyer', []);

app.controller('myCtrl', ['$scope', '$http', function ($scope, $http) {

    var baseURL = 'http://localhost:8080/html/';
    $scope.deleteLevel = {};

    // These Functions are duplicated because I can't figure out how to get the "data" variable to be set to an onject.
    $scope.sendLevelOne = function () {
            $http({
                method: 'DELETE',
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

    $scope.sendLevelTwo = function () {
            $http({
                method: 'DELETE',
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
    $scope.sendLevelThree = function () {
            $http({
                method: 'DELETE',
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
    $scope.sendLevelFour = function () {
        $http({
            method: 'DELETE',
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
            url: baseURL + '/index'
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