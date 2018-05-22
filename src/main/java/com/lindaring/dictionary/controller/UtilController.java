package com.lindaring.dictionary.controller;

import com.lindaring.dictionary.annotation.LogExecutionTime;
import com.lindaring.dictionary.annotation.LogMethod;
import com.lindaring.dictionary.exception.TechnicalException;
import com.lindaring.dictionary.utils.SimpleUtils;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/simple-dictionary/v1/util")
public class UtilController {

    @LogMethod
    @LogExecutionTime
    @RequestMapping(value="/year", method=RequestMethod.GET)
    @ApiOperation(notes="Get the current year", value="Get the current year")
    public ResponseEntity<Integer> getCurrentYear() throws TechnicalException {
        try {
            return new ResponseEntity<>(SimpleUtils.getCurrentYear(), HttpStatus.OK);

        } catch (Exception e) {
            throw new TechnicalException();
        }
    }

}
