package UMC_Hackathon.DailyMate.converter;

import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.web.dto.ScheduleRequestDTO;
import UMC_Hackathon.DailyMate.web.dto.ScheduleResponseDTO;
import org.springframework.data.domain.Page;

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
        return Schedules.builder()
                .users(users)
                .date(request.getDate())
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
                .date(schedules.getDate())
                .title(schedules.getTitle())
                .content(schedules.getContent())
                .createdAt(schedules.getCreatedAt().toLocalDate())
                .build();
    }

    public static ScheduleResponseDTO.SchedulePreViewListDto toSchedulePreViewListDTO (Page<Schedules> schedulesList){

        List<ScheduleResponseDTO.SchedulePreViewDto> schedulePreViewDTOList = schedulesList.stream()
                .map(ScheduleConverter::toSchedulePreViewDTO).collect(Collectors.toList());

        return ScheduleResponseDTO.SchedulePreViewListDto.builder()
                .isLast(schedulesList.isLast())
                .isFirst(schedulesList.isFirst())
                .totalPage(schedulesList.getTotalPages())
                .totalElements(schedulesList.getTotalElements())
                .listSize(schedulePreViewDTOList.size())
                .scheduleList(schedulePreViewDTOList)
                .build();
    }
}
