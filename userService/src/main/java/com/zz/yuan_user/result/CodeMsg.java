package com.zz.yuan_user.result;

/**
 * 返回的code message
 */
public class CodeMsg {
	
	private int code;
	private String msg;
	
	//通用的错误码
	public static CodeMsg SUCCESS = new CodeMsg(0, "success");
	public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "Server error");
	public static CodeMsg BIND_ERROR = new CodeMsg(500101, "arguments error：%s");
	public static CodeMsg REQUEST_ILLEGAL = new CodeMsg(500102, "illegal request");
	public static CodeMsg ACCESS_LIMIT_REACHED= new CodeMsg(500104, "访问太频繁！");
	//登录模块 5002XX
	public static CodeMsg SESSION_ERROR = new CodeMsg(500210, "Session expired");
	public static CodeMsg PASSWORD_EMPTY = new CodeMsg(500211, "login password empty");
	public static CodeMsg USERNAME_EMPTY = new CodeMsg(500212, "username empty");
	public static CodeMsg USERNAME_ERROR = new CodeMsg(500213, "username should be an email address");
	public static CodeMsg USERNAME_NOT_EXIST = new CodeMsg(500214, "username not registered");
	public static CodeMsg PASSWORD_ERROR = new CodeMsg(500215, "password wrong");
	//注册模块
	public static CodeMsg DUPLICATE_USERNAME = new CodeMsg(500210, "username already used");

	private CodeMsg( ) {
	}
			
	private CodeMsg( int code,String msg ) {
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public CodeMsg fillArgs(Object... args) {
		int code = this.code;
		String message = String.format(this.msg, args);
		return new CodeMsg(code, message);
	}

	@Override
	public String toString() {
		return "CodeMsg [code=" + code + ", msg=" + msg + "]";
	}
	
	
}
