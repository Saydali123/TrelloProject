package uz.elmurodov.ui;

import uz.elmurodov.security.auth.PermissionsItem;
import uz.elmurodov.utils.Color;
import uz.elmurodov.utils.Print;

import java.util.Objects;

import static uz.elmurodov.security.SecurityHolder.authUserSession;

public class Menu {

    public static void getMainMenu() {
        if (Objects.isNull(authUserSession)) Print.println(Color.GREEN, "Login -> LOGIN");
        else {
            for (PermissionsItem permission : authUserSession.getPermissions()) {
                System.out.printf("%s%s%s\n", permission.getName(), " -> ", permission.getCode());
            }

        }
        Print.println(Color.GREEN, "Exit -> EXIT");
    }

}
