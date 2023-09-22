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
               
            Book temp=new Book(attributes[2],attributes[3],Integer.parseInt(attributes[4]),Integer.parseInt(attributes[5]),Integer.parseInt(attributes[6]));
             temp.set_id(Integer.parseInt(attributes[1]));
         // temp.set_id(temp_id);
            temp.borrow=Integer.parseInt(attributes[7]);
             books.add( temp);
            }
            else if(Integer.parseInt(attributes[0])==2){
                
                String[] a_names=attributes[3].split(" " );
                ArrayList<String> a= new ArrayList<String>();
                for(int i=0;i<a_names.length;i++){
                    a.add(a_names[i]);
                }
                magzine temp= new magzine(attributes[2], attributes[4],a,Integer.parseInt(attributes[5]),Integer.parseInt(attributes[6]) );
                temp.set_Id(Integer.parseInt(attributes[1]));
                temp.borrow=Integer.parseInt(attributes[7]);
                books.add( temp);
            }
            else{
                
                newspaper temp= new newspaper(attributes[2],attributes[3],attributes[4],Integer.parseInt(attributes[5]),Integer.parseInt(attributes[6]));
                temp.set_ID(Integer.parseInt(attributes[1]));
temp.borrow=Integer.parseInt(attributes[7]);
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
     System.out.println("Enter 1 For Book 2 For Magzine 3 for Newspaper");
Scanner sc= new Scanner(System.in);
int option=sc.nextInt();
 BufferedWriter bw = new BufferedWriter(new FileWriter("LMS/data.txt",true));
if(option==1){
    String title, author;
    int year;
    sc.nextLine();
    System.out.println("Enter the title of the book: ");
    
    title =sc.nextLine();
    
    
    System.out.println("Enter the author of the book: ");
    author=sc.nextLine();
    System.out.println("Enter the year of publication of the book: ");
    year=sc.nextInt();
   
    System.out.println("Enter Price: ");
    int pri=sc.nextInt();
    Book book= new Book(title, author, year,0,pri);
    item.add( book);

        
        bw.write("\n1"+book.id + "," + book.title + "," + book.author + "," + book.year+","+book.Popularity+","+book.price+","+book.borrow);
}
else if(option==2){
    String NTitle, pub;
    ArrayList<String>Auth=new ArrayList<>();
    sc.nextLine();
    System.out.println("Enter new title of the Magzine: ");
     NTitle =sc.nextLine();

    System.out.println("Enter new authors of the book: ");
    for(int j=0;j<3;j++)
    Auth.add(sc.nextLine());
    System.out.println("Enter new year of publisher: ");
    pub=sc.nextLine();
  
    System.out.println("Enter Price: ");
    int pri=sc.nextInt();

    magzine m=new magzine(NTitle, pub, Auth, 0, pri);
    item.add(m);
    bw.write("\n2,"+m.id + "," + m.title + "," );
 Iterator<String> itr=m.authors.iterator();
 while(itr.hasNext())
 {
    bw.write(itr.next()+" ");
 }
 bw.write("," + m.publisher+","+m.Popularity+","+m.price+","+m.borrow);

}
      else if(option==3){

         String NTitle, NPub;
    String dte;
    sc.nextLine();
    System.out.println("Enter new title of the Newspaper: ");
     NTitle =sc.nextLine();

    System.out.println("Enter new publisher of the Newspaper: ");
    NPub=sc.nextLine();
    System.out.println("Enter new Date: ");
    dte=sc.nextLine();
   
    System.out.println("Enter Price: ");
    int pri=sc.nextInt();
    newspaper t=new newspaper(NTitle, NPub, dte, 0, pri);
    item.add(t);
    bw.write("\n3"+t.id + "," + t.title + "," + t.publisher + "," + t.date+","+t.Popularity+","+t.price+","+t.borrow);
      }
        bw.close();

}
 
void Edit_Book()throws IOException{
     System.out.print("\033[H\033[2J");
     Scanner sc =new Scanner(System.in);
  
    
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
    System.out.println("Enter Popularity Index: ");
    int pop=sc.nextInt();
    System.out.println("Enter Price: ");
    int pri=sc.nextInt();
    book.author=NAuthor;
    book.title=NTitle;
    book.year=NYear;
    book.price=pri;
    book.Popularity=pop;
break;
    }
   else if(item.elementAt(i) instanceof magzine){
        magzine temp = (magzine) item.elementAt(i);
    String NTitle, pub;
    ArrayList<String>Auth=new ArrayList<>(null);
    sc.nextLine();
    System.out.println("Enter new title of the Magzine: ");
     NTitle =sc.nextLine();

    System.out.println("Enter new authors of the book: ");
    for(int j=0;j<3;j++)
    Auth.add(sc.nextLine());
    System.out.println("Enter new year of publisher: ");
    pub=sc.nextLine();
    System.out.println("Enter Popularity Index: ");
    int pop=sc.nextInt();
    System.out.println("Enter Price: ");
    int pri=sc.nextInt();
    temp.authors=Auth;
    temp.title=NTitle;
    temp.publisher=pub;
    temp.Popularity=pop;
    temp.price=pri;
break;
    }
    else if(item.elementAt(i) instanceof newspaper){
        newspaper temp = (newspaper) item.elementAt(i);
    String NTitle, NPub;
    String dte;
    sc.nextLine();
    System.out.println("Enter new title of the Newspaper: ");
     NTitle =sc.nextLine();

    System.out.println("Enter new publisher of the Newspaper: ");
    NPub=sc.nextLine();
    System.out.println("Enter new Date: ");
    dte=sc.nextLine();
    System.out.println("Enter Popularity Index: ");
    int pop=sc.nextInt();
    System.out.println("Enter Price: ");
    int pri=sc.nextInt();
    temp.publisher=NPub;
    temp.title=NTitle;
    temp.date=dte;
    temp.Popularity=pop;
    temp.price=pri;
break;
    }
}


}

BufferedWriter bw = new BufferedWriter(new FileWriter("LMS/data.txt"));

       
         

for(int i=0;i<item.size();i++){
     if(i==0){
    if (item.elementAt(i) instanceof Book){
    
    Book t=(Book) item.elementAt(i);
    
 bw.write("1,"+t.id + "," + t.title + "," + t.author + "," + t.year+","+t.Popularity+","+t.price+","+t.borrow);
    }
   else if (item.elementAt(i) instanceof magzine){
    
    magzine t=(magzine) item.elementAt(i);
    
 bw.write("2,"+t.id + "," + t.title + "," );
 Iterator<String> itr=t.authors.iterator();
 while(itr.hasNext())
 {
    bw.write(itr.next()+" ");
 }
 bw.write("," + t.publisher+","+t.Popularity+","+t.price+","+t.borrow);
    }
   else if (item.elementAt(i) instanceof newspaper){
    
   newspaper t= (newspaper) item.elementAt(i);
 bw.write(t.id + "," + t.title + "," + t.publisher + "," + t.date+","+t.Popularity+","+t.price+","+t.borrow);
    }
}
else

{
    if (item.elementAt(i) instanceof Book){
    
    Book t=(Book) item.elementAt(i);
    
 bw.write("\n1,"+t.id + "," + t.title + "," + t.author + "," + t.year+","+t.Popularity+","+t.price+","+t.borrow);
    }
   else if (item.elementAt(i) instanceof magzine){
    
    magzine t=(magzine) item.elementAt(i);
    
 bw.write("\n2,"+t.id + "," + t.title + "," );
 Iterator<String> itr=t.authors.iterator();
 while(itr.hasNext())
 {
    bw.write(itr.next()+" ");
 }
 bw.write("," + t.publisher+","+t.Popularity+","+t.price+","+t.borrow);
    }
   else if (item.elementAt(i) instanceof newspaper){
    
   newspaper t= (newspaper) item.elementAt(i);
 bw.write("\n"+t.id + "," + t.title + "," + t.publisher + "," + t.date+","+t.Popularity+","+t.price+","+t.borrow);
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
     
    System.out.println("\n\nEnter Item ID: ");
    Scanner sc =new Scanner(System.in);
int find=sc.nextInt();

for(int i=0;i<item.size();i++){
if(item.elementAt(i).id==find){
    item.elementAt(i).display();
break;
}

}
}

public void displayHotPicks() {
    List<material> hotPicks = new ArrayList<>();

    for (int i=0;i<item.size();i++) {
        hotPicks.add(item.elementAt(i));
    }

    hotPicks.sort((item1, item2) -> item2.getPopularityCount() - item1.getPopularityCount());

    System.out.println("Hot Picks:");
    for (material item : hotPicks) {
        System.out.println(item.title);
    }
}
    void Menu(){
       
        System.out.println("1.Display Hot Picks");
        System.out.println("2.Add Item");
         System.out.println("2.Edit Item");
          System.out.println("2.Delete Item");
           System.out.println("5.View All Item");
            System.out.println("6.View Item by ID");
            System.out.println("7 Borrow Item");
            System.out.println("8. Display Borrow Information");
             System.out.println("9.Exit");
             System.out.print("Enter option: ");

    }
    void borrow_item(){
        this.print_all();
        System.out.println("Enter Item ID: ");
        Scanner sc= new Scanner(System.in);
        int find=sc.nextInt();
        System.out.println("Enter Borrower Name: ");
        String n=sc.nextLine();
        Borrower b1=new Borrower(n);
        for(int i=0;i<item.size();i++){
if(item.elementAt(i).id==find){
    if(item.elementAt(i).borrow==0){
        b1.borrowedBooks.add(item.elementAt(i));
        item.elementAt(i).borrow=1;
        item.elementAt(i).incrementPopularityCount();
break;}
}
else{
    System.out.println("Already Borrowed!");
    return;
}
        }

    }
public static void main(String args[])throws IOException{
Library lib=new Library();

// ArrayList<String> a= new ArrayList<String>();
// a.add("Ahmed");
// a.add("Hammad");
// a.add("Ahad");

// material m1=new magzine("Jang", "Geo",a);
// m1.display();

boolean flag=true;
int option;
Scanner sc= new Scanner(System.in);
while(flag){
lib.Menu();
option=sc.nextInt();
if(option==1)
lib.displayHotPicks();

if(option==2)
lib.Add_book();

else if(option==3)
lib.Edit_Book();

else if(option==4)
lib.delete_book();

else if(option==5)
lib.print_all();

else if(option==6)
lib.view_by_id();

else if(option==7)
lib.borrow_item();

// else if(option==6)
// lib.view_by_id();
else if(option==9)
break;

else{
    System.out.println("Invalid Option");
}
}

}
}
class material  implements Configration{
static int nextId; // Static variable to auto-increment the ID
int id;
String title;
int Popularity;
int price;
int borrow;
static{
    nextId=1;
}

public void display(){}
public int getPopularityCount() {
        return Popularity;
    }

    public void incrementPopularityCount() {
        Popularity++;
    }

}
class magzine extends material{
String publisher;
ArrayList<String> authors;
magzine(String ttle,String publ,ArrayList<String> auth, int pop, int pri){
this.id=nextId++;
this.title=ttle;
this.publisher=publ;
this.authors=auth;
this.price=pri;
this.Popularity=pop;

}
@Override
public void display(){
System.out.print("ID: "+this.id+" Title :"+this.title+" Authors are ");
for(int i=0;i<authors.size();i++){
    System.out.print(authors.get(i)+" ");
}
System.out.println("Published by "+this.publisher);
}
void set_Id(int i){
this.id=i;

}
@Override
public int cost_cal(){
    return this.price*this.Popularity;
}

}
class newspaper extends material{

String publisher;
String date;

newspaper(String t,String Pub,String dat, int pop, int pri){
this.id=nextId++;
this.title=t;
this.publisher=Pub;
this.date=dat;
this.price=pri;
this.Popularity=pop;

}
@Override
public void display(){
System.out.println("ID: "+this.id+" Title: "+this.title+" Published By "+this.publisher+" on "+this.date);


}
@Override
public int cost_cal(){
return 10+5;

}
void set_ID(int i){
this.id=i;

}
}

interface Configration{
    default void display(){}
    default int cost_cal(){
        return 0;
    }
}
class Borrower {
    private String name;
    
     List<material> borrowedBooks;

    public Borrower(String name) {
        this.name = name;
        
        borrowedBooks = new ArrayList<>();
    }

    public List<material> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}
