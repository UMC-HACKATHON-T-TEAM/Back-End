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
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserRestController {

    private final UserCommandService userCommandService;

    @PostMapping("/")
    @Operation(summary = "사용자 회원가입 API", description = "사용자 입력값으로 회원가입하는 API입니다.")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDto request){
        Users users = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(users));
    }

    @PostMapping("/login")
    @Operation(summary = "사용자 로그인 API", description = "이메일과 비밀번호로 로그인하는 API입니다.")
    public ApiResponse<Users> login(@RequestParam String email, @RequestParam String password) {
        // 사용자 인증
        Users authenticatedUser = userCommandService.authenticateUser(email, password);

        return new ApiResponse<>(true, "200", "로그인 성공", authenticatedUser);
    }
}