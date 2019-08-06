package com.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Vector;

public class Main {

    public static class MainFrame extends JFrame {
        JLabel lable1,lable2,info;//标签
        JPanel jPanel1,jp1,jp2,jp3;//面板
        JTextField text;//写入
        JButton button,admin,stu;//按钮

        JButton lend;//借书

        public MainFrame(){
            this.setLayout(new BorderLayout());
            this.setBounds(400,200,600,450);
            this.setTitle("图书查询");

            lable1 = new JLabel("图书查询",SwingConstants.CENTER);//大标题
            lable1.setFont(new Font("楷体",Font.BOLD,40));

            lable2 = new JLabel("书名");//中间

            text = new JTextField(15);
            button = new JButton("查询");

            jPanel1 = new JPanel();
            jPanel1.setLayout(new BorderLayout());
            jp1 = new JPanel();
            jp2 = new JPanel();

            stu = new JButton("用户登录");
            admin  = new JButton("管理员登录");

            jp1.add(lable1);
            jp1.add(text);
            jp1.add(button);

            jp3 = new JPanel();
            jp2.setLayout(new BorderLayout());
            jp3.setLayout(new FlowLayout(FlowLayout.RIGHT));
            jp3.add(stu);
            jp3.add(admin);
            jp2.add(jp3,BorderLayout.SOUTH);
            jPanel1.add(jp1,BorderLayout.NORTH);
            jPanel1.add(jp2);

            this.add(lable1,BorderLayout.NORTH);
            this.add(jPanel1);

            MyEvent();

            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        public void MyEvent(){
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new FindBook();//.findInfo(jp2,text);
                }
            });
            admin.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new LoginFrame();
                }
            });
            stu.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new UserLoginFrame();
                }
            });
        }
    }
    public static class LoginFrame extends JFrame{
        JLabel label,name,pass;
        JButton login;
        JTextField adminName;
        JPasswordField password;
        JPanel panel,jp1,jp2;

        public LoginFrame(){//管理员登录界面
            this.setBounds(400,200,300,200);
            this.setTitle("图书管理系统登录");
            this.setLayout(new BorderLayout());

            label = new JLabel("登录",SwingConstants.CENTER);
            label.setFont(new Font("楷体",Font.BOLD,30));

            name = new JLabel("账号");
            pass = new JLabel("密码");

            adminName = new JTextField(12);
            adminName.setText("admin");
            adminName.setHorizontalAlignment(SwingConstants.CENTER);
            password = new JPasswordField(12);
            password.setHorizontalAlignment(SwingConstants.CENTER);
            password.setEchoChar('*');

            panel = new JPanel();
            jp1 = new JPanel();
            jp2 = new JPanel();
            panel.setLayout(new BorderLayout());

            jp1.add(adminName);
            jp1.add(name);
            jp1.add(password);
            jp1.add(pass);

            panel.add(jp1);
            login = new JButton("登录");
            jp2.add(login);
            panel.add(jp2,BorderLayout.SOUTH);

            this.add(label,BorderLayout.NORTH);
            this.add(panel);

            MYevent();

            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
        public void MYevent(){
            login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String word = "123456";
                    String str = new String(password.getPassword());

                    if(str.equals(word))
                        new LendAdminFrame();
                    else{
                        String str1 = "你输入的密码不正确！";
                        JOptionPane.showMessageDialog(null,str1);
                    }
                    LoginFrame.this.dispose();
                }
            });
        }
    }
    public static class LendAdminFrame extends JFrame{
        JPanel panel;
        JButton storage,lendInfo;
        public LendAdminFrame(){
            this.setTitle("管理员");
            this.setBounds(400,200,400,200);
            this.setLayout(new FlowLayout(FlowLayout.CENTER));

            storage = new JButton("图书入库管理");
            lendInfo = new JButton("借阅信息管理");

            this.add(storage);
            this.add(lendInfo);

           // MyEvent();

            this.setVisible(true);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        /*public void MyEvent(){
            storage.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new TableFrame(storage.getText()).show();
                }
            });
            lendInfo.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new TableFrame(lendInfo.getText()).show();
                }
            });
        }*/
    }
    public static class FindBook{
        Vector tableName;

        private Vector getTableName(){
            tableName = new Vector();

            Connection conn;
            PreparedStatement preparedStatement;
            ///////////
            return tableName;
        }
    }
    public static class UserLoginFrame extends JFrame{
        JLabel label,name,pass,identify;
        JButton login,register,modify;
        JTextField adminname;
        JPasswordField password;
        JPanel panel,jp1,jp2;


        public UserLoginFrame(){
            this.setBounds(400,200,300,200);
            this.setTitle("登录系统");
            this.setLayout(new BorderLayout());

            label = new JLabel("登录",SwingConstants.CENTER);
            label.setFont(new Font("楷体",Font.BOLD,30));

            name = new JLabel("账号");
            pass = new JLabel("密码");

            adminname = new JTextField(12);
            adminname.setHorizontalAlignment(SwingConstants.CENTER);
            password = new JPasswordField(12);
            password.setHorizontalAlignment(SwingConstants.CENTER);
            password.setEchoChar('*');

            panel = new JPanel();
            jp1 = new JPanel();
            jp2 = new JPanel();
            panel.setLayout(new BorderLayout());

            jp1.add(adminname);
            jp1.add(name);
            jp1.add(password);
            jp1.add(pass);

            panel.add(jp1);

            register = new JButton("注册");
            login = new JButton("登录");
            modify = new JButton("修改密码");
            jp2.add(register);
            jp2.add(login);
            jp2.add(modify);
            panel.add(jp2);

            this.add(label,BorderLayout.NORTH);
            this.add(panel);

            MyEvent();

            this.setVisible(true);
            //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        public void MyEvent(){
            register.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    new RegisterFrame();
                }
            });
            login.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Connection conn;
                    PreparedStatement preparedStatement;
                    /////////
                }
            });
        }
    }
    public  static class RegisterFrame extends JFrame{
        JPanel panel;
        JTextField text;
        JPasswordField password1,password2;

        JLabel title,user,pass1,pass2;

        JButton button;

        public RegisterFrame(){
            this.setBounds(400,200,300,200);
            this.setTitle("注册");
            this.setLayout(new BorderLayout());

            title = new JLabel("注册",SwingConstants.CENTER);
            title.setFont(new Font("楷体",Font.BOLD,30));

            panel = new JPanel();

            text = new JTextField(15);
            text.setHorizontalAlignment(SwingConstants.CENTER);
            password1 = new JPasswordField(15);
            password1.setEchoChar('*');
            password1.setHorizontalAlignment(SwingConstants.CENTER);
            password2 = new JPasswordField(15);
            password2.setEchoChar('*');
            password2.setHorizontalAlignment(SwingConstants.CENTER);

            user = new JLabel("用    户");
            pass1 = new JLabel("密    码");
            pass2 = new JLabel("确认密码");

            button = new JButton("注册成功");

            panel.add(text);
            panel.add(user);
            panel.add(password1);
            panel.add(pass1);
            panel.add(password2);
            panel.add(pass2);

            this.add(title,BorderLayout.NORTH);
            this.add(panel);
            this.add(button,BorderLayout.SOUTH);

            //MyEvent();

            this.setVisible(true);
            //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
    public static void main(String[] args) {

        new MainFrame();
    }
}
