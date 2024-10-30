package com.backendapiRest.models.entity;





import javax.persistence.*;
        import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "water")
public class Water implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String watername;

    private String watericon;
    private String waterstyle;
    private String watersize;
    private String waterprice;

    private String shopaccount;

    private String shopname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWatername() {
        return watername;
    }

    public void setWatername(String watername) {
        this.watername = watername;
    }

    public String getWatericon() {
        return watericon;
    }

    public void setWatericon(String watericon) {
        this.watericon = watericon;
    }

    public String getWaterstyle() {
        return waterstyle;
    }

    public void setWaterstyle(String waterstyle) {
        this.waterstyle = waterstyle;
    }

    public String getWatersize() {
        return watersize;
    }

    public void setWatersize(String watersize) {
        this.watersize = watersize;
    }

    public String getWaterprice() {
        return waterprice;
    }

    public void setWaterprice(String waterprice) {
        this.waterprice = waterprice;
    }

    public String getShopaccount() {
        return shopaccount;
    }

    public void setShopaccount(String shopaccount) {
        this.shopaccount = shopaccount;
    }

    public String getShopname() {
        return shopname;
    }

    public void setShopname(String shopname) {
        this.shopname = shopname;
    }
}