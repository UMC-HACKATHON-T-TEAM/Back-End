package UMC_Hackathon.DailyMate.service.HomeService;

import UMC_Hackathon.DailyMate.apiPayload.code.status.ErrorStatus;
import UMC_Hackathon.DailyMate.apiPayload.exception.handler.UserHandler;
import UMC_Hackathon.DailyMate.converter.HomeConverter;
import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.repository.ScheduleRepository;
import UMC_Hackathon.DailyMate.repository.UserRepository;
import UMC_Hackathon.DailyMate.service.WeatherService.WeatherQueryService;
import UMC_Hackathon.DailyMate.web.dto.HomeRequestDTO;
import UMC_Hackathon.DailyMate.web.dto.HomeResponseDTO;
import UMC_Hackathon.DailyMate.web.dto.WeatherDTO;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeQueryServiceImpl implements HomeQueryService {
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;
    private final WeatherQueryService weatherQueryService;

    @Override
    @Transactional
    public HomeResponseDTO.GetHomeResponseDTO getHome(Long userId, HomeRequestDTO.Coord coord) {
        Users user = userRepository.findById(userId).orElseThrow(() -> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
        String name = user.getName();

        //날씨 api 사용
        WeatherDTO.Weather weather = weatherQueryService.getWeather(coord.getLat(), coord.getLon());

        List<HomeResponseDTO.SchedulesDTO> schedules = new ArrayList<>();
        List<Schedules> schedulesList = scheduleRepository.getSchedulesByUser(user);
        for(Schedules s : schedulesList) {
            String title = s.getTitle();
            String content = s.getContent();
            HomeResponseDTO.SchedulesDTO schedule = HomeResponseDTO.SchedulesDTO.builder()
                    .schedule(title)
                    .preperance(content)
                    .build();
            schedules.add(schedule);
        }

        return HomeConverter.toHomeResponseDTO(name, weather, schedules);
    }
}
