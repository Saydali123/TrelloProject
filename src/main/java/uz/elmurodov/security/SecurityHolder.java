package uz.elmurodov.security;

import lombok.Setter;
import uz.elmurodov.security.auth.Session;

@Setter
public class SecurityHolder {
    public static Session authUserSession;

    public static void setSessionUser(Session authUser) {
        authUserSession = authUser;
    }

    public static void killSession() {
        authUserSession = null;
    }

}
