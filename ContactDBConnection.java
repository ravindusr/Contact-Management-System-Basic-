import java.util.*;
class ContactDBConnection{
	private ArrayList <Contact>ContactList;
	
	private static ContactDBConnection contactDBConnection;
	private ContactDBConnection(){
		ContactList=new ArrayList<>();
	}
	public static ContactDBConnection getInstance(){
		if(contactDBConnection==null){
			contactDBConnection=new ContactDBConnection();
		}
		return contactDBConnection;
	}
	public ArrayList<Contact>getContactList(){
		return ContactList;
	}
}

