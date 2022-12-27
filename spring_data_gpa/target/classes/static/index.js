angular.module('app',[]).controller('indexController',function($scope,$http){
    const contextPath = 'http://localhost:8080/app/api/v1';

    $scope.fillTable = function(){
        $http.get(contextPath + '/products')
        .then(function(response){
            $scope.ProductList = response.data;
        });

    $scope.fillCard = function(){
        $http.get(contextPath + 'products/card')
        .then(function(response){
            $scope.ProductDtoList = response.data
        });
    }

    };
    $scope.deleteProduct = function(productId){
        $http.delete(contextPath + '/products/' + productId)
             .then(function(response){
                $scope.fillTable();
        });
    }

    $scope.changeProductPrice = function(productDto){
        $http.put(contextPath + '/products/change',$scope.productDto)
                .then(function(response){
                        $scope.fillTable();
                });
    }

    $scope.addNewProduct = function(productDto){

            $http.post(contextPath + '/products',$scope.productDto)
            .then(function(response){
                    $scope.fillTable();
            });
    }
    $scope.addProductIntoCard = function(productDto){

                $http.post(contextPath + '/products/card/add',$scope.productDto)
                .then(function(response){
                        $scope.fillCard();
                });
    }



    $scope.fillTable();
    $scope.fillCard();
});