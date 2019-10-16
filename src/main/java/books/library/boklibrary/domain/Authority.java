package books.library.boklibrary.domain;


import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
@Table(name = "authorities")
public class Authority implements GrantedAuthority {
    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthorityType authorityType;

    @Override
    public String getAuthority() {
        return authorityType.name();
    }

    public enum AuthorityType {
        ROLE_ADMIN,
        ROLE_USER
    }
}
