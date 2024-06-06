import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

class Listsalaryform extends JFrame{

	private JTable tblCustomerDetails;
	private DefaultTableModel dtm;
	
	private JLabel titleLabel;
	
	private JButton btnReload; 
    private JButton btnbth;

	Listsalaryform(){
		setSize(400,300);
		setTitle("List Contacts by Salary Form");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		
		titleLabel=new JLabel("LIST CONTACTS BY SALARY");
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
		titleLabel.setFont(new Font("",1,30));
		add("North",titleLabel);
		
		String[] columnsName={"Customer Id","Name","Contact Number","Company","Salary","Birthday"};
		dtm=new DefaultTableModel(columnsName,0);
		
		tblCustomerDetails=new JTable(dtm);
		
		JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
		
		add("Center",tablePane);
		
		JPanel buttonPanel=new JPanel(); //Default layout ->JPanel --FlowLAyout
		btnReload=new JButton("Reload");
		btnReload.setFont(new Font("",1,20));
		btnReload.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				for(int i=0; i<MainForm.ContactList.size(); i++){
					Contact contact=MainForm.ContactList.get(i);
					Object[] rowData={contact.getID(), contact.getName(),contact.getPhonenum(),contact.getCompany(),contact.getSalary(),contact.getBD()};
					dtm.addRow(rowData);
				}
			}
		});
		buttonPanel.add(btnReload);

        btnbth=new JButton("Back To Home");
		btnbth.setFont(new Font("",1,20));
        btnbth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
		buttonPanel.add(btnbth);

		add("South",buttonPanel);
		
	}
}
