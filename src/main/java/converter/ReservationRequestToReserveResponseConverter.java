package converter;

import com.spring.demo.entity.ReservationEntity;
import com.spring.demo.model.request.ReservationRequest;
import org.springframework.core.convert.converter.Converter;

public class ReservationRequestToReserveResponseConverter implements Converter<ReservationRequest, ReservationEntity> {

    @Override
    public ReservationEntity convert(ReservationRequest reservationRequest) {

        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setCheckin(reservationRequest.getCheckin());
        reservationEntity.setCheckout(reservationRequest.getCheckout());
        if(reservationRequest.getId() != null){

            reservationEntity.setId(reservationRequest.getId());
        }
        return reservationEntity;
    }
}
