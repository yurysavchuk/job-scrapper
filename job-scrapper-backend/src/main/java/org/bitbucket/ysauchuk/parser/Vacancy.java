package org.bitbucket.ysauchuk.parser;

import java.util.List;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Vacancy {
  private final String name;
  private final String link;
  private final List<String> skills;

  public Vacancy.VacancyBuilder copyBuilder() {
    return
      builder()
        .name(this.name)
        .link(this.link)
        .skills(this.skills);
  }
}
