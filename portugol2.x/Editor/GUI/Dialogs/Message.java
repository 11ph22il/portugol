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
/*
 * Message.java
 *
 * Created on 22 de Outubro de 2005, 17:35
 *
 */

package Editor.GUI.Dialogs;

import Portugol.Language.Utils.LanguageException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;



/**
 *
 * @author Ant�nio Manuel Rodrigues MAnso
 */
public class Message {
    private static final String title =  "PORTUGOL" ; //mainEditor.TITLE+" Mensagem";
    private static ImageIcon icoBug = new javax.swing.ImageIcon("./Editor/icons/bug32.png");    
    
    public static  void Error(String msg){
       JOptionPane.showMessageDialog(null, msg, title, JOptionPane.ERROR_MESSAGE); 
    }
    
    public static void Information(String msg){
       JOptionPane.showMessageDialog(null, msg, title,JOptionPane.INFORMATION_MESSAGE); 
    }
    
    public static void Warning(String msg){
       JOptionPane.showMessageDialog(null, msg, title,JOptionPane.WARNING_MESSAGE); 
    }
    
    public static int Confirm(String msg){
        return JOptionPane.showConfirmDialog(null,msg, title,JOptionPane.YES_NO_CANCEL_OPTION);
    }
    
    public static  void CompileError(LanguageException e){
        String 
              str = "INSTRU��O:\n" + e.codeLine  + "\n";
              str +="ERRO:\n" + e.error  + "\n";
              str +="SOLU��O:\n" + e.solution +"\n";
       
       JOptionPane.showMessageDialog(null, str, title, JOptionPane.ERROR_MESSAGE); 
    }
    public static  void ExecutionError(String msg,LanguageException e){
        String 
              str = msg + "\n\n";
              str += "INSTRU��O:\n" + e.codeLine  + "\n";
              str +="ERRO:\n" + e.error  + "\n";
              str +="SOLU��O:\n" + e.solution +"\n";
       
       JOptionPane.showMessageDialog(null, str, title, JOptionPane.ERROR_MESSAGE); 
    }
    
}
