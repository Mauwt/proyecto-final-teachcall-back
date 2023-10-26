package dbp.techcall.auth.useCase;

import dbp.techcall.auth.dto.JwtRes;
import dbp.techcall.auth.dto.LoginReq;
import dbp.techcall.auth.dto.RegisterReq;

public interface IAuthUseCase {
    JwtRes register(RegisterReq request);

    //JwtRes loginProfessor(LoginReq request);

    //JwtRes registerStudent(RegisterReq request);

    JwtRes login(LoginReq request);
}
