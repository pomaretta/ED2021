package Lite;

public class ComputerLite {
    public static void main(String[] args) {

        // Computer
        Computer c1 = new Computer("Dell UltraLight",4096,100000);

        // Windows
        OperativeSystem windows = new OperativeSystem("Windows",
                "2004",
                "x86_64",
                false,
                20,
                2);

        // Applications
        Application s1,s2;
        s1 = new Application("Word","1.0",0.5f,1);
        s2 = new Application("Affinity Photo", "2.5",0.2f,0.6f);

        // Install Operative System in Computer.
        try {
            c1.installOperatingSystem(windows);
        } catch (Exception e){
            e.printStackTrace();
        }

        // Wake up the computer
        try {
            c1.startComputer();
        }catch (Exception e){
            e.getMessage();
        }

        // Install Applications in Operative System.
        try {
            windows.installApplication(s1);
            windows.installApplication(s2);
        } catch (Exception e){
            e.printStackTrace();
        }

        // Open or close applications
        try {
            windows.openApplication(windows.getOsSoftware().get(windows.getOsSoftware().indexOf(s1)));
            windows.openApplication(windows.getOsSoftware().get(windows.getOsSoftware().indexOf(s2)));
        } catch (Exception e){
            e.getMessage();
        }
        // windows.closeApplication(windows.getOsSoftware().get(windows.getOsSoftware().indexOf(s1)));
        // windows.closeApplication(windows.getOsSoftware().get(windows.getOsSoftware().indexOf(s2)));

        // Uninstalling by given application
        try {
            windows.uninstallApplication(windows.getOsSoftware().get(windows.getOsSoftware().indexOf(s2)));
        } catch (Exception e){
            e.getMessage();
        }

        // Before formatting.
        System.out.println("Before formatting.");
        System.out.println(c1.toString() + "\n\n");

        c1.formatSystem();

        // After formatting.
        System.out.println("After formatting.");
        System.out.println(c1.toString() + "\n\n");

        /*
        System.out.println("==== Software ====");
        System.out.printf("%-15s %-15s","Name","isOpen");
        System.out.println(c1.toString());
        for(Application app : windows.getOsSoftware()){
            System.out.printf("\n%-15s %-15b",app.getSoftwareName(),app.isOpen());
        }
        */
    }
}
