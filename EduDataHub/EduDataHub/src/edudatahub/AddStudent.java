
package edudatahub;
import java.awt.*;
import java.util.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
public class AddStudent extends JFrame implements ActionListener{
   JTextField tfname,tffname,tfadd,tfxii,tfemail,tfx,tfphone,tfadhaar;
   JLabel lblrolln;
   JDateChooser dcdob;
   JComboBox cbcourse,cbbranch;
   JButton submit,cancel;
    Random ran = new Random();
    long first4=Math.abs(ran.nextLong()%9000L)+1000L;
           public AddStudent() {
       setSize(900,700);
       setLocation(350,50);
       setLayout(null);
       
       JLabel heading = new JLabel("New student Details");
       heading.setBounds(310,30,500,50);
       heading.setFont(new Font("serif",Font.BOLD,30));
       add(heading);
       
       JLabel lblname = new JLabel("Name");
       lblname.setBounds(50,150,100,30);
       lblname.setFont(new Font("serif",Font.BOLD,20));
       add(lblname);
       
       tfname = new JTextField();
       tfname.setBounds(200,150,150,30);
       add(tfname);
      
       JLabel lbflname = new JLabel("Father's Name");
       lbflname.setBounds(400,150,200,30);
       lbflname.setFont(new Font("serif",Font.BOLD,20));
       add(lbflname);
       
       tffname = new JTextField();
       tffname.setBounds(600,150,150,30);
       add(tffname);
       
       JLabel lblrollno = new JLabel("Roll no :");
       lblrollno.setBounds(50,200,200,30);
       lblrollno.setFont(new Font("serif",Font.BOLD,20));
       add(lblrollno);
       
       lblrolln = new JLabel("1533"+first4);
       lblrolln.setBounds(200,200,200,30);
       lblrolln.setFont(new Font("serif",Font.BOLD,20));
       add(lblrolln);
       
       JLabel lbldob = new JLabel("Date of Birth:");
       lbldob.setBounds(400,200,200,30);
       lbldob.setFont(new Font("serif",Font.BOLD,20));
       add(lbldob);
       
       dcdob = new JDateChooser();
       dcdob.setBounds(600,200,150,30);
       add(dcdob);
       
      JLabel lbladd = new JLabel("Address");
       lbladd.setBounds(50,250,200,30);
       lbladd.setFont(new Font("serif",Font.BOLD,20));
       add(lbladd);
       
       tfadd = new JTextField();
       tfadd.setBounds(200,250,150,30);
       add(tfadd);
       
       JLabel lblphone = new JLabel("Phone Number");
       lblphone.setBounds(400,250,200,30);
       lblphone.setFont(new Font("serif",Font.BOLD,20));
       add(lblphone);
       
       tfphone = new JTextField();
       tfphone.setBounds(600,250,150,30);
       add(tfphone);
       
       JLabel lblemail = new JLabel("Email");
       lblemail.setBounds(50,300,200,30);
       lblemail.setFont(new Font("serif",Font.BOLD,20));
       add(lblemail);
       
       tfemail = new JTextField();
       tfemail.setBounds(200,300,150,30);
       add(tfemail);
       
       JLabel lblx = new JLabel("Class X (%)");
       lblx.setBounds(400,300,200,30);
       lblx.setFont(new Font("serif",Font.BOLD,20));
       add(lblx);
       
       tfx = new JTextField();
       tfx.setBounds(600,300,150,30);
       add(tfx);
       
      
       
       JLabel lblxii = new JLabel("Class XII (%)");
       lblxii.setBounds(50,350,200,30);
       lblxii.setFont(new Font("serif",Font.BOLD,20));
       add(lblxii);
       
       tfxii = new JTextField();
       tfxii.setBounds(200,350,150,30);
       add(tfxii);
       
       JLabel lbladhaar = new JLabel("Adhaar No");
       lbladhaar.setBounds(400,350,200,30);
       lbladhaar.setFont(new Font("serif",Font.BOLD,20));
       add(lbladhaar);
       
       tfadhaar = new JTextField();
       tfadhaar.setBounds(600,350,150,30);
       add(tfadhaar);
       
       JLabel lblcourse = new JLabel("select course");
       lblcourse.setBounds(50,400,200,30);
       lblcourse.setFont(new Font("serif",Font.BOLD,20));
       add(lblcourse);

       String course[]={"BE","B.Tech","BCA","BSC","MSC","MBA","MCA","MCOM","MA","BA"};
       cbcourse = new JComboBox(course);
       cbcourse.setBackground(Color.PINK);
       cbcourse.setBounds(200,400,150,30);
       add(cbcourse);
    
       
       JLabel lblbranch = new JLabel("Branch");
       lblbranch.setBounds(400,400,200,30);
       lblbranch.setFont(new Font("serif",Font.BOLD,20));
       add(lblbranch);

       String Branch[]={"Electronics","Computer Science","Mechanical","Electrical","Telecommunication","Civil","IT"};
       cbbranch = new JComboBox(Branch);
       cbbranch.setBackground(Color.PINK);
       cbbranch.setBounds(600,400,150,30);
       add(cbbranch);
       
        submit = new JButton("Submit");                        
        submit.setBounds(150,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);
        
         cancel = new JButton("Cancel");                        
        cancel.setBounds(610,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        add(cancel);
    
            setVisible(true);
           }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
         String name = tfname.getText();
        String  fname = tffname.getText();
        String  rollno = lblrolln.getText();
        String dob=((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
        String phone = tfphone.getText();
        String address = tfadd.getText();
        String email = tfemail.getText();
        String x=tfx.getText();
        String xii=tfxii.getText();
        String aadhar=tfadhaar.getText();
        String course = (String)cbcourse.getSelectedItem();            
        String branch = (String)cbbranch.getSelectedItem();
        //get selected item returns object. so typecast string so cource will be able to store the value
        
        try{
            String query = "insert into student values ('"+name+"','"+fname+"','"+rollno+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+aadhar+"','"+course+"','"+branch+"')";
        //DML cmd   
        //single inverted comma is used cause we have used varchar in DB which takes value from ''.
           Conn con = new Conn();
           con.s.executeUpdate(query);
           
           JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");    //popup
           setVisible(false);
        }catch (Exception e){
            
        }
        }else{
            setVisible(false);
        }
    }
    public static void main (String[] args){
        new AddStudent();
        
    }
}
