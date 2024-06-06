import java.util.ArrayList;
class CustomerController{
	public static boolean addContact(Contact contact){
		ArrayList <Contact>customerList=ContactDBConnection.getInstance().getContactList();
		return customerList.add(contact);	
	}
	public static boolean deleteCustomer(int index){
		ContactDBConnection.getInstance().getContactList().remove(index);
		return true;
	}
	public static boolean deleteCustomer(Contact customer){
		return ContactDBConnection.getInstance().getContactList().remove(customer);
	}
}
