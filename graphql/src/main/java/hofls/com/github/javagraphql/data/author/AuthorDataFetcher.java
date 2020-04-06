package hofls.com.github.javagraphql.data.author;

import graphql.schema.DataFetcher;
import hofls.com.github.javagraphql.data.book.Book;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class AuthorDataFetcher {

    private static List<Author> authors = Arrays.asList(
            new Author("author-1", "Joanne", "Rowling"),
            new Author("author-2", "Herman", "Melville"),
            new Author("author-3", "Anne", "Rice")
    );

    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Book book = dataFetchingEnvironment.getSource();
            return authors
                    .stream()
                    .filter(author -> author.getId().equals(book.getAuthorId()))
                    .findFirst()
                    .orElse(null);
        };
    }
}
