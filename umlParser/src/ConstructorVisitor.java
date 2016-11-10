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

public class ConstructorVisitor extends VoidVisitorAdapter{
	private String result;
	private String name;
	private String modifier;
	private String parameter;
	private ArrayList<String> npType = new ArrayList<String>();
	private ArrayList<String> reserveTypes = new ArrayList<String>(Arrays.asList("byte","short","int","long","float","double","boolean","char","Integer","String", "Character","void"));

	public void visit(ConstructorDeclaration n, Object arg) {
        if(n.getName().toString() != null){
        	name = n.getName().toString();
        	switch(n.getModifiers()){
				case 0: modifier = "~";
					break;
				case 1: modifier = "+";
					break;
				case 2: modifier = "-";
					break;
				case 4: modifier = "#";
					break;
        	}
        	parameter = n.getParameters().toString();
        	if(n.getParameters().isEmpty()){
        		result = modifier + name + "(";
			}else{
	        	parameter = parameter.substring(parameter.indexOf("[")+1, parameter.indexOf("]"));
	        	String[] onePara = parameter.split(",");
	        	for(int i = 0; i < onePara.length; i++){
	        		onePara[i] = onePara[i].replaceAll("^\\s*|\\s*$", "");
	        	}
	        	for(int i = 0; i < onePara.length; i++){
	        		String[] pType = onePara[i].split(" ");
	        		if(!reserveTypes.contains(pType[0])){
	        			npType.add(pType[0]);
	        		}
	        		if(i == 0){
	        			result = modifier + name + "(" + pType[1] + ":" + pType[0];
	        		}else{
	        			result = result + ", " + pType[1] + ":" +pType[0];
	        		}
	        	}
			}
        	result = result + ")";
        }else{
        	result = null;
        }
    }
	
	public String getCFormat (){
		return result;
	}
	
	public ArrayList<String> getNoReserveType(){
		return npType;
	}
}
