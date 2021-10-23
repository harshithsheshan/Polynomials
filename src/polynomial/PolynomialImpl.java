package polynomial;

/**
 * Represents a class which denotes a polynomial with a head which refers to a listOfTerm object.
 * It can have 0 to n number of elements.
 */
public class PolynomialImpl implements Polynomial {
  private ListOfTerm head;

  private PolynomialImpl(ListOfTerm head) {
    this.head = head;
  }

  /**
   * Constructor to instantiate a polynomial object from a string.
   * @param str input string
   */
  public PolynomialImpl(String str) {
    head = new TermEmptyNode();
    String[] strArr = str.split("\\s+");
    for (String s : strArr) {
      String[] var = s.split("x\\^");
      if (var.length == 2) {
        if (Integer.parseInt(var[1]) < 0) {
          throw new IllegalArgumentException();
        }
        head = head.addNext(Integer.parseInt(var[0]), Integer.parseInt(var[1]));
      } else if (var.length == 1) {
        head = head.addNext(Integer.parseInt(var[0]), 0);
      } else {
        throw new IllegalArgumentException();
      }
    }

  }
  //System.out.println(list);

  /**
   * default constructor which creates an empty polynomial with an emptyNode.
   */
  public PolynomialImpl() {
    this.head = new TermEmptyNode();
  }

  /**
   * Add this polynomial to another and return the result as another polynomial.
   *
   * @param other the other polynomial to be added
   * @return the resulting polynomial
   * @throws IllegalArgumentException if parameter is not the same concrete type
   *                                  as the current object.
   */
  @Override
  public Polynomial add(Polynomial other) throws IllegalArgumentException {
    if (!(other instanceof PolynomialImpl)) {
      throw new IllegalArgumentException();
    }
    TermElementNode otherClone = new TermElementNode(((PolynomialImpl) other).head.getCoefficient(),
        ((PolynomialImpl) other).head.getPower(), ((PolynomialImpl) other).head.getNext());
    return new PolynomialImpl(head.add(otherClone));
  }

  /**
   * Add a term to this polynomial with the specified coefficient and power.
   *
   * @param coefficient the coefficient of the term to be added
   * @param power       the power of the term to be added
   * @throws IllegalArgumentException if the power is negative
   */
  @Override
  public void addTerm(int coefficient, int power) throws IllegalArgumentException {
    head = head.addNext(coefficient, power);
  }

  /**
   * Determines if this polynomial is the same as the parameter polynomial.
   *
   */
  @Override
  public boolean isSame(Polynomial poly) {
    if (!(poly instanceof PolynomialImpl)) {
      return false;
    }
    return head.isSame(((PolynomialImpl) poly).head);
  }

  /**
   * Evaluate the value of this polynomial at the given value of the variable.
   *
   * @param x the value at which the polynomial is to be evaluated.
   * @return the value of the polynomial at x
   */
  @Override
  public double evaluate(double x) {
    return head.value(x);
  }

  /**
   * Return the coefficient of the term with the given power.
   *
   * @param power the power whose coefficient is sought
   * @return the coefficient at the given power
   */
  @Override
  public int getCoefficient(int power) {
    return head.getCoefficientOf(power);
  }

  /**
   * Get the degree of this polynomial.
   *
   * @return the degree of this polynomial as a whole number
   */
  @Override
  public int getDegree() {
    return head.getDegree();
  }

  /**
   * To convert the Polynomial to a human-readable format.
   * @return String
   */
  @Override
  public String toString() {
    return head.toString();
  }
}
