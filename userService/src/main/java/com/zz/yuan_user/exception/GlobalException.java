package com.zz.yuan_user.exception;


import com.zz.yuan_user.result.CodeMsg;

public class GlobalException extends RuntimeException {

    CodeMsg cm;

    public GlobalException(CodeMsg cm){
        super(cm.toString());
        this.cm = cm;
    }

    public CodeMsg getCm() {
        return cm;
    }
}
