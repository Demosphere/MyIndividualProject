var app = angular.module('myApp', []);

app.controller('myCtrl', ['$scope', '$http', function ($scope, $http) {

    $scope.child = {};

    // These Functions are duplicated because I can't figure out how to get the "data" variable to be set to an onject.
    $scope.sendLevelTwo = function () {
        if ($scope.children == "True") {
            $http({
                method: 'PUT',
                url: 'http://localhost:8080/html/Level/Two',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelTwoID': 0,
                    'levelOneID': parseInt($scope.child.parent),
                    'listingName': $scope.child.name,
                    'listingDescription': '',
                    'versionID': 0,
                    'bookName': '',
                    'pageNumber': 0,
                    'levelThree': []
                }
            }).success(function (response) {
                var data = angular.fromJson(response);
                $scope.parsedData = data;
                $scope.getDataFromServer();
            }).error(function (response) {
                alert(response);
                // called asynchronously if an error occurs or server returns response with an error status.
            });
        } else {
            $http({
                method: 'PUT',
                url: 'http://localhost:8080/html/Level/Two',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelTwoID': 0,
                    'levelOneID': parseInt($scope.child.parent),
                    'listingName': $scope.child.name,
                    'listingDescription': $scope.child.description,
                    'versionID': 0,
                    'bookName': $scope.child.bookName,
                    'pageNumber': parseInt($scope.child.pageNumber),
                    'levelThree': []
                }
            }).success(function (response) {
                var data = angular.fromJson(response);
                $scope.parsedData = data;
                $scope.getDataFromServer();
                alert(data);
            }).error(function (response) {
                alert(response);
                // called asynchronously if an error occurs or server returns response with an error status.
            });
        }
    }

    // These Functions are duplicated because I can't figure out how to get the "data" variable to be set to an onject.
    $scope.sendLevelThree = function () {
        if ($scope.children == "True") {
            $http({
                method: 'PUT',
                url: 'http://localhost:8080/html/Level/Three',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelThreeID': 0,
                    'levelTwoID': $scope.child.parent,
                    'listingName': $scope.child.name,
                    'listingDescription': '',
                    'versionID': 0,
                    'bookName': '',
                    'pageNumber': 0,
                    'levelFour': []
                }
            }).success(function (response) {
                var data = angular.fromJson(response);
                $scope.parsedData = data;
                $scope.getDataFromServer();
            }).error(function (response) {
                alert(response);
                // called asynchronously if an error occurs or server returns response with an error status.
            });
        } else {
            $http({
                method: 'PUT',
                url: 'http://localhost:8080/html/Level/Three',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelThreeID': 0,
                    'levelTwoID': $scope.child.parent,
                    'listingName': $scope.child.name,
                    'listingDescription': $scope.child.description,
                    'versionID': 0,
                    'bookName': $scope.child.bookName,
                    'pageNumber': parseInt($scope.child.pageNumber),
                    'levelFour': []
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
    }

    // These Functions are duplicated because I can't figure out how to get the "data" variable to be set to an onject.
    $scope.sendLevelFour = function () {
            $http({
                method: 'PUT',
                url: 'http://localhost:8080/html/Level/Four',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelFourID': 0,
                    'levelThreeID': $scope.child.parent,
                    'listingName': $scope.child.name,
                    'listingDescription': $scope.child.description,
                    'versionID': 0,
                    'bookName': $scope.child.bookName,
                    'pageNumber': parseInt($scope.child.pageNumber)
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

    $scope.getDataFromServer = function () {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/html/index'
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