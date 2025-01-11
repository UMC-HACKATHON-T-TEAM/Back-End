package UMC_Hackathon.DailyMate.validation.validator;

import UMC_Hackathon.DailyMate.apiPayload.code.status.ErrorStatus;
import UMC_Hackathon.DailyMate.repository.ScheduleRepository;
import UMC_Hackathon.DailyMate.repository.UserRepository;
import UMC_Hackathon.DailyMate.validation.annotation.ExistSchedules;
import UMC_Hackathon.DailyMate.validation.annotation.ExistUsers;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SchedulesExistValidator implements ConstraintValidator<ExistSchedules, Long> {

    private final ScheduleRepository scheduleRepository;

    @Override
    public void initialize(ExistSchedules constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        boolean isValid = scheduleRepository.existsById(value);

        if (!isValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(ErrorStatus.SCHEDULE_NOT_FOUND.toString()).addConstraintViolation();
        }

        return isValid;
    }
}
