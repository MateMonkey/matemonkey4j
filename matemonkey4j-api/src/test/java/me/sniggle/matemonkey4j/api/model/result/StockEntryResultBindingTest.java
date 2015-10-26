package me.sniggle.matemonkey4j.api.model.result;

import me.sniggle.matemonkey4j.api.model.Quantity;
import me.sniggle.matemonkey4j.api.model.StockEntry;
import me.sniggle.matemonkey4j.api.model.StockStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author tuxbox, sniggle.me
 */
public class StockEntryResultBindingTest extends BaseAPIResultBindingTest<StockEntryResult> {

  public StockEntryResultBindingTest() {
    super(StockEntryResult.class, "/stock.json");
  }

  @Test
  public void testBinding() {
    assertNotNull(getResultType());
    assertEquals(1, getResultType().getCount());
    assertEquals(1, getResultType().getEntries().size());
    StockEntry entry = getResultType().getEntries().get(0);
    assertNotNull(entry);
    assertNotNull(entry.getProduct());
    assertEquals("2015-05-20T09:20:03+00:00", entry.getCreatedAt());
    assertEquals("?", entry.getPrice());
    assertEquals(Quantity.CRATE, entry.getQuantity());
    assertEquals(StockStatus.UNKNOWN, entry.getStatus());
  }

}
