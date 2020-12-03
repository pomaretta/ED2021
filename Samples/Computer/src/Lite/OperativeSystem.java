package Lite;

import java.util.ArrayList;

public class OperativeSystem {

    private String osName;
    private String osVersion;
    private String osArchitecture;
    private boolean isOnlyCommand;
    private int osSpaceRequirement;
    private int osRamMemoryRequirement;
    private ArrayList<Application> osSoftware;
    private Computer osComputer;

    public OperativeSystem(String osName, String osVersion, String osArchitecture, boolean isOnlyCommand, int osSpaceRequirement, int osRamMemoryRequirement) {
        this.osName = osName;
        this.osVersion = osVersion;
        this.osArchitecture = osArchitecture;
        this.isOnlyCommand = isOnlyCommand;
        this.osSpaceRequirement = osSpaceRequirement;
        this.osRamMemoryRequirement = osRamMemoryRequirement;

        osSoftware = new ArrayList<Application>();

    }

    public void setComputer(Computer computer){
        this.osComputer = computer;
    }

    public void addApplication(Application app) throws Exception{
        if(this.osSoftware.contains(app)){
            throw new Exception("App already exists.");
        } else {
            this.osComputer.updateDriveSpace(app.getSoftwareSpaceRequirements(),"-");
            this.osSoftware.add(app);
        }

    }

    public void openApplication(Application app){
        try {
            app.openApp();
        } catch (Exception e){
            e.getMessage();
        }
        this.osComputer.updateRamSpace(app.getSoftwareRamMemoryRequirements(),"-");
    }

    public void closeApplication(Application app){
        try {
            app.closeApp();
        } catch (Exception e){
            e.getMessage();
        }
        this.osComputer.updateRamSpace(app.getSoftwareRamMemoryRequirements(),"+");
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
        return osSpaceRequirement;
    }

    public int getOsRamMemoryRequirement() {
        return osRamMemoryRequirement;
    }

    public ArrayList<Application> getOsSoftware() {
        return osSoftware;
    }
}
