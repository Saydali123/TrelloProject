package uz.elmurodov.exception;


import lombok.Getter;
import lombok.Setter;
import uz.elmurodov.enums.HttpStatus;

@Getter
@Setter
public class CustomSQLException extends BaseException {

    private String friendlyMessage;

    public CustomSQLException(String message, HttpStatus status) {
        super(message, status);
        this.friendlyMessage = message;
        initMessage();
    }

    public CustomSQLException(String message, Throwable cause) {
        super(message, cause);
    }

    private void initMessage() {
//        this.friendlyMessage = null;
//        String message = super.getMessage();
//        String systemMessage = message.trim();
//        try {
//            friendlyMessage = systemMessage.substring(systemMessage.lastIndexOf("ERROR: ") + 7, systemMessage.indexOf("Where")).trim();
//            if (friendlyMessage.isEmpty()) {
//                friendlyMessage = systemMessage.substring(systemMessage.lastIndexOf("detail: ") + 8, systemMessage.indexOf("hint: ")).trim();
//            }
//            if (friendlyMessage.isEmpty()) {
//                friendlyMessage = systemMessage.substring(systemMessage.lastIndexOf("hint: ") + 6).trim();
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
        if (friendlyMessage.contains("ERROR_CODE_INTERNAL"))
            super.setStatus(HttpStatus.HTTP_500);
        else if (friendlyMessage.contains("ERROR_CODE_BAD_REQUEST"))
            super.setStatus(HttpStatus.HTTP_400);
        else
            super.setStatus(HttpStatus.UNDEFINED);
    }

}
