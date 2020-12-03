package Lite;

import os.microsoft.Windows;

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

        try {
            c1.installOperatingSystem(windows);
        } catch (Exception e){
            e.printStackTrace();
        }

        Application s1,s2;

        s1 = new Application("Word","1.0",0.5f,1);
        s2 = new Application("Affinity Photo", "2.5",0.2f,0.6f);

        try {
            windows.addApplication(s1);
            windows.addApplication(s2);
        } catch (Exception e){
            e.printStackTrace();
        }

        windows.openApplication(windows.getOsSoftware().get(0));
        windows.openApplication(windows.getOsSoftware().get(1));

        System.out.println(c1.toString());

    }
}
