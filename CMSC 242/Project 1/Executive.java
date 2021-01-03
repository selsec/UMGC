/* A class to definte an Executive. This class is a subclass of the Employee Class
* Author: Steve Thaw
* Class: CMIS242 Intermediate Programming
* Date: 13 Oct 19
*/

public class Executive extends Employee {
  private int stockPrice = 0;
  public Executive(String startName, int startSal, int startStock) {
    super(startName, startSal);
    this.stockPrice = startStock;
  }
  public int annualSalary() {
    int annualSalary = super.annualSalary(); 
    int bonus = 0;
    if (stockPrice >= 50) {
      bonus = 30000;
    }
    annualSalary += bonus;
    return annualSalary;
  }

  public String toString() {
    return super.toString() + "Stock Price: " + this.stockPrice + "\n";
  }
}
