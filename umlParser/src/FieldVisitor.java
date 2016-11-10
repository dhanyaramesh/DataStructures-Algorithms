import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.ClassOrInterfaceDeclaration;
import japa.parser.ast.body.ConstructorDeclaration;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.Parameter;
import japa.parser.ast.body.TypeDeclaration;
import japa.parser.ast.stmt.Statement;
import japa.parser.ast.type.ClassOrInterfaceType;
import japa.parser.ast.visitor.VoidVisitorAdapter;
import net.sourceforge.plantuml.SourceStringReader;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class FieldVisitor extends VoidVisitorAdapter {
	
	private ArrayList<String> fFormat = new ArrayList<String>(); 
 	private ArrayList<String> nonPrimitive = new ArrayList<String>(); 
 	private ArrayList<String> reserveTypes = new ArrayList<String>(Arrays.asList("byte","short","int","long","float","double","boolean","char","Integer","String", "Character")); 

    public void visit(FieldDeclaration n, Object arg) {
		String result = null;
		String type;
		String var;
		String[] str1;
		String[] str2;
		StringBuilder sb = new StringBuilder();
		if(n.getVariables().toString()==null){
			fFormat = null;
		}else{
			type = n.getType().toString();
			if(reserveTypes.contains(type)){
				switch(n.getModifiers()){
					case 0: 
						return;
					case 1:
						sb.append("+");break;
					case 17:
						sb.append("+");break;
					case 2:
						sb.append("-");break;
					case 4:
						return;
				}
				var = n.getVariables().toString();
				var = var.substring(var.indexOf("[")+1, var.indexOf("]"));
				if(var.contains("=")){
					str1 = var.split("=");
					str1[0] = str1[0].replaceAll("^\\s*|\\s*$", "");
					str1[1] = str1[1].replaceAll("^\\s*|\\s*$", "");
					if (str1[1].contains("<") == true) {
						int startIndex = str1[1].indexOf("<");
						int endIndex = str1[1].indexOf("(");
						type = str1[1].substring(startIndex, endIndex);
					}else if (str1[1].contains("[") == true) {
						str2 = str1[1].split(" ");
						int endIndex = str2[1].indexOf("(");
						type = str2[1].substring(0, endIndex);
					}else {
						sb.append(str1[0]);
					}
				}else{
					sb.append(var);
				}
				sb.append(":");
				sb.append(type);
			}
			if(!reserveTypes.contains(type)){ 
				if(type.contains("<")){ 
					type = type.substring(type.indexOf("<")+1, type.indexOf(">"));
					if(!nonPrimitive.contains(type)){ 
						nonPrimitive.add(type+"*"); 
					} 
				}else if(type.contains("[")){ 
					switch(n.getModifiers()){
						case 0: 
							sb.append("~");break;
						case 1:
							sb.append("+");break;
						case 2:
							sb.append("-");break;
						case 4:
							sb.append("#");break;
					}
					var = n.getVariables().toString();
					var = var.substring(var.indexOf("[")+1, var.indexOf("]"));
					sb.append(var);
					sb.append(":");
					sb.append(type);
					type = type.substring(0, type.indexOf("[")); 
					if(!nonPrimitive.contains(type)){ 
						if(!reserveTypes.contains(type)){ 
							nonPrimitive.add(type+"*"); 
						} 
					} 
				}else{ 
					if(!nonPrimitive.contains(type)){ 
						nonPrimitive.add(type); 
					} 
				} 
			} 
			result = sb.toString();
			if(result.length()!=0)
				fFormat.add(result);
		}
    }
	
	public ArrayList<String> getNonReserve(){ 
 		return nonPrimitive; 
	} 
	
	public ArrayList<String> getFormat(){
		return fFormat;
	}
	
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream("Decorator.java");

        CompilationUnit cu;
        try {
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }

        FieldVisitor fv = new FieldVisitor();
        fv.visit(cu, null);
        System.out.println(fv.getNonReserve());
        System.out.println(fv.getFormat());
	}
}
