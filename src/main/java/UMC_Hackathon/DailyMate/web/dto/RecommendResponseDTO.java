package UMC_Hackathon.DailyMate.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RecommendResponseDTO {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RecommendResultDTO {
        String fortunePoint;
        String fortuneDate;
        String recommend;
    }
}
