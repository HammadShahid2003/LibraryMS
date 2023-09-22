package LMS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class Library {
    Vector<material> item;
    Library()throws IOException{

        this.item=this.load_items();
    }
    private    Vector<material> load_items() throws IOException{

    
         BufferedReader br = new BufferedReader(new FileReader("LMS/data.txt"));
 
       
         Vector<material> books = new Vector<>();
 
         
         String entry;
 
        int temp_id;
        String temp_author;
        String temp_title;
        String temp_year;
         while ((entry = br.readLine()) != null) {

           
 
                // temp_id = Integer.parseInt(st.nextToken());
                // temp_title=st.nextToken();
                // temp_author=st.nextToken();
                // temp_year=st.nextToken();

            
                
        
             String[] attributes = entry.split(",");
             

             if(Integer.parseInt(attributes[0])== 1) {

             
 
             
             //Book temp= new Book(temp_title,temp_author,Integer.parseInt(temp_year));
               
            Book temp=new Book(attributes[2],attributes[3],Integer.parseInt(attributes[4]));
             temp.set_id(Integer.parseInt(attributes[1]));
         // temp.set_id(temp_id);
            
             books.add( temp);
            }
            else if(Integer.parseInt(attributes[0])==2){
                
                String[] a_names=attributes[3].split(" " );
                ArrayList<String> a= new ArrayList<String>();
                for(int i=0;i<a_names.length;i++){
                    a.add(a_names[i]);
                }
                magzine temp= new magzine(attributes[2], attributes[4],a );
                temp.set_Id(Integer.parseInt(attributes[1]));

                books.add( temp);
            }
            else{
                
                newspaper temp= new newspaper(attributes[2],attributes[3],attributes[4]);
                temp.set_ID(Integer.parseInt(attributes[1]));

                books.add(temp);
            }
         }
 
         
          br.close();
 
        
    
     
 
 return books;

    }
void print_all (){
     //System.out.print("\033[H\033[2J");
 Iterator<material> it=this.item.iterator();
while(it.hasNext()){
it.next().display();
}
}
void Add_book () throws IOException{
     System.out.print("\033[H\033[2J");
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
    item.add( book);
     BufferedWriter bw = new BufferedWriter(new FileWriter("LMS/data.txt",true));

        
        bw.write("\n"+book.id + "," + book.title + "," + book.author + "," + book.year);

      
        bw.close();

}
 
void Edit_Book()throws IOException{
     System.out.print("\033[H\033[2J");
     Scanner sc =new Scanner(System.in);
     System.out.println("Enter 1 For Book 2 for Magzine 3 for Newspaper");
     int type=sc.nextInt();
     if(type==1){
System.out.println("Enter Book ID: ");

int find=sc.nextInt();

for(int i=0;i<item.size();i++){
if(item.elementAt(i).id==find){
    if(item.elementAt(i) instanceof Book){
        Book book = (Book) item.elementAt(i);
    String NTitle, NAuthor;
    int NYear;
    sc.nextLine();
    System.out.println("Enter new title of the book: ");
     NTitle =sc.nextLine();

    System.out.println("Enter new author of the book: ");
    NAuthor=sc.nextLine();
    System.out.println("Enter new year of publication of the book: ");
    NYear=sc.nextInt();
    book.author=NAuthor;
    book.title=NTitle;
    book.year=NYear;
break;
    }
}
}

}

BufferedWriter bw = new BufferedWriter(new FileWriter("LMS/data.txt"));

       
         

for(int i=0;i<item.size();i++){
     if(i==0){
    if (item.elementAt(i) instanceof Book){
    
    Book t=(Book) item.elementAt(i);
    
 bw.write("1,"+t.id + "," + t.title + "," + t.author + "," + t.year);
    }
   else if (item.elementAt(i) instanceof magzine){
    
    magzine t=(magzine) item.elementAt(i);
    
 bw.write("2,"+t.id + "," + t.title + "," );
 Iterator<String> itr=t.authors.iterator();
 while(itr.hasNext())
 {
    bw.write(itr.next()+" ");
 }
 bw.write("," + t.publisher);
    }
   else if (item.elementAt(i) instanceof newspaper){
    
   newspaper t= (newspaper) item.elementAt(i);
 bw.write(t.id + "," + t.title + "," + t.publisher + "," + t.date);
    }
}
else

{
    if (item.elementAt(i) instanceof Book){
    
    Book t=(Book) item.elementAt(i);
    
 bw.write("\n1,"+t.id + "," + t.title + "," + t.author + "," + t.year);
    }
   else if (item.elementAt(i) instanceof magzine){
    
    magzine t=(magzine) item.elementAt(i);
    
 bw.write("\n2,"+t.id + "," + t.title + "," );
 Iterator<String> itr=t.authors.iterator();
 while(itr.hasNext())
 {
    bw.write(itr.next()+" ");
 }
 bw.write("," + t.publisher);
    }
   else if (item.elementAt(i) instanceof newspaper){
    
   newspaper t= (newspaper) item.elementAt(i);
 bw.write("\n"+t.id + "," + t.title + "," + t.publisher + "," + t.date);
    }
}
}
       

      
       bw.close();
}

void delete_book()throws IOException{
     System.out.print("\033[H\033[2J");
System.out.println("Enter Book ID: ");
Scanner sc =new Scanner(System.in);
int find=sc.nextInt();

for(int i=0;i<item.size();i++){
if(item.elementAt(i).id==find){
    item.remove(i);
break;
}

}

BufferedWriter bw = new BufferedWriter(new FileWriter("LMS/data.txt"));

for(int i=0;i<item.size();i++){
     if(i==0){
    if (item.elementAt(i) instanceof Book){
    
    Book t=(Book) item.elementAt(i);
    
 bw.write("1,"+t.id + "," + t.title + "," + t.author + "," + t.year);
    }
   else if (item.elementAt(i) instanceof magzine){
    
    magzine t=(magzine) item.elementAt(i);
    
 bw.write("2,"+t.id + "," + t.title + "," );
 Iterator<String> itr=t.authors.iterator();
 while(itr.hasNext())
 {
    bw.write(itr.next()+" ");
 }
 bw.write("," + t.publisher);
    }
   else if (item.elementAt(i) instanceof newspaper){
    
   newspaper t= (newspaper) item.elementAt(i);
 bw.write(t.id + "," + t.title + "," + t.publisher + "," + t.date);
    }
}
else

{
    if (item.elementAt(i) instanceof Book){
    
    Book t=(Book) item.elementAt(i);
    
 bw.write("\n1,"+t.id + "," + t.title + "," + t.author + "," + t.year);
    }
   else if (item.elementAt(i) instanceof magzine){
    
    magzine t=(magzine) item.elementAt(i);
    
 bw.write("\n2,"+t.id + "," + t.title + "," );
 Iterator<String> itr=t.authors.iterator();
 while(itr.hasNext())
 {
    bw.write(itr.next()+" ");
 }
 bw.write("," + t.publisher);
    }
   else if (item.elementAt(i) instanceof newspaper){
    
   newspaper t= (newspaper) item.elementAt(i);
 bw.write("\n"+t.id + "," + t.title + "," + t.publisher + "," + t.date);
    }
}
}
       

      
       bw.close();


}
void view_by_id(){
     System.out.print("\033[H\033[2J");
    System.out.println("Enter Book ID: ");
    Scanner sc =new Scanner(System.in);
int find=sc.nextInt();

for(int i=0;i<item.size();i++){
if(item.elementAt(i).id==find){
    item.elementAt(i).display();
break;
}

}
}
    void Menu(){
       

        System.out.println("1.Add Book");
         System.out.println("2.Edit Book");
          System.out.println("3.Delete Book");
           System.out.println("4.View All Book");
            System.out.println("5.View Book by ID");
             System.out.println("6.Exit");
             System.out.print("Enter option: ");

    }
public static void main(String args[])throws IOException{
Library lib=new Library();
lib.print_all();

// ArrayList<String> a= new ArrayList<String>();
// a.add("Ahmed");
// a.add("Hammad");
// a.add("Ahad");

// material m1=new magzine("Jang", "Geo",a);
// m1.display();

// boolean flag=true;
// int option;
// Scanner sc= new Scanner(System.in);
// while(flag){
// lib.Menu();
// option=sc.nextInt();
// if(option==1)
// lib.Add_book();

// else if(option==2)
// lib.Edit_Book();

// else if(option==3)
// lib.delete_book();

// else if(option==4)
// lib.print_all();

// else if(option==5)
// lib.view_by_id();

// else if(option==6)
// break;

// else{
//     System.out.println("Invalid Option");
// }
}

}
//}
abstract class material{
static int nextId; // Static variable to auto-increment the ID
int id;
String title;
static{
    nextId=1;
}

abstract void display();


}
class magzine extends material{
String publisher;
ArrayList<String> authors;
magzine(String ttle,String publ,ArrayList<String> auth){
this.id=nextId++;
this.title=ttle;
this.publisher=publ;
this.authors=auth;


}
@Override
void display(){
System.out.print("ID: "+this.id+" Title :"+this.title+" Authors are ");
for(int i=0;i<authors.size();i++){
    System.out.print(authors.get(i)+" ");
}
System.out.println("Published by "+this.publisher);
}
void set_Id(int i){
this.id=i;

}

}
class newspaper extends material{

String publisher;
String date;

newspaper(String t,String Pub,String dat){
this.id=nextId++;
this.title=t;
this.publisher=Pub;
this.date=dat;


}
@Override
void display(){
System.out.println("ID: "+this.id+" Title: "+this.title+" Published By "+this.publisher+" on "+this.date);


}
void set_ID(int i){
this.id=i;

}
}