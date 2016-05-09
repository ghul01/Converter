/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Attila;

import java.io.*;
import html2markdown.*;

/**
 *
 * @author quail
 */
public class ConvertHTML{

    /**
     *
     * @param input
     * @param output
     */
    public static void convert(File input, File output) throws Exception {
        String kimenet = new String();
        kimenet = HTML2Md.convertFile(input, null);

        if (!output.exists()) {
            output.createNewFile();
        }
        
        FileWriter fw = new FileWriter(output.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(kimenet);
			bw.close();
    }
}
