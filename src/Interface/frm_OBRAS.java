package Interface;

import Beans.GeneroBean;
//import com.sun.glass.events.KeyEvent;
import DAO.Conexao;
import DAO.ObraDAO;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import Beans.ObraBean;
import DAO.GeneroDAO;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class frm_OBRAS extends javax.swing.JFrame {

    private ObraBean ob = new ObraBean();
    private ArrayList autor = new ArrayList();
    private String tombo = "";
    private String titulo = "";
    private String auto = "";
    private String editora = "";
    private String edicao = "";
    private String ano = "";
    private String genero = "";
    private String localizacao = "";
    private String qtd = "";
    private String sql;
    private final Icon erro = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/erro.png")));
    private final Icon atencao = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/atencao.png")));
    private final Icon questao = new ImageIcon(getToolkit().createImage(getClass().getResource("/Imagens/questao.png")));
    private frm_PRINCIPAL principal;

    public frm_OBRAS(String tombo, String titulo, String autor, String editora, String edicao, String ano, String genero, String qtd, String localizacao) {
        preecherCampos();
        habilitaCampos();
        this.tombo = tombo;
        this.titulo = titulo;
        this.auto = autor;
        this.editora = editora;
        this.edicao = edicao;
        this.ano = ano;
        this.genero = genero;
        this.qtd = qtd;
        this.localizacao = localizacao;
        btnNOVO.setEnabled(false);
        btnSALVAR.setEnabled(false);
        btnALTERAR.setEnabled(true);
        btnEXCLUIR.setEnabled(true);
        setarAlteracao();

        //SETA O ICONE DO SISTEMA
        URL url = this.getClass().getResource("/Imagens/icone.png");
        Image logo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(logo);
    }

    public frm_OBRAS() {
        preecherCampos();
        setAlwaysOnTop(true);

        //SETA O ICONE DO SISTEMA
        URL url = this.getClass().getResource("/Imagens/icone.png");
        Image logo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(logo);

    }

    //CARREGA AS INFORMAÇÕES DO BANCO E FAZ A SUGESTÃO AO USUÁRIO
    private void sugestao() {

        try {
            Connection con = Conexao.abrirConexao();
            sql = "select *from autor";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            rs.first();
            while (rs.next()) {
                autor.add(rs.getString("Nome"));
            }

        } catch (SQLException ex) {
            setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao conectar-se ao Banco de Dados! \n" + ex + "</h3></html>", "ERRO", JOptionPane.ERROR_MESSAGE, erro);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ifrm_GENERO = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtDESCRICAOG = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btnEXCLUIRG = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGENERO = new javax.swing.JTable();
        btnNOVOG = new javax.swing.JButton();
        btnSALVARG = new javax.swing.JButton();
        btnALTERARG = new javax.swing.JButton();
        btnVOLTARG = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnNOVO = new javax.swing.JButton();
        btnSALVAR = new javax.swing.JButton();
        btnCANCELAR = new javax.swing.JButton();
        btnVOLTAR = new javax.swing.JButton();
        btnALTERAR = new javax.swing.JButton();
        btnEXCLUIR = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtTITULO = new javax.swing.JTextField();
        cbGENERO = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCODIGO = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDESCRICAO = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();
        txtEDITORA = new javax.swing.JTextField();
        txtQUANTIDADE = new javax.swing.JTextField();
        txtAUTOR = new javax.swing.JTextField();
        txtESTANTE = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnADDGENERO = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtEDICAO = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txtANO = new javax.swing.JFormattedTextField();
        txtPRATELEIRA = new javax.swing.JTextField();

        ifrm_GENERO.setTitle("Gerenciar Gênero");
        ifrm_GENERO.setResizable(false);

        jPanel2.setBackground(new java.awt.Color(204, 255, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white), "Gênero", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel2.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jPanel2ComponentAdded(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(153, 255, 204));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setText("Descrição*:");

        txtDESCRICAOG.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        txtDESCRICAOG.setEnabled(false);
        txtDESCRICAOG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDESCRICAOGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtDESCRICAOG)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(txtDESCRICAOG))
                .addContainerGap())
        );

        jPanel6.setBackground(new java.awt.Color(153, 255, 204));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        btnEXCLUIRG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEXCLUIRG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/deletarGenero.png"))); // NOI18N
        btnEXCLUIRG.setToolTipText("<html><h3>Excluir Dados</h3></html>");
        btnEXCLUIRG.setBorderPainted(false);
        btnEXCLUIRG.setContentAreaFilled(false);
        btnEXCLUIRG.setEnabled(false);
        btnEXCLUIRG.setFocusable(false);
        btnEXCLUIRG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXCLUIRGActionPerformed(evt);
            }
        });

        jScrollPane3.setBackground(new java.awt.Color(204, 255, 204));
        jScrollPane3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jScrollPane3.setToolTipText("");
        jScrollPane3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        tblGENERO.setBackground(new java.awt.Color(204, 255, 204));
        tblGENERO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        tblGENERO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        tblGENERO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "<html><h4>ID</h4></html>", "<html><h4>Descrição</h4></html>"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGENERO.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblGENERO.setFocusable(false);
        tblGENERO.setGridColor(new java.awt.Color(255, 255, 255));
        tblGENERO.setSelectionBackground(new java.awt.Color(153, 255, 204));
        tblGENERO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGENEROMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblGENERO);

        btnNOVOG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnNOVOG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        btnNOVOG.setToolTipText("<html><h3>Cadastrar Novo Gênero</h3></html>");
        btnNOVOG.setBorderPainted(false);
        btnNOVOG.setContentAreaFilled(false);
        btnNOVOG.setFocusable(false);
        btnNOVOG.setPreferredSize(new java.awt.Dimension(59, 59));
        btnNOVOG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNOVOGActionPerformed(evt);
            }
        });

        btnSALVARG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnSALVARG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvarGenero.png"))); // NOI18N
        btnSALVARG.setToolTipText("<html><h3>Salvar Dados</h3></html>");
        btnSALVARG.setBorderPainted(false);
        btnSALVARG.setContentAreaFilled(false);
        btnSALVARG.setEnabled(false);
        btnSALVARG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSALVARGActionPerformed(evt);
            }
        });

        btnALTERARG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnALTERARG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/alterarGenero.png"))); // NOI18N
        btnALTERARG.setToolTipText("<html><h3> Alterar Dados </h3></html>");
        btnALTERARG.setBorderPainted(false);
        btnALTERARG.setContentAreaFilled(false);
        btnALTERARG.setEnabled(false);
        btnALTERARG.setFocusable(false);
        btnALTERARG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALTERARGActionPerformed(evt);
            }
        });

        btnVOLTARG.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnVOLTARG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/voltarGenero.png"))); // NOI18N
        btnVOLTARG.setToolTipText("<html><h3>Retornar à Tela de Obras</h3></html>");
        btnVOLTARG.setBorderPainted(false);
        btnVOLTARG.setContentAreaFilled(false);
        btnVOLTARG.setFocusable(false);
        btnVOLTARG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVOLTARGActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnNOVOG, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSALVARG, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(btnALTERARG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEXCLUIRG)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVOLTARG)))
                .addContainerGap())
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnALTERARG, btnEXCLUIRG, btnNOVOG, btnSALVARG});

        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVOLTARG)
                    .addComponent(btnEXCLUIRG)
                    .addComponent(btnALTERARG, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSALVARG, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnNOVOG, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnALTERARG, btnEXCLUIRG, btnNOVOG, btnSALVARG});

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout ifrm_GENEROLayout = new javax.swing.GroupLayout(ifrm_GENERO.getContentPane());
        ifrm_GENERO.getContentPane().setLayout(ifrm_GENEROLayout);
        ifrm_GENEROLayout.setHorizontalGroup(
            ifrm_GENEROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ifrm_GENEROLayout.setVerticalGroup(
            ifrm_GENEROLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Gerenciar Obras");
        setAlwaysOnTop(true);
        setUndecorated(true);
        setResizable(false);

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black));

        jPanel3.setBackground(new java.awt.Color(153, 255, 204));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        btnNOVO.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNOVO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/addLivro.png"))); // NOI18N
        btnNOVO.setToolTipText("<html><h3>Cadastrar Nova Obra</h3></html>");
        btnNOVO.setBorderPainted(false);
        btnNOVO.setContentAreaFilled(false);
        btnNOVO.setFocusable(false);
        btnNOVO.setMaximumSize(new java.awt.Dimension(71, 25));
        btnNOVO.setMinimumSize(new java.awt.Dimension(71, 25));
        btnNOVO.setPreferredSize(new java.awt.Dimension(71, 25));
        btnNOVO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNOVOActionPerformed(evt);
            }
        });

        btnSALVAR.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSALVAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/salvar.png"))); // NOI18N
        btnSALVAR.setToolTipText("<html><h3>Salvar Dados</h3></html>");
        btnSALVAR.setBorderPainted(false);
        btnSALVAR.setContentAreaFilled(false);
        btnSALVAR.setEnabled(false);
        btnSALVAR.setFocusable(false);
        btnSALVAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSALVARMouseClicked(evt);
            }
        });
        btnSALVAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSALVARActionPerformed(evt);
            }
        });
        btnSALVAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnSALVARKeyPressed(evt);
            }
        });

        btnCANCELAR.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCANCELAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/fechar.png"))); // NOI18N
        btnCANCELAR.setToolTipText("<html><h3>Cancelar</h3></html>");
        btnCANCELAR.setBorderPainted(false);
        btnCANCELAR.setContentAreaFilled(false);
        btnCANCELAR.setEnabled(false);
        btnCANCELAR.setFocusable(false);
        btnCANCELAR.setMaximumSize(new java.awt.Dimension(71, 25));
        btnCANCELAR.setMinimumSize(new java.awt.Dimension(71, 25));
        btnCANCELAR.setPreferredSize(new java.awt.Dimension(71, 25));
        btnCANCELAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCANCELARActionPerformed(evt);
            }
        });

        btnVOLTAR.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnVOLTAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/voltar.png"))); // NOI18N
        btnVOLTAR.setToolTipText("<html><h3>Retornar à Tela Principal</h3></html>");
        btnVOLTAR.setBorderPainted(false);
        btnVOLTAR.setContentAreaFilled(false);
        btnVOLTAR.setFocusable(false);
        btnVOLTAR.setMaximumSize(new java.awt.Dimension(71, 25));
        btnVOLTAR.setMinimumSize(new java.awt.Dimension(71, 25));
        btnVOLTAR.setPreferredSize(new java.awt.Dimension(71, 25));
        btnVOLTAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVOLTARActionPerformed(evt);
            }
        });

        btnALTERAR.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnALTERAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/alterar.png"))); // NOI18N
        btnALTERAR.setToolTipText("<html><h3>Alterar Dados</h3></html>");
        btnALTERAR.setBorderPainted(false);
        btnALTERAR.setContentAreaFilled(false);
        btnALTERAR.setEnabled(false);
        btnALTERAR.setFocusable(false);
        btnALTERAR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnALTERARMouseClicked(evt);
            }
        });
        btnALTERAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnALTERARActionPerformed(evt);
            }
        });
        btnALTERAR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                btnALTERARKeyPressed(evt);
            }
        });

        btnEXCLUIR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        btnEXCLUIR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/deletar.png"))); // NOI18N
        btnEXCLUIR.setToolTipText("<html><h3>Excluir Obra</h3></html>");
        btnEXCLUIR.setBorderPainted(false);
        btnEXCLUIR.setContentAreaFilled(false);
        btnEXCLUIR.setEnabled(false);
        btnEXCLUIR.setFocusable(false);
        btnEXCLUIR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXCLUIRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNOVO, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnSALVAR, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addComponent(btnALTERAR, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEXCLUIR, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCANCELAR, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVOLTAR, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnALTERAR, btnEXCLUIR});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSALVAR, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(btnCANCELAR, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnVOLTAR, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnALTERAR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNOVO, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                    .addComponent(btnEXCLUIR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnCANCELAR, btnNOVO, btnSALVAR, btnVOLTAR});

        jPanel1.setBackground(new java.awt.Color(153, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white), "Obra", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 14))); // NOI18N
        jPanel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 526));

        txtTITULO.setEditable(false);
        txtTITULO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtTITULO.setToolTipText("<html><h3>Título da Obra</h3></html>");
        txtTITULO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtTITULO.setEnabled(false);
        txtTITULO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTITULOKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTITULOKeyTyped(evt);
            }
        });

        cbGENERO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cbGENERO.setToolTipText("<html><h3>Selecione Um Gênero</h3></html>");
        cbGENERO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        cbGENERO.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("Título*:");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("Editora:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Descrição:");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Quantidade*:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setText("Prateleira*:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setText("Autor*:");

        txtCODIGO.setEditable(false);
        txtCODIGO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtCODIGO.setToolTipText("<html><h3>Número de Tombo da Obra</h3></html>");
        txtCODIGO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("Nº de Tombo:");

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        jScrollPane1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        txtDESCRICAO.setEditable(false);
        txtDESCRICAO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white, java.awt.Color.white));
        txtDESCRICAO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtDESCRICAO.setToolTipText("<html><h3>Descrição da Obra</h3></html>");
        txtDESCRICAO.setEnabled(false);
        txtDESCRICAO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDESCRICAOKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDESCRICAOKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(txtDESCRICAO);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setText("Estante*:");

        txtEDITORA.setEditable(false);
        txtEDITORA.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEDITORA.setToolTipText("<html><h3>Editora da Obra</h3></html>");
        txtEDITORA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtEDITORA.setEnabled(false);
        txtEDITORA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEDITORAKeyTyped(evt);
            }
        });

        txtQUANTIDADE.setEditable(false);
        txtQUANTIDADE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtQUANTIDADE.setToolTipText("<html><h3>Quantidade de Exemplares</h3></html>");
        txtQUANTIDADE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtQUANTIDADE.setEnabled(false);

        txtAUTOR.setEditable(false);
        txtAUTOR.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtAUTOR.setToolTipText("<html></h3>Autor da Obra</h3></html>");
        txtAUTOR.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtAUTOR.setEnabled(false);
        txtAUTOR.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtAUTORKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAUTORKeyTyped(evt);
            }
        });

        txtESTANTE.setEditable(false);
        txtESTANTE.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtESTANTE.setToolTipText("<html><h3>Estante</h3></html>");
        txtESTANTE.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtESTANTE.setEnabled(false);
        txtESTANTE.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtESTANTEKeyTyped(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel10.setText("Gênero*:");

        jLabel11.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel11.setText("(*) Campos Obrigatórios");

        btnADDGENERO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/adicionar.png"))); // NOI18N
        btnADDGENERO.setToolTipText("<html><h3>Incluir Novo Gênero</h3></html>");
        btnADDGENERO.setBorderPainted(false);
        btnADDGENERO.setContentAreaFilled(false);
        btnADDGENERO.setEnabled(false);
        btnADDGENERO.setFocusable(false);
        btnADDGENERO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDGENEROActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setText("Ano:");

        txtEDICAO.setEditable(false);
        txtEDICAO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtEDICAO.setToolTipText("<html><h3>Edição da Publicação</h3></html>");
        txtEDICAO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtEDICAO.setEnabled(false);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel14.setText("Edição:");

        txtANO.setEditable(false);
        txtANO.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtANO.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("####"))));
        txtANO.setToolTipText("<html><h3>Ano de Publicação</h3></html>");
        txtANO.setEnabled(false);
        txtANO.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtANO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtANOActionPerformed(evt);
            }
        });
        txtANO.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtANOKeyTyped(evt);
            }
        });

        txtPRATELEIRA.setEditable(false);
        txtPRATELEIRA.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtPRATELEIRA.setToolTipText("<html><h3>Prateleira</h3></html>");
        txtPRATELEIRA.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED, null, null, java.awt.Color.white, java.awt.Color.white));
        txtPRATELEIRA.setEnabled(false);
        txtPRATELEIRA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPRATELEIRAActionPerformed(evt);
            }
        });
        txtPRATELEIRA.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPRATELEIRAKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCODIGO)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtTITULO)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel11))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbGENERO, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnADDGENERO)
                                .addGap(99, 99, 99)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtQUANTIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtAUTOR, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEDITORA, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtEDICAO, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(24, 24, 24)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtANO, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(5, 5, 5)
                                .addComponent(txtPRATELEIRA, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtESTANTE, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel10)
                    .addComponent(jLabel6)
                    .addComponent(jLabel3))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txtESTANTE, txtPRATELEIRA});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtTITULO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCODIGO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEDICAO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEDITORA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAUTOR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtANO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel8)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnADDGENERO)
                    .addComponent(jLabel4)
                    .addComponent(txtQUANTIDADE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtPRATELEIRA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtESTANTE, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbGENERO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(146, 146, 146))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    private void txtDESCRICAOGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDESCRICAOGActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDESCRICAOGActionPerformed

    private void btnNOVOGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNOVOGActionPerformed
        txtDESCRICAOG.setEnabled(true);
        btnSALVARG.setEnabled(true);
        btnEXCLUIRG.setEnabled(true);
        btnALTERARG.setEnabled(true);
        tblGENERO.setEnabled(true);
        txtDESCRICAOG.grabFocus();
    }//GEN-LAST:event_btnNOVOGActionPerformed

    private void btnVOLTARGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVOLTARGActionPerformed
        voltar2();
    }//GEN-LAST:event_btnVOLTARGActionPerformed

    private void btnSALVARGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSALVARGActionPerformed
        novoGenero();
    }//GEN-LAST:event_btnSALVARGActionPerformed

    private void btnVOLTARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVOLTARActionPerformed
        voltar();
    }//GEN-LAST:event_btnVOLTARActionPerformed

    private void btnCANCELARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCANCELARActionPerformed
        limpaCampos();
        desabilitaCampos();
    }//GEN-LAST:event_btnCANCELARActionPerformed

    private void btnSALVARKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnSALVARKeyPressed

    }//GEN-LAST:event_btnSALVARKeyPressed

    private void btnSALVARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSALVARActionPerformed
        verificaCampos();
        this.principal.pesquisarObra();
    }//GEN-LAST:event_btnSALVARActionPerformed

    private void btnSALVARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSALVARMouseClicked

    }//GEN-LAST:event_btnSALVARMouseClicked

    private void btnNOVOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNOVOActionPerformed
        Connection con = Conexao.abrirConexao();
        ObraDAO ob = new ObraDAO(con);
        habilitaCampos();
        txtCODIGO.setText(ob.carregaCODIGO());
    }//GEN-LAST:event_btnNOVOActionPerformed

    private void txtPRATELEIRAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPRATELEIRAKeyTyped

        int caracteres = 1;

        if (txtPRATELEIRA.getText().length() >= caracteres) {
            evt.consume();
            setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "<html><h3>Digite no Máximo " + caracteres + " Caracteres</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        }
    }//GEN-LAST:event_txtPRATELEIRAKeyTyped

    private void txtEDITORAKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEDITORAKeyTyped
        int caracteres = 35;

        if (txtEDITORA.getText().length() >= caracteres) {
            evt.consume();
            setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "<html><h3>Digite no Máximo " + caracteres + " Caracteres</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        }
    }//GEN-LAST:event_txtEDITORAKeyTyped

    private void btnADDGENEROActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDGENEROActionPerformed
        ifrm_GENERO.setLocationRelativeTo(null);
        ifrm_GENERO.setVisible(true);
    }//GEN-LAST:event_btnADDGENEROActionPerformed

    private void txtTITULOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTITULOKeyTyped
        int caracteres = 100;

        if (txtTITULO.getText().length() >= caracteres) {
            evt.consume();
            setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "<html><h3>Digite no Máximo " + caracteres + " Caracteres</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        }
    }//GEN-LAST:event_txtTITULOKeyTyped

    private void txtTITULOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTITULOKeyPressed

    }//GEN-LAST:event_txtTITULOKeyPressed

    private void txtESTANTEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtESTANTEKeyTyped
        int caracteres = 2;

        if (txtESTANTE.getText().length() >= caracteres) {
            evt.consume();

        }
    }//GEN-LAST:event_txtESTANTEKeyTyped

    private void txtDESCRICAOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDESCRICAOKeyTyped
        int caracteres = 200;

        if (txtDESCRICAO.getText().length() >= caracteres) {
            evt.consume();
            setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "<html><h3>Digite no Máximo " + caracteres + " Caracteres</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        }
    }//GEN-LAST:event_txtDESCRICAOKeyTyped

    private void txtDESCRICAOKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDESCRICAOKeyPressed

    }//GEN-LAST:event_txtDESCRICAOKeyPressed

    private void txtAUTORKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAUTORKeyTyped
        int caracteres = 100;

        if (txtAUTOR.getText().length() >= caracteres) {
            evt.consume();
            setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "<html><h3>Digite no Máximo " + caracteres + " Caracteres</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        }
    }//GEN-LAST:event_txtAUTORKeyTyped

    private void txtAUTORKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAUTORKeyPressed
//
//        switch (evt.getKeyCode()) {
//            case KeyEvent.VK_BACKSPACE:
//                break;
//            case KeyEvent.VK_ENTER:
//                txtAUTOR.setText(txtAUTOR.getText());
//                break;
//            default:
//                EventQueue.invokeLater(() -> {
//                    String txt = txtAUTOR.getText();
//                    autoCompleta(txt);
//                });
//        }
    }//GEN-LAST:event_txtAUTORKeyPressed

    private void btnALTERARGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALTERARGActionPerformed
        alterarGenero();
    }//GEN-LAST:event_btnALTERARGActionPerformed

    private void btnALTERARMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnALTERARMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnALTERARMouseClicked

    private void btnALTERARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnALTERARActionPerformed
        alterar();
        this.principal.pesquisarObra();
    }//GEN-LAST:event_btnALTERARActionPerformed

    private void btnALTERARKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_btnALTERARKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnALTERARKeyPressed

    private void txtPRATELEIRAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPRATELEIRAActionPerformed

    }//GEN-LAST:event_txtPRATELEIRAActionPerformed

    private void jPanel2ComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jPanel2ComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel2ComponentAdded

    private void btnEXCLUIRGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXCLUIRGActionPerformed
        if (tblGENERO.getSelectedRow() < 0) {
            setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "Selecione um Gênero!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        } else {
            excluirGenero();
        }
    }//GEN-LAST:event_btnEXCLUIRGActionPerformed

    private void txtANOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtANOActionPerformed

    }//GEN-LAST:event_txtANOActionPerformed

    private void txtANOKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtANOKeyTyped
        int caracteres = 4;

        if (txtANO.getText().length() >= caracteres) {
            evt.consume();
            setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "<html><h3>Digite no Máximo " + caracteres + " Caracteres</h3></html>", "ATENÇÃO", JOptionPane.WARNING_MESSAGE, atencao);

        }
    }//GEN-LAST:event_txtANOKeyTyped

    private void tblGENEROMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGENEROMouseClicked

        btnALTERARG.setEnabled(true);
        btnEXCLUIRG.setEnabled(true);


    }//GEN-LAST:event_tblGENEROMouseClicked

    private void btnEXCLUIRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXCLUIRActionPerformed
        excluir();
        this.principal.pesquisarObra();
    }//GEN-LAST:event_btnEXCLUIRActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            JFrame principal = new frm_PRINCIPAL();
            JFrame obra = new frm_OBRAS();
            obra.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnADDGENERO;
    private javax.swing.JButton btnALTERAR;
    private javax.swing.JButton btnALTERARG;
    private javax.swing.JButton btnCANCELAR;
    private javax.swing.JButton btnEXCLUIR;
    private javax.swing.JButton btnEXCLUIRG;
    private javax.swing.JButton btnNOVO;
    private javax.swing.JButton btnNOVOG;
    private javax.swing.JButton btnSALVAR;
    private javax.swing.JButton btnSALVARG;
    private javax.swing.JButton btnVOLTAR;
    private javax.swing.JButton btnVOLTARG;
    private javax.swing.JComboBox<String> cbGENERO;
    private javax.swing.JFrame ifrm_GENERO;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblGENERO;
    private javax.swing.JFormattedTextField txtANO;
    private javax.swing.JTextField txtAUTOR;
    private javax.swing.JTextField txtCODIGO;
    private javax.swing.JTextPane txtDESCRICAO;
    private javax.swing.JTextField txtDESCRICAOG;
    private javax.swing.JTextField txtEDICAO;
    private javax.swing.JTextField txtEDITORA;
    private javax.swing.JTextField txtESTANTE;
    private javax.swing.JTextField txtPRATELEIRA;
    private javax.swing.JTextField txtQUANTIDADE;
    private javax.swing.JTextField txtTITULO;
    // End of variables declaration//GEN-END:variables

    //INCLUIR NOVA OBRA
    private void incluirObra() {

        Connection con = Conexao.abrirConexao();

        ObraDAO cd = new ObraDAO(con);
        Boolean disp;
        String localizacao1 = txtPRATELEIRA.getText() + "-" + txtESTANTE.getText();

        ob.setTitulo_OBRA(txtTITULO.getText());
        ob.setEditora_OBRA(txtEDITORA.getText());
        ob.setEdicao(txtEDICAO.getText());
        ob.setAno(txtANO.getText());
        ob.setDescricao_OBRA(txtDESCRICAO.getText());
        ob.setLocalizacao(localizacao1);
        ob.setQuantidade_OBRA(Integer.valueOf(txtQUANTIDADE.getText()));
        //VERIFICA A DISPONIBILIDADE DO LIVRO >>>>>
        disp = verificaDisponibilidade();
        ob.setDisponibilidade(disp);
        ob.setGenero((String) cbGENERO.getSelectedItem());
        ob.setAutor(txtAUTOR.getText());
        
        this.setAlwaysOnTop(false);
        
        cd.inserir(ob);

        Conexao.fecharConexao(con);
        limpaCampos();
        desabilitaCampos();

    }

    private void alterar() {

        Connection con = Conexao.abrirConexao();

        ObraDAO cd = new ObraDAO(con);
        Boolean disp;
        String localizacao2 = txtPRATELEIRA.getText() + "-" + txtESTANTE.getText();

        ob.setTitulo_OBRA(txtTITULO.getText());
        ob.setEditora_OBRA(txtEDITORA.getText());
        ob.setEdicao(txtEDICAO.getText());
        ob.setAno(txtANO.getText());
        ob.setDescricao_OBRA(txtDESCRICAO.getText());
        ob.setLocalizacao(localizacao2);
        ob.setQuantidade_OBRA(Integer.valueOf(txtQUANTIDADE.getText()));
        //VERIFICA A DISPONIBILIDADE DO LIVRO >>>>>
        disp = verificaDisponibilidade();
        ob.setDisponibilidade(disp);
        ob.setGenero((String) cbGENERO.getSelectedItem());
        ob.setAutor(txtAUTOR.getText());
        ob.setID(Integer.valueOf(txtCODIGO.getText()));

        cd.alterar(ob);

        Conexao.fecharConexao(con);
        limpaCampos();
        desabilitaCampos();

    }

    private void excluir() {
        setAlwaysOnTop(false);
        Connection con = Conexao.abrirConexao();
        ObraBean ob = new ObraBean();
        ObraDAO od = new ObraDAO(con);

        ob.setID(Integer.valueOf(txtCODIGO.getText()));

        Object[] opcoes = {"Sim", "Não"};

        int i = JOptionPane.showOptionDialog(null,
                "<html><h3>Deseja realmente excluir essa Obra: <br>"
                + txtTITULO.getText() + " ?</h3></html>",
                "Exclusão", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, questao,
                opcoes, opcoes[0]);

        if (i == JOptionPane.YES_OPTION) {

            od.excluir(ob);
            limpaCampos();
            btnALTERAR.setEnabled(false);
            btnEXCLUIR.setEnabled(false);
        }

        Conexao.fecharConexao(con);

    }

    //MOSTRA LISTA DE SUGESTÕES NAS TEXTFIELDS, DE ACORDO COM O QUE O USUÁRIO DIGITA.
    private void autoCompleta(String txt) {
        String complete = "";
        int inicio = txt.length();
        int fim = txt.length();
        int a;
        for (a = 0; a < autor.size(); a++) {
            if (autor.get(a).toString().startsWith(txt)) {
                complete = autor.get(a).toString();
                fim = complete.length();
                break;
            }
        }
        if (fim > inicio) {
            txtAUTOR.setText(complete);
            txtAUTOR.setCaretPosition(fim);
            txtAUTOR.moveCaretPosition(inicio);

        }

    }

    //VERIFICA SE TODOS OS CAMPOS ESTÃO PREENCHIDOS
    private void verificaCampos() {
        if ("".equals(txtTITULO.getText())
                || "".equals(txtAUTOR.getText())
                || "".equals(txtQUANTIDADE.getText())
                || "".equals(txtESTANTE.getText())
                || "".equals(txtPRATELEIRA.getText())
                || cbGENERO.getSelectedIndex() == -1) {
            setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "<html><h3>Favor inserir todos os valores obrigatórios (*)!!</h3></html>", "ATENÇÃO!", JOptionPane.WARNING_MESSAGE, atencao);
            txtTITULO.grabFocus();
            setAlwaysOnTop(true);
        } else {
            incluirObra();
        }

    }

    //VERIFICA DISPONIBILIDADE DA OBRA
    private boolean verificaDisponibilidade() {

        int quantidade = Integer.parseInt(txtQUANTIDADE.getText());

        if (quantidade > 0) {
            return true;
        } else {
            return false;
        }

    }

    //RETORNA A TELA DE CADASTRO DE OBRAS
    private void voltar2() {

        ifrm_GENERO.dispose();

    }

    // RETORNA A TELA PRINCIPAL
    private void voltar() {

        this.dispose();

    }

    //PREENCHE A COMBOBOX DE GENEROS
    private void carregaGENEROS() {

        try {

            Connection con = Conexao.abrirConexao();
            sql = "select * from genero order by id_GENERO";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            //LIMPA A COMBO BOX "GENEROS"
            cbGENERO.removeAllItems();
            while (rs.next()) {
                //ADICIONA OS ITENS, ENQUANTO AINDA HÁ ITENS A SEREM ADICIONADOS
                cbGENERO.addItem(rs.getString("Descricao"));
            }
        } catch (SQLException ex) {
            setAlwaysOnTop(false);
            JOptionPane.showMessageDialog(null, "<html><h3>Erro ao preencher Gêneros!" + ex + "</h3></html>", "Erro no Banco!", JOptionPane.ERROR_MESSAGE, erro);
        }

    }

    private void setarAlteracao() {

        txtCODIGO.setText(tombo);
        txtTITULO.setText(titulo);
        txtAUTOR.setText(auto);
        txtEDITORA.setText(editora);
        txtEDICAO.setText(edicao);
        txtANO.setText(ano);
        cbGENERO.setSelectedItem(genero);
        txtQUANTIDADE.setText(String.valueOf(qtd));
        String novaLoc = localizacao.replace("-", "");
        txtPRATELEIRA.setText(novaLoc.substring(0));
        txtESTANTE.setText(localizacao.substring(2));

    }

    private void preecherCampos() {

        initComponents();
        carregaGENEROS();
        preencherTabelaGeneros();
        sugestao();
        txtTITULO.grabFocus();

    }

    //FORM DOS GÊNEROS>>>>>
    private void preencherTabelaGeneros() {
        Connection con = Conexao.abrirConexao();
        GeneroDAO gd = new GeneroDAO(con);

        List<GeneroBean> listaGenero = new ArrayList<>();

        listaGenero = gd.listarTodos();

        DefaultTableModel tbm = (DefaultTableModel) tblGENERO.getModel();

        tblGENERO.setModel(tbm);

        for (int i = tbm.getRowCount() - 1; i >= 0; i--) {

            tbm.removeRow(i);
        }
        int i = 0;
        for (GeneroBean cb : listaGenero) {
            tbm.addRow(new String[1]);
            tblGENERO.setValueAt(cb.getID(), i, 0);
            tblGENERO.setValueAt(cb.getDescricao(), i, 1);
            i++;
        }

        Conexao.fecharConexao(con);
        cbGENERO.setSelectedIndex(-1);

    }

    private void novoGenero() {

        Connection con = Conexao.abrirConexao();
        GeneroBean gb = new GeneroBean();
        GeneroDAO gd = new GeneroDAO(con);

        gb.setDescricao(txtDESCRICAOG.getText());
        gd.inserir(gb);

        Conexao.fecharConexao(con);

    }

    private void alterarGenero() {

        Connection con = Conexao.abrirConexao();
        GeneroBean gb = new GeneroBean();
        GeneroDAO gd = new GeneroDAO(con);

        gb.setDescricao(txtDESCRICAOG.getText());
        gd.alterar(gb);

        preencherTabelaGeneros();
        Conexao.fecharConexao(con);

        desabilitarCamposG();
    }

    private void excluirGenero() {

    }

    private void habilitaCampos() {
        txtTITULO.setEditable(true);
        txtTITULO.setEnabled(true);
        txtAUTOR.setEnabled(true);
        txtAUTOR.setEditable(true);
        txtEDITORA.setEnabled(true);
        txtEDITORA.setEditable(true);
        txtEDICAO.setEditable(true);
        txtEDICAO.setEnabled(true);
        txtANO.setEditable(true);
        txtANO.setEnabled(true);
        txtQUANTIDADE.setEnabled(true);
        txtQUANTIDADE.setEditable(true);
        txtPRATELEIRA.setEnabled(true);
        txtPRATELEIRA.setEditable(true);
        txtESTANTE.setEnabled(true);
        txtESTANTE.setEditable(true);
        cbGENERO.setEnabled(true);
        cbGENERO.setSelectedIndex(-1);
        txtDESCRICAO.setEnabled(true);
        txtDESCRICAO.setEditable(true);
        btnSALVAR.setEnabled(true);
        btnCANCELAR.setEnabled(true);
        btnADDGENERO.setEnabled(true);
        txtTITULO.grabFocus();

    }

    private void limpaCampos() {
        txtCODIGO.setText("");
        txtTITULO.setText("");
        txtAUTOR.setText("");
        txtANO.setText("");
        txtEDICAO.setText("");
        txtEDITORA.setText("");
        txtQUANTIDADE.setText("");
        txtESTANTE.setText("");
        txtPRATELEIRA.setText("");
        txtDESCRICAO.setText("");
        cbGENERO.setSelectedIndex(-1);
    }

    private void desabilitaCampos() {

        txtTITULO.setEditable(false);
        txtTITULO.setEnabled(false);
        txtAUTOR.setEnabled(false);
        txtAUTOR.setEditable(false);
        txtANO.setEnabled(false);
        txtANO.setEditable(false);
        txtEDICAO.setEnabled(false);
        txtEDICAO.setEditable(false);
        txtEDITORA.setEnabled(false);
        txtEDITORA.setEditable(false);
        txtQUANTIDADE.setEnabled(false);
        txtQUANTIDADE.setEditable(false);
        txtPRATELEIRA.setEnabled(false);
        txtPRATELEIRA.setEditable(false);
        txtESTANTE.setEnabled(false);
        txtESTANTE.setEditable(false);
        cbGENERO.setEnabled(false);
        txtDESCRICAO.setEnabled(false);
        txtDESCRICAO.setEditable(false);
        btnSALVAR.setEnabled(false);
        btnCANCELAR.setEnabled(false);
        btnADDGENERO.setEnabled(false);

    }

    private void desabilitarCamposG() {

        txtDESCRICAOG.setEnabled(false);
        txtDESCRICAOG.setEditable(false);
        btnSALVARG.setEnabled(false);
        btnEXCLUIRG.setEnabled(false);
        btnALTERARG.setEnabled(false);

    }

}
