import java.io.FileInputStream;
import java.util.List;

import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.TypeDeclaration;

public class CuPrinter {
	public static String classname;

    public static void main(String[] args) throws Exception {
        // creates an input stream for the file to be parsed
        FileInputStream in = new FileInputStream("/Users/dhanyaramesh/Documents/workspace/exam/src/Student.java");

        CompilationUnit cu;
        try {
            // parse the file
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }

        // prints the resulting compilation unit to default system output
        System.out.println(cu.toString());
        
        
        
        String cu2str = cu.toString();
		String[] lines = cu2str.split("\\r?\\n");
		String delims = "[ .,?!]+";
        String[] tokens = lines[0].split(delims);
        for(int i=0;i<tokens.length;i++)
        {
        	System.out.println(tokens[i]);
        }
        List types = cu.getTypes(); 
        System.out.println("types"+types);
        
        /*List types1 = cu.getTypes();
        System.out.println("types 1"+types1);*/
     
        TypeDeclaration typeDec = (TypeDeclaration) types.get(0);
        classname = typeDec.getName();
        System.out.println(classname);
    }
}