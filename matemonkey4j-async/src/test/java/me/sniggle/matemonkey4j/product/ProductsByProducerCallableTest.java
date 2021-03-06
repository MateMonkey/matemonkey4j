package me.sniggle.matemonkey4j.product;

import me.sniggle.matemonkey4j.api.model.result.ProductResult;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author tuxbox, sniggle.me
 */
public class ProductsByProducerCallableTest {

  private ProductsByProducerCallable productsCallable;

  @Before
  public void setup() {
    productsCallable = new ProductsByProducerCallable(1);
  }

  @Test
  public void testCall() throws Exception {
    ProductResult productResult = productsCallable.call();
    assertNotNull(productResult);
    assertTrue(productResult.getCount() >= 6);
    assertNotNull(productResult.getProducts());
    assertTrue(productResult.getProducts().size() >= 6);
    assertEquals(productResult.getCount(), productResult.getProducts().size());
  }

  @After
  public void  cleanUp() {
    productsCallable = null;
  }

}
