package UMC_Hackathon.DailyMate.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ScheduleResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScheduleResultDto {
        Long scheduleId;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SchedulePreViewListDto {
        List<SchedulePreViewDto> scheduleList;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SchedulePreViewDto {
        Long scheduleId;
        LocalDate date;
        String title;
        String content;
        LocalDate createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ScheduleUpdateResultDto {
        Long scheduleId;
        LocalDateTime updatedAt;
    }
}
