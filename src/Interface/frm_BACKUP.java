package Interface;

import DAO.Conexao;
import Extras.StreamGobbler;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class frm_BACKUP extends javax.swing.JFrame {

    private final Icon erro = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/erro.png")));
    private final Icon sucesso = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/sucesso.png")));

    public frm_BACKUP() {
        initComponents();

        //SETA O ICONE DO SISTEMA
        URL url = this.getClass().getResource("/Imagens/icone.png");
        Image logo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(logo);
        this.setFocusableWindowState(true);
  
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JFC_Salvar_Backup = new javax.swing.JFileChooser();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnFAZER_BACKUP = new javax.swing.JButton();
        btnRESTAURAR_BACKUP = new javax.swing.JButton();
        btnVOLTAR = new javax.swing.JButton();

        setTitle("Gerenciar Backup");
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white), "Backup", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        btnFAZER_BACKUP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fazerBackup.png"))); // NOI18N
        btnFAZER_BACKUP.setToolTipText("<html><h3>Realizar Backup</h3></html>");
        btnFAZER_BACKUP.setBorderPainted(false);
        btnFAZER_BACKUP.setContentAreaFilled(false);
        btnFAZER_BACKUP.setFocusable(false);
        btnFAZER_BACKUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFAZER_BACKUPActionPerformed(evt);
            }
        });

        btnRESTAURAR_BACKUP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/restaurarBackup.png"))); // NOI18N
        btnRESTAURAR_BACKUP.setToolTipText("<html><h3>Restaurar Backup</h3></html>");
        btnRESTAURAR_BACKUP.setBorderPainted(false);
        btnRESTAURAR_BACKUP.setContentAreaFilled(false);
        btnRESTAURAR_BACKUP.setFocusable(false);
        btnRESTAURAR_BACKUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRESTAURAR_BACKUPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnFAZER_BACKUP, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnRESTAURAR_BACKUP, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnFAZER_BACKUP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRESTAURAR_BACKUP, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
        );

        btnVOLTAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/voltarGenero.png"))); // NOI18N
        btnVOLTAR.setToolTipText("<html><h3>Retornar à Tela Principal</h3></html>");
        btnVOLTAR.setBorderPainted(false);
        btnVOLTAR.setContentAreaFilled(false);
        btnVOLTAR.setFocusable(false);
        btnVOLTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVOLTARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVOLTAR)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVOLTAR)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVOLTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVOLTARActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVOLTARActionPerformed

    private void btnFAZER_BACKUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFAZER_BACKUPActionPerformed
        try {
            String arquivo = null;

            JFC_Salvar_Backup.setVisible(true);
            

            int result = JFC_Salvar_Backup.showSaveDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                arquivo = JFC_Salvar_Backup.getSelectedFile().toString().concat(".sql");

                File file = new File(arquivo);

                if (file.exists()) {
                    Object[] options = {"Sim", "Não"};
                    int opcao = JOptionPane.showOptionDialog(null, "Este arquivo já existe. Deseja sobreescrever este arquivo?", "Atenção",
                            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                    if (opcao == JOptionPane.YES_OPTION) {
                        Runtime bck = Runtime.getRuntime();
                        bck.exec("C:\\Program Files\\MySQL\\MySQL Workbench 6.3 CE\\mysqldump.exe -v -v -v --host=localhost --user=root --password=_c@n3t@321_ --port=3306 --protocol=tcp --force --allow-keywords --compress  --add-drop-table --default-character-set=latin1 --hex-blob  --result-file=" + arquivo + " --databases btk");
                        JOptionPane.showMessageDialog(null, "<html><h3>Backup realizado com sucesso.</h3></html>", "BTK Informa", JOptionPane.INFORMATION_MESSAGE, sucesso);
                    } else {
                        btnFAZER_BACKUPActionPerformed(evt);
                    }
                } else {

                    Runtime bck = Runtime.getRuntime();
                    bck.exec("C:\\Program Files\\MySQL\\MySQL Workbench 6.3 CE\\mysqldump.exe -v -v -v --host=localhost --user=root --password=_c@n3t@321_ --port=3306 --protocol=tcp --force --allow-keywords --compress  --add-drop-table --default-character-set=latin1 --hex-blob  --result-file=" + arquivo + " --databases btk");
                    JOptionPane.showMessageDialog(null, "<html><h3>Backup realizado com sucesso.</h3></html>", "BTK Informa", JOptionPane.INFORMATION_MESSAGE, sucesso);
                }

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", 2);
        }


    }//GEN-LAST:event_btnFAZER_BACKUPActionPerformed

    private void btnRESTAURAR_BACKUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRESTAURAR_BACKUPActionPerformed
        Process proc;
        Connection con = Conexao.abrirConexao();
        try {
            JFC_Salvar_Backup.setVisible(true);
            String bd = "btk";
            int result = JFC_Salvar_Backup.showOpenDialog(null);

            if (result == JFileChooser.OPEN_DIALOG) {

                File bkp;
                bkp = JFC_Salvar_Backup.getSelectedFile();
                String arq = bkp.getPath();
                System.out.println("bd " + bd);
                System.out.println("arq " + arq);
               
                String[] cmd = new String[6];
                cmd[0] = "cmd.exe";
                cmd[1] = "CD\\";
                cmd[2] = "CD Program Files";
                cmd[3] = "CD MySQL";
                cmd[4] = "CD MySQL Workbench 6.3 CE";
                cmd[5] = "start mysql.exe -u root -p _c@n3t@321_ -h localhost btk <C:\\Users\\lgust\\OneDrive\\Documents\\teste1.sql";

                Runtime rt = Runtime.getRuntime();
                System.out.println("Execing " + cmd[0] + " " + cmd[1]);
                proc = rt.exec(cmd);

                // any error message?
                StreamGobbler errorGobbler = new StreamGobbler(proc.getErrorStream(), "ERROR");

                // any output?
                StreamGobbler outputGobbler = new StreamGobbler(proc.getInputStream(), "OUTPUT");

                // kick them off
                errorGobbler.run();
                outputGobbler.run();

                // any error???
                int exitVal = proc.waitFor();

                if (exitVal == 0) {
                    JOptionPane.showMessageDialog(null, "<html><h3>Backup Restaurado com sucesso !</h3></html>", "Sucesso", JOptionPane.INFORMATION_MESSAGE, sucesso);
                } else {
                    JOptionPane.showMessageDialog(null, "<html><h3>Falha ao restaurar backup. <br> Verifique as configurações ou entre em contato com o suporte !</h3></html>", "Erro", JOptionPane.INFORMATION_MESSAGE, erro);
                }

                Conexao.fecharConexao(con);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Erro!", 2);
        }


    }//GEN-LAST:event_btnRESTAURAR_BACKUPActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_BACKUP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser JFC_Salvar_Backup;
    private javax.swing.JButton btnFAZER_BACKUP;
    private javax.swing.JButton btnRESTAURAR_BACKUP;
    private javax.swing.JButton btnVOLTAR;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
