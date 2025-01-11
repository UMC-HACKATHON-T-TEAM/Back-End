package UMC_Hackathon.DailyMate.converter;

import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.web.dto.ScheduleRequestDTO;
import UMC_Hackathon.DailyMate.web.dto.ScheduleResponseDTO;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleConverter {
    public static ScheduleResponseDTO.ScheduleResultDto toScheduleResultDTO (Schedules schedules){
        return ScheduleResponseDTO.ScheduleResultDto.builder()
                .scheduleId(schedules.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Schedules toScheduleDTO (ScheduleRequestDTO.ScheduleDto request, Users users){
        String[] split = request.getDate().split("-");
        LocalDate requestDate = LocalDate.of(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2]));

        return Schedules.builder()
                .users(users)
                .date(requestDate)
                .title(request.getTitle())
                .content(request.getContent())
                .build();
    }

    public static Schedules toScheduleUpdateResultDTO (ScheduleRequestDTO.ScheduleUpdateRequestDto request, Users users, Schedules schedules) {
        // 기존 Schedules 객체의 데이터를 업데이트
        schedules.update(request.getTitle(), request.getContent());

        // Users 객체를 재설정하는 경우
        if (users != null && !schedules.getUsers().equals(users)) {
            schedules.setUsers(users);
        }

        return schedules;

    }
    public static ScheduleResponseDTO.SchedulePreViewDto toSchedulePreViewDTO (Schedules schedules){
        return ScheduleResponseDTO.SchedulePreViewDto.builder()
                .scheduleId(schedules.getId()) // scheduleId 추가
                .date(schedules.getDate())
                .title(schedules.getTitle())
                .content(schedules.getContent())
                .createdAt(schedules.getCreatedAt().toLocalDate())
                .build();
    }

    public static List<ScheduleResponseDTO.SchedulePreViewDto> toSchedulePreViewListDTO(List<Schedules> schedulesList) {
        return schedulesList.stream()
                .map(ScheduleConverter::toSchedulePreViewDTO)
                .collect(Collectors.toList());
    }
}
