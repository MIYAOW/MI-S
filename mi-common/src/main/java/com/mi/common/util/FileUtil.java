package com.mi.common.util;

import java.io.File;

/**
 * 处理文件工具类
 * @author yesh
 *         (M.M)!
 *         Created by 2017/6/27.
 */
public class FileUtil {

    /**
     * 返回所属操作系统路径  op filename
     * @param strs
     * @return
     * separator filename
     * win\ liux/
     */
    public static String getOpPath(String... strs){
        String[] array = strs;
        StringBuilder sb = new StringBuilder();
        for (String s : array){
            sb.append(File.separator+s);
        }
        return sb.toString();
    }
}
