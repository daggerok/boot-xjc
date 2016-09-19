package daggerok.ws;

import daggerok.DaggerokRequest;

public interface AnswerRepository {

    String getAnswer(DaggerokRequest question);
}
