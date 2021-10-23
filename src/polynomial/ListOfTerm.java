package polynomial;

/**
 * Interface to hold terms of a polynomial. A polynomial can have 0 to n number of terms for this
 * purpose we choose a linked list to represent a polynomial.
 */
interface ListOfTerm {

  /**
   * To get the next term in the list.
   */
  ListOfTerm getNext();

  /**
   * To find the value of each term in the polynomial.
   * @param x variable to replace x with
   * @return returns the value computed when x is replaced with the value provided
   */
  double value(double x);

  /**
   * Helper function for the value  function which calls the valueHelper recursively till the last
   * term and returns the accumulator.
   * @param x value to be substituted
   * @param res accumulator that carries the value and is returned
   * @return the accumulated result when each term is substituted with x
   */
  double valueHelper(double x, double res);

  /**
   * To get the coefficient of the current term.
   * @return integer coefficient
   */
  int getCoefficient();


  /**
   *To get the power of the current term.
   * @return integer power
   */
  int getPower();

  /**
   * To add term to the listOfTerms object.
    * @param coefficient Coefficient of the new term
   * @param power power of the new term
   * @return reference to head
   */
  ListOfTerm addNext(int coefficient, int power);

  /**
   * To help the toString Method to call the method recursively and accumulate a stringBuilder.
   * @param str String Builder which accumulates
   * @return String value of the accumulator
   */
  String  toStringHelper(StringBuilder str);

  /**
   * To help the getDegree method by calling this method recursively and accumulate the highest
   * power of the ListOfTerm.
   * @param deg accumulator which has the highest power
   * @return Integer degree
   */
  int getDegreeHelper(int deg);

  /**
   * To convert each term of the listOfTerm to string and human-readable format.
   * @return String.
   */
  String toString();

  /**
   * to get the degree of the listOfTerm object that is the highest power in the object.
   * @return integer degree
   */
  int getDegree();

  /**
   * to check if two terms are same which compares the coefficient and the power.
   * @param otherHead head of the other object which we compare with
   * @return boolean true/false
   */
  boolean isSame(ListOfTerm otherHead);

  /**
   * to help the isSame method call recursively for all terms of the object.
   * @param otherHead head of the other object
   * @param res accumulator which carries the result of each comparison.
   * @return boolean true/false
   */
  boolean isSameHelper(ListOfTerm otherHead, boolean res);

  /**
   * to get the coefficient of a particular power in the list of terms.
   * @param power the power corresponding to the coefficient
   * @return the coefficient
   */
  int getCoefficientOf(int power);

  /**
   * get the lenght of the listOfTerm object.
   * @return integer length
   */
  int getLen();

  /**
   * helper for getLen method which counts the number of terms in the object.
   * @param len accumulator
   * @return accumulator value at the end
   */
  int getNumTerms(int len);

  /**
   * Method to add two listOfTerm objects to each other.
   * @param other the other object which needs to be added and also the accumulator.
   * @return accumulator string
   */
  ListOfTerm add(ListOfTerm other);/**


   * Helper to add two listOfTerm objects to each other.
   * @param accOther the other object which needs to be added and also the accumulator.
   * @return accumulator string
   */
  ListOfTerm addAcc(ListOfTerm accOther);
}
