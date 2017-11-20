/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teledir;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author e1500943
 */
public class PersonCollection {
    private ArrayList<Person> persons=new ArrayList<>();

    public ArrayList<Person> getPersons() {
        return persons;
    }

    public void setPersons(ArrayList<Person> persons) {
        this.persons = persons;
    }
    
    public void writeToFile(String filePath) throws IOException{
        try(ObjectOutputStream out= new ObjectOutputStream(
        new FileOutputStream(filePath))){
            out.writeObject(persons);
        }
    }
    
     public void readFromFile(String filePath) throws IOException, ClassNotFoundException{
        try(ObjectInputStream in= new ObjectInputStream(
        new FileInputStream(filePath))){
            persons=(ArrayList<Person>) in.readObject();
        }
    }
    
}
