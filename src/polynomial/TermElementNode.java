package polynomial;

class TermElementNode implements ListOfTerm {

  private int coefficient;
  private int power;
  private ListOfTerm next;
  StringBuilder str;


  public TermElementNode(int coefficient, int power, ListOfTerm next) {
    if (power < 0) {
      throw new IllegalArgumentException();
    }
    this.coefficient = coefficient;
    this.next = next;
    this.power = power;
  }

  @Override
  public ListOfTerm getNext() {
    if (next instanceof TermElementNode) {
      return new TermElementNode(next.getCoefficient(), next.getPower(), next.getNext());
    } else {
      return new TermEmptyNode();
    }
  }

  @Override
  public double value(double x) {
    if (next != null) {
      double res = 0;
      return valueHelper(x, res);
    } else {
      return this.coefficient * Math.pow(x, power);
    }
  }

  @Override
  public double valueHelper(double x, double res) {
    res += this.coefficient * Math.pow(x, power);
    return next.valueHelper(x, res);
  }

  @Override
  public int getCoefficient() {
    return coefficient;
  }

  @Override
  public int getPower() {
    return power;
  }

  @Override
  public ListOfTerm addNext(int coefficient, int power) {
    if (power > this.power) {
      return new TermElementNode(coefficient, power, this);
    } else if (power < this.power) {
      next = next.addNext(coefficient, power);
      return this;
    } else {
      //System.out.println(String.format("Before: %dx^%d", this.coefficient, this.power));
      this.coefficient += coefficient;
      //System.out.println(String.format("Before: %dx^%d", this.coefficient, this.power));
      return this;
    }
    //System.out.println(newNode);

  }

  @Override
  public String toString() {
    str = new StringBuilder();
    return toStringHelper(str);
  }

  @Override
  public int getDegree() {
    int deg = 0;
    return getDegreeHelper(deg);
  }

  @Override
  public boolean isSame(ListOfTerm otherHead) {
    if (getLen() != otherHead.getLen()) {
      return false;
    } else {
      boolean res = false;
      return isSameHelper(otherHead, res);

    }
  }

  @Override
  public boolean isSameHelper(ListOfTerm otherHead, boolean res) {

    if (this.coefficient != otherHead.getCoefficientOf(this.power)) {
      return false;
    }
    return next.isSameHelper(otherHead, res);
  }


  @Override
  public int getCoefficientOf(int power) {
    if (this.power == power) {
      return this.coefficient;
    } else if (next != null) {
      return next.getCoefficientOf(power);
    } else {
      return 0;
    }
  }

  @Override
  public int getLen() {
    int len = 0;
    return getNumTerms(len);
  }

  @Override
  public int getNumTerms(int len) {
    if (next == null) {
      return len + 1;
    }
    return next.getNumTerms(len + 1);
  }

  @Override
  public ListOfTerm add(ListOfTerm otherClone) {
    return addAcc(otherClone);
  }

  /**
   * Method to add two listOfTerm objects to each other.
   *
   * @param accOther accumulator
   * @return accumulator string
   */
  @Override
  public ListOfTerm addAcc(ListOfTerm accOther) {
    accOther = accOther.addNext(coefficient, power);
    return next.addAcc(accOther);
  }

  @Override
  public String toStringHelper(StringBuilder str) {

    if (coefficient > 0) {
      if (str.length() == 0) {
        if (power > 0) {
          str.append(String.format("%dx^%d ", this.coefficient, this.power));
        } else {
          str.append(String.format("%d ", coefficient));
        }
      } else {
        if (power > 0) {
          str.append(String.format("+%dx^%d ", this.coefficient, this.power));
        } else {
          str.append(String.format("+%d ", coefficient));
        }
      }
    } else {
      if (power > 0) {
        str.append(String.format("%dx^%d ", this.coefficient, this.power));
      } else {
        str.append(String.format("%d ", coefficient));
      }
    }
    return next.toStringHelper(str);
  }

  @Override
  public int getDegreeHelper(int deg) {
    if (this.power > deg) {
      deg = this.power;
    }
    return next.getDegreeHelper(deg);
  }
}
