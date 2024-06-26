import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainForm extends JFrame{
	private JLabel title2;

	private AddContactForm AddContactForm;
	private UpdateContactForm UpdateContactForm;
	private Deletecontactform Deletecontactform; 
	private Searchcontactform Searchcontactform;
	private ListContactForm ListContactForm;

	private JButton btnAddContact;
	private JButton btnUpdateContact;
	private JButton btnDeleteContact;
	private JButton btnSerachContact;
	private JButton btnListContact;
	private JButton btnExit;
	
	
	MainForm(){
		setSize(850,500);
		setTitle("Contact Management System");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		JPanel titlepanel=new JPanel(new GridLayout(1,1));

		

		title2=new JLabel("HOME PAGE");
		title2.setHorizontalAlignment(JLabel.CENTER);
		title2.setFont(new Font("",1,30));
		titlepanel.add(title2);

		add("North",titlepanel);

		JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        JLabel label = new JLabel("<html><div style='text-align: center;'><h1>iFRIEND<br>Contact Manager</h1></div></html>", SwingConstants.CENTER);
        leftPanel.add(label, BorderLayout.CENTER);
 


		JPanel buttonPanel=new JPanel(new GridLayout(6,1,10,10));
		
		btnAddContact=new JButton("Add Contact");
		btnAddContact.setFont(new Font("",1,25));
		btnAddContact.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt){
				if(AddContactForm==null){
					AddContactForm=new AddContactForm();
					}
					AddContactForm.setVisible(true);
				}
			});
		buttonPanel.add(btnAddContact);

		
		btnUpdateContact=new JButton("Update Contact");
		btnUpdateContact.setFont(new Font("",1,25));
		btnUpdateContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				if(UpdateContactForm==null){
					UpdateContactForm=new UpdateContactForm();
				}
				UpdateContactForm.setVisible(true);
			}
		});
		buttonPanel.add(btnUpdateContact);
		
		btnDeleteContact=new JButton("Delete Contact");
		btnDeleteContact.setFont(new Font("",1,25));
		btnDeleteContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				if(Deletecontactform==null){
					Deletecontactform=new Deletecontactform();
				}
				Deletecontactform.setVisible(true);
			}
		});
		buttonPanel.add(btnDeleteContact);
		
		btnSerachContact=new JButton("Search Contact");
		btnSerachContact.setFont(new Font("",1,25));
		btnSerachContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				if(Searchcontactform==null){
					Searchcontactform=new Searchcontactform();
				}
				Searchcontactform.setVisible(true);
			}
		});
		buttonPanel.add(btnSerachContact);
		
		btnListContact=new JButton("List Contact");
		btnListContact.setFont(new Font("",1,25));
		btnListContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				if(ListContactForm==null){
					ListContactForm=new ListContactForm();
				}
				ListContactForm.setVisible(true);
			}
		});
		buttonPanel.add(btnListContact);
		
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,25));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				System.exit(0);
			}
		});
		buttonPanel.add(btnExit);
		
		add(buttonPanel,BorderLayout.CENTER);

		add(leftPanel, BorderLayout.WEST);

		leftPanel.setPreferredSize(new Dimension(300, 0));

        setVisible(true);
		}
	}
	
	
class Demo{
	public static void main(String args[]){
		new MainForm().setVisible(true);
		}
	}
