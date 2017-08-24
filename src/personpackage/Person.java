package personpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.script.Compilable;

public class Person implements Serializable ,Comparable<Person>{
	
	private String personId;
	private String firstname;
	private String lastname;
	private List<Address> listAddress;
	private Date birthday;
	private List<String> listCellphone;
	private List<String> listMail;	
	
	public Person() {
		this("", "", "",new ArrayList<Address>(),new Date() ,new ArrayList<String>(), new ArrayList<String>(),"fullname");
	}
	public Person(String personId, String firstname, String lastname, List<Address> listAddress, Date birthday,
			List<String> listCellphone, List<String> listMail) {
		this("", "", "",new ArrayList<Address>(),new Date() ,new ArrayList<String>(), new ArrayList<String>(),"fullname");
	}
	public Person(String personId, String firstname, String lastname, List<Address> listAddress, Date birthday,
			List<String> listCellphone, List<String> listMail, String typeOfSort) {
		super();
		this.personId = personId;
		this.firstname = firstname;
		this.lastname = lastname;
		this.listAddress = listAddress;
		this.birthday = birthday;
		this.listCellphone = listCellphone;
		this.listMail = listMail;
	}

	public String getPersonId() {
		return personId;
	}

	public void setPersonId(String personId) {
		this.personId = personId;
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public List<Address> getListAddress() {
		return listAddress;
	}
	public void setListAddress(List<Address> listAddress) {
		this.listAddress = listAddress;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public List<String> getListCellphone() {
		return listCellphone;
	}
	public void setListCellphone(List<String> listCellphone) {
		this.listCellphone = listCellphone;
	}
	public List<String> getListMail() {
		return listMail;
	}
	public void setListMail(List<String> listMail) {
		this.listMail = listMail;
	}
	public void addAddress(Address address) {
		this.listAddress.add(address);
	}
	public void deleteAddress(int index) {
		this.listAddress.remove(index);
	}
	public void addCellPhone(String cellphone) {
		this.listCellphone.add(cellphone);
	}
	public void deleteCellPhone(int index) {
		this.listCellphone.remove(index);
	}
	public void addListMail(String mail) {
		this.listMail.add(mail);
	}
	public void deleteListMail(int index) {
		this.listMail.remove(index);
	}

	@Override
	public String toString() {
		return firstname + " " + lastname + ", birthday :" + ((birthday.getYear())-1900)+"/"+(birthday.getMonth())+"/"+(birthday.getDate()
				+ ""+listAddress.get(0).getPostalcode()) ;
	}
	public String toString2() {
		return firstname + " " + lastname + ", birthday :" + birthday + " Cellphone :" 
	          + listCellphone + " Mail : " + listMail+ "\n listAddress=" + listAddress ;
	}
	@Override
	public int compareTo(Person o) {
		if(o.firstname.compareTo(firstname)>0)return -1;
		if(o.firstname.compareTo(firstname)>0)return 1;
		return 0;
	}

}
