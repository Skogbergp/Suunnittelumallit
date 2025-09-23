public class GamingComputerBuilder implements ComputerBuilder{
    private Computer computer = new Computer();

    @Override
    public void buildProcessor() {
        computer.setProcessor("Ryzen 2700x");
    }

    @Override
    public void buildRAM() {
        computer.setRAM(32);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("3TB HardDrive");
    }

    @Override
    public void buildGPU() {
        computer.setGPU("Nvidia rtx 2070");
    }

    @Override
    public void buildOS() {
        computer.setOS("Windows 10");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
