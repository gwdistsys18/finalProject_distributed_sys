package com.loveindc.preference.service.Impl;

import com.loveindc.preference.converter.DO2VO;
import com.loveindc.preference.dao.UserPreferenceDAO;
import com.loveindc.preference.entity.UserPreference;
import com.loveindc.preference.service.UserPreferenceService;
import com.loveindc.preference.vo.UserPreferenceVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPreferenceServiceImpl implements UserPreferenceService {
    @Autowired
    private UserPreferenceDAO userPreferenceDAO;

    @Override
    public UserPreferenceVO getById(int id) {
        return DO2VO.UserPreferenceDO2VO(userPreferenceDAO.getById(id));
    }

    @Override
    public UserPreferenceVO update(UserPreferenceVO userPreferenceVO) {
        System.out.println(userPreferenceVO);
        // update data
        UserPreference ret = userPreferenceDAO.getById(userPreferenceVO.getId());
        if (userPreferenceVO.getSports() != null) ret.setSports(userPreferenceVO.getSports());
        if (userPreferenceVO.getMusic() != null) ret.setMusic(userPreferenceVO.getMusic());
        if (userPreferenceVO.getTechnology() != null) ret.setTechnology(userPreferenceVO.getTechnology());
        if (userPreferenceVO.getPolitics() != null) ret.setPolitics(userPreferenceVO.getPolitics());
        if (userPreferenceVO.getArt() != null) ret.setArt(userPreferenceVO.getArt());
        if (userPreferenceVO.getLiterature() != null) ret.setLiterature(userPreferenceVO.getLiterature());
        if (userPreferenceVO.getGame() != null) ret.setGame(userPreferenceVO.getGame());
        if (userPreferenceVO.getMovie() != null) ret.setMovie(userPreferenceVO.getMovie());
        if (userPreferenceVO.getCooking() != null) ret.setCooking(userPreferenceVO.getCooking());
        if (userPreferenceVO.getFinance() != null) ret.setFinance(userPreferenceVO.getFinance());
        System.out.println(ret);
        // save into db
        userPreferenceDAO.update(ret);
        return DO2VO.UserPreferenceDO2VO(ret);
    }

    @Override
    public UserPreferenceVO create(int id) {
        UserPreference ret = new UserPreference();
        ret.setId(id);
        userPreferenceDAO.create(id);
        return DO2VO.UserPreferenceDO2VO(ret);
    }
}
