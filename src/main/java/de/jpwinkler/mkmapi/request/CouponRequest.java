package de.jpwinkler.mkmapi.request;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "request")
public class CouponRequest {

    private List<String> couponCode;

    public CouponRequest() {}

    public CouponRequest(List<String> coupons) {
        this.couponCode = coupons;
    }

    public List<String> getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(List<String> couponCode) {
        this.couponCode = couponCode;
    }
}
