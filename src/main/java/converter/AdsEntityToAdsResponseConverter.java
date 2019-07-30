package converter;

import com.spring.demo.entity.Ads;
import com.spring.demo.model.response.AdsResponse;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

public class AdsEntityToAdsResponseConverter implements Converter<Ads, AdsResponse>{

    @Override
    public AdsResponse convert(Ads ads) {

        AdsResponse response = new AdsResponse();
        response.setId(ads.getId());
        response.setAdImage(ads.getImgPath());
        if (ads.getStart_at() != null) {
            response.setPublishedDate(ads.getStart_at());
        } else {
            response.setPublishedDate(new Date());
        }
        response.setAdStatus(ads.getStatus());
        response.setAdSlot(ads.getAdSlotId().getId());
        response.setAddLocation(ads.getAdSlotId().getAddLocation());
        response.setCustomerEmail(ads.getUserId().getUser().getEmail());
        response.setCustomerName(ads.getUserId().getUser().getFirstName() + " " + ads.getUserId().getUser().getLastName());
        return response;
    }
}
