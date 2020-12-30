package org.bitbucket.ysauchuk.parser;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev-by")
@RequiredArgsConstructor
public class DevByVacancyScrapperController {

  private final DevByVacancyScrapper devByVacancyScrapper;

  @GetMapping("/vacancies")
  public List<Vacancy> scrapVacanciesFromDevBy() {
    return devByVacancyScrapper.fetchVacancies();
  }

}
