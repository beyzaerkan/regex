
/**
*
* @author	Beyza Erkan beyza.erkan@ogr.sakarya.edu.tr
* @since	20.03.2022  
* <p>
* .java uzantili dosya okuma isleminin, dosyadaki operatorler ve operandlarin sayisinin hesaplandigi ana sinif. 
* </p>
*/

package B201210038;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;

public class Program {
  public static void main(String[] args) {
    try {
      String line = "";
      String key = "";

      // okunacak dosyayý komut satirindan alir.
      FileReader fReader = new FileReader(args[0]);
      BufferedReader bReader = new BufferedReader(fReader);

      // dosyayi satir satir okur ve string degiskenin icine atar. 
      // Bu sayede blok halindeki yorum satirlarini silmek daha kolay hale gelecektir.
      while ((line = bReader.readLine()) != null) {

        key += line + "\n";
      }

      // yorum satirlarini boslukla degistirir
      key = key.replaceAll("(?s)\\/\\*.*?\\*\\/", "");
      key = key.replaceAll("//.*(?=\\n)", "");

      // regexlerin tanimli oldugu siniftan obje olusturur.
      Lexical operators = new Lexical();

      Matcher relationalMatcher = operators.relational.matcher(key);
      Matcher logicalMatcher = operators.logical.matcher(key);
      Matcher arithmeticMatcher = operators.arithmetic.matcher(key);
      Matcher dualMatcher = operators.dual.matcher(key);
      Matcher singleMatcher = operators.single.matcher(key);
      Matcher singleOperandMatcher = operators.singleOperands.matcher(key);
      Matcher dualLogicalOperandMatcher = operators.dualLogicalOperands.matcher(key);

      // okunan dosyada eslesen regexi buldugunda ona ait sayaci bir artirir.

      while (relationalMatcher.find()) {
        operators.relationalCounter++;
      }
      while (logicalMatcher.find()) {
        operators.logicalCounter++;
      }
      while (arithmeticMatcher.find()) {
        operators.arithmeticCounter++;
      }
      while (dualMatcher.find()) {
        operators.dualCounter++;
      }
      while (singleMatcher.find()) {
        operators.singleCounter++;
      }
      while (singleOperandMatcher.find()) {
        operators.singleOperandCounter++;
      }
      while (dualLogicalOperandMatcher.find()) {
        operators.dualLogicalOperandCounter++;
      }

      //operatorlerin ve operandlarin sayilarini konsola yazdirir.

      System.out.println("Operator bilgisi:");
      System.out.println("	Tekli Operator Bilgisi: " + operators.singleCounter);
      System.out.println("	Ikili Operator Bilgisi: " + operators.dualCounter);
      System.out.println("	Sayisal Operator Bilgisi: " + operators.arithmeticCounter);
      System.out.println("	Iliskisel Operator Bilgisi: " + operators.relationalCounter);
      System.out.println("	Mantiksal Operator Bilgisi: " + operators.logicalCounter);
      System.out.println("Operand bilgisi:");
      
      // iliskisel operatorlerin hepsi iki operand icerir. 
      // ikili operatorlerin hepsi iki operand icerir
      // bunlarý icine almayan ve iki operand iceren && || operatorleridir, bunlar icin dualLogicalOperands adli pattern tanimlidir.
      // tek operand icerenler ++ -- ! operatorleridir. Bunlar icin de singleOperands adli pattern tanimlidir.
      // ikili operand icerenleri ikiyle carpip tek operand icerenlerle topladigimizda operand sayisini buluruz.

      System.out.println("	Toplam Operand Sayisi: "
          + (operators.singleOperandCounter + operators.dualLogicalOperandCounter*2 + operators.dualCounter*2 + operators.relationalCounter*2));

    } catch (FileNotFoundException e) {
      System.out.println("-> Cannot find the file you are looking for \n-> Message: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("-> Cannot read data on the file you are looking for \n-> Message: " + e.getMessage());
    } finally {
      System.out.println();
    }
  }
}
