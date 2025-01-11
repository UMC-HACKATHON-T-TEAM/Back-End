package UMC_Hackathon.DailyMate.service.UserService;

import UMC_Hackathon.DailyMate.apiPayload.code.status.ErrorStatus;
import UMC_Hackathon.DailyMate.apiPayload.exception.handler.UserHandler;
import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.domain.Weather;
import UMC_Hackathon.DailyMate.repository.ScheduleRepository;
import UMC_Hackathon.DailyMate.repository.UserRepository;
import UMC_Hackathon.DailyMate.repository.WeatherRepository;
import UMC_Hackathon.DailyMate.web.dto.UserResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;
    private final WeatherRepository weatherRepository;

    @Override
    public Users getOwnData(Long userId) {
        return userRepository.findById(userId).orElseThrow(()-> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }

    @Override
    public void withdrawal(Long userId) {
        Users users = userRepository.findById(userId).orElseThrow(()-> new UserHandler(ErrorStatus.MEMBER_NOT_FOUND));

        List<Schedules> schedules = scheduleRepository.getSchedulesByUser(users);
        for(Schedules schedule : schedules) {
            scheduleRepository.deleteById(schedule.getId());
        }
        List<Weather> weathers = weatherRepository.findAllByUsers(users);
        for(Weather weather : weathers) {
            weatherRepository.deleteById(weather.getId());
        }

        userRepository.deleteById(userId);
    }
}
