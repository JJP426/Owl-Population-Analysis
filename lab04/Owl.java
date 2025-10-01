// CSCI 1933 Lab 04

public class Owl {
    // TODO: Declare instance variables
     private String name;
     private int age;
     private double weight;

    // TODO:
    // 2. Create a constructor to set the instance variables
    public Owl(String name, int age, double weight){
        this.name = name;
        this.age = age;
        this.weight = weight;
    }

    // TODO:
    // 3. Write the appropriate getters and setters
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getAge()
        {
        return age;
        }
    public void setAge(int age)
        {
        this.age = age;
        }
    public double getWeight()
        {
        return weight;
        }
    public void setWeight(double weight)
        {
        this.weight = weight;
        }
    public boolean equals(Owl other){
        return this.name.equals(other.name) && this.age == other.age && this.weight == other.weight;
    }

    public static void main(String[] args){
        Owl owl1 = new Owl("owl1", 5, 12.0);
        Owl owl2 = new Owl("owl2", 5, 12.0);
        Owl owl3 = new Owl("owl1", 5, 12.0);
        System.out.println(owl1.equals(owl2));
        System.out.println(owl1.equals(owl3));
    }


}