package org.bitbucket.ysauchuk.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "dev.by")
public class DevByProperties {

  private String baseUrl;
  private String vacancyListUrl;

}
