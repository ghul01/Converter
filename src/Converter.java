
import Main.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import static javax.swing.JOptionPane.showMessageDialog;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Txt, html, doc, docx konvertálása md-be.
 *
 * @author Babinszki Attila
 */
public class Converter extends javax.swing.JFrame {

    JFileChooser filechooser = new JFileChooser();
    File input, output;

    /**
     * Creates new form Converter
     */
    public Converter() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        TextFieldInput = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        TextFieldOutput = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Choose file:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        TextFieldInput.setFocusable(false);
        getContentPane().add(TextFieldInput, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 350, -1));

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jLabel2.setText("Covert to:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, -1, -1));

        TextFieldOutput.setFocusable(false);
        getContentPane().add(TextFieldOutput, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 350, -1));

        jButton2.setText("...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));

        jButton3.setText("Convert");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
     * Input kivalasztasa
     *
     * @param evt
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            input = filechooser.getSelectedFile();
            TextFieldInput.setText(input.getName());
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    /**
     * Output fajl kivalasztasa.
     *
     * @param evt
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (filechooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            output = filechooser.getSelectedFile();
            TextFieldOutput.setText(output.getName());
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    /**
     * Konvertalas.
     *
     * @param evt
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (!"".equals(TextFieldInput.getText()) && !"".equals(TextFieldOutput.getText())) { //
            if (input.exists() && input.canRead()) {
                String filename = input.getName();
                if (filename.lastIndexOf('.') > 0) {
                    String fileextension = filename.substring(filename.lastIndexOf('.') + 1);
                    switch (fileextension) {
                        //Ide rakjártok a konvertáló classokat!
                        case "txt": {
                            try {
                                ConvertTXT.convert(input, output);
                                showMessageDialog(null, "Sikeres konvertálás!");
                            } catch (Exception ex) {
                                Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

                        break;
                        case "docx":
                        case "doc":
                            File temp = new File("temp.html");
                            ConvertDoc.convert(input, temp);
                            try {
                                ConvertHTML.convert(temp, output);
                                showMessageDialog(null, "Sikeres konvertálás!");
                            } catch (Exception ex) {
                                Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            temp.delete();
                            break;
                        case "html": {
                            try {
                                ConvertHTML.convert(input, output);
                                showMessageDialog(null, "Sikeres konvertálás!");
                                //ConvertHTML.convertFromURL(input, output);
                            } catch (Exception ex) {
                                Logger.getLogger(Converter.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        break;
                        default:
                            System.err.println("Ismeretlen fájl formátum!");
                            break;
                    }
                } else {
                    showMessageDialog(null,"Ismeretlen fájl formátum!");
                }
            }
        } else {
            showMessageDialog(null, "Nem jó bemeneti vagy a kimenti fájl!");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Converter.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Converter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TextFieldInput;
    private javax.swing.JTextField TextFieldOutput;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
