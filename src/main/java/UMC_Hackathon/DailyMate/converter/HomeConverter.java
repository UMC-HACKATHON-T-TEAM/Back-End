package UMC_Hackathon.DailyMate.converter;

import UMC_Hackathon.DailyMate.web.dto.HomeResponseDTO;
import UMC_Hackathon.DailyMate.web.dto.WeatherDTO;

import java.util.List;

public class HomeConverter {
    public static HomeResponseDTO.GetHomeResponseDTO toHomeResponseDTO(String name, WeatherDTO.Weather weather, List<HomeResponseDTO.SchedulesDTO> schedules){
        return HomeResponseDTO.GetHomeResponseDTO.builder()
                .name(name)
                .weather(weather)
                .schedules(schedules)
                .build();
    }
}
