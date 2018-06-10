package Interface;

import Beans.EmprestimoBean;
import Beans.LocatarioBean;
import Beans.ObraBean;
import DAO.Conexao;
import DAO.EmprestimoDAO;
import DAO.ItensEmprestimoDAO;
import DAO.LocatarioDAO;
import Extras.Email;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frm_ATRASOS extends javax.swing.JFrame {

    private final Icon atencao = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/atencao.png")));

    public frm_ATRASOS() {
        initComponents();
        listarAtrasos();
        tblATRASOS.setFillsViewportHeight(true);
        //SETA O ICONE DO SISTEMA
        URL url = this.getClass().getResource("/Imagens/icone.png");
        Image logo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(logo);

       

        tblATRASOS.setSelectionMode(1);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblATRASOS = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnVoltar = new javax.swing.JButton();
        btnEmail = new javax.swing.JButton();

        setTitle("Devoluções Atrasadas");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white), "Devoluções Atrasadas", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jScrollPane2.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));

        tblATRASOS.setBackground(new java.awt.Color(204, 255, 204));
        tblATRASOS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        tblATRASOS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblATRASOS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html><h3>ID</h3></html>", "<html><h3>Usuário</h3></html>", "<html><h3>Locatário</h3></html>", "<html><h3>Data de Empréstimo</h3></html>", "<html><h3>Data de Devolução</h3></html>"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblATRASOS.setToolTipText("<html><h3>Empréstimos Atrasados</h3></html>");
        tblATRASOS.setFocusable(false);
        tblATRASOS.setGridColor(new java.awt.Color(255, 255, 255));
        tblATRASOS.setSelectionBackground(new java.awt.Color(153, 255, 204));
        tblATRASOS.getTableHeader().setReorderingAllowed(false);
        tblATRASOS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblATRASOSMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblATRASOS);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        btnVoltar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/voltar.png"))); // NOI18N
        btnVoltar.setToolTipText("<html><h3>Retornar à Tela Principal</h3></html>");
        btnVoltar.setBorderPainted(false);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setFocusable(false);
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnEmail.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEmail.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/email.png"))); // NOI18N
        btnEmail.setToolTipText("<html><h3>Enviar E-mail</h3></html>");
        btnEmail.setBorderPainted(false);
        btnEmail.setContentAreaFilled(false);
        btnEmail.setFocusable(false);
        btnEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmailActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 70, Short.MAX_VALUE)
            .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmailActionPerformed
           if (tblATRASOS.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(null, "Selecione um Empréstimo!", "ATENÇÃO", JOptionPane.ERROR_MESSAGE, atencao);
        } else {
        enviarEmail();
        }
    }//GEN-LAST:event_btnEmailActionPerformed

    private void tblATRASOSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblATRASOSMouseClicked
    
    }//GEN-LAST:event_tblATRASOSMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frm_CARREGAMENTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_CARREGAMENTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_CARREGAMENTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_CARREGAMENTO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_ATRASOS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmail;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblATRASOS;
    // End of variables declaration//GEN-END:variables

    private void listarAtrasos() {
        Connection con = Conexao.abrirConexao();
        EmprestimoDAO ed = new EmprestimoDAO(con);

        List<EmprestimoBean> listaAtrasos = new ArrayList<>();
        listaAtrasos = ed.listarAtrasos();

        DefaultTableModel atrasos = (DefaultTableModel) tblATRASOS.getModel();
        tblATRASOS.setModel(atrasos);

        for (int i = atrasos.getRowCount() - 1; i >= 0; i--) {
            atrasos.removeRow(i);
        }

        int i = 0;

        for (EmprestimoBean eb : listaAtrasos) {
            atrasos.addRow(new String[1]);

            atrasos.setValueAt( eb.getId()  , i, 0);
            atrasos.setValueAt(eb.getUsuario()  , i, 1);
            atrasos.setValueAt( eb.getLocatario()  , i, 2);
            atrasos.setValueAt( formatarData(eb.getData_emprestimo()) , i, 3);
            atrasos.setValueAt(formatarData(eb.getData_dev_prev()), i, 4);

            i++;

        }
        Conexao.fecharConexao(con);
    }

    private void enviarEmail() {
        Connection con = Conexao.abrirConexao();
        LocatarioDAO ld = new LocatarioDAO(con);
        ItensEmprestimoDAO ied = new ItensEmprestimoDAO(con);

        Integer linha = tblATRASOS.getSelectedRow();

        String locatario = String.valueOf(tblATRASOS.getValueAt(linha, 2));
        String dataDev = String.valueOf(tblATRASOS.getValueAt(linha, 4));

        String email = ld.verificarEmail(locatario);
        
        String obras[] = new String[10];
        Email emailDeAtrasos = new Email();
        emailDeAtrasos.enviarEmail(email,locatario);
        
        Conexao.fecharConexao(con);
    }
    private String formatarData(Date data) {
        String dataFormatada;
        SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
        dataFormatada = formatarData.format(data);

        return dataFormatada;

    }

}
