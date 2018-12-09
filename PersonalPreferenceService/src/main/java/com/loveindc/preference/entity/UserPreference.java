package com.loveindc.preference.entity;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserPreference {
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
