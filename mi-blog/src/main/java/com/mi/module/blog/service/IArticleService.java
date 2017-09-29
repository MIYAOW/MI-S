package com.mi.module.blog.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.mi.data.vo.ArticleVo;
import com.mi.data.vo.Pager;
import com.mi.module.blog.entity.Article;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;
import java.util.Map;

/**
 *
 * 文章; InnoDB free: 11264 kB 服务接口
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
public interface IArticleService extends IService<Article> {

    /** 获取归档列表 **/
    List<Map> selectArticleArchiveList();

    /**
     * 初始化分页信息
     * @return
     * @param pager
     */
    void initPage(Pager pager);

    /**
     * 关键字查询文章
     * @param map｛keymap｝ 关键字
     * @return
     */
    List<Article> selectArticleListByKeywords(Map map);




    /**
     * 添加文章
     * @param article
     * @param tags
     * @param typeId
     * @return
     */
    Integer insertArticle(Article article, String[] tags, String typeId);


    /**
     * 修改文章
     * @param article
     * @param tags
     * @param typeId
     * @return
     */
    Integer updateArticle(Article article, String[] tags, String typeId);


    /**
     * 通过id获取文章的所以信息 包括标签和分类信息
     *
     * @param articleId
     * @return
     */
    ArticleVo getArticleCustomById(String articleId);

    /**
     * 获取上一篇文章信息
     *
     * @param articleId
     * @return
     */
    Article getLastArticle(String articleId);

    /**
     * 获取下一篇文章信息
     *
     * @param articleId
     * @return
     */
    Article getNextArticle(String articleId);

    /**
     * 增加文章阅读数量
     *
     * @param articleId
     */
    void addArticleCount(String articleId);


    /**
     * 首页加载文章列表
     *
     * @param page
     * @return
     */
    Page<ArticleVo> selectArticleList(Page<ArticleVo> page);

    Page<ArticleVo> selectArticleByArchive(Page<ArticleVo> page);

    Page<ArticleVo> selectArticleByType(Page<ArticleVo> page, String typeId);

    Page<ArticleVo> selectArticleByTag(Page<ArticleVo> page, String tagId);

    /**
     * 条件查询文章
     *
     * @param param
     * @return
     */
    Page<Article> selectArticlePage(Page pages, Map<String, Object> param);
}
