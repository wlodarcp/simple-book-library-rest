package books.library.boklibrary.configuration.security;

import books.library.boklibrary.domain.LibraryUser;
import books.library.boklibrary.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        return userRepository.findByUsername(username).map(MyUserPrincipal::new)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    @RequiredArgsConstructor
    public class MyUserPrincipal implements UserDetails {

        private final LibraryUser libraryUser;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return libraryUser.getAuthorities();
        }

        @Override
        public String getPassword() {
            return libraryUser.getPassword();
        }

        @Override
        public String getUsername() {
            return libraryUser.getUsername();
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}