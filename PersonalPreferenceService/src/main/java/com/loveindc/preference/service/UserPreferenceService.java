package com.loveindc.preference.service;

import com.loveindc.preference.vo.UserPreferenceVO;
import org.springframework.stereotype.Service;

@Service
public interface UserPreferenceService {
    UserPreferenceVO getById(int id);
    UserPreferenceVO update(UserPreferenceVO userPreference);
    UserPreferenceVO create(int id);
}
