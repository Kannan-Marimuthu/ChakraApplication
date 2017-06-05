'use strict';

angular.module('crudUserLevelApp').factory('UserLevelService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllUserLevels: loadAllUserLevels,
                getAllUserLevels: getAllUserLevels,
                getUserLevel: getUserLevel,
                createUserLevel: createUserLevel,
                updateUserLevel: updateUserLevel,
                removeUserLevel: removeUserLevel
            };

            return factory;

            function loadAllUserLevels() {
                console.log('Fetching all users');
                var deferred = $q.defer();
                $http.get(urls.USER_LEVEL_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all users');
                            $localStorage.userLevels = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading users');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllUserLevels(){
                return $localStorage.userLevels;
            }

            function getUserLevel(id) {
                console.log('Fetching UserLevel with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.USER_LEVEL_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully UserLevel with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading UserLevel with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function createUserLevel(user) {
                console.log('Creating UserLevel');
                var deferred = $q.defer();
                $http.post(urls.USER_LEVEL_SERVICE_API, user)
                    .then(
                        function (response) {
                            loadAllUserLevels();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                           console.error('Error while creating UserLevel : '+errResponse.data.errorMessage);
                           deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function updateUserLevel(user, id) {
                console.log('Updating UserLevel with id '+id);
                var deferred = $q.defer();
                $http.put(urls.USER_LEVEL_SERVICE_API + id, user)
                    .then(
                        function (response) {
                            loadAllUserLevels();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while updating UserLevel with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function removeUserLevel(id) {
                console.log('Removing UserLevel with id '+id);
                var deferred = $q.defer();
                $http.delete(urls.USER_LEVEL_SERVICE_API + id)
                    .then(
                        function (response) {
                            loadAllUserLevels();
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while removing User with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);