public class ComputerDirector {
    private ComputerBuilder builder;
    public ComputerDirector(ComputerBuilder builder) {
        this.builder = builder;
    }
    void buildComputer() {
        builder.buildProcessor();
        builder.buildGPU();
        builder.buildRAM();
        builder.buildHardDrive();
        builder.buildOS();
    }

}
