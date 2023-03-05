package cn.charlie.common.dubbo.api.base;

/**
 * @author charlie
 * @date 3/5/2023 8:18 PM
 **/
public interface BaseClient {
    /**
     * 基础回应方法: 用于返回输入内容
     *
     * @param str 输入内容
     * @return 回应
     */
    String echo(String str);
}
