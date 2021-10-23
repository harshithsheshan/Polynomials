package polynomial;

class TermEmptyNode implements ListOfTerm {

  @Override
  public ListOfTerm getNext() {
    return null;
  }

  @Override
  public double value(double x) {
    return 0;
  }

  @Override
  public double valueHelper(double x, double res) {
    return res;
  }

  @Override
  public int getCoefficient() {
    return 0;
  }

  @Override
  public int getPower() {
    return 0;
  }

  @Override
  public ListOfTerm addNext(int coefficient, int power) {
    ListOfTerm newNode;
    newNode = new TermElementNode(coefficient, power, this);
    return newNode;
  }

  @Override
  public String toString() {
    return toStringHelper(new StringBuilder("0"));
  }

  @Override
  public int getDegree() {
    return 0;
  }

  @Override
  public boolean isSame(ListOfTerm otherHead) {
    return true;
  }

  @Override
  public boolean isSameHelper(ListOfTerm otherHead, boolean res) {
    return true;
  }

  @Override
  public int getCoefficientOf(int power) {
    return 0;
  }

  @Override
  public int getLen() {
    return 0;
  }

  @Override
  public int getNumTerms(int len) {
    return len;
  }

  @Override
  public ListOfTerm add(ListOfTerm other) {
    return addAcc(other);
  }

  @Override
  public ListOfTerm addAcc(ListOfTerm accOther) {
    return accOther;
  }

  public int getDegreeHelper(int deg) {
    return deg;
  }

  @Override
  public String toStringHelper(StringBuilder str) {
    return str.toString().trim();
  }

}
