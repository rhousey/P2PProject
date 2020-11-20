public class CSE216Student {
   private String lastName;
   private String firstName;

   public CSE216Student(String lastName, String firstName) {
	   this.lastName = lastName;
	   this.firstName = firstName;
   }
   
   public String getLastName() {
	   return lastName;
   }
   
   public String getFirstName() {
	   return firstName;
   }
   
   public boolean equals(CSE216Student s) {
	   return this.lastName.equals(s.getLastName())
			   && this.firstName.equals(s.getFirstName());
   }
   
   public String toString() {
	   return lastName + " " + firstName;
   }
   
   public int hashCode() {
	   return this.toString().hashCode();
   }
}
