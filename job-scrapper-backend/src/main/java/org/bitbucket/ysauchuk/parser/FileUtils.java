package org.bitbucket.ysauchuk.parser;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public final class FileUtils {

  private FileUtils() {
    throw new UnsupportedOperationException();
  }

  public static Document readDocumentFromFile(String file) throws URISyntaxException, IOException {
    URL path = ClassLoader.getSystemResource(file);
    File input = new File(path.toURI());
    return Jsoup.parse(input, StandardCharsets.UTF_8.name());
  }
}
