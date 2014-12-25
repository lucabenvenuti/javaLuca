public class Employee {
 
    private String name;
    private int id;
    private Department department;
 
    public Department getDepartment() {
        return department;
    }
 
    public String getName() {
        return name;
    }
 
    public int getId() {
        return id;
    }
 
    public void setDepartment(Department department) {
        this.department = department;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public Employee(int id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
 
    public Employee(Employee oldEmployee) {
        this.id = oldEmployee.id;
        this.name = oldEmployee.name;
     //   this.department = oldEmployee.department;  //shallow cloning
        this.department = new Department(oldEmployee.department);    //deep cloning
    }
 
    @Override
    public String toString() {
        return "Employee Id: " + id + "\tEmployee Name: " + name + "\t" + department;
    }
    
    public static Employee copy(Employee originalEmployee) {
        return new Employee(originalEmployee);
    }
}