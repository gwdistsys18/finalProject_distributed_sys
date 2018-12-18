package com.loveinDC.personalInfoMicroService.VO;

public class ResultVO<T> {
	/** Error Code */
    private Integer code;

    /** Errof Info */
    private String msg;

    /** Data */
    private T data;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
    
    
}
