package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.UserDTO;
import SMWU.NaesoneulJAVA.NidonNaedon.models.User;
import SMWU.NaesoneulJAVA.NidonNaedon.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean validateUser(String kakaoId) {
        Optional<User> userOptional = userRepository.findByKakaoId(kakaoId);
        return userOptional.isPresent();
    }

    @Override
    public UserDTO getUserNickname(String kakaoId) {
        User user = userRepository.findByKakaoId(kakaoId).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return new UserDTO(user.getKakaoId(), user.getNickname());
    }

    @Override
    public String getUserKakaoId(String userId) {
        User user = userRepository.findById(Long.parseLong(userId)).orElseThrow(() -> new IllegalArgumentException("User not found"));
        return user.getKakaoId();
    }
}
