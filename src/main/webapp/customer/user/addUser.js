var application = angular.module('myapp', []);

application.controller('formControllerAddUser', function($scope){
    $scope.voornaam = "EdwinAngular";
    $scope.achternaam = "EdwinAngular";
    $scope.straatnaam = "EdwinAngularStraatnaam";
    $scope.huisnummer = "EdwinAngular";
    $scope.postcode = "EdwinAngularPostcode";
    $scope.password = "EdwinAngular_Pass";
    $scope.emailadres = "Edwin@Angular";
});
