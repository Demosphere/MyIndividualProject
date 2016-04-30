var app = angular.module('myCreator', []);

app.controller('myCreatorCtrl', ['$scope', '$http', function ($scope, $http) {

    this.rootLevel = {};

    this.createRootLevel = function (hasChildren) {

        if (hasChildren == "True") {
            $http({
                method: 'POST',
                url: 'http://localhost:8080/html/AddRootLevel',
                headers: {'Content-Type': 'application/x-www-form-urlencoded'},
                data: {
                    'levelOneID': 0,
                    'listingName': $scope.listingName_FORM,
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
            }).error(function (data, status, headers, config) {
                // called asynchronously if an error occurs or server returns response with an error status.
            });
        } else {
            //alert("{\nlevelOneID        : 0, " +
            //      "\n listingName       : " + $scope.listingName_FORM + "," +
            //      "\n listingDescription: " +$scope.listingDesctipion_FORM + "," +
            //      "\n versionID         : 0," +
            //      "\n bookName          : " + $scope.listingBookname_FORM + "," +
            //      "\n pageNumber        : " + parseInt($scope.listingPageNumber_FORM) + "," +
            //      "\n levelTwo          : []" +
            //    "\n}")
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
            }).error(function (data, status, headers, config) {
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