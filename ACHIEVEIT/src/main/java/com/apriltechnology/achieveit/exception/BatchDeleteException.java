package com.apriltechnology.achieveit.exception;

/**
 * @Description 批量删除自定义异常
 * @Author fjm
 * @Date 2020/3/18
 */
public class BatchDeleteException extends Exception{

    public BatchDeleteException(){
        super();
    }
    public BatchDeleteException(String message){
        super(message);
    }

    public BatchDeleteException(String message, Throwable cause){
        super(message,cause);
    }

    public BatchDeleteException(Throwable cause) {
        super(cause);
    }

}
