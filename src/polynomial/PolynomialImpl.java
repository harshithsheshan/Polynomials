package polynomial;

public class PolynomialImpl implements Polynomial {
  private ListOfTerm head;

  private PolynomialImpl(ListOfTerm head) {
    this.head = head;
  }

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
    ListOfTerm res = new TermEmptyNode();
    while (this.head != null) {
      res.addNext(head.getCoefficient() + other.getCoefficient(head.getPower())
          , head.getPower());
      head = head.getNext();
    }
    return new PolynomialImpl(res);
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
    if (getCoefficient(power) != 0) {
      //Polynomial aP;
      ListOfTerm newHead;
      newHead = new TermElementNode(coefficient, power, new TermEmptyNode());
      this.add(new PolynomialImpl(newHead));
    } else {
      head = head.addNext(coefficient, power);
    }
  }

  /**
   * Determines if this polynomial is the same as the parameter polynomial.
   *
   * @param poly the polynomial to use
   * @return true if this polynomial is of the same concrete type and has the same
   * terms as the parameter, false otherwise
   */
  @Override
  public boolean isSame(Polynomial poly) {
    return head.isSame(poly.getHead());
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

  @Override
  public ListOfTerm getHead() {
    ListOfTerm res;
    res = new TermElementNode(head.getCoefficient(), head.getPower(), head.getNext());
    return res;
  }

  @Override
  public String toString() {

    return head.toString();
  }
}
