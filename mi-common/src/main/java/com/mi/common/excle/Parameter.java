//package com.mi.common.excle;
//
///**
// * 定值参数部分
// * @author yesh
// *         (M.M)!
// *         Created by 2017/5/21.
// */
//public class Parameter extends Constant{
//    /**
//     * Excel文件路径
//     */
//    protected String excelPath = "data.xlsx";
//
//    /**
//     * 设定开始读取的位置，默认为0
//     */
//    protected int startReadPos = READ_START_POS;
//
//    /**
//     * 设定结束读取的位置，默认为0，用负数来表示倒数第n行
//     */
//    protected int endReadPos = READ_END_POS;
//
//    /**
//     * 设定开始比较的列位置，默认为0
//     */
//    protected int comparePos = COMPARE_POS;
//
//    /**
//     *  设定汇总的文件是否需要替换，默认为true
//     */
//    protected boolean isOverWrite = NEED_OVERWRITE;
//
//    /**
//     *  设定是否需要比较，默认为true(仅当不覆写目标内容是有效，即isOverWrite=false时有效)
//     */
//    protected boolean isNeedCompare = NEED_COMPARE;
//
//    /**
//     * 设定是否只操作第一个sheet
//     */
//    protected boolean onlyReadOneSheet = ONLY_ONE_SHEET;
//
//    /**
//     * 设定操作的sheet在索引值
//     */
//    protected int selectedSheetIdx =SELECTED_SHEET;
//
//    /**
//     * 设定操作的sheet的名称
//     */
//    protected String selectedSheetName = "";
//
//    /**
//     * 设定开始读取的sheet，默认为0
//     */
//    protected int startSheetIdx = READ_START_SHEET;
//
//    /**
//     * 设定结束读取的sheet，默认为0，用负数来表示倒数第n行
//     */
//    protected int endSheetIdx = READ_END_SHEET;
//
//    /**
//     * 设定是否打印消息
//     */
//    protected boolean printMsg = PRINT_MSG;
//
//
//
//}
