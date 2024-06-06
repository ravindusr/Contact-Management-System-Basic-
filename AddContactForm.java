import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class AddContactForm extends JFrame {
	private JLabel title;

	private JLabel lblId;
	private JLabel lblName;
	private JLabel lblContactnum;
	private JLabel lblCompany;
	private JLabel lblSalary;
	private JLabel lblBD;

	private JTextField txtID;
	private JTextField txtName;
	private JTextField txtContactnum;
	private JTextField txtCompany;
	private JTextField txtSalary;
	private JTextField txtBD;

	private JButton btnaddcontact;
	private JButton btncancle;
	private JButton btnbacktohome;

	AddContactForm() {
		setSize(500, 500);
		setTitle("Add Contacts");
		setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		setLocationRelativeTo(null);
		

		title = new JLabel("Add Contacts");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("", 1, 30));
		add("North", title);
	

		JPanel labelPanel = new JPanel(new GridLayout(6, 1));

		lblId = new JLabel(" Contact ID - ");
		lblId.setFont(new Font("", 1, 20));
		labelPanel.add(lblId);

		lblName = new JLabel("    Name ");
		lblName.setFont(new Font("", 1, 20));
		labelPanel.add(lblName);

		lblContactnum = new JLabel("    Contact Number ");
		lblContactnum.setFont(new Font("", 1, 20));
		labelPanel.add(lblContactnum);

		lblCompany = new JLabel("    Company ");
		lblCompany.setFont(new Font("", 1, 20));
		labelPanel.add(lblCompany);

		lblSalary = new JLabel("    Salary ");
		lblSalary.setFont(new Font("", 1, 20));
		labelPanel.add(lblSalary);

		lblBD = new JLabel("    Birth Day ");
		lblBD.setFont(new Font("", 1, 20));
		labelPanel.add(lblBD);

		add("West", labelPanel);

		JPanel textPanel = new JPanel(new GridLayout(6, 1));
		txtID = new JTextField(6);
		txtID.setFont(new Font("", 1, 20));
		JPanel idtxtPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		idtxtPanel.add(txtID);
		textPanel.add(idtxtPanel);

		txtName = new JTextField(25);
		txtName.setFont(new Font("", 1, 20));
		JPanel nametxtPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		nametxtPanel.add(txtName);
		textPanel.add(nametxtPanel);

		txtContactnum = new JTextField(25);
		txtContactnum.setFont(new Font("", 1, 20));
		JPanel contactnumtxtPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		contactnumtxtPanel.add(txtContactnum);
		textPanel.add(contactnumtxtPanel);

		txtCompany = new JTextField(25);
		txtCompany.setFont(new Font("", 1, 20));
		JPanel companytxtPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		companytxtPanel.add(txtCompany);
		textPanel.add(companytxtPanel);

		txtSalary = new JTextField(25);
		txtSalary.setFont(new Font("", 1, 20));
		JPanel salarytxtPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		salarytxtPanel.add(txtSalary);
		textPanel.add(salarytxtPanel);

		txtBD = new JTextField(25);
		txtBD.setFont(new Font("", 1, 20));
		JPanel bdtxtPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		bdtxtPanel.add(txtBD);
		textPanel.add(bdtxtPanel);

		add("Center", textPanel);

		JPanel downbtns = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		btnaddcontact = new JButton("ADD Contact");
		btnaddcontact.setFont(new Font("", 1, 25));
		btnaddcontact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				String id=txtID.getText();
				String name=txtName.getText();
				String pn=txtContactnum.getText();
				String cn=txtCompany.getText();
				double salary=Double.parseDouble(txtSalary.getText());
				String bd=txtBD.getText();
				Contact contact=new Contact(id,name,pn,cn,salary,bd);
				MainForm.ContactList.add(contact);
				
			}
		});
		downbtns.add(btnaddcontact);


		btncancle = new JButton("Cancle");
		btncancle.setFont(new Font("", 1, 25));
		btnbacktohome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
        });
		downbtns.add(btncancle);

		btnbacktohome = new JButton("Back To Home");
		btnbacktohome.setFont(new Font("", 1, 25));
		btnbacktohome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
        });
		downbtns.add(btnbacktohome);

		add("South", downbtns);

		btnaddcontact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(AddContactForm.this,
                        "Contact added successfully!",
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

	}
}
