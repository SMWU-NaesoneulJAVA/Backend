package SMWU.NaesoneulJAVA.NidonNaedon.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import SMWU.NaesoneulJAVA.NidonNaedon.models.User;


//카카오 id로 user 엔티티 검색. 
public interface UserRepository extends JpaRepository<User, Long> {
    User findByKakaoId(String kakaoId);
}