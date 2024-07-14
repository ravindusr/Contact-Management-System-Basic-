import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
		setSize(700, 520);
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
		txtID.setEditable(false);
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

				if (!ContactController.isValidPhoneNumber(pn)) {
					JOptionPane.showMessageDialog(AddContactForm.this,
						"Invalid phone number! Try Again",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					return;
				}

				String cn=txtCompany.getText();
				double salary=Double.parseDouble(txtSalary.getText());
				String bd=txtBD.getText();

				
				if (!ContactController.isValidBirthday(bd)) {
					JOptionPane.showMessageDialog(AddContactForm.this,
						"Invalid Birthday ! Try Again.",
						"Error",
						JOptionPane.ERROR_MESSAGE);
					return;
				}

				Contact contact=new Contact(id,name,pn,cn,salary,bd);
				ContactDBConnection.getInstance().getContactList().add(contact);
			}
			
		});
		
		
		downbtns.add(btnaddcontact);


		btncancle = new JButton("Cancle");
		btncancle.setFont(new Font("", 1, 25));
		btncancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				clearInputFields();
			}
        });
		downbtns.add(btncancle);

		btnbacktohome = new JButton("Back To Home");
		btnbacktohome.setFont(new Font("", 1, 25));
		btnbacktohome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				dispose();
				clearInputFields();
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

		txtID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				txtName.requestFocus();
			}
		});

		txtName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				txtContactnum.requestFocus();
			}
		});

		txtContactnum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				txtCompany.requestFocus();
			}
		});

		txtCompany.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				txtSalary.requestFocus();
			}
		});

		txtSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				txtBD.requestFocus();
			}
		});

		txtBD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnaddcontact.requestFocus();
			}
		});

		setNextContactID();

	
	}
	private void setNextContactID() {
    String nextID = "C0001";  // Default first ID
    ArrayList<Contact> contactList = ContactDBConnection.getInstance().getContactList();
    
    if (!contactList.isEmpty()) {
        Contact lastContact = contactList.get(contactList.size() - 1);
        String lastID = lastContact.getID();
        int lastNo = Integer.parseInt(lastID.substring(1));
        nextID = String.format("C%04d", lastNo + 1);
    }
    txtID.setText(nextID);
}
	

	private void clearInputFields() {
        txtName.setText("");
        txtContactnum.setText("");
        txtCompany.setText("");
        txtSalary.setText("");
        txtBD.setText("");
        setNextContactID();
    }

}
