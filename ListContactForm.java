import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ListContactForm extends JFrame{

    private JLabel title;

    private JButton btnname;
    private JButton btnsalary;
    private JButton btnBd;

    private JButton btncancle;

    private Listnameform Listnameform;
    private Listsalaryform Listsalaryform;
    private Listbirthdayform Listbirthdayform;

    ListContactForm(){
        setSize(850,500);
        setTitle("List Contact Form");
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);

        title=new JLabel("CONTACT LIST");
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setFont(new Font("",1,30));

        add("North",title);

        JPanel listpanel=new JPanel(new GridLayout(3,1,20,20));

        btnname=new JButton("List by Name");
        btnname.setFont(new Font("",1,25));
        btnname.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                if(Listnameform==null){
                    Listnameform=new Listnameform();
                }
                Listnameform.setVisible(true);
            }
        });
        listpanel.add(btnname);

        btnsalary=new JButton("List by Salary");
        btnsalary.setFont(new Font("",1,25));
        btnsalary.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                if(Listsalaryform==null){
                    Listsalaryform=new Listsalaryform();
                }
                Listsalaryform.setVisible(true);
            }
        });
        listpanel.add(btnsalary);

        btnBd=new JButton("List by Birthday");
        btnBd.setFont(new Font("",1,25));
        btnBd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt){
                if(Listbirthdayform==null){
                    Listbirthdayform=new Listbirthdayform();
                }
                Listbirthdayform.setVisible(true);
            }
        });
        listpanel.add(btnBd);


        add(listpanel,BorderLayout.CENTER);

        JPanel pnl=new JPanel(new FlowLayout(FlowLayout.RIGHT));

        btncancle=new JButton("Cancle");
        btncancle.setFont(new Font("",1,25));
        btncancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt){
				dispose();
			}
		});
        pnl.add(btncancle);

        add(pnl,BorderLayout.SOUTH);

    }
    
}
