package UMC_Hackathon.DailyMate.web.dto;

import UMC_Hackathon.DailyMate.domain.enums.Gender;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDate;

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
        Gender gender;
        @NotNull
        LocalDate birthday;
    }

    @Data
    public static class EditInfoDto {
        String name;
        String password;
        String birth;
    }
}
