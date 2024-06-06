import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class Searchcontactform extends JFrame{
    
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

    private JButton btnbacktohome;

    Searchcontactform(){

        setSize(580,500);
        setTitle("SearchContactForm");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        title=new JLabel("SEARCH CONTACT");
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
            @Override
            public void actionPerformed(ActionEvent e) {
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
                    contactFound = true;
                    break;
                }
            }

        if (!contactFound) {
            JOptionPane.showMessageDialog(this, "Contact not found.", "Error", JOptionPane.ERROR_MESSAGE);
        }



    }

}
