package CollageApp;

class MatureStudent extends Student {//start class
    private int age;//declare private valriable
    public MatureStudent( int id, String name, int age, String email) {//create constaructr to intailxze the value of user id, age and email.
    
        super(id, name, email);//calls the constructor of the superclass (Student) using the super() keyword, passing in the id, name, and email arguments.
        this.age = age;
    }//end consructor

    public int getAge() {//getter to get user age
        return age;
    }//end getter

    public void setAge(int age) {//setter to set user age
        this.age = age;
    }//end setter
    
    @Override
    public String toString() {// overridden to return a string that includes the name, id, and email attributes of the object. 
        return "Student{" +
                "name='" + getName() + '\'' +
                ", id=" + getId() +
                ", email=" + getemail()+
                ",age=" + getAge()+
                '}';
    }//End method
}//end class
