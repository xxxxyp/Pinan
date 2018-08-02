package com.msa.core.emun;

/**
 * Created by xiongwei on 2018/4/24.
 */
public class ErrorCode {
    //认证部分代码
    public static String AUTH_SUCCESS = "0";//认证成功
    public static String UNAUTHENTICATE = "9999";//会话过期或未登录
    public static String INCORRECT_CREDENTIALS = "-1001";//用户或密码不正确
    public static String NO_PERMISSIONS = "-1002";//无权限访问
    public static String UN_EXCEPTION = "-9999";//未知异常

    //业务部分代码
    public static String BIZ_SUCCESS = "0";//业务调用成功
    public static String BIZ_FAIL = "1";//业务调用失败
}
