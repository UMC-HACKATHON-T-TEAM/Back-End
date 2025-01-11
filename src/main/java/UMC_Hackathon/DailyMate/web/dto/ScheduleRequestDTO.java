package UMC_Hackathon.DailyMate.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

public class ScheduleRequestDTO {
    @Getter
    public static class ScheduleDto {
        @NotNull
        String date;
        @NotBlank
        String title;
        @NotBlank
        String content;
    }

    @Getter
    @Setter
    public static class ScheduleUpdateRequestDto {
        @NotNull
        LocalDate date;
        @NotBlank
        String title;
        @NotBlank
        String content;
    }
}
