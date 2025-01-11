package UMC_Hackathon.DailyMate.web.controller;

import UMC_Hackathon.DailyMate.apiPayload.ApiResponse;
import UMC_Hackathon.DailyMate.converter.ScheduleConverter;
import UMC_Hackathon.DailyMate.domain.Schedules;
import UMC_Hackathon.DailyMate.service.ScheduleService.ScheduleCommandService;
import UMC_Hackathon.DailyMate.service.ScheduleService.ScheduleQueryService;
import UMC_Hackathon.DailyMate.validation.annotation.CheckPage;
import UMC_Hackathon.DailyMate.validation.annotation.ExistUsers;
import UMC_Hackathon.DailyMate.web.dto.ScheduleRequestDTO;
import UMC_Hackathon.DailyMate.web.dto.ScheduleResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleRestController {

    private final ScheduleCommandService scheduleCommandService;
    private final ScheduleQueryService scheduleQueryService;

    @PostMapping("/")
    @Operation(summary = "일정 추가 API")
    public ApiResponse<ScheduleResponseDTO.ScheduleResultDto> createSchedule(@RequestBody @Valid ScheduleRequestDTO.ScheduleDto request,
                                                                             @ExistUsers @RequestParam(name = "userId") Long userId) {
        Schedules schedules = scheduleCommandService.createSchedule(request, userId);
        return ApiResponse.onSuccess(ScheduleConverter.toScheduleResultDTO(schedules));
    }

    @GetMapping("/{scheduleId}")
    @Operation(summary = "일정 조회 API")
    public ApiResponse<ScheduleResponseDTO.SchedulePreViewListDto> getScheduleList(@ExistUsers @RequestParam(name = "userId") Long userId,
                                                                               @CheckPage @RequestParam(name = "page", defaultValue = "1") Integer page) {
        Page<Schedules> myScheduleList = scheduleQueryService.getScheduleList(userId, page - 1);
        return ApiResponse.onSuccess(ScheduleConverter.toSchedulePreViewListDTO(myScheduleList));
    }

    @DeleteMapping("/{scheduleId}")
    @Operation(summary = "일정 삭제 API")
    public ApiResponse<Void> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleCommandService.deleteSchedule(scheduleId);
        return new ApiResponse<>(true, null, "일정이 성공적으로 삭제되었습니다.", null);
    }
}
