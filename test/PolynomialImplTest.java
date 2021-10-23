import static org.junit.Assert.assertEquals;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import polynomial.Polynomial;
import polynomial.PolynomialImpl;

/**
 * Testing class to test the methods of polynomial implementation class.
 */
public class PolynomialImplTest {

  Polynomial test;
  Polynomial test2;
  Polynomial test3;
  Polynomial test4;


  @Before
  public void setup() {
    test = new PolynomialImpl();
    test2 = new PolynomialImpl();
  }


  @Test
  public void add() {
    test.addTerm(5, 3);
    test.addTerm(4, 2);
    test.addTerm(3, 2);
    test2.addTerm(5, 5);
    test3 = new PolynomialImpl("5x^3 +2x^1 -10");
    test4 = new PolynomialImpl("6x^6 -5x^4 +2x^2");
    assertEquals("5x^5 +5x^3 +7x^2", test.add(test2).toString());
    assertEquals("6x^6 -5x^4 +5x^3 +2x^2 +2x^1 -10", test3.add(test4).toString());
  }


  @Test
  public void addTerm() {
    test.addTerm(5, 3);
    test.addTerm(4, 2);
    test.addTerm(4, 2);
    test.addTerm(12, 0);
    assertEquals("5x^3 +8x^2 +12", test.toString());
  }

  @Test
  public void isSame() {
    test.addTerm(5, 3);
    test.addTerm(4, 2);
    test2.addTerm(4, 2);
    test2.addTerm(5, 3);
    //test2.addTerm(4, 2);
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
    assertEquals(test.getCoefficient(3), 5);
  }

  @Test
  public void getDegree() {
    test.addTerm(5, 3);
    test.addTerm(4, 2);
    //test.addTerm(-4,3);
    assertEquals(3, test.getDegree());
  }

  @Test
  public void testToString() {
    test3 = new PolynomialImpl("5x^3 +8x^2 +12");
    assertEquals("5x^3 +8x^2 +12", test3.toString());
    //System.out.println(test.toString());
  }

  @Test
  public void stringConstructor() {
    test3 = new PolynomialImpl("3x^5 +3x^4 -2x^1 -5");
    assertEquals("[3x^5 +3x^4 -2x^1 -5]", "[" + test3.toString() + "]");
  }
}