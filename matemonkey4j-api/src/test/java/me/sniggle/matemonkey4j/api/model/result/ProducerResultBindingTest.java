package me.sniggle.matemonkey4j.api.model.result;

import me.sniggle.matemonkey4j.api.model.Address;
import me.sniggle.matemonkey4j.api.model.Producer;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author tuxbox, sniggle.me
 */
public class ProducerResultBindingTest extends BaseAPIResultBindingTest<ProducerResult> {

  public ProducerResultBindingTest() {
    super(ProducerResult.class, "/producers.json");
  }

  @Test
  public void testBinding() {
    assertNotNull(getResultType());
    assertEquals(17, getResultType().getCount());
    assertEquals(17, getResultType().getProducers().size());
    Producer producer = getResultType().getProducers().get(0);
    //assumption: if one binds correctly, all do
    assertEquals(1L, producer.getId());
    assertEquals("Brauerei Loscher GmbH & Co. KG", producer.getName());
    assertEquals("loscher", producer.getSlug());
    assertNull(producer.getDescription());
    assertNull(producer.getImage());
    assertNotNull(producer.getAddress());
    Address address = producer.getAddress();
    assertEquals("Steigerwaldstrasse", address.getStreet());
    assertEquals("21-23", address.getNumber());
    assertEquals("Germany", address.getCountry());
    assertEquals("Münchsteinach", address.getCity());
    assertEquals("91481", address.getPostal());
    assertEquals(49.64104, address.getLatitude(), 0.0);
    assertEquals(10.59215, address.getLongitude(), 0.0);
    assertEquals("http://www.clubmate.de/", address.getWeb());
    assertEquals("info@club-mate.de", address.getEmail());
    assertEquals("+49(0)9166607", address.getPhone());
  }



}
