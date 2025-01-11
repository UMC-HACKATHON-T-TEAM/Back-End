package UMC_Hackathon.DailyMate.apiPayload.exception.handler;

import UMC_Hackathon.DailyMate.apiPayload.code.BaseErrorCode;
import UMC_Hackathon.DailyMate.apiPayload.exception.GeneralException;

public class ScheduleHandler extends GeneralException {
    public ScheduleHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
