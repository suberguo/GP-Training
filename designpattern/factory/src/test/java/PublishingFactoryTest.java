import com.dds.designpattern.factory.Book;
import com.dds.designpattern.factory.Magazine;
import com.dds.designpattern.factory.PublishingFactory;

public class PublishingFactoryTest {
    public static void main(String[] args) {
        PublishingFactory factory = new PublishingFactory();

        Book book = (Book) factory.create(Book.class);
        book.setAuthor("suber");
        book.setTitle("设计模式");
        book.setIsbn("1001");
        System.out.println(book);

        Magazine magazine = (Magazine)factory.create(Magazine.class);
        magazine.setTitle("致青春");
        magazine.setIsbn("2001");
        System.out.println(magazine);

    }
}
