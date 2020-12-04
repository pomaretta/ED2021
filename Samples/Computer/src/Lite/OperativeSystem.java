package Lite;

import java.util.ArrayList;

public class OperativeSystem {

    // Operative System name
    private String osName;
    // Operative System version
    private String osVersion;
    // Operative System architecture
    private String osArchitecture;
    // If the operative system is only command.
    private boolean isOnlyCommand;
    // Operative System hard disk requirement.
    private int osSpaceRequirement;
    // Operative System ram memory requirement.
    private int osRamMemoryRequirement;
    // System state
    private boolean systemState;
    // Operative System list of installed applications.
    private ArrayList<Application> osSoftware;
    // Operative System assigned hardware (Computer)
    private Computer osComputer;

    /*
        Constructor
        Assign the initial values of the new Operative System and initializes the array list of the software.
     */
    public OperativeSystem(String osName, String osVersion, String osArchitecture, boolean isOnlyCommand, int osSpaceRequirement, int osRamMemoryRequirement) {
        this.osName = osName;
        this.osVersion = osVersion;
        this.osArchitecture = osArchitecture;
        this.isOnlyCommand = isOnlyCommand;
        this.osSpaceRequirement = osSpaceRequirement;
        this.osRamMemoryRequirement = osRamMemoryRequirement;
        osSoftware = new ArrayList<Application>();
    }

    // Method for setting the computer in the operative system at the installation time.
    public void setComputer(Computer computer){
        this.osComputer = computer;
    }

    // Method for starting the system through the computer.
    public void startSystem(){
        this.osComputer.updateRamSpace(getOsRamMemoryRequirement(),"-");
        this.systemState = true;
    }

    // Method for stopping the system through the computer.
    public void stopSystem(){
        this.osComputer.updateRamSpace(getOsRamMemoryRequirement(),"+");
        this.systemState = false;
    }

    // Method for installing applications and update disk space in the computer.
    public void installApplication(Application app) throws Exception {
        if(this.osSoftware.contains(app)){
            throw new Exception("App already exists.");
        } else if(checkDiskSpace(app.getSoftwareSpaceRequirements())){
            this.osComputer.updateDriveSpace(app.getSoftwareSpaceRequirements(),"-");
            this.osSoftware.add(app);
        } else {
            throw new Exception("Error.");
        }
    }

    // Method for uninstalling application, update computer requirements and software list.
    public void uninstallApplication(Application app) throws Exception {
        if(this.osSoftware.contains(app)){
            if(app.isOpen()){
                this.closeApplication(app);
            }
            this.osComputer.updateDriveSpace(app.getSoftwareSpaceRequirements(), "+");
            this.osSoftware.remove(app);
        } else {
            throw new Exception("Software isn't installed.");
        }
    }

    // Method for opening an application and update the ram space.
    public void openApplication(Application app) throws Exception {
        if(checkRamSpace(app.getSoftwareRamMemoryRequirements())){
            try {
                app.openApp();
            } catch (Exception e){
                e.getMessage();
            }
            this.osComputer.updateRamSpace(app.getSoftwareRamMemoryRequirements(),"-");
        } else {
            throw new Exception("RAM requirement not satisfied.");
        }
    }

    // Method for closing an application and update the ram space.
    public void closeApplication(Application app){
        try {
            app.closeApp();
        } catch (Exception e){
            e.getMessage();
        }
        this.osComputer.updateRamSpace(app.getSoftwareRamMemoryRequirements(),"+");
    }

    private boolean checkDiskSpace(int spaceToBeSet){
        if(spaceToBeSet < this.osComputer.getMaxHardDisk() && (this.osComputer.getCurrentHardDisk() + spaceToBeSet) <= this.osComputer.getMaxHardDisk()){
            return true;
        } else {
            return false;
        }
    }

    private boolean checkRamSpace(int spaceToBeSet){
        if(spaceToBeSet < this.osComputer.getMaxRamMemory() && (this.osComputer.getCurrentRamMemory() + spaceToBeSet) <= this.osComputer.getMaxRamMemory()){
            return true;
        } else {
            return false;
        }
    }

    public String getOsName() {
        return osName;
    }
    public String getOsVersion() {
        return osVersion;
    }
    public String getOsArchitecture() {
        return osArchitecture;
    }
    public boolean isOnlyCommand() {
        return isOnlyCommand;
    }
    public int getOsSpaceRequirement() {
        return osSpaceRequirement * 1024;
    }
    public int getOsRamMemoryRequirement() {
        return osRamMemoryRequirement * 1024;
    }
    public ArrayList<Application> getOsSoftware() {
        return osSoftware;
    }

}
