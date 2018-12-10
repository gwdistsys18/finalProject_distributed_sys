package com.loveindc.preference.converter;

import com.loveindc.preference.entity.UserPreference;
import com.loveindc.preference.vo.UserPreferenceVO;

public class DO2VO {
    public static UserPreferenceVO UserPreferenceDO2VO(UserPreference userPreference) {
        UserPreferenceVO userPreferenceVO = new UserPreferenceVO();
        userPreferenceVO.setArt(userPreference.getArt());
        userPreferenceVO.setCooking(userPreference.getCooking());
        userPreferenceVO.setFinance(userPreference.getFinance());
        userPreferenceVO.setGame(userPreference.getGame());
        userPreferenceVO.setMovie(userPreference.getMovie());
        userPreferenceVO.setLiterature(userPreference.getLiterature());
        userPreferenceVO.setPolitics(userPreference.getPolitics());
        userPreferenceVO.setTechnology(userPreference.getTechnology());
        userPreferenceVO.setMusic(userPreference.getMusic());
        userPreferenceVO.setSports(userPreference.getSports());
        userPreferenceVO.setId(userPreference.getId());
        return userPreferenceVO;
    }
}
