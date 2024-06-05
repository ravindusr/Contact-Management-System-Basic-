import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.awt.color.*;
class UpdateContactForm extends JFrame{
    
    private JLabel title;

    private JTextField search;
    private JButton btnsearch;

    private JLabel lblId;
	private JLabel lblName;
	private JLabel lblContactnum;
	private JLabel lblCompany;
	private JLabel lblSalary;
	private JLabel lblBD;

    private JButton btnupdate;
    private JButton btncancle;
    private JButton btnbacktohome;

    UpdateContactForm(){

        setSize(580,500);
        setTitle("UpdateContactForm");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        title=new JLabel("UPDATE CONTACT");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("",1,30));
        title.setBackground(Color.BLUE);
        add("North",title);

        JPanel searchcomp=new JPanel(new FlowLayout());

        search=new JTextField(25);
        search.setFont(new Font("",1,20));
        searchcomp.add(search);
        
        btnsearch=new JButton("Search");
        btnsearch.setFont(new Font("",1,25));
        searchcomp.add(btnsearch);

        add(searchcomp,BorderLayout.CENTER);


        
        JPanel lablePanel=new JPanel(new GridLayout(6,1));
        
        lblId=new JLabel("Contact ID ");
        lblId.setFont(new Font("",1,25));
        lablePanel.add(lblId);

        lblName=new JLabel("Name");
        lblName.setFont(new Font("",1,25));
        lablePanel.add(lblName);

        lblContactnum=new JLabel("Contact Number ");
        lblContactnum.setFont(new Font("",1,25));
        lablePanel.add(lblContactnum);

        lblCompany=new JLabel("Company ");
        lblCompany.setFont(new Font("",1,25));
        lablePanel.add(lblCompany);

        lblSalary=new JLabel("Salary ");
        lblSalary.setFont(new Font("",1,25));
        lablePanel.add(lblSalary);

        lblBD=new JLabel("Birthday");
        lblBD.setFont(new Font("",1,25));
        lablePanel.add(lblBD);

        add("West",lablePanel);

        JPanel downpanel=new JPanel(new FlowLayout(FlowLayout.CENTER));

        btnupdate=new JButton("Update");
        btnupdate.setFont(new Font("",1,25));
        downpanel.add(btnupdate);

        btncancle=new JButton("Cancle");
        btncancle.setFont(new Font("",1,25));
        downpanel.add(btncancle);

        btnbacktohome=new JButton("Back To Home");
        btnbacktohome.setFont(new Font("",1,25));
        btnbacktohome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
        });
        downpanel.add(btnbacktohome);

        add(downpanel,BorderLayout.SOUTH);



    }

}
