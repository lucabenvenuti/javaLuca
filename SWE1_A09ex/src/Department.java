public class Department {
 
    private String name;
    private int id;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }
 
    public Department(Department oldDepartment) {
        this.id = oldDepartment.id;
        this.name = oldDepartment.name;
    }
 
    @Override
    public String toString() {
        return "Department Id: " + id + "\tDepartment Name: " + name;
    }
}
