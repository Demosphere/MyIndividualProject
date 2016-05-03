var app = angular.module('myCreator', []);

app.controller('myCreatorCtrl', ['$scope', '$http', function ($scope, $http) {

    $scope.rootLevel = {};

    $scope.createRootLevel = function () {

        if ($scope.children == "True") {
            alert($scope.rootLevel.name);
            $http({
                method: 'POST',
                url: 'http://localhost:8080/html/Level/One',
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
                url: 'http://localhost:8080/html/Level/One',
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

}]);