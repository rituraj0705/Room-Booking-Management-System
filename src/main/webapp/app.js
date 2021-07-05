// MODULE
var myApp = angular.module('myApp', ['ngMessages', 'ngResource']);

//CONTROLLERS
myApp.controller('mainController',  ['$scope', '$log', '$filter', '$http', '$window', function ($scope, log, $filter, $http, window) {
    $scope.firstName = '';
    $scope.lastName = '';
    $scope.dob ;
    $scope.email = '';
    $scope.customers = '';
    $scope.isObjectEmpty = function(card){
        if (card == undefined  || card == null) {
            return true;
        }
        return card.toString().length === 0;
    }
    $scope.addCustomer = function () {
        const payLoad = {firstName : $scope.firstName, lastName : $scope.lastName, dob : $scope.dob, email: $scope.email};
        if ($scope.isObjectEmpty($scope.firstName) || $scope.isObjectEmpty($scope.lastName) ||
            $scope.isObjectEmpty($scope.dob) || $scope.isObjectEmpty($scope.email)) {
            window.alert('All fields are mandatory.');
            return;
        }
        $http.post('/customer', payLoad)
            .then(function success(response) {
                $scope.getAllCustomers();
                log.info('Successfully inserted the user');
            }, function error (data, status){
                //To do for error callback
            });
    }

    $scope.getAllCustomers = function () {
        $http.get('/customers/all')
            .then(function success(response) {
                $scope.customers = response.data;
            }, function error(data, status) {
                log.error("System threw error: " + status);
            });
    }

    $scope.deleteCustomer = function (customer) {
        $http.post('/customer/remove', customer)
            .then(function success(response) {
                $scope.getAllCustomers();
                log.info('Successfully deleted the user');
            }, function error(data, status) {
                log.error("System threw error: " + status);
            });
    }
}]);