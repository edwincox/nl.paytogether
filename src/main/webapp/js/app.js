//var paytogether = angular.module(payToGetherApp, []);
//
//payToGetherApp.config(['$routeProvider']).function($routeProvider){
//$routeProvider
//    .when("/test",{
//        templateUrl : "test.html"
//    })
//    .when("/customer/user/addUser.html",{
//        templateUrl : "addUser.html",
//        controller : 'MyCtrll';
//    })
//    .when("/*",{
//        templateUrl : "index.html"
//    })


// Declare app level module which depends on filters, and services
angular.module('paytogether', ['filters', 'services', 'directives', 'controllers']).
    config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/view1', {templateUrl: 'partials/partial1.html', controller: 'MyCtrl1'});
        $routeProvider.otherwise({redirectTo: '/view1'});
    }]);


}