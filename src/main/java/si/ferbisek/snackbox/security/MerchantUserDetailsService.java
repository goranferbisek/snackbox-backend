package si.ferbisek.snackbox.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import si.ferbisek.snackbox.user.persistence.User;
import si.ferbisek.snackbox.user.persistence.UserRepository;

@RequiredArgsConstructor
public class MerchantUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
        return new MerchantUserDetails(user);
    }
}
