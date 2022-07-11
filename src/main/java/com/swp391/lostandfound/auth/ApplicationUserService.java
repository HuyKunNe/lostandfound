package com.swp391.lostandfound.auth;


import com.swp391.lostandfound.entity.User;
import com.swp391.lostandfound.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicationUserService implements UserDetailsService {
    @Autowired
    private UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String studentCode) throws UsernameNotFoundException {
        User user = repo.findByStudentCodeLike(studentCode);
        if (user == null) {
            throw new UsernameNotFoundException("USER_NOT_FOUND!");
        }
        return new UserDetail(user);
    }

}
