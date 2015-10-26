package me.sniggle.matemonkey4j.api.query;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author tuxbox, sniggle.me
 */
public class SearchQueryBuilderTest {

  private SearchQueryBuilder searchQueryBuilder;

  @Before
  public void setup() {
    searchQueryBuilder = SearchQueryBuilder.create();
  }

  @Test
  public void testJustOneTerm() {
    String result = searchQueryBuilder
                      .searchTerm("Köln")
                      .build().toQuery();
    assertEquals("query=K%C3%B6ln", result);
  }

  @Test
  public void testCallTermTwiceReplace() {
    String result = searchQueryBuilder
        .searchTerm("Berlin")
        .searchTerm("Köln")
        .build().toQuery();
    assertEquals("query=K%C3%B6ln", result);
  }

  @After
  public void cleanUp() {

  }

}
