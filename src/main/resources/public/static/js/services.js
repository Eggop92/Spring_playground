var app = angular.module('spring_playground', [ "ngResource" ]);

app.controller('CountryController', [ '$scope', '$http',

    function($scope, $http) {
        $scope.getAllCountries = function() {
            $http.get('/country').success(function(data) {
                $scope.countries = data;
            });
        };

        $scope.addNewCountry = function() {
            $http.post('/country',
                {
                    name : $scope.name,
                    phonePrefix : $scope.phonePrefix
                }
            ).success(function(data) {
                $scope.msg = 'Pelicula creada correctamente';
                $scope.getAllCountries();
            }).error(function(data) {
                $scope.msg = 'Se ha producido un error';
            });
        };
    } ]);