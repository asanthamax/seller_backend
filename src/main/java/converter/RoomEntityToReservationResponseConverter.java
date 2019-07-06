package converter;

import com.spring.demo.entity.RoomEntity;
import com.spring.demo.model.response.Link;
import com.spring.demo.model.response.ReservationResponse;
import com.spring.demo.model.response.Self;
import com.spring.demo.rest.ResourceConstants;
import org.springframework.core.convert.converter.Converter;

public class RoomEntityToReservationResponseConverter implements Converter<RoomEntity, ReservationResponse> {


    @Override
    public ReservationResponse convert(RoomEntity roomEntity) {

        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setRoomNumber(roomEntity.getRoomNumber());
        reservationResponse.setPrice(Integer.valueOf(roomEntity.getPrice()));
        reservationResponse.setId(roomEntity.getId());
        reservationResponse.setReservations(roomEntity.getReservationEntities());

        Link link = new Link();
        Self self = new Self();
        self.setRef(ResourceConstants.USER_V1 +"/"+roomEntity.getId());
        link.setSelf(self);
        reservationResponse.setLinks(link);
        return reservationResponse;
    }
}
