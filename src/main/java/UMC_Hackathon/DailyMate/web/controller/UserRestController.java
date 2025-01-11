package UMC_Hackathon.DailyMate.web.controller;

import UMC_Hackathon.DailyMate.apiPayload.ApiResponse;
import UMC_Hackathon.DailyMate.converter.UserConverter;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.service.UserService.UserCommandService;
import UMC_Hackathon.DailyMate.web.dto.UserRequestDTO;
import UMC_Hackathon.DailyMate.web.dto.UserResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {

    private final UserCommandService userCommandService;

    @PostMapping("/")
    @Operation(summary = "사용자 회원가입 API")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request){
        Users users = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(users));
    }

}