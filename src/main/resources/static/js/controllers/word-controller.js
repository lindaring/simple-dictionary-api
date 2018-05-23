app.controller('wordController', function ($scope, $compile, $timeout, $route, wordService, utilService) {

    $scope.search = {};
    $scope.search = {
        word: ""
    };
    $scope.definition = {};
    $scope.definition = {
        partsOfSpeech: [],
        word: ""
    };
    $scope.formEnabled = {};
    $scope.formEnabled = {
        definition: false,
        preloader: false
    };
    $scope.date = {};
    $scope.date = {
        year: 0
    };
    $scope.searchHistory = [];
    var duration = 5000;

    $scope.getDefinition = function () {
        if ($scope.search.word != null && $scope.search.word !== "") {
            $scope.formEnabled.preloader = true;

            $scope.definitionPromise = wordService.getDefinition($scope.search.word);
            $scope.definitionPromise.then(function success(response) {
                $scope.definition = response.data;

                if (!$scope.exists($scope.searchHistory, $scope.definition.word)) {
                    $scope.addTag($scope.definition.word);
                    $scope.searchHistory.push($scope.definition.word);
                }

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

    $scope.getDefinitionFromTag = function (word) {
        $scope.search.word = word;
        $scope.getDefinition();
    };

    $scope.getYear = function () {
        $scope.currentPromise = utilService.getCurrentYear();
        $scope.currentPromise.then(function success(response) {
            $scope.date.year = response.data;

        }).catch(function () {
            $scope.date.year = 2018;
        });
    };

    $scope.addTag = function (word) {
        var btnhtml =   '<div class="chip">' +
                            '<button class="hide-buttion" ng-click="getDefinitionFromTag(\''+word+'\')">' +
                                word +
                            '</button>' +
                        '<i class="close material-icons">close</i></div>';
        var temp = $compile(btnhtml)($scope);
        $("#word-chips").append(temp);
    };

    $scope.exists = function (list, item) {
        return (list.indexOf(item) !== -1);
    };

    $scope.refresh = function () {
        $scope.getYear();
    };

    $scope.refresh();
});