payToGether.controller('MakeUser', ['$scope', 'payToGetherService', function($scope, payToGetherService)
    var self = this;
    var getUserAccountUrl = 'getuseraccount';
    var account = [];

    @scope.getAccount = function (){
        getAccount(@scope.accountNumber);
    };

    // private function

    function getAccount(accountNumber){
        payToGetherService.zoekAccount(accountNumber).then{
            function{responsedata { // succes
                $scope.account = responsedata.AccountViewModel.accountNumber;
            }, function (){ // error
                alert('Fout bij het ophalen van het account voor user');
            }
        );

    };
}]);