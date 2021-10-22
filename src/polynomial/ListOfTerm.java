package polynomial;

/**
 * Interface to hold terms of a polynomial. A polynomial can have 0 to n number of terms for this
 * purpose we choose a linked list to represent a polynomial.
 */
interface ListOfTerm {

  ListOfTerm getNext();

  double value(double x);

  double valueHelper(double x, double res);

  int getCoefficient();

  int getPower();

  ListOfTerm addNext(int coefficient, int power);

  public String toStringHelper(StringBuilder str);

  public int getDegreeHelper(int deg);

  String toString();

  int getDegree();

  boolean isSame(ListOfTerm otherHead);

  boolean isSameHelper(ListOfTerm otherHead, boolean res);

  int getCoefficientOf(int power);

  int getLen();

  int getNumTerms(int len);


}
