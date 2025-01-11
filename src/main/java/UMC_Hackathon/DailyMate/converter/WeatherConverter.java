package UMC_Hackathon.DailyMate.converter;

import UMC_Hackathon.DailyMate.web.dto.WeatherDTO;

public class WeatherConverter {
    public static WeatherDTO.Weather toWeatherDTO(double temp, double feel_like, String position, String dust, double avgPop) {
        return WeatherDTO.Weather.builder()
                .temp(temp)
                .feel_like(feel_like)
                .position(position)
                .dust(dust)
                .pop(avgPop).build();
    }
}
