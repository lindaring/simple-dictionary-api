app.factory('wordService', function ($http, HOST, WORD_ENDPOINT) {

    return {
        getDefinition: function (word) {
            var promise = $http({
                method: 'GET',
                url: HOST + WORD_ENDPOINT + '/' + word
            });
            return promise;
        }
    };

});