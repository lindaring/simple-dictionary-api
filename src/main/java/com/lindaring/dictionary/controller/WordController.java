package com.lindaring.dictionary.controller;

import com.lindaring.dictionary.annotation.LogExecutionTime;
import com.lindaring.dictionary.exception.NoImplementationException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value="/simple-dictionary/v1/word")
public class WordController {

    @LogExecutionTime
    @RequestMapping(value="/{word}", method=RequestMethod.GET)
    @ApiOperation(notes="Get word definition", value="Get word definition")
    public int getDefinition(@ApiParam(value="Word to search", required=true) @PathVariable String word) throws NoImplementationException, InterruptedException {
        Thread.sleep(2000);
        return 100;
    }
    
}
