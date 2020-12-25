package com.springboot.cloud.common.core.exception;

/**
 * @description:
 * @author: dongxiazi
 * @create: 2020/12/23 10:26
 */
public interface ErrorType {
    /**
     * 返回code
     * @return
     */
    String getCode();

    /**
     * 返回mesg
     * @return
     */

    String getMesg();
}
