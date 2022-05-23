/**
*
* @author	Beyza Erkan beyza.erkan@ogr.sakarya.edu.tr
* @since	20.03.2022  
* <p>
*   regexlerin ve sayaclarinin tanýmlandigi sinif
* </p>
*/

package B201210038;

import java.util.regex.Pattern;

public class Lexical {
  public Pattern relational = Pattern.compile("[<>!=]={1,2}|<|>");  //iliskisel operatorleri ifade eden regex
  public Pattern logical = Pattern.compile("([&][&])|([|][|])|(!)(?!=)"); //mantiksal operatorleri ifade eden regex
  public Pattern arithmetic = Pattern.compile(  //sayisal operatorleri ifade eden regex
      "\\++(?!=)|-+(?!=)|[+-/\\\\*%&\\\\|\\\\^]={1,2}|\\*|\\/|%|\\^|(?<!&)&(?!&)|(?<!\\|)\\|(?!\\|)|(?<![><=!])=(?!=)");
  public Pattern dual = Pattern.compile(  //ikili operatorleri ifade eden regex
      "(?<!\\+)\\+(?!\\+|=)|(?<!-)-(?!-|=)|[+-/\\*%&\\|\\^]={1,2}|\\*|\\/|%|\\^|(?<!&)&(?!&)|(?<!\\|)\\|(?!\\|)|(?<![><=!])=(?!=)");
  public Pattern single = Pattern.compile("[\\+-]{2}");  //tekli operatorleri ifade eden regex
  public Pattern singleOperands = Pattern.compile("[\\+-]{2}|!(?!=)");  // ++ -- ! tek operand iceren operatorler
  public Pattern dualLogicalOperands = Pattern.compile("[&\\|]{2}");  // && || operatorleri

  // sayaclar
  public int relationalCounter = 0;
  public int logicalCounter = 0;
  public int arithmeticCounter = 0;
  public int dualCounter = 0;
  public int singleCounter = 0;
  public int singleOperandCounter = 0;
  public int dualLogicalOperandCounter = 0;
}
