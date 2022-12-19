angular.module('app',[]).controller('indexController',function($scope,$http){
    const contextPath = 'http://localhost:8080/app/api/v1';

    $scope.fillTable = function(){
        $http.get(contextPath + '/products')
        .then(function(response){
            $scope.ProductList = response.data;
        });

    };
    $scope.deleteProduct = function(productId){
        $http.delete(contextPath + '/products/' + productId)
             .then(function(response){
                $scope.fillTable();
        });
    }

    $scope.changeProductPrice = function(product){
        $http.post(contextPath + '/products/change',$scope.product)
                .then(function(response){
                        $scope.fillTable();
                });
    }

    $scope.addNewProduct = function(product){

            $http.post(contextPath + '/products',$scope.product)
            .then(function(response){
                    $scope.fillTable();
            });
    }


    $scope.fillTable();
});