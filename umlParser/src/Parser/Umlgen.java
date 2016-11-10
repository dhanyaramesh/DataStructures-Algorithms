package Parser;


import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;

public class Umlgen {

	public static String s = "@startuml\n";
	public static String classname;
	public static int mc =0;
	 public static void main(String[] args) throws Exception {
	        // creates an input stream for the file to be parsed
		 
		  File dir = new File("/Users/dhanyaramesh/Documents/workspace/helloWorld/src/helloWorld/");
		  File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
		    for (File child : directoryListing) {
		    	System.out.println(child);
		    	if((child.getName().contains(".java")))
		    	{
		    	File file = new File(child.getAbsolutePath());
		    	FileInputStream in = new FileInputStream(file);
		        CompilationUnit cu;
		        try {
		           
		            cu = JavaParser.parse(in,"UTF8");
		        	}
		        finally {
		            in.close();
		        }
		        String temp = cu.toString();
		        String lines[] = temp.split("\\r?\\n");
		        String delims = "[ .,?!]+";
		        String[] tokens = lines[0].split(delims);
		        System.out.println(tokens.toString());
		        List types = cu.getTypes(); 
		        System.out.println("types"+types);
		        List types1 = cu.getTypes();
		        System.out.println("types 1"+types1);
		         
		        
		        TypeDeclaration typeDec = (TypeDeclaration) types.get(0);
		  
		        classname = typeDec.getName();
		        
		        if(tokens[1].equals("interface"))
		        	s = s + "interface" + " " + classname + "\n";
		        if(tokens[1].equals("class"))
		        	 s = s + "class" + " " + classname + "\n";
		        // visit and print the methods names
		      
		        new MethodVisitor().visit(cu, null);
		       
		        new MethodVisitor1().visit(cu, null);
		        new MethodVisitor2().visit(cu, null);
		        new MethodVisitor3().visit(cu, null);
		    }
		    }
		    s = s + "@enduml\n";
		    System.out.println(s); 
		    generateUML p = new generateUML();
		    p.umlCreator(s);
	    
		  }
		  
	 }
	 private static class MethodVisitor extends VoidVisitorAdapter {

	        @Override
	        public void visit(FieldDeclaration n, Object arg) {
	           
	           
	        	String k =n.toString();
	             k = k.replaceAll("[;]", "");
	             String[] strs = k.split("\\s+");
	             if(strs[0].equals("public"))
	            	 strs[0]="+" ;
	             if(strs[0].equals("private"))
	            	 strs[0]="-" ;
	             if(strs[0].equals("protected"))
	            	 strs[0]="#" ;
	             
	             s = s + classname + " : " + strs[0] + " " + strs[1] + " " + strs[2];
	             s = s + "\n";
	       
	             super.visit(n, arg);
	        }
	        
	        
}
	 
	 
	 private static class MethodVisitor1 extends VoidVisitorAdapter {

	      
	        @Override
	        public void visit(MethodDeclaration n, Object arg) {
	        	
	            s = s + classname + " : " + n.getName() + "()" ;
	            s = s + "\n";
	        }
	        
	        
}
	 private static class MethodVisitor2 extends VoidVisitorAdapter {

	      
		 @Override
		 public void visit(ClassOrInterfaceDeclaration decl, Object arg)
		   {
		      // Make class extend//
			 
			 List<ClassOrInterfaceType> list = decl.getExtends();
			 if(list==null)
				 return;
			 for (ClassOrInterfaceType k : list) {
					String n = k.toString();
					s = s + n + " " + "<|--" + " " + classname + "\n";
				}
		      
		      
		   }
	        
}

	 private static class MethodVisitor3 extends VoidVisitorAdapter {

	      
		 @Override
		 public void visit(ClassOrInterfaceDeclaration decl, Object arg)
		   {
		      // Make class extend Blah.
			 
			 
			 List<ClassOrInterfaceType> list = decl.getImplements();
			 if(list==null)
				 return;
			 for (ClassOrInterfaceType k : list) {
					String n = k.toString();
					s = s + n + " " + "<|--" + " " + classname + "\n";
				}
			
		      
		      
		   }
	        
}

}

