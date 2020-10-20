
public class tester {

	public static void main(String[] args) {


		BookList.booklist.add(new Book(1234,"my",23));
		BookList.booklist.add(new Book(357,"title",77));
		BookList.booklist.add(new Book(45745,"tita",88));
		BookList.booklist.add(new Book(45621,"pop",11.02));
		BookList.booklist.add(new Book(3246,"quick",55.60));
	
		//BookList.sort_title();
		System.out.println(	BookList.returnListToString());
		
	}

}
