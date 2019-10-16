package books.library.boklibrary.api;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
class AuthorForm {
    @NotBlank
    String name;
    @NotBlank
    String surname;
}
