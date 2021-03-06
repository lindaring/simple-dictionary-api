package com.lindaring.dictionary.controller;

import com.lindaring.dictionary.annotation.LogExecutionTime;
import com.lindaring.dictionary.annotation.LogMethod;
import com.lindaring.dictionary.exception.NoImplementationException;
import com.lindaring.dictionary.exception.TechnicalException;
import com.lindaring.dictionary.exception.WordNotFoundException;
import com.lindaring.dictionary.model.Word;
import com.lindaring.dictionary.service.DictionaryService;
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
@RequestMapping(value="/simple-dictionary/v1/word")
public class WordController {

    @Autowired
    private DictionaryService dictionaryService;

    @LogMethod
    @LogExecutionTime
    @RequestMapping(value="/{word}", method=RequestMethod.GET)
    @ApiOperation(notes="Get word definition", value="Get word definition")
    public ResponseEntity<Word> getDefinition(@ApiParam(value="Word to search", required=true) @PathVariable String word) throws WordNotFoundException, TechnicalException {
        try {
            Word meaning = dictionaryService.getWord(word);
            return new ResponseEntity<>(meaning, HttpStatus.OK);

        } catch (WordNotFoundException e) {
            throw e;

        } catch (Exception e) {
            throw new TechnicalException();
        }
    }

    @LogMethod
    @LogExecutionTime
    @RequestMapping(value="/{word}/translate/{lang}", method=RequestMethod.GET)
    @ApiOperation(notes="Translate the word", value="Translate the word")
    public int getTranslation(@ApiParam(value="Word to translate", required=true) @PathVariable String word,
                              @ApiParam(value="Language", required=true) @PathVariable String lang) throws InterruptedException {
        Thread.sleep(1000);
        return 100;
    }

    @LogMethod
    @LogExecutionTime
    @RequestMapping(value="/{word}/spelling", method=RequestMethod.GET)
    @ApiOperation(notes="Get possible words", value="Get possible words")
    public int getSpelling(@ApiParam(value="Word to search", required=true) @PathVariable String word) throws NoImplementationException, InterruptedException {
        Thread.sleep(2000);
        throw new NoImplementationException();
    }
    
}
