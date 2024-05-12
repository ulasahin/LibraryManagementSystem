package com.example.LibraryManagementSystem.services.concretes;

import com.example.LibraryManagementSystem.core.exceptionhandling.exception.types.BusinessException;
import com.example.LibraryManagementSystem.core.security.services.JwtService;
import com.example.LibraryManagementSystem.entities.User;
import com.example.LibraryManagementSystem.repositories.UserRepository;
import com.example.LibraryManagementSystem.services.abstracts.AuthService;
import com.example.LibraryManagementSystem.services.dtos.requests.loginregister.LoginRequest;
import com.example.LibraryManagementSystem.services.dtos.requests.loginregister.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    @Override
    public void register(RegisterRequest request) {
        User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setAddress(request.getAddress());
        user.setPhoneNumber(request.getPhoneNumber());
        userRepository.save(user);

    }

    @Override
    public String login(LoginRequest request) {
        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() -> new BusinessException("E-posta ya da şifre yanlış."));

        Authentication authentication =
                authenticationManager
                        .authenticate(
                                new UsernamePasswordAuthenticationToken(request.getEmail(),request.getPassword()));

        if(!authentication.isAuthenticated())
            throw new BusinessException("E-posta ya da şifre yanlış.");

        // TODO: JWT Oluştur ve kullanıcıya ver.
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("UserId",user.getId());
        return jwtService.generateToken(user.getUsername(), extraClaims);
    }
}
