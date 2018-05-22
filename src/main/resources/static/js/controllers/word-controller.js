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
    $scope.year = 1999;
    var duration = 5000;

    $scope.getDefinition = function () {
        if ($scope.search.word != null && $scope.search.word !== "") {
            $scope.formEnabled.preloader = true;

            $scope.definitionPromise = wordService.getDefinition($scope.search.word);
            $scope.definitionPromise.then(function success(response) {
                $scope.definition = response.data;

                $scope.formEnabled.definition = true;
                $scope.formEnabled.preloader = false;
            }).catch(function (error) {
                var message = error.data.message;

                if (error.status === 404) {
                    M.toast({html: message, displayLength: duration});
                    console.error("Word not found.");
                } else {
                    M.toast({html: message, displayLength: duration});
                    console.error("Failed to get word definition.");
                }

                $scope.formEnabled.definition = false;
                $scope.formEnabled.preloader = false;
            });
        } else {
            M.toast({html: "Please provide word to search", displayLength: duration});
        }
    };

    $scope.getYear = function () {
        $scope.year = 1999;
    };

    $scope.refresh = function () {
        $scope.getYear();
    };

    $scope.refresh();
});