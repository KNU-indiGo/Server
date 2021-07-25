package com.example.indigo.fire.domain;

import com.example.indigo.fire.BaseTimeEntity;
import com.example.indigo.fire.dto.AddForm;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Access(AccessType.FIELD)
public class Fire extends BaseTimeEntity {

    // Primary Key of Fire
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 3 Statuses of Fire(Break out, Contain, Put out)
    @Enumerated(EnumType.STRING)
    @Column(length = 8)
    private FireStatus status;

    private String building_name;

    private String address;

    private String latitude;

    private String longitude;

    private String cam_url;

    private Integer people_num;

    public Fire(AddForm form){

        // default status is SAFE
        this.status = FireStatus.SAFE;

        // get from form
        this.building_name = form.getBuilding_name();
        this.address = form.getAddress();
        this.latitude = form.getLatitude();
        this.longitude = form.getLongitude();
        this.cam_url = form.getCam_url();

        //default people number is zero
        this.people_num = 0;
    }

    public void setStatus(FireStatus status) {
        this.status = status;
    }

    public boolean isContain(){
        return this.status == FireStatus.CONTAIN;
    }

    public boolean isPutOut(){
        return this.status == FireStatus.PUTOUT;
    }
}
