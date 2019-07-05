package converter;

import com.spring.demo.entity.Ads;
import com.spring.demo.model.response.AdsResponse;
import org.springframework.core.convert.converter.Converter;

public class AdsEntityToAdsResponseConverter implements Converter<Ads, AdsResponse> {

    @Override
    public AdsResponse convert(Ads ads) {

        AdsResponse response = new AdsResponse();
        response.setId(ads.getId());
        response.setAdImage(ads.getImgPath());
        response.setPublishedDate(ads.getStart_at());
        response.setAdStatus(ads.getStatus());
        return response;
    }
}
