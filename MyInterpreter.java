
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.FileNotFoundException;
import java.util.Vector;

public class MyInterpreter {

	public void Interpret(String _file){
		String file = "mycodes.txt";
		if(_file.equals("")){
			file = "mycodes.txt";
		}else{
			file = _file;
		}
		 try {
			BufferedReader reader = new BufferedReader( new FileReader (file));
			BufferedReader inputreader = new BufferedReader(new InputStreamReader(System.in));
			String s;
			String ss="";
			int i= 0;
			while((s = reader.readLine()) != null) {
				ss=ss+s;
				i++;				
			}
			String d = "";
			StringTokenizer tokens = new StringTokenizer(ss);
			Vector var = new Vector();
			boolean anotherline = false;
			while(tokens.hasMoreTokens()){
				if(anotherline){
					anotherline=false;
				}else{
					d = tokens.nextToken();
				}
				if(d.equals("int")){
					String valname = tokens.nextToken();
					myVariable v = new myVariable(valname, 0);
					var.addElement(v);					
				}else if(d.equals("read")){
					String r = inputreader.readLine();
					int num = var.size();
					int x = 0;
					String h = tokens.nextToken();
					while(x<num){
						myVariable tmp = (myVariable)var.elementAt(x);
						if(h.equals(tmp.getName())) {
							tmp.setVal(Integer.parseInt(r));
						}
						x++;
					}					
				}else if(d.equals("readline")){
					String r = inputreader.readLine();
					int num = var.size();
					int x = 0;
					String h = tokens.nextToken();
					while(x<num){
						myVariable tmp = (myVariable)var.elementAt(x);
						if(h.equals(tmp.getName())) {
							tmp.setVal(Integer.parseInt(r));
						}
						x++;
					}					
				}else if(d.equals("write")){					
					int num = var.size();
					int x = 0;
					String h = tokens.nextToken();
					String r = "";					
					if(h.charAt(0) == '"'){						
						String end = "";
						r = r + h;
						boolean endchar = false;
						while(!endchar){
							end = tokens.nextToken();
							r = r + " "+end;
							int endcharlength = end.length();
							if(end.charAt(endcharlength-1)=='"'){
								endchar=true;
							}							
						}
					}else{
						while(x<num){
							myVariable tmp = (myVariable)var.elementAt(x);
							if(h.equals(tmp.getName())) {
								r = tmp.getVal()+"" ;
							}
							x++;
						}
					}					
					System.out.print(r);
				}else if(d.equals("writeline")){
					int num = var.size();
					int x = 0;
					String h = tokens.nextToken();
					String r = "";
					
					if(h.charAt(0) == '"'){						
						
						String end = "";
						r = r + h;
						boolean endchar = false;
						while(!endchar){
							end = tokens.nextToken();
							r = r + " "+end;
							int endcharlength = end.length();
							if(end.charAt(endcharlength-1)=='"'){
								endchar=true;
							}							
						}
					}else{
						while(x<num){
							myVariable tmp = (myVariable)var.elementAt(x);
							if(h.equals(tmp.getName())) {
								r = tmp.getVal()+"" ;
							}
							x++;
						}
					}					
					System.out.println(r);					
				}
				int num = var.size();
				int x = 0;
				boolean found = false;
				while(x<num){
					myVariable tmp = (myVariable)var.elementAt(x);
					if(d.equals(tmp.getName())) {
						
						int total = 0;
						int y = 0;
						int a = 0;
						int b = 0;
						String operand = tokens.nextToken();
						String operand2 ="";
						if(operand.equals("=")){
							String d2 = tokens.nextToken();
							y=0;
							while(y<num){
								myVariable tmp2 = (myVariable)var.elementAt(y); 
								if(d2.equals(tmp2.getName())) {
									found=true;
									a = tmp2.getVal();
								}
								y++;
							}
							if(!found){
								a = Integer.parseInt(d2);
							}						
							operand2 = tokens.nextToken();
							found = false;
							if(operand2.equals("+") || operand2.equals("-")|| operand2.equals("*")||operand2.equals("/")||operand2.equals("%")){
								d2 = tokens.nextToken();
								y=0;
								while(y<num){
									myVariable tmp2 = (myVariable)var.elementAt(y); 
									if(d2.equals(tmp2.getName())) {
										found=true;
										b = tmp2.getVal();
									}
									y++;
								}
								if(!found){
									b = Integer.parseInt(d2);
								}
							}else{
								d = operand2;
								anotherline = true;
								operand2="";
							}							
						}
						if(operand2.equals("")){
							total= a;
						}else{
							if(operand2.equals("+")){
								total = a + b;
							}else if(operand2.equals("-")){
								total = a - b;
							}else if (operand2.equals("*")){
								total = a * b;
							}else if(operand2.equals("/")){
								total = a / b;
							}else if(operand2.equals("%")){
								total = a % b;
							}
						}						
						tmp.setVal(total);						
					}
					x++;
				}
			}			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	public static void main(String[] args){
		MyInterpreter interpreter = new MyInterpreter();
		interpreter.Interpret(args[0]);
	}	
}
class myVariable{
	String str;
	int val;
	public myVariable(String _str, int _val){
		str = _str;
		val = _val;
	}
	public void setVal(int _val){
		val = _val;	
	}
	public int getVal(){
		return val;
	}
	public String getName(){
		return str;
	}
}
