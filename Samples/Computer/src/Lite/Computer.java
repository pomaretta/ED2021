package Lite;

public class Computer {

    // Name of the computer.
    private String name;
    // Max memory on computer.
    private int maxRamMemory;
    // Max storage on disk.
    private int maxHardDisk;
    // Variable ram, specifies the actual memory in free in the system.
    private int ramMemory;
    // Variable disk space, specifies the actual disk space free.
    private int hardDisk;
    // Actual state of the computer
    private boolean computerState;
    // Variable containing the operative system of the computer.
    private OperativeSystem operativeSystem;

    /*
        Constructor
        Asign some initial variables that must have one computer.
     */
    public Computer(String name, int ramMemory, int hardDisk) {
        this.name = name;
        this.maxRamMemory = ramMemory;
        this.maxHardDisk = hardDisk;
        this.ramMemory = maxRamMemory;
        this.hardDisk = maxHardDisk;
    }

    /*
        Method for installing an operative system in the computer. It updates the ram memory and disk space.
     */
    public void installOperatingSystem(OperativeSystem os) throws Exception{
        if(this.operativeSystem == null && this.hardDisk >= os.getOsSpaceRequirement()){
            // Assign physic computer to an operative system.
            os.setComputer(this);
            // Assign the operative system in the
            this.operativeSystem = os;
            // Update the drive space in the computer.
            updateDriveSpace(os.getOsSpaceRequirement(),"-");
        } else {
            // User cannot install more than one operative system in the computer.(Rule)
            throw new Exception("Existing operating system.");
        }
    }

    // Method for updating the drive space currently assigned in computer.
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

    // Method for updating the ram space currently assigned in computer.
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

    // Method for reset the default values in hardDisk and ramMemory in the computer
    public void formatSystem(){
        this.operativeSystem = null;
        this.hardDisk = this.maxHardDisk;
        this.ramMemory = this.maxRamMemory;
    }

    // Open the system
    public void startComputer() throws Exception {
        if(this.computerState){
            throw new Exception("Computer is already open.");
        } else if(this.operativeSystem != null){
            this.operativeSystem.startSystem();
            this.computerState = true;
        } else {
            throw new Exception("No operative system installed.");
        }
    }

    // Open the system
    public void stopComputer() throws Exception {
        if(this.computerState){
            throw new Exception("Computer is closed.");
        } else {
            this.operativeSystem.stopSystem();
            this.computerState = false;
        }
    }

    // Close the system

    public OperativeSystem getOperativeSystem(){
        return this.operativeSystem;
    }

    public int getCurrentRamMemory() {
        return ramMemory;
    }

    public int getCurrentHardDisk() {
        return hardDisk;
    }

    public int getMaxRamMemory() {
        return maxRamMemory;
    }

    public int getMaxHardDisk() {
        return maxHardDisk;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", maxRamMemory=" + maxRamMemory +
                ", maxHardDisk=" + maxHardDisk +
                ", Free ramMemory=" + ramMemory +
                ", Free hardDisk=" + hardDisk +
                ", computerState=" + computerState +
                ", operativeSystem=" + operativeSystem +
                '}';
    }
}
