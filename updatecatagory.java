import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class updatecatagory extends JDialog {

    private JButton btnName;
    private JButton btnPhoneNum;
    private JButton btnCompany;
    private JButton btnSalary;
    private JButton btnCancel;

    private UpdateContactForm parentForm;

    public updatecatagory(UpdateContactForm parent) {
        super(parent, "Select Field to Update", true);
        this.parentForm = parent;
        setSize(400, 300);
        setLocationRelativeTo(parent);
        setLayout(new GridLayout(5, 1,10,10));

        btnName = new JButton("Name");
        btnName.setFont(new Font("", Font.BOLD, 20));
        btnName.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                parentForm.showUpdateDialog("Name");
                dispose();
            }
        });
        add(btnName);

        btnPhoneNum = new JButton("Phone Number");
        btnPhoneNum.setFont(new Font("", Font.BOLD, 20));
        btnPhoneNum.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                parentForm.showUpdateDialog("Phone Number");
                dispose();
            }
        });
        add(btnPhoneNum);

        btnCompany = new JButton("Company");
        btnCompany.setFont(new Font("", Font.BOLD, 20));
        btnCompany.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                parentForm.showUpdateDialog("Company");
                dispose();
            }
        });
        add(btnCompany);

        btnSalary = new JButton("Salary");
        btnSalary.setFont(new Font("", Font.BOLD, 20));
        btnSalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                parentForm.showUpdateDialog("Salary");
                dispose();
            }
        });
        add(btnSalary);

        
        btnCancel = new JButton("Cancel");
        btnCancel.setFont(new Font("", Font.BOLD, 20));
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
        add(btnCancel);
    }
}
