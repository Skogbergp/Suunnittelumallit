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
            for (Department d : e.getDepartments()) {
                if (d.isEmployee(employee)) {
                    d.removeEmployee(employee);
                }
            }
            if(e.isEmployee(employee)){
                e.removeEmployee(employee);

            }


        }
        employees.remove(employee);
    }

    public void removeDepartment(Department department){
        departments.remove(department);
    }

    public void printOrganization(){
        StringBuilder sb = new StringBuilder();
        sb.append("<Organization>\n");
        for (Department d : departments) {
            sb.append(d.printDepartment("    "));
        }
        sb.append("</Organization>\n");
        System.out.println(sb.toString());
    }
}
