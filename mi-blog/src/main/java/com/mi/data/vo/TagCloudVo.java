package com.mi.data.vo;

/**
 * 标签云定位
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017/9/6.
 */
public class TagCloudVo {

    private String tagId;
    private String tagName; // 表情名称
    private String position;//坐标

    public String getTagId() {
        return tagId;
    }

    public void setTagId(String tagId) {
        this.tagId = tagId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
