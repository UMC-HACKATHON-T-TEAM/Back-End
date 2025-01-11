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

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class FortuneResultDTO {
        private Integer point;
        private String content;
        private String color1;
        private String color1HexCode;
        private String color2;
        private String color2HexCode;
        private String item1;
        private String item2;
    }
}
