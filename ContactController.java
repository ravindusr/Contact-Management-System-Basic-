import java.util.ArrayList;
import java.time.*;
class CustomerController{
	public static boolean addContact(Contact contact){
		ArrayList <Contact>ContactlList=ContactDBConnection.getInstance().getContactList();
		return ContactlList.add(contact);	
	}
	public static boolean deleteCustomer(int index){
		ContactDBConnection.getInstance().getContactList().remove(index);
		return true;
	}
	public static boolean deleteCustomer(Contact customer){
		return ContactDBConnection.getInstance().getContactList().remove(customer);
	}

	public static boolean isValidPhoneNumber(String phoneNumber){
        if(phoneNumber.length()==10 && phoneNumber.charAt(0)=='0'){
            for(int i=1; i<phoneNumber.length(); i++){
                if(!Character.isDigit(phoneNumber.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        return false;

    }

	public static boolean isValidBirthday(String bd){
        String y=bd.substring(0,4);
		int year=Integer.parseInt(y);
		String m=bd.substring(5,7);
		int month=Integer.parseInt(m);
		String d=bd.substring(8,10);
		int day=Integer.parseInt(d);
		LocalDate currentDate = LocalDate.now();
		int currentMonthValue = currentDate.getMonthValue();
		int currentYear=currentDate.getYear();    
		int currentMonthDate=currentDate.getDayOfMonth();
			
		if(year%4!=0 & month==2){
			if(day>28){
				return false;
			}else{
				return true;
			}
		}
		if(year%4==0 & month==2){
			if(day>29){
				return false;
			}else{
				return true;
			}
		}
		if(month==4 || month==6 || month==9 || month==11){
			if(day>30){
				return false;					
			}
		}
		if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12){
			if(day>31){
				return false;
			}	
		}
		if(month>12){
			return false;
		}
		if(year<currentYear){
			return true;
			}else if(year==currentYear){
									
				if(month>currentMonthValue){
					return true;
				}else if(month==currentMonthValue){
									
					if(day<=currentMonthDate){
						return true;
					}
				}
			}
					return false;
    }
}
