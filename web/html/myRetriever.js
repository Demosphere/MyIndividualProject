var app = angular.module('myRetriever',  ['ui.bootstrap']);

app.controller('myRetrieverCtrl', ['$scope', '$http', function ($scope, $http) {

    this.getDataFromServer = function () {

        $http({
            method: 'GET',
            url: 'http://localhost:8080/html/index'
        }).success(function (response) {
            var listings = angular.fromJson(response);
            $scope.parsedData = listings;

            $scope.serverData = listings;

            $scope.levelOneID = listings.levelOneID;
            $scope.listingName = listings.listingName;
            $scope.listingDescription = listings.listingDescription;
            $scope.versionID = listings.versionID;
            $scope.bookName = listings.bookName;
            $scope.pageNumber = listings.pageNumber;

            $scope.response = response;

            alert(response);
        }).error(function (data, status, headers, config) {
            // called asynchronously if an error occurs or server returns response with an error status.
        });

    };

    $scope.groups = [{
        title: "Dynamic Group Header - Level 1.0",
        description: "Dynamic Group Header - Level 1.0",
        items: [{
            "item-title": "Item Level 2.0",
            "item-description": "Item Level 2.0",
            "items": [{
                "item-title": "Item Level 3.0",
                "item-description": "Item Level 3.0",
                "items": [{
                    "item-title": "Item Level 4.0",
                    "item-description": "Item Level 4.0"
                }]
            },
                {
                    "item-title": "Item Level 3.1",
                    "item-description": "Item Level 3.1",
                    "items": [{
                        "item-title": "Item Level 4.1",
                        "item-description": "Item Level 4.1"
                    },
                        {
                            "item-title": "Item Level 4.1.0",
                            "item-description": "Item Level 4.1.0"
                        }]
                }]
        }, {
            "item-title": "Item Level 2.1",
            "item-description": "Item Level 2.1",
            "items": [{
            }]
        }]
    }, {
        title: "Dynamic Group Header - Level 1.1",
        description: "Dynamic Group Header - Level 1.1",
        items: [{
            "item-title": "item 3"
        }, {
            "item-title": "item 4"
        }]
    }];

}]);