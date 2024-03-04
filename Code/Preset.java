import java.io.File;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
import java.text.SimpleDateFormat;

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
            System.out.println("\nAVAILABLE PRESETS:\nFormat: [Preset name, file path, last backup date]\n"+ //
                                "__________________________________\n");
            while(readFile.hasNextLine()) {
 //               String presetEntry = readFile.nextLine();
//                System.out.println(presetEntry);
                presetsArray.add(getRow(readFile.nextLine()));
            }
//            readFile.close();
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
 //           scanRow.close();
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
            Scanner scanName = new Scanner(System.in);
            System.out.println("New Preset Name: ");
            String timeStamp = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
            presetWriter.write(scanName.nextLine() + "," + "ADD FILEPATH" + "," + timeStamp + "\n");
            presetWriter.close();
 //           scanName.close()
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
