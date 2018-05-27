package com.lindaring.dictionary.controller;

import com.lindaring.dictionary.annotation.LogExecutionTime;
import com.lindaring.dictionary.annotation.LogMethod;
import com.lindaring.dictionary.enumerator.Language;
import com.lindaring.dictionary.exception.LanguageNotSupportedException;
import com.lindaring.dictionary.exception.NoImplementationException;
import com.lindaring.dictionary.exception.TechnicalException;
import com.lindaring.dictionary.exception.WordNotFoundException;
import com.lindaring.dictionary.model.Word;
import com.lindaring.dictionary.properties.MessageProperties;
import com.lindaring.dictionary.service.DefinitionService;
import com.lindaring.dictionary.service.TranslationService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.util.StringUtils.isEmpty;

@RestController
@RequestMapping(value="/simple-dictionary/v1/word")
public class WordController {

    @Autowired
    private DefinitionService dictionaryService;

    @Autowired
    private TranslationService translationService;

    @Autowired
    private MessageProperties messages;

    @LogMethod
    @LogExecutionTime
    @RequestMapping(value="/{word}", method=RequestMethod.GET)
    @ApiOperation(notes="Get word definition", value="Get word definition")
    public ResponseEntity<Word> getDefinition(@ApiParam(value="Word to search", required=true) @PathVariable String word) throws WordNotFoundException, TechnicalException {
        try {
            if (isEmpty(word))
                throw new WordNotFoundException(messages.getWord().getWordNotProvided());

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
    @RequestMapping(value="/{word}/translate", method=RequestMethod.GET)
    @ApiOperation(notes="Translate the word", value="Translate the word")
    public ResponseEntity<Word> getTranslation(@ApiParam(value="Word to translate", required=true) @PathVariable String word,
                        @ApiParam(value="Translate from language", required=true) @RequestParam String source,
                        @ApiParam(value="Translate to language", required=true) @RequestParam String target) throws WordNotFoundException, TechnicalException {
        try {
            if (isEmpty(word))
                throw new WordNotFoundException(messages.getWord().getWordNotProvided());
            else if (isEmpty(source))
                throw new LanguageNotSupportedException(messages.getTranslation().getSourceNotProvided());
            else if (isEmpty(target))
                throw new LanguageNotSupportedException(messages.getTranslation().getTargetNotProvided());

            Word translation = translationService.getTranslation(word, Language.get(source, messages), Language.get(target, messages));
            return new ResponseEntity<>(translation, HttpStatus.OK);

        } catch (WordNotFoundException e) {
            throw e;

        } catch (Exception e) {
            throw new TechnicalException();
        }
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
