package com.loveindc.preference.utils;

import com.loveindc.preference.enums.ResultEnum;
import com.loveindc.preference.vo.ResultVO;

public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(ResultEnum.SUCCESS.getCode());
        resultVO.setMsg(ResultEnum.SUCCESS.getMessage());
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(ResultEnum ret) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(ret.getCode());
        resultVO.setMsg(ret.getMessage());
        return resultVO;
    }

    public static ResultVO error(Integer code, String message) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(message);
        return resultVO;
    }
}
