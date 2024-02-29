import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Integer userSelection = showMenu();
        File selectedFile = validateFileLocation();

        // TEMP CLASS TESTING
        Preset testPreset = new Preset();
        testPreset.sayHello();
        Backup testBackup = new Backup();
        testBackup.sayHello();
    }

    static int showMenu(){ // Returns the numerical selection of the user
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nWelcome to StealthELF Backup Software!\n____________________________________________\n\n" + //
                        "Please make a selection below for what you would like to do first:\n\n" + //
                        "\t(1) Manual Selection\n\t(2) Pick Preset\n\t(3) Create Preset\n\t(4) Delete Preset\n" + //
                        "\nEnter menu number to select: ");

        try {
            String menuInput = scanner.nextLine();
            Integer menuInputNum = Integer.parseInt(menuInput);
            if(menuInputNum > 0 && menuInputNum < 5){
                System.out.println("You selected " + menuInput + "!");
                return Integer.parseInt(menuInput);
            } 
            else {
                System.out.println("Please enter a valid input.");
                
            }
        }
        catch (Exception e) {
            System.out.println("Please enter a valid input.");
        }
        return 1;
    }

    static File validateFileLocation(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please input a filepath: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        if(file.exists()){
            System.out.println("File location was found!");
        }
        else {
            System.out.println("File location not found!");
            //validateFileLocation();
        }
        scanner.close();
        return file;
    }
}

class Preset {

    public static void main(String[] args){
        System.out.println("\nIn preset class.\n");
    }

    public void sayHello(){
        System.out.println("Hello from the Preset class!");
    }
}

class Backup {

    public static void main(String[] args){
        System.out.println("\nIn backup class.\n");
    }

    public void sayHello(){
        System.out.println("Hello from the Backup class!");
    }
}
