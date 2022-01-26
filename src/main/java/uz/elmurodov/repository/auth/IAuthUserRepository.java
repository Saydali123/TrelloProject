package uz.elmurodov.repository.auth;

import uz.elmurodov.security.auth.Session;

public interface IAuthUserRepository {
    Session login(String username, String password);

    Boolean leader(long projectId, long userId);
}
