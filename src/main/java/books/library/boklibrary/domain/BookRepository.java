package books.library.boklibrary.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findAllByTitle(String title);

    List<Book> findAllByAuthorsIn(List<Author> author);

    List<Book> findAllByTagsIn(List<Tag> tags);
}
