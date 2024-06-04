import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
class MainForm extends JFrame{
	private JLabel title;
	
	
	private JButton btnAddContact;
	private JButton btnUpdateContact;
	private JButton btnDeleteContact;
	private JButton btnSerachContact;
	private JButton btnListContact;
	private JButton btnExit;
	
	
	MainForm(){
		setSize(500,400);
		setTitle("Contact Management System");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		title=new JLabel("Contact Manager");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("",1,30));
		add("North",title);
		
		JPanel buttonPanel=new JPanel(new GridLayout(3,2));
		
		btnAddContact=new JButton("Add Contact");
		btnAddContact.setFont(new Font("",1,25));
		buttonPanel.add(btnAddContact);
		
		btnUpdateContact=new JButton("Update Contact");
		btnUpdateContact.setFont(new Font("",1,25));
		buttonPanel.add(btnUpdateContact);
		
		btnDeleteContact=new JButton("Delete Contact");
		btnDeleteContact.setFont(new Font("",1,25));
		buttonPanel.add(btnDeleteContact);
		
		btnSerachContact=new JButton("Search Contact");
		btnSerachContact.setFont(new Font("",1,25));
		buttonPanel.add(btnSerachContact);
		
		btnListContact=new JButton("List Contact");
		btnListContact.setFont(new Font("",1,25));
		buttonPanel.add(btnListContact);
		
		btnExit=new JButton("Exit");
		btnExit.setFont(new Font("",1,25));
		buttonPanel.add(btnExit);
		
		add("Center",buttonPanel);
		}
		

	}
	
	
class Demo{
	public static void main(String args[]){
		new MainForm().setVisible(true);
		}
	}
