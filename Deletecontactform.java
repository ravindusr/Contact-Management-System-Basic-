import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Deletecontactform extends JFrame{
    
    private JLabel title;

    private JTextField search;
    private JButton btnsearch;

    private JLabel lblId;
    private JLabel lblIdValue;
	private JLabel lblName;
    private JLabel lblNameValue;
	private JLabel lblContactnum;
    private JLabel lblContactnumValue;
	private JLabel lblCompany;
    private JLabel lblCompanyValue;
	private JLabel lblSalary;
    private JLabel lblSalaryValue;
	private JLabel lblBD;
    private JLabel lblBDValue;

    private JButton btndelete;;
    private JButton btncancle;
    private JButton btnbacktohome;

    private Contact foundContact;

    Deletecontactform(){

        setSize(850,500);
        setTitle("DeleteContactForm");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        title=new JLabel("DELETE CONTACT");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("",1,30));
      
        add("North",title);

        JPanel searchcomp=new JPanel(new FlowLayout());

        search=new JTextField(25);
        search.setFont(new Font("",1,20));
        searchcomp.add(search);
        
        btnsearch=new JButton("Search");
        btnsearch.setFont(new Font("",1,25));
        btnsearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchContact();
            }
        });
        searchcomp.add(btnsearch);

        add(searchcomp,BorderLayout.CENTER);


        
        JPanel lablePanel=new JPanel(new GridLayout(6,2));
        
        lblId=new JLabel("Contact ID ");
        lblId.setFont(new Font("",1,25));
        lablePanel.add(lblId);
        
        lblIdValue = new JLabel();
        lblIdValue.setFont(new Font("",1,25));
        lablePanel.add(lblIdValue);

        lblName=new JLabel("Name");
        lblName.setFont(new Font("",1,25));
        lablePanel.add(lblName);
        lblNameValue = new JLabel();
        lblNameValue.setFont(new Font("",1,25));
        lablePanel.add(lblNameValue);

        lblContactnum=new JLabel("Contact Number ");
        lblContactnum.setFont(new Font("",1,25));
        lablePanel.add(lblContactnum);
        lblContactnumValue = new JLabel();
        lblContactnumValue.setFont(new Font("",1,25));
        lablePanel.add(lblContactnumValue);


        lblCompany=new JLabel("Company ");
        lblCompany.setFont(new Font("",1,25));
        lablePanel.add(lblCompany);
        lblCompanyValue = new JLabel();
        lblCompanyValue.setFont(new Font("",1,25));
        lablePanel.add(lblCompanyValue);


        lblSalary=new JLabel("Salary ");
        lblSalary.setFont(new Font("",1,25));
        lablePanel.add(lblSalary);
        lblSalaryValue = new JLabel();
        lblSalaryValue.setFont(new Font("",1,25));
        lablePanel.add(lblSalaryValue);


        lblBD=new JLabel("Birthday");
        lblBD.setFont(new Font("",1,25));
        lablePanel.add(lblBD);
        lblBDValue = new JLabel();
        lblBDValue.setFont(new Font("",1,25));
        lablePanel.add(lblBDValue);


        add("West",lablePanel);

        JPanel downpanel=new JPanel(new FlowLayout(FlowLayout.CENTER));

        btndelete=new JButton("Delete");
        btndelete.setFont(new Font("",1,25));
        btndelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                deletecontact();
            }
        });
        downpanel.add(btndelete);

        btncancle=new JButton("Cancle");
        btncancle.setFont(new Font("",1,25));
        downpanel.add(btncancle);

        btnbacktohome=new JButton("Back To Home");
        btnbacktohome.setFont(new Font("",1,25));
        btnbacktohome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
                clearFields();
				dispose();
			}
        });
        downpanel.add(btnbacktohome);

        add(downpanel,BorderLayout.SOUTH);
    }

        private void searchContact() {
            String searchText = search.getText().trim();
            if (searchText.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please enter a contact name or phone number.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }


            boolean contactFound = false;
            for (Contact contact : ContactDBConnection.getInstance().getContactList()) {
                if (contact.getName().equalsIgnoreCase(searchText) || contact.getPhonenum().equals(searchText)) {
                    lblIdValue.setText(contact.getID());
                    lblNameValue.setText(contact.getName());
                    lblContactnumValue.setText(contact.getPhonenum());
                    lblCompanyValue.setText(contact.getCompany());
                    lblSalaryValue.setText(String.valueOf(contact.getSalary()));
                    lblBDValue.setText(contact.getBD());
                    foundContact = contact;
                    contactFound = true;
                    break;
                }
            }

        if (!contactFound) {
            JOptionPane.showMessageDialog(this, "Contact not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deletecontact(){
        if (foundContact == null) {
            JOptionPane.showMessageDialog(this, "Please search for a contact first.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int response = JOptionPane.showConfirmDialog(this, "Are you sure you want to delete this contact?", "Confirm ", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            ContactDBConnection.getInstance().getContactList().remove(foundContact);
            JOptionPane.showMessageDialog(this, "Contact deleted successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
            clearFields();
        }
            
    }

    private void clearFields() {
        lblIdValue.setText("");
        lblNameValue.setText("");
        lblContactnumValue.setText("");
        lblCompanyValue.setText("");
        lblSalaryValue.setText("");
        lblBDValue.setText("");
        search.setText("");
        foundContact = null;
    }


}
