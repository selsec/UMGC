/* A class to definte an Employee. This class will be used as a super class for other employee types
* Author: Steve Thaw
* Class: CMIS242 Intermediate Programming
* Date: 13 Oct 19
*/
public class Employee {
  private String empName;
  private int salary;

  public Employee(String startName, int startSal) {
    this.empName = startName;
    this.salary = startSal;
  }

  public int annualSalary() {
    int annualSal = 0;
    annualSal = this.salary * 12;
    return annualSal;
  }

  
  public String toString() {
    return "Name: " + this.empName + "\n" + "Monthly Salary: " + this.salary + "\n";
  }
}
