package CollageApp;


public class Student {//class start
	
   private int id; private String name,email;////declare private valriable
   
    public Student(int id, String name, String email) {//create constructor to intialize value of user name, id and email
        this.name = name;
        this.id = id;
        this.email=email;
    }//end constructor
    public int getId() {//getter to get id
        return id;
    }//end getter

    public void setId(int id) {//create setter
        this.id = id;
    }//end setter
    public String getName() {//getter to get user name
        return name;
    }//end getter

    public void setName(String name) {//setter to set the name
        this.name = name;
    }//end setter

   
    public String getemail() {//getter to get email
        return email;
    }//end getter
    
    public void setemail(String email) {//setter to set the email
        this.email = email;
    }//end setter
    
    
    @Override
    public String toString() {// overridden to return a string that includes the name, id, and email attributes of the object. 
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", email=" + email+
                '}';
    }//end to string method
}//end class