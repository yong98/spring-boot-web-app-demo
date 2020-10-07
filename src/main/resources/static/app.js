var myApp = angular.module('myApp', []);

myApp.controller('mainController', ['$scope', '$filter', '$http', function ($scope, $filter, $http) {

    $scope.phoneNumber = '';
    $scope.pageId = 0;

    $scope.characters = 7;

    $scope.getWords = function () {
        $http.put('/api', { phoneNumber: $scope.phoneNumber })
            .success(function (result) {

                console.log(result);
                $scope.words = result;
                $scope.pageId = 1;

            })
            .error(function (data, status) {

                console.log(data);

            });
    };

    $scope.nextPage = function () {
    	$scope.pageId = $scope.pageId + 1;
	    $http.get('/api/list/' + $scope.phoneNumber + '/' + $scope.pageId)
	        .success(function (result) {
	
	            $scope.words = result;
	
	        })
	        .error(function (data, status) {
	
	            console.log(data);
	
	        });
    };

    $scope.prevPage = function () {
    	$scope.pageId = $scope.pageId - 1;
	    $http.get('/api/list/' + $scope.phoneNumber + '/' + $scope.pageId)
	        .success(function (result) {
	
	            $scope.words = result;
	
	        })
	        .error(function (data, status) {
	
	            console.log(data);
	
	        });
    };

}]);