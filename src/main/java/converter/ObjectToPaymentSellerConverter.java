package converter;

import com.spring.demo.entity.PaymentSeller;
import org.springframework.core.convert.converter.Converter;


public class ObjectToPaymentSellerConverter implements Converter<Object[], PaymentSeller>{

    @Override
    public PaymentSeller convert(Object[] objects) {


        PaymentSeller payment = new PaymentSeller();
        payment.setUserID(Long.parseLong(objects[2].toString()));
        payment.setAmount(Double.parseDouble(objects[0].toString()));
        payment.setNumOrders(Long.parseLong(objects[1].toString()));
        return payment;
    }
}
