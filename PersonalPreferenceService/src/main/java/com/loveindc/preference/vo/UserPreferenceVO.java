package com.loveindc.preference.vo;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserPreferenceVO {
    @NotNull
    private Integer id;

    private Boolean sports;
    private Boolean music;
    private Boolean technology;
    private Boolean politics;
    private Boolean art;
    private Boolean literature;
    private Boolean game;
    private Boolean movie;
    private Boolean cooking;
    private Boolean finance;
}
