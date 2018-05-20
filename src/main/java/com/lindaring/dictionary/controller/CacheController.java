package com.lindaring.dictionary.controller;

import com.lindaring.dictionary.annotation.LogExecutionTime;
import com.lindaring.dictionary.annotation.LogMethod;
import com.lindaring.dictionary.exception.CacheException;
import com.lindaring.dictionary.exception.TechnicalException;
import com.lindaring.dictionary.model.SimpleCache;
import com.lindaring.dictionary.service.CacheService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value="/simple-dictionary/v1/cache")
public class CacheController {

    @Autowired
    private CacheService cacheService;

    @LogMethod
    @LogExecutionTime
    @RequestMapping(value="/", method=RequestMethod.GET)
    @ApiOperation(notes="Get cache names", value="Get cache names")
    public ResponseEntity<SimpleCache> getCacheNames() throws CacheException, TechnicalException {
        try {
            SimpleCache keys = cacheService.getNames();
            return new ResponseEntity<>(keys, HttpStatus.OK);

        } catch (CacheException e) {
            throw e;

        } catch (Exception e) {
            throw new TechnicalException();
        }
    }

    @LogMethod
    @LogExecutionTime
    @RequestMapping(value="/{name}", method=RequestMethod.GET)
    @ApiOperation(notes="Get cache keys", value="Get cache keys")
    public ResponseEntity<SimpleCache> getCacheKeys(@ApiParam(value="Cache name", required=true) @PathVariable String name) throws CacheException, TechnicalException {
        try {
            SimpleCache keys = cacheService.getKeys(name);
            return new ResponseEntity<>(keys, HttpStatus.OK);

        } catch (CacheException e) {
            throw e;

        } catch (Exception e) {
            throw new TechnicalException();
        }
    }

}
