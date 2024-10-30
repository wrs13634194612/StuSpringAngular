package com.backendapiRest.models.entity;


import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "repair")
public class Repair implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String devicename;

    private String devicestyle;
    private String deviceicon;
    private String repairdate;

    private String roomcode;

    private boolean applyresult;

    private int applystatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDevicename() {
        return devicename;
    }

    public void setDevicename(String devicename) {
        this.devicename = devicename;
    }

    public String getDevicestyle() {
        return devicestyle;
    }

    public void setDevicestyle(String devicestyle) {
        this.devicestyle = devicestyle;
    }

    public String getDeviceicon() {
        return deviceicon;
    }

    public void setDeviceicon(String deviceicon) {
        this.deviceicon = deviceicon;
    }

    public String getRepairdate() {
        return repairdate;
    }

    public void setRepairdate(String repairdate) {
        this.repairdate = repairdate;
    }

    public String getRoomcode() {
        return roomcode;
    }

    public void setRoomcode(String roomcode) {
        this.roomcode = roomcode;
    }

    public boolean isApplyresult() {
        return applyresult;
    }

    public void setApplyresult(boolean applyresult) {
        this.applyresult = applyresult;
    }

    public int getApplystatus() {
        return applystatus;
    }

    public void setApplystatus(int applystatus) {
        this.applystatus = applystatus;
    }
}