package com.spring.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "shippingmethod")
public class ShippingMethod {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "shippingCompany")
    private String shippingCompany;

    public ShippingMethod() {
    }

    public Long getId() {
        return id;
    }

    public ShippingMethod(String shippingCompany, String shippingCompanyLogo, String shippingCode, String shippingMethod, double shippingCharge) {
        this.shippingCompany = shippingCompany;
        this.shippingCompanyLogo = shippingCompanyLogo;
        this.shippingCode = shippingCode;
        this.shippingMethod = shippingMethod;
        this.shippingCharge = shippingCharge;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShippingCompany() {
        return shippingCompany;
    }

    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    public String getShippingCompanyLogo() {
        return shippingCompanyLogo;
    }

    public void setShippingCompanyLogo(String shippingCompanyLogo) {
        this.shippingCompanyLogo = shippingCompanyLogo;
    }

    public String getShippingCode() {
        return shippingCode;
    }

    public void setShippingCode(String shippingCode) {
        this.shippingCode = shippingCode;
    }

    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    public double getShippingCharge() {
        return shippingCharge;
    }

    public void setShippingCharge(double shippingCharge) {
        this.shippingCharge = shippingCharge;
    }

    @Column(name = "shippingCompanyLogo")
    private String shippingCompanyLogo;

    @Column(name = "shippingCode")
    private String 	shippingCode;

    @Column(name = "shippingMethod")
    private String shippingMethod;

    @Column(name = "shippingCharge")
    private double shippingCharge;
}
