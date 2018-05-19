package com.lindaring.dictionary.controller;

import com.lindaring.dictionary.annotation.LogExecutionTime;
import com.lindaring.dictionary.annotation.LogMethod;
import com.lindaring.dictionary.exception.CacheException;
import com.lindaring.dictionary.exception.TechnicalException;
import com.lindaring.dictionary.model.Cache;
import com.lindaring.dictionary.service.CacheService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    @ApiOperation(notes="Get cache keys", value="Get cache keys")
    public ResponseEntity<Cache> getCacheKeys() throws CacheException, TechnicalException {
        try {
            Cache keys = cacheService.getAllKeys();
            return new ResponseEntity<>(keys, HttpStatus.OK);

        } catch (CacheException e) {
            throw e;

        } catch (Exception e) {
            throw new TechnicalException();
        }
    }

}
