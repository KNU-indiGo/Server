package com.example.indigo.fire.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FireStatus {

    SAFE("평소상태"), BREAKOUT("화재발생"), CONTAIN("진압중"), PUTOUT("진압완료");

    private final String description;
}
