package com.mi.module.blog.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mi.common.util.IDUntil;
import com.mi.data.vo.ArticleVo;
import com.mi.data.vo.Pager;
import com.mi.module.blog.entity.Article;
import com.mi.module.blog.entity.ArticleTag;
import com.mi.module.blog.entity.ArticleType;
import com.mi.module.blog.mapper.ArticleMapper;
import com.mi.module.blog.mapper.ArticleTagMapper;
import com.mi.module.blog.mapper.ArticleTypeMapper;
import com.mi.module.blog.service.IArticleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * 
 * 文章; InnoDB free: 11264 kB 服务实现类
 *
 * @author yesh
 *         (M.M)!
 *         Created by 2017-07-09.
 */
@Slf4j
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private ArticleTagMapper articleTagMapper;
    @Resource
    private ArticleTypeMapper articleTypeMapper;


    @Override
    public List<Map> selectArticleArchiveList() {
        return articleMapper.selectArticleArchiveList();
    }

    @Override
    public void initPage(Pager pager) {
        EntityWrapper<Article> ew = new EntityWrapper<Article>();
        int count = articleMapper.selectCount(ew);
        pager.setTotalCount(count);
    }

    @Override
    public List<Article> selectArticleListByKeywords(Map map) {
        return articleMapper.selectArticleListByKeywords(map);
    }


    @Override
    @Transactional
    public Integer insertArticle(Article article, String[] tags, String typeId) {
        int result;
        String id = IDUntil.getRandomId(5);

        if (tags != null) {
            for (int j = 0; j < tags.length; j++) {
                ArticleTag articleTag = new ArticleTag();
                articleTag.setArticleId(id);
                articleTag.setTagId(tags[j]);
                articleTagMapper.insert(articleTag);
            }
        }

        ArticleType articleType = new ArticleType();
        articleType.setArticleId(id);
        articleType.setTypeId(typeId);
        articleTypeMapper.insert(articleType);


        article.setArticleId(id);
        result = articleMapper.insert(article);

        return result;
    }

    @Override
    public Integer updateArticle(Article article, String[] tags, String typeId) {
        article.setUpdateTime(new Date());
        article.setStatus(1);

        //移除原有相关链接之后再添加
        articleTypeMapper.deleteById(article.getArticleId());
        ArticleType articleType = new ArticleType();
        articleType.setArticleId(article.getArticleId());
        articleType.setTypeId(typeId);
        articleTypeMapper.insert(articleType);

        articleTagMapper.deleteById(article.getArticleId());
        if (tags!=null){
            for (int i = 0; i < tags.length; i++) {
                ArticleTag at = new ArticleTag();
                at.setArticleId(article.getArticleId());
                at.setTagId(tags[i]);
                articleTagMapper.insert(at);
            }
        }

        int result =  articleMapper.updateById(article);

        return result;
    }

    @Override
    public ArticleVo getArticleCustomById(String articleId) {
        return articleMapper.getArticleCustomById(articleId);
    }

    @Override
    public Article getLastArticle(String articleId) {
        return articleMapper.getLastArticle(articleId);
    }

    @Override
    public Article getNextArticle(String articleId) {
        return articleMapper.getNextArticle(articleId);
    }

    @Override
    public void addArticleCount(String articleId) {
        articleMapper.addArticleCount(articleId);
    }

    @Override
    public Page<ArticleVo> selectArticleList(Page<ArticleVo> page) {
        List<ArticleVo> list = articleMapper.selectArticleList(page);
        page.setRecords(list);
        return page;
    }

    @Override
    public Page<ArticleVo> selectArticleByArchive(Page<ArticleVo> page) {
        List<ArticleVo> list = articleMapper.selectArticleList(page);
        page.setRecords(list);
        return page;
    }

    @Override
    public Page<ArticleVo> selectArticleByType(Page<ArticleVo> page, String typeId) {
        List<ArticleVo> list = articleMapper.selectArticleByType2(page, typeId);
        page.setRecords(list);
        return page;
    }

    @Override
    public Page<ArticleVo> selectArticleByTag(Page<ArticleVo> page, String tagId) {
        List<ArticleVo> list = articleMapper.selectArticleByTag(page, tagId);
        page.setRecords(list);
        return page;
    }


    @Override
    public Page<Article> selectArticlePage(Page page, Map<String, Object> param) {
        List<Article> list = articleMapper.selectArticlePage(page, param);
        page.setRecords(list);
        return page;
    }


}
