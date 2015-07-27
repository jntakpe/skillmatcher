package com.github.jntakpe.skillmatcher.resource;

import com.github.jntakpe.skillmatcher.config.UrlConstants;
import com.github.jntakpe.skillmatcher.domain.Question;
import com.github.jntakpe.skillmatcher.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author jntakpe
 */
@RestController
@RequestMapping(UrlConstants.QUESTIONS)
public class QuestionResource {

    private QuestionService questionService;

    @Autowired
    public QuestionResource(QuestionService questionService) {
        this.questionService = questionService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Question> list() {
        return questionService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Question> create(@RequestBody @Valid Question question) {
        return new ResponseEntity<>(questionService.save(question), HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Question update(@PathVariable Long id, @RequestBody @Valid Question question) {
        return questionService.save(question);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        questionService.delete(id);
    }
}
