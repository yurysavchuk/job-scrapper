package org.bitbucket.ysauchuk.parser;

import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

@Component
public class VacancyParser {

  private static final String VACANCY_LIST_CLASS = ".vacancies-list-item__link_block";
  private static final String VACANCY_SKILL_CLASS = ".vacancy__tags__item";
  private static final String VACANCY_TEXT_CLASS = ".vacancy__text";

  public List<Vacancy> parse(Document doc) {

    Elements vacancyElements = doc.select(VACANCY_LIST_CLASS);

    return
      vacancyElements
        .stream()
        .map(element ->
          Vacancy.builder()
            .name(element.text())
            .link(element.attr("href"))
            .build()
        ).collect(Collectors.toList());
  }

  public List<String> parseSkills(Document doc) {
    Elements skillElements = doc.select(VACANCY_SKILL_CLASS);

    Elements vacancyBody = doc.select(VACANCY_TEXT_CLASS);

    //TODO use dictionary with technology names to look up for
    // the vacancies in the text body of a vacancy

    return
      skillElements
        .stream()
        .map(Element::text)
        .collect(Collectors.toList());

  }

}
