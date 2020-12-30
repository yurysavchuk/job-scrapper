package org.bitbucket.ysauchuk.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;

public class VacancyParserTest {

  @Test
  public void parseVacanciesTest() throws IOException, URISyntaxException {
    // given
    VacancyParser parser = new VacancyParser();
    Document response = FileUtils.readDocumentFromFile("response/vacancies_response.html");

    // when
    List<Vacancy> vacancies = parser.parse(response);

    // then
    assertEquals(67, vacancies.size());
  }

  @Test
  public void parseVacancySkillsTest() throws IOException, URISyntaxException {
    // given
    VacancyParser parser = new VacancyParser();
    Document response = FileUtils.readDocumentFromFile("response/vacancy_details_response.html");

    // when
    List<String> skills = parser.parseSkills(response);

    // then
    assertEquals(5, skills.size());
  }
}
