var app = angular.module('myApp', []);

app.controller('myCtrl', ['$scope', '$http', function ($scope, $http) {

    this.sendGet = function () {
        $http.get("http://localhost:8080/html/AddLevel").then(function (response) {
            alert("Controller Hit" + response.toString());
        });
    }

    this.sendPost = function () {
        // This only works for the Level one Table at the moment.
        $http({
            method: 'POST',
            url: 'http://localhost:8080/html/AddLevel',
            headers: {'Content-Type': 'application/x-www-form-urlencoded'},
            data: {
                'levelOneID': 0,
                'listingName': $scope.listingName_FORM,
                'listingDescription': 'null',
                'versionID': 0,
                'bookName': 'null',
                'pageNumber': 0,
                'levelTwo' : []
            }
        }).success(function (response) {
            var data = angular.fromJson(response);
            $scope.parsedData = data;
            alert(data);
        }).error(function (data, status, headers, config) {
            // called asynchronously if an error occurs or server returns response with an error status.
        });
    }

    this.resetForm = function () {
        $scope.levelOfListing_FORM = "1";
        $scope.parentOfListing_FORM = "1";
        $scope.children = "No";
        $scope.listingName_FORM = "";
        $scope.listingDesctipion_FORM = "";
        $scope.listingBookname_FORM = "";
        $scope.listingPageNumber_FORM = "";
    }

    this.getDataFromServer = function () {

        $http({
            method: 'POST',
            url: 'http://localhost:8080/html/AddLevel',
        }).success(function (response) {
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
        }).error(function (data, status, headers, config) {
            // called asynchronously if an error occurs or server returns response with an error status.
        });

    };

    this.toggle_type_FORM = function (toggle) {
        if (toggle = "Yes") {
            $scope.toggle_FORM = true
        } else {
            $scope.toggle_FORM = false
        }

    };


}]);