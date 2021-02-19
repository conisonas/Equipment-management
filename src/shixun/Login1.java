package shixun;
import com.alee.laf.WebLookAndFeel;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class Login1 extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    PreparedStatement ps;
    ResultSet rs;
    private JRadioButton rdbtnNewRadioButton,rdbtnNewRadioButton_1;
    JButton btnNewButton,btnNewButton_1;
    /**
     * Launch the application.
     */
    public static void main(String[] args) throws InvocationTargetException, InterruptedException {
       try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        }catch(Exception e) {
            System.out.println(e);
        }
//        SwingUtilities.invokeAndWait(WebLookAndFeel::install);

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login1 frame = new Login1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    /**
     * Create the frame.
     */
    public Login1() {
        setBackground(new Color(240, 255, 240));

        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lenovo-pc\\eclipse-workspace\\shixun1\\src\\assets\\a.png"));
        setTitle("\u5B9E\u9A8C\u5BA4\u8BBE\u5907\u7BA1\u7406\u7CFB\u7EDF");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 668, 455);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(211, 211, 211));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u767B\u5F55");
        lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 26));

        JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D:");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\eclipse-workspace\\shixun1\\src\\assets\\b1.png"));
        lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 24));

        textField = new JTextField();
        textField.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("\u5BC6  \u7801:");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\eclipse-workspace\\shixun1\\src\\assets\\c1.png"));
        lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 26));

        textField_1 = new JTextField();
        textField_1.setColumns(10);

         btnNewButton = new JButton("\u767B\u5F55");
        // btnNewButton.setContentAreaFilled(false);
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton.setFont(new Font("宋体", Font.PLAIN, 19));

        btnNewButton_1 = new JButton("\u91CD\u7F6E");
        btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 19));
        btnNewButton.addActionListener(this);
        btnNewButton_1.addActionListener(this);
        JLabel lblNewLabel_3 = new JLabel("\u6743  \u9650:");
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\eclipse-workspace\\shixun1\\src\\assets\\c2.png"));
        lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 22));

         rdbtnNewRadioButton = new JRadioButton("\u7528\u6237");
        rdbtnNewRadioButton.setFont(new Font("宋体", Font.PLAIN, 22));

         rdbtnNewRadioButton_1 = new JRadioButton("\u7BA1\u7406\u5458");
        rdbtnNewRadioButton_1.setFont(new Font("宋体", Font.PLAIN, 22));

        JButton btnNewButton_2 = new JButton("\u6CE8\u518C");
        btnNewButton_2 .addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog jd1 = new JDialog();
                jd1.setLayout(null);
                jd1.setTitle("增加");
                jd1.setBounds(900, 100, 600, 900);
                JLabel ja=new JLabel("请输入新的信息");
                ja.setFont(new Font("华文行楷",4,20));
                ja.setBounds(225,-80,200,200);
                jd1.add(ja, BorderLayout.NORTH);


                JLabel ja1=new JLabel("id编号:");
                ja1.setFont(new Font("华文行楷",4,18));
                ja1.setBounds(40,48,130,40);
                jd1.add(ja1 );
                JTextField jt1=new JTextField();
                jt1.setColumns(20);
                jt1.setBounds(130,58,100,25);
                jd1.add(jt1 );


                JLabel ja2=new JLabel("用户名:");
                ja2.setFont(new Font("华文行楷",4,18));
                ja2.setBounds(30,120,100,40);
                jd1.add(ja2 );
                JTextField jt2=new JTextField();
                jt2.setColumns(20);
                jt2.setBounds(130,128,100,25);
                jd1.add(jt2 );

                JLabel ja22=new JLabel("登录密码：");
                ja22.setFont(new Font("华文行楷",4,18));
                ja22.setBounds(10,180,100,40);
                jd1.add(ja22);
                JTextField jt22=new JTextField();
                jt22.setColumns(20);
                jt22.setBounds(130,190,100,25);
                jd1.add(jt22);

                JLabel ja3=new JLabel("姓名：");
                ja3.setFont(new Font("华文行楷",4,18));
                ja3.setBounds(40,240,100,40);
                jd1.add(ja3 );
                JTextField jt3=new JTextField();
                jt3.setColumns(20);
                jt3.setBounds(130,250,100,25);
                jd1.add(jt3 );
                JLabel ja4=new JLabel("性别:");
                ja4.setFont(new Font("华文行楷",4,18));
                ja4.setBounds(40,300,120,40);
                jd1.add(ja4 );

                JTextField jt4=new JTextField();
                jt4.setColumns(20);
                jt4.setBounds(130,310,100,25);
                jd1.add(jt4);

                JLabel ja5=new JLabel("出生日期:");
                ja5.setFont(new Font("华文行楷",4,18));
                ja5.setBounds(10,360,120,40);
                jd1.add(ja5 );
                JTextField jt5=new JTextField();
                jt5.setColumns(20);
                jt5.setBounds(130,370,100,25);
                jd1.add(jt5);

                JLabel ja6=new JLabel("电话号码:");
                ja6.setFont(new Font("华文行楷",4,18));
                ja6.setBounds(10,420,120,40);
                jd1.add(ja6);
                JTextField jt6=new JTextField();
                jt6.setColumns(20);
                jt6.setBounds(130,430,100,25);
                jd1.add(jt6);


                JLabel ja7=new JLabel("电子邮箱:");
                ja7.setFont(new Font("华文行楷",4,18));
                ja7.setBounds(10,480,120,40);
                jd1.add(ja7 );
                JTextField jt7=new JTextField();
                jt7.setColumns(20);
                jt7.setBounds(130,490,100,25);
                jd1.add(jt7);

                JLabel ja8=new JLabel("个人简介:");
                ja8.setFont(new Font("华文行楷",4,18));
                ja8.setBounds(10,540,120,40);
                jd1.add(ja8);
                JTextField jt8=new JTextField();
                jt8.setColumns(20);
                jt8.setBounds(130,550,100,25);
                jd1.add(jt8);



                JButton jb = new JButton("确定");
                jb.setBounds(130,600,90,30);
                jd1.add(jb);
                jd1.setVisible(true);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Integer a=Integer.valueOf(jt1.getText());
                        String b=jt2.getText();
                        String c=jt22.getText();
                        String d=jt3.getText();
                        String e=jt4.getText();
                        String f=jt5.getText();
                        String g=jt6.getText();
                        String h=jt7.getText();
                        String k=jt8.getText();
                        try {
                            Connection con = Connection1.getcon();

                            String sql = "insert into userinfo values" +"("+ a + ",'" +b + "'," +c+",'"+d+ "','" +e+"','"+f+"','"+g+"','"+h+"','"+k+"'"+")";
                            PreparedStatement ps = con.prepareStatement(sql);
                            ps.executeUpdate();
                        }catch (Exception throwables) {
                            throwables.printStackTrace();
                        } finally {
                            try {
                                if (rs != null) {
                                    rs.close();
                                }
                                if (ps != null) {
                                    ps.close();
                                }
                            } catch (SQLException a1) {
                                a1.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
        btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 22));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(87)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblNewLabel_2)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(34)
                                                .addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lblNewLabel_3))
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                        .addGap(62)
                                                        .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(ComponentPlacement.RELATED, 100, Short.MAX_VALUE)
                                                        .addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
                                                        .addGap(46))
                                                .addGroup(gl_contentPane.createSequentialGroup()
                                                        .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                                .addComponent(textField)
                                                                .addComponent(textField_1, 213, 213, Short.MAX_VALUE))
                                                        .addContainerGap(189, Short.MAX_VALUE)))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addComponent(rdbtnNewRadioButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)
                                                .addGap(55)
                                                .addComponent(rdbtnNewRadioButton_1, GroupLayout.PREFERRED_SIZE, 101, GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(154, Short.MAX_VALUE))))
                        .addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
                                .addGap(260)
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(267, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
                                .addGap(21)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(26)
                                                .addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(rdbtnNewRadioButton)
                                        .addComponent(rdbtnNewRadioButton_1))
                                .addGap(45)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                                        .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(27))
        );
        contentPane.setLayout(gl_contentPane);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("lib/3.txt", true));
            SimpleDateFormat myfmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Integer qw=myfmt.format(new java.util.Date()).toString().hashCode();
            System.out.println(qw);
            if (e.getActionCommand() == "登录") {
                String userName = textField.getText();
                String passWord = textField_1.getText();
                Connection con = null;
                con = Connection1.getcon();
                String sql = "select * from userinfo where id= ? and uname= ? and pwd= ?";
                //如果选中用户登录
                if (rdbtnNewRadioButton.isSelected()) {
                    try {
                        PreparedStatement pstmt = con.prepareStatement(sql);
                        // Integer ident=pstmt.
                        pstmt.setString(1, "1");
                        pstmt.setString(2, userName);
                        pstmt.setString(3, passWord);
                        ResultSet rs = pstmt.executeQuery();
                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "登陆成功");
                            bw.write("此次操作系统编号为： "+qw+"\n");
                            bw.write("身份为：用户\n");
                            bw.write("用户名："+userName+"\n");
                            //bw.newLine();
                            clear();
                            Usermenu1 frame = new Usermenu1();
                            frame.setVisible(true);
                            dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "登陆失败");
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                } else if (rdbtnNewRadioButton_1.isSelected()) //管理员在登录系统
                {
                    try {
                        PreparedStatement pstmt = con.prepareStatement(sql);
                        pstmt.setString(1, "0");
                        pstmt.setString(2, userName);
                        pstmt.setString(3, passWord);
                        ResultSet rs = pstmt.executeQuery();
                        if (rs.next()) {
                            JOptionPane.showMessageDialog(null, "登陆成功");
                            bw.write("此次操作系统编号为： "+qw+"\n");
                            bw.write("身份为：管理员\n");
                            bw.write("用户名为： "+userName+"\n");
                            clear();
                            dispose();
                            Adminmenu a1 = new Adminmenu();
                        } else {
                            JOptionPane.showMessageDialog(null, "登陆失败");
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                }
            } else if (e.getActionCommand() == "重置") {
                clear();
            }
            bw.close();
        }catch (Exception e1){
            e1.getMessage();
        }
    }
    //清空文本框和密码框
    public	void clear()
    {
        textField.setText("");
        textField_1.setText("");
    }
}
