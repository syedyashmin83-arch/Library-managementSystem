package library;
abstract class Book{
	private String title;
	private String auther;
	private int year;
	
	Book(){
		
	}
	Book(String title,String auther,int year){
		this.title=title;
		this.auther=auther;
		this.year=year;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuther() {
		return auther;
	}


	public void setAuther(String auther) {
		this.auther = auther;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}
	 abstract void displayDetails();
	
}
interface LibraryOperations{
	public void borrowBook();
	public void returnBook();
}
class TextBook extends Book implements LibraryOperations {
	String subject;
	
	TextBook(String title,String auther,int year,String subject){
		super(title,auther,year);
		this.subject=subject;
		
	}
	TextBook(){
		
	}
	
	void displayDetails(){
		System.out.println("TextBook");
		System.out.println("Title: "+getTitle());
		System.out.println("Auther: "+getAuther());
		System.out.println("year: "+getYear());
		System.out.println("subject: "+ subject);
	}
	
	@Override
	public void borrowBook() {
		System.out.println("TextBook borrowed for 15 days");
	}
	@Override
	public void returnBook() {
		System.out.println("TextBook returned");
	}
	
}
class Magazine extends Book implements LibraryOperations{
	
	int issueNumber;
	
	Magazine(String title,String auther,int year,int issueNumber){
		super(title,auther,year);
		this.issueNumber= issueNumber;
		
	}
	void displayDetails(){
		System.out.println("Magazine");
		System.out.println("Title: "+getTitle());
		System.out.println("Auther: "+getAuther());
		System.out.println("year: "+getYear());
		System.out.println("issueNumber: "+ issueNumber);
	}
	@Override
	public void borrowBook() {
		System.out.println("Magazine borrowed for 10 days");
	}
	@Override
	public void returnBook() {
		System.out.println("Magazine returned");
	}
	
}
class Novel extends Book implements LibraryOperations{
	
	String genre;
	
	Novel(String title,String auther,int year,String genre){
		super(title,auther,year);
		this.genre=genre;
		
	}
	void displayDetails(){
		System.out.println("Novel");
		System.out.println("Title: "+getTitle());
		System.out.println("Auther: "+getAuther());
		System.out.println("year: "+getYear());
		System.out.println("genre: "+ genre);
	}
	@Override
	public void borrowBook() {
		System.out.println("Novel borrowed for 20 days");
	}
	@Override
	public void returnBook() {
		System.out.println("Novel returned");
	}
	
}
public class LibraryManagement {
	public static void main(String[] args) {
		Book b1=new TextBook("java book", "james Gosling", 2020, "CS");
		Book b2=new Magazine("Readers digest","jhon Doe",2024,12);
		Book b3=new Novel("the Shinchan", "japan auther", 2004,"Entertainer");
		
//		TextBook tb=new TextBook();
//		tb.borrowBook();
		
		Book[] books= {b1,b2,b3};
			
		for(Book book:books) {
			book.displayDetails();
		
			
			LibraryOperations op=(LibraryOperations)book;
			op.borrowBook();
			op.returnBook();
			System.out.println("------------------");
		}
	}
	
}