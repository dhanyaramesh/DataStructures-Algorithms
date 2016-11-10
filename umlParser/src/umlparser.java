/*

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;
import net.sourceforge.plantuml.GeneratedImage;
import net.sourceforge.plantuml.SourceFileReader;
import japa.parser.JavaParser;
import japa.parser.ast.CompilationUnit;*/
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
import net.sourceforge.plantuml.GeneratedImage;
import net.sourceforge.plantuml.SourceFileReader;
import net.sourceforge.plantuml.SourceStringReader;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import com.github.javaparser.JavaParser;
//import com.github.javaparser.ast.CompilationUnit;
import com.google.zxing.Writer;

import Parser.generateUML;

public class umlparser {

	public static void main(String[] args) {
		File path = new File("/Users/dhanyaramesh/Documents/workspace/umlParser/src/uml-parser-test-5/");  
		File[] list = path.listFiles();
		String cInfo;
		String output = "/Users/dhanyaramesh/Documents/workspace/umlParser/src/uml-parser-test-5/";
		ArrayList<String> umlResult = new ArrayList<String>();
		ArrayList<String> fInfo = new ArrayList<String>();
		ArrayList<String> mInfo = new ArrayList<String>();
		ArrayList<String> iName = new ArrayList<String>();
		ArrayList<String> compare = new ArrayList<String>();
		ArrayList<String> fName = new ArrayList<String>();
		ArrayList<String> relationship = new ArrayList<String>();
		ArrayList<String> connectionFormat = new ArrayList<String>();
		
		umlResult.add("@startuml");
		umlResult.add("skinparam classAttributeIconSize 0");
		
		for(int i = 0; i < list.length; i++){
			File file = list[i];
			if(file.isFile() && file.getName().endsWith(".java")){
				String fname = file.getName().substring(0, file.getName().indexOf("."));
				fName.add(fname);
				FileInputStream in1 = null;
				CompilationUnit cu1 = null;
				try{
					in1 = new FileInputStream(file.getAbsolutePath());
					cu1 = JavaParser.parse(in1);
				}catch(Exception e){
					System.err.println("File path error or Parser Error");
				}finally{
					try{
						in1.close();
					}catch (Exception e){
						e.printStackTrace();
					}
				}
				ClassOrInterfaceVisitor civ1 = new ClassOrInterfaceVisitor();
				civ1.visit(cu1, null);
				if(civ1.isInt() == true){
					iName.add(civ1.getClassName());
				}
			}
		}
		for(int i = 0; i < list.length; i++){
			File file = list[i];
			if(file.isFile() && file.getName().endsWith(".java")){
				String fname = file.getName().substring(0, file.getName().indexOf("."));
				FileInputStream in = null;
				CompilationUnit cu = null;
				try{
					in = new FileInputStream(file.getAbsolutePath());
					cu = JavaParser.parse(in);
				}catch(Exception e){
					System.err.println("File path error or Parser Error");
				}finally{
					try{
						in.close();
					}catch (Exception e){
						e.printStackTrace();
					}
				}
				ClassOrInterfaceVisitor civ = new ClassOrInterfaceVisitor();
				FieldVisitor fv = new FieldVisitor();
				ConstructorVisitor cv = new ConstructorVisitor();
				MethodVisitor mv = new MethodVisitor();
				civ.visit(cu, null);
				if(civ.isInt() == true){
					iName.add(civ.getClassName());
					umlResult.add("interface "+civ.getClassName()+"{");	
				}else{
					umlResult.add("class "+civ.getClassName()+"{");	
				}
				fv.visit(cu, null);
				fInfo = fv.getFormat();		
				cv.visit(cu, null);
				cInfo = cv.getCFormat();
				mv.visit(cu, null);
				mInfo = mv.getMFormat();	
				Map<String, Integer> map = new HashMap<String, Integer>();
				for (int idx = 0; idx < mInfo.size(); idx++) {
					String temp = mInfo.get(idx);
					if (!temp.substring(0, 1).equals("+")) {
						continue;
					}
					String cur = temp.substring(1, 4).toLowerCase();
					if (cur.equals("get") || cur.equals("set")) {
						String str = temp.substring(4, temp.indexOf("("));
						str = str.toLowerCase();
						Integer flag =  map.put(str, idx);
						if (flag != null) {
							for (int j = 0; j < fInfo.size(); j++) {
								String var = fInfo.get(j);
								if (var.substring(1, var.indexOf(":")).toLowerCase().equals(str)) {
									fInfo.set(j, "+" + var.substring(1));
									mInfo.remove(idx);
									mInfo.remove((int)flag);
								}
							}
						}
					}
				}
				umlResult.addAll(fInfo);
				umlResult.add(cInfo);
				umlResult.addAll(mInfo);
				umlResult.add("}");
				RelationConstructor getRelation = new RelationConstructor(fv, civ, fName, iName, connectionFormat, mv, cv);
				getRelation.BuildRelationship();	
				compare = getRelation.getRelations();
				for(int k = 0; k < compare.size(); k++){
					if(!relationship.contains(compare.get(k))){
						relationship.add(compare.get(k));
					}
				}
			}
		}
		for(int j = 0; j < umlResult.size(); j++){
			if(umlResult.get(j) != null)
				System.out.println(umlResult.get(j)); 
		}
		umlResult.addAll(relationship);
		umlResult.addAll(connectionFormat);
		socketNotation(umlResult);
		System.out.println("as" + umlResult);
		umlResult.add("@enduml");
		printUML(umlResult, output);
		drawUML(output);
	}
	
	public static void printUML(ArrayList<String> umlResult, String outputPath){
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(outputPath+"/UMLoutput.java","UTF-8");
			for(int i = 0; i < umlResult.size(); i++){
				if(umlResult.get(i) != null){
					writer.println(umlResult.get(i));
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		writer.close();
	}
	
	public static void socketNotation(ArrayList<String> umlResult) {
		System.out.println("before remove" + umlResult);
		for (int i = 0; i < umlResult.size(); i++) {
			if (umlResult.get(i) != null) {
				
				if (umlResult.get(i).toString().contains("<|..")) {	
					System.out.println("inside if");
					String temp = umlResult.get(i).replaceAll("\\s+", "");
					String itf = temp.substring(0, temp.indexOf("<"));
					int count = 0, countUse = 0;
					for (int k = 0; k < umlResult.size(); k++) {
						String curUML = umlResult.get(k);
						if (curUML == null) {
							continue;
						} 
						if (curUML.contains(itf) && curUML.contains("<|.."))
							count++;
						if (curUML.contains(itf) && curUML.contains(":use"))
							countUse++;
					}
					System.out.println("count" + count + " " + countUse );
					//if (count > 1 || countUse > 1)											
						//continue;
					String impClass = temp.substring(temp.indexOf(".") + 2, temp.length());									
					
						//if (umlResult.get(j) == null) {
							//continue;
						//}else
						//if (!umlResult.get(j).toString().contains(itf + ":use")) {
							System.out.println("inside");
							for (int j = 0; j < umlResult.size(); j++) {
							if(umlResult.get(j)!=null)
							{
							String dp = umlResult.get(j).toString();
							System.out.println("dp" + dp);
							dp = dp.replaceAll("\\s+", "");
							String result =dp;
							if(dp.contains("."))
								 result = impClass + "-0)-" + dp.substring(0, dp.indexOf(".")) + ":\"" + itf + "\"";	
							System.out.println("result" + result);
							umlResult.add(result);
							//umlResult.remove(i);
							//umlResult.remove(j-1);
							
							removeInterface(umlResult, itf);
							}
								
						//}
					}
				}
			}
		}
		System.out.println("after remove" + umlResult);
	}
	
	public static void removeInterface(ArrayList<String> umlResult, String name) { 
		for (int i = 0; i < umlResult.size(); i++) {
			if (umlResult.get(i) != null) {
				if (umlResult.get(i).contains("interface "+name+"{")) {
					int index = 0;
					for (int k = i; k < umlResult.size(); k++) {
						if (umlResult.get(k) != null) {
							String temp = umlResult.get(k).toString();
							if (temp.compareTo("}") == 0) {
								index = k;
								break;
							}
						}
					}
					for (int k = index; k >= i; k--)
						umlResult.remove(k);
					break;
				} 
			}
		}
		/*System.out.println(umlResult.toString());
		generateUML p = new generateUML();
	    p.umlCreator(umlResult.toString());*/
	}
	
	public static void drawUML(String outputPath){
		File source = new File(outputPath+"/UMLoutput.java");
		SourceFileReader reader = null;
		try {
			reader = new SourceFileReader(source);
			List<GeneratedImage> list = reader.getGeneratedImages();
			list.get(0).getPngFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}