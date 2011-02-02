/*****************************************************************************/
/****     Copyright (C) 2006                                              ****/
/****     Ant�nio Manuel Rodrigues Manso                                  ****/
/****     e-mail: manso@ipt.pt                                            ****/
/****     url   : http://orion.ipt.pt/~manso    manso@ipt.pt              ****/
/****     Instituto Polit�cnico de Tomar                                  ****/
/****     Escola Superior de Tecnologia de Tomar                          ****/
/*****************************************************************************/
/*
 * Variable.java
 *
 * Created on 12 de Outubro de 2005, 16:32
 *
 */

package Portugol.Language.Parse;

import Portugol.Language.Evaluate.Calculator;
import Portugol.Language.Make.NodeInstruction;
import Portugol.Language.Utils.IteratorString;
import Portugol.Language.Utils.LanguageException;
import java.util.Vector;


/**
 * Variaveis
 * @author Ant�nio M@nuel Rodrigues M@nso<br>
 * Departamento de Engenharia Inform�tica<br>
 * Escola Superior de Tecnologia de Tomar<br>
 * Intituto Polit�cnico de Tomar<br>
 * Estrada da Serra<br>
 * 2350 - Tomar - Portugal<br>
 * <br>
 * Web site:  http://orion.ipt.pt/~manso/<br>
 * Email:     manso@ipt.pt <br>
 */
public class Variable {
    
    private static String goodChars =
            "abcdefghijklmnopqrstuvxywz"+
            "ABCDEFGHIJKLMNOPQRSTUVXYWZ"+
            "_0123456789";
    
    /**
     * verifica se o nome da variavel � aceit�vel
     * @param nameVar nome da variavel
     * @return verdadeiro se o nome for aceit�vel
     */
    public static boolean isNameAcceptable(String nameVar){
        
        String name = nameVar.trim();
        
        if(name.length()==0) return false;
        if(Character.isDigit( name.charAt(0))) return false;
        
        for(int i=1; i< name.length() ; i++)
            if(  goodChars.indexOf(name.charAt(i)) == -1)
                return false;
        
        if( Keyword.IsKeyword(nameVar) || Calculator.IsCalculus(nameVar))
            return false;
        
        
        return true;
    }
    
    /**
     * calcula o erro do nome da variavel
     * @param nameVar nome da variavel
     * @return causa do erro
     */
    public static String getErrorName(String nameVar){
        String name = nameVar.trim();
        if(name.length()==0)
            return " O nome n�o pode ser vazio ";
        if(Character.isDigit( name.charAt(0)))
            return " O nome da variavel n�o pode come�ar por um digito";
        if (Keyword.IsKeyword(nameVar))
            return name + " � uma palavra reservada ";
        if (Calculator.IsCalculus(nameVar))
            return name + " � um elemento de C�lculo";
        
        if(name.indexOf("=") != -1)
            return "o sinal \"=\" deve ser substituido por \"<-\"  ";
        
        for(int i=1; i< name.length() ; i++)
            if( goodChars.indexOf(""+name.charAt(i)) == -1)
                return  name + " contem  o caracter \"" + name.charAt(i) + "\" que n�o � valido";
        
        return "SEM ERRO NO NOME";
    }
    
    
    /**
     * devolve a variavel em mem�ria
     * dado o seu nome
     * @return Variavel
     * @param varName nome da variavel
     * @param memory vector de mem�ria
     */
    public static Symbol getVariable(String name, Vector memory){
       // if(!Variable.isNameAcceptable(name))
       //     return null;
        String varName = name.trim();
        for( int index = memory.size()-1 ; index >=0 ; index--){
            Symbol v = (Symbol) memory.get(index);
            if (v.nameEqual(varName)){
                return v;
            }
        }
        return null;
    }
    
    
    public static void defineVAR(NodeInstruction node, Vector memory)throws LanguageException{
        if( SymbolArray.isArray( node.GetText()))
            Variable.defineArray(node,memory);
        else
            Variable.defineSimples(node,memory);
    }
    
    /**
     * define uma variavel e mete-a na mem�ria
     * @param node n� com a defini��o da variavel
     * @param memory mem�ria
     * @throws Portugol.Language.Utils.LanguageException erro
     */
    public static void defineSimples(NodeInstruction node, Vector memory)throws LanguageException{
        // VARIAVEL TIPO VAR <- VALOR
        IteratorString tok = new IteratorString(node.GetText());
        String modif = tok.current(); tok.next();
        String type = tok.current() ; tok.next();
        String name = tok.current() ; tok.next();
        String atribui = tok.current() ; tok.next();
        String value = tok.getUnprocessedString();
        try {
            value = Expression.Evaluate(value,memory);
        } catch( Exception e){
            throw new  LanguageException(
                    node.GetCharNum(), node.GetText() ,
                    e.toString(),
                    "Verifique a express�o <" +  value + ">");
        }
        Symbol v = new Symbol(modif,type, name,value, node.GetLevel());
        memory.add(v);
    }
    
    /**
     * define uma variavel e mete-a na mem�ria
     * @param node n� com a defini��o da variavel
     * @param memory mem�ria
     * @throws Portugol.Language.Utils.LanguageException erro
     */
    public static void defineArray(NodeInstruction node, Vector memory)throws LanguageException{
        // VARIAVEL TIPO VAR <- VALOR
        IteratorString tok = new IteratorString(node.GetText());
        String modif = tok.current(); tok.next();
        String type = tok.current() ; tok.next();
        String name = tok.current() ; tok.next();
        
        String rest = tok.getUnprocessedString();
        int  atr = rest.indexOf(Keyword.ATRIBUI);
        String indexes = rest.substring(0,atr).trim();
        String value = rest.substring(atr + Keyword.ATRIBUI.length()).trim();
        
        SymbolArray v = new SymbolArray(modif,type, name, indexes,value, node.GetLevel(),memory);
        memory.add(v);
    }
    
//------------------------------------------------------------------------------
    
    
    /**
     * altera o valor da variavel
     * @param varName nome da variavel
     * @param newValue novo valor
     * @param memory mem�ria
     * @throws Portugol.Language.Utils.LanguageException erro
     */
    public static void replaceVariableValue(String varName, String newValue, Vector memory)throws LanguageException{
        Symbol var = Variable.getVariable(varName.trim(), memory);
        if( var == null)
            throw new LanguageException(0, varName, " a variavel \""+ varName + "\" na� est� definida",
                    " verifique o nome da vari�vel");
        if(var instanceof SymbolArray){
            ((SymbolArray) var).SetIndex(varName,memory);
        }
        
        var.setValue(newValue);
    }
    
    
}
