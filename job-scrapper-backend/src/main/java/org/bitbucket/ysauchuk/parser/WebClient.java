package org.bitbucket.ysauchuk.parser;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@Slf4j
@RequiredArgsConstructor
public class WebClient<T> {

  public List<T> fetchVacancies(String url, ResponseHandler<T> responseHandler) {
    try {
      Document doc = Jsoup.connect(url).get();
      return responseHandler.handle(doc);
    } catch (IOException e) {
      log.error("Error while making request to {}", url);
      return Collections.emptyList();
    }
  }
}
