/*****************************************************************************/
/****     Copyright (C) 2005                                              ****/
/****     Ant�nio Manuel Rodrigues Manso                                  ****/
/****     e-mail: manso@ipt.pt                                            ****/
/****     url   : http://orion.ipt.pt/~manso    manso@ipt.pt              ****/
/****     Instituto Polit�cnico de Tomar                                  ****/
/****     Escola Superior de Tecnologia de Tomar                          ****/
/*****************************************************************************/
/*  This library is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU Lesser General Public License as published
 *  by the Free Software Foundation; either version 2.1 of the License, or
 *  (at your option) any later version.
 *
 *  This library is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU Lesser General Public License for more details.
 *
 *  You should have received a copy of the GNU Lesser General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 675 Mass Ave, Cambridge, MA 02139, USA.
 */
package Portugol.Language.Make;

import Portugol.Language.Parse.Expression;
import Portugol.Language.Parse.Keyword;
import Portugol.Language.Parse.Symbol;
import Portugol.Language.Utils.LanguageException;
import java.util.Vector;

/**
 * expande um ciclo FAZ . . .ENQUANTO
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
public class ExpandFazEnquanto {
    
//------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
//------------                                                    ---------------------
//------------    I N S T R U � � O    F A Z  E N Q U A N T O     ---------------------
//------------                                                     --------------------
//-------------------------------------------------------------------------------------
//-------------------------------------------------------------------------------------
    /**
     * expand um nodo FAZ
     * @param doNode nodo de inicio
     * @param level nivel do nodo
     * @param memory vector de mem�ria
     * @throws Portugol.Language.Utils.LanguageException erro
     */
    public static void ExpandDoWhile(NodeInstruction doNode,NodeInstruction endNode,int level, Vector memory)throws LanguageException{
        String FAZ = Keyword.GetTextKey( Keyword.FAZ);
        String FAZENQUANTO = Keyword.GetTextKey( Keyword.FAZENQUANTO);
        //marcar o no como FAZ
        doNode.SetType(Keyword.FAZ);
        doNode.SetLevel(level);
        
        NodeInstruction tmp = doNode.GetNext();
        //procurar o fim do ciclo
        while(!tmp.equals(endNode)){
            tmp.SetLevel(level+1);
            tmp = tmp.GetNext();
        }
        //fim do Faz enquanto
        NodeInstruction endDoNode = tmp;
        //fazer o no do endDowhile
        String  condic = (endDoNode.GetText().trim()).substring(FAZENQUANTO.length()).trim();
        //verificar a condi��o
        
        if( Expression.TypeExpression(condic,memory)!= Symbol.LOGICO)
            throw new LanguageException(
                    doNode.GetCharNum(), doNode.GetText(),
                    "\"" + condic + "\" n�o � uma condi��o v�lida" ,
                    "verifique se a condi��o est� bem escrita");
        
        //alterar o texto para a condi��o
        endDoNode.SetText(condic);
        //tipo de no dp tipo DOWHILE
        endDoNode.SetType(Keyword.FAZENQUANTO);
        //nivel do no
        endDoNode.SetLevel(level);
        //se for verdadeiro volta para cima
        endDoNode.SetIfTrue(doNode);
        //se for falso continua
        endDoNode.SetIfFalse(endDoNode.GetNext());
        
        //ligar o FAZ � primeira instru��o fora do ciclo.
        // utilizo esta liga��o para escrever (toString)
        doNode.SetIfTrue(endDoNode.GetNext());
        doNode.SetIfFalse(endDoNode.GetNext());
        
    }
     /**
     * calcular as posi��es do fluxograma visual
     * @param begin nodo de inicio
     * @param Y posi��o Y do inicio
     * @param X posi��o X do inicio
     */
    public static void CalculatePositions( NodeInstruction begin ,double Y, double X ){
        double PY ,  PX ;
        PX = 0.5/(begin.level + 1.0);
        
        begin.SetPositionY(Y);
        begin.SetPositionX(X);
        NodeInstruction tmp = begin.GetNext();
        //fazer o  if
        PY = Y+1;
        while(tmp.GetIfTrue() != begin){
            FluxogramVisual.ProcessNodePosition(tmp, PY , X + PX);
            PY = tmp.GetPositionY() + 1;
            tmp = tmp.GetNext();
        }
        //colocar a decis�o ao mesmo n�vel do faz
        tmp.SetPositionY(PY);
        tmp.SetPositionX(X);
        
    }
    
     /**
     * texto com as intru��es do ciclo
     * @param begin inicio do ciclo
     * @return texto com as intru��es do ciclo
     */
    
    public static  String toString(NodeInstruction begin){
        StringBuffer str = new StringBuffer();
        str.append(begin.toString()+"\n");
        NodeInstruction tmp = begin.GetNext();
        while(tmp.GetIfTrue() != begin){
            str.append(Fluxogram.GetCode(tmp));
            tmp = tmp.GetNext();
        }
        return str.toString();
    }
}
