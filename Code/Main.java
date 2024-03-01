import java.io.File;
import java.util.Scanner;
import java.awt.Desktop;


public class Main {

    public static void main(String[] args){
        Integer userSelection = showMenu();
        Scanner scanner = new Scanner(System.in);
        Preset testPreset = new Preset();

        // Take actions based on validated user input
        if(userSelection == 1){ // MANUAL SELECTION
            System.out.println("\n\nWelcome to MANUAL SELECTION mode!\n____________________________________________\n");
            manualSelection();
        } else {
            if(userSelection == 2){ // PICK PRESET
                System.out.println("selection: 2");
                testPreset.checkPreset();
            } else {
                if(userSelection == 3){ // CREATE PRESET
                    System.out.println("selection: 3");
                    testPreset.checkPreset();
                } else { // DELETE PRESET
                    System.out.println("selection: 4");
                    testPreset.checkPreset();
                }
            }
        }
    runningCheck();
    }

    private static void runningCheck() {
        System.out.println("Success!\nWould you like to continue with another task or exit?\n" + //
                        "Enter C to continue or E to exit:");
        Scanner scanner = new Scanner(System.in);
        String running = scanner.nextLine();
        if(running.toUpperCase().equals("C")) {
            main(null);
        } else {
            if(running.toUpperCase().equals("E")) {
                System.out.println("\nStealthELF Backup Program exited.\nGoodbye!\n");
            } else {
                System.out.println(">>> Please enter a valid input.");
            }
        }
    }

    public static int showMenu(){ // Returns the numerical selection of the user
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n\nStealthELF Backup Software\n____________________________________________\n\n" + //
                        "Please make a selection below for what you would like to do first:\n\n" + //
                        "\t(1) Manual Selection\n\t(2) Pick Preset\n\t(3) Create Preset\n\t(4) Delete Preset\n" + //
                        "\nEnter menu number to select: ");

        try {
            String menuInput = scanner.nextLine().trim();
            Integer menuInputNum = Integer.parseInt(menuInput);
            if(menuInputNum > 0 && menuInputNum < 5){
                return Integer.parseInt(menuInput);
            } 
            else {
                System.out.println("Please enter a valid input.");
                
            }
        }
        catch (Exception e) {
            System.out.println("Please enter a valid input.");
            showMenu();
        }
        return 1;
    }

    private static File validateFileLocation(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input a filepath: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        Desktop desktop = Desktop.getDesktop();
        if(file.exists()){
            System.out.println("File location successfully located.");
            try{
                desktop.open(file);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else {
            System.out.println("Uh oh! File location not found!");
            validateFileLocation();
        }
        return file;
    }

    static void manualSelection(){
        System.out.println("Please copy and paste the path to the directory you would like to backup below.\n" + //
        "____________________________________________\n");
        File selectedFile = validateFileLocation();
        Backup.copyFile(selectedFile);
    }
}

class Preset {


    public void checkPreset(){
        System.out.println("Hello from the Preset class!");
    }

    public void newPreset(){
        System.out.println("Creating new Preset...");
    }

    public void loadPreset(){
        System.out.println("Loading Preset...");
    }

    public void deletePreset(){
        System.out.println("Deleting preset...");
    }
}

class Backup {

    public static void copyFile(File inputFile){
        System.out.println("you found: " + inputFile);
    }
}
