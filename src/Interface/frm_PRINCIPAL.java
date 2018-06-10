package Interface;

import Beans.ObraBean;
import DAO.Conexao;
import DAO.ObraDAO;
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
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class frm_PRINCIPAL extends javax.swing.JFrame {

    String login = "";
    String nome = "";
    private final Icon atencao = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/atencao.png")));
    private final Icon questao = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/questao.png")));

    public frm_PRINCIPAL(String login, String nome) {

        initComponents();
        this.login = login;
        this.nome = nome;
        verificaUsuario(login);
        Icon figura = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/bemVindo.png")));
        tblACERVO.setFillsViewportHeight(true);

        JOptionPane.showMessageDialog(null, "<html><h2>Bem-Vindo ao BTK, " + nome + "!!</h2></html>", "Boas-Vindas", JOptionPane.PLAIN_MESSAGE, figura);
//        this.getContentPane().setBackground(Color.white);
        pesquisarObra();

        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        txtBUSCAR.grabFocus();

        //SETA O ICONE DO SISTEMA
        URL url = this.getClass().getResource("/Imagens/icone.png");
        Image logo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(logo);

        lblLOGO.setHorizontalAlignment(SwingConstants.CENTER);
    }

    public frm_PRINCIPAL() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        tblACERVO.setFillsViewportHeight(true);
        URL url = this.getClass().getResource("/Imagens/icone.png");
        Image logo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(logo);
        lblLOGO.setHorizontalAlignment(SwingConstants.CENTER);
        btnUSUARIO.setEnabled(true);
        btnBACKUP.setEnabled(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jPopupMenu3 = new javax.swing.JPopupMenu();
        jFrame1 = new javax.swing.JFrame();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        btngPESQUISA = new javax.swing.ButtonGroup();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtBUSCAR = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblACERVO = new javax.swing.JTable();
        btnBUSCAR = new javax.swing.JButton();
        btnSAIR = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        rdbtnCODIGO = new javax.swing.JRadioButton();
        rdbtnGENERO = new javax.swing.JRadioButton();
        rdbtnTITULO = new javax.swing.JRadioButton();
        rdbtnAUTOR = new javax.swing.JRadioButton();
        rdbtnLOCALIZACAO = new javax.swing.JRadioButton();
        rdbtnEDITORA = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblLOGO = new javax.swing.JLabel();
        btnEDITAR = new javax.swing.JButton();
        btnTROCARUS = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnEMPRESTIMO = new javax.swing.JButton();
        btnDEVOLUCAO = new javax.swing.JButton();
        btnLOCATARIO = new javax.swing.JButton();
        btnUSUARIO = new javax.swing.JButton();
        btnRELATORIOS = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        btnATRASOS = new javax.swing.JButton();
        btnBACKUP = new javax.swing.JButton();
        btnOBRAS = new javax.swing.JButton();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BTK - Sistema Bibliotecário");
        setUndecorated(true);
        setResizable(false);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));

        jPanel6.setBackground(new java.awt.Color(153, 255, 204));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        jPanel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        txtBUSCAR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtBUSCAR.setToolTipText("");
        txtBUSCAR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        jScrollPane3.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        jScrollPane3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tblACERVO.setBackground(new java.awt.Color(204, 255, 204));
        tblACERVO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblACERVO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html><h3>Nº de Tombo</h3></html>  ", "<html><h3>Data de Entrada</h3></html> ", "<html><h3>Título</h3></html> ", "<html><h3>Autor</h3></html> ", "<html><h3>Gênero</h3></html>", "<html><h3>Editora</h3></html>", "<html><h3>Edição</h3></html> ", "<html><h3>Ano</h3></html>", "<html><h3>Localização</h3></html>   ", "<html><h3>Qtd.</h3></html> ", "<html><h3>Status</h3></html>"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblACERVO.setToolTipText("<html><h3>Obras do Acervo</h3></html>");
        tblACERVO.setFocusable(false);
        tblACERVO.setGridColor(new java.awt.Color(255, 255, 255));
        tblACERVO.setSelectionBackground(new java.awt.Color(153, 255, 204));
        tblACERVO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblACERVOMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblACERVO);
        if (tblACERVO.getColumnModel().getColumnCount() > 0) {
            tblACERVO.getColumnModel().getColumn(6).setPreferredWidth(5);
        }

        btnBUSCAR.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnBUSCAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/buscar.png"))); // NOI18N
        btnBUSCAR.setToolTipText("<html><h3>Buscar Obras</h3></html>");
        btnBUSCAR.setBorderPainted(false);
        btnBUSCAR.setContentAreaFilled(false);
        btnBUSCAR.setFocusable(false);
        btnBUSCAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBUSCARActionPerformed(evt);
            }
        });

        btnSAIR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSAIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sairDoSistema.png"))); // NOI18N
        btnSAIR.setToolTipText("<html><h3>Sair do Sistema</h3></html>");
        btnSAIR.setBorderPainted(false);
        btnSAIR.setContentAreaFilled(false);
        btnSAIR.setFocusable(false);
        btnSAIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSAIRActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(153, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white), "Filtrar Por", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel7.setToolTipText("<html><h3>Filtros de Pesquisa</h3></html>");

        rdbtnCODIGO.setBackground(new java.awt.Color(153, 255, 204));
        btngPESQUISA.add(rdbtnCODIGO);
        rdbtnCODIGO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rdbtnCODIGO.setText("Tombo");
        rdbtnCODIGO.setToolTipText("<html><h3>Realizar Busca por Tombo</h3></html>");
        rdbtnCODIGO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        rdbtnCODIGO.setFocusable(false);

        rdbtnGENERO.setBackground(new java.awt.Color(153, 255, 204));
        btngPESQUISA.add(rdbtnGENERO);
        rdbtnGENERO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rdbtnGENERO.setText("Gênero");
        rdbtnGENERO.setToolTipText("<html><h3>Realizar Busca por Gênero</h3></html>");
        rdbtnGENERO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        rdbtnGENERO.setFocusable(false);

        rdbtnTITULO.setBackground(new java.awt.Color(153, 255, 204));
        btngPESQUISA.add(rdbtnTITULO);
        rdbtnTITULO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rdbtnTITULO.setText("Título");
        rdbtnTITULO.setToolTipText("<html><h3>Realizar Busca por título</h3></html>");
        rdbtnTITULO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        rdbtnTITULO.setFocusable(false);

        rdbtnAUTOR.setBackground(new java.awt.Color(153, 255, 204));
        btngPESQUISA.add(rdbtnAUTOR);
        rdbtnAUTOR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rdbtnAUTOR.setText("Autor");
        rdbtnAUTOR.setToolTipText("<html><h3>Realizar Busca por Autor</h3></html>");
        rdbtnAUTOR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        rdbtnAUTOR.setFocusable(false);

        rdbtnLOCALIZACAO.setBackground(new java.awt.Color(153, 255, 204));
        btngPESQUISA.add(rdbtnLOCALIZACAO);
        rdbtnLOCALIZACAO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rdbtnLOCALIZACAO.setText("Localização");
        rdbtnLOCALIZACAO.setToolTipText("<html><h3>Realizar Busca por Localização</h3></html>");
        rdbtnLOCALIZACAO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        rdbtnLOCALIZACAO.setFocusable(false);

        rdbtnEDITORA.setBackground(new java.awt.Color(153, 255, 204));
        btngPESQUISA.add(rdbtnEDITORA);
        rdbtnEDITORA.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        rdbtnEDITORA.setText("Editora");
        rdbtnEDITORA.setToolTipText("<html><h3>Realizar Busca por Editora</h3></html>");
        rdbtnEDITORA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        rdbtnEDITORA.setFocusable(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbtnCODIGO)
                    .addComponent(rdbtnGENERO))
                .addGap(176, 176, 176)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbtnTITULO)
                    .addComponent(rdbtnAUTOR))
                .addGap(149, 149, 149)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rdbtnLOCALIZACAO)
                    .addComponent(rdbtnEDITORA))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(rdbtnTITULO)
                        .addGap(27, 27, 27)
                        .addComponent(rdbtnAUTOR))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdbtnCODIGO)
                            .addComponent(rdbtnLOCALIZACAO))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rdbtnGENERO, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rdbtnEDITORA, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(153, 255, 204));

        lblLOGO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/logo.png"))); // NOI18N
        lblLOGO.setToolTipText("<html><h3>BTK - Sistema Bibliotecário</h3></html>");
        lblLOGO.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLOGO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblLOGO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnEDITAR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEDITAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/visualizar.png"))); // NOI18N
        btnEDITAR.setToolTipText("<html><h3>Visualizar Obra</h3></html>");
        btnEDITAR.setBorderPainted(false);
        btnEDITAR.setContentAreaFilled(false);
        btnEDITAR.setEnabled(false);
        btnEDITAR.setFocusable(false);
        btnEDITAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEDITARActionPerformed(evt);
            }
        });

        btnTROCARUS.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnTROCARUS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/trocarUsuario.png"))); // NOI18N
        btnTROCARUS.setToolTipText("<html><h3>Alternar Usuário</h3></html>");
        btnTROCARUS.setBorderPainted(false);
        btnTROCARUS.setContentAreaFilled(false);
        btnTROCARUS.setFocusable(false);
        btnTROCARUS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTROCARUSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnTROCARUS, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSAIR, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(txtBUSCAR, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBUSCAR))
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnBUSCAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBUSCAR)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSAIR, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEDITAR, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTROCARUS, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        btnEMPRESTIMO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/emprestimo.png"))); // NOI18N
        btnEMPRESTIMO.setToolTipText("<html><h3>Realizar Empréstimo</h3></html>");
        btnEMPRESTIMO.setBorderPainted(false);
        btnEMPRESTIMO.setContentAreaFilled(false);
        btnEMPRESTIMO.setDefaultCapable(false);
        btnEMPRESTIMO.setFocusable(false);
        btnEMPRESTIMO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEMPRESTIMOActionPerformed(evt);
            }
        });

        btnDEVOLUCAO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/devolucao.png"))); // NOI18N
        btnDEVOLUCAO.setToolTipText("<html><h3>Realizar Devolução</h3></html>");
        btnDEVOLUCAO.setBorderPainted(false);
        btnDEVOLUCAO.setContentAreaFilled(false);
        btnDEVOLUCAO.setFocusable(false);
        btnDEVOLUCAO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDEVOLUCAOActionPerformed(evt);
            }
        });

        btnLOCATARIO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnLOCATARIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/gerenciarLoctario.png"))); // NOI18N
        btnLOCATARIO.setToolTipText("<html><h3>Gerenciar Locatários</h3></html>");
        btnLOCATARIO.setBorderPainted(false);
        btnLOCATARIO.setContentAreaFilled(false);
        btnLOCATARIO.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLOCATARIO.setFocusable(false);
        btnLOCATARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLOCATARIOActionPerformed(evt);
            }
        });

        btnUSUARIO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/gerenciarUsuarios.png"))); // NOI18N
        btnUSUARIO.setToolTipText("<html><h3>Gerenciar Usuários</h3></html>");
        btnUSUARIO.setBorderPainted(false);
        btnUSUARIO.setContentAreaFilled(false);
        btnUSUARIO.setEnabled(false);
        btnUSUARIO.setFocusable(false);
        btnUSUARIO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUSUARIOActionPerformed(evt);
            }
        });

        btnRELATORIOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/relatorios.png"))); // NOI18N
        btnRELATORIOS.setToolTipText("<html><h3>Gerenciar Relatórios do Sistema</h3></html>");
        btnRELATORIOS.setBorderPainted(false);
        btnRELATORIOS.setContentAreaFilled(false);
        btnRELATORIOS.setFocusable(false);
        btnRELATORIOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRELATORIOSActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/sobre.png"))); // NOI18N
        jButton7.setToolTipText("<html><h3>Sobre BTK</h3></html>");
        jButton7.setBorderPainted(false);
        jButton7.setContentAreaFilled(false);
        jButton7.setFocusable(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        btnATRASOS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/atrasos.png"))); // NOI18N
        btnATRASOS.setToolTipText("<html><h3>Visualizar Atrasos</h3></html>");
        btnATRASOS.setBorderPainted(false);
        btnATRASOS.setContentAreaFilled(false);
        btnATRASOS.setFocusable(false);
        btnATRASOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnATRASOSActionPerformed(evt);
            }
        });

        btnBACKUP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/backup.png"))); // NOI18N
        btnBACKUP.setToolTipText("<html><h3>Gerenciar Backup do Sistema</h3></html>");
        btnBACKUP.setBorderPainted(false);
        btnBACKUP.setContentAreaFilled(false);
        btnBACKUP.setEnabled(false);
        btnBACKUP.setFocusable(false);
        btnBACKUP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBACKUPActionPerformed(evt);
            }
        });

        btnOBRAS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/obra.png"))); // NOI18N
        btnOBRAS.setToolTipText("<html><h3>Gerenciar Obras</h3></html>");
        btnOBRAS.setBorderPainted(false);
        btnOBRAS.setContentAreaFilled(false);
        btnOBRAS.setFocusable(false);
        btnOBRAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOBRASActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(btnEMPRESTIMO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDEVOLUCAO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnATRASOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnOBRAS, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnLOCATARIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnUSUARIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnRELATORIOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(btnBACKUP, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnEMPRESTIMO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnDEVOLUCAO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnLOCATARIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnUSUARIO, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnRELATORIOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnATRASOS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnBACKUP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(btnOBRAS, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tblACERVOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblACERVOMouseClicked
        if (tblACERVO.getRowCount() == 0) {

            JOptionPane.showMessageDialog(null, "<html><h3>Não Há Valores Cadastrados!</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        } else {
            btnEDITAR.setEnabled(true);

        }
    }//GEN-LAST:event_tblACERVOMouseClicked

    private void btnBUSCARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBUSCARActionPerformed
        pesquisarObra();
        limparCampos();
    }//GEN-LAST:event_btnBUSCARActionPerformed

    private void btnSAIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSAIRActionPerformed
        Object[] opcoes = {"Sim", "Não"};

        int i = JOptionPane.showOptionDialog(null,
                "<html><h3>Deseja realmente sair do Sistema? <br>"
                + "</h3></html>",
                "Sair", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, questao,
                opcoes, opcoes[0]);

        if (i == JOptionPane.YES_OPTION) {

            System.exit(0);
        }

    }//GEN-LAST:event_btnSAIRActionPerformed

    private void btnLOCATARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLOCATARIOActionPerformed
        JFrame locatario = new frm_LOCATARIOS();
        locatario.setVisible(true);
    }//GEN-LAST:event_btnLOCATARIOActionPerformed

    private void btnUSUARIOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUSUARIOActionPerformed
        JFrame usuario = new frm_USUARIOS();
        usuario.setVisible(true);

    }//GEN-LAST:event_btnUSUARIOActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JFrame sobre = new frm_SOBRE();
        sobre.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void btnBACKUPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBACKUPActionPerformed
        JFrame backup = new frm_BACKUP();
        backup.setVisible(true);
    }//GEN-LAST:event_btnBACKUPActionPerformed

    private void btnEMPRESTIMOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEMPRESTIMOActionPerformed
        JFrame emprestimo = new frm_EMPRESTIMO(nome);
        emprestimo.setExtendedState(MAXIMIZED_BOTH);
        emprestimo.setVisible(true);
    }//GEN-LAST:event_btnEMPRESTIMOActionPerformed

    private void btnATRASOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnATRASOSActionPerformed
        JFrame atraso = new frm_ATRASOS();
        atraso.setExtendedState(MAXIMIZED_BOTH);
        atraso.setVisible(true);
    }//GEN-LAST:event_btnATRASOSActionPerformed

    private void btnDEVOLUCAOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDEVOLUCAOActionPerformed
        JFrame devolucao = new frm_DEVOLUCAO();
        devolucao.setExtendedState(MAXIMIZED_BOTH);
        devolucao.setVisible(true);
    }//GEN-LAST:event_btnDEVOLUCAOActionPerformed

    private void btnRELATORIOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRELATORIOSActionPerformed
        JFrame relatorios = new frm_RELATORIOS();
        relatorios.setVisible(true);
    }//GEN-LAST:event_btnRELATORIOSActionPerformed

    private void btnOBRASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOBRASActionPerformed
        JFrame obra = new frm_OBRAS();
        obra.setVisible(true);
    }//GEN-LAST:event_btnOBRASActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus

    }//GEN-LAST:event_formWindowGainedFocus

    private void btnEDITARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEDITARActionPerformed
        alterar();
    }//GEN-LAST:event_btnEDITARActionPerformed

    private void btnTROCARUSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTROCARUSActionPerformed
        Object[] opcoes = {"Sim", "Não"};

        int i = JOptionPane.showOptionDialog(null,
                "<html><h3>Deseja realmente alternar o Usuário? <br>"
                + "</h3></html>",
                "Alternar Usuário", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, questao,
                opcoes, opcoes[0]);

        if (i == JOptionPane.YES_OPTION) {
            JFrame login = new frm_LOGIN();
            this.dispose();
            login.setVisible(true);
        }
    }//GEN-LAST:event_btnTROCARUSActionPerformed

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
            @Override
            public void run() {
                JFrame principal = new frm_PRINCIPAL();
                principal.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnATRASOS;
    private javax.swing.JButton btnBACKUP;
    private javax.swing.JButton btnBUSCAR;
    private javax.swing.JButton btnDEVOLUCAO;
    private javax.swing.JButton btnEDITAR;
    private javax.swing.JButton btnEMPRESTIMO;
    private javax.swing.JButton btnLOCATARIO;
    private javax.swing.JButton btnOBRAS;
    private javax.swing.JButton btnRELATORIOS;
    private javax.swing.JButton btnSAIR;
    private javax.swing.JButton btnTROCARUS;
    private javax.swing.JButton btnUSUARIO;
    private javax.swing.ButtonGroup btngPESQUISA;
    private javax.swing.JButton jButton7;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JPopupMenu jPopupMenu3;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JLabel lblLOGO;
    private javax.swing.JRadioButton rdbtnAUTOR;
    private javax.swing.JRadioButton rdbtnCODIGO;
    private javax.swing.JRadioButton rdbtnEDITORA;
    private javax.swing.JRadioButton rdbtnGENERO;
    private javax.swing.JRadioButton rdbtnLOCALIZACAO;
    private javax.swing.JRadioButton rdbtnTITULO;
    private javax.swing.JTable tblACERVO;
    private javax.swing.JTextField txtBUSCAR;
    // End of variables declaration//GEN-END:variables

    /**
     * Realiza a Pesquisa no Banco, de acordo com a Radio Button selecionada
     * pelo usuário.
     *
     *
     */
    public void pesquisarObra() {
        Connection con = Conexao.abrirConexao();
        ObraDAO cd = new ObraDAO(con);

        List<ObraBean> listaObra = new ArrayList<>();
        if (rdbtnCODIGO.isSelected() == true) {

            String tombo = txtBUSCAR.getText();
            listaObra = cd.listarPorCodigo(tombo);

        } else if (rdbtnAUTOR.isSelected() == true) {
            String autor = txtBUSCAR.getText();
            listaObra = cd.listarPorAutor(autor);

        } else if (rdbtnTITULO.isSelected() == true) {
            String titulo = txtBUSCAR.getText();
            listaObra = cd.listarPorTitulo(titulo);

        } else if (rdbtnGENERO.isSelected() == true) {
            String genero = txtBUSCAR.getText();
            listaObra = cd.listarPorGenero(genero);

        } else if (rdbtnLOCALIZACAO.isSelected() == true) {
            String localizacao = txtBUSCAR.getText();
            listaObra = cd.listarPorLocalizacao(localizacao);

        } else if (rdbtnEDITORA.isSelected() == true) {
            String editora = txtBUSCAR.getText();
            listaObra = cd.listarPorEditora(editora);

        } else {

            listaObra = cd.listarTodos();

        }
        limparCampos();

        DefaultTableModel acervo = (DefaultTableModel) tblACERVO.getModel();

        tblACERVO.setModel(acervo);

        for (int i = acervo.getRowCount() - 1; i >= 0; i--) {

            acervo.removeRow(i);
        }

        int i = 0;

        for (ObraBean cb : listaObra) {
            acervo.addRow(new String[1]);

            tblACERVO.setValueAt(cb.getID(), i, 0);
            tblACERVO.setValueAt(formatarData(cb.getData()), i, 1);
            tblACERVO.setValueAt(cb.getTitulo_OBRA(), i, 2);
            tblACERVO.setValueAt(cb.getAutor(), i, 3);
            tblACERVO.setValueAt(cb.getGenero(), i, 4);
            tblACERVO.setValueAt(cb.getEditora_OBRA(), i, 5);
            tblACERVO.setValueAt(cb.getEdicao(), i, 6);
            tblACERVO.setValueAt(cb.getAno(), i, 7);
            tblACERVO.setValueAt(cb.getLocalizacao(), i, 8);
            tblACERVO.setValueAt(cb.getQuantidade_OBRA(), i, 9);
            tblACERVO.setValueAt(verificaDisponibilidade(cb.isDisponibilidade()), i, 10);

            i++;

        }

        Conexao.fecharConexao(con);
    }

    /**
     * Verifica a disponibilidade da Obra e, a partir disso, retorna o valor em
     * String correspondente.
     *
     *
     */
    private String verificaDisponibilidade(Boolean disp) {
        if (disp.equals(true)) {

            return "<html><font:color = green><b>Disponível</b></font></html>";
        } else {

            return "<html><font:color = red><b>Indisponível</b></font></html>";
        }

    }

    /**
     * Instancia os valores da Obra para a tela de Gerenciamento de Obras String
     * correspondente.
     *
     *
     */
    private void alterar() {

        Integer linha = tblACERVO.getSelectedRow();
        String tombo = String.valueOf(tblACERVO.getValueAt(linha, 0));
        String titulo = (String) tblACERVO.getValueAt(linha, 2);
        String autor = (String) tblACERVO.getValueAt(linha, 3);
        String genero = (String) tblACERVO.getValueAt(linha, 4);
        String editora = (String) tblACERVO.getValueAt(linha, 5);
        String edicao = (String) tblACERVO.getValueAt(linha, 6);
        String ano = (String) tblACERVO.getValueAt(linha, 7);
        String localizacao = (String) tblACERVO.getValueAt(linha, 8);
        String quantidade = String.valueOf(tblACERVO.getValueAt(linha, 9));

        JFrame obra = new frm_OBRAS(tombo, titulo, autor, editora, edicao, ano, genero, quantidade, localizacao);
        obra.setVisible(true);
    }
//String tombo, String titulo, String autor, String editora, String edicao, String ano, String genero, int qtd, String localizacao

    /**
     * Verifica se o usuário é "Administrador". Caso seja, ele tem acesso as
     * funcionalidades de cadastro de novo Usuário e de Backup.
     *
     *
     */
    private void verificaUsuario(String login) {
        if (login.equals("admin")) {
            btnUSUARIO.setEnabled(true);
            btnBACKUP.setEnabled(true);
        }

    }

    private String formatarData(Date data) {
        String dataFormatada;
        SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy");
        dataFormatada = formatarData.format(data);

        return dataFormatada;

    }

    private void limparCampos() {
        txtBUSCAR.setText("");
        btngPESQUISA.clearSelection();

    }

 
}
