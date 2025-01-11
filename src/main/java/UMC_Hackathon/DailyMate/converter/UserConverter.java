package UMC_Hackathon.DailyMate.converter;

import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.web.dto.UserRequestDTO;
import UMC_Hackathon.DailyMate.web.dto.UserResponseDTO;

import java.sql.Date;
import java.time.LocalDateTime;

public class UserConverter {
    public static UserResponseDTO.JoinResultDTO toJoinResultDTO(Users users){
        return UserResponseDTO.JoinResultDTO.builder()
                .userId(users.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Users toUser(UserRequestDTO.JoinDto request){

        return Users.builder()
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .gender(request.getGender())
                .birthday(request.getBirthday())
                .build();
    }

    public static UserResponseDTO.OwnPageDTO toOwnPageDTO(Users users){
        return UserResponseDTO.OwnPageDTO.builder()
                .name(users.getName())
                .birthday(users.getBirthday().toString())
                .build();
    }

    public static UserResponseDTO.userIdDTO toUserIdDTO(Users users){
        return UserResponseDTO.userIdDTO.builder()
                .userId(users.getId()).build();
    }
}
