package com.adam.app;

public class PersonBean implements Comparable<PersonBean> {

    int age = 0;
    String name = "";
    
    public PersonBean(int age, String name) {
        this.age = age;
        this.name = name;
    }
    
    
    
    public int getAge() {
        return age;
    }





    public void setAge(int age) {
        this.age = age;
    }





    public String getName() {
        return name;
    }





    public void setName(String name) {
        this.name = name;
    }



    
    


    @Override
    public boolean equals(Object obj) {
//        // TODO Auto-generated method stub
//        return super.equals(obj);
        
        if(obj instanceof PersonBean) {
            return false;
        }
        
        PersonBean p = (PersonBean)obj;
        
        return (this.age == p.age) && (this.name.equals(p.name));
        
    }



    @Override
    public int hashCode() {
//        // TODO Auto-generated method stub
//        return super.hashCode();
        int result = 17;
        result = 31 * result + age;
        result = 31 * result + name.hashCode();
        
        return result;
    }


    public String toString() {
        
        return (age + "(" + name + ")");
    }
    
    
    @Override
    public int compareTo(PersonBean arg0) {
        // TODO Auto-generated method stub
        int cop = age - arg0.getAge();
        
        if(cop != 0) {
            return cop;
        }
        
        
        return name.compareTo(arg0.getName());
    }

}
