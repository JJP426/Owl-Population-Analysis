// CSCI 1933 Lab 04

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;

public class OwlPopulation {
    private String fileName;
    private Owl[] data;

//Runs through file to determine how many owls are there and their criteria
    public int populateData() throws FileNotFoundException {
        File f = new File(fileName);
        Scanner s = new Scanner(f);
        int numLines = 0;
        while(s.hasNextLine()){
            numLines++;
            String str = s.nextLine();
        }
        s.close();
        data = new Owl[numLines];   //data is is allocated the exact amount of space it needs

        // Runs through file again and takes the strings of the owls (Age, weight, name)
        File c = new File(fileName);
        Scanner d = new Scanner(c);
        for (int i = 0; i < numLines; i++){
            String line = d.nextLine();
            String[] args = line.split(","); // looks like ["name", "7", "2.1"]
            int years = Integer.parseInt(args[1]);
            double x = Double.parseDouble(args[2]);
            String name = args[0];
            Owl owlCharecteristic = new Owl(name, years, x);
            data[i] = owlCharecteristic;
        }
        d.close();
        return numLines;
    }


    public OwlPopulation(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.populateData();
        //TODO: Populate the class variables in OwlPopulation
    }

    public double averageAge(){
        // Find average age of Owls
        int sum = 0;
        for(int i = 0; i < data.length; i++){
            int owlAge = data[i].getAge();
            sum += owlAge;
        }
        double average = (double)sum / data.length;
        return average;
    }

    public Owl getYoungest(){
        // Set default youngest owl
        Owl youngestOwl = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i].getAge() < youngestOwl.getAge()) {
                youngestOwl = data[i];
            }
        }
        return youngestOwl;
    }

    public Owl getHeaviest(){
        //Set default heaviest owl
        Owl owlHeaviest = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i].getWeight() > owlHeaviest.getWeight()) {
                owlHeaviest = data[i];
            }
        }
            return owlHeaviest;
    }

    public String toString(){
        return fileName + ":" + "\n" +"YOUNGEST OWL: " + getYoungest() + ", " + getYoungest().getAge() + " year(s) old" + "\n" +"HEAVIEST OWL: " + getHeaviest() + ", " + getHeaviest().getWeight() + " pound(s)" + "\n" + "AVERAGE AGE: " + averageAge() + " year(s) old" +"\n" + "POPULATION SIZE: " + data.length;

    }

    public boolean containsOwl(Owl other){
        // Loop through the array to check for duplicates
        for (int i = 0; i < data.length; i++){
            // Assuming Owl has an equals(Owl other) method that compares name, age, and weight
            if (data[i].equals(other)){
                return true;
            }
        }
        return false;
    }

    public void merge(OwlPopulation other){
        //TODO: a brief overview of what you can do to implement this method is given below:

        //1) determine (and store) the distinct owls in the other population.
        // Set up counters for distinct owls and duplicate
        int distinctOwls = data.length;
        int duplicateOwls = 0;
        // Determine amount of duplicate owls
        for (int i = 0; i < other.data.length; i++){
            if (this.containsOwl(other.data[i])){
                duplicateOwls++;
            }
        }
        //2) make a new data array to hold the correct number of owls for the merged population
        //Need to figure out how much space we need for the owls
        int actualDistinctOwls =  data.length + other.data.length - duplicateOwls;
        Owl[] newData = new Owl[actualDistinctOwls];

        //3) copy over the distinct owls from each population to the data array
        // Set the location of the newData array to equal the current spot so it will seamlessly add the owls
        int spotForOwl = 0;
        for (int i = 0; i < data.length; i++){
            newData[spotForOwl] = data[i];
            spotForOwl++;
        }
        //Weed out the duplicate birds for the new array
        for (int i = 0; i < other.data.length; i++){
            if (!this.containsOwl(other.data[i])){
                newData[spotForOwl] = other.data[i];
                spotForOwl++;
            }
        }
        //4) set the new data array to "this" data (where is the merged population? what happens to the original populations?)
        this.data = newData;
        this.fileName = this.fileName + " + " + other.fileName;
    }

    public int popSize(){
        return data.length;
    }
	
    public static void main(String[] args) {
        try {

            //The following should run when you are complete. Feel free to comment out as you see fit while you work.
            OwlPopulation pop1 = new OwlPopulation("owlPopulation1.csv");
            OwlPopulation pop2 = new OwlPopulation("owlPopulation2.csv");

	    // Milestone 2:
	    //System.out.println("Population1 has " + pop1.popSize() + " members");
	    //System.out.println("Population2 has " + pop2.popSize() + " members");

	    // Milestone 3: Comment these lines back in
	    System.out.println(pop1);
	    System.out.println(pop2);

            // Milestone 4: Comment these lines back in
            //pop1.merge(pop2);
            //System.out.println(pop1);
        }
        catch (FileNotFoundException f){
            System.out.println("File not found.");
        }
    }


}
