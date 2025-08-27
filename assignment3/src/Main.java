public class Main {
    public static void main(String[] args) {
        Organization org = new Organization();
        Department myynti = new Department("Myynti");
        Employee jaakko = new Employee("Jaakko",12000);
        Department myynti2 = new Department("Myynti2");
        Employee pekka = new Employee("Pekka",13000);
        myynti2.addEmployee(pekka);
        myynti.addDepartment(myynti2);
        org.addDepartment(myynti);
        myynti.addEmployee(jaakko);
        org.printOrganization();

        org.removeEmployee(pekka);
        org.printOrganization();

    }
}
