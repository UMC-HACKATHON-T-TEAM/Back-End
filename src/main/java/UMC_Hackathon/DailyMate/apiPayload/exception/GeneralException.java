package UMC_Hackathon.DailyMate.apiPayload.exception;
import lombok.AllArgsConstructor;
import lombok.Getter;
import UMC_Hackathon.DailyMate.apiPayload.code.BaseErrorCode;
import UMC_Hackathon.DailyMate.apiPayload.code.ErrorReasonDTO;
@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {
    private BaseErrorCode code;
    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }
    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}