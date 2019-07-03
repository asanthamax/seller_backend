package converter;

import com.spring.demo.entity.ResetPassword;
import com.spring.demo.model.request.ResetPasswordRequest;
import org.springframework.core.convert.converter.Converter;

public class ResetPasswordRequestToResetPasswordResponseConverter implements Converter<ResetPasswordRequest, ResetPassword> {

    @Override
    public ResetPassword convert(ResetPasswordRequest resetPasswordRequest) {

        ResetPassword resetEntity = new ResetPassword();
        return null;
    }
}
