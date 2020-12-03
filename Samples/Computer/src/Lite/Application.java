package Lite;

public class Application {

    private String softwareName;
    private String softwareVersion;
    private float softwareSpaceRequirements;
    private float softwareRamMemoryRequirements;
    private boolean isOpen = false;

    public Application(String softwareName, String softwareVersion, float softwareSpaceRequeriments, float softwareRamMemoryRequeriment) {
        this.softwareName = softwareName;
        this.softwareVersion = softwareVersion;
        this.softwareSpaceRequirements = softwareSpaceRequeriments;
        this.softwareRamMemoryRequirements = softwareRamMemoryRequeriment;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void openApp() throws Exception {
        if(this.isOpen){
            throw new Exception("App is already open.");
        } else{
            this.isOpen = true;
        }
    }

    public void closeApp() throws Exception {
        if(!this.isOpen){
            throw new Exception("App is already open.");
        } else{
            this.isOpen = false;
        }
    }

    public int getSoftwareSpaceRequirements() {
        return (int)(softwareSpaceRequirements * 1024);
    }

    public int getSoftwareRamMemoryRequirements() {
        return (int)(softwareRamMemoryRequirements * 1024);
    }
}
