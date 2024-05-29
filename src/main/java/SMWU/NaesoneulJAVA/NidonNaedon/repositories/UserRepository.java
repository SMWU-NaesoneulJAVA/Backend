package SMWU.NaesoneulJAVA.NidonNaedon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import SMWU.NaesoneulJAVA.NidonNaedon.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByKakaoId(String kakaoId);
}