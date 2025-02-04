package com.demo.Miscellanious;
import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }
}

public class SerializationExample {
    public static void main(String[] args) {
        // Serialization
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/adi.txt"))) {
            Student student = new Student("John", 20);
            out.writeObject(student);
            System.out.println("Serialization complete");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("student.ser"))) {
            Student restoredStudent = (Student) in.readObject();
            System.out.println("Deserialization complete");
            System.out.println("Restored Student: " + restoredStudent);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

