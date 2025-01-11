package UMC_Hackathon.DailyMate.web.controller;

import UMC_Hackathon.DailyMate.apiPayload.ApiResponse;
import UMC_Hackathon.DailyMate.service.FortuneService.RecommendCommandService;
import UMC_Hackathon.DailyMate.web.dto.RecommendRequestDTO;
import UMC_Hackathon.DailyMate.web.dto.RecommendResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fortunes")
public class RecommendController {
    private final RecommendCommandService recommendCommandService;

    @Operation(summary = "자세한 운세 생성 및 옷차림 추천 api", description =
            "# 자세한 운세를 생성하고 저장하며 회원정보와 운세, 그리고 날씨 정보에 따른 옷차림을 ChatGpt로 추천해줍니다."
    )
    @PostMapping("/")
    public ApiResponse<RecommendResponseDTO.RecommendResultDTO> CreandRecommendAndPostFortune(
            @RequestBody RecommendRequestDTO.CreateRecommendAndPostFortuneRequestDTO request
            ) {
        RecommendResponseDTO.RecommendResultDTO recommendResultDTO = recommendCommandService.CreandRecommendAndPostFortune(request);
        return ApiResponse.onSuccess(
                recommendResultDTO
        );
    }
}
