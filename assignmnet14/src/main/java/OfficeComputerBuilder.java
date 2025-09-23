public class OfficeComputerBuilder implements ComputerBuilder{
    private Computer computer = new Computer();

    @Override
    public void buildProcessor() {
        computer.setProcessor("Ryzen 2700");
    }

    @Override
    public void buildRAM() {
        computer.setRAM(16);
    }

    @Override
    public void buildHardDrive() {
        computer.setHardDrive("1TB HardDrive");
    }

    @Override
    public void buildGPU() {
        computer.setGPU("Nvidia GTX 1050");
    }

    @Override
    public void buildOS() {
        computer.setOS("Windows 11");
    }
    @Override
    public Computer getComputer() {
        return computer;
    }
}

