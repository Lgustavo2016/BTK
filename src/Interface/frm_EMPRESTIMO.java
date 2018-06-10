package Interface;

import Beans.EmprestimoBean;
import Beans.ItensEmprestimoBean;
import Beans.ObraBean;
import DAO.Conexao;
import DAO.EmprestimoDAO;
import DAO.ItensEmprestimoDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frm_EMPRESTIMO extends javax.swing.JFrame {

    private String usuario = "";
    private final Icon atencao = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/atencao.png")));
    private final Icon questao = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/questao.png")));
    private final Icon erro = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/erro.png")));

    public frm_EMPRESTIMO(String usuario) {
        initComponents();
        this.usuario = usuario;
        carregarOBRAS();
        carregarLOCATARIOS();
        tblITENS.setFillsViewportHeight(true);
        limparCampos();
        //SETA O ICONE DO SISTEMA
        URL url = this.getClass().getResource("/Imagens/icone.png");
        Image logo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(logo);

    }

    public frm_EMPRESTIMO() {
        initComponents();
        setarDatas();
        limparCampos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnSALVAR = new javax.swing.JButton();
        btnVOLTAR = new javax.swing.JButton();
        btnNOVO = new javax.swing.JButton();
        btnCANCELAR = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        cbLOCATARIO = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        txtTIPO = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtSERIE = new javax.swing.JTextField();
        txtPERIODO = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        txtTOMBO = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbOBRA = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtQTD = new javax.swing.JTextField();
        btnADICIONAR = new javax.swing.JButton();
        btnREMOVER = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblITENS = new javax.swing.JTable();
        dataDEVOLUCAO = new net.sf.nachocalendar.components.DateField();
        dataEMPRESTIMO = new net.sf.nachocalendar.components.DateField();

        setTitle("Empréstimo");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1006, 390));

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        btnSALVAR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSALVAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        btnSALVAR.setToolTipText("<html><h3>Salvar Dados</h3><html>");
        btnSALVAR.setBorderPainted(false);
        btnSALVAR.setContentAreaFilled(false);
        btnSALVAR.setEnabled(false);
        btnSALVAR.setFocusable(false);
        btnSALVAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSALVARActionPerformed(evt);
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

        btnNOVO.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnNOVO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/emprestimo_1.png"))); // NOI18N
        btnNOVO.setToolTipText("<html><h3>Novo Empréstimo</h3></html>");
        btnNOVO.setBorderPainted(false);
        btnNOVO.setContentAreaFilled(false);
        btnNOVO.setFocusable(false);
        btnNOVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNOVOActionPerformed(evt);
            }
        });

        btnCANCELAR.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCANCELAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fechar.png"))); // NOI18N
        btnCANCELAR.setToolTipText("<html><h3>Cancelar Empréstimo</h3></html>");
        btnCANCELAR.setBorderPainted(false);
        btnCANCELAR.setContentAreaFilled(false);
        btnCANCELAR.setEnabled(false);
        btnCANCELAR.setFocusable(false);
        btnCANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCANCELARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNOVO)
                .addGap(18, 18, 18)
                .addComponent(btnSALVAR, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVOLTAR)
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnCANCELAR, btnVOLTAR});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnNOVO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVOLTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSALVAR))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCANCELAR, btnSALVAR, btnVOLTAR});

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white), "Locatário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Tipo:");

        cbLOCATARIO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbLOCATARIO.setToolTipText("<html><h3>Selecione o Nome do Locatário</h3></html>");
        cbLOCATARIO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        cbLOCATARIO.setEnabled(false);
        cbLOCATARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLOCATARIOActionPerformed(evt);
            }
        });
        cbLOCATARIO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbLOCATARIOKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Nome do Locatário:");

        txtTIPO.setEditable(false);
        txtTIPO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTIPO.setText(" ");
        txtTIPO.setToolTipText("<html><h3>Tipo de Locatário</h3></html>");
        txtTIPO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Série:");

        txtSERIE.setEditable(false);
        txtSERIE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtSERIE.setToolTipText("<html><h3>Série do Aluno</h3></html>");
        txtSERIE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        txtPERIODO.setEditable(false);
        txtPERIODO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPERIODO.setText(" ");
        txtPERIODO.setToolTipText("<html><h3>Período do Aluno</h3></html>");
        txtPERIODO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Período:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbLOCATARIO, 0, 494, Short.MAX_VALUE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtTIPO, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtSERIE, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPERIODO, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel7)
                                .addComponent(jLabel8))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSERIE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(cbLOCATARIO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTIPO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtPERIODO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbLOCATARIO, txtPERIODO, txtSERIE, txtTIPO});

        jPanel4.setBackground(new java.awt.Color(153, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white), "Obra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        txtTOMBO.setEditable(false);
        txtTOMBO.setToolTipText("<html><h3>Nº de Tombo da Obra</h3></html>");
        txtTOMBO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Tombo:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Título da Obra:");

        cbOBRA.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbOBRA.setToolTipText("<html><h3>Selecione a Obra</h3></html>");
        cbOBRA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        cbOBRA.setEnabled(false);
        cbOBRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbOBRAActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Qtd.:");

        txtQTD.setEditable(false);
        txtQTD.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtQTD.setText(" ");
        txtQTD.setToolTipText("<html><h3>Quantidade Emprestada</h3></html>");
        txtQTD.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtQTD.setEnabled(false);

        btnADICIONAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        btnADICIONAR.setToolTipText("<html><h3>Adicionar Item</h3></html>");
        btnADICIONAR.setBorderPainted(false);
        btnADICIONAR.setContentAreaFilled(false);
        btnADICIONAR.setEnabled(false);
        btnADICIONAR.setFocusable(false);
        btnADICIONAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADICIONARActionPerformed(evt);
            }
        });

        btnREMOVER.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/remover.png"))); // NOI18N
        btnREMOVER.setToolTipText("<html><h3>Remover Item</h3></html>");
        btnREMOVER.setBorderPainted(false);
        btnREMOVER.setContentAreaFilled(false);
        btnREMOVER.setEnabled(false);
        btnREMOVER.setFocusable(false);
        btnREMOVER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnREMOVERActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTOMBO, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbOBRA, 0, 563, Short.MAX_VALUE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtQTD, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnADICIONAR, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnREMOVER, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnADICIONAR, btnREMOVER});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTOMBO, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbOBRA, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                        .addComponent(btnADICIONAR, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnREMOVER, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtQTD, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnADICIONAR, btnREMOVER, cbOBRA, txtQTD, txtTOMBO});

        jPanel5.setBackground(new java.awt.Color(153, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white), "Dados do Empréstimo", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Data de Empréstimo:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Data de Devolução:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Itens:");

        jScrollPane1.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        tblITENS.setBackground(new java.awt.Color(204, 255, 204));
        tblITENS.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        tblITENS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblITENS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html><h4>Nº de Tombo</h4></html>  ", "<html><h4>Título</h4></html> ", "<html><h4>Autor</h4></html> ", "<html><h4>Editora</h4></html> ", "<html><h4>Gênero</h4></html> ", "<html><h4>Edição</h4></html> ", "<html><h4>Ano</h4></html> ", "<html><h4>Qtd.</h4></html> "
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
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
        tblITENS.setSelectionBackground(new java.awt.Color(102, 255, 204));
        tblITENS.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblITENS);

        dataDEVOLUCAO.setBackground(new java.awt.Color(255, 255, 255));
        dataDEVOLUCAO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        dataDEVOLUCAO.setToolTipText("<html><h3>Data de Devolução Prevista</h3></html>");
        dataDEVOLUCAO.setEnabled(false);
        dataDEVOLUCAO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        dataEMPRESTIMO.setBackground(new java.awt.Color(255, 255, 255));
        dataEMPRESTIMO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        dataEMPRESTIMO.setToolTipText("<html><h3>Data de Realização do Empréstimo</h3></html>");
        dataEMPRESTIMO.setEnabled(false);
        dataEMPRESTIMO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4)
                    .addComponent(dataDEVOLUCAO, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataEMPRESTIMO, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataEMPRESTIMO, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataDEVOLUCAO, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 79, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSALVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSALVARActionPerformed
        verificarCampos();
    }//GEN-LAST:event_btnSALVARActionPerformed

    private void btnVOLTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVOLTARActionPerformed
        this.hide();
    }//GEN-LAST:event_btnVOLTARActionPerformed

    private void cbLOCATARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLOCATARIOActionPerformed
        if (cbLOCATARIO.getSelectedIndex() > -1) {
            verificarLocatario();
        }
    }//GEN-LAST:event_cbLOCATARIOActionPerformed

    private void cbOBRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbOBRAActionPerformed
        verificarObra();
    }//GEN-LAST:event_cbOBRAActionPerformed

    private void cbLOCATARIOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbLOCATARIOKeyPressed

    }//GEN-LAST:event_cbLOCATARIOKeyPressed

    private void btnADICIONARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADICIONARActionPerformed
        if (cbOBRA.getSelectedItem() == null) {

            JOptionPane.showMessageDialog(null, "<html><h3>Selecione uma Obra!</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);
        } else if (txtQTD.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "<html><h3>Digite a Quantidade!</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        } else {
            adicionarItens();
        }
    }//GEN-LAST:event_btnADICIONARActionPerformed

    private void btnNOVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNOVOActionPerformed
        habilitarCampos();
    }//GEN-LAST:event_btnNOVOActionPerformed

    private void btnCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCANCELARActionPerformed
        desabilitarCampos();
    }//GEN-LAST:event_btnCANCELARActionPerformed

    private void btnREMOVERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnREMOVERActionPerformed
        removerItens();
    }//GEN-LAST:event_btnREMOVERActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_EMPRESTIMO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADICIONAR;
    private javax.swing.JButton btnCANCELAR;
    private javax.swing.JButton btnNOVO;
    private javax.swing.JButton btnREMOVER;
    private javax.swing.JButton btnSALVAR;
    private javax.swing.JButton btnVOLTAR;
    private javax.swing.JComboBox<String> cbLOCATARIO;
    private javax.swing.JComboBox<String> cbOBRA;
    private net.sf.nachocalendar.components.DateField dataDEVOLUCAO;
    private net.sf.nachocalendar.components.DateField dataEMPRESTIMO;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblITENS;
    private javax.swing.JTextField txtPERIODO;
    private javax.swing.JTextField txtQTD;
    private javax.swing.JTextField txtSERIE;
    private javax.swing.JTextField txtTIPO;
    private javax.swing.JTextField txtTOMBO;
    // End of variables declaration//GEN-END:variables

    private void emprestar() {

        Connection con = Conexao.abrirConexao();

        EmprestimoBean eb = new EmprestimoBean();
        EmprestimoDAO ed = new EmprestimoDAO(con);

        //CRIANDO O EMPRÉSTIMO
        eb.setLocatario((String) cbLOCATARIO.getSelectedItem());
        eb.setUsuario(usuario);
        eb.setData_emprestimo(verificarDataEmprestimo());
        eb.setData_dev_prev(verificarDataDevolucaoPrevista());
        eb.setStatus("Em Aberto");

        ed.emprestar(eb);

        //ADICIONANDO OS ITENS
        ItensEmprestimoBean ieb = new ItensEmprestimoBean();
        ItensEmprestimoDAO ied = new ItensEmprestimoDAO(con);

        tblITENS.selectAll();

        Integer linha = tblITENS.getSelectedRow();

        int obra = (Integer) tblITENS.getValueAt(linha, 0);
        String quantidade = String.valueOf(tblITENS.getValueAt(linha, 7));

        DefaultTableModel itens = (DefaultTableModel) tblITENS.getModel();
        tblITENS.setModel(itens);

        for (int i = itens.getRowCount(); i > 0; i--) {

            ieb.setIdEmprestimo(eb.getId());
            ieb.setObra(obra);
            ieb.setQuantidade(Integer.valueOf(quantidade));

            ied.adicionar(ieb);


        }

        desabilitarCampos();

        Conexao.fecharConexao(con);

    }

    private void carregarLOCATARIOS() {
        String sql = "select Nome from LOCATARIO order by Nome";
        Connection con = Conexao.abrirConexao();
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            //LIMPA A COMBO BOX "LOCATARIOS"
            cbLOCATARIO.removeAllItems();
            while (rs.next()) {
                //ADICIONA OS ITENS, ENQUANTO AINDA HÁ ITENS A SEREM ADICIONADOS
                cbLOCATARIO.addItem(rs.getString("Nome"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Locatário!" + ex);
        }
        Conexao.fecharConexao(con);
    }

    private void carregarOBRAS() {

        String sql = "select Titulo from OBRA where disponibilidade = 1 order by Titulo";
        Connection con = Conexao.abrirConexao();
        try {

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            //LIMPA A COMBO BOX "OBRAS"
            cbOBRA.removeAllItems();

            while (rs.next()) {
                //ADICIONA OS ITENS, ENQUANTO AINDA HÁ ITENS A SEREM ADICIONADOS
                cbOBRA.addItem(rs.getString("Titulo"));

            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao preencher Locatário!" + ex);
        }
        Conexao.fecharConexao(con);
    }

    private void verificarLocatario() {
        String locatario = (String) cbLOCATARIO.getSelectedItem();
        Connection con = Conexao.abrirConexao();
        String sql = "select Tipo, Serie, Periodo from locatario"
                + " where Nome ='" + locatario + "'";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                txtTIPO.setText(rs.getString("Tipo"));
                txtSERIE.setText(rs.getString("Serie"));
                txtPERIODO.setText(rs.getString("Periodo"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "<html><font:color = red><h3>Erro ao procurar informações do Locatário<br></h3></font></html>" + ex, "BTK Informa", JOptionPane.ERROR_MESSAGE, erro);
        }
        Conexao.fecharConexao(con);
    }

    private void verificarObra() {
        String obra = (String) cbOBRA.getSelectedItem();
        Connection con = Conexao.abrirConexao();
        String sql = "select id_obra from obra where titulo = '" + obra + "'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                txtTOMBO.setText(String.valueOf(rs.getInt("id_OBRA")));

            } else {
                txtTOMBO.setText("");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao verificar Id_Obra!\n" + "Erro: " + e, "ERRO SQL", JOptionPane.ERROR_MESSAGE);
        }
        Conexao.fecharConexao(con);
    }

    private void adicionarItens() {

        String obra = (String) cbOBRA.getSelectedItem();

        Connection con = Conexao.abrirConexao();
        ItensEmprestimoDAO ied = new ItensEmprestimoDAO(con);

        List<ObraBean> adicionarItens = new ArrayList<>();
        adicionarItens = ied.adicionarItens(obra);

        DefaultTableModel tbm = (DefaultTableModel) tblITENS.getModel();
        tblITENS.setModel(tbm);

        int i = 0;

        for (ObraBean cb : adicionarItens) {

            tbm.addRow(new String[1]);

            tblITENS.setValueAt(cb.getID(), i, 0);
            tblITENS.setValueAt(cb.getTitulo_OBRA(), i, 1);
            tblITENS.setValueAt(cb.getAutor(), i, 2);
            tblITENS.setValueAt(cb.getEditora_OBRA(), i, 3);
            tblITENS.setValueAt(cb.getGenero(), i, 4);
            tblITENS.setValueAt(cb.getEdicao(), i, 5);
            tblITENS.setValueAt(cb.getAno(), i, 6);
            tblITENS.setValueAt(txtQTD.getText(), i, 7);

            i++;

        }

        Conexao.fecharConexao(con);

    }

    private void removerItens() {
        if (tblITENS.getRowCount() == 0) {

            JOptionPane.showMessageDialog(null, "<html><h3>Não há Itens no Empréstimo!</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);
        } else {
            DefaultTableModel tbm = (DefaultTableModel) tblITENS.getModel();
            tblITENS.selectAll();
            tbm.removeRow(tblITENS.getSelectedRow());
        }

    }

    private Date verificarDataEmprestimo() {
        java.util.Date d = (java.util.Date) dataEMPRESTIMO.getValue();
        java.sql.Date data = new java.sql.Date(d.getTime());

        SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
        data = Date.valueOf(formatarData.format(data));

        return data;

    }

    //*
    // Verifica a Data Prevista para Devolução da Obra ao acervo.
    private Date verificarDataDevolucaoPrevista() {

        java.util.Date d = (java.util.Date) dataDEVOLUCAO.getValue();
        java.sql.Date data = new java.sql.Date(d.getTime());

        SimpleDateFormat formatarData = new SimpleDateFormat("yyyy-MM-dd");
        data = Date.valueOf(formatarData.format(data));

        return data;

    }

    private void setarDatas() {

        Date data = new Date(System.currentTimeMillis());
        SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
        dataEMPRESTIMO.setValue(data);

        data.setDate(data.getDate() + 7);

        dataDEVOLUCAO.setValue(data);

    }

    private void limparCampos() {
        cbLOCATARIO.setSelectedItem(null);
        cbLOCATARIO.setSelectedIndex(-1);
        cbOBRA.setSelectedItem(null);
        cbOBRA.setSelectedIndex(-1);

        txtPERIODO.setText("");
        txtSERIE.setText("");
        txtTIPO.setText("");

        dataEMPRESTIMO.setValue(null);
        dataDEVOLUCAO.setValue(null);
        txtTOMBO.setText("");
        txtQTD.setText("");
        
        DefaultTableModel itens = (DefaultTableModel) tblITENS.getModel();
        itens.setNumRows(0);

    }

    private void habilitarCampos() {
        setarDatas();
        cbLOCATARIO.setEnabled(true);
        cbLOCATARIO.setEditable(true);
        cbOBRA.setEnabled(true);
        cbOBRA.setEditable(true);

        txtQTD.setEnabled(true);
        txtQTD.setEditable(true);
        btnADICIONAR.setEnabled(true);
        btnREMOVER.setEnabled(true);
        btnSALVAR.setEnabled(true);
        btnCANCELAR.setEnabled(true);
        dataEMPRESTIMO.setEnabled(true);
        dataDEVOLUCAO.setEnabled(true);
        cbLOCATARIO.grabFocus();
    }

    private void desabilitarCampos() {
        cbLOCATARIO.setEnabled(false);
        cbLOCATARIO.setEditable(false);
        cbOBRA.setEnabled(false);
        cbOBRA.setEditable(false);

        txtQTD.setEnabled(false);
        txtQTD.setEditable(false);
        btnADICIONAR.setEnabled(false);
        btnREMOVER.setEnabled(false);
        btnSALVAR.setEnabled(false);
        btnCANCELAR.setEnabled(false);
        dataDEVOLUCAO.setEnabled(false);
        dataEMPRESTIMO.setEnabled(false);
        limparCampos();

    }

    private void verificarCampos() {
        if (cbLOCATARIO.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "<html><h3>Selecione um Locatário!</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        } else if (tblITENS.getRowCount() == 0) {

            JOptionPane.showMessageDialog(null, "<html><h3>Não há itens adicionados!</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        } else {

            emprestar();
        }
    }

}
