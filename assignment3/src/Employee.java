public class Employee {
    private String name;
    private int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public String printEmployee(String indent) {
        return indent + "<Employee>\n" +
                indent + "    <Name>" + name + "</Name>\n" +
                indent + "    <Salary>" + salary + "</Salary>\n" +
                indent + "</Employee>\n";
    }
}