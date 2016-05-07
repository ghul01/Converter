
import Attila.*;
import javax.swing.JFileChooser;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Attila
 */
public class Converter {

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
                            new ConvertDoc(file);
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
