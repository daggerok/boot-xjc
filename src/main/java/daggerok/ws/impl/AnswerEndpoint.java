package daggerok.ws.impl;

import daggerok.DaggerokRequest;
import daggerok.DaggerokResponse;
import daggerok.ws.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Component
public class AnswerEndpoint {

    private static final String NAMESPACE_URI = "http://github.com/daggerok/ws/v1";
    private AnswerRepository answerRepo;

    @Autowired
    public AnswerEndpoint(AnswerRepository answerRepo) {
        this.answerRepo = answerRepo;
    }

    @ResponsePayload
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "daggerokRequest")
    public DaggerokResponse getAnswer(@RequestPayload DaggerokRequest question) {

        final DaggerokResponse answer = new DaggerokResponse();

        answer.setAnswer(answerRepo.getAnswer(question));
        return answer;
    }
}
