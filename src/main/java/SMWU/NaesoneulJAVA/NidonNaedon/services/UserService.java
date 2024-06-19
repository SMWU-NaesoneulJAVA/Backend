package SMWU.NaesoneulJAVA.NidonNaedon.services;

import SMWU.NaesoneulJAVA.NidonNaedon.dto.UserDTO;

public interface UserService {
    boolean validateUser(String kakaoId);
    UserDTO getUserNickname(String kakaoId);
    String getUserKakaoId(String userId);
    boolean updateUserData(String kakaoId, String name, String nickname); // 추가된 메서드
}
