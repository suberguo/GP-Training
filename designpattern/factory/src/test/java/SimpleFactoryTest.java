import com.dds.designpattern.Bible;
import com.dds.designpattern.Book;
import com.dds.designpattern.Magazine;
import com.dds.designpattern.simplefactory.PublishingFactory;

/**
 * 简单工厂测试
 */
public class SimpleFactoryTest {
    public static void main(String[] args) {
        PublishingFactory factory = new PublishingFactory();

        Book book = (Book) factory.create(Book.class);
        book.setAuthor("suber");
        book.setTitle("设计模式");
        book.setIsbn("1001");
        System.out.println(book);

        Bible bible = (Bible)factory.create(Bible.class);
        bible.setIsbn("2001");
        System.out.println(bible);

    }
}
