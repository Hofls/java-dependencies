package hofls.com.github.javagraphql.data.book;

import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class BookDataFetcher {

    private static List<Book> books = Arrays.asList(
            new Book("book-1", "HP and the Philosopher's Stone", "223", "author-1"),
            new Book("book-2", "Scooby Doo", "542", "author-2"),
            new Book("book-3", "Questions about unierse", "231", "author-3")
    );

    public DataFetcher getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");
            return books
                    .stream()
                    .filter(book -> book.getId().equals(bookId))
                    .findFirst()
                    .orElse(null);
        };
    }

}
