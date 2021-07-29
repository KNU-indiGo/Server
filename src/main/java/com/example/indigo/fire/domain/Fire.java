package com.example.indigo.fire.domain;

import com.example.indigo.fire.BaseTimeEntity;
import com.example.indigo.fire.dto.AddForm;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Fire extends BaseTimeEntity {

    // Primary Key of Fire
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 3 Statuses of Fire(Break out, Contain, Put out)
    @Enumerated(EnumType.STRING)
    private FireStatus status;

    private String building_name;

    private String address;

    private String latitude;

    private String longitude;

    private LocalDateTime breakOutTime;

    private LocalDateTime containTime;

    private LocalDateTime putOutTime;

    private String cam_url;

    public Fire(AddForm form) {

        // default status is SAFE
        this.status = FireStatus.SAFE;

        // get from form
        this.building_name = form.getBuilding_name();
        this.address = form.getAddress();
        this.latitude = form.getLatitude();
        this.longitude = form.getLongitude();
        this.cam_url = form.getCam_url();
    }

    public void setBreakOut() {
        this.status = FireStatus.BREAKOUT;
        this.breakOutTime = LocalDateTime.now();
    }

    public void setContain() {
        this.status = FireStatus.CONTAIN;
        this.containTime = LocalDateTime.now();
    }

    public void setPutOut() {
        this.status = FireStatus.PUTOUT;
        this.putOutTime = LocalDateTime.now();
    }

    public boolean isContain() {
        return this.status == FireStatus.CONTAIN;
    }

    public boolean isPutOut() {
        return this.status == FireStatus.PUTOUT;
    }
}
