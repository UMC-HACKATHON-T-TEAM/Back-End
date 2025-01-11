package UMC_Hackathon.DailyMate.web.controller;

import UMC_Hackathon.DailyMate.apiPayload.ApiResponse;
import UMC_Hackathon.DailyMate.converter.RecommendConverter;
import UMC_Hackathon.DailyMate.converter.ScheduleConverter;
import UMC_Hackathon.DailyMate.domain.Fortune;
import UMC_Hackathon.DailyMate.service.RecommendService.RecommendCommandService;
import UMC_Hackathon.DailyMate.web.dto.RecommendRequestDTO;
import UMC_Hackathon.DailyMate.web.dto.RecommendResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fortunes")
public class RecommendController {
    private final RecommendCommandService recommendCommandService;

    @Operation(summary = "옷차림 추천 api", description =
            "# 회원정보와 운세, 일정 그리고 날씨 정보에 따른 옷차림을 ChatGpt로 추천해줍니다."
    )
    @PostMapping("/recommend")
    public ApiResponse<RecommendResponseDTO.RecommendResultDTO> CreandRecommendAndPostFortune(
            @RequestBody RecommendRequestDTO.CreateRecommendAndPostFortuneRequestDTO request
            ) {
        RecommendResponseDTO.RecommendResultDTO recommendResultDTO = recommendCommandService.CreateRecommendAndPostFortune(request);
        return ApiResponse.onSuccess(
                recommendResultDTO
        );
    }

    @GetMapping("/")
    @Operation(summary = "자세한 운세 조회 API", description = "자세한 운세를 조회하는 API입니다.")
    public ApiResponse<RecommendResponseDTO.FortuneResultDTO> getFortune(
            @RequestParam Long userId
            ) {
        Fortune fortune = recommendCommandService.GetFortune(userId);
        return ApiResponse.onSuccess(
                RecommendConverter.toFortuneResultDTO(fortune)
        );
    }
}
