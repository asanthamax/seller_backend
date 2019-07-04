package converter;

import com.spring.demo.entity.ResetPassword;
import com.spring.demo.model.response.ResetPasswordResponse;
import org.springframework.core.convert.converter.Converter;

public class ResetPasswordEntityToResetPasswordResponse implements Converter<ResetPassword, ResetPasswordResponse> {


    @Override
    public ResetPasswordResponse convert(ResetPassword resetPassword) {

        ResetPasswordResponse resetPasswordResponse = new ResetPasswordResponse();
        resetPasswordResponse.setId(resetPassword.getId());
        resetPasswordResponse.setToken(resetPassword.getToken());
        resetPasswordResponse.setUserId(resetPassword.getUser().getId());
        return resetPasswordResponse;
    }
}
