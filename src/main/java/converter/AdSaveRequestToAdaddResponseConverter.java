package converter;

import com.spring.demo.model.request.AdSaveRequest;
import com.spring.demo.model.response.AdaddResponse;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class AdSaveRequestToAdaddResponseConverter implements Converter<AdSaveRequest, AdaddResponse> {


    @Override
    public AdaddResponse convert(AdSaveRequest adSaveRequest) {

        AdaddResponse adResponse = new AdaddResponse();
        adResponse.setAdId(adSaveRequest.getAdId());
        adResponse.setApproveRejectDatetime(new Date());
        adResponse.setMessage("Ad Saved Successfully");
        return adResponse;
    }
}
