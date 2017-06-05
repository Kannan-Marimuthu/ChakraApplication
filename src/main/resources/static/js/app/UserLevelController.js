'use strict';

angular.module('crudUserLevelApp').controller('UserLevelController',
    ['UserLevelService', '$scope',  function( UserLevelService, $scope) {

        var self = this;
        self.userLevel = {};
        self.userLevels=[];

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
            if (self.userLevel.id === undefined || self.userLevel.id === null) {
                console.log('Saving New UserLevel', self.userLevel);
                createUserLevel(self.userLevel);
            } else {
                updateUserLevel(self.userLevel, self.userLevel.id);
                console.log('UserLevel updated with id ', self.userLevel.id);
            }
        }

        function createUserLevel(userLevel) {
            console.log('About to create userLevel');
            UserLevelService.createUserLevel(userLevel)
                .then(
                    function (response) {
                        console.log('UserLevel created successfully');
                        self.successMessage = 'UserLevel created successfully';
                        self.errorMessage='';
                        self.done = true;
                        self.userLevel={};
                        $scope.myForm.$setPristine();
                    },
                    function (errResponse) {
                        console.error('Error while creating UserLevel');
                        self.errorMessage = 'Error while creating UserLevel: ' + errResponse.data.errorMessage;
                        self.successMessage='';
                    }
                );
        }


        function updateUserLevel(userLevel, id){
            console.log('About to update userLevel');
            UserLevelService.updateUserLevel(userLevel, id)
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
                        console.error('Error while removing userLevel '+id +', Error :'+errResponse.data);
                    }
                );
        }


        function getAllUserLevels(){
            return UserLevelService.getAllUserLevels();
        }

        function editUserLevel(id) {
            self.successMessage='';
            self.errorMessage='';
            UserLevelService.getUserLevel(id).then(
                function (userLevel) {
                    self.userLevel = userLevel;
                },
                function (errResponse) {
                    console.error('Error while removing userLevel level ' + id + ', Error :' + errResponse.data);
                }
            );
        }
        function reset(){
            self.successMessage='';
            self.errorMessage='';
            self.userLevel={};
            $scope.myForm.$setPristine(); //reset Form
        }
    }


    ]);