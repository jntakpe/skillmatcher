package com.github.jntakpe.skillmatcher.service;

import com.github.jntakpe.skillmatcher.domain.Question;
import com.github.jntakpe.skillmatcher.repository.QuestionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jntakpe
 */
@Service
public class QuestionService {

    private static final Logger LOGGER = LoggerFactory.getLogger(QuestionService.class);

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Transactional(readOnly = true)
    public List<Question> findAll() {
        LOGGER.debug("Recherche des questions");
        return questionRepository.findAll();
    }

    @Transactional
    public Question save(Question question) {
        LOGGER.info("Enregistrement de la question {}", question);
        return questionRepository.save(question);
    }

    @Transactional
    public void delete(Long id) {
        Question question = questionRepository.findOne(id);
        LOGGER.info("Suppression de la question {}", question);
        questionRepository.delete(question);
    }
}
