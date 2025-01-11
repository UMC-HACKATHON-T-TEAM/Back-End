package UMC_Hackathon.DailyMate.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class HomeResponseDTO {
    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class GetHomeResponseDTO{
        String name;
        WeatherDTO.Weather weather;
        List<SchedulesDTO> schedules;
    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SchedulesDTO{
        String schedule;
        String preperance;
    }
}
