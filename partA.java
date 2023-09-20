package LMS;
import java.util.*;

public class partA{

public static void main(String args[]){
String title, author;
int year;
System.out.println("Enter the title of the book: ");
Scanner sc= new Scanner(System.in);
title =sc.nextLine();


System.out.println("Enter the author of the book: ");
author=sc.nextLine();
System.out.println("Enter the year of publication of the book: ");
year=sc.nextInt();

Book book= new Book(title, author, year);
book.display();
Book book1= new Book(title, author, year);
book1.display();
Book book2= new Book(title, author, year);
book2.display();
Book book3= new Book(title, author, year);
book3.display();
Book book4= new Book(title, author, year);
book4.display();

}


}
class Book {
static int nextId; // Static variable to auto-increment the ID
int id;
String title;
String author;
int year;


Book(String t, String a, int y) {
id = nextId++; 
title = t;
author = a;
year =y;
}
void set_id(int i){
this.id=i;

}

void display() {
    System.out.println( "ID: " + id + " Title: " + title + " by " + author + "(" + year + ")" );

}
static{
    Book.nextId=1;
}

}