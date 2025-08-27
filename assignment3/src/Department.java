import javax.xml.stream.XMLOutputFactory;
import java.util.ArrayList;


public class Department {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Department> departments = new ArrayList<>();
    private XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();

    public Department(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

   public void addEmployee(Employee employee){
       employees.add(employee);
   }
   public ArrayList<Employee> getEmployees(){
       return employees;
   }
   public void addDepartment(Department department){
        departments.add(department);
   }
   public ArrayList<Department> getDepartments(){
        return departments;
   }
   public boolean isEmployee(Employee employee){
       if(employees.size() == 0){
           return false;
       }
       for(Employee e : employees){
           if(e.equals(employee)) {
               return true;
           }
       }
       return false;
   }
   public void removeEmployee(Employee employee){
       employees.remove(employee);
   }
   public String printDepartment(String indent) {
       StringBuilder sb = new StringBuilder();
       sb.append(indent).append("<Department>\n");
       sb.append(indent).append("    <Name>").append(name).append("</Name>\n");

       sb.append(indent).append("    <Employees>\n");
       for (Employee e : employees) {
           sb.append(e.printEmployee(indent + "        "));
       }
       sb.append(indent).append("    </Employees>\n");

       for (Department subDept : departments) {
           sb.append(subDept.printDepartment(indent + "    "));
       }

       sb.append(indent).append("</Department>\n");
       return sb.toString();
   }
}
