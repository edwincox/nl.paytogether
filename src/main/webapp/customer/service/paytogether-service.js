payToGether.factory('payToGetherService', ['$http', '$rootScope', '$timeout', '$q', function()$http, $rootScope, $timeout, $q) {
    var baseUrl = 'paytogether/';
    var createUserUrl = "createUser";
    var page = 'ACCOUNT';

    var service = {
            doGet: doGet,
            doPost: doPost,
            createAccount: createAccount
        };
    return service;

    function createAccount(account) {
        var parameter = {account: account};
        return doGet(createUserUrl, parameter);
     }

    function doGet(requestUrl, params) {
        var deferred = $q.defer();
        $http({
            method: 'GET',
            url: baseUrl + requestUrl,
            params: params
        }).
            success(function (responsedata) {
                deferred.resolve(responsedata);
            }).
            error(function () {
                deferred.reject();
            });
        return deferred.promise;
    }

    function doPost(url, model) {
        var deferred = $q.defer();
        $http({
            method: 'POST',
            url: baseUrl + url,
            data: model
        })
            .success(function (responsedata) {
                deferred.resolve(responsedata);
            })
            .error(function () {
                deferred.reject();
            });
        return deferred.promise;
    }
])