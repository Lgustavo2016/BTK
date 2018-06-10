package Interface;

import Beans.EmprestimoBean;
import Beans.ObraBean;
import DAO.Conexao;
import DAO.EmprestimoDAO;
import DAO.ItensEmprestimoDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frm_DEVOLUCAO extends javax.swing.JFrame {

    private final Icon atencao = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/atencao.png")));
    private final Icon questao = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/questao.png")));

    public frm_DEVOLUCAO() {
        initComponents();
        tblEMPRESTIMOS.setFillsViewportHeight(true);
        tblITENS.setFillsViewportHeight(true);
        preencherEmprestimos();
        dataDEVOLUCAO.setValue(null);
        //SETA O ICONE DO SISTEMA
        URL url = this.getClass().getResource("/Imagens/icone.png");
        Image logo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(logo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEMPRESTIMOS = new javax.swing.JTable();
        txtBUSCAR = new javax.swing.JTextField();
        txtDATAEMP = new javax.swing.JTextField();
        btnBUSCAR = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        dataDEVOLUCAO = new net.sf.nachocalendar.components.DateField();
        jPanel6 = new javax.swing.JPanel();
        btnDEVOLVER = new javax.swing.JButton();
        btnVOLTAR = new javax.swing.JButton();
        btnCANCELAR = new javax.swing.JButton();
        btnRENOVAR = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblITENS = new javax.swing.JTable();

        setTitle("Devolução");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1018, 744));

        jPanel5.setBackground(new java.awt.Color(153, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.white));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Data de Empréstimo:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Data de Devolução:");

        jScrollPane1.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        tblEMPRESTIMOS.setBackground(new java.awt.Color(204, 255, 204));
        tblEMPRESTIMOS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        tblEMPRESTIMOS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblEMPRESTIMOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html><h4>ID</h4></html>", "<html><h4>D. Empréstimo</h4></html>", "<html><h4>D. Devolução(Prevista)</h4></html>", "<html><h4>Usuário Responsável</h4></html>", "<html><h4>Locatário</h4></html>", "<html><h4>Status</h4></html>"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEMPRESTIMOS.setToolTipText("<html><h3>Empréstimos em Aberto</h3></html>");
        tblEMPRESTIMOS.setFocusable(false);
        tblEMPRESTIMOS.setGridColor(new java.awt.Color(255, 255, 255));
        tblEMPRESTIMOS.setSelectionBackground(new java.awt.Color(153, 255, 204));
        tblEMPRESTIMOS.getTableHeader().setReorderingAllowed(false);
        tblEMPRESTIMOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEMPRESTIMOSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEMPRESTIMOS);

        txtBUSCAR.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtBUSCAR.setToolTipText("<html><h3>Digite o Nome do Locatário</h3></html>");
        txtBUSCAR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtBUSCAR.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        txtBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBUSCARActionPerformed(evt);
            }
        });

        txtDATAEMP.setEditable(false);
        txtDATAEMP.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDATAEMP.setToolTipText("<html><h3>Data de Empréstimo da Obra</h3></html>");
        txtDATAEMP.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtDATAEMP.setDisabledTextColor(new java.awt.Color(204, 204, 204));

        btnBUSCAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscar.png"))); // NOI18N
        btnBUSCAR.setToolTipText("<html><h3>Buscar Empréstimos em Aberto</h3></html>");
        btnBUSCAR.setBorderPainted(false);
        btnBUSCAR.setContentAreaFilled(false);
        btnBUSCAR.setFocusable(false);
        btnBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBUSCARActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Digite o Nome do Locatário:");

        dataDEVOLUCAO.setBackground(new java.awt.Color(255, 255, 255));
        dataDEVOLUCAO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        dataDEVOLUCAO.setToolTipText("<html><h3>Data de Devolução</h3></html>");
        dataDEVOLUCAO.setEnabled(false);
        dataDEVOLUCAO.setFocusable(false);
        dataDEVOLUCAO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtBUSCAR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtDATAEMP, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dataDEVOLUCAO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(114, 114, 114))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {dataDEVOLUCAO, txtDATAEMP});

        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(2, 2, 2)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDATAEMP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dataDEVOLUCAO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnBUSCAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(262, 262, 262))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtBUSCAR)
                        .addGap(262, 262, 262))))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnBUSCAR, txtBUSCAR});

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {dataDEVOLUCAO, txtDATAEMP});

        jPanel6.setBackground(new java.awt.Color(153, 255, 204));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        btnDEVOLVER.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnDEVOLVER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/devolucao_1.png"))); // NOI18N
        btnDEVOLVER.setToolTipText("<html><h3>Realizar Devolução</h3><html>");
        btnDEVOLVER.setBorderPainted(false);
        btnDEVOLVER.setContentAreaFilled(false);
        btnDEVOLVER.setEnabled(false);
        btnDEVOLVER.setFocusable(false);
        btnDEVOLVER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDEVOLVERActionPerformed(evt);
            }
        });

        btnVOLTAR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnVOLTAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/voltar.png"))); // NOI18N
        btnVOLTAR.setToolTipText("<html><h3>Retornar à Tela Principal</h3></html>");
        btnVOLTAR.setBorderPainted(false);
        btnVOLTAR.setContentAreaFilled(false);
        btnVOLTAR.setFocusable(false);
        btnVOLTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVOLTARActionPerformed(evt);
            }
        });

        btnCANCELAR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCANCELAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fechar.png"))); // NOI18N
        btnCANCELAR.setToolTipText("<html><h3>Cancelar Devolução</h3></html>");
        btnCANCELAR.setBorderPainted(false);
        btnCANCELAR.setContentAreaFilled(false);
        btnCANCELAR.setEnabled(false);
        btnCANCELAR.setFocusable(false);
        btnCANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCANCELARActionPerformed(evt);
            }
        });

        btnRENOVAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/renovar.png"))); // NOI18N
        btnRENOVAR.setToolTipText("<html><h3>Renovar Empréstimo</h3></html>");
        btnRENOVAR.setBorderPainted(false);
        btnRENOVAR.setContentAreaFilled(false);
        btnRENOVAR.setEnabled(false);
        btnRENOVAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRENOVARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDEVOLVER, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRENOVAR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVOLTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnDEVOLVER, btnRENOVAR});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnDEVOLVER, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVOLTAR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCANCELAR, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRENOVAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(153, 255, 204));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white), "Itens do Empréstimo", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jScrollPane3.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        tblITENS.setBackground(new java.awt.Color(204, 255, 204));
        tblITENS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblITENS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html><h4>Nº de Tombo</h4></html>", "<html><h4>Título</h4></html>", "<html><h4>Autor</h4></html>", "<html><h4>Editora</h4></html>", "<html><h4>Gênero</h4></html>", "<html><h4>Edição</h4></html>", "<html><h4>Ano</h4></html>", "<html><h4>Qtd.</h4></html>", "<html><h4>Nota</h4></html>"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblITENS.setToolTipText("<html><h3>Itens do Empréstimo</h3></html>");
        tblITENS.setFocusable(false);
        tblITENS.setGridColor(new java.awt.Color(255, 255, 255));
        tblITENS.setSelectionBackground(new java.awt.Color(153, 255, 204));
        tblITENS.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tblITENS);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDEVOLVERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDEVOLVERActionPerformed
        if (dataDEVOLUCAO.getValue() == null) {

            JOptionPane.showMessageDialog(null, "Selecione a Data de Devolução!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);
        } else {
            devolver();
        }
    }//GEN-LAST:event_btnDEVOLVERActionPerformed

    private void btnVOLTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVOLTARActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVOLTARActionPerformed

    private void btnCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCANCELARActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnCANCELARActionPerformed

    private void tblEMPRESTIMOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEMPRESTIMOSMouseClicked
        if (tblEMPRESTIMOS.getRowCount() == 0) {

            JOptionPane.showMessageDialog(null, "Não há Empréstimos em Aberto!", "BTK Informa", JOptionPane.WARNING_MESSAGE, atencao);
        } else {
            setarData();
            dataDEVOLUCAO.setEnabled(true);
            preencherItens();
            habilitarCampos();
        }
    }//GEN-LAST:event_tblEMPRESTIMOSMouseClicked

    private void btnBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBUSCARActionPerformed
        preencherEmprestimos();
    }//GEN-LAST:event_btnBUSCARActionPerformed

    private void btnRENOVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRENOVARActionPerformed
        preencherRenovacao();
    }//GEN-LAST:event_btnRENOVARActionPerformed

    private void txtBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBUSCARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBUSCARActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_DEVOLUCAO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBUSCAR;
    private javax.swing.JButton btnCANCELAR;
    private javax.swing.JButton btnDEVOLVER;
    private javax.swing.JButton btnRENOVAR;
    private javax.swing.JButton btnVOLTAR;
    private net.sf.nachocalendar.components.DateField dataDEVOLUCAO;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblEMPRESTIMOS;
    private javax.swing.JTable tblITENS;
    private javax.swing.JTextField txtBUSCAR;
    private javax.swing.JTextField txtDATAEMP;
    // End of variables declaration//GEN-END:variables
/**
     * Realiza a Devolução das Obras ao Acervo da Biblioteca.
     *
     *
     *
     */
    private void devolver() {
        Connection con = Conexao.abrirConexao();

        EmprestimoBean eb = new EmprestimoBean();
        EmprestimoDAO ed = new EmprestimoDAO(con);
        Integer linha = tblEMPRESTIMOS.getSelectedRow();

        eb.setData_dev_real(verificarDataDevolucaoReal());
        eb.setId((int) tblEMPRESTIMOS.getValueAt(linha, 0));
        eb.setStatus("Finalizado");

        ed.devolver(eb);

        Conexao.fecharConexao(con);
        limparCampos();
        preencherEmprestimos();
    }

    private void renovar() {
        Connection con = Conexao.abrirConexao();

        EmprestimoBean eb = new EmprestimoBean();
        EmprestimoDAO ed = new EmprestimoDAO(con);
        Integer linha = tblEMPRESTIMOS.getSelectedRow();

        //eb.setData_dev_real(verificarDataRenovacao());
        // ed.renovar(eb);
        Conexao.fecharConexao(con);
        desabilitarCampos();
        preencherEmprestimos();

    }

    private void setarData() {

        Integer linha = tblEMPRESTIMOS.getSelectedRow();
        txtDATAEMP.setText(String.valueOf(tblEMPRESTIMOS.getValueAt(linha, 1)));

    }

    /**
     * Preenche a Tabela de Empréstimos.
     *
     *
     *
     */
    private void preencherEmprestimos() {
        limparCampos();

        Connection con = Conexao.abrirConexao();
        EmprestimoDAO ed = new EmprestimoDAO(con);

        List<EmprestimoBean> listaEmprestimo = new ArrayList<>();

        if (txtBUSCAR.getText().length() > 0) {

            String locatario = txtBUSCAR.getText();
            listaEmprestimo = ed.listarPorLocatario(locatario);

        } else {
            listaEmprestimo = ed.listarTodos();
        }

        DefaultTableModel emprestimos = (DefaultTableModel) tblEMPRESTIMOS.getModel();
        tblEMPRESTIMOS.setModel(emprestimos);

        for (int i = emprestimos.getRowCount() - 1; i >= 0; i--) {

            emprestimos.removeRow(i);

        }

        int i = 0;

        for (EmprestimoBean eb : listaEmprestimo) {

            emprestimos.addRow(new String[1]);

            tblEMPRESTIMOS.setValueAt(eb.getId(), i, 0);
            tblEMPRESTIMOS.setValueAt(formatarData(eb.getData_emprestimo()), i, 1);
            tblEMPRESTIMOS.setValueAt(formatarData(eb.getData_dev_prev()), i, 2);
            tblEMPRESTIMOS.setValueAt(eb.getUsuario(), i, 3);
            tblEMPRESTIMOS.setValueAt(eb.getLocatario(), i, 4);
            tblEMPRESTIMOS.setValueAt(eb.getStatus(), i, 5);

            i++;

        }

        Conexao.fecharConexao(con);

    }

    /**
     * Preenche a Tabela de Itens, de acordo com o Empréstimo clicado na Tabela
     * de Empréstimos.
     *
     *
     */
    private void preencherItens() {

        btnDEVOLVER.setEnabled(true);
        btnRENOVAR.setEnabled(true);
        btnCANCELAR.setEnabled(true);

        Connection con = Conexao.abrirConexao();
        ItensEmprestimoDAO ied = new ItensEmprestimoDAO(con);

        //PEGA OS ITENS DO BANCO, DE ACORDO COM O EMPRÉSTIMO
        List<ObraBean> listaObra = new ArrayList<>();
        Integer linha = tblEMPRESTIMOS.getSelectedRow();
        //PEGA O ID DO EMPRÉSTIMO
        String id_emprestimo = String.valueOf(tblEMPRESTIMOS.getValueAt(linha, 0));

        //ATRIBUI O RETORNO DADO PELO MÉTODO DE LISTAR OS ITENS, NA CLASSE ITENS_EMPRESTIMO(DAO) À ARRAYLIST CRIADA ACIMA
        listaObra = ied.listarTodos(id_emprestimo);

        DefaultTableModel itens = (DefaultTableModel) tblITENS.getModel();
        tblITENS.setModel(itens);

        for (int i = itens.getRowCount() - 1; i >= 0; i--) {

            itens.removeRow(i);

        }

        int i = 0;

        for (ObraBean ob : listaObra) {
            itens.addRow(new String[1]);

            tblITENS.setValueAt(ob.getID(), i, 0);
            tblITENS.setValueAt(ob.getTitulo_OBRA(), i, 1);
            tblITENS.setValueAt(ob.getAutor(), i, 2);
            tblITENS.setValueAt(ob.getEditora_OBRA(), i, 3);
            tblITENS.setValueAt(ob.getGenero(), i, 4);
            tblITENS.setValueAt(ob.getEdicao(), i, 5);
            tblITENS.setValueAt(ob.getAno(), i, 6);
            tblITENS.setValueAt(ob.getQuantidade_OBRA(), i, 7);
            tblITENS.setValueAt(ob.getNota(), i, 8);

            i++;

        }

        Conexao.fecharConexao(con);

    }

    private void limparCampos() {
        txtBUSCAR.setText("");
        txtDATAEMP.setText("");
        tblEMPRESTIMOS.clearSelection();
        DefaultTableModel itens = (DefaultTableModel) tblITENS.getModel();
        itens.setNumRows(0);
        desabilitarCampos();
    }

    private void habilitarCampos() {

        btnDEVOLVER.setEnabled(true);
        btnRENOVAR.setEnabled(true);
        btnCANCELAR.setEnabled(true);

    }

    private void desabilitarCampos() {

        btnDEVOLVER.setEnabled(false);
        btnRENOVAR.setEnabled(false);
        btnCANCELAR.setEnabled(false);

    }

    /**
     * Verifica o status do Empréstimo. Caso seja "Em Aberto", formata o texto
     * em verde; Caso seja "Em Atraso", formata o texto em vermelho.
     *
     */
//    private String verificaStatus(Date devolucaoPrevista) {
//
//        Date hoje = new Date(System.currentTimeMillis());
//
//        if (hoje.after(devolucaoPrevista)) {
//
//            return "<html><font:color = red><b>Em Atraso</b></font></html>";
//
//        } else {
//
//            return "<html><font:color = green><b>Em Aberto</b></font></html>";
//        }
//    }

    /**
     * Formata a data para o padrão brasileiro.
     *
     *
     *
     */
    private String formatarData(Date data) {
        String dataFormatada;
        SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
        dataFormatada = formatarData.format(data);

        return dataFormatada;

    }

    /**
     * Verifica a Data de Devolução do Empréstimo.
     *
     *
     *
     */
    private Date verificarDataDevolucaoReal() {

        java.util.Date d = (java.util.Date) dataDEVOLUCAO.getValue();
        java.sql.Date dataatual = new java.sql.Date(d.getTime());

        SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
        dataatual = Date.valueOf(formatarData.format(dataatual));

        return dataatual;

    }

    private void preencherRenovacao() {

        Integer linha = tblEMPRESTIMOS.getSelectedRow();

        int id = (int) tblEMPRESTIMOS.getValueAt(linha, 0);
        String dataEmp = (String) tblEMPRESTIMOS.getValueAt(linha, 1);
        String dataDev = (String) tblEMPRESTIMOS.getValueAt(linha, 2);
        String locatario = (String) tblEMPRESTIMOS.getValueAt(linha, 4);
        String status = (String) tblEMPRESTIMOS.getValueAt(linha, 5);

        JFrame renovacao = new frm_RENOVAR(id, dataEmp, dataDev, locatario, status);

        renovacao.setVisible(true);

    }
}
