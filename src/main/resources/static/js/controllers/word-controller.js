app.controller('wordController', function ($scope, $timeout, $route, wordService) {

    $scope.search = {};
    $scope.search = {
        word: ""
    };
    $scope.definition = {};
    $scope.definition = {
        partsOfSpeech: ["asdf", "adsfasdf"]
    };

    $scope.getDefinition = function () {
        $scope.definitionPromise = wordService.getDefinition($scope.search.word);
        $scope.definitionPromise.then(function success(response) {
            $scope.definition = response.data;
        }).catch(function () {
            console.log("Failed to get word definition.");
        });
    };

});