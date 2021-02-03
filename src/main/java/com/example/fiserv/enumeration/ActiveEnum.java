package com.example.fiserv.enumeration;

import lombok.Getter;

@Getter
public enum ActiveEnum {
    ACTIVE(true),
    INACTIVE(false);

    private boolean status;

    ActiveEnum(boolean status) {
        this.status = status;
    }
}
