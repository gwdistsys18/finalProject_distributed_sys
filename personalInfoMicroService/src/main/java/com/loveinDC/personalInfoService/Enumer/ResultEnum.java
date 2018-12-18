package com.loveinDC.personalInfoService.Enumer;

public enum ResultEnum {
	SUCCESS(0, "success"),
    USERNAME_NOT_EXIST(40100, "User not exist"),
    PASSWORD_ERROR(40101, "Password Error"),
    USER_NOT_LOGIN(40402, "User need to login"),
    DUPLICATE_ERROR(500210, "User name already exist"),
    SERVER_ERROR(501, "Server exception");

    private Integer code;
    private String message;

    public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
