package org.bitbucket.ysauchuk.parser;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VacancyDetailsResponseHandler implements ResponseHandler<String> {

  private final VacancyParser vacancyParser;

  @Override
  public List<String> handle(Document doc) {
    return vacancyParser.parseSkills(doc);
  }

}
