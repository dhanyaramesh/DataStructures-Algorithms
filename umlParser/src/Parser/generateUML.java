package Parser;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import net.sourceforge.plantuml.SourceStringReader;
public class generateUML {
	public  void umlCreator(String source) {
		
		OutputStream png = null;
		try {
			png = new FileOutputStream("/Users/dhanyaramesh/Desktop/umltest2.jpeg");
			System.out.println("Package");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			SourceStringReader reader = new SourceStringReader(source);
		// Write the first image to "png"
		try {
			reader.generateImage(png);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Return a null string if no generation
	}
}
