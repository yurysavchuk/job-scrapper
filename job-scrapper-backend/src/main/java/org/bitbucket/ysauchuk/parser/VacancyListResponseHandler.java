package org.bitbucket.ysauchuk.parser;

import java.util.List;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

@Component
public class VacancyListResponseHandler implements ResponseHandler<Vacancy> {

  @Override
  public List<Vacancy> handle(Document doc) {
    VacancyParser vacancyParser = new VacancyParser();
    return vacancyParser.parse(doc);
  }

}
