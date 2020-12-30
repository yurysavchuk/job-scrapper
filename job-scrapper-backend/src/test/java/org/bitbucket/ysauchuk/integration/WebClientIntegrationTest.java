package org.bitbucket.ysauchuk.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.bitbucket.ysauchuk.parser.ResponseHandler;
import org.bitbucket.ysauchuk.parser.Vacancy;
import org.bitbucket.ysauchuk.parser.VacancyListResponseHandler;
import org.bitbucket.ysauchuk.parser.WebClient;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

public class WebClientIntegrationTest {

  @Test
  public void vacanciesTest() {
    // given a url to get
    String url = "https://jobs.dev.by/?filter[specialization_title]=Java";

    // when make call to a site via client and get a vacancies
    ResponseHandler<Vacancy> responseHandler = new VacancyListResponseHandler();
    WebClient<Vacancy> client = new WebClient<>();
    List<Vacancy> vacancies = client.fetchVacancies(url, responseHandler);

    //assert that a list has expected number of vacancies
    assertThat(vacancies, is(not(empty())));
    assertTrue(allVacanciesHaveNamePopulated(vacancies), "Vacancy name should be filled in");
    assertTrue(allVacanciesHaveLinkPopulated(vacancies), "Vacancy link should be filled in");
  }

  private boolean allVacanciesHaveNamePopulated(List<Vacancy> vacancies) {
    return
      vacancies.stream()
        .noneMatch(vacancy -> StringUtils.isBlank(vacancy.getName()));
  }

  private boolean allVacanciesHaveLinkPopulated(List<Vacancy> vacancies) {
    return
      vacancies.stream()
        .noneMatch(vacancy -> StringUtils.isBlank(vacancy.getLink()));
  }

}
