package UMC_Hackathon.DailyMate.web.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
        LocalDate birthday; // LocalDate로 선언..?

    }
}
