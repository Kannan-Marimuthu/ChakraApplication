'use strict';

angular.module('crudApp').controller('UserLevelController',
    ['UserService', '$scope',  function( UserLevelService, $scope) {

        var self = this;
        self.user = {};
        self.users=[];

        self.submit = submit;
        self.getAllUserLevels = getAllUserLevels;
        self.createUserLevel = createUserLevel;
        self.updateUserLevel = updateUserLevel;
        self.removeUserLevel = removeUserLevel;
        self.editUserLevel = editUserLevel;
        self.reset = reset;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function submit() {
            console.log('Submitting');
            if (self.user.id === undefined || self.user.id === null) {
                console.log('Saving New UserLevel', self.user);
                createUserLevel(self.user);
            } else {
                updateUserLevel(self.user, self.user.id);
                console.log('UserLevel updated with id ', self.user.id);
            }
        }

        function createUserLevel(user) {
            console.log('About to create user');
            UserLevelService.createUserLevel(user)
                .then(
                    function (response) {
                        console.log('UserLevel created successfully');
                        self.successMessage = 'UserLevel created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.user={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating UserLevel');
                        self.errorMessage = 'Error while creating UserLevel: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateUserLevel(user, id){
            console.log('About to update user');
            UserLevelService.updateUserLevel(user, id)
                .then(
                    function (response){
                        console.log('UserLevel updated successfully');
                        self.successMessage='UserLevel updated successfully';
                        self.errorMessage='';
                        self.done = true;
                        $scope.myForm.$setPristine();
                    },
                    function(errResponse){
                        console.error('Error while updating UserLevel');
                        self.errorMessage='Error while updating UserLevel '+errResponse.data;
                        self.successMessage='';
                    }
                );
        }


        function removeUserLevel(id){
            console.log('About to remove UserLevel with id '+id);
            UserLevelService.removeUserLevel(id)
                .then(
                    function(){
                        console.log('UserLevel '+id + ' removed successfully');
                    },
                    function(errResponse){
                        console.error('Error while removing user '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllUserLevelLevels(){
            return UserLevelService.getAllUserLevels();
        }

        function editUserLevel(id) {
            self.successMessage='';
            self.errorMessage='';
            UserLevelService.getUserLevel(id).then(
                function (user) {
                    self.user = user;
                },
                function (errResponse) {
                    console.error('Error while removing user ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.user={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);