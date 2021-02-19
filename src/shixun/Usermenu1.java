package shixun;
import exp5.Login;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import javax.swing.JDialog;
public class Usermenu1 extends JFrame implements ActionListener {
    PreparedStatement ps;
    ResultSet rs;
    String  string;
    Connection con = Connection1.getcon();
    JButton jb,jb1,jb2,jb3,jb4,jn,jn1,jn2,jn3,jn4,ju,ju1,ju2,ju3,ju4,jc,jc1,jc2,jc3,jc4;
    JButton jo,jo1,jo2,jo3,jo4,jk,jk1,jk2,jk3,jk4,jk1p,jk1p1,jk1p2,jk1p3,jk1p4,jod,jo1d,jo2d,jo3d,jo4d,jButton;
    //构造函数
    public Usermenu1() throws Exception
    {
        //设置界面标题
        setTitle("用户界面");
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Lenovo-pc\\eclipse-workspace\\shixun1\\src\\assets\\k.png"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("lib\\3.txt",true));
        SimpleDateFormat myfmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        bw.write("操作内容为：\n");
        // 设置界面像素 设置界面初始位置
        setBounds(100, 0, 1300, 1000);
        Container c = getContentPane();
        c.setLayout(null);
        c.setBackground(Color.decode("#D8BFD8"));
        //设置虚拟机和界面一同关闭
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //设置界面可视化
        setVisible(true);
        // 创建组件
        JLabel j1 = new JLabel("欢迎使用实验室设备管理系统");
        j1.setBounds(330, 40, 560, 50);
        j1.setFont(new Font("仿宋", Font.ITALIC, 40));
        j1.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\eclipse-workspace\\shixun1\\src\\assets\\1.png"));
        c.add(j1, BorderLayout.NORTH);
        JLabel  j11=new JLabel();
        j11.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\eclipse-workspace\\shixun1\\src\\assets\\1.png"));
        j11.setBounds(892,40,50,50);
        c.add(j11);
        JButton juj=new JButton("退出");
        juj.setFont(new Font("黑体", 0, 15));
        juj.setBounds(1030,198,80,40);
        jButton=new JButton("交流");
        jButton.setFont(new Font("黑体", 0, 15));
        //jButton.addActionListener(this);
        jButton.setBounds(945, 198, 80, 40);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Login();
            }
        });
        c.add(jButton);
        juj.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(10);
            }
        });
        c.add(juj);
        //创建选项卡
        JTabbedPane jtb = new JTabbedPane();
        jtb.setFont(new Font("黑体",4,26));
        jtb.setBounds(43, 200, 1200, 780);
        c.add(jtb);
        //创建选项卡
        JTabbedPane jtbp = new JTabbedPane();
        jtbp.setFont(new Font("黑体",4,20));
        jtbp.setBounds(43, 200, 1200, 780);
        Object[][] tableDate = new Object[40][3];
        Object[] name = {"id", "设备编号", "类别名称"};
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBounds(0, 100, 800, 900);
        JTable d=new JTable(tableDate,name);
        d.setRowHeight(25);
        JScrollPane js = new JScrollPane(d);
        js.setBounds(0, 0, 600, 400);
        p1.add(js);
        jb = new JButton("查询全部");
        jb.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\2.png"));
        jb.setBounds(630, 35, 120, 35);
        jb.setFont(new Font("黑体", 0, 15));
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                    bw.write("查询全部设备类别信息\n");
                    bw.flush();
                }catch (Exception e){
                    e.printStackTrace();
                }
                for(int i=0;i<40;i++)
                {
                    for(int j=0;j<3;j++)
                    {
                        d.setValueAt(" ",i,j);
                    }
                }
                try {
                    ps = con.prepareStatement("select * from device1");
                    rs = ps.executeQuery();
                    for (int i = 0; rs.next(); i++) {
                        int id = rs.getInt(1);
                        int num = rs.getInt(2);
                        String name = rs.getString(3);
                        d.setValueAt(Integer.toString(id), i, 0);
                        d.setValueAt(Integer.toString(num), i, 1);
                        d.setValueAt(name, i, 2);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
            }
        });
        p1.add(jb);
        jb1 = new JButton("查询");
        jb1.setBounds(630, 80, 120, 35);
        jb1.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\3.png"));
        jb1.setFont(new Font("黑体", 0, 15));
        jb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String st1 = JOptionPane.showInputDialog(null, "设备编号", "查询", 1);
                System.out.println(st1);
                int m = 0;
                try {
                    ps = con.prepareStatement("select * from device1");
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        int num = rs.getInt(2);
                        String a = "" + num;
                        if (st1.equals(a)) {
                            m = 1;
                            int id = rs.getInt(1);
//                            try {
//                                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
//                                bw.write("查询设备类别信息：id为: "+id+"\n");
//                                bw.flush();
//                            }catch (Exception e){
//                                e.printStackTrace();
//                            }
                            String name = rs.getString(3);
                            d.setValueAt(Integer.toString(id), 0, 0);
                            d.setValueAt(Integer.toString(num), 0, 1);
                            d.setValueAt(name, 0, 2);
                        }
                    }
                    if (m == 0) {   try {
                        bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                        bw.write("查询的设备类别数据不存在");
                        bw.flush();
                        bw.close();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                        JOptionPane.showMessageDialog(null, "您查找的数据不存在", "提示：", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
            }
        });
        p1.add(jb1);
        jb2 = new JButton("增加");
        jb2.setBounds(630, 125, 120, 35);
        jb2.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\4.png"));
        jb2.setFont(new Font("黑体", 0, 15));
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog jd1 = new JDialog();
                jd1.setLayout(null);
                jd1.setTitle("增加");
                jd1.setBounds(900, 200, 600, 600);
                JLabel ja=new JLabel("请输入新的信息");
                ja.setFont(new Font("华文行楷",4,20));
                ja.setBounds(225,-80,200,200);
                jd1.add(ja,BorderLayout.NORTH);
                JLabel ja1=new JLabel("id:");
                ja1.setFont(new Font("华文行楷",4,18));
                ja1.setBounds(40,48,40,40);
                jd1.add(ja1 );

                SimpleDateFormat myfmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                Integer qw=myfmt.format(new java.util.Date()).toString().hashCode();

                JLabel jt1=new JLabel();
                jt1.setFont(new Font("黑体",4,19));
                jt1.setText(qw.toString());
                jt1.setBounds(110,58,180,25);
                jd1.add(jt1 );
                JLabel ja2=new JLabel("设备编号:");
                ja2.setFont(new Font("华文行楷",4,18));
                ja2.setBounds(20,120,80,40);
                jd1.add(ja2 );
                JTextField jt2=new JTextField();
                jt2.setColumns(20);
                jt2.setBounds(110,128,100,25);
                jd1.add(jt2 );
                JLabel ja3=new JLabel("类别名称:");
                ja3.setFont(new Font("华文行楷",4,18));
                ja3.setBounds(20,180,80,40);
                jd1.add(ja3 );
                JTextField jt3=new JTextField();
                jt3.setColumns(20);
                jt3.setBounds(110,190,100,25);
                jd1.add(jt3 );
                JButton jb = new JButton("确定");
                jb.setBounds(110,320,90,30);
                jd1.add(jb);
                jd1.setVisible(true);

                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Integer a=Integer.valueOf(jt1.getText());
                        Integer b=Integer.valueOf(jt2.getText());
                        String c=jt3.getText();
                        try {
                            bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                            bw.write("增加设备类别信息：(id,设备编号，类别名称)"+a+" "+b+" "+ c+"\n");
                            bw.flush();
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                        try {
                            String sql = "insert into device1 values" +"(" + a + "," +b + ",'" + c + "'"+ ")";
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
        p1.add(jb2);
        jb3 = new JButton("删除");
        jb3.setBounds(630, 170, 120, 35);
        jb3.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\5.png"));
        jb3.setFont(new Font("黑体", 0, 15));
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row=d.getSelectedRow();
                if(row!=-1) {
                    int result = JOptionPane.showConfirmDialog(null, "确定要删除吗？","请确认",JOptionPane.YES_NO_OPTION);
                    if(result==JOptionPane.OK_OPTION)
                    {
//                        try {
//                            bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
//                            bw.write("删除设备类别信息：id:"+d.getValueAt(row,1).toString()+"\n");
//                            bw.flush();
//                        }catch (Exception e) {
//                            e.printStackTrace();
//                        }
                        try {
                            String sql = "DELETE FROM device1 WHERE num"+"="+Integer.parseInt(d.getValueAt(row,1).toString());
                            PreparedStatement ps = con.prepareStatement(sql);
                            ps.executeUpdate();
                        } catch (Exception throwables) {
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
                }else{
                    JOptionPane.showMessageDialog(null, "请选择要删除的行！","提示：",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        p1.add(jb3);
        jb4 = new JButton("修改");
        jb4.setBounds(630, 215, 120, 35);
        jb4.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\6.png"));
        jb4.setFont(new Font("黑体", 0, 15));
        p1.add(jb4);
        jb4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent act) {
                int row=d.getSelectedRow();
                if(row!=-1) {
                    int result = JOptionPane.showConfirmDialog(null, "确定要修改吗？","请确认",JOptionPane.YES_NO_OPTION);
                    if(result==JOptionPane.OK_OPTION)
                    {
                        JDialog jd1 = new JDialog();
                        jd1.setLayout(null);
                        jd1.setTitle("修改");
                        jd1.setBounds(900, 200, 600, 600);
                        JLabel ja=new JLabel("请输入新的信息");
                        ja.setFont(new Font("华文行楷",4,20));
                        ja.setBounds(225,-80,200,200);
                        jd1.add(ja,BorderLayout.NORTH);
                        JLabel ja1=new JLabel("编号:");
                        ja1.setFont(new Font("华文行楷",4,18));
                        ja1.setBounds(20,48,60,40);
                        jd1.add(ja1 );
                        JTextField jt1=new JTextField();
                        jt1.setText(d.getValueAt(row,1).toString());
                        jt1.setColumns(20);
                        jt1.setBounds(110,58,100,25);
                        jd1.add(jt1 );
                        JLabel ja2=new JLabel("类别名称:");
                        ja2.setFont(new Font("华文行楷",4,18));
                        ja2.setBounds(20,120,80,40);
                        jd1.add(ja2 );
                        JTextField jt2=new JTextField();
                        jt2.setText(d.getValueAt(row,2).toString());
                        jt2.setColumns(20);
                        jt2.setBounds(110,128,100,25);
                        jd1.add(jt2 );
                        JButton jb = new JButton("确定");
                        jb.setBounds(110,320,90,30);
                        jd1.add(jb);
                        jd1.setVisible(true);
                        jb.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                String st2=jt2.getText();
                                String st1=jt1.getText();
                                Integer a=Integer.parseInt(jt1.getText());
                                String b=jt2.getText();
//                                try {
//                                    bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
//                                    bw.write("修改设备类别信息：name:"+b+"\n");
//                                    bw.flush();
//                                }catch (Exception e) {
//                                    e.printStackTrace();
//                                }
                                try {
                                    String sql="update device1 set name='"+b+"' where num="+Integer.parseInt(d.getValueAt(row,1).toString());
                                    ps= con.prepareStatement(sql);
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
                                    } catch (SQLException y) {
                                        y.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "请选择修改的行！","提示：",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        jtb.add("设备类别管理",p1);
        //部门信息管理界面
        Object[][] table1 = new Object[40][4];
        Object[] name2 = {"部门编号", "部门名称", "负责人","电话"};
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBounds(0, 100, 800, 500);
        JTable d3=new JTable(table1,name2);
        d3.setRowHeight(25);
        JScrollPane js3 = new JScrollPane(d3);
        js3.setBounds(0, 0, 600, 400);
        p2.add(js3);
        jn = new JButton("查询全部");
        jn.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\2.png"));
        jn.setBounds(630, 35, 120, 35);
        jn.setFont(new Font("黑体", 0, 15));
        jn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i=0;i<40;i++)
                {
                    for(int j=0;j<4;j++)
                    {
                        d3.setValueAt(" ",i,j);
                    }
                }
//                try {
//                    bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
//                    bw.write("查询全部部门信息：\n");
//                    bw.flush();
//                }catch (Exception e) {
//                    e.printStackTrace();
//                }
                try {
                    ps = con.prepareStatement("select * from depart1");
                    rs = ps.executeQuery();
                    for (int i = 0; rs.next(); i++) {
                        int num = rs.getInt(1);
                        String name = rs.getString(2);
                        String le=rs.getString(3);
                        String tel= rs.getString(4);
                        d3.setValueAt(Integer.toString(num), i, 0);
                        d3.setValueAt(name, i, 1);
                        d3.setValueAt(le, i, 2);
                        d3.setValueAt(tel, i, 3);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
            }
        });
        p2.add(jn);
        jn1 = new JButton("查询");
        jn1.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\3.png"));
        jn1.setBounds(630, 80, 120, 35);
        jn1.setFont(new Font("黑体", 0, 15));
        jn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String st1 = JOptionPane.showInputDialog(null, "部门编号", "查询", 1);
                System.out.println(st1);
                int m = 0;
                try {
                    ps = con.prepareStatement("select * from depart1");
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        int num= rs.getInt(1);
                        String a = "" + num;
                        if (st1.equals(a)) {
                            m=1;
                            String name = rs.getString(2);
                            String le=rs.getString(3);
                            String tel= rs.getString(4);
                            d3.setValueAt(Integer.toString(num), 0, 0);
                            d3.setValueAt(name, 0, 1);
                            d3.setValueAt(le, 0, 2);
                            d3.setValueAt(tel, 0, 3);
//                            try {
//                                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
//                                bw.write("查询部门信息：部门编号："+num+"\n");
//                                bw.flush();
//                            }catch (Exception e) {
//                                e.printStackTrace();
//                            }
                        }
                    }
                    if (m == 0) {
                        JOptionPane.showMessageDialog(null, "您查找的数据不存在", "提示：", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
            }
        });
        p2.add(jn1);
        jn2 = new JButton("增加");
        jn2.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\4.png"));
        jn2.setBounds(630, 125, 120, 35);
        jn2.setFont(new Font("黑体", 0, 15));
        jn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog jd1 = new JDialog();
                jd1.setLayout(null);
                jd1.setTitle("增加");
                jd1.setBounds(900, 300, 600, 600);
                JLabel ja=new JLabel("请输入新的信息");
                ja.setFont(new Font("华文行楷",4,20));
                ja.setBounds(225,-80,200,200);
                jd1.add(ja,BorderLayout.NORTH);
                JLabel ja1=new JLabel("部门编号:");
                ja1.setFont(new Font("华文行楷",4,18));
                ja1.setBounds(20,48,80,40);
                jd1.add(ja1 );
                JTextField jt1=new JTextField();
                jt1.setColumns(20);
                jt1.setBounds(110,58,100,25);
                jd1.add(jt1 );
                JLabel ja2=new JLabel("部门名称:");
                ja2.setFont(new Font("华文行楷",4,18));
                ja2.setBounds(20,120,80,40);
                jd1.add(ja2 );
                JTextField jt2=new JTextField();
                jt2.setColumns(20);
                jt2.setBounds(110,128,100,25);
                jd1.add(jt2 );
                JLabel ja3=new JLabel("负责人:");
                ja3.setFont(new Font("华文行楷",4,18));
                ja3.setBounds(40,180,80,40);
                jd1.add(ja3 );
                JTextField jt3=new JTextField();
                jt3.setColumns(20);
                jt3.setBounds(110,190,100,25);
                jd1.add(jt3 );

                JLabel ja4=new JLabel("  电话:");
                ja4.setFont(new Font("华文行楷",4,18));
                ja4.setBounds(45,240,80,40);
                jd1.add(ja4 );
                JTextField jt4=new JTextField();
                jt4.setColumns(20);
                jt4.setBounds(110,250,100,25);
                jd1.add(jt4 );

                JButton jb = new JButton("确定");
                jb.setBounds(110,320,90,30);
                jd1.add(jb);
                jd1.setVisible(true);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Integer a=Integer.valueOf(jt1.getText());
                        String b=jt2.getText();
                        String c=jt3.getText();
                        String d=jt4.getText();
//                        try {
//                            bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
//                            bw.write("增加部门信息：\n"+a+" "+b+" "+c+" "+d+"\n");
//                            bw.flush();
//                        }catch (Exception e) {
//                            e.printStackTrace();
//                        }
                        try {
                            String sql = "insert into depart1 values" +"(" + a + ",'" +b + "','" + c+"','"+d+"'"+")";
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
        p2.add(jn2);
        jn3 = new JButton("删除");
        jn3.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\5.png"));
        jn3.setBounds(630, 170, 120, 35);
        jn3.setFont(new Font("黑体", 0, 15));
        jn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row=d3.getSelectedRow();
                if(row!=-1) {
                    int result = JOptionPane.showConfirmDialog(null, "确定要删除吗？","请确认",JOptionPane.YES_NO_OPTION);
                    if(result==JOptionPane.OK_OPTION)
                    {
//                        try {
//                            bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
//                            bw.write("删除部门信息：部门编号:"+d3.getValueAt(row,0).toString()+"\n");
//                            bw.flush();
//                        }catch (Exception e) {
//                            e.printStackTrace();
//                        }
                        try {
                            String sql = "DELETE FROM depart1 WHERE num"+"="+Integer.parseInt(d3.getValueAt(row,0).toString());
                            PreparedStatement preparedStatement = con.prepareStatement(sql);
                            preparedStatement.executeUpdate();
                        } catch (Exception throwables) {
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
                }else{
                    JOptionPane.showMessageDialog(null, "请选择要删除的行！","提示：",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        p2.add(jn3);
        jn4 = new JButton("修改");
        jn4.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\6.png"));
        jn4.setBounds(630, 215, 120, 35);
        jn.setFont(new Font("黑体", 0, 15));
        p2.add(jn4);
        jn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent act) {
                int row=d3.getSelectedRow();
                if(row!=-1) {
                    int result = JOptionPane.showConfirmDialog(null, "确定要修改吗？","请确认",JOptionPane.YES_NO_OPTION);
                    if(result==JOptionPane.OK_OPTION)
                    {
                        JDialog jd1 = new JDialog();
                        jd1.setLayout(null);
                        jd1.setTitle("修改");
                        jd1.setBounds(900, 200, 600, 600);
                        JLabel ja=new JLabel("请输入新的信息");
                        ja.setFont(new Font("华文行楷",4,20));
                        ja.setBounds(225,-80,200,200);
                        jd1.add(ja,BorderLayout.NORTH);

                        JLabel ja11=new JLabel("部门编号:");
                        ja11.setFont(new Font("华文行楷",4,18));
                        ja11.setBounds(20,28,80,40);
                        jd1.add(ja11 );
                        JTextField jt11=new JTextField();
                        jt11.setText(d3.getValueAt(row,0).toString());
                        String str= d3.getValueAt(row,0).toString();
                        jt11.setColumns(20);
                        jt11.setBounds(110,38,100,25);
                        jd1.add(jt11);

                        JLabel ja1=new JLabel("部门名称:");
                        ja1.setFont(new Font("华文行楷",4,18));
                        ja1.setBounds(20,88,80,40);
                        jd1.add(ja1 );
                        JTextField jt1=new JTextField();
                        jt1.setColumns(20);
                        jt1.setText(d3.getValueAt(row,1).toString());
                        jt1.setBounds(110,98,100,25);
                        jd1.add(jt1 );
                        JLabel ja2=new JLabel("负责人:");
                        ja2.setFont(new Font("华文行楷",4,18));
                        ja2.setBounds(30,148,80,40);
                        jd1.add(ja2 );
                        JTextField jt2=new JTextField();
                        jt2.setText(d3.getValueAt(row,2).toString());
                        jt2.setBounds(110,158,100,25);
                        jd1.add(jt2 );

                        JLabel ja3=new JLabel("  电话:");
                        ja3.setFont(new Font("华文行楷",4,18));
                        ja3.setBounds(45,208,80,40);
                        jd1.add(ja3);
                        JTextField jt3=new JTextField();
                        jt3.setColumns(20);
                        jt3.setText(d3.getValueAt(row,3).toString());
                        jt3.setBounds(110,218,100,25);
                        jd1.add(jt3);

                        JButton jb = new JButton("确定");
                        jb.setBounds(110,320,90,30);
                        jd1.add(jb);
                        jd1.setVisible(true);
                        jb.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                String st1=jt1.getText();
                                Integer a=Integer.valueOf(jt11.getText());
                                String st11=jt11.getText();
                                String st2=jt2.getText();
                                String st3=jt3.getText();
//                                try {
//                                    bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
//                                    bw.write("修改部门信息：\n"+a+" "+st1+" "+st2+" "+st3+"\n");
//                                    bw.flush();
//                                }catch (Exception e) {
//                                    e.printStackTrace();
//                                }
                                try {
                                    String sql="update depart1 set num="+a+","+"name="+"'"+st1+"',"+"le="+"'"+st2+"',"+"tel='"+st3+"'"+" where num="+str;
                                    PreparedStatement preparedStatement= con.prepareStatement(sql);
                                    preparedStatement.executeUpdate();
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
                                    } catch (SQLException y) {
                                        y.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "请选择修改的行！","提示：",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        jtb.add("部门信息管理",p2);

        //设备信息管理界面
        Object[][] table= new Object[40][6];
        Object[] name1 = {"设备编号", "设备类别","设备名字","部门名称", "设备状态","出厂日期"};
        JPanel p3 = new JPanel();
        p3.setLayout(null);
        p3.setBounds(0, 100, 800, 500);
        JTable d1=new JTable(table,name1);
        d1.setRowHeight(25);
        JScrollPane js2 = new JScrollPane(d1);
        js2.setBounds(0, 0, 600, 400);
        p3.add(js2);
        ju = new JButton("查询全部");
        ju.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\2.png"));
        ju.setBounds(630, 35, 120, 35);
        ju.setFont(new Font("黑体", 0, 15));
        ju.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i=0;i<40;i++)
                {
                    for(int j=0;j<6;j++)
                    {
                        d1.setValueAt(" ",i,j);
                    }
                }
                try {
                    ps = con.prepareStatement("select * from message");
                    rs = ps.executeQuery();
                    for (int i = 0; rs.next(); i++) {
                        int num = rs.getInt(1);
                        String name = rs.getString(2);
                        String fmname = rs.getString(3);
                        String dename= rs.getString(4);
                        String sta = rs.getString(5);
                        String data= rs.getString(6);
                        d1.setValueAt(Integer.toString(num), i, 0);
                        d1.setValueAt(name, i, 1);
                        d1.setValueAt(fmname, i, 2);
                        d1.setValueAt(dename, i, 3);
                        d1.setValueAt(sta, i, 4);
                        d1.setValueAt(data, i, 5);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
            }
        });
        p3.add(ju);
        ju1 = new JButton("查询");
        ju1.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\3.png"));
        ju1.setBounds(630, 80, 120, 35);
        ju1.setFont(new Font("黑体", 0, 15));
        ju1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String st1 = JOptionPane.showInputDialog(null, "编号", "查询", 1);
                System.out.println(st1);
                int m = 0;
                try {
                    ps = con.prepareStatement("select * from message");
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        int num= rs.getInt(1);
                        String a = "" + num;
                        if (st1.equals(a)) {
                            m = 1;
                            String name = rs.getString(2);
                            String fmname = rs.getString(3);
                            String dename= rs.getString(4);
                            String sta = rs.getString(5);
                            String data= rs.getString(6);
                            d1.setValueAt(Integer.toString(num), 0, 0);
                            d1.setValueAt(name, 0, 1);
                            d1.setValueAt(fmname, 0, 2);
                            d1.setValueAt(dename, 0, 3);
                            d1.setValueAt(sta, 0, 4);
                            d1.setValueAt(data, 0, 5);
                        }
                    }
                    if (m == 0) {
                        JOptionPane.showMessageDialog(null, "您查找的数据不存在", "提示：", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
            }
        });
        p3.add(ju1);
        ju2 = new JButton("增加");
        ju2.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\4.png"));
        ju2.setBounds(630, 125, 120, 35);
        ju2.setFont(new Font("黑体", 0, 15));
        ju2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog jd1 = new JDialog();
                jd1.setLayout(null);
                jd1.setTitle("增加");
                jd1.setBounds(900, 200, 600, 600);
                JLabel ja=new JLabel("请输入新的信息");
                ja.setFont(new Font("华文行楷",4,20));
                ja.setBounds(225,-80,200,200);
                jd1.add(ja,BorderLayout.NORTH);
                JLabel ja1=new JLabel("设备编号:");
                ja1.setFont(new Font("华文行楷",4,18));
                ja1.setBounds(20,48,80,40);
                jd1.add(ja1 );
                JTextField jt1=new JTextField();
                jt1.setColumns(20);
                jt1.setBounds(110,58,100,25);
                jd1.add(jt1 );

                JLabel ja2=new JLabel("设备类别:");
                ja2.setFont(new Font("华文行楷",4,18));
                ja2.setBounds(20,120,80,40);
                jd1.add(ja2 );
                String array1[]=new String[7];
                try {
                    ps = con.prepareStatement("select * from device1");
                    rs = ps.executeQuery();
                    for (int i = 0; rs.next(); i++) {
                        array1[i]=rs.getString(3);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
                JComboBox jcom1=new JComboBox(array1);
                jcom1.setBounds(110,128,100,25);
                jd1.add(jcom1);
                JLabel ja41=new JLabel("设备状态:");
                ja41.setFont(new Font("华文行楷",4,18));
                ja41.setBounds(20,300,80,40);
                jd1.add(ja41);

                JLabel ja22=new JLabel("设备名字:");
                ja22.setFont(new Font("华文行楷",4,18));
                ja22.setBounds(20,180,80,40);
                jd1.add(ja22);
                JTextField jt22=new JTextField();
                jt22.setColumns(20);
                jt22.setBounds(110,190,100,25);
                jd1.add(jt22);

                JLabel ja3=new JLabel("部门类别:");
                ja3.setFont(new Font("华文行楷",4,18));
                ja3.setBounds(20,240,80,40);
                jd1.add(ja3 );

                String array2[]=new String[7];
                try {
                    ps = con.prepareStatement("select * from depart1");
                    rs = ps.executeQuery();
                    for (int i = 0; rs.next(); i++) {
                        array2[i]=rs.getString(2);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
                JComboBox jcom2=new JComboBox(array2);
                jcom2.setBounds(110,250,100,25);
                jd1.add(jcom2);
                JLabel ja4=new JLabel("设备状态:");
                ja4.setFont(new Font("华文行楷",4,18));
                ja4.setBounds(20,300,80,40);
                jd1.add(ja4 );

                Object array[]={"已报废","维修中","使用中","闲置中"};
                JComboBox jcom=new JComboBox(array);
                jcom.setBounds(110,310,100,25);
                jd1.add(jcom);
                JLabel ja5=new JLabel("出厂日期:");
                ja5.setFont(new Font("华文行楷",4,18));
                ja5.setBounds(20,360,80,40);
                jd1.add(ja5 );
                JTextField jt5=new JTextField();
                jt5.setColumns(20);
                jt5.setBounds(110,370,100,25);
                jd1.add(jt5);
                JButton jb = new JButton("确定");
                jb.setBounds(110,420,90,30);
                jd1.add(jb);
                jd1.setVisible(true);

                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Integer a=Integer.valueOf(jt1.getText());
                        String b=jcom1.getSelectedItem().toString();
                        String c=jcom2.getSelectedItem().toString();
                        String d=jcom.getSelectedItem().toString();
                        String e=jt5.getText();
                        String f=jt22.getText();
                        try {
                            String sql = "insert into message values" +"(" + a + ",'" +b + "','" +f+"','"+c+ "','" +d +"','"+e+"'"+")";
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
        p3.add(ju2);
        ju3 = new JButton("删除");
        ju3.setBounds(630, 170, 120, 35);
        ju3.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\5.png"));
        ju3.setFont(new Font("黑体", 0, 15));
        ju3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row=d1.getSelectedRow();
                if(row!=-1) {
                    int r1= JOptionPane.showConfirmDialog(null, "确定要删除吗？","请确认",JOptionPane.YES_NO_OPTION);
                    if(r1==JOptionPane.OK_OPTION)
                    {
                        try {
                            String sql = "DELETE FROM message WHERE num"+"="+Integer.parseInt(d1.getValueAt(row,0).toString());
                            PreparedStatement preparedStatement = con.prepareStatement(sql);
                            preparedStatement.executeUpdate();
                        } catch (Exception throwables) {
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
                }else{
                    JOptionPane.showMessageDialog(null, "请选择要删除的行！","提示：",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        p3.add(ju3);
        ju4 = new JButton("修改");
        ju4.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\6.png"));
        ju4.setBounds(630, 215, 120, 35);
        ju4.setFont(new Font("黑体", 0, 15));
        p3.add(ju4);
        ju4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent act) {
                int row=d1.getSelectedRow();
                if(row!=-1) {
                    int result = JOptionPane.showConfirmDialog(null, "确定要修改吗？","请确认",JOptionPane.YES_NO_OPTION);
                    if(result==JOptionPane.OK_OPTION)
                    {
                        JDialog jd1 = new JDialog();
                        jd1.setLayout(null);
                        jd1.setTitle("修改");
                        jd1.setBounds(900, 200, 600, 600);
                        JLabel ja=new JLabel("请输入新的信息");
                        ja.setFont(new Font("华文行楷",4,20));
                        ja.setBounds(225,-80,200,200);
                        jd1.add(ja,BorderLayout.NORTH);
                        JLabel ja1=new JLabel("设备编号:");
                        ja1.setFont(new Font("华文行楷",4,18));
                        ja1.setBounds(20,48,80,40);
                        jd1.add(ja1 );
                        JTextField jt1=new JTextField();
                        jt1.setColumns(20);
                        jt1.setText(d1.getValueAt(row,0).toString());
                        jt1.setBounds(110,58,100,25);
                        jd1.add(jt1 );

                        JLabel ja2=new JLabel("设备类别:");
                        ja2.setFont(new Font("华文行楷",4,18));
                        ja2.setBounds(20,108,80,40);
                        jd1.add(ja2 );
                        JTextField jt2=new JTextField();
                        jt2.setText(d1.getValueAt(row,1).toString());
                        jt2.setColumns(20);
                        jt2.setBounds(110,118,100,25);
                        jd1.add(jt2);

                        JLabel ja3=new JLabel("设备名字:");
                        ja3.setFont(new Font("华文行楷",4,18));
                        ja3.setBounds(20,178,80,40);
                        jd1.add(ja3);
                        JTextField jt3=new JTextField();
                        jt3.setText(d1.getValueAt(row,2).toString());
                        jt3.setColumns(20);
                        jt3.setBounds(110,188,100,25);
                        jd1.add(jt3);

                        JLabel ja4=new JLabel("部门名称:");
                        ja4.setFont(new Font("华文行楷",4,18));
                        ja4.setBounds(20,238,80,40);
                        jd1.add(ja4);
                        JTextField jt4=new JTextField();
                        jt4.setText(d1.getValueAt(row,3).toString());
                        jt4.setColumns(20);
                        jt4.setBounds(110,248,100,25);
                        jd1.add(jt4);

                        JLabel ja5=new JLabel("设备状态:");
                        ja5.setFont(new Font("华文行楷",4,18));
                        ja5.setBounds(20,298,80,40);
                        jd1.add(ja5);
                        Object array[]={"已报废","维修中","使用中","闲置中"};
                        JComboBox jcom=new JComboBox(array);
                        jcom.setBounds(110,308,100,25);
                        jd1.add(jcom);

                        JLabel ja6=new JLabel("出厂日期:");
                        ja6.setFont(new Font("华文行楷",4,18));
                        ja6.setBounds(20,358,80,40);
                        jd1.add(ja6);
                        JTextField jt6=new JTextField();
                        jt6.setText(d1.getValueAt(row,5).toString());
                        jt6.setColumns(20);
                        jt6.setBounds(110,368,100,25);
                        jd1.add(jt6);
                        JButton jb = new JButton("确定");
                        jb.setBounds(110,428,90,30);
                        jd1.add(jb);
                        jd1.setVisible(true);
                        jb.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                String st1=jt1.getText();
                                Integer a=Integer.parseInt(jt1.getText());
                                String st2=jt2.getText();
                                String st3=jt3.getText();
                                String st4=jt4.getText();
                                String st5=null;
                                if(jcom.getSelectedIndex()==0){
                                    st5="已报废";
                                }else if(jcom.getSelectedIndex()==1){
                                    st5="维修中";
                                }else if(jcom.getSelectedIndex()==2){
                                    st5="使用中";
                                }else{
                                    st5="闲置中";
                                }
                                String st6=jt6.getText();
                                try {
                                    String sql="update message set num="+a+","+"name="+"'"+st2+"',"+"fmname="+"'"+st3+"',"+"dename='"+st4+"',"+"sta='"+st5+"',"
                                            +"data="+"'"+st6+"'"+" where num="+d1.getValueAt(row,0);
                                    ps= con.prepareStatement(sql);
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
                                    } catch (SQLException y) {
                                        y.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "请选择修改的行！","提示：",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        //创建三个面板
        jtb.add("设备信息管理",p3);

        Object[][] table2 = new Object[40][7];
        Object[] name3 = {"使用部门", "使用设备","使用人", "联系电话","用途","使用开始日期","预计归还日期"};
        JPanel p4 = new JPanel();
        p4.setLayout(null);
        p4.setBounds(0, 100, 800, 500);
        JTable d4=new JTable(table2,name3);
        d4.setRowHeight(25);
        JScrollPane js4 = new JScrollPane(d4);
        js4.setBounds(0, 0, 600, 400);
        p4.add(js4);
        jc = new JButton("查询全部");
        jc.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\2.png"));
        jc.setBounds(630, 35, 120, 35);
        jc.setFont(new Font("黑体", 0, 15));
        jc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i=0;i<40;i++)
                {
                    for(int j=0;j<7;j++)
                    {
                        d4.setValueAt(" ",i,j);
                    }
                }
                try {
                    ps = con.prepareStatement("select * from usedevice");
                    rs = ps.executeQuery();
                    for (int i = 0; rs.next(); i++) {
                        String dep=rs.getString(1);
                        String devname=rs.getString(2);
                        String pename=rs.getString(3);
                        String tel= rs.getString(4);
                        String using=rs.getString(5);
                        String data1=rs.getString(6);
                        String data2=rs.getString(7);

                        d4.setValueAt(dep, i, 0);
                        d4.setValueAt(devname, i, 1);
                        d4.setValueAt(pename, i, 2);
                        d4.setValueAt(tel, i, 3);
                        d4.setValueAt(using, i, 4);
                        d4.setValueAt(data1, i, 5);
                        d4.setValueAt(data2, i, 6);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }



            }
        });
        p4.add(jc);
        jc1 = new JButton("查询");
        jc1.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\3.png"));
        jc1.setBounds(630, 80, 120, 35);
        jc1.setFont(new Font("黑体", 0, 15));
        jc1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String st1 = JOptionPane.showInputDialog(null, "使用人", "查询", 1);
                System.out.println(st1);
                int m = 0;
                try {
                    ps = con.prepareStatement("select * from usedevice");
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        String a =rs.getString(2);
                        if (st1.equals(a)) {
                            m = 1;
                            String dep=rs.getString(1);
                            String devname=rs.getString(2);
                            String pename=rs.getString(3);
                            String tel= rs.getString(4);
                            String using=rs.getString(5);
                            String data1=rs.getString(6);
                            String data2=rs.getString(7);

                            d4.setValueAt(dep, 0, 0);
                            d4.setValueAt(devname, 0, 1);
                            d4.setValueAt(pename, 0, 2);
                            d4.setValueAt(tel, 0, 3);
                            d4.setValueAt(using, 0, 4);
                            d4.setValueAt(data1, 0, 5);
                            d4.setValueAt(data2, 0, 6);
                        }
                    }
                    if (m == 0) {
                        JOptionPane.showMessageDialog(null, "您查找的数据不存在", "提示：", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
            }
        });
        p4.add(jc1);
        jc2 = new JButton("增加");
        jc2.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\4.png"));
        jc2.setBounds(630, 125, 120, 35);
        jc2.setFont(new Font("黑体", 0, 15));
        jc2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog jd1 = new JDialog();
                jd1.setLayout(null);
                jd1.setTitle("增加");
                jd1.setBounds(900, 200, 600, 600);
                JLabel ja=new JLabel("请输入新的信息");
                ja.setFont(new Font("华文行楷",4,20));
                ja.setBounds(225,-80,200,200);
                jd1.add(ja,BorderLayout.NORTH);

                JLabel ja1=new JLabel("使用部门:");
                ja1.setFont(new Font("华文行楷",4,18));
                ja1.setBounds(40,48,100,40);
                jd1.add(ja1 );
                JTextField jt1=new JTextField();
                jt1.setColumns(20);
                jt1.setBounds(130,58,100,25);
                jd1.add(jt1 );


                JLabel ja11=new JLabel("使用设备:");
                ja11.setFont(new Font("华文行楷",4,18));
                ja11.setBounds(40,120,100,40);
                jd1.add(ja11 );
                JTextField jt11=new JTextField();
                jt11.setColumns(20);
                jt11.setBounds(130,128,100,25);
                jd1.add(jt11);


                JLabel ja2=new JLabel("使用人:");
                ja2.setFont(new Font("华文行楷",4,18));
                ja2.setBounds(60,180,100,40);
                jd1.add(ja2 );
                JTextField jt2=new JTextField();
                jt2.setColumns(20);
                jt2.setBounds(130,190,100,25);
                jd1.add(jt2 );

                JLabel ja22=new JLabel("联系电话：");
                ja22.setFont(new Font("华文行楷",4,18));
                ja22.setBounds(40,240,100,40);
                jd1.add(ja22);
                JTextField jt22=new JTextField();
                jt22.setColumns(20);
                jt22.setBounds(130,250,100,25);
                jd1.add(jt22);

                JLabel ja3=new JLabel("用 途:");
                ja3.setFont(new Font("华文行楷",4,18));
                ja3.setBounds(65,300,100,40);
                jd1.add(ja3 );
                JTextField jt3=new JTextField();
                jt3.setColumns(20);
                jt3.setBounds(130,310,100,25);
                jd1.add(jt3 );
                JLabel ja4=new JLabel("使用开始日期:");
                ja4.setFont(new Font("华文行楷",4,18));
                ja4.setBounds(10,360,120,40);
                jd1.add(ja4 );

                JTextField jt4=new JTextField();
                jt4.setColumns(20);
                jt4.setBounds(130,370,100,25);
                jd1.add(jt4);

                JLabel ja5=new JLabel("预计归还日期:");
                ja5.setFont(new Font("华文行楷",4,18));
                ja5.setBounds(10,420,120,40);
                jd1.add(ja5 );
                JTextField jt5=new JTextField();
                jt5.setColumns(20);
                jt5.setBounds(130,430,100,25);
                jd1.add(jt5);
                JButton jb = new JButton("确定");
                jb.setBounds(130,500,90,30);
                jd1.add(jb);
                jd1.setVisible(true);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        String a=jt1.getText();
                        String a1=jt11.getText();
                        String b=jt2.getText();
                        String c=jt22.getText();
                        String d=jt3.getText();
                        String e=jt4.getText();
                        String f=jt5.getText();
                        try {
                            String sql = "insert into usedevice values" +"("+"'"+ a + "','"+a1+"','"+b + "','" +c+"','"+d+ "','" +e+"','"+f+"'"+")";
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
                            } catch (SQLException a11) {
                                a11.printStackTrace();
                            }
                        }
                    }
                });
            }
        });
        p4.add(jc2);
        jc3 = new JButton("删除");
        jc3.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\5.png"));
        jc3.setBounds(630, 170, 120, 35);
        jc3.setFont(new Font("黑体", 0, 15));
        jc3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row=d4.getSelectedRow();
                if(row!=-1) {
                    int result = JOptionPane.showConfirmDialog(null, "确定要删除吗？","请确认",JOptionPane.YES_NO_OPTION);
                    if(result==JOptionPane.OK_OPTION)
                    {
                        try {
                            String sql = "DELETE FROM usedevice WHERE pename"+"="+"'"+d4.getValueAt(row,2).toString()+"'";
                            PreparedStatement preparedStatement = con.prepareStatement(sql);
                            preparedStatement.executeUpdate();
                        } catch (Exception throwables) {
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
                }else{
                    JOptionPane.showMessageDialog(null, "请选择要删除的行！","提示：",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        p4.add(jc3);
        jc4 = new JButton("修改");
        jc4.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\6.png"));
        jc4.setBounds(630, 215, 120, 35);
        jn.setFont(new Font("黑体", 0, 15));
        p4.add(jc4);
        jc4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent act) {
                int row=d4.getSelectedRow();
                if(row!=-1) {
                    int result = JOptionPane.showConfirmDialog(null, "确定要修改吗？","请确认",JOptionPane.YES_NO_OPTION);
                    if(result==JOptionPane.OK_OPTION)
                    {
                        JDialog jd1 = new JDialog();
                        jd1.setLayout(null);
                        jd1.setTitle("修改");
                        jd1.setBounds(900, 200, 600, 600);
                        JLabel ja=new JLabel("请输入新的信息");
                        ja.setFont(new Font("华文行楷",4,20));
                        ja.setBounds(225,-80,200,200);
                        jd1.add(ja,BorderLayout.NORTH);
                        JLabel ja1=new JLabel("使用部门:");
                        ja1.setFont(new Font("华文行楷",4,18));
                        ja1.setBounds(40,48,100,40);
                        jd1.add(ja1 );
                        JTextField jt1=new JTextField();
                        jt1.setText(d4.getValueAt(row,0).toString());
                        jt1.setColumns(20);
                        jt1.setBounds(130,58,100,25);
                        jd1.add(jt1 );


                        JLabel ja11=new JLabel("使用设备:");
                        ja11.setFont(new Font("华文行楷",4,18));
                        ja11.setBounds(40,120,100,40);
                        jd1.add(ja11 );
                        JTextField jt11=new JTextField();
                        jt11.setText(d4.getValueAt(row,1).toString());
                        jt11.setColumns(20);
                        jt11.setBounds(130,128,100,25);
                        jd1.add(jt11);


                        JLabel ja2=new JLabel("使用人:");
                        ja2.setFont(new Font("华文行楷",4,18));
                        ja2.setBounds(60,180,100,40);
                        jd1.add(ja2 );
                        JTextField jt2=new JTextField();
                        jt2.setText(d4.getValueAt(row,2).toString());
                        jt2.setColumns(20);
                        jt2.setBounds(130,190,100,25);
                        jd1.add(jt2 );

                        JLabel ja22=new JLabel("联系电话：");
                        ja22.setFont(new Font("华文行楷",4,18));
                        ja22.setBounds(40,240,100,40);
                        jd1.add(ja22);
                        JTextField jt22=new JTextField();
                        jt22.setText(d4.getValueAt(row,3).toString());
                        jt22.setColumns(20);
                        jt22.setBounds(130,250,100,25);
                        jd1.add(jt22);

                        JLabel ja3=new JLabel("用 途:");
                        ja3.setFont(new Font("华文行楷",4,18));
                        ja3.setBounds(65,300,100,40);
                        jd1.add(ja3 );
                        JTextField jt3=new JTextField();
                        jt3.setText(d4.getValueAt(row,4).toString());
                        jt3.setColumns(20);
                        jt3.setBounds(130,310,100,25);
                        jd1.add(jt3 );
                        JLabel ja4=new JLabel("使用开始日期:");
                        ja4.setFont(new Font("华文行楷",4,18));
                        ja4.setBounds(10,360,120,40);
                        jd1.add(ja4 );

                        JTextField jt4=new JTextField();
                        jt4.setColumns(20);
                        jt4.setText(d4.getValueAt(row,5).toString());
                        jt4.setBounds(130,370,100,25);
                        jd1.add(jt4);

                        JLabel ja5=new JLabel("预计归还日期:");
                        ja5.setFont(new Font("华文行楷",4,18));
                        ja5.setBounds(10,420,120,40);
                        jd1.add(ja5 );
                        JTextField jt5=new JTextField();
                        jt5.setText(d4.getValueAt(row,6).toString());
                        jt5.setColumns(20);
                        jt5.setBounds(130,430,100,25);
                        jd1.add(jt5);
                        JButton jb = new JButton("确定");
                        jb.setBounds(130,470,90,30);
                        jd1.add(jb);
                        jd1.setVisible(true);
                        jb.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                String a=jt1.getText();
                                String a2=jt11.getText();
                                String b=jt2.getText();
                                String c=jt22.getText();
                                String d=jt3.getText();
                                String e=jt4.getText();
                                String f=jt5.getText();
                                try {
                                    String sql="update usedevice set dep='"+a+"',"+"devname='"+a2+"',"+"pename='"+b+"',"+"tel='"+c+"',"+"deuse='"+d+"',"+"data1='"+e+"',"+"data2='"+f+"'"+" where dep='"+d4.getValueAt(row,0).toString()+"'";
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
                                    } catch (SQLException y) {
                                        y.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "请选择修改的行！","提示：",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        jtbp.add("设备使用信息管理", p4);

        Object[][] table3 = new Object[40][7];
        Object[] name4 = {"维修设备编号","设备名称","故障问题","维修地点","维修负责人","维修开始日期","预计维修结束日期"};
        JPanel p5 = new JPanel();
        p5.setLayout(null);
        p5.setBounds(0, 100, 900, 500);
        JTable d5=new JTable(table3,name4);
        d5.setRowHeight(25);
        JScrollPane js5 = new JScrollPane(d5);
        js5.setBounds(0, 0, 800, 400);
        p5.add(js5);
        jo = new JButton("查询全部");
        jo.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\2.png"));
        jo.setBounds(830, 35, 120, 35);
        jo.setFont(new Font("黑体", 0, 15));
        jo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i=0;i<40;i++)
                {
                    for(int j=0;j<7;j++)
                    {
                        d5.setValueAt(" ",i,j);
                    }
                }
                try {
                    ps = con.prepareStatement("select * from modify");
                    rs = ps.executeQuery();
                    for (int i = 0; rs.next(); i++) {
                        int num1= rs.getInt(1);
                        String name1=rs.getString(2);
                        String pro=rs.getString(3);
                        String place=rs.getString(4);
                        String duty=rs.getString(5);
                        String data1=rs.getString(6);
                        String data2=rs.getString(7);
                        d5.setValueAt(Integer.toString(num1), i, 0);
                        d5.setValueAt(name1, i, 1);
                        d5.setValueAt(pro, i, 2);
                        d5.setValueAt(place, i, 3);
                        d5.setValueAt(duty, i, 4);
                        d5.setValueAt(data1, i, 5);
                        d5.setValueAt(data2, i, 6);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
            }
        });
        p5.add(jo);
        jo1 = new JButton("查询");
        jo1.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\3.png"));
        jo1.setBounds(830, 80, 120, 35);
        jo1.setFont(new Font("黑体", 0, 15));
        jo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String st1 = JOptionPane.showInputDialog(null, "编号", "查询", 1);
                System.out.println(st1);
                int m = 0;
                try {
                    ps = con.prepareStatement("select * from modify");
                    rs = ps.executeQuery();
                    while (rs.next()) {
                        int num1 = rs.getInt(1);
                        String a = "" + num1;
                        if (st1.equals(a)) {
                            m = 1;
                            String name1=rs.getString(2);
                            String pro=rs.getString(3);
                            String place=rs.getString(4);
                            String duty=rs.getString(5);
                            String data1=rs.getString(6);
                            String data2=rs.getString(7);
                            d5.setValueAt(Integer.toString(num1), 0, 0);
                            d5.setValueAt(name1, 0, 1);
                            d5.setValueAt(pro, 0, 2);
                            d5.setValueAt(place, 0, 3);
                            d5.setValueAt(duty, 0, 4);
                            d5.setValueAt(data1, 0, 5);
                            d5.setValueAt(data2, 0, 6);
                        }
                    }
                    if (m == 0) {
                        JOptionPane.showMessageDialog(null, "您查找的数据不存在", "提示：", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
            }
        });
        p5.add(jo1);
        jo2 = new JButton("增加");
        jo2.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\4.png"));
        jo2.setBounds(830, 125, 120, 35);
        jo2.setFont(new Font("黑体", 0, 15));
        jo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog jd1 = new JDialog();
                jd1.setLayout(null);
                jd1.setTitle("增加");
                jd1.setBounds(900, 200, 600, 600);
                JLabel ja=new JLabel("请输入新的信息");
                ja.setFont(new Font("华文行楷",4,20));
                ja.setBounds(225,-80,200,200);
                jd1.add(ja,BorderLayout.NORTH);


                JLabel ja1=new JLabel("维修设备编号:");
                ja1.setFont(new Font("华文行楷",4,18));
                ja1.setBounds(10,48,130,40);
                jd1.add(ja1 );
                JTextField jt1=new JTextField();
                jt1.setColumns(20);
                jt1.setBounds(130,58,100,25);
                jd1.add(jt1 );


                JLabel ja2=new JLabel("设备名称:");
                ja2.setFont(new Font("华文行楷",4,18));
                ja2.setBounds(40,120,100,40);
                jd1.add(ja2 );
                JTextField jt2=new JTextField();
                jt2.setColumns(20);
                jt2.setBounds(130,128,100,25);
                jd1.add(jt2 );

                JLabel ja22=new JLabel("故障问题：");
                ja22.setFont(new Font("华文行楷",4,18));
                ja22.setBounds(40,180,100,40);
                jd1.add(ja22);
                JTextField jt22=new JTextField();
                jt22.setColumns(20);
                jt22.setBounds(130,190,100,25);
                jd1.add(jt22);

                JLabel ja3=new JLabel("维修地点：");
                ja3.setFont(new Font("华文行楷",4,18));
                ja3.setBounds(40,240,100,40);
                jd1.add(ja3 );
                JTextField jt3=new JTextField();
                jt3.setColumns(20);
                jt3.setBounds(130,250,100,25);
                jd1.add(jt3 );
                JLabel ja4=new JLabel("维修负责人:");
                ja4.setFont(new Font("华文行楷",4,18));
                ja4.setBounds(30,300,120,40);
                jd1.add(ja4 );

                JTextField jt4=new JTextField();
                jt4.setColumns(20);
                jt4.setBounds(130,310,100,25);
                jd1.add(jt4);

                JLabel ja5=new JLabel("维修开始日期:");
                ja5.setFont(new Font("华文行楷",4,18));
                ja5.setBounds(10,360,120,40);
                jd1.add(ja5 );
                JTextField jt5=new JTextField();
                jt5.setColumns(20);
                jt5.setBounds(130,370,100,25);
                jd1.add(jt5);

                JLabel ja6=new JLabel("维修开始日期:");
                ja6.setFont(new Font("华文行楷",4,18));
                ja6.setBounds(10,420,120,40);
                jd1.add(ja6);
                JTextField jt6=new JTextField();
                jt6.setColumns(20);
                jt6.setBounds(130,430,100,25);
                jd1.add(jt6);

                JButton jb = new JButton("确定");
                jb.setBounds(130,470,90,30);
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
                        try {
                            String sql = "insert into modify values" +"("+ a + ",'" +b + "','" +c+"','"+d+ "','" +e+"','"+f+"','"+g+"'"+")";
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
        p5.add(jo2);
        jo3 = new JButton("删除");
        jo3.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\5.png"));
        jo3.setBounds(830, 170, 120, 35);
        jo3.setFont(new Font("黑体", 0, 15));
        jo3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row=d5.getSelectedRow();
                if(row!=-1) {
                    int result = JOptionPane.showConfirmDialog(null, "确定要删除吗？","请确认",JOptionPane.YES_NO_OPTION);
                    if(result==JOptionPane.OK_OPTION)
                    {
                        try {
                            String sql = "DELETE FROM modify WHERE num1"+"="+Integer.parseInt(d5.getValueAt(row,0).toString());
                            PreparedStatement preparedStatement = con.prepareStatement(sql);
                            preparedStatement.executeUpdate();
                        } catch (Exception throwables) {
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
                }else{
                    JOptionPane.showMessageDialog(null, "请选择要删除的行！","提示：",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        p5.add(jo3);
        jo4 = new JButton("修改");
        jo4.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\6.png"));
        jo4.setBounds(830, 215, 120, 35);
        jn.setFont(new Font("黑体", 0, 15));
        p5.add(jo4);
        jo4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent act) {
                int row=d5.getSelectedRow();
                if(row!=-1) {
                    int result = JOptionPane.showConfirmDialog(null, "确定要修改吗？","请确认",JOptionPane.YES_NO_OPTION);
                    if(result==JOptionPane.OK_OPTION)
                    {
                        JDialog jd1 = new JDialog();
                        jd1.setLayout(null);
                        jd1.setTitle("修改");
                        jd1.setBounds(900, 200, 600, 600);
                        JLabel ja=new JLabel("请输入新的信息");
                        ja.setFont(new Font("华文行楷",4,20));
                        ja.setBounds(225,-80,200,200);
                        jd1.add(ja,BorderLayout.NORTH);
                        JLabel ja1=new JLabel("维修设备编号:");
                        ja1.setFont(new Font("华文行楷",4,18));
                        ja1.setBounds(10,48,130,40);
                        jd1.add(ja1 );
                        JTextField jt1=new JTextField();
                        jt1.setText(d5.getValueAt(row,0).toString());
                        jt1.setColumns(20);
                        jt1.setBounds(130,58,100,25);
                        jd1.add(jt1 );


                        JLabel ja2=new JLabel("设备名称:");
                        ja2.setFont(new Font("华文行楷",4,18));
                        ja2.setBounds(40,120,100,40);
                        jd1.add(ja2 );
                        JTextField jt2=new JTextField();
                        jt2.setText(d5.getValueAt(row,1).toString());
                        jt2.setColumns(20);
                        jt2.setBounds(130,128,100,25);
                        jd1.add(jt2 );

                        JLabel ja22=new JLabel("故障问题：");
                        ja22.setFont(new Font("华文行楷",4,18));
                        ja22.setBounds(40,180,100,40);
                        jd1.add(ja22);
                        JTextField jt3=new JTextField();
                        jt3.setText(d5.getValueAt(row,2).toString());
                        jt3.setColumns(20);
                        jt3.setBounds(130,190,100,25);
                        jd1.add(jt3);

                        JLabel ja3=new JLabel("维修地点：");
                        ja3.setFont(new Font("华文行楷",4,18));
                        ja3.setBounds(40,240,100,40);
                        jd1.add(ja3 );
                        JTextField jt4=new JTextField();
                        jt4.setText(d5.getValueAt(row,3).toString());
                        jt4.setColumns(20);
                        jt4.setBounds(130,250,100,25);
                        jd1.add(jt4);
                        JLabel ja4=new JLabel("维修负责人:");
                        ja4.setFont(new Font("华文行楷",4,18));
                        ja4.setBounds(30,300,120,40);
                        jd1.add(ja4 );

                        JTextField jt5=new JTextField();
                        jt5.setText(d5.getValueAt(row,4).toString());
                        jt5.setColumns(20);
                        jt5.setBounds(130,310,100,25);
                        jd1.add(jt5);

                        JLabel ja5=new JLabel("维修开始日期:");
                        ja5.setFont(new Font("华文行楷",4,18));
                        ja5.setBounds(10,360,120,40);
                        jd1.add(ja5 );
                        JTextField jt6=new JTextField();
                        jt6.setText(d5.getValueAt(row,5).toString());
                        jt6.setColumns(20);
                        jt6.setBounds(130,370,100,25);
                        jd1.add(jt6);

                        JLabel ja6=new JLabel("维修开始日期:");
                        ja6.setFont(new Font("华文行楷",4,18));
                        ja6.setBounds(10,420,120,40);
                        jd1.add(ja6);
                        JTextField jt7=new JTextField();
                        jt7.setText(d5.getValueAt(row,6).toString());
                        jt7.setColumns(20);
                        jt7.setBounds(130,430,100,25);
                        jd1.add(jt7);
                        JButton jb = new JButton("确定");
                        jb.setBounds(130,470,90,30);
                        jd1.add(jb);
                        jd1.setVisible(true);
                        jb.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                Integer a=Integer.valueOf(jt1.getText());
                                String b=jt2.getText();
                                String c=jt3.getText();
                                String d=jt4.getText();
                                String e=jt5.getText();
                                String f=jt6.getText();
                                String g=jt7.getText();
                                try {
                                    String sql="update modify set num1="+a+","+"name1='"+b+"',"+"pro='"+c+"',"+"place='"+d+"',"+"duty='"+e+
                                            "',"+"data1='"+f+"',"+"data2='"+g+"'"+" where num1="+a;
                                    PreparedStatement preparedStatement= con.prepareStatement(sql);
                                    preparedStatement.executeUpdate();
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
                                    } catch (SQLException y) {
                                        y.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "请选择修改的行！","提示：",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        jtbp.add("设备维修信息管理", p5);
        Object[][] table4 = new Object[40][5];
        Object[] name5 = {"设备编号","检验内容", "预期目标", "检验负责人", "检验日期"};
        JPanel p66 = new JPanel();
        p66.setLayout(null);
        p66.setBounds(0, 100, 800, 500);
        JTable d6=new JTable(table4,name5);
        d6.setRowHeight(25);
        JScrollPane js6 = new JScrollPane(d6);
        //d6.setBackground(Color.LIGHT_GRAY);
        js6.setBounds(0, 0, 600, 400);
        p66.add(js6);
        jk = new JButton("查询全部");
        jk.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\2.png"));
        jk.setBounds(630, 35, 120, 35);
        jk.setFont(new Font("黑体", 0, 15));
        jk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i=0;i<40;i++)
                {
                    for(int j=0;j<5;j++)
                    {
                        d6.setValueAt(" ",i,j);
                    }
                }
                try {
                    ps = con.prepareStatement("select * from check1");
                    rs = ps.executeQuery();
                    for (int i = 0; rs.next(); i++) {
                        int num5=rs.getInt(1);
                        String info = rs.getString(2);
                        String goal = rs.getString(3);
                        String resp = rs.getString(4);
                        String data4 = rs.getString(5);
                        d6.setValueAt(Integer.toString(num5), i, 0);
                        d6.setValueAt(info, i, 1);
                        d6.setValueAt(goal, i, 2);
                        d6.setValueAt(resp, i, 3);
                        d6.setValueAt(data4, i, 4);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
            }
        });
        p66.add(jk);
        jk1 = new JButton("查询");
        jk1.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\3.png"));
        jk1.setBounds(630, 80, 120, 35);
        jk1.setFont(new Font("黑体", 0, 15));
        jk1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String st1 = JOptionPane.showInputDialog(null, "编号", "查询", 1);
                int m = 0;
                try {
                    ps = con.prepareStatement("select * from check1");
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        int num5=rs.getInt(1);
                        String a =""+num5;
                        if (st1.equals(a)) {
                            m = 1;
                            String info = rs.getString(2);
                            String goal = rs.getString(3);
                            String resp = rs.getString(4);
                            String data4 = rs.getString(5);
                            d6.setValueAt(Integer.toString(num5), 0, 0);
                            d6.setValueAt(info, 0, 0);
                            d6.setValueAt(goal, 0, 1);
                            d6.setValueAt(resp, 0, 2);
                            d6.setValueAt(data4, 0, 3);
                        }
                    }
                    if (m == 0) {
                        JOptionPane.showMessageDialog(null, "您查找的数据不存在", "提示：", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
            }
        });
        p66.add(jk1);
        jk2 = new JButton("增加");
        jk2.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\4.png"));
        jk2.setBounds(630, 125, 120, 35);
        jk2.setFont(new Font("黑体", 0, 15));
        jk2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog jd1 = new JDialog();
                jd1.setLayout(null);
                jd1.setTitle("增加");
                jd1.setBounds(900, 200, 600, 600);
                JLabel ja=new JLabel("请输入新的信息");
                ja.setFont(new Font("华文行楷",4,20));
                ja.setBounds(225,-80,200,200);
                jd1.add(ja,BorderLayout.NORTH);

                JLabel ja1=new JLabel("设备编号:");
                ja1.setFont(new Font("华文行楷",4,18));
                ja1.setBounds(20,48,130,40);
                jd1.add(ja1 );
                JTextField jt1=new JTextField();
                jt1.setColumns(20);
                jt1.setBounds(130,58,100,25);
                jd1.add(jt1 );


                JLabel ja2=new JLabel("检验内容:");
                ja2.setFont(new Font("华文行楷",4,18));
                ja2.setBounds(20,120,100,40);
                jd1.add(ja2 );
                JTextField jt2=new JTextField();
                jt2.setColumns(20);
                jt2.setBounds(130,128,100,25);
                jd1.add(jt2 );

                JLabel ja22=new JLabel("预期目标：");
                ja22.setFont(new Font("华文行楷",4,18));
                ja22.setBounds(20,180,100,40);
                jd1.add(ja22);
                JTextField jt22=new JTextField();
                jt22.setColumns(20);
                jt22.setBounds(130,190,100,25);
                jd1.add(jt22);

                JLabel ja3=new JLabel("检验负责人：");
                ja3.setFont(new Font("华文行楷",4,18));
                ja3.setBounds(0,240,120,40);
                jd1.add(ja3 );
                JTextField jt3=new JTextField();
                jt3.setColumns(20);
                jt3.setBounds(130,250,100,25);
                jd1.add(jt3 );
                JLabel ja4=new JLabel("检验日期:");
                ja4.setFont(new Font("华文行楷",4,18));
                ja4.setBounds(10,300,120,40);
                jd1.add(ja4 );

                JTextField jt4=new JTextField();
                jt4.setColumns(20);
                jt4.setBounds(130,310,100,25);
                jd1.add(jt4);

                JButton jb = new JButton("确定");
                jb.setBounds(130,350,90,30);
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
                        try {
                            String sql = "insert into check1 values" +"(" +a+ ",'" +b + "','" + c + "','" + d+"','"+e+"'"+ ")";
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
        p66.add(jk2);
        jk3 = new JButton("删除");
        jk3.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\5.png"));
        jk3.setBounds(630, 170, 120, 35);
        jk3.setFont(new Font("黑体", 0, 15));
        jk3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row=d6.getSelectedRow();
                if(row!=-1) {
                    int result = JOptionPane.showConfirmDialog(null, "确定要删除吗？","请确认",JOptionPane.YES_NO_OPTION);
                    if(result==JOptionPane.OK_OPTION)
                    {
                        try {
                            String sql = "DELETE FROM check1 WHERE num5"+"="+Integer.parseInt(d6.getValueAt(row,0).toString());
                            PreparedStatement preparedStatement = con.prepareStatement(sql);
                            preparedStatement.executeUpdate();
                        } catch (Exception throwables) {
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
                }else{
                    JOptionPane.showMessageDialog(null, "请选择要删除的行！","提示：",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        p66.add(jk3);
        jk4 = new JButton("修改");
        jk4.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\6.png"));
        jk4.setBounds(630, 215, 120, 35);
        jk4.setFont(new Font("黑体", 0, 15));
        p66.add(jk4);
        jk4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent act) {
                int row=d6.getSelectedRow();
                if(row!=-1) {
                    int result = JOptionPane.showConfirmDialog(null, "确定要修改吗？","请确认",JOptionPane.YES_NO_OPTION);
                    if(result==JOptionPane.OK_OPTION)
                    {
                        JDialog jd1 = new JDialog();
                        jd1.setLayout(null);
                        jd1.setTitle("修改");
                        jd1.setBounds(900, 200, 600, 600);
                        JLabel ja=new JLabel("请输入新的信息");
                        ja.setFont(new Font("华文行楷",4,20));
                        ja.setBounds(225,-80,200,200);
                        jd1.add(ja,BorderLayout.NORTH);
                        JLabel ja1=new JLabel("设备编号:");
                        ja1.setFont(new Font("华文行楷",4,18));
                        ja1.setBounds(20,48,130,40);
                        jd1.add(ja1 );
                        JTextField jt1=new JTextField();
                        jt1.setText(d6.getValueAt(row,0).toString());
                        jt1.setColumns(20);
                        jt1.setBounds(130,58,100,25);
                        jd1.add(jt1 );


                        JLabel ja2=new JLabel("检验内容:");
                        ja2.setFont(new Font("华文行楷",4,18));
                        ja2.setBounds(20,120,100,40);
                        jd1.add(ja2 );
                        JTextField jt2=new JTextField();
                        jt2.setText(d6.getValueAt(row,1).toString());
                        jt2.setColumns(20);
                        jt2.setBounds(130,128,100,25);
                        jd1.add(jt2 );

                        JLabel ja22=new JLabel("预期目标：");
                        ja22.setFont(new Font("华文行楷",4,18));
                        ja22.setBounds(20,180,100,40);
                        jd1.add(ja22);
                        JTextField jt22=new JTextField();
                        jt22.setText(d6.getValueAt(row,2).toString());
                        jt22.setColumns(20);
                        jt22.setBounds(130,190,100,25);
                        jd1.add(jt22);

                        JLabel ja3=new JLabel("检验负责人：");
                        ja3.setFont(new Font("华文行楷",4,18));
                        ja3.setBounds(0,240,120,40);
                        jd1.add(ja3 );
                        JTextField jt3=new JTextField();
                        jt3.setText(d6.getValueAt(row,3).toString());
                        jt3.setColumns(20);
                        jt3.setBounds(130,250,100,25);
                        jd1.add(jt3 );
                        JLabel ja4=new JLabel("检验日期:");
                        ja4.setFont(new Font("华文行楷",4,18));
                        ja4.setBounds(10,300,120,40);
                        jd1.add(ja4 );

                        JTextField jt4=new JTextField();
                        jt4.setText(d6.getValueAt(row,4).toString());
                        jt4.setColumns(20);
                        jt4.setBounds(130,310,100,25);
                        jd1.add(jt4);

                        JButton jb = new JButton("确定");
                        jb.setBounds(130,340,90,30);
                        jd1.add(jb);
                        jd1.setVisible(true);
                        jb.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                Integer a=Integer.parseInt(jt1.getText());
                                String b=jt2.getText();
                                String c=jt22.getText();
                                String d=jt3.getText();
                                String e=jt4.getText();
                                try {
                                    String sql="update check1 set num5="+a+","+"info='"+b+"',"+"goal='"+c+"',"+"resp='"+d+"',"+"data4='"+e+
                                            "'"+" where num5="+Integer.parseInt(d6.getValueAt(row,0).toString());
                                    PreparedStatement psd = con.prepareStatement(sql);
                                    psd.executeUpdate();
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
                                    } catch (SQLException y) {
                                        y.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "请选择修改的行！","提示：",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        jtbp.add("设备检验信息", p66);


        Object[][] table5 = new Object[40][5];
        Object[] name6 = {"设备编号","设备名称","报废原因", "报废日期", "经办人"};
        JPanel p62 = new JPanel();
        p62.setLayout(null);
        p62.setBounds(0, 100, 800, 500);
        JTable d7=new JTable(table4,name6);
        d7.setRowHeight(25);
        JScrollPane js7 = new JScrollPane(d7);
        //d6.setBackground(Color.LIGHT_GRAY);
        js7.setBounds(0, 0, 600, 400);
        p62.add(js7);
        jk1p = new JButton("查询全部");
        jk1p.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\2.png"));
        jk1p.setBounds(630, 35, 120, 35);
        jk1p.setFont(new Font("黑体", 0, 15));
        jk1p.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                for(int i=0;i<40;i++)
                {
                    for(int j=0;j<5;j++)
                    {
                        d7.setValueAt(" ",i,j);
                    }
                }
                try {
                    ps = con.prepareStatement("select * from scrap");
                    rs = ps.executeQuery();
                    for (int i = 0; rs.next(); i++) {
                        int num4=rs.getInt(1);
                        String sname=rs.getString(2);
                        String reason = rs.getString(3);
                        String data3 = rs.getString(4);
                        String agent= rs.getString(5);
                        d7.setValueAt(Integer.toString(num4), i, 0);
                        d7.setValueAt(sname,i,1);
                        d7.setValueAt(reason, i, 2);
                        d7.setValueAt(data3, i, 3);
                        d7.setValueAt(agent, i, 4);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
            }
        });
        p62.add(jk1p);
        jk1p1 = new JButton("查询");
        jk1p1.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\3.png"));
        jk1p1.setBounds(630, 80, 120, 35);
        jk1p1.setFont(new Font("黑体", 0, 15));
        jk1p1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String st1 = JOptionPane.showInputDialog(null, "编号", "查询", 1);
                int m = 0;
                try {
                    ps = con.prepareStatement("select * from scrap");
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        int num4=rs.getInt(1);
                        String a =""+num4;
                        if (st1.equals(a)) {
                            m = 1;
                            String sname=rs.getString(2);
                            String reason = rs.getString(3);
                            String data3 = rs.getString(4);
                            String agent= rs.getString(5);
                            d7.setValueAt(Integer.toString(num4), 0, 0);
                            d7.setValueAt(sname,0,1);
                            d7.setValueAt(reason,0, 2);
                            d7.setValueAt(data3, 0, 3);
                            d7.setValueAt(agent, 0, 4);
                        }
                    }
                    if (m == 0) {
                        JOptionPane.showMessageDialog(null, "您查找的数据不存在", "提示：", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception throwables) {
                    throwables.printStackTrace();
                } finally {
                    try {
                        if (rs != null) {
                            rs.close();
                        }
                        if (ps != null) {
                            ps.close();
                        }
                    } catch (SQLException a) {
                        a.printStackTrace();
                    }
                }
            }
        });
        p62.add(jk1p1);
        JButton jk1p2 = new JButton("增加");
        jk1p2.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\4.png"));
        jk1p2.setBounds(630, 125, 120, 35);
        jk1p2.setFont(new Font("黑体", 0, 15));
        jk1p2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog jd1 = new JDialog();
                jd1.setLayout(null);
                jd1.setTitle("增加");
                jd1.setBounds(900, 200, 600, 600);
                JLabel ja=new JLabel("请输入新的信息");
                ja.setFont(new Font("华文行楷",4,20));
                ja.setBounds(225,-80,200,200);
                jd1.add(ja,BorderLayout.NORTH);


                JLabel ja1=new JLabel("设备编号:");
                ja1.setFont(new Font("华文行楷",4,18));
                ja1.setBounds(20,48,130,40);
                jd1.add(ja1 );
                JTextField jt1=new JTextField();
                jt1.setColumns(20);
                jt1.setBounds(130,58,100,25);
                jd1.add(jt1 );

                JLabel ja12=new JLabel("设备名称:");
                ja12.setFont(new Font("华文行楷",4,18));
                ja12.setBounds(20,120,100,40);
                jd1.add(ja12 );
                JTextField jt12=new JTextField();
                jt12.setColumns(20);
                jt12.setBounds(130,128,100,25);
                jd1.add(jt12 );


                JLabel ja2=new JLabel("报废原因:");
                ja2.setFont(new Font("华文行楷",4,18));
                ja2.setBounds(20,180,100,40);
                jd1.add(ja2 );
                JTextField jt2=new JTextField();
                jt2.setColumns(20);
                jt2.setBounds(130,190,100,25);
                jd1.add(jt2 );

                JLabel ja22=new JLabel("报废日期：");
                ja22.setFont(new Font("华文行楷",4,18));
                ja22.setBounds(20,240,100,40);
                jd1.add(ja22);
                JTextField jt22=new JTextField();
                jt22.setColumns(20);
                jt22.setBounds(130,250,100,25);
                jd1.add(jt22);

                JLabel ja3=new JLabel("经办人：");
                ja3.setFont(new Font("华文行楷",4,18));
                ja3.setBounds(30,300,100,40);
                jd1.add(ja3 );
                JTextField jt3=new JTextField();
                jt3.setColumns(20);
                jt3.setBounds(130,310,100,25);
                jd1.add(jt3 );

                JButton jb = new JButton("确定");
                jb.setBounds(130,360,90,30);
                jd1.add(jb);
                jd1.setVisible(true);
                jb.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {
                        Integer a=Integer.valueOf(jt1.getText());
                        String b=jt12.getText();
                        String c=jt2.getText();
                        String d=jt22.getText();
                        String e=jt3.getText();
                        try {
                            String sql = "insert into scrap values" +"(" +a+ ",'"+b+"','"+c+ "','" +d+ "','" +e+"'"+")";
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
        p62.add(jk1p2);
        jk1p3 = new JButton("删除");
        jk1p3.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\5.png"));
        jk1p3.setBounds(630, 170, 120, 35);
        jk1p3.setFont(new Font("黑体", 0, 15));
        jk1p3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int row=d7.getSelectedRow();
                if(row!=-1) {
                    int result = JOptionPane.showConfirmDialog(null, "确定要删除吗？","请确认",JOptionPane.YES_NO_OPTION);
                    if(result==JOptionPane.OK_OPTION)
                    {
                        try {
                            String sql = "DELETE FROM scrap WHERE num4"+"="+Integer.parseInt(d7.getValueAt(row,0).toString());
                            PreparedStatement preparedStatement = con.prepareStatement(sql);
                            preparedStatement.executeUpdate();
                        } catch (Exception throwables) {
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
                }else{
                    JOptionPane.showMessageDialog(null, "请选择要删除的行！","提示：",JOptionPane.ERROR_MESSAGE);
                }

            }
        });
        p62.add(jk1p3);
        jk1p4 = new JButton("修改");
        jk1p4.setIcon(new ImageIcon("C:\\Users\\Lenovo-pc\\IdeaProjects\\ShiXun\\src\\image\\6.png"));
        jk1p4.setBounds(630, 215, 120, 35);
        jk1p4.setFont(new Font("黑体", 0, 15));
        jk1p4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent act) {
                int row=d7.getSelectedRow();
                if(row!=-1) {
                    int result = JOptionPane.showConfirmDialog(null, "确定要修改吗？","请确认",JOptionPane.YES_NO_OPTION);
                    if(result==JOptionPane.OK_OPTION)
                    {
                        JDialog jd1 = new JDialog();
                        jd1.setLayout(null);
                        jd1.setTitle("修改");
                        jd1.setBounds(900, 200, 600, 600);
                        JLabel ja=new JLabel("请输入新的信息");
                        ja.setFont(new Font("华文行楷",4,20));
                        ja.setBounds(225,-80,200,200);
                        jd1.add(ja,BorderLayout.NORTH);
                        JLabel ja1=new JLabel("设备编号:");
                        ja1.setFont(new Font("华文行楷",4,18));
                        ja1.setBounds(20,48,130,40);
                        jd1.add(ja1 );
                        JTextField jt1=new JTextField();
                        jt1.setText(d7.getValueAt(row,0).toString());
                        jt1.setColumns(20);
                        jt1.setBounds(130,58,100,25);
                        jd1.add(jt1 );

                        JLabel ja12=new JLabel("设备名称:");
                        ja12.setFont(new Font("华文行楷",4,18));
                        ja12.setBounds(20,120,100,40);
                        jd1.add(ja12 );
                        JTextField jt12=new JTextField();
                        jt12.setText(d7.getValueAt(row,1).toString());
                        jt12.setColumns(20);
                        jt12.setBounds(130,128,100,25);
                        jd1.add(jt12 );


                        JLabel ja2=new JLabel("报废原因:");
                        ja2.setFont(new Font("华文行楷",4,18));
                        ja2.setBounds(20,180,100,40);
                        jd1.add(ja2 );
                        JTextField jt2=new JTextField();
                        jt2.setText(d7.getValueAt(row,2).toString());
                        jt2.setColumns(20);
                        jt2.setBounds(130,190,100,25);
                        jd1.add(jt2 );

                        JLabel ja22=new JLabel("报废日期：");
                        ja22.setFont(new Font("华文行楷",4,18));
                        ja22.setBounds(20,240,100,40);
                        jd1.add(ja22);
                        JTextField jt22=new JTextField();
                        jt22.setText(d7.getValueAt(row,3).toString());
                        jt22.setColumns(20);
                        jt22.setBounds(130,250,100,25);
                        jd1.add(jt22);

                        JLabel ja3=new JLabel("经办人：");
                        ja3.setFont(new Font("华文行楷",4,18));
                        ja3.setBounds(30,300,100,40);
                        jd1.add(ja3 );
                        JTextField jt3=new JTextField();
                        jt3.setText(d7.getValueAt(row,4).toString());
                        jt3.setColumns(20);
                        jt3.setBounds(130,310,100,25);
                        jd1.add(jt3 );

                        JButton jb = new JButton("确定");
                        jb.setBounds(130,360,90,30);
                        jd1.add(jb);
                        jd1.setVisible(true);
                        jb.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent actionEvent) {
                                Integer a=Integer.parseInt(jt1.getText());
                                String b=jt12.getText();
                                String c=jt2.getText();
                                String d=jt22.getText();
                                String e=jt3.getText();
                                try {

                                    String sql="update scrap set num4="+a+","+"sname='"+b+"',"+"reason='"+c+"',"+"data3='"+d+"',"+"agent='"+e+
                                            "'"+" where num4="+Integer.parseInt(d7.getValueAt(row,0).toString());
                                    PreparedStatement psd = con.prepareStatement(sql);
                                    psd.executeUpdate();
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
                                    } catch (SQLException y) {
                                        y.printStackTrace();
                                    }
                                }
                            }
                        });
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "请选择修改的行！","提示：",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        p62.add(jk1p4);
        jtbp.add("设备报废信息管理",p62);
        jtb.add("设备综合信息管理",jtbp);
        jb.addActionListener(this);
        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jn.addActionListener(this);
        jn1.addActionListener(this);
        jn2.addActionListener(this);
        jn3.addActionListener(this);
        jn4.addActionListener(this);
        ju.addActionListener(this);
        ju1.addActionListener(this);
        ju2.addActionListener(this);
        ju3.addActionListener(this);
        ju4.addActionListener(this);
        jc.addActionListener(this);
        jc1.addActionListener(this);
        jc2.addActionListener(this);
        jc3.addActionListener(this);
        jc4.addActionListener(this);
        jo.addActionListener(this);
        jo1.addActionListener(this);
        jo2.addActionListener(this);
        jo3.addActionListener(this);
        jo4.addActionListener(this);
        jk.addActionListener(this);
        jk1.addActionListener(this);
        jk2.addActionListener(this);
        jk3.addActionListener(this);
        jk4.addActionListener(this);
        jk1p.addActionListener(this);
        jk1p1.addActionListener(this);
        jk1p2.addActionListener(this);
        jk1p3.addActionListener(this);
        jk1p4.addActionListener(this);

//        JPanel p8 = new JPanel();
//        p8.setLayout(null);
//        p8.setBounds(0, 100, 800, 900);
//        jButton=new JButton("发送");
//        //jButton.addActionListener(this);
//        jButton.setBounds(830, 125, 100, 35);
//        jButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent actionEvent) {
//                string = "交流2367";
//                System.out.println(string);
//                new Login();
//            }
//        });
//        p8.add(jButton);
//        //jButton.addActionListener(this);
//        jtb.add("交流", p8);
    }

    public static void main (String[] args) throws Exception
    {
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
        Usermenu1 a = new Usermenu1();
        SimpleDateFormat myfmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("lib/3.txt",true));
            bw.write("操作内容为: \n");
            SimpleDateFormat myfmt = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            if(e.getSource()==jb) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("查询全部设备类别信息\n");
            }
            if(e.getSource()==jb1) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("查询设备类别信息\n");
            }
            if(e.getSource()==jb2) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("增加设备类别信息\n");
            }
            if(e.getSource()==jb3) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("删除设备类别信息\n");
            }
            if(e.getSource()==jb4) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("修改设备类别信息\n");
            }

            if(e.getSource()==jn) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("查询全部部门信息\n");
            }
            if(e.getSource()==jn1) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("查询部门信息\n");
            }
            if(e.getSource()==jn2) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("增加部门信息\n");
            }
            if(e.getSource()==jn3) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("删除部门信息\n");
            }
            if(e.getSource()==jn4) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("修改部门信息\n");
            }
            if(e.getSource()==ju) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("查询全部设备信息\n");
            }
            if(e.getSource()==ju1) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("查询设备信息\n");
            }
            if(e.getSource()==ju2) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("增加设备信息\n");
            }
            if(e.getSource()==ju3) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("删除设备信息\n");
            }
            if(e.getSource()==ju4) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("修改设备信息\n");
            }

            if(e.getSource()==jc) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("查询全部设备使用信息\n");
            }
            if(e.getSource()==jc1) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("查询设备使用信息\n");
            }
            if(e.getSource()==jc2) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("增加设备使用信息\n");
            }
            if(e.getSource()==jc3) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("删除设备使用信息\n");
            }
            if(e.getSource()==jc4) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("修改设备使用信息\n");
            }

            if(e.getSource()==jo) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("查询全部设备维修信息\n");
            }
            if(e.getSource()==jo1) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("查询设备维修信息\n");
            }
            if(e.getSource()==jo2) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("增加设备维修信息\n");
            }
            if(e.getSource()==jo3) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("删除设备维修信息\n");
            }
            if(e.getSource()==jo4) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("修改设备维修信息\n");
            }

            if(e.getSource()==jk) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("查询全部设备检验信息\n");
            }
            if(e.getSource()==jk1) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("查询设备检验信息\n");
            }
            if(e.getSource()==jk2) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("增加设备检验信息\n");
            }
            if(e.getSource()==jk3) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("删除设备检验信息\n");
            }
            if(e.getSource()==jk4) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("修改设检验信息\n");
            }

            if(e.getSource()==jk1p) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("查询全部设备报废信息\n");
            }
            if(e.getSource()==jk1p1) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("查询设备报废信息\n");
            }
            if(e.getSource()==jk1p2) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("增加设备报废信息\n");
            }
            if(e.getSource()==jk1p3) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("删除设备报废信息\n");
            }
            if(e.getSource()==jk1p4) { ;
                bw.write(myfmt.format(new java.util.Date()).toString()+"\n");
                bw.write("修改设备报废信息\n");
            }
            bw.close();
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }
}

