
import Attila.*;
import javax.swing.JFileChooser;

/*
 * Ezt a class-t felhasználtam az új Converter.java-ba. Funkciója nincs.
 */
/**
 *
 * @author Attila
 */
public class Converterregi {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception IOExceptions!
     */
    public static void main(String[] args) throws Exception {
        // TODO Innen induljon az egész!
        JFileChooser filechooser = new JFileChooser();
        if (filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            java.io.File file = filechooser.getSelectedFile();
            if (file.exists() && file.canRead()) {
                String filename = file.getName();
                if (filename.lastIndexOf('.') > 0) {
                    String fileextension = filename.substring(filename.lastIndexOf('.') + 1);
                    switch (fileextension) {
                        //Ide rakjártok a konvertáló classokat!
                        case "doc":
                            ConvertDoc.convert(file,file);
                            break;
                        default:
                            System.err.println("Ismeretlen fájl formátum!");
                            break;
                    }
                } else {
                    System.err.println("Ismeretlen fájl formátum!");
                }
            }
        } else {
            System.err.println("Nem választottál ki egy fájlt sem!");
        }
    }

}
