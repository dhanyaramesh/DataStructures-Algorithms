import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.awt.List;
import java.io.*;
import java.util.*;

import Parser.generateUML;
//import Parser.Umlgen.MethodVisitor;

public class java2uml {
	public static String s = "@startuml\n";
	public static String classname;
	public static ArrayList<String> accessSpecifiers = new ArrayList<String>(Arrays.asList("private","protected","public"));
	public static Map<String, java.util.List<String>> connection =  new HashMap<String, java.util.List<String>>();
	public static ArrayList<String> impList = new ArrayList<>();
	public static ArrayList<String> datatypes = new ArrayList<String>(Arrays.asList("null","int", "String", "Integer","float","Double","ArrayList","List","Set","HashMap","double","boolean","short","char","long"));
	public static Boolean IsAssociation = false;
	public static Boolean Multiplicity =false;
	
	public static ArrayList<String>privateAttributes = new ArrayList<String> ();

	public static void main(String args[]) throws ParseException, IOException
	{
		
		File dir = new File ("/Users/dhanyaramesh/Documents/workspace/umlParser/src/uml-parser-test-5/");
		File[] directoryListing = dir.listFiles();
		  if (directoryListing != null) {
		    for (File child : directoryListing) {
		    	System.out.println(child);
		    	if((child.getName().contains(".java")))
		    	{
		    	File file = new File(child.getAbsolutePath());
		    	FileInputStream fis = new FileInputStream(file);
		        CompilationUnit cu;
		        try {
		           
		            cu = JavaParser.parse(fis,"UTF8");
		        	}
		        finally {
		            fis.close();
		        }
		
		
		//FileInputStream fis = new FileInputStream(file);
		//CompilationUnit cu;
		
		
		String cu2str = cu.toString();
		String[] lines = cu2str.split("\\r?\\n");
		String delims = "[ .,?!]+";
        String[] tokens = lines[0].split(delims);
       
        java.util.List<TypeDeclaration> types = cu.getTypes();
        //java.util.List types1 = cu.getTypes();
        TypeDeclaration typeDec = (TypeDeclaration) types.get(0);
		  
        classname = typeDec.getName();
        
        System.out.println("tokens[2]" + tokens[2]);
       
        	if(tokens[1].equals("class"))
        	{
        		if(!impList.contains(classname))
        			s = s + "class" + " " + tokens[2] + " \n";
        	}
        	 
            if(tokens[1].equals("interface"))
            {
            	impList.add(tokens[2]);
            	//s = s  + "interface" + " " + classname + " \n";
            }
        		
        
        //new FieldVisitor().visit(cu, null);
        new FieldVisitor1().visit(cu, null);
        new ImplementsVisitor().visit(cu, null);
        if(! tokens[1].equals("interface"))
        	new MethodVisitor().visit(cu, null);
        new ConstructorVisitor().visit(cu, null);
        new InheritanceVisitor().visit(cu, null);
       
        //new MethodVisitor().visit(cu, null);
        
        
        
		}
    }
        s = s + "@enduml\n";
	    System.out.println(s); 
        generateUML p = new generateUML();
	    p.umlCreator(s);		
	}


	}
	
private static class FieldVisitor1 extends VoidVisitorAdapter 	{

	@Override
	public void visit(FieldDeclaration n, Object arg)
	{
		ArrayList val=new ArrayList();
		if(n.getType().toString().contains("[") && n.getType().toString().contains("]"))
		{
			String dt[] = n.getType().toString().split("\\[");
			if(!(datatypes.contains(dt[0])))       //association with multiplicity
			{
				if(connection.containsKey(classname))
				{
					val = (ArrayList) connection.get(classname);
					if(!(val.contains(dt[0])))
					{
						val.add(dt[0]);
						connection.put(classname, val);
						if(! impList.contains(dt[0]))
						s=s + classname + " -- \"*\" " + dt[0] + "\n"; 
					}
				}
				else
				{
					val.add(dt[0]);
					connection.put(classname,val);
					if(! impList.contains(dt[0]))
					s=s + classname + " -- \"*\" " + dt[0] + "\n"; 
				}
				
				// write attribute anyways
				
				
			}
			 //primitive array
			
				if(n.getModifiers() == 2 || n.getModifiers() == 0)
				{
					s = s + classname + " : " + "-" + " " + n.getVariables().get(0) + " : " +n.getType();
					s = s + "\n";
					privateAttributes.add(n.getVariables().get(0).toString());
				}
				if(n.getModifiers() == 4)
				{
					s = s + classname + " : " + "#" + " " + n.getVariables().get(0) + " : " +n.getType();
					s = s + "\n";
				}
				if(n.getModifiers() == 1)
				{
					s = s + classname + " : " + "+" + " " + n.getVariables().get(0) + " : " +n.getType();
					s = s + "\n";
				}
			
			
		}  // all array conditions over
		
		else   // no []
		{
			if(n.getType().toString().contains("Collection"))   // if it is a collection
			{
				String[] dt=n.getType().toString().split("\\<");
				dt[1] = dt[1].substring(0, dt[1].length()-1);
				if(!(datatypes.contains(dt[1])))   // collection of association
				{
					if( !( connection.containsValue(dt[1])) )
					{
						
						if(connection.containsKey(classname))
						{
						
							val = (ArrayList) connection.get(classname);
							if(!(val.contains(dt[1])))
							{
								val.add(dt[1]);
								connection.put(classname, val);
								if(! impList.contains(dt[0]))
								s=s + classname + " -- \"*\" " + dt[1] + "\n"; 
							}
						}
						else
						{
							val.add(dt[1]);
							connection.put(classname,val);
							if(! impList.contains(dt[0]))
							s=s + classname + " -- \"*\" " + dt[1] + "\n"; 
						}
					}
					
					
				}
				//else collection of primitive

				if(n.getModifiers() == 2 || n.getModifiers() == 0)
				{
					s = s + classname + " : " + "-" + " " + n.getVariables().get(0) + " : " +n.getType();
					s = s + "\n";
					privateAttributes.add(n.getVariables().get(0).toString());
				}
				if(n.getModifiers() == 4)
				{
					s = s + classname + " : " + "#" + " " + n.getVariables().get(0) + " : " +n.getType();
					s = s + "\n";
				}
				if(n.getModifiers() == 1)
				{
					s = s + classname + " : " + "+" + " " + n.getVariables().get(0) + " : " +n.getType();
					s = s + "\n";
				}
				
			}
			else
			{
				if(!(datatypes.contains(n.getType().toString())))  // association single
				{
					if(connection.containsKey(classname))
					{
						ArrayList dummy = (ArrayList) connection.get(classname);
						if(!(dummy.contains(n.getType().toString())))
						{
							if(! impList.contains(n.getType()))
							s = s + classname + " -- " + n.getType() + " \n ";
							val=(ArrayList) connection.get(classname);
							val.add(n.getType().toString());
							connection.put(classname, val);
						}
						
					}
					
					else
					{
						val.clear();
						val.add(n.getType().toString());
						connection.put(classname, val);
					}
					
				}
				
				//primitive single
				
					if(n.getModifiers() == 2 || n.getModifiers() == 0)
					{
						s = s + classname + " : " + "-" + " " + n.getVariables().get(0) + " : " +n.getType();
						s = s + "\n";
						privateAttributes.add(n.getVariables().get(0).toString());
					}
					if(n.getModifiers() == 4)
					{
						s = s + classname + " : " + "#" + " " + n.getVariables().get(0) + " : " +n.getType();
						s = s + "\n";
					}
					if(n.getModifiers() == 1)
					{
						s = s + classname + " : " + "+" + " " + n.getVariables().get(0) + " : " +n.getType();
						s = s + "\n";
					}
				
			}
		}
		System.out.println(connection);
		super.visit(n, arg);
		
	}
		
}
private static class MethodVisitor extends VoidVisitorAdapter {
	
	@Override	public void visit(MethodDeclaration n,Object arg)
	{
		if( (n.getName().startsWith("get")) || (n.getName().startsWith("set")))
		{
			for(int i=0;i<privateAttributes.size();i++)
			{
				System.out.println("inside get");
				String name = privateAttributes.get(i);
				name = name.replace(name.charAt(0), Character.toUpperCase(name.charAt(0)));
				System.out.println(name+ "name:" + n.getName().toString());
				if(n.getName().toString().contains(name) || n.getName().toString().contains(privateAttributes.get(i)))
				{
					System.out.println("inside priv");
					s= s.replace( "-" + " " + privateAttributes.get(i) ,  "+" + " " + privateAttributes.get(i) );
				}
			}
					
		}
		
	
		
		if(!(n.getName().startsWith("get")) && !(n.getName().startsWith("set")) )
		{

			
			if(n.getParameters() != null)
			{
				
				java.util.List<Parameter> param =  n.getParameters();
				String[] params = param.get(0).toString().split("\\s+");
				String displayParam = params[0];

				if(params[0].contains("[") && params[0].contains("]") )
				{
					params[0] = params[0].replace("[", "");
					params[0] = params[0].replace("]", "");
					
				}
				
				
				if(!(datatypes.contains(params[0])))
				{
					System.out.println("normal");
					String dummy = classname + " -- " + params[0];
					String dummy1 = classname + " -- \"*\" " + params[0];
					if(!(s.contains(classname + " ..> " + params[0] )) /**/&& !(s.contains(dummy)) && !(s.contains(dummy1))) 
					{
						if(! impList.contains(params[0]))
						s= s + classname + " ..> " + params[0] + " : uses " + " \n";
					}
					if(!impList.contains(n.getName()))
					s = s + classname + " : " + n.getName() + "(" + displayParam +")" + ":" + n.getType() + " \n";
				}
				else
				{
					if(!impList.contains(n.getName()))
					s = s + classname + " : " + n.getName() + "(" + displayParam +")" + ":" + n.getType() + "\n";
				}
			}
			else
			{
				if(!impList.contains(n.getName()))
				s = s + classname + " : " + n.getName() + "()" + ":" + n.getType() + "\n";
				
			}
		}
	
	}
}

private static class InheritanceVisitor extends VoidVisitorAdapter {

    
	 @Override
	 public void visit(ClassOrInterfaceDeclaration decl, Object arg)
	   {
	      // Make class extend//
		
		 java.util.List<ClassOrInterfaceType> list = decl.getExtends();
		 if(list==null)
			 return;
		 for (ClassOrInterfaceType k : list) {
				String n = k.toString();
				//classList.put(n, 1);
				
				s = s + n + " " + "<|--" + " " + classname + "\n";
			}
	      
	      
	   }
       
}

private static class ImplementsVisitor extends VoidVisitorAdapter {

     
	 @Override
	 public void visit(ClassOrInterfaceDeclaration decl, Object arg)
	   {
	      // Make class extend Blah.
		 System.out.println("imp" + impList);
		 
		 java.util.List<ClassOrInterfaceType> list = decl.getImplements();
		 if(list==null)
			 return;
		 for (ClassOrInterfaceType k : list) {
				String n = k.toString();
				System.out.println("n" + n);
				if(impList.contains(n))
					if(! s.contains(n + " -0)- " ))
						s = s + n + " -0)- " + classname + "\n";
				//classList.put(n, 1);
				
			}	      
	   }
       
}
    

private static class ConstructorVisitor extends VoidVisitorAdapter {
	@Override
	public void visit(ConstructorDeclaration n, Object arg)
	{
		
		if(n.getParameters() != null)
		{
			
			java.util.List<Parameter> param =  n.getParameters();
			String[] params = param.get(0).toString().split("\\s+");
			String displayParam = params[0];
			
			
			if(params[0].contains("[") && params[0].contains("]") )
			{
				params[0] = params[0].replace("[", "");
				params[0] = params[0].replace("]", "");
				
			}
			
			
			if(!(datatypes.contains(params[0])))
			{
				System.out.println("normal");
				if(!(s.contains(classname + " ..> " + params[0] )))
				{
					if(impList.contains(params[0]))
					{
						if(!s.contains(params[0] + " --() " ))
			/* */				s = s+ classname + " --() " + params[0] + " : uses " + " \n";
					}
					else
					{
						s= s + classname + " ..() " + params[0] + " : uses " + " \n";
					}
					//s= s + classname + " ..> " + params[0] + " : uses " + " \n";
				}
				s = s + classname + " : " + n.getName() + "(" + displayParam +")"  + " \n";
			}
			else
			{
				s = s + classname + " : " + n.getName() + "(" + displayParam +")" ;
				s = s + "\n";
			}
		}

		else
		{
			s = s + classname + " : " + n.getName() + "("  +")" ;
			s = s + "\n";
		}
		
	}
}

}


