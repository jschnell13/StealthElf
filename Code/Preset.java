import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;

class Preset {

    public static void main(String[] args){
        System.out.println("\nIn preset class.\n");
    }

    public void showPresets() {
        File presetfile = new File("Code/stealthELFstore.csv");
        List<List<String>> presetsArray = new ArrayList<>();
        try{
            Scanner readFile = new Scanner(presetfile);
            readFile.nextLine();
            System.out.println("\nAvailable Presets:\n__________________________________\n");
            while(readFile.hasNextLine()) {
 //               String presetEntry = readFile.nextLine();
//                System.out.println(presetEntry);
                presetsArray.add(getRow(readFile.nextLine()));
            }
            readFile.close();
            for(List<String> s : presetsArray){
                System.out.println(s);
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("FILE ERROR.\nUnable to find preset records.");
        }
    }

    private List<String> getRow(String row) {
        List<String> rowContents = new ArrayList<String>();
        try{
            Scanner scanRow = new Scanner(row);
            scanRow.useDelimiter(",");
            while(scanRow.hasNext()) {
                rowContents.add(scanRow.next());
            }
            scanRow.close();
        } catch(Exception e) {
            System.out.println(e);
        }
        
        return rowContents;
    }

    public void checkPreset(){
        System.out.println("Hello from the Preset class!");
    }

    public void newPreset(){
        try{
            FileWriter presetWriter = new FileWriter("Code/stealthELFstore.csv", true);
            Scanner scanName
            presetWriter.write("test, test, test\n");
            presetWriter.close();
        } catch (IOException e) {
            System.out.println("FILE ERROR.");
        }
    }

    public void loadPreset(){
        System.out.println("Loading Preset...");
    }

    public void deletePreset(){
        System.out.println("Deleting preset...");
    }
}
