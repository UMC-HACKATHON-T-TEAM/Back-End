package UMC_Hackathon.DailyMate.service.WeatherService;

import UMC_Hackathon.DailyMate.converter.WeatherConverter;
import UMC_Hackathon.DailyMate.web.dto.WeatherDTO;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherQueryServiceImpl implements WeatherQueryService {
    private final RestTemplate restTemplate;

    public WeatherQueryServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public WeatherDTO.Weather getWeather(double lat, double lon) {
        String apiKey = "82e7fed59ae9ea9a08a7477a8511fd21";
        String url1 = String.format(
                "https://api.openweathermap.org/data/2.5/weather?lat=%s&lon=%s&units=metric&lang=kr&appid=%s",
                lat, lon, apiKey
        );
        JsonNode response1 = restTemplate.getForObject(url1, JsonNode.class);

        double temp = response1.get("main").get("temp").asDouble();
        double feel_like = response1.get("main").get("feels_like").asDouble();
        String position = response1.get("name").asText();

        String url2 = String.format(
                "http://api.openweathermap.org/data/2.5/air_pollution?lat=%s&lon=%s&appid=%s",
                lat, lon, apiKey
        );
        JsonNode response2 = restTemplate.getForObject(url2, JsonNode.class);

        JsonNode listNode = response2.get("list"); // 'list'가 배열인지 확인
        String dust = "";

        for (JsonNode item : listNode) {
            JsonNode mainNode = item.get("main");
            int aqi = mainNode.get("aqi").asInt();
            switch (aqi) {
                case 1:
                case 2:
                    dust = "좋음";
                    break;
                case 3:
                    dust = "보통";
                    break;
                case 4:
                case 5:
                    dust = "나쁨";
                    break;
            }
        }

        String url3 = String.format(
                "https://pro.openweathermap.org/data/2.5/forecast/hourly?lat=%s&lon=%s&appid=%s&cnt=12",
                lat, lon, apiKey
        );
        JsonNode response3 = restTemplate.getForObject(url3, JsonNode.class);

        double avgPop = 0;
        if (response3 != null && response3.has("list")) {
            JsonNode listNodes = response3.get("list");

            double popSum = 0;
            int count = 0;

            // "list" 배열을 순회하면서 pop 값을 가져옴
            for (JsonNode item : listNodes) {
                if (item.has("pop")) {
                    popSum += item.get("pop").asDouble();
                    count++;
                }
            }
            avgPop = popSum / count;
        }

        return WeatherConverter.toWeatherDTO(temp, feel_like, position, dust, avgPop);
    }
}
