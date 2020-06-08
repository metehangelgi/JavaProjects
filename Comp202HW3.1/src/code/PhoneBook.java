package code;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import autograder.Autograder;
import given.ContactInfo;
import given.Entry;

/*
 * A phonebook class that should:
 * - Be efficiently (O(log n)) searchable by contact name
 * - Be efficiently (O(log n)) searchable by contact number
 * - Be searchable by e-mail (can be O(n)) 
 * 
 * The phonebook assumes that names and numbers will be unique
 * Extra exercise (not to be submitted): Think about how to remove this assumption
 * 
 * You need to use your own data structures to implement this
 * 
 * Hint: You need to implement a multi-map! 
 * 
 */
public class PhoneBook {

  /*
   * ADD MORE FIELDS IF NEEDED
   *
   */
  private BinarySearchTree<String,ContactInfo> contactName;
  private BinarySearchTree<String,ContactInfo> contactNumber;
  private int size=0;

  public PhoneBook() {
    /*
     * TO BE IMPLEMENTED
     * 
     */
    contactName=new BinarySearchTree<>();
    contactNumber=new BinarySearchTree<>();
    contactName.setComparator(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        for (int i = 0; i<o1.length() && i<o2.length(); i++) {
          char o1C=o1.charAt(i);
          char o2C=o2.charAt(i);
          if(o1C>o2C) return 1;
          else if(o1C<o2C) return -1;
        }
        if(o1.length()>o2.length()) return 1;
        if(o1.length()<o2.length()) return -1;
        return 0;
      }
    });
    contactNumber.setComparator(new Comparator<String>() {
      @Override
      public int compare(String o1, String o2) {
        for (int i = 0; i<o1.length() && i<o2.length(); i++) {
          char o1C=o1.charAt(i);
          char o2C=o2.charAt(i);
          if(o1C<o2C) return 1;
          else if(o1C>o2C) return -1;
        }
        if(o1.length()>o2.length()) return -1;
        if(o1.length()<o2.length()) return 1;
        return 0;
      }
    });
  }

  // Returns the number of contacts in the phone book
  public int size() {
    return contactName.size();
  }

  // Returns true if the phone book is empty, false otherwise
  public boolean isEmpty() {
    return size==0;
  }

  //Adds a new contact or overwrites an existing contact with the given info
  // Args should be given in the order of e-mail and address which is handled for
  // you
  // Note that it can also be empty. If you do not want to update a field pass
  // null
  public void addContact(String name, String number, String... args) {
    int numArgs = args.length;
    String email = null;
    String address = null;

    /*
     * Add stuff here if needed
     */

    if (numArgs > 0)
      if (args[0] != null)
        email = args[0];
    if (numArgs > 1)
      if (args[1] != null)
        address = args[1];
    if (numArgs > 2)
      System.out.println("Ignoring extra arguments");

    /*
     * TO BE IMPLEMENTED
     * 
     */
    ContactInfo contactInfo=new ContactInfo(name,number);
    contactInfo.setEmail(email);
    contactInfo.setAddress(address);
    contactName.put(name,contactInfo);
    contactNumber.put(number,contactInfo);
    size++;
  }

  // Return the contact info with the given name
  // Return null if it does not exists
  // Should be O(log n)!
  public ContactInfo searchByName(String name) {
    /*
     * TO BE IMPLEMENTED
     * 
     */
    return contactName.get(name);
  }

  // Return the contact info with the given phone number
  // Return null if it does not exists
  // Should be O(log n)!
  public ContactInfo searchByPhone(String phoneNumber) {
    /*
     * TO BE IMPLEMENTED
     * 
     */
    return contactNumber.get(phoneNumber);

  }

  // Return the contact info with the given e-mail
  // Return null if it does not exists
  // Can be O(n)
  public ContactInfo searchByEmail(String email) {
    /*
     * TO BE IMPLEMENTED
     * 
     */
    if(isEmpty()) return null;
    List<ContactInfo> list=getContacts().stream().filter(s->s.getEmail()!=null).filter(s->s.getEmail().equals(email)).collect(Collectors.toList());
    if(list.isEmpty()) return null;
    return list.get(0);

  }

  // Removes the contact with the given name
  // Returns true if there is a contact with the given name to delete, false otherwise
  public boolean removeByName(String name) {
    /*
     * TO BE IMPLEMENTED
     * 
     */
    if (isEmpty()) return false;
    ContactInfo removedInfo=contactName.remove(name);
    if(removedInfo==null) return false;
    contactNumber.remove(removedInfo.getNumber());
    size--;
    return true;
  }

  // Removes the contact with the given name
  // Returns true if there is a contact with the given number to delete, false otherwise
  public boolean removeByNumber(String phoneNumber) {
    /*
     * TO BE IMPLEMENTED
     * 
     */
    if (isEmpty()) return false;
    ContactInfo removedInfo=contactNumber.remove(phoneNumber);
    if(removedInfo==null) return false;
    contactName.remove(removedInfo.getName());
    size--;
    return true;
  }

  // Returns the number associated with the name
  public String getNumber(String name) {
    /*
     * TO BE IMPLEMENTED
     * 
     */
    ContactInfo info=contactName.get(name);
    if(info==null) return null;
    return info.getNumber();
  }

  // Returns the name associated with the number
  public String getName(String number) {
    /*
     * TO BE IMPLEMENTED
     * 
     */
    ContactInfo info=contactNumber.get(number);
    if(info==null) return null;
    return info.getName();
  }
  
  // Update the email of the contact with the given name
  // Returns true if there is a contact with the given name to update, false otherwise
  public boolean updateEmail(String name, String email) {
    /*
     * TO BE IMPLEMENTED
     * 
     */
    ContactInfo info=contactName.get(name);
    if(info==null) return false;
    info.setEmail(email);

    return true;
  }
  
  // Update the address of the contact with the given name
  // Returns true if there is a contact with the given name to update, false otherwise
  public boolean updateAddress(String name, String address) {
    /*
     * TO BE IMPLEMENTED
     * 
     */
    ContactInfo info=contactName.get(name);
    if(info==null) return false;
    info.setAddress(address);
    return true;
  }

  // Returns a list containing the contacts in sorted order by name
  public List<ContactInfo> getContacts() {
    /*
     * TO BE IMPLEMENTED
     * 
     */
    if (isEmpty()) return null;
    return contactName.getNodesInOrder().stream().map(Entry::getValue).collect(Collectors.toList());
  }

  // Prints the contacts in sorted order by name
  public void printContacts() {
    /*
     * TO BE IMPLEMENTED
     * 
     */
    for (ContactInfo info:getContacts()) {
      System.out.println(info);
    }
  }
}
