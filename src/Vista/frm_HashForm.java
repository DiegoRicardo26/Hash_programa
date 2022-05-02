/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.util.StringTokenizer;
import javax.swing.event.DocumentEvent;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.util.HashMap;

/**
 *
 * @author joseg
 */
public class frm_HashForm extends javax.swing.JFrame {

    /**
     * Creates new form frm_HashForm
     */
    
    HashMap<Integer, String> Hash;
    public frm_HashForm() {
        initComponents();
        Hash = new HashMap();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txt_sintaxis = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        btn_procesar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txt_sintaxis.setColumns(20);
        txt_sintaxis.setRows(5);
        jScrollPane1.setViewportView(txt_sintaxis);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Ingrese el texto en sintaxis C++");
        jLabel1.setToolTipText("");

        btn_procesar.setText("Procesar");
        btn_procesar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_procesarActionPerformed(evt);
            }
        });

        btn_limpiar.setText("Limpiar");

        btn_buscar.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_procesar, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btn_buscar)
                        .addGap(32, 32, 32)
                        .addComponent(btn_procesar)
                        .addGap(40, 40, 40)
                        .addComponent(btn_limpiar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_procesarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_procesarActionPerformed
        // TODO add your handling code here:
        Funcion_Hash(txt_sintaxis.getText());
        
    }//GEN-LAST:event_btn_procesarActionPerformed
    
    
    public void Funcion_Hash(String texto)
    {
        //intente separar por ; pero en donde separo por lineas, hacerlo pero en donde ya tengo las lineas separadas.
        int CantidadLineas = 0, contador = 0, index = 0, codigoHash=0;
        String[] lineas = txt_sintaxis.getText().split("\\r?\\n");
        String palabras[] = new String[100];
        String secundario[]  = new String [100];
        CantidadLineas = lineas.length;
        for(int i =0; i<CantidadLineas;i++)
        {
            StringTokenizer tokens = new StringTokenizer(lineas[i]);
            while(tokens.hasMoreTokens())
            {
                palabras[i]=tokens.nextToken();
                StringTokenizer token2 = new StringTokenizer(palabras[i], ";", true);
                while(token2.hasMoreTokens())
                {
                    secundario[i]=token2.nextToken();
                        if(secundario[i].equals(";"))
                        {
                            index = lineas[i].length()-1;
                            String fila = String.valueOf(i);
                            String columna = String.valueOf(index);
                            String codigo = fila+columna;
                            codigoHash = Integer.parseInt(codigo);
                            System.out.println(" la posicion es: "+i+", " + index+ " para la palabra: " + secundario[i]);
                        }
                        else
                        {
                            index = lineas[i].indexOf(palabras[i]);
                            System.out.println(" la posicion es: "+i+", " + index+ " para la palabra: " + secundario[i]);
                            String fila = String.valueOf(i);
                            String columna = String.valueOf(index);
                            String codigo = fila+columna;
                            codigoHash = Integer.parseInt(codigo);
                        }
                        Hash.put(codigoHash, palabras[i]);
                        
                }
            }
        }
        System.out.println(Hash);
    }
    
    
    
    
    
    
    
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_HashForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_HashForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_HashForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_HashForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_HashForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_procesar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea txt_sintaxis;
    // End of variables declaration//GEN-END:variables
}
