
package analisintac_lr1;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.IOException;
/**
 *
 * @author acer
 */
/*Gramática
E -> E+T|T
T ->T*F|F
F ->(E) | id
*/
public class AnaliSINTAC_LR1 {
    static StringTokenizer sTokenizer;
  static String ExpressionLeft;
  static String currentString;
  static Stack<String> stackSymbol = new Stack<String>();
  static Stack<Integer> stackState = new Stack<Integer>();
	
  // Setting the String to current to the next token also
  // evaluates if is an integer
  static void next()
  {
	currentString = sTokenizer.nextToken().intern();
	if(currentString == "+"){}
      else if(currentString == "*"){}
	else if(currentString == "("){}
	else if(currentString == ")"){}
	else if(currentString == "$"){}
	else if(Integer.parseInt(currentString) < 32767)
			currentString = "n";
  }
	
  static String input()
  {	
	ExpressionLeft = "";
	while(currentString != "$")
	{		
	  ExpressionLeft += currentString;
	  next();
	}
	ExpressionLeft += "$";
	return ExpressionLeft;
  }
	
  // shifts current state and removes the front Of the expression
  static void shift(int nextState)
  {
    stackSymbol.push("" + ExpressionLeft.charAt(0));
    stackState.push(nextState);
    ExpressionLeft = ExpressionLeft.substring(1); 
  }
	
  // LR(1) parsing begins
  static void LRParser()
  {
	stackSymbol.push("-");
	stackState.push(0);
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
				if(stateOfStack == X[8]) {shift(X[11]); Resp="REDUCIR 4";}
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
     		{												
                    System.out.print("["+stackSymbol.elementAt(0)+":"+stackState.elementAt(0)+"]");
		for(int i = 1; i < stackSymbol.size(); i++)
		{
			System.out.print("["+stackSymbol.elementAt(i)+":"+stackState.elementAt(i)+"]");
		}
                
                        System.out.print("   " + ExpressionLeft +"   "+Resp +"\n");
                }
	  }
	}
	
  static void InvalidString()
  {
	System.out.println("Sorry, the expression you entered is NOT VALID! =(");
	System.exit(-1);
  }

 // Function that handle reductions
 static void ReductionHandler(int rule)
 {
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
    
    
    
    
    public static void main(String[] args) throws IOException{
        // input string
	
      // separate the string in tokens
	String aString = " 23 + 24";
      // tokenizing the input string
	sTokenizer = new StringTokenizer(aString + " $");	
  	next();
  	input();
  	LRParser();
        //System.out.println(str.length());
     System.out.println("End Of the Program!");
  }
    
    
}
