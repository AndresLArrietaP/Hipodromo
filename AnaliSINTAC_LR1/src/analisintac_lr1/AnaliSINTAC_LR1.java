
package analisintac_lr1;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.*;
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
  static LR1FR frLR1;
	
  // Setting the String to current to the next token also
  // evaluates if is an integer
  
    
    
    
    
    public static void main(String[] args) {
      //frame
        LR1FR vistaInicio = new LR1FR();
        ControLR1FR controlInicio = new ControLR1FR(vistaInicio);
        controlInicio.iniciar();
      // separate the string in tokens
	//String aString = " khan23 + maricon24 * ( max1 + no2 + reniegues3 )";
      // tokenizing the input string
	//sTokenizer = new StringTokenizer(aString + " $"," ");	

        //System.out.println(str.length());
        System.out.println("End Of the Program!");
  }
    
    
}
