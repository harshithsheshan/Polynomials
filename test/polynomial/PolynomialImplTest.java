package polynomial;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PolynomialImplTest {

  Polynomial test;
  Polynomial test2;

  @Before
  public void setup() {
    test = new PolynomialImpl();
    test2 = new PolynomialImpl();
  }

  @Test
  public void add() {
    System.out.println(test.add(test2).toString());
  }

  @Test
  public void addTerm() {
    test.addTerm(5, 3);
    test.addTerm(4, 2);
    test.addTerm(-4,4);
    System.out.println(test.toString());
    Assert.assertEquals("-4x^4 +4x^2 +5x^3 ", test.toString());
  }

  @Test
  public void isSame() {
    test.addTerm(5, 3);
    test.addTerm(4, 2);
    test2.addTerm(4, 2);
    test2.addTerm(5, 3);
   // test2.addTerm(4, 2);
    Assert.assertTrue(test.isSame(test2));


  }

  @Test
  public void evaluate() {
    test.addTerm(5, 3);
    test.addTerm(4, 2);
    //System.out.println(test.evaluate(5.4));
    Assert.assertTrue(test.evaluate(5.4) - 903.96 < 0.01);
    //System.out.println(test.evaluate(-2));
    Assert.assertTrue(test.evaluate(-2) + 24 < 0.01);
  }

  @Test
  public void getCoefficient() {
    test.addTerm(5, 3);
    test.addTerm(4, 2);
    //System.out.println(test.getCoefficient(3));
    Assert.assertEquals(test.getCoefficient(3), 5);
  }

  @Test
  public void getDegree() {
    test.addTerm(5, 3);
    test.addTerm(4, 2);
    //test.addTerm(-4,3);
    Assert.assertEquals(3, test.getDegree());
  }

  @Test
  public void getHead() {
    test.getHead();

  }

  @Test
  public void testToString() {
    System.out.println(test.toString());
  }
}