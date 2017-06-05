var app = angular.module('crudUserApp',['ui.router','ngStorage']);
var app1 = angular.module('crudUserLevelApp',['ui.router','ngStorage']);

var CombineModule = angular.module("CombineModule", ["crudUserApp", "crudUserLevelApp"]);

app.constant('urls', {
    BASE: 'http://localhost:8080/chakra',
    USER_SERVICE_API : 'http://localhost:8080/chakra/api/user/' 
});

app1.constant('urls', {
    BASE: 'http://localhost:8080/chakra', 
    USER_LEVEL_SERVICE_API : 'http://localhost:8080/chakra/api/userLevel/'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/user',
                templateUrl: 'partials/userList',
                controller:'UserController',
                controllerAs:'ctrl',
                resolve: {
                    users: function ($q, UserService) {
                        console.log('Load all users');
                        var deferred = $q.defer();
                        UserService.loadAllUsers().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);


app1.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
        $stateProvider
            .state('home', {
                url: '/userLevel',
                templateUrl: 'partials/userLevelList',
                controller:'UserLevelController',
                controllerAs:'ctrl',
                resolve: {
                    userLevels: function ($q, UserLevelService) {
                        console.log('Load all user Levels');
                        var deferred = $q.defer();
                        UserLevelService.loadAllUserLevels().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

