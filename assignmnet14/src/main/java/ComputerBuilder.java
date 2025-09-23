public interface ComputerBuilder {
    void buildProcessor();
    void buildRAM();
    void buildHardDrive();
    void buildGPU();
    void buildOS();
    Computer getComputer();
}
