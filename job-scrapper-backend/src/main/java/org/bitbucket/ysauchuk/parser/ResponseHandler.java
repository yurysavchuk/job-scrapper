package org.bitbucket.ysauchuk.parser;

import java.util.List;
import org.jsoup.nodes.Document;

public interface ResponseHandler<T> {

  List<T> handle(Document doc);

}
