import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import javax.swing.UIManager;

public class PatientInfoProgress1 extends JFrame {
	JPanel panel = new JPanel();
	GroupLayout layout = new GroupLayout(panel);
	
	private JLabel lblform,lblname,lbladdress,lblcontact,lblemail,lblDOB,lblage,lblgender,lbltype,lblinfo;
	private JTextField txtfldname,txtfldaddress,txtfldcontact,txtfldemail;
	private JComboBox days,months,years,ages,genders,bloodtypes;
	private JTextArea txtareainfo;
	private JButton btnadd,btnupdate,btndelete,btngetdata;
	
	String [] bloodtype = {"A+","A-","B+","B-","AB+","AB-","O+","O-"};
	String [] gender = {"Male","Female","LGBTQ+"};
	String [] age = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35"};
	String [] day = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String [] month = {"Jan","Feb","Mar","Apr","May","Jun","JUl","Aug","Sept","Oct","Nov","Dec"};
        String [] year = {"2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"};
	
	PatientInfoProgress1(){
		
		//panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setBounds(500, 175, 200, 200);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(Box.createVerticalStrut(10));
		
		setSize(800,700);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lblform = new JLabel("Patient Personal Information Form");
		lblform.setBounds(285, 50, 250, 30);
		lblform.setFont(new Font("Times New Roman", Font.BOLD,16));
		
		//name
		lblname = new JLabel("Patient Name: ");
		lblname.setBounds(100,100,100,30);
		
		txtfldname = new JTextField();
		txtfldname.setBounds(200, 100, 200, 30);
		
		//address
		lbladdress = new JLabel("Address:");
		lbladdress.setBounds(100, 150, 100, 30);
		
		txtfldaddress = new JTextField();
		txtfldaddress.setBounds(200, 150, 200, 30);
		
		//contact number
		lblcontact = new JLabel("Contact #: ");
		lblcontact.setBounds(100, 200, 100, 30);
		
		txtfldcontact = new JTextField(11);
		txtfldcontact.setBounds(200,200,200,30);
		
		//email
		lblemail = new JLabel("Email: ");
		lblemail.setBounds(100, 250, 100, 30);
		
		txtfldemail = new JTextField();
		txtfldemail.setBounds(200, 250, 200, 30);
		
		//DOB
		lblDOB = new JLabel("Date of Birth: ");
		lblDOB.setBounds(100,300,100,30);
		
		months = new JComboBox(month);
		months.setBounds(200,300,80,30);
		
		days = new JComboBox(day);
		days.setBounds(280, 300, 80, 30);
		
		years = new JComboBox(year);
		years.setBounds(360, 300, 90, 30);
		
		//Age
		lblage = new JLabel("Age: ");
		lblage.setBounds(100, 350, 100, 30);
		
		ages = new JComboBox(age);
		ages.setBounds(200, 350, 100, 30);
		
		//gender
		lblgender = new JLabel("Gender: ");
		lblgender.setBounds(100, 400, 100, 30);
		
		genders = new JComboBox(gender);
		genders.setBounds(200, 400, 100, 30);
		
		//blood type
		lbltype = new JLabel("Blood Type: ");
		lbltype.setBounds(100, 450, 100, 30);
		
		bloodtypes = new JComboBox(bloodtype);
		bloodtypes.setBounds(200, 450, 100, 30);
		
		//info
		lblinfo = new JLabel("Information: ");
		lblinfo.setBounds(100, 500, 100, 30);
		
		txtareainfo = new JTextArea();
		txtareainfo.setBounds(200, 500, 250, 150);
		
		//Buttons
		btnadd = new JButton("Add");
		btnupdate = new JButton("Update");
		btndelete = new JButton("Reset");
		btngetdata = new JButton("Get Data");
		
		//setting size
		btnadd.setSize(100, 30);
		btnupdate.setSize(100, 30);
		btndelete.setSize(100, 30);
		btngetdata.setSize(100, 30);
		
		//button alignment to center
		btnadd.setAlignmentX(JButton.CENTER_ALIGNMENT);
		btnupdate.setAlignmentX(JButton.CENTER_ALIGNMENT);
		btndelete.setAlignmentX(JButton.CENTER_ALIGNMENT);
		btngetdata.setAlignmentX(JButton.CENTER_ALIGNMENT);
		
		//alignment of button to vertical
		panel.add(Box.createVerticalGlue());
		
		panel.add(Box.createVerticalStrut(20));
		panel.add(btnadd);
		panel.add(Box.createVerticalStrut(20));
		panel.add(btnupdate);
		panel.add(Box.createVerticalStrut(20));
		panel.add(btndelete);
		panel.add(Box.createVerticalStrut(20));
		panel.add(btngetdata);
		
		panel.add(Box.createVerticalGlue());

		//add all the components
		add(panel);
		add(lblform);
		add(lblname); add(txtfldname);
		add(lbladdress); add(txtfldaddress);
		add(lblcontact); add(txtfldcontact);
		add(lblemail); add(txtfldemail);
		add(lblDOB); add(months); add(days); add(years);
		add(lblage); add(ages);
		add(lblgender); add(genders);
		add(lbltype); add(bloodtypes);
		add(lblinfo); add(txtareainfo);
		
		
                btnadd.addActionListener(new ActionListener(){
                  @Override
                   public void actionPerformed(ActionEvent e){
                       JOptionPane.showMessageDialog(rootPane, "Patient Personal Information Successfully added", "Information Added", JOptionPane.INFORMATION_MESSAGE);
                   }
                });
                
                btndelete.addActionListener(new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e){
                       txtfldname.setText("");
                       txtfldaddress.setText("");
                       txtfldcontact.setText("");
                       txtfldemail.setText("");
                       txtareainfo.setText("");
                   }
                });
                
		setVisible(true);
		setResizable(false);
		getContentPane().add(panel);    
	}
        
        public static void main(String[] args) throws Exception{
            String ui = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
		
            UIManager.setLookAndFeel(ui);
            new PatientInfoProgress1();
        }
}

