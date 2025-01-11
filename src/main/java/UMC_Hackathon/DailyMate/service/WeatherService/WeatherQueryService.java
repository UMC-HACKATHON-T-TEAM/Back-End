package UMC_Hackathon.DailyMate.service.WeatherService;

import UMC_Hackathon.DailyMate.web.dto.WeatherDTO;
import org.springframework.stereotype.Service;

@Service
public interface WeatherQueryService {
    public WeatherDTO.Weather getWeather(double lat, double lon);
}
