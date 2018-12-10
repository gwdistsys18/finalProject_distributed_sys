package com.loveindc.preference.vo;

import lombok.Data;

@Data
public class ResultVO<T> {
    /** Error Code */
    private Integer code;

    /** Errof Info */
    private String msg;

    /** Data */
    private T data;
}
