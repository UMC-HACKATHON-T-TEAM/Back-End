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

@RestController
@RequiredArgsConstructor
@RequestMapping("/home")
public class HomeRestController {
    private final HomeQueryService homeQueryService;

    @GetMapping("/{userId}")
    @Operation(summary = "홈 화면 조회 API")
    public ApiResponse<HomeResponseDTO.GetHomeResponseDTO> getHome(@PathVariable Long userId, @RequestParam double lat, @RequestParam double lon) {
        System.out.println("in Method");
        return ApiResponse.onSuccess(homeQueryService.getHome(userId, lat, lon));
    }
}
