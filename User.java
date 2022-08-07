import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class UserRegistration extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    //private static final long serialVersion UID=1L;
    private JPanel ContextPane;
    private JTextField Firstname;
    private JTextField Lastname;
    private JTextField email;
    private JTextField Username;
    private JTextField mob;
    private JPasswordField password;
    private JButton b;
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable () {
            public void run() {
                try {
                    UserRegistration frame=new UserRegistration();
                    frame.setVisible(true);
                }catch(Exception e) {e.printStackTrace();}}});}
    public UserRegistration() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450,190,1014,597);
        setResizable(false);
        ContextPane=new JPanel();
        ContextPane.setBorder(new EmptyBorder(5,5,5,5));
        setContentPane(ContextPane);
        ContextPane.setLayout(null);
        JLabel l=new JLabel("New User Registration");
        l.setFont(new Font("Times new Roman",Font.PLAIN,42));
        l.setBounds(362,52,350,50);
        ContextPane.add(l);

        JLabel l1=new JLabel("Firstname");
        l1.setFont(new Font("Times new Roman",Font.PLAIN,20));
        l1.setBounds(58,152,99,43);
        ContextPane.add(l1);
        JLabel l2=new JLabel("Lastname");
        l2.setFont(new Font("Times new Roman",Font.PLAIN,20));
        l2.setBounds(58,243,110,29);
        ContextPane.add(l2);

        JLabel l3=new JLabel("Email\r\nAddress");
        l3.setFont(new Font("Times new Roman",Font.PLAIN,20));
        l3.setBounds(58,324,124,36);
        ContextPane.add(l3);

        Firstname=new JTextField();
        Firstname.setFont(new Font("Times new Roman",Font.PLAIN,32));
        Firstname.setBounds(214,151,228,50);
        ContextPane.add(Firstname);
        Firstname.setColumns(10);

        Lastname=new JTextField();
        Lastname.setFont(new Font("Times new Roman",Font.PLAIN,32));
        Lastname.setBounds(214,235,228,50);
        ContextPane.add(Lastname);
        Lastname.setColumns(10);

        email=new JTextField();
        email.setFont(new Font("Times new Roman",Font.PLAIN,32));
        email.setBounds(214,320,228,50);
        ContextPane.add(email);
        email.setColumns(10);

        Username=new JTextField();
        Username.setFont(new Font("Times new Roman",Font.PLAIN,32));
        Username.setBounds(707,151,228,50);
        ContextPane.add(Username);
        Username.setColumns(10);

        JLabel l4=new JLabel("Username");
        l4.setFont(new Font("Times new Roman",Font.PLAIN,20));
        l4.setBounds(552,159,99,29);
        ContextPane.add(l4);

        JLabel l5=new JLabel("Password");
        l5.setFont(new Font("Times new Roman",Font.PLAIN,20));
        l5.setBounds(542,245,99,24);
        ContextPane.add(l5);

        JLabel l6=new JLabel("Mobile Number");
        l6.setFont(new Font("Times new Roman",Font.PLAIN,20));
        l6.setBounds(542,329,139,26);
        ContextPane.add(l6);

        mob=new JTextField();
        mob.setFont(new Font("Times new Roman",Font.PLAIN,32));
        mob.setBounds(707,320,228,50);
        ContextPane.add(mob);
        mob.setColumns(10);

        password=new JPasswordField();
        password.setFont(new Font("Times new Roman",Font.PLAIN,32));
        password.setBounds(707,235,228,50);
        ContextPane.add(password);

        b=new JButton("Register");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstname=Firstname.getText();
                String lastname=Lastname.getText();
                String emailid=email.getText();
                String username=Username.getText();
                String mobilenumber=mob.getText();
                int len=mobilenumber.length();
                String pass=password.getText();

                String msg= " "+firstname;
                msg+="\n";
                if(len!=10) {
                    JOptionPane.showMessageDialog(b, "Enter valid mobile number");
                }
                try {
                    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/swing_project","root","root");
                    String query="insert into account values("+firstname+","+lastname+","+username+","+pass+","+emailid+","+mobilenumber+")";
                    Statement sta=conn.createStatement();
                    int x=sta.executeUpdate(query);
                    if(x==0) {
                        JOptionPane.showMessageDialog(b, "Already exist");
                    }else {
                        JOptionPane.showMessageDialog(b, "Your account is successfully created");
                    }
                    conn.close();
                }catch(Exception exception) {exception.printStackTrace();
                }
            }});
        b.setFont(new Font("Times new Roman",Font.PLAIN,22));
        b.setBounds(399,447,259,74);
        ContextPane.add(b);

    }}