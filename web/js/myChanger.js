var app = angular.module('myChanger', []);

app.controller('myCtrl', ['$scope', '$http', function ($scope, $http) {

    var baseURL = 'http://localhost:8080/html/';
    $scope.updateLevel = {};

    $scope.sendLevelOne = function (method) {
        $http({
            method: method,
            url: baseURL + 'Level/One',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            data: {
                'levelOneID': $scope.updateLevel.levelOneID,
                'listingName': $scope.updateLevel.listingName,
                'listingDescription': $scope.updateLevel.listingDescription,
                'versionID': $scope.updateLevel.versionID,
                'bookName': $scope.updateLevel.bookName,
                'pageNumber': $scope.updateLevel.pageNumber,
                'levelTwo': $scope.updateLevel.levelTwo
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
                'levelTwoID': $scope.updateLevel.levelTwoID,
                'levelOneID': $scope.updateLevel.levelOneID,
                'listingName': $scope.updateLevel.listingName,
                'listingDescription': $scope.updateLevel.listingDescription,
                'versionID': $scope.updateLevel.versionID,
                'bookName': $scope.updateLevel.bookName,
                'pageNumber': $scope.updateLevel.pageNumber,
                'levelThree': $scope.updateLevel.levelThree
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
                'levelThreeID': $scope.updateLevel.levelThreeID,
                'levelTwoID': $scope.updateLevel.levelTwoID,
                'listingName': $scope.updateLevel.listingName,
                'listingDescription': $scope.updateLevel.listingDescription,
                'versionID': $scope.updateLevel.versionID,
                'bookName': $scope.updateLevel.bookName,
                'pageNumber': $scope.updateLevel.pageNumber,
                'levelFour': $scope.updateLevel.levelFour
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
                'levelFourID': $scope.updateLevel.levelFourID,
                'levelThreeID': $scope.updateLevel.levelThreeID,
                'listingName': $scope.updateLevel.listingName,
                'listingDescription': $scope.updateLevel.listingDescription,
                'versionID': $scope.updateLevel.versionID,
                'bookName': $scope.updateLevel.bookName,
                'pageNumber': $scope.updateLevel.pageNumber,
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

    $scope.setUpdateLevel = function (inLevel) {
        $scope.updateLevel = angular.fromJson(inLevel);
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