package Interface;

import DAO.Conexao;
import DAO.UsuarioDAO;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Beans.UsuarioBean;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

public class frm_USUARIOS extends javax.swing.JFrame {

    private final Icon atencao = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/atencao.png")));
    private final Icon questao = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/questao.png")));

    public frm_USUARIOS() {
        initComponents();
        pesquisarUsuario();
        tblUSUARIO.setFillsViewportHeight(true);
        
        //SETA O ICONE DO SISTEMA
        URL url = this.getClass().getResource("/Imagens/icone.png");
        Image logo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(logo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtNOME = new javax.swing.JTextField();
        txtCODIGO = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtLOGIN = new javax.swing.JTextField();
        txtSENHA = new javax.swing.JPasswordField();
        txtCONFIRMAR = new javax.swing.JPasswordField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblUSUARIO = new javax.swing.JTable();
        lblERRO_SENHA = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNOVO = new javax.swing.JButton();
        btnSALVAR = new javax.swing.JButton();
        btnEDITAR = new javax.swing.JButton();
        btnEXCLUIR = new javax.swing.JButton();
        btnCANCELAR = new javax.swing.JButton();
        btnVOLTAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Usuários");
        setUndecorated(true);
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(204, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white), "Usuário", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtNOME.setEditable(false);
        txtNOME.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNOME.setToolTipText("<html><h3>Nome do Usuário</h3></html>");
        txtNOME.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtNOME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNOMEKeyTyped(evt);
            }
        });

        txtCODIGO.setEditable(false);
        txtCODIGO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCODIGO.setToolTipText("<html><h3>ID do Usuário</h3></html>");
        txtCODIGO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtCODIGO.setEnabled(false);
        txtCODIGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCODIGOActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("ID:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Nome*:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Login*:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Confirmar Senha*:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Senha*:");

        txtLOGIN.setEditable(false);
        txtLOGIN.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtLOGIN.setToolTipText("<html><h3>Login do Usuário</h3></html>");
        txtLOGIN.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtLOGIN.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLOGINKeyTyped(evt);
            }
        });

        txtSENHA.setEditable(false);
        txtSENHA.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSENHA.setToolTipText("<html><h3>Senha do Usuário</h3></html>");
        txtSENHA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtSENHA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSENHAKeyTyped(evt);
            }
        });

        txtCONFIRMAR.setEditable(false);
        txtCONFIRMAR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCONFIRMAR.setToolTipText("<html><h3>Confirmar Senha do Usuário</h3></html>");
        txtCONFIRMAR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtCONFIRMAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCONFIRMARKeyTyped(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel7.setText("(*)Campos Obrigatórios");

        jScrollPane3.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        tblUSUARIO.setBackground(new java.awt.Color(204, 255, 204));
        tblUSUARIO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblUSUARIO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html><h4>ID</h4></html>", "<html><h4>Data</h4></html>", "<html><h4>Nome</h4></html> ", "<html><h4>Login</h4></html>"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUSUARIO.setToolTipText("<html><h3>Usuários Cadastrados</h3></html>");
        tblUSUARIO.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblUSUARIO.setFocusable(false);
        tblUSUARIO.setGridColor(new java.awt.Color(255, 255, 255));
        tblUSUARIO.setSelectionBackground(new java.awt.Color(153, 255, 204));
        tblUSUARIO.setShowVerticalLines(false);
        tblUSUARIO.getTableHeader().setReorderingAllowed(false);
        tblUSUARIO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUSUARIOMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblUSUARIO);
        if (tblUSUARIO.getColumnModel().getColumnCount() > 0) {
            tblUSUARIO.getColumnModel().getColumn(0).setResizable(false);
            tblUSUARIO.getColumnModel().getColumn(1).setResizable(false);
            tblUSUARIO.getColumnModel().getColumn(2).setResizable(false);
            tblUSUARIO.getColumnModel().getColumn(3).setResizable(false);
        }

        lblERRO_SENHA.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        lblERRO_SENHA.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(79, 79, 79)
                                .addComponent(jLabel2))
                            .addComponent(txtLOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSENHA, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtCONFIRMAR, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblERRO_SENHA)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtCODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtNOME))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtCONFIRMAR, txtLOGIN, txtSENHA});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNOME, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(7, 7, 7)
                                .addComponent(txtLOGIN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(7, 7, 7)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCONFIRMAR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblERRO_SENHA)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(7, 7, 7)
                        .addComponent(txtSENHA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCODIGO, txtCONFIRMAR, txtLOGIN, txtNOME, txtSENHA});

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        btnNOVO.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnNOVO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/novoUsuario.png"))); // NOI18N
        btnNOVO.setToolTipText("<html><h3>Cadastrar Novo Usuário</h3></html>");
        btnNOVO.setBorderPainted(false);
        btnNOVO.setContentAreaFilled(false);
        btnNOVO.setFocusable(false);
        btnNOVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNOVOActionPerformed(evt);
            }
        });

        btnSALVAR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSALVAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        btnSALVAR.setToolTipText("<html><h3>Salvar Dados</h3></html>");
        btnSALVAR.setBorderPainted(false);
        btnSALVAR.setContentAreaFilled(false);
        btnSALVAR.setEnabled(false);
        btnSALVAR.setFocusable(false);
        btnSALVAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSALVARActionPerformed(evt);
            }
        });

        btnEDITAR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEDITAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/alterar.png"))); // NOI18N
        btnEDITAR.setToolTipText("<html><h3>Alterar Cadastro</h3></html>");
        btnEDITAR.setBorderPainted(false);
        btnEDITAR.setContentAreaFilled(false);
        btnEDITAR.setEnabled(false);
        btnEDITAR.setFocusable(false);
        btnEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEDITARActionPerformed(evt);
            }
        });

        btnEXCLUIR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnEXCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/deletar.png"))); // NOI18N
        btnEXCLUIR.setToolTipText("<html><h3>Excluir Dados</h3></html>");
        btnEXCLUIR.setBorderPainted(false);
        btnEXCLUIR.setContentAreaFilled(false);
        btnEXCLUIR.setEnabled(false);
        btnEXCLUIR.setFocusable(false);
        btnEXCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXCLUIRActionPerformed(evt);
            }
        });

        btnCANCELAR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCANCELAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fechar.png"))); // NOI18N
        btnCANCELAR.setToolTipText("<html><h3>Cancelar Cadastro</h3></html>");
        btnCANCELAR.setBorderPainted(false);
        btnCANCELAR.setContentAreaFilled(false);
        btnCANCELAR.setEnabled(false);
        btnCANCELAR.setFocusable(false);
        btnCANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCANCELARActionPerformed(evt);
            }
        });

        btnVOLTAR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(btnNOVO, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSALVAR, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEXCLUIR, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVOLTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEXCLUIR, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
            .addComponent(btnVOLTAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnCANCELAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnEDITAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnSALVAR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnNOVO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblUSUARIOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUSUARIOMouseClicked
        if (tblUSUARIO.getRowCount() == 0) {

            JOptionPane.showMessageDialog(null, "<html><h3>Não Há Valores Cadastrados!</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        } else {
            preencherTabela();
        }
    }//GEN-LAST:event_tblUSUARIOMouseClicked

    private void txtCONFIRMARKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCONFIRMARKeyTyped
        int caracteres = 10;

        if (txtCONFIRMAR.getText().length() >= caracteres) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "<html><h3>Digite no Máximo " + caracteres + " Caracteres</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        }
    }//GEN-LAST:event_txtCONFIRMARKeyTyped

    private void txtSENHAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSENHAKeyTyped
        int caracteres = 10;

        if (txtSENHA.getText().length() >= caracteres) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "<html><h3>Digite no Máximo " + caracteres + " Caracteres</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        }
    }//GEN-LAST:event_txtSENHAKeyTyped

    private void txtLOGINKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLOGINKeyTyped
        int caracteres = 10;

        if (txtLOGIN.getText().length() >= caracteres) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "<html><h3>Digite no Máximo " + caracteres + " Caracteres</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        }
    }//GEN-LAST:event_txtLOGINKeyTyped

    private void txtCODIGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCODIGOActionPerformed

    }//GEN-LAST:event_txtCODIGOActionPerformed

    private void txtNOMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNOMEKeyTyped
        int caracteres = 100;

        if (txtNOME.getText().length() >= caracteres) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "<html><h3>Digite no Máximo " + caracteres + " Caracteres</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        }
    }//GEN-LAST:event_txtNOMEKeyTyped

    private void btnNOVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNOVOActionPerformed
        habilitaCampos();
    }//GEN-LAST:event_btnNOVOActionPerformed

    private void btnSALVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSALVARActionPerformed
        verificaCampos();
    }//GEN-LAST:event_btnSALVARActionPerformed

    private void btnEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEDITARActionPerformed
        alterarUsuario();
    }//GEN-LAST:event_btnEDITARActionPerformed

    private void btnEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXCLUIRActionPerformed
        excluirUsuario();
    }//GEN-LAST:event_btnEXCLUIRActionPerformed

    private void btnCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCANCELARActionPerformed
        desabilitaCampos();
    }//GEN-LAST:event_btnCANCELARActionPerformed

    private void btnVOLTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVOLTARActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVOLTARActionPerformed

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
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_USUARIOS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCANCELAR;
    private javax.swing.JButton btnEDITAR;
    private javax.swing.JButton btnEXCLUIR;
    private javax.swing.JButton btnNOVO;
    private javax.swing.JButton btnSALVAR;
    private javax.swing.JButton btnVOLTAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblERRO_SENHA;
    private javax.swing.JTable tblUSUARIO;
    private javax.swing.JTextField txtCODIGO;
    private javax.swing.JPasswordField txtCONFIRMAR;
    private javax.swing.JTextField txtLOGIN;
    private javax.swing.JTextField txtNOME;
    private javax.swing.JPasswordField txtSENHA;
    // End of variables declaration//GEN-END:variables
private void incluirUsuario() {

        Connection con = Conexao.abrirConexao();
        UsuarioBean cb = new UsuarioBean();
        UsuarioDAO cd = new UsuarioDAO(con);

        cb.setNOME(txtNOME.getText());
        cb.setLOGIN(txtLOGIN.getText());
        cb.setSENHA(txtSENHA.getText());

        cd.inserir(cb);

        pesquisarUsuario();

        Conexao.fecharConexao(con);

    }

    private void alterarUsuario() {

        Connection con = Conexao.abrirConexao();
        UsuarioBean cb = new UsuarioBean();
        UsuarioDAO cd = new UsuarioDAO(con);

        cb.setID(Integer.valueOf(txtCODIGO.getText()));
        cb.setNOME(txtNOME.getText());
        cb.setLOGIN(txtLOGIN.getText());
        cb.setSENHA(txtSENHA.getText());
        cd.alterar(cb);

        pesquisarUsuario();

        Conexao.fecharConexao(con);

        desabilitaCampos();

    }

    private void excluirUsuario() {
        if (txtCODIGO.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Selecione um Locatário!", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE, atencao);
        } else {
            Connection con = Conexao.abrirConexao();
            UsuarioBean cb = new UsuarioBean();
            UsuarioDAO cd = new UsuarioDAO(con);
            cb.setID(Integer.valueOf(txtCODIGO.getText()));
            Object[] opcoes = {"Sim", "Não"};

            int i = JOptionPane.showOptionDialog(null,
                    "<html><h3>Deseja realmente excluir esse Usuário: \n"
                    + txtNOME.getText() + " ?",
                    "Exclusão", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, questao,
                    opcoes, opcoes[0]);

            if (i == JOptionPane.YES_OPTION) {

                cd.excluir(cb);
                desabilitaCampos();
            }
            pesquisarUsuario();
            Conexao.fecharConexao(con);

        }
    }

    private void habilitaCampos() {
        Connection con = Conexao.abrirConexao();
        UsuarioDAO ud = new UsuarioDAO(con);
        limpaCampos();
        txtCODIGO.setText(ud.carregaCODIGO());
        txtNOME.setEditable(true);
        txtLOGIN.setEditable(true);
        txtSENHA.setEditable(true);
        txtCONFIRMAR.setEditable(true);
        btnSALVAR.setEnabled(true);
        btnCANCELAR.setEnabled(true);

        txtNOME.grabFocus();

    }

    private void desabilitaCampos() {
        txtNOME.setEditable(false);
        txtLOGIN.setEditable(false);
        txtSENHA.setEditable(false);
        txtCONFIRMAR.setEditable(false);
        btnSALVAR.setEnabled(false);
        btnCANCELAR.setEnabled(false);
        btnEDITAR.setEnabled(false);
        btnEXCLUIR.setEnabled(false);

        limpaCampos();

    }

    private void limpaCampos() {
        txtCODIGO.setText("");
        txtNOME.setText("");
        txtLOGIN.setText("");
        txtSENHA.setText("");
        txtCONFIRMAR.setText("");
        lblERRO_SENHA.setText("");

    }

    private void verificaCampos() {
        if (("").equals(txtNOME.getText()) || ("").equals(txtLOGIN.getText())
                || ("").equals(txtSENHA.getText()) || ("").equals(txtCONFIRMAR.getText())) {
            JOptionPane.showMessageDialog(null, "<html><h3>Favor inserir todos os valores obrigatórios (*)!!</h3></html>", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE, atencao);
            txtNOME.grabFocus();
        } else {

            verificaSenha();

        }

    }

    private void verificaSenha() {
        if (txtSENHA.getText() == null ? txtCONFIRMAR.getText() != null : !txtSENHA.getText().equals(txtCONFIRMAR.getText())) {

            lblERRO_SENHA.setText("As Senhas Não Correspondem!");

        } else {

            incluirUsuario();
            desabilitaCampos();

        }

    }

    private void pesquisarUsuario() {

        Connection con = Conexao.abrirConexao();
        UsuarioDAO cd = new UsuarioDAO(con);
        List<UsuarioBean> listaUsuario = new ArrayList<>();
        listaUsuario = cd.listarTodos();

        DefaultTableModel tbm = (DefaultTableModel) tblUSUARIO.getModel();
        tblUSUARIO.setModel(tbm);
        ajustaTamanhoColuna();

        for (int i = tbm.getRowCount() - 1; i >= 0; i--) {

            tbm.removeRow(i);

        }

        int i = 0;

        for (UsuarioBean cb : listaUsuario) {
            tbm.addRow(new String[1]);

            tblUSUARIO.setValueAt(cb.getID(), i, 0);
            tblUSUARIO.setValueAt(formatarData(cb.getData()), i, 1);
            tblUSUARIO.setValueAt(cb.getNOME(), i, 2);
            tblUSUARIO.setValueAt(cb.getLOGIN(), i, 3);

            i++;

        }

        Conexao.fecharConexao(con);

    }

    //PREENCHE A TABELA DE USUARIOS
    private void preencherTabela() {

        btnEDITAR.setEnabled(true);
        btnEXCLUIR.setEnabled(true);
        Integer linha = tblUSUARIO.getSelectedRow();
        String id = String.valueOf(tblUSUARIO.getValueAt(linha, 0));
        String nome = (String) tblUSUARIO.getValueAt(linha, 2);
        String login = (String) tblUSUARIO.getValueAt(linha, 3);

        txtCODIGO.setText(id);
        txtNOME.setText(nome);
        txtLOGIN.setText(login);
        txtCODIGO.setEnabled(false);
        txtNOME.setEnabled(true);
        txtNOME.setEditable(true);
        txtLOGIN.setEnabled(true);
        txtLOGIN.setEditable(true);
        txtSENHA.setEnabled(true);
        txtSENHA.setEditable(true);
        txtCONFIRMAR.setEnabled(true);
        txtCONFIRMAR.setEditable(true);

    }

    private void ajustaTamanhoColuna() {
        tblUSUARIO.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblUSUARIO.getColumnModel().getColumn(0).setPreferredWidth(50);
        tblUSUARIO.getColumnModel().getColumn(1).setPreferredWidth(90);
        tblUSUARIO.getColumnModel().getColumn(2).setPreferredWidth(478);
        tblUSUARIO.getColumnModel().getColumn(3).setPreferredWidth(145);

    }

    private String formatarData(Date data) {
        String dataFormatada;
        SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
        dataFormatada = formatarData.format(data);

        return dataFormatada;

    }

}
