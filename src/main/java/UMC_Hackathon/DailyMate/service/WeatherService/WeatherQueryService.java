package UMC_Hackathon.DailyMate.service.WeatherService;

import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.web.dto.WeatherDTO;
import org.springframework.stereotype.Service;

@Service
public interface WeatherQueryService {
    public WeatherDTO.Weather getWeather(Users user, double lat, double lon);
}
