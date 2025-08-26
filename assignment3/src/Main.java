public class Main {
    public static void main(String[] args) {
        Organization org = new Organization();
        Department myynti = new Department("Myynti");
        Employee jaakko = new Employee("Jaakko",12000);
        org.addDepartment(myynti);
        myynti.addEmployee(jaakko);
        org.printOrganization();

    }
}
