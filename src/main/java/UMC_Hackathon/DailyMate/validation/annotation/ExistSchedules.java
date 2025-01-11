package UMC_Hackathon.DailyMate.validation.annotation;

import UMC_Hackathon.DailyMate.validation.validator.SchedulesExistValidator;;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SchedulesExistValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExistSchedules {
    String message() default "해당 일정이 존재하지 않습니다.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
