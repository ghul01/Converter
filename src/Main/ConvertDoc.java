package Main;
/**
*	
*
*
*/

import com.aspose.words.*;
import java.io.*;


public class ConvertDoc {
    
    /**
     * 
     * @param input
     * @param output 
     */
    public static void convert(File input, File output){
		try{
			Document doc = new Document(input.getPath());

			HtmlSaveOptions options = new HtmlSaveOptions();
			
			doc.save(output.getPath(), options);
		}catch(Exception e){
			System.err.println("Hiba a documentum beolvasasakor");
		}
		
		try{
			String mi = "Evaluation Only. Created with Aspose.Words. Copyright 2003-2016 Aspose Pty Ltd.";
			File file = output;
			BufferedReader be = new BufferedReader( new FileReader (file));
			String line = null;
			
			line = be.readLine();
			be.close();
	
			//honnan = line.indexOf(mi);
			line = line.replaceAll(mi,"");

			
			FileWriter ki = new FileWriter(file);
			ki.write(line);
			
			ki.close();

			
		}catch(Exception e){
			System.out.println("Hiba a dokumentum szerkesztesekor");
		}
	
	}
        
		
}
