package books.library.boklibrary.api;

import books.library.boklibrary.domain.Book;
import books.library.boklibrary.domain.Tag;
import lombok.Value;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Value
class BookDto {
    Long id;
    String title;
    Set<AuthorDto> authors;
    boolean rented;
    Integer year;
    Set<String> tags;

    static BookDto from(Book book){
        return new BookDto(
                book.getId(),
                book.getTitle(),
                getAuthors(book),
                book.isRented(),
                book.getYear(),
                getTags(book));
    }

    private static Set<AuthorDto> getAuthors(Book book) {
        return Objects.nonNull(book.getAuthors())
                ? book.getAuthors().stream().map(AuthorDto::from).collect(Collectors.toSet())
                : new HashSet<>();
    }

    private static Set<String> getTags(Book book) {
        return Objects.nonNull(book.getTags())
                ? book.getTags().stream().map(Tag::getTag).collect(Collectors.toSet())
                : new HashSet<>();
    }
}
