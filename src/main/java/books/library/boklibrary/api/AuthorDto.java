package books.library.boklibrary.api;

import books.library.boklibrary.domain.Author;
import lombok.Value;

@Value
class AuthorDto {
    String name;
    String surname;

    static AuthorDto from(Author author) {
        return new AuthorDto(author.getName(), author.getSurname());
    }
}
