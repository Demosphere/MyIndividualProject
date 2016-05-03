var app = angular.module('myCreator', []);

app.controller('myCreatorCtrl', ['$scope', '$http', function ($scope, $http) {

    $scope.rootLevel = {};

    $scope.createRootLevel = function () {

        if ($scope.children == "True") {
            alert($scope.rootLevel.name);
            $http({
                method: 'POST',
                url: 'http://localhost:8080/html/AddRootLevel',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelOneID': 0,
                    'listingName': $scope.rootLevel.name,
                    'listingDescription': '',
                    'versionID': 0,
                    'bookName': '',
                    'pageNumber': 0,
                    'levelTwo' : []
                }
            }).success(function (response) {
                var data = angular.fromJson(response);
                $scope.parsedData = data;
                alert(data);
            }).error(function (response) {
                alert(response);
                // called asynchronously if an error occurs or server returns response with an error status.
            });
        } else {
            $http({
                method: 'POST',
                url: 'http://localhost:8080/html/AddRootLevel',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelOneID': 0,
                    'listingName': $scope.rootLevel.name,
                    'listingDescription': $scope.rootLevel.description,
                    'versionID': 0,
                    'bookName': $scope.rootLevel.bookName,
                    'pageNumber': parseInt($scope.rootLevel.pageNumber),
                    'levelTwo' : []
                }
            }).success(function (response) {
                var data = angular.fromJson(response);
                $scope.parsedData = data;
                alert(data);
            }).error(function (response) {
                alert(response);
                // called asynchronously if an error occurs or server returns response with an error status.
            });
        }
    }

    this.resetForm = function () {
        $scope.children = "No";
        $scope.listingName_FORM = "";
        $scope.listingDesctipion_FORM = "";
        $scope.listingBookname_FORM = "";
        $scope.listingPageNumber_FORM = "";
    }

    //this.getDataFromServer = function () {
    //
    //    $http({
    //        method: 'POST',
    //        url: 'http://localhost:8080/html/AddLevel',
    //    }).success(function (response) {
    //        var data = angular.fromJson(response);
    //        $scope.parsedData = data;
    //
    //        $scope.levelOneID = data.levelOneID;
    //        $scope.listingName = data.listingName;
    //        $scope.listingDescription = data.listingDescription;
    //        $scope.versionID = data.versionID;
    //        $scope.bookName = data.bookName;
    //        $scope.pageNumber = data.pageNumber;
    //
    //        $scope.response = response;
    //
    //        alert(response);
    //    }).error(function (response) {
    //        // called asynchronously if an error occurs or server returns response with an error status.
    //    });
    //
    //};

    //this.toggle_type_FORM = function (toggle) {
    //    if (toggle = "Yes") {
    //        $scope.toggle_FORM = true
    //    } else {
    //        $scope.toggle_FORM = false
    //    }
    //
    //};


}]);