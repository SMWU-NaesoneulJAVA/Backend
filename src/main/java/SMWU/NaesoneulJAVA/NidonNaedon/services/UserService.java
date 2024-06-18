package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.models.User;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean validateUser(String kakaoId) {
        Optional<User> userOptional = userRepository.findByKakaoId(kakaoId);
        return userOptional.isPresent();
    }
}
