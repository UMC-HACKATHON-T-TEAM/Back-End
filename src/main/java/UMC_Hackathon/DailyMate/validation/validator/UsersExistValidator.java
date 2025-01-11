package UMC_Hackathon.DailyMate.validation.validator;

import UMC_Hackathon.DailyMate.apiPayload.code.status.ErrorStatus;
import UMC_Hackathon.DailyMate.domain.Users;
import UMC_Hackathon.DailyMate.repository.UserRepository;
import UMC_Hackathon.DailyMate.validation.annotation.ExistUsers;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsersExistValidator implements ConstraintValidator<ExistUsers, Long> {

    private final UserRepository userRepository;

    @Override
    public void initialize(ExistUsers constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = userRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.MEMBER_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
