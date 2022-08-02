
package analisintac_lr1;
import java.io.*;
import java.awt.event.*;
import java.util.StringTokenizer;
import javax.swing.*;
import java.util.Stack;
import java.util.regex.*;


public class ControLR1FR {
    private LR1FR vistaInicio;
    public static StringTokenizer sTokenizer;
    public static String ExpressionLeft;
    public static String currentString;
    public static Stack<String> stackSymbol = new Stack<String>();
    public static Stack<Integer> stackState = new Stack<Integer>();
    JFileChooser seleccionar= new JFileChooser();
    File Archivo;
    FileInputStream entrada;
    FileOutputStream salida;
    LRPARSER LRP;

    
    public ControLR1FR(LR1FR vistaInicio){
        this.vistaInicio = vistaInicio;
        this.vistaInicio.btnSalir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });
        
        this.vistaInicio.btnImportarAr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
                if(seleccionar.showDialog(null, "Abrir")==JFileChooser.APPROVE_OPTION){
                        Archivo=seleccionar.getSelectedFile();
                    if(Archivo.canRead()){
                        if(Archivo.getName().endsWith("txt")){
                            String documento=AbrirArchivo(Archivo);
                            vistaInicio.txtAreaA.setText(documento);
                        }else{
                            JOptionPane.showMessageDialog(null,"Formato incorrecto");
                    
                        }
                    }
                }
            }
        });
        
        this.vistaInicio.btnGuardarEdit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                if(seleccionar.showDialog(vistaInicio.txtAreaA, "Guardar")==JFileChooser.APPROVE_OPTION){
                        Archivo=seleccionar.getSelectedFile();
                    if(Archivo.getName().endsWith("txt")){
                        String Documento=vistaInicio.txtAreaA.getText();
                        String mensaje= GuardarArchivo(Archivo,Documento);
                        if(mensaje!=null){
                            JOptionPane.showMessageDialog(null, mensaje);
                        }else{
                            JOptionPane.showMessageDialog(null, "Formato incorrecto");
                        } 
                    }else{
                        JOptionPane.showMessageDialog(null, "Guardado");
                    }
                }
            }
        });
        
        this.vistaInicio.btnAnalizarAr.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String text= vistaInicio.txtAreaA.getText();
                // tokenizing the input string
                sTokenizer = new StringTokenizer(text + " $"," ");
                next();
                input();
                LRParser();
            }
        });
        
        
        
        
    
    
    }
    
    public String AbrirArchivo(File archivo){
        String documento="";
        try{
            entrada=new FileInputStream(archivo);
            int ascci;
            while((ascci=entrada.read())!=-1){
                char caracter=(char)ascci;
                documento+=caracter;
            }
        }catch(Exception e){
        }   
        return documento;
    }
    
    public String GuardarArchivo(File archivo,String documento){
        String mensaje=null;
        try{
            salida=new FileOutputStream(archivo);
            byte[] bytxt=documento.getBytes();
            salida.write(bytxt);
            mensaje="Archivo guardado";
        }catch(Exception e){
        }
        return mensaje;
    }
    public void iniciar(){

        vistaInicio.setLocationRelativeTo(null);
        vistaInicio.setVisible(true);
        vistaInicio.txtAreaA.setText(" khan23 + maricon24 * ( max1 + no2 + reniegues3 )");
    }
    public void next(){
	currentString = sTokenizer.nextToken().intern();
        Pattern pat = Pattern.compile(".+[0-9]+.+");
        Matcher mat = pat.matcher(currentString);
        boolean rs = mat.matches();
	if(currentString == "+"){}
        else if(currentString == "*"){}
	else if(currentString == "("){}
	else if(currentString == ")"){}
	else if(currentString == "$"){}
	else {
			currentString = "n";}
    }
    
    public String input(){	
	ExpressionLeft = "";
	while(currentString != "$")
	{		
	  ExpressionLeft += currentString;
	  next();
	}
	ExpressionLeft += "$";
	return ExpressionLeft;
    }
    
    public void shift(int nextState){
        stackSymbol.push("" + ExpressionLeft.charAt(0));
        stackState.push(nextState);
        ExpressionLeft = ExpressionLeft.substring(1); 
    }
    
    public void LRParser(){
	stackSymbol.push("-");
	stackState.push(0);
        String rpta = "";
	int resume = 1;
	while(resume == 1)
	{
		int stateOfStack = stackState.peek();
		char frontOfExpression = ExpressionLeft.charAt(0);
                int X[]={0,1,2,3,4,5,6,7,8,9,10,11};
                String Resp = "";
		switch(frontOfExpression)
		{
			case 'n':
			{
				if(stateOfStack == X[0] || stateOfStack == X[4] || stateOfStack == X[6]|| stateOfStack == X[7]){
					shift(X[5]);
                                        Resp="Desplazar 5";
                                }
				else InvalidString();
				break;
			}
			case '+':
			{
				if(stateOfStack == X[1] || stateOfStack == X[8]){ shift(X[6]);Resp="DESPLAZAR 6";}
				else if(stateOfStack == X[2]){ ReductionHandler(X[2]);Resp="REDUCIR 2";}
				else if(stateOfStack == X[3]){ ReductionHandler(X[4]);Resp="REDUCIR 4";}
				else if(stateOfStack == X[5]){ ReductionHandler(X[6]);Resp="REDUCIR 6";}
				else if(stateOfStack == X[9]){ ReductionHandler(X[1]);Resp="REDUCIR 1";}
				else if(stateOfStack == X[10]){ ReductionHandler(X[3]);Resp="REDUCIR 3";}
				else if(stateOfStack == X[11]){ ReductionHandler(X[5]);Resp="REDUCIR 5";}
				else InvalidString();
				break;
			}
			case '*':
			{
				if(stateOfStack == X[2] || stateOfStack == X[9]){ shift(X[7]);Resp="DESPLAZAR 7";}					
                                else if(stateOfStack == X[3]) {ReductionHandler(X[4]); Resp="REDUCIR 4";}
				else if(stateOfStack == X[5]) {ReductionHandler(X[6]); Resp="REDUCIR 6";}
				else if(stateOfStack == X[10]){ReductionHandler(X[3]); Resp="REDUCIR 3";}
				else if(stateOfStack == X[11]){ReductionHandler(X[5]); Resp="REDUCIR 5";}
				else InvalidString();
				break;
			}
			case '(':
			{
				if(stateOfStack == X[0] || stateOfStack == X[4] || stateOfStack == X[6] || stateOfStack == X[7])
                                    {shift(X[4]);Resp="DESPLAZAR 4";}
				else InvalidString();
				break;
			}
			case ')':
			{
				if(stateOfStack == X[8]) {shift(X[11]); Resp="DESPLAZAR 11";}
				else if(stateOfStack == X[2]) {ReductionHandler(X[2]); Resp="REDUCIR 2";}
				else if(stateOfStack == X[3]) {ReductionHandler(X[4]); Resp="REDUCIR 4";}
				else if(stateOfStack == X[5]) {ReductionHandler(X[6]); Resp="REDUCIR 6";}
				else if(stateOfStack == X[9]) {ReductionHandler(X[1]);Resp="REDUCIR 1";}
				else if(stateOfStack == X[10]) {ReductionHandler(X[3]);Resp="REDUCIR 3";}
				else if(stateOfStack == X[11]) {ReductionHandler(X[5]);Resp="REDUCIR 5";}
				else InvalidString();
				break;
			}
			case '$':
			{
				if(stateOfStack == X[1]){
			    	    	System.out.println("ACEPTADO ");
					resume = 0;
				}
				else if(stateOfStack == X[2]) {ReductionHandler(X[2]);Resp="REDUCIR 2";}
				else if(stateOfStack == X[3]) {ReductionHandler(X[4]);Resp="REDUCIR 4";}
				else if(stateOfStack == X[5]) {ReductionHandler(X[6]);Resp="REDUCIR 6";}
				else if(stateOfStack == X[9]) {ReductionHandler(X[1]);Resp="REDUCIR 1";}
				else if(stateOfStack == X[10]) {ReductionHandler(X[3]);Resp="REDUCIR 3";}
				else if(stateOfStack == X[11]) {ReductionHandler(X[5]);Resp="REDUCIR 5";}
				else InvalidString();
				break;
			}
		}
		if(resume != 0)
     		{	rpta = rpta.concat("["+stackSymbol.elementAt(0)+":"+stackState.elementAt(0)+"]");
                    //vistaInicio.txtAreaA.setText("["+stackSymbol.elementAt(0)+":"+stackState.elementAt(0)+"]");
		for(int i = 1; i < stackSymbol.size(); i++)
		{
                        rpta = rpta.concat("["+stackSymbol.elementAt(i)+":"+stackState.elementAt(i)+"]");
			//vistaInicio.txtAreaA.setText("["+stackSymbol.elementAt(i)+":"+stackState.elementAt(i)+"]");
		}
                        rpta = rpta.concat("   " + ExpressionLeft +"   "+Resp +"\n");
                        //vistaInicio.txtAreaA.setText("   " + ExpressionLeft +"   "+Resp +"\n");
                }
	  }
        vistaInicio.txtAreaA.setText(rpta);
    }
    
    public void InvalidString(){
	System.out.println("Invalido");
	System.exit(-1);
    }
    
    public void ReductionHandler(int rule){
	switch(rule)
	{
		case 1:
		{
			//reduce E -> E+T
			stackSymbol.pop();
			stackSymbol.pop();
			stackState.pop();
			stackState.pop();
			if(stackState.peek() == 0)
        		{
				stackSymbol.push("E");
				stackState.push(1); 
			}
			else if(stackState.peek() == 4)
        		{
				stackSymbol.push("E");
				stackState.push(8);
			}
			break;
		}
		case 2:
		{
			//reduce E -> T
			stackSymbol.pop(); 
			stackState.pop();
			if(stackState.peek() == 0)
        		{
				stackSymbol.push("E");
				stackState.push(1);
			}
			else if(stackState.peek() == 4)
        		{
				stackSymbol.push("E");
				stackState.push(8); 
			}
			break;
		}
		case 3:
		{
			//reduce T -> T*F
			stackSymbol.pop();
			stackSymbol.pop();
			stackState.pop();
			stackState.pop();
			if(stackState.peek() == 0 || stackState.peek() == 4)
       		{
				stackSymbol.push("T");
				stackState.push(2);
			}
			else if(stackState.peek() == 6)
        		{
				stackSymbol.push("T");
				stackState.push(9);
			}
			break;
		}
		case 4:
		{
			//reduce T -> F
			stackSymbol.pop();
			stackState.pop();
			if(stackState.peek() == 0 || stackState.peek() == 4)
        		{
				stackSymbol.push("T");
				stackState.push(2);
			}
			else if(stackState.peek() == 6)
        		{
				stackSymbol.push("T");
				stackState.push(9);
			}
			break;
		}
		case 5:
		{
			//reduce F -> (E)
			stackSymbol.pop();
			stackSymbol.pop();
			stackSymbol.pop();
			stackState.pop();
			stackState.pop();
			stackState.pop();
			if(stackState.peek() == 0 || stackState.peek() == 4 || stackState.peek() == 6)
       	 	{
				stackSymbol.push("F");
				stackState.push(3);
			}
			else if(stackState.peek() == 7)
        		{
				stackSymbol.push("F");
				stackState.push(10);
			}
			break;
		}
		case 6:
		{
			//reduce F -> n
			stackSymbol.pop();
			stackState.pop();
			if(stackState.peek() == 0 || stackState.peek() == 4 || stackState.peek() == 6)
       		{
				stackSymbol.push("F");
				stackState.push(3);
			}
			else if(stackState.peek() == 7)
      	 	{
				stackSymbol.push("F");
				stackState.push(10);
			}
			break;
		}
	}
    }
    
}
