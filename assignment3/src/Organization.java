import java.util.ArrayList;

public class Organization {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Department> departments = new ArrayList<>();
    public void addDepartment(Department department){
        departments.add(department);
    }
    public void addEmployee(Employee employee){
        employees.add(employee);
    }
    public void removeEmployee(Employee employee){
        for(Department e : departments) {
            if(e.isEmployee(employee)){
                departments.remove(e);
                employees.remove(employee);
            }

        }
    }

    public void removeDepartment(Department department){
        departments.remove(department);
    }

    public void printOrganization(){
        System.out.println("<Organization>");
        for(Department d : departments){
            System.out.println(d.printDepartment());
        }
        System.out.println("</Organization>");
    }
}
