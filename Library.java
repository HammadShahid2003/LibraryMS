package LMS;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;
public class Library {
    Vector<Book> item;
    Library()throws IOException{

        this.item=this.load_books();
    }
    private    Vector<Book> load_books() throws IOException{

    
         BufferedReader br = new BufferedReader(new FileReader("LMS/data.txt"));
 
       
         Vector<Book> books = new Vector<>();
 
         
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
 
             
             //Book temp= new Book(temp_title,temp_author,Integer.parseInt(temp_year));
               
            Book temp=new Book(attributes[1],attributes[2],Integer.parseInt(attributes[3]));
             temp.set_id(Integer.parseInt(attributes[0]));
         // temp.set_id(temp_id);
            
             books.add(temp);
         }
 
         
          br.close();
 
        
    
     
 
 return books;

    }
void print_all (){
     System.out.print("\033[H\033[2J");
 Iterator<Book> it=this.item.iterator();
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
System.out.println("Enter Book ID: ");
Scanner sc =new Scanner(System.in);
int find=sc.nextInt();

for(int i=0;i<item.size();i++){
if(item.elementAt(i).id==find){
    String NTitle, NAuthor;
    int NYear;
    sc.nextLine();
    System.out.println("Enter new title of the book: ");
     NTitle =sc.nextLine();

    System.out.println("Enter new author of the book: ");
    NAuthor=sc.nextLine();
    System.out.println("Enter new year of publication of the book: ");
    NYear=sc.nextInt();
    item.elementAt(i).author=NAuthor;
    item.elementAt(i).title=NTitle;
    item.elementAt(i).year=NYear;
break;
}

}

BufferedWriter bw = new BufferedWriter(new FileWriter("LMS/data.txt"));

       
         

for(int i=0;i<item.size();i++){
if(i==0)
 bw.write(+this.item.elementAt(i).id + "," + item.elementAt(i).title + "," + item.elementAt(i).author + "," + item.elementAt(i).year);

else
 bw.write("\n"+this.item.elementAt(i).id + "," + item.elementAt(i).title + "," + item.elementAt(i).author + "," + item.elementAt(i).year);

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
if(i==0)
 bw.write(+this.item.elementAt(i).id + "," + item.elementAt(i).title + "," + item.elementAt(i).author + "," + item.elementAt(i).year);

else{
    bw.write("\n"+this.item.elementAt(i).id + "," + item.elementAt(i).title + "," + item.elementAt(i).author + "," + item.elementAt(i).year);
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

boolean flag=true;
int option;
Scanner sc= new Scanner(System.in);
while(flag){
lib.Menu();
option=sc.nextInt();
if(option==1)
lib.Add_book();

else if(option==2)
lib.Edit_Book();

else if(option==3)
lib.delete_book();

else if(option==4)
lib.print_all();

else if(option==5)
lib.view_by_id();

else if(option==6)
break;

else{
    System.out.println("Invalid Option");
}
}

}
}