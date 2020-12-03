package Lite;

public class Computer {

    private String name;
    private int maxRamMemory;
    private int maxHardDisk;
    private int ramMemory;
    private int hardDisk;
    private OperativeSystem operativeSystem;

    public Computer(String name, int ramMemory, int hardDisk) {
        this.name = name;
        this.maxRamMemory = ramMemory;
        this.maxHardDisk = hardDisk;
        this.ramMemory = maxRamMemory;
        this.hardDisk = maxHardDisk;
    }

    public void installOperatingSystem(OperativeSystem os) throws Exception{
        if(this.operativeSystem == null){
            os.setComputer(this);
            this.operativeSystem = os;
            this.hardDisk -= (os.getOsSpaceRequirement() * 1024);
            this.ramMemory -= (os.getOsRamMemoryRequirement() * 1024);

        } else {
            throw new Exception("Existing operating system.");
        }
    }

    public void updateDriveSpace(int spaceToUpdate, String op){
        switch (op){
            case "+" -> {
                this.hardDisk += spaceToUpdate;
            }
            case "-" -> {
                this.hardDisk -= spaceToUpdate;
            }
        }
    }

    public void updateRamSpace(int spaceToUpdate, String op){
        switch (op){
            case "+" -> {
                this.ramMemory += spaceToUpdate;
            }
            case "-" -> {
                this.ramMemory -= spaceToUpdate;
            }
        }
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", RamMemory=" + ramMemory +
                ", hardDisk=" + hardDisk +
                ", operativeSystem=" + operativeSystem.toString() +
                '}';
    }
}
