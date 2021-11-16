// Ethan Thao 
// Week 2 Assignment Two
// 11/15/2021

// Here is the public class
// I have reduced the variables to only just a String and and int
public class AssignmentOnePet {

    private String name;
    private int age;

    // Then to get the name of the pet and the age
    public AssignmentOnePet(String name, int age) {

        this.name = name;

        this.age = age;

    }

    public String getName() {

        return name;

    }


    public void setName(String name) {

        this.name = name;

    }

    public int getAge() {

        return age;

    }

    public void setAge(int age) {

        this.age = age;

    }
}