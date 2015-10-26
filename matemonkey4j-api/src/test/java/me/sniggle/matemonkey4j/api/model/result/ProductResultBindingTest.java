package me.sniggle.matemonkey4j.api.model.result;

import me.sniggle.matemonkey4j.api.model.Address;
import me.sniggle.matemonkey4j.api.model.Producer;
import me.sniggle.matemonkey4j.api.model.Product;
import me.sniggle.matemonkey4j.api.model.ProductType;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

/**
 * @author tuxbox, sniggle.me
 */
public class ProductResultBindingTest extends BaseAPIResultBindingTest<ProductResult> {

  public ProductResultBindingTest() {
    super(ProductResult.class, "/products.json");
  }

  @Test
  public void testBinding() {
    assertNotNull(getResultType());
    assertNotNull(getResultType().getProducts());
    assertEquals(32, getResultType().getCount());
    assertEquals(32, getResultType().getProducts().size());
    Product p = getResultType().getProducts().get(0);
    //take first one as example
    //assume that all are mapped fine when one is
    //mapped correctly
    assertEquals("1337mate", p.getName());
    assertEquals("25", p.getId());
    assertEquals(ProductType.SOFT_DRINK, p.getType());
    assertEquals("1337mate", p.getSlug());
    assertNull(p.getDescription());
    assertNull(p.getImage());
    Producer producer = p.getProducer();
    assertNotNull(producer);
    assertEquals("1337 und so GmbH", producer.getName());
    assertEquals(11, producer.getId());
    assertEquals("1337undsogmbh", producer.getSlug());
    assertNotNull(producer.getAddress());
    Address address = producer.getAddress();
    assertEquals("Hamburg", address.getCity());
    assertEquals("Germany", address.getCountry());
    assertEquals("info@leetmate.de", address.getEmail());
    assertEquals("22", address.getNumber());
    assertEquals("+49(0)4030720081", address.getPhone());
    assertEquals("20146", address.getPostal());
    assertEquals("Papendamm", address.getStreet());
    assertEquals("http://www.1337mate.com/", address.getWeb());
    assertEquals(53.56612, address.getLatitude(), 0.0);
    assertEquals(9.9755, address.getLongitude(), 0.0);
  }

}
