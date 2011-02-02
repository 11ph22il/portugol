/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AlgolXXI.Core.Parser;

import java.util.HashMap;
import java.util.Vector;

/**
 *
 * @author Saso
 */
public class KeywordsDatabase {

    private static String doStatement;
  /**
   * hashtable para acelarar os acesso ás keys e ID
   */
    private static HashMap<Integer,String> fastKeys;
    private static HashMap<String,Integer> fastIDs;
    
    private static Vector<AlgolXXIKeyword> allKeywords;
    private static Vector<AlgolXXIKeyword> normalKeywords;
    private static Vector<AlgolXXIKeyword> typeKeywords;
    private static String ALEATORIO,  SEN,  COS,  TAN,  CTG,  ASEN,  ACOS,  ATAN,  ACTG,  SENH,  COSH;
    private static String TANH,  CTGH,  EXP,  ABS,  RAIZ,  LOG,  LN,  INT,  FRAC,  ARRED,  POTENCIA;
    private static String COMPRIMENTO,  LETRA;
    private static String NAO,  E,  OU,  XOU;
    

    static {
        fastKeys = new HashMap<Integer,String>() ;
        fastIDs = new HashMap<String,Integer>() ;
        
        
        allKeywords = KeywordsReader.getKeywords();
        
        normalKeywords = new Vector<AlgolXXIKeyword>();
        typeKeywords = new Vector<AlgolXXIKeyword>();
        
        for (int i = 0; i < allKeywords.size(); i++) {
            int id = allKeywords.elementAt(i).getId();
            String word = allKeywords.elementAt(i).getWord();
            String cat = allKeywords.elementAt(i).getCategory();
           
            fastKeys.put(id, word.toUpperCase());
            fastIDs.put(word.toUpperCase(), id);

            if (cat.equals("TYPE")) {
                typeKeywords.addElement(allKeywords.elementAt(i));
            }

            if (!cat.equals("MATHFUNC") && !cat.equals("TEXTFUNC") && !cat.equals("LOGICFUNC")) {
                normalKeywords.addElement(allKeywords.elementAt(i));
            }

            switch (id) {
                case 18: doStatement = word; break;
                case 100: ALEATORIO = word; break;
                case 101: POTENCIA = word; break;
                case 102: SEN = word; break;
                case 103: COS = word; break;
                case 104: TAN = word; break;
                case 105: CTG = word; break;
                case 106: ASEN = word; break;
                case 107: ACOS = word; break;
                case 108: ATAN = word; break;
                case 109: ACTG = word; break;
                case 110: SENH = word; break;
                case 111: COSH = word; break;
                case 112: TANH = word; break;
                case 113: CTGH = word; break;
                case 114: EXP = word; break;
                case 115: ABS = word; break;
                case 116: RAIZ = word; break;
                case 117: LOG = word; break;
                case 118: LN = word; break;
                case 119: INT = word; break;
                case 120: FRAC = word; break;
                case 121: ARRED = word; break;
                case 150: COMPRIMENTO = word; break;
                case 151: LETRA = word; break;
                case 200: NAO = word; break;
                case 201: E = word; break;
                case 202: OU = word; break;
                case 203: XOU = word; break;
                default: break;
            }
        }
        System.out.println(fastKeys.toString());
        System.out.println(fastIDs.toString());
    }

    public static String getABS() {
        return ABS;
    }

    public static String getACOS() {
        return ACOS;
    }

    public static String getACTG() {
        return ACTG;
    }

    public static String getALEATORIO(boolean addSpaces) {
        if (addSpaces) {
            return " " + ALEATORIO + " ";
        }
        return ALEATORIO;
    }

    public static String getARRED() {
        return ARRED;
    }

    public static String getASEN() {
        return ASEN;
    }

    public static String getATAN() {
        return ATAN;
    }

    public static String getCOMPRIMENTO(boolean addSpaces) {
        if (addSpaces) {
            return " " + COMPRIMENTO + " ";
        }
        return COMPRIMENTO;
    }

    public static String getCOS() {
        return COS;
    }

    public static String getCOSH() {
        return COSH;
    }

    public static String getCTG() {
        return CTG;
    }

    public static String getCTGH() {
        return CTGH;
    }

    public static String getE() {
        return E;
    }

    public static String getEXP() {
        return EXP;
    }

    public static String getFRAC() {
        return FRAC;
    }

    public static String getINT() {
        return INT;
    }

    public static String getFastKeyword(int key) {
        return fastKeys.get(key);
    }
     public static int getFastID(String word) {
         Integer i = fastIDs.get(word.toUpperCase());
         if( i != null)
            return i.intValue();
         return Keyword.DESCONHECIDO;
    }
    
    
    public static String getKeyword(int key) {
        return allKeywords.elementAt(key).getWord();
    }

    public static Vector<AlgolXXIKeyword> getAllKeywords() {
        return allKeywords;
    }

    public static String getLETRA(boolean addSpaces) {
        if (addSpaces) {
            return " " + LETRA + " ";
        }
        return LETRA;
    }

    public static String getLN() {
        return LN;
    }

    public static String getLOG() {
        return LOG;
    }

    public static String getNAO(boolean addSpaces) {
        if (addSpaces) {
            return " " + NAO + " ";
        }
        return NAO;
    }

    public static Vector<AlgolXXIKeyword> getNormalKeywords() {
        return normalKeywords;
    }

    public static String getDoStatement() {
        return doStatement;
    }

    public static String getOU() {
        return OU;
    }

    public static String getOtherLogicFuncs() {
        return " " + E + " " + OU + " " + XOU + " ";
    }

    public static String getOtherMathFuncs() {
        return " " + SEN + " " + COS + " " + TAN + " " + CTG + " " + ASEN +
                " " + ACOS + " " + ATAN + " " + ACTG + " " + SENH + " " +
                COSH + " " + TANH + " " + CTGH + " " + EXP + " " + ABS +
                " " + RAIZ + " " + LOG + " " + LN + " " + INT + " " + FRAC +
                " " + ARRED;
    }

    public static String getPOTENCIA(boolean addSpaces) {
        if (addSpaces) {
            return " " + POTENCIA + " ";
        }
        return POTENCIA;
    }

    public static String getRAIZ() {
        return RAIZ;
    }

    public static String getSEN() {
        return SEN;
    }

    public static String getSENH() {
        return SENH;
    }

    public static String getTAN() {
        return TAN;
    }

    public static String getTANH() {
        return TANH;
    }

    public static Vector<AlgolXXIKeyword> getTypeKeywords() {
        return typeKeywords;
    }

    public static String getXOU() {
        return XOU;
    }
}
