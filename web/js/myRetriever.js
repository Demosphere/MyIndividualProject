var app = angular.module('myRetriever',  ['ui.bootstrap']);

app.filter('unsafe', function($sce) { return $sce.trustAsHtml; });

app.controller('myRetrieverCtrl', ['$scope', '$http', function ($scope, $http) {

    $scope.getDataFromServer = function () {
        $http({
            method: 'GET',
            url: 'http://localhost:8080/html/Level/One'
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
