package org.bitbucket.ysauchuk.parser;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bitbucket.ysauchuk.properties.DevByProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@Slf4j
@RequiredArgsConstructor
public class DevByVacancyScrapper implements VacancyScrapper {

  private final DevByProperties properties;
  private final VacancyDetailsResponseHandler vacancyDetailsResponseHandler;

  @Override
  public List<Vacancy> fetchVacancies() {
    ResponseHandler<Vacancy> responseHandler = new VacancyListResponseHandler();
    WebClient<Vacancy> client = new WebClient<>();
    List<Vacancy> vacancies = client.fetchVacancies(properties.getVacancyListUrl(), responseHandler);
    return
      vacancies.stream()
        .map(this::initDetailsFor)
        .collect(Collectors.toList());
  }

  private Vacancy initDetailsFor(Vacancy vacancy) {
    WebClient<String> client = new WebClient<>();

    String url =
      UriComponentsBuilder
        .fromUriString(properties.getBaseUrl())
        .path(vacancy.getLink())
        .build()
        .toUriString();

    List<String> skills = client.fetchVacancies(url, vacancyDetailsResponseHandler);

    log.info("{} skills fetched for vacancy {}", skills.size(), vacancy.getName());

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      log.error(e.getLocalizedMessage());
    }

    return
      vacancy
        .copyBuilder()
        .skills(skills)
        .build();
  }

}
