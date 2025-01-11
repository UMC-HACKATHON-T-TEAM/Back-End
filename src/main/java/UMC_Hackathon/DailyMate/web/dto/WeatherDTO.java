package UMC_Hackathon.DailyMate.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class WeatherDTO {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Weather {
        double temp;
        double feel_like;
        String position;
        String dust;
        double pop;
    }
}
