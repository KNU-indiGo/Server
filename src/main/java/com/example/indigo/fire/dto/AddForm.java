package com.example.indigo.fire.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class AddForm {

    @NotNull
    private String building_name;

    @NotNull
    private String address;

    @NotNull
    private String latitude;

    @NotNull
    private String longitude;

    @NotNull
    private String cam_url;

    public AddForm(String building_name, String address, String latitude, String longitude, String cam_url){

        this.building_name = building_name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.cam_url = cam_url;
    }
}
