import java.util.ArrayList;

public class Department {
    private String name;
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Department> departments = new ArrayList<>();

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
           if(e.equals(employee)){
               return true;
           }
       }
       return false;
   }
   public void removeEmployee(Employee employee){
       employees.remove(employee);
   }
   public String printDepartment() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t<Department>\n\t\t<Name>" + name + "</Name>\n\t\t<Employees>\n");
        for (Employee e : employees) {
            sb.append("\t\t\t<Employee>\n" +
                    "\t\t\t\t<Name>"+e.getName()+"</Name>\n" +
                    "\t\t\t\t<Salary>"+e.getSalary()+"</Salary>\n");
        }
        sb.append("\t\t\t</Employees>\n\t</Department>");
        return sb.toString();
   }
}
