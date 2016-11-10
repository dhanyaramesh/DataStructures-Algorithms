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
import java.util.List;



public class ClassOrInterfaceVisitor extends VoidVisitorAdapter {
	private boolean isInterface = false; 
	private String Name;
	private String extend;
	private String implement;
	
	public void visit(ClassOrInterfaceDeclaration n, Object arg) {
		if(n.getName().toString() != null){
			Name = n.getName().toString();
			if(n.isInterface()){
				isInterface = true;
			}else{
				if(n.getExtends()!=null)
				{
				if(n.getExtends().toString()!= "[]"){
					extend = n.getExtends().toString();
				}
				}
				if(n.getImplements()!=null)
				{
				if(n.getImplements().toString()!= "[]"){
					implement = n.getImplements().toString();
				}
				}
			}
		}
    }
	
	public boolean isInt(){
		return isInterface;
	}
	public String getClassName(){
		return Name;
	}
	public String getExtend(){
		return extend;
	}
	public String getImp(){
		return implement;
	}
	
	public static void main(String[] args) throws Exception{
		FileInputStream in = new FileInputStream("B2.java");

        CompilationUnit cu;
        try {
            cu = JavaParser.parse(in);
        } finally {
            in.close();
        }

        ClassOrInterfaceVisitor civ = new ClassOrInterfaceVisitor();
        civ.visit(cu, null);
        System.out.println(civ.getClassName());
        System.out.println(civ.getExtend());
        System.out.println(civ.getImp());
        System.out.println(civ.isInt());
	}
}
