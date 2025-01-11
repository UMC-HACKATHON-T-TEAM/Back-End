package UMC_Hackathon.DailyMate.apiPayload.exception.handler;

import UMC_Hackathon.DailyMate.apiPayload.code.BaseErrorCode;
import UMC_Hackathon.DailyMate.apiPayload.exception.GeneralException;

public class UserHandler extends GeneralException {
    public UserHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
