package uz.elmurodov.services.auth;

import uz.elmurodov.exception.ApiRuntimeException;
import uz.elmurodov.exception.CustomSQLException;
import uz.elmurodov.repository.auth.AuthUserRepository;
import uz.elmurodov.response.Data;
import uz.elmurodov.response.ResponseEntity;
import uz.elmurodov.security.SecurityHolder;
import uz.elmurodov.security.auth.Session;
import uz.elmurodov.services.AbstractService;

public class AuthUserService extends AbstractService<AuthUserRepository> {

    public AuthUserService(AuthUserRepository repository) {
        super(repository);
    }

    public ResponseEntity<Data<Boolean>> login(String username, String password) {
        try {
            Session sessionUser = repository.login(username, password);
            SecurityHolder.setSessionUser(sessionUser);
            return new ResponseEntity<>(new Data<>(true));
        } catch (CustomSQLException e) {
            throw new ApiRuntimeException(e.getFriendlyMessage(), e.getStatus());
        }
    }

    public ResponseEntity<Data<Void>> logout() {
        SecurityHolder.killSession();
        return new ResponseEntity<>(new Data<>(null));
    }
}
