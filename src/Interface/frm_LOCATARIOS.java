package Interface;

import DAO.Conexao;
import Beans.LocatarioBean;
import DAO.LocatarioDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

public class frm_LOCATARIOS extends javax.swing.JFrame {

    private final Icon atencao = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/atencao.png")));
    private final Icon questao = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/questao.png")));

    public frm_LOCATARIOS() {
        initComponents();
        limpaCampos();
        buscarLocatario();
        tblPESSOA.setFillsViewportHeight(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        //SETA O ICONE DO SISTEMA
        URL url = this.getClass().getResource("/Imagens/icone.png");
        Image logo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(logo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblERRO_SENHA = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPESSOA = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        txtBUSCAR = new javax.swing.JTextField();
        btnBUSCAR = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCODIGO = new javax.swing.JTextField();
        cbTIPOPESSOA = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtEMAIL = new javax.swing.JTextField();
        txtTELEFONE = new javax.swing.JFormattedTextField();
        cbANOSERIE = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtCELULAR = new javax.swing.JFormattedTextField();
        cbPERIODO = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        txtNOME = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnNOVO = new javax.swing.JButton();
        btnSALVAR = new javax.swing.JButton();
        btnEDITAR = new javax.swing.JButton();
        btnEXCLUIR = new javax.swing.JButton();
        btnCANCELAR = new javax.swing.JButton();
        btnVOLTAR = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Locatários");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        lblERRO_SENHA.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        lblERRO_SENHA.setForeground(java.awt.Color.red);
        lblERRO_SENHA.setToolTipText("");

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white), "Pesquisar ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel3.setToolTipText("");

        jScrollPane3.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        jScrollPane3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tblPESSOA.setBackground(new java.awt.Color(204, 255, 204));
        tblPESSOA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        tblPESSOA.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblPESSOA.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html><h4>ID</h4></html>", "<html><h4>Nome</h4></html>", "<html><h4>Tipo</h4></html>", "<html><h4>Período</h4></html>", "<html><h4>Ano/Série</h4></html>", "<html><h4>E-mail</h4></html> ", "<html><h4>Telefone</h4></html>", "<html><h4>Celular</h4></html>"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPESSOA.setToolTipText("<html><h3>Locatários Cadastrados</h3></html>");
        tblPESSOA.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblPESSOA.setFocusable(false);
        tblPESSOA.setGridColor(new java.awt.Color(255, 255, 255));
        tblPESSOA.setSelectionBackground(new java.awt.Color(153, 255, 204));
        tblPESSOA.getTableHeader().setReorderingAllowed(false);
        tblPESSOA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPESSOAMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblPESSOA);

        jLabel11.setBackground(new java.awt.Color(153, 255, 204));
        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("Nome:");

        txtBUSCAR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBUSCAR.setToolTipText("<html><h3>Digite o Nome do Locatário</h3></html>");
        txtBUSCAR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        btnBUSCAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscar.png"))); // NOI18N
        btnBUSCAR.setToolTipText("<html><h3>Buscar Locatário</h3></html>");
        btnBUSCAR.setBorderPainted(false);
        btnBUSCAR.setContentAreaFilled(false);
        btnBUSCAR.setFocusable(false);
        btnBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBUSCARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBUSCAR)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnBUSCAR)
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addGap(4, 4, 4)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBUSCAR)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtBUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(153, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white), "Dados do Locatário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N
        jPanel4.setToolTipText("<html><h3>Dados do Locatário</h3></html>");

        jLabel1.setBackground(new java.awt.Color(153, 255, 204));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("ID:");

        jLabel3.setBackground(new java.awt.Color(153, 255, 204));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Tipo*:");

        txtCODIGO.setEditable(false);
        txtCODIGO.setBackground(new java.awt.Color(255, 255, 255));
        txtCODIGO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCODIGO.setToolTipText("<html><h3>ID do Locatário</h3></html>");
        txtCODIGO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtCODIGO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCODIGOActionPerformed(evt);
            }
        });

        cbTIPOPESSOA.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbTIPOPESSOA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aluno", "Professor" }));
        cbTIPOPESSOA.setSelectedIndex(-1);
        cbTIPOPESSOA.setToolTipText("<html><h3>Selecione o Tipo de Locatário</h3></html>");
        cbTIPOPESSOA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        cbTIPOPESSOA.setEnabled(false);
        cbTIPOPESSOA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTIPOPESSOAActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(153, 255, 204));
        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("E-mail:");

        txtEMAIL.setEditable(false);
        txtEMAIL.setBackground(new java.awt.Color(255, 255, 255));
        txtEMAIL.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEMAIL.setToolTipText("<html><h3>E-mail do Locatário</h3></html>");
        txtEMAIL.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtEMAIL.setEnabled(false);
        txtEMAIL.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEMAILKeyTyped(evt);
            }
        });

        txtTELEFONE.setEditable(false);
        txtTELEFONE.setBackground(new java.awt.Color(255, 255, 255));
        txtTELEFONE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        try {
            txtTELEFONE.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtTELEFONE.setToolTipText("<html><h3>Telefone do Locatário</h3></html>");
        txtTELEFONE.setEnabled(false);
        txtTELEFONE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTELEFONE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTELEFONEActionPerformed(evt);
            }
        });

        cbANOSERIE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbANOSERIE.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1ºA", "1ºB", "1ºC", "2ºA", "2ºB", "2ºC", "2ºD", "3ºA", "3ºB", "3ºC", "3ºD", "3ºE", "4ºA", "4ºB", "4ºC", "4ºD", "4ºE", "5ºA", "5ºB", "5ºC", "5ºD", "5ºE", "6ºA", "6ºB", "6ºC", "6ºD", "7ºA", "7ºB", "7ºC", "7ºD", "8ºA", "8ºB", "8ºC", "8ºD", "9ºA", "9ºB", "9ºC", "1ºA EM", "1ºB EM", "1ºC EM", "1ºD EM", "2ºA EM", "2ºB EM", "2ºC EM", "2ºD EM", "3ºA EM", "3ºB EM", "3ºC EM", "3ºD EM", "3ºE EM" }));
        cbANOSERIE.setSelectedIndex(-1);
        cbANOSERIE.setToolTipText("<html><h3>Selecione o Ano/Série do Aluno</h3></html>");
        cbANOSERIE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        cbANOSERIE.setEnabled(false);

        jLabel5.setBackground(new java.awt.Color(153, 255, 204));
        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Ano/Série:");

        jLabel9.setBackground(new java.awt.Color(153, 255, 204));
        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Telefone:");

        jLabel10.setBackground(new java.awt.Color(153, 255, 204));
        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Celular:");

        txtCELULAR.setEditable(false);
        txtCELULAR.setBackground(new java.awt.Color(255, 255, 255));
        txtCELULAR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        try {
            txtCELULAR.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txtCELULAR.setToolTipText("<html><h3>Celular do Locatário</h3></html>");
        txtCELULAR.setEnabled(false);
        txtCELULAR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCELULAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCELULARActionPerformed(evt);
            }
        });

        cbPERIODO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbPERIODO.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manhã", "Tarde", "Noite" }));
        cbPERIODO.setSelectedIndex(-1);
        cbPERIODO.setToolTipText("<html><h3>Selecione o Período do Aluno</h3></html>");
        cbPERIODO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        cbPERIODO.setEnabled(false);

        jLabel4.setBackground(new java.awt.Color(153, 255, 204));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Período:");

        txtNOME.setEditable(false);
        txtNOME.setBackground(new java.awt.Color(255, 255, 255));
        txtNOME.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtNOME.setToolTipText("<html><h3>Nome do Locatário</h3></html>");
        txtNOME.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtNOME.setEnabled(false);
        txtNOME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNOMEKeyTyped(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(153, 255, 204));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Nome*:");

        jLabel7.setBackground(new java.awt.Color(153, 255, 204));
        jLabel7.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel7.setText("(*)Campos Obrigatórios");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtCODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addComponent(txtNOME)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbTIPOPESSOA, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtEMAIL)
                            .addComponent(jLabel8)
                            .addComponent(jLabel3))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(cbANOSERIE, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtTELEFONE, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addGap(85, 85, 85))
                            .addComponent(jLabel9))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbPERIODO, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtCELULAR, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                .addGap(85, 85, 85))
                            .addComponent(jLabel10))))
                .addGap(14, 14, 14))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNOME, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTIPOPESSOA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbANOSERIE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbPERIODO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEMAIL, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTELEFONE, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCELULAR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbTIPOPESSOA, txtCELULAR, txtCODIGO, txtEMAIL, txtNOME, txtTELEFONE});

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        btnNOVO.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnNOVO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/leitor.png"))); // NOI18N
        btnNOVO.setToolTipText("<html><h3>Cadastrar Novo Locatário</h3></html>");
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
        btnEDITAR.setToolTipText("<html><h3>Alterar Dados</h3></html>");
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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNOVO, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSALVAR, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEDITAR, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnEXCLUIR, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(13, 13, 13)
                .addComponent(btnCANCELAR, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btnVOLTAR, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnVOLTAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btnNOVO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSALVAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEDITAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEXCLUIR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCANCELAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(lblERRO_SENHA))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(155, 155, 155)
                        .addComponent(lblERRO_SENHA))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNOMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNOMEKeyTyped
        int caracteres = 100;

        if (txtNOME.getText().length() >= caracteres) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "<html><h3>Digite no Máximo " + caracteres + " Caracteres</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);
        }
    }//GEN-LAST:event_txtNOMEKeyTyped

    private void txtCODIGOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCODIGOActionPerformed

    }//GEN-LAST:event_txtCODIGOActionPerformed

    private void btnNOVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNOVOActionPerformed
        habilitaCampos();
    }//GEN-LAST:event_btnNOVOActionPerformed

    private void btnCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCANCELARActionPerformed
        desabilitaCampos();
    }//GEN-LAST:event_btnCANCELARActionPerformed

    private void btnSALVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSALVARActionPerformed
        verificaCampos();
    }//GEN-LAST:event_btnSALVARActionPerformed

    private void btnVOLTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVOLTARActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnVOLTARActionPerformed

    private void cbTIPOPESSOAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTIPOPESSOAActionPerformed

        //VERIFICA SE O TIPO DE PESSOA SELECIONADO É PROFESSOR OU ALUNO
        if (cbTIPOPESSOA.getSelectedIndex() == 0) {
            cbANOSERIE.setEnabled(true);
            cbPERIODO.setEnabled(true);

        } else {
            cbANOSERIE.setEnabled(false);
            cbPERIODO.setEnabled(false);
            cbPERIODO.setSelectedIndex(-1);
            cbPERIODO.setSelectedItem(null);
            cbANOSERIE.setSelectedIndex(-1);
            cbANOSERIE.setSelectedItem(null);
        }
    }//GEN-LAST:event_cbTIPOPESSOAActionPerformed

    private void txtEMAILKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEMAILKeyTyped
        int caracteres = 80;

        if (txtEMAIL.getText().length() >= caracteres) {
            evt.consume();
            JOptionPane.showMessageDialog(null, "<html><h3>Digite no Máximo " + caracteres + " Caracteres</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        }
    }//GEN-LAST:event_txtEMAILKeyTyped

    private void txtTELEFONEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTELEFONEActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTELEFONEActionPerformed

    private void txtCELULARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCELULARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCELULARActionPerformed

    private void btnBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBUSCARActionPerformed
        buscarLocatario();
    }//GEN-LAST:event_btnBUSCARActionPerformed

    private void tblPESSOAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPESSOAMouseClicked
        if (tblPESSOA.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "<html><h3>Não Há Valores Cadastrados!</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        } else {
            preencherCampos();
        }

    }//GEN-LAST:event_tblPESSOAMouseClicked

    private void btnEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEDITARActionPerformed
        verificaCampos();
    }//GEN-LAST:event_btnEDITARActionPerformed

    private void btnEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXCLUIRActionPerformed
        if (txtCODIGO.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Selecione um Locatário!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);
        } else {
            excluir();
        }
    }//GEN-LAST:event_btnEXCLUIRActionPerformed

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
                JFrame locatario = new frm_LOCATARIOS();
                locatario.setExtendedState(MAXIMIZED_BOTH);
                locatario.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBUSCAR;
    private javax.swing.JButton btnCANCELAR;
    private javax.swing.JButton btnEDITAR;
    private javax.swing.JButton btnEXCLUIR;
    private javax.swing.JButton btnNOVO;
    private javax.swing.JButton btnSALVAR;
    private javax.swing.JButton btnVOLTAR;
    private javax.swing.JComboBox<String> cbANOSERIE;
    private javax.swing.JComboBox<String> cbPERIODO;
    private javax.swing.JComboBox<String> cbTIPOPESSOA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblERRO_SENHA;
    private javax.swing.JTable tblPESSOA;
    private javax.swing.JTextField txtBUSCAR;
    private javax.swing.JFormattedTextField txtCELULAR;
    private javax.swing.JTextField txtCODIGO;
    private javax.swing.JTextField txtEMAIL;
    private javax.swing.JTextField txtNOME;
    private javax.swing.JFormattedTextField txtTELEFONE;
    // End of variables declaration//GEN-END:variables

    private void salvar() {

        Connection con = Conexao.abrirConexao();
        LocatarioBean lb = new LocatarioBean();
        LocatarioDAO ld = new LocatarioDAO(con);

        lb.setNome(txtNOME.getText());
        lb.setSerie((String) cbANOSERIE.getSelectedItem());
        lb.setPeriodo((String) cbPERIODO.getSelectedItem());
        lb.setTipo((String) cbTIPOPESSOA.getSelectedItem());
        lb.setEmail(txtEMAIL.getText());
        lb.setTel(txtTELEFONE.getText());
        lb.setCel(txtCELULAR.getText());

        ld.inserir(lb);

        desabilitaCampos();
        Conexao.fecharConexao(con);
        buscarLocatario();

    }

    private void alterar() {
        Connection con = Conexao.abrirConexao();
        LocatarioBean lb = new LocatarioBean();
        LocatarioDAO ld = new LocatarioDAO(con);

        lb.setID(Integer.valueOf(txtCODIGO.getText()));
        lb.setNome(txtNOME.getText());
        lb.setSerie((String) cbANOSERIE.getSelectedItem());
        lb.setPeriodo((String) cbPERIODO.getSelectedItem());
        lb.setTipo((String) cbTIPOPESSOA.getSelectedItem());
        lb.setEmail(txtEMAIL.getText());
        lb.setTel(txtTELEFONE.getText());
        lb.setCel(txtCELULAR.getText());

        ld.alterar(lb);

        desabilitaCampos();

        Conexao.fecharConexao(con);
        buscarLocatario();
    }

    private void excluir() {
        if (txtCODIGO.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um Locatário!", "ATENÇÃO", JOptionPane.INFORMATION_MESSAGE, atencao);
        } else {

            Connection con = Conexao.abrirConexao();
            LocatarioBean lb = new LocatarioBean();
            LocatarioDAO ld = new LocatarioDAO(con);
            lb.setID(Integer.valueOf(txtCODIGO.getText()));
            Object[] opcoes = {"Sim", "Não"};

            int i = JOptionPane.showOptionDialog(null,
                    "<html><h3>Deseja realmente excluir esse Locatário: \n"
                    + txtNOME.getText() + " ?",
                    "Exclusão", JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE, questao,
                    opcoes, opcoes[0]);

            if (i == JOptionPane.YES_OPTION) {

                ld.excluir(lb);
                desabilitaCampos();
            }
            buscarLocatario();
            Conexao.fecharConexao(con);
        }
    }

    private void habilitaCampos() {
        Connection con = Conexao.abrirConexao();
        LocatarioDAO ld = new LocatarioDAO(con);
        txtNOME.setEnabled(true);
        txtNOME.setEditable(true);
        txtEMAIL.setEnabled(true);
        txtEMAIL.setEditable(true);
        txtTELEFONE.setEnabled(true);
        txtTELEFONE.setEditable(true);
        txtCELULAR.setEnabled(true);
        txtCELULAR.setEditable(true);
        cbTIPOPESSOA.setEnabled(true);
        btnCANCELAR.setEnabled(true);
        btnSALVAR.setEnabled(true);
        txtNOME.grabFocus();
        limpaCampos();
        txtCODIGO.setText(ld.carregaCODIGO());

    }

    private void limpaCampos() {
        txtCODIGO.setText("");
        txtNOME.setText("");
        cbTIPOPESSOA.setSelectedIndex(-1);
        cbTIPOPESSOA.setSelectedItem(null);
        cbANOSERIE.setSelectedIndex(-1);
        cbANOSERIE.setSelectedItem(null);
        cbPERIODO.setSelectedIndex(-1);
        cbPERIODO.setSelectedItem(null);
        txtEMAIL.setText("");
        txtTELEFONE.setText("");
        txtCELULAR.setText("");

    }

    private void desabilitaCampos() {
        txtNOME.setEnabled(false);
        txtNOME.setEditable(false);
        txtEMAIL.setEnabled(false);
        txtEMAIL.setEditable(false);
        txtTELEFONE.setEnabled(false);
        txtCELULAR.setEnabled(false);
        txtCELULAR.setEditable(false);
        cbTIPOPESSOA.setEnabled(false);
        cbANOSERIE.setEnabled(false);
        cbPERIODO.setEnabled(false);
        btnCANCELAR.setEnabled(false);
        btnEDITAR.setEnabled(false);
        btnEXCLUIR.setEnabled(false);
        btnSALVAR.setEnabled(false);
        tblPESSOA.clearSelection();
        btnVOLTAR.grabFocus();

        limpaCampos();

    }

    private void verificaCampos() {
        if ("".equals(txtNOME.getText())
                || cbTIPOPESSOA.getSelectedIndex() == -1) {

            JOptionPane.showMessageDialog(null, "<html><h3>Favor inserir todos os valores obrigatórios (*)!!</h3></html>", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE, atencao);
            txtNOME.grabFocus();
        } else if (btnSALVAR.isEnabled() == true) {

            salvar();
        } else {

            alterar();

        }
    }

    private void buscarLocatario() {

        Connection con = Conexao.abrirConexao();
        LocatarioDAO ld = new LocatarioDAO(con);
        List<LocatarioBean> locatario = new ArrayList<>();
        String nome = txtBUSCAR.getText();

        if (nome.equals("")) {

            locatario = ld.listarTodos();
        } else {
            locatario = ld.listarPorNome(nome);
        }
        txtBUSCAR.setText("");

        DefaultTableModel dtm = (DefaultTableModel) tblPESSOA.getModel();
        tblPESSOA.setModel(dtm);

        for (int i = dtm.getRowCount() - 1; i >= 0; i--) {

            dtm.removeRow(i);
        }

        int i = 0;

        for (LocatarioBean cb : locatario) {
            dtm.addRow(new String[1]);
            tblPESSOA.setValueAt(cb.getID(), i, 0);
            tblPESSOA.setValueAt(cb.getNome(), i, 1);
            tblPESSOA.setValueAt(cb.getTipo(), i, 2);
            tblPESSOA.setValueAt(cb.getPeriodo(), i, 3);
            tblPESSOA.setValueAt(cb.getSerie(), i, 4);
            tblPESSOA.setValueAt(cb.getEmail(), i, 5);
            tblPESSOA.setValueAt(cb.getTel(), i, 6);
            tblPESSOA.setValueAt(cb.getCel(), i, 7);
            i++;
        }

        Conexao.fecharConexao(con);

    }

    private void preencherCampos() {

        habilitaCampos();
        btnEDITAR.setEnabled(true);
        btnEXCLUIR.setEnabled(true);
        btnSALVAR.setEnabled(false);
        btnNOVO.setEnabled(false);
        Integer linha = tblPESSOA.getSelectedRow();
        txtCODIGO.setText(String.valueOf(tblPESSOA.getValueAt(linha, 0)));
        txtNOME.setText((String) tblPESSOA.getValueAt(linha, 1));
        cbTIPOPESSOA.setSelectedItem((String) tblPESSOA.getValueAt(linha, 2));
        cbPERIODO.setSelectedItem((String) tblPESSOA.getValueAt(linha, 3));
        cbANOSERIE.setSelectedItem((String) tblPESSOA.getValueAt(linha, 4));
        txtEMAIL.setText((String) tblPESSOA.getValueAt(linha, 5));
        txtTELEFONE.setText((String) tblPESSOA.getValueAt(linha, 6));
        txtCELULAR.setText((String) tblPESSOA.getValueAt(linha, 7));

    }

  
}
