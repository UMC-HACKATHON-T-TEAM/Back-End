package UMC_Hackathon.DailyMate.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class ScheduleRequestDTO {
    @Getter
    public static class ScheduleDto {
        @NotBlank
        String title;
        @NotBlank
        String content;
    }

    @Getter
    @Setter
    public static class ScheduleUpdateRequestDto {
        @NotBlank
        String title;
        @NotBlank
        String content;
    }
}
