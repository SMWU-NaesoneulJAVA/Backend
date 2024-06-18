package SMWU.NaesoneulJAVA.NidonNaedon.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "사용자 정보 DTO")
public class UserDTO {

    @Schema(description = "사용자 ID", example = "user123")
    private String userId;

    @Schema(description = "사용자 닉네임", example = "닉네임")
    private String nickname;

    public UserDTO(String userId, String nickname) {
        this.userId = userId;
        this.nickname = nickname;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
