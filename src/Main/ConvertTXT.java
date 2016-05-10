/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.*;
import java.nio.file.Files;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 *
 * @author Babinszki Attila
 */
public class ConvertTXT {

    /**
     *Txt tartalmának át másolsása mdbe.
     * @param input .txt
     * @param output .md
     * @throws Exception
     */
    public static void convert(File input, File output) throws Exception {
        if(output.exists())output.delete();//Eceptionok kerülése végett törlöm a fájl-t.
        Files.copy(input.toPath(), output.toPath());//Át másolom a txt fájlt mdbe mert konverziót nem igényel.

    }

}
