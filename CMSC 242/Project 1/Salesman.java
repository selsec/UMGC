/* A class to definte a Salesman. This class is a subclass of the Employee Class
* Author: Steve Thaw
* Class: CMIS242 Intermediate Programming
* Date: 13 Oct 19
*/

public class Salesman extends Employee {
  
  private int annualSales = 0;

  public Salesman(String startName, int startSal, int startSales) {
    super(startName, startSal);
    this.annualSales = startSales;
  }

  public int annualSalary() {
    int annualSalary = super.annualSalary();
    double commission = annualSales * .02;
    if (commission > 20000) {
      commission = 20000;
    }
    annualSalary = annualSalary + (int)commission;
    return annualSalary;
  }

  public String toString() {
  return super.toString() + "Annual Sales: " + this.annualSales + "\n";
  }
}
