package me.sniggle.matemonkey4j.api.model.result;

import me.sniggle.matemonkey4j.api.model.Address;
import me.sniggle.matemonkey4j.api.model.Dealer;
import me.sniggle.matemonkey4j.api.model.DealerType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author tuxbox, sniggle.me
 */
public class DealersResultBindingTest extends BaseAPIResultBindingTest<DealerResult> {

  public DealersResultBindingTest() {
    super(DealerResult.class, "/dealers.json");
  }

  @Test
  public void testBinding() {
    DealerResult result = getResultType();
    assertNotNull(result);
    assertEquals(3425, result.getCount());
    assertEquals(3425, result.getDealers().size());
    Dealer dealer = result.getDealers().get(0);
    assertEquals(1, dealer.getId());
    assertEquals("Brausedealer", dealer.getName());
    assertEquals("2015-05-20T09:19:21+00:00", dealer.getCreatedAt());
    assertEquals("EUR", dealer.getCurrency());
    assertEquals("", dealer.getNote());
    assertEquals("brausedealer", dealer.getSlug());
    assertEquals(DealerType.RETAIL, dealer.getType());
    assertEquals("2015-05-20T23:49:17+00:00", dealer.getUpdatedAt());
    assertNotNull(dealer.getAddress());
    Address address = dealer.getAddress();
    assertEquals("Hannover", address.getCity());
    assertEquals("Germany", address.getCountry());
    assertNull(address.getEmail());
    assertEquals(52.3761, address.getLatitude(), 0.0);
    assertEquals(9.70221, address.getLongitude(), 0.0);
    assertEquals("33", address.getNumber());
    assertEquals("", address.getPhone());
    assertEquals("Erderstraße", address.getStreet());
    assertEquals("", address.getWeb());
    assertEquals("30451", address.getPostal());
  }

}
