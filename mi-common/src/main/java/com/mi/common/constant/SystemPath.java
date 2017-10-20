package com.mi.common.constant;

/**
 * 系统路径-常量
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017/10/20.
 */
public class SystemPath {

    /**
     * 控制台打印显示
     */
    public static void main(String[] args) {
//        System.out.println(getSysPath());
//        System.out.println(System.getProperty("java.io.tmpdir"));
//        System.out.println(getSeparator());
//        System.out.println(getClassPath());
    }


    /**
     * 得到当前应用的系统路径
     */
    public static String getSysPath() {
        //从classpath根开始查找
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("").toString();
        String temp = path.replaceFirst("file:/", "").replaceFirst(
                "WEB-INF/classes/", "");
        //文件分隔符（在 UNIX 系统中是“/”）
        String separator = System.getProperty("file.separator");
        String resultPath = temp.replaceAll("/", separator + separator);
        return resultPath;
    }

    /**
     * 得到当前应用生成class文件的系统路径
     */
    public static String getClassPath() {
        String path = Thread.currentThread().getContextClassLoader()
                .getResource("").toString();
        String temp = path.replaceFirst("file:/", "");
        String separator = System.getProperty("file.separator");
        String resultPath = temp.replaceAll("/", separator + separator);
        return resultPath;
    }

    /**
     * 默认的临时文件路径
     */
    public static String getSystempPath() {
        return System.getProperty("java.io.tmpdir");
    }


    /**
     * 用户的账户名称
     */
    public static String getUserName() {
        return System.getProperty("user.name");
    }

    /**
     * 用户主目录
     */
    public static String getUserHome() {
        return System.getProperty("user.home");
    }

    /**
     * 用户当前工作目录
     */
    public static String getUserDir() {
        return System.getProperty("user.dir");
    }

    /**
     * 文件分隔符（在 UNIX 系统中是“/”）
     */
    public static String getFileSeparator() {
        return System.getProperty("file.separator");
    }

    /**
     * 路径分隔符（在 UNIX 系统中是“:”）
     */
    public static String getPathSeparator() {
        return System.getProperty("path.separator");
    }

    /**
     * 行分隔符（在 UNIX 系统中是“/n”）
     */
    public static String getLineSeparator() {
        return System.getProperty("line.separator");
    }
}
