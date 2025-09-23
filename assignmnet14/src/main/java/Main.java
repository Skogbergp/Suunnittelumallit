public class Main {
    public static void main(String[] args) {
        ComputerBuilder gamingBuilder = new GamingComputerBuilder();
        ComputerBuilder officeBuilder = new OfficeComputerBuilder();
        Computer GamingPC;
        Computer OfficePC;
        ComputerDirector director = new ComputerDirector(gamingBuilder);
        director.buildComputer();
        director = new ComputerDirector(officeBuilder);
        director.buildComputer();
        OfficePC = officeBuilder.getComputer();
        GamingPC = gamingBuilder.getComputer();
        System.out.println(GamingPC);
        System.out.println(OfficePC);


    }
}
