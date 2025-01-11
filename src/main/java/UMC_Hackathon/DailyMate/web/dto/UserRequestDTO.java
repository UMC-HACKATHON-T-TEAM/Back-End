package UMC_Hackathon.DailyMate.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

public class UserRequestDTO {
    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotBlank
        String email;
        @NotBlank
        String password;
        @NotNull
        String birthday; // LocalDate로 선언..?

    }

    @Data
    public static class EditInfoDto {
        String name;
        String password;
        String birth;
    }
}
