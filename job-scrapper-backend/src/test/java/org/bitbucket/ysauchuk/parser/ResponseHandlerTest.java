package org.bitbucket.ysauchuk.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

public class ResponseHandlerTest {

  @Test
  public void parseVacancyResponseTest() throws IOException, URISyntaxException {
    // given a response
    // and response handler
    ResponseHandler<Vacancy> handler = new VacancyListResponseHandler();
    Document response = FileUtils.readDocumentFromFile("response/vacancies_response.html");

    // when the response is handled
    List<Vacancy> vacancies = handler.handle(response);

    // then count of policies is equal to expected value
    assertEquals(67, vacancies.size());

  }

}
