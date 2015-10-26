package me.sniggle.matemonkey4j.api.query;

import me.sniggle.matemonkey4j.api.model.DealerType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author tuxbox, sniggle.me
 */
public class DealerQueryBuilderTest {

  private DealerQueryBuilder dealerQueryBuilder;

  @Before
  public void setup() {
    dealerQueryBuilder = DealerQueryBuilder.create();
  }

  @Test
  public void testBboxOnly() {
    String result = dealerQueryBuilder.bbox(50.90, 6.90, 51.0, 7.0).build().toQuery();
    assertEquals("bbox=50.9,6.9,51.0,7.0", result);
  }

  @Test
  public void testOneDealerType() {
    String result = dealerQueryBuilder
        .bbox(50.90, 6.90, 51.0, 7.0)
        .addDealerType(DealerType.RETAIL)
        .build().toQuery();
    assertEquals("bbox=50.9,6.9,51.0,7.0&type=retail", result);
  }

  @Test
  public void testAllDealerTypes() {
    for( DealerType d : DealerType.values() ) {
      dealerQueryBuilder.addDealerType(d);
    }
    String result = dealerQueryBuilder.build().toQuery();
    assertTrue(result.contains("type="));
    assertTrue(result.contains("hackerspace"));
    assertTrue(result.contains("retail"));
    assertTrue(result.contains("club"));
    assertTrue(result.contains("bar"));
    assertTrue(result.contains("restaurant"));
    assertTrue(result.contains("other"));
    assertTrue(result.contains("community"));
    assertFalse(result.endsWith(","));
    assertFalse(result.endsWith("&"));
  }



  @Test
  public void testOneProductId() {
    assertEquals("product=4711", dealerQueryBuilder
        .addProductId("4711")
        .build().toQuery());
  }

  @Test
  public void testMultipleProductIds() {
    String result = dealerQueryBuilder
        .addProductId("4711")
        .addProductId("1948")
        .build().toQuery();
    assertTrue(result.contains("product="));
    assertTrue(result.contains("4711"));
    assertTrue(result.contains("1948"));
    assertFalse(result.endsWith(","));
    assertFalse(result.endsWith("&"));
  }

  @Test
  public void testCombinationAndOmissionOfDuplicates() {
    String result = dealerQueryBuilder
        .bbox(50.90, 6.90, 51.0, 7.0)
        .addDealerType(DealerType.RETAIL)
        .addDealerType(DealerType.RETAIL)
        .addDealerType(DealerType.CLUB)
        .addProductId("4711")
        .addProductId("1948")
        .addProductId("4711")
        .build().toQuery();
    assertTrue(result.contains("bbox=50.9,6.9,51.0,7.0"));
    assertTrue(result.contains("type="));
    assertTrue(result.contains("retail"));
    assertTrue(result.contains("club"));
    assertTrue(result.indexOf("retail") == result.lastIndexOf("retail"));
    assertTrue(result.contains("product="));
    assertTrue(result.contains("1948"));
    assertTrue(result.contains("4711"));
    assertTrue(result.indexOf("4711") == result.lastIndexOf("4711"));
  }

  @After
  public void cleanUp() {
    dealerQueryBuilder = null;
  }

}
