/*
 * AboutThis.java
 *
 * Created on 2 de Novembro de 2005, 3:10
 */

package Editor.GUI.About;

import Editor.GUI.Dialogs.Message;



/**
 *
 * @author  Ant�nio Manuel Rodrigues MAnso
 */
public class AboutThis extends javax.swing.JFrame {
    
    /** Creates new form AboutThis */
    public AboutThis() {
        initComponents();
        title.setText("");// mainEditor.TITLE + mainEditor.DATE);
        text.setCaretPosition(0);
        this.setBounds(200, 100, 600, 320);
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jToggleButton1 = new javax.swing.JToggleButton();
        title = new javax.swing.JLabel();
        btOK = new javax.swing.JToggleButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        text = new javax.swing.JTextPane();

        getContentPane().setLayout(null);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acerca de . . .");
        setResizable(false);
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Editor/GUI/About/foto.png")));
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        getContentPane().add(jToggleButton1);
        jToggleButton1.setBounds(10, 10, 140, 190);

        title.setFont(new java.awt.Font("Tahoma", 1, 18));
        title.setText("Portugol ver 0.0");
        getContentPane().add(title);
        title.setBounds(160, 0, 370, 30);

        btOK.setText("OK");
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        getContentPane().add(btOK);
        btOK.setBounds(10, 210, 140, 60);

        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createEtchedBorder());
        text.setEditable(false);
        text.setText("(C) Ant\u00f3nio Manso / Novembro 2005\nhttp://orion.ipt.pt/~manso/\nmanso@ipt.pt\n\nPORTUGOL \u00e9 um simulador de linguagem algoritmica\ndesenvolvido para  apoio \u00e0s aulas de Introdu\u00e7\u00e3o \u00e0\n Programa\u00e7\u00e3o dos Cursos de Engenharia da Escola\n Superior de  Tecnologia  de  Tomar  do   Instituto \nPolit\u00e9cnico de Tomar.\n\n***************************************************\n  This library is free software; you can redistribute it and/or\n   modify  it under the terms of the GNU Lesser General\n   Public License as published  by the Free Software \n   Foundation;   either version 2.1 of the License, or\n  (at your option)   any later version.\n\n  This library is distributed in the hope that it will be useful,\n  but WITHOUT ANY WARRANTY; without even the implied\n  warranty of  MERCHANTABILITY or FITNESS FOR A \n  PARTICULAR PURPOSE.  See the  GNU Lesser General \n  Public License for more details.\n\n  You should have received a copy of the GNU Lesser \n  General Public License  along with this program; if not,\n   write to the Free Software  Foundation, Inc., \n  675 Mass Ave, Cambridge, MA 02139, USA.\n***************************************************");
        jScrollPane1.setViewportView(text);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(160, 30, 360, 240);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        Message.Information("obrigado por utilizar este programa");
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
     this.dispose();
    }//GEN-LAST:event_btOKActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AboutThis().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btOK;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextPane text;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
    
}