package converter;

import com.spring.demo.entity.ReservationEntity;
import com.spring.demo.model.response.ReserveResponse;
import org.springframework.core.convert.converter.Converter;

public class ReservationEntityToReserveResponseConverter implements Converter<ReservationEntity, ReserveResponse> {


    @Override
    public ReserveResponse convert(ReservationEntity entity) {

        ReserveResponse response = new ReserveResponse();
        response.setCheckin(entity.getCheckin());
        response.setCheckout(entity.getCheckout());
        response.setId(entity.getId());
        return response;
    }
}
