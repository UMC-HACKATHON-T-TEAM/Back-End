package UMC_Hackathon.DailyMate.web.controller;

import UMC_Hackathon.DailyMate.apiPayload.ApiResponse;
import UMC_Hackathon.DailyMate.service.HomeService.HomeQueryService;
import UMC_Hackathon.DailyMate.validation.annotation.ExistUsers;
import UMC_Hackathon.DailyMate.web.dto.HomeRequestDTO;
import UMC_Hackathon.DailyMate.web.dto.HomeResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeRestController {
    private final HomeQueryService homeQueryService;

    @GetMapping("/{userId}")
    @Operation(summary = "홈 화면 조회 API")
    public ApiResponse<HomeResponseDTO.GetHomeResponseDTO> getHome(@ExistUsers @PathVariable Long userId, @RequestBody HomeRequestDTO.Coord coord) {
        return ApiResponse.onSuccess(homeQueryService.getHome(userId, coord));
    }
}
