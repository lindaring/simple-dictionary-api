app.controller('wordController', function ($scope, $timeout, $route, wordService) {

    $scope.search = {};
    $scope.search = {
        word: ""
    };
    $scope.definition = {};
    $scope.definition = {
        partsOfSpeech: ["asdf", "adsfasdf"]
    };
    $scope.formEnabled = {}
    $scope.formEnabled = {
        definition: false,
        preloader: false
    };

    $scope.getDefinition = function () {
        $scope.formEnabled.preloader = true;

        $scope.definitionPromise = wordService.getDefinition($scope.search.word);
        $scope.definitionPromise.then(function success(response) {
            $scope.definition = response.data;

            $scope.formEnabled.definition = true;
            $scope.formEnabled.preloader = false;
        }).catch(function () {
            console.log("Failed to get word definition.");

            $scope.formEnabled.definition = false;
            $scope.formEnabled.preloader = false;
        });
    };

    //Todo - handle error - word not found - enable/disable form
});