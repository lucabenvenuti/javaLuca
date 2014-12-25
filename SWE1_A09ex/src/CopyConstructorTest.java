public class CopyConstructorTest {
 
   public static void main(String[] args) {
        Department department = new Department(1, "Finance");
        Employee originalEmployee = new Employee(1, "Ram", department);
        Employee clonedEmployee = Employee.copy(originalEmployee);
        //Employee clonedEmployee = new Employee(originalEmployee);
        System.out.println("Original:- " + originalEmployee);
        System.out.println("Duplicate:- " + clonedEmployee);
        System.out.println();
        clonedEmployee.setId(2);
        clonedEmployee.setName("Laxman");
        clonedEmployee.getDepartment().setName("HR");
        System.out.println("Original:- " + originalEmployee);
        System.out.println("Duplicate:- " + clonedEmployee);
    }
}