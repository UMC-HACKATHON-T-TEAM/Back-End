package UMC_Hackathon.DailyMate.apiPayload.exception.handler;

import UMC_Hackathon.DailyMate.apiPayload.code.BaseErrorCode;
import UMC_Hackathon.DailyMate.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
