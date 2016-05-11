/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static jdk.nashorn.internal.objects.NativeRegExp.source;

/**
 *
 * @author Babinszki Attila
 */
public class ConvertTXT {

    public static List<String> extractUrls(String text) {
        List<String> containedUrls = new ArrayList<String>();
        String urlRegex = "((https?|ftp|gopher|telnet|file):((//)|(\\\\))+[\\w\\d:#@%/;$()~_?\\+-=\\\\\\.&]*)";
        Pattern pattern = Pattern.compile(urlRegex, Pattern.CASE_INSENSITIVE);
        Matcher urlMatcher = pattern.matcher(text);

        while (urlMatcher.find()) {
            containedUrls.add(text.substring(urlMatcher.start(0),
                    urlMatcher.end(0)));
        }

        return containedUrls;
    }

    /**
     * Txt tartalmának át másolsása mdbe.
     *
     * @param input .txt
     * @param output .md
     * @throws Exception
     */
    public static void convert(File input, File output) throws Exception {
        if (output.exists()) {
            output.delete();//Eceptionok kerülése végett törlöm a fájl-t.
        }
        Files.copy(input.toPath(), output.toPath());//Át másolom a txt fájlt mdbe mert konverziót nem igényel.
        //linkeket be

        String search = new String();
        String replace = new String();
        List<String> urls = new ArrayList<String>();

        try {
            FileReader fr = new FileReader(output);
            String s;
            String totalStr = "";
            int quitter=0;
            BufferedReader br = new BufferedReader(fr);

                while (quitter<100000 && (s = br.readLine()) != null) {
                    totalStr += s + "\n";
                    List<String> tempurls = extractUrls(s);
                    urls.addAll(tempurls);
                    quitter++;
                    //System.out.println(quitter);
                }
                if (urls.size() != 0) {
                    for (String url : urls) {
                        //System.out.println(url);
                        search = url;
                        replace = "[" + url + "](" + url + ")";
                        totalStr = totalStr.replaceAll(search, replace);
                    }
                    FileWriter fw = new FileWriter(output);
                    fw.write(totalStr);
                    fw.close();
                }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
