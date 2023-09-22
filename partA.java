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

Book book= new Book(title, author, year,1,2);
book.display();


}


}
class Book extends material{

String author;
int year;


Book(String t, String a, int y,int pop,int pri) {
id = nextId++; 
title = t;
author = a;
year =y;
Popularity=pop;
price=pri;
borrow=0;
}
void set_id(int i){
this.id=i;

}

public void display() {
    System.out.println( "ID: " + id + " Title: " + title + " by " + author + "(" + year + ")" );

}
public int cost_cal(){
    return this.price+ 20*price+200;
}
}