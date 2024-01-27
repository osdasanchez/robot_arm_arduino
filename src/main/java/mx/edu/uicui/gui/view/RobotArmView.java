package mx.edu.uicui.gui.view;

import mx.edu.uicui.gui.model.RobotArmModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class RobotArmView extends JFrame {
    private JButton jButton1;
    private JButton jButtonConectar;
    private JButton jButtonEnter;
    private JButton jButtonRefresh;
    private JComboBox<String> jComboBoxPorts;
    private JLabel jLabel1;
    private JLabel jLabel3;
    private JPanel jPanel1;
    private JPanel jPanel3;
    private JPanel jPanel8;
    private JTextField jTextField1;

    private final RobotArmModel armModel;

    public RobotArmView(RobotArmModel armModel) {
        this.armModel = armModel;
        initComponents();
    }

    private void initComponents() {
        jPanel1 = new JPanel();
        jPanel3 = new JPanel();
        jComboBoxPorts = new JComboBox<>();
        jButtonRefresh = new JButton();
        jButtonConectar = new JButton();
        jPanel8 = new JPanel();
        jTextField1 = new JTextField();
        jLabel1 = new JLabel();
        jButtonEnter = new JButton();
        jLabel3 = new JLabel();
        jButton1 = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Arm Robot");
        setBackground(new Color(51, 51, 51));
        setResizable(false);
        //setVisible(false);

        jPanel1.setBackground(new Color(0, 204, 204));
        jPanel1.setToolTipText("");
        jPanel1.addMouseMotionListener(new MouseMotionAdapter() {
            public void mouseMoved(MouseEvent evt) {
                //jPanel1MouseMoved(evt);
            }
        });

        jPanel3.setBackground(new Color(51, 51, 51));
        jPanel3.setBorder(BorderFactory.createEtchedBorder());

        jComboBoxPorts.setFont(new Font("Century Gothic", 0, 14));

        jButtonRefresh.setFont(new Font("Tahoma", 0, 14));
        //jButtonRefresh.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource("/images/refreshicon.png"))));
//        jButtonRefresh.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                // jButtonRefreshActionPerformed(evt);
//            }
//        });

        jButtonConectar.setFont(new Font("Century Gothic", 0, 17));
        jButtonConectar.setForeground(new Color(0, 153, 204));
        //jButtonConectar.setText("Conectar");
        jButtonConectar.setEnabled(false);
        if (this.armModel.isIsConected()) {
            jButtonConectar.setText("Desconectar");
        } else {
            jButtonConectar.setText("Conectar");
        }
//        jButtonConectar.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//                // jButtonConnectActionPerformed(evt);
//            }
//        });

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jComboBoxPorts, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonRefresh, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButtonConectar)
                                .addGap(34, 34, 34))
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jButtonRefresh, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addComponent(jComboBoxPorts))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonConectar, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new Color(51, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTextField1.setText("ROBOTICA ITSE UNIVERSIDAD DE IXTLAHUACA CUI");

        GroupLayout jPanel8Layout = new GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
                jPanel8Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, 539, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
                jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel8Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jTextField1, GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                                .addContainerGap())
        );

        jLabel1.setBackground(new Color(255, 255, 255));
        jLabel1.setFont(new Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("ESCRIBE UNA FRASE");
        jLabel1.setRequestFocusEnabled(false);

        jButtonEnter.setBackground(new Color(204, 204, 204));
        jButtonEnter.setFont(new Font("Century Gothic", 1, 18)); // NOI18N
        jButtonEnter.setForeground(new Color(255, 102, 0));
        jButtonEnter.setText("ENVIAR");
        jButtonEnter.setEnabled(false);
//        jButtonEnter.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//               // jButtonEnterActionPerformed(evt);
//            }
//        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("PUERTO");

        //jButton1.setIcon(new javax.swing.ImageIcon(Objects.requireNonNull(getClass().getResource("/images/foto.jpg")))); // NOI18N
//        jButton1.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent evt) {
//              //  jButton1ActionPerformed(evt);
//            }
//        });

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(161, 161, 161)
                                                .addComponent(jButton1))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1))))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jButtonEnter)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3)
                                        .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE))
                                .addGap(123, 123, 123))
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jButton1)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jPanel8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonEnter, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel3, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();


    }

    public void updateView() {
        if (this.armModel.isIsConected()) {
            jButtonConectar.setText("Desconectar");
            jButtonEnter.setEnabled(true);
        } else {
            jButtonConectar.setText("Conectar");
            jButtonEnter.setEnabled(false);
        }
        jButtonConectar.setEnabled(this.armModel.isHasPort());

    }

    public void addJButtonConectarActionListener(ActionListener actionListener) {
        jButtonConectar.addActionListener(actionListener);
    }

    public void addJButtonEnterActionListener(ActionListener actionListener) {
        jButtonEnter.addActionListener(actionListener);
    }

    public void addJButtonRefreshActionListener(ActionListener actionListener) {
        jButtonRefresh.addActionListener(actionListener);
    }

    public void addJPanel1MouseMotionListener(MouseMotionAdapter mouseMotionAdapter) {
        jPanel1.addMouseMotionListener(mouseMotionAdapter);
    }

    public String getSelectedPort() {
        return (String) jComboBoxPorts.getSelectedItem();
    }

    public void setPuertos(String[] puertos) {
        jComboBoxPorts.setModel(new DefaultComboBoxModel<>(puertos));
    }

    public String getWord() {
        return jTextField1.getText();
    }


}
