package UMC_Hackathon.DailyMate.web.dto;

import UMC_Hackathon.DailyMate.validation.annotation.ExistUsers;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ScheduleRequestDTO {
    @Getter
    public static class ScheduleDto {
        @NotNull
        String title;
        String content;
    }
}
