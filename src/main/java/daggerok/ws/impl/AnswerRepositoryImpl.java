package daggerok.ws.impl;

import daggerok.DaggerokRequest;
import daggerok.ws.AnswerRepository;
import org.springframework.stereotype.Component;

@Component
public class AnswerRepositoryImpl implements AnswerRepository {

    @Override
    public String getAnswer(DaggerokRequest question) {
        return "hi ws!";
    }
}
