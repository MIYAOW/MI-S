SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for blog_article
-- ----------------------------
DROP TABLE IF EXISTS `blog_article`;
CREATE TABLE `blog_article` (
  `article_id` varchar(50) NOT NULL COMMENT '主键',
  `title` varchar(50) default NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `description` varchar(500) default NULL COMMENT '简介',
  `status` int(2) default NULL COMMENT '状态 0：正常  1：不可用',
  `class_type` smallint(2) default '0' COMMENT '0原创 1转载 ',
  `author` varchar(20) default NULL COMMENT '作者',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '修改时间',
  `look_count` int(11) default '0' COMMENT '访问量',
  PRIMARY KEY  (`article_id`),
  UNIQUE KEY `Index_titile` (`title`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章';

-- ----------------------------
-- Records of blog_article
-- ----------------------------
INSERT INTO `blog_article` VALUES ('201708091054445915', '部署安装', '## 环境安装\n\nJDK1.8\n\nMySQL5.5 ↑\n\nIDEA 2017\n\nMaven\n\n### 运行步骤\n\n下载[MI源码](https://github.com/miyaow/mi);\n\n1.sql文件导入到mysql数据库中(技术群里拿)\n\n2.直接使用maven工具 mvn package 命令进行打包；\n\n5.使用命令 **java -jar mi-blog.jar** 运行项目\n\n6.访问 **http://localhost:9922** 进入主页\n\n### 后台模块\n\n **http://localhost:9922/admin/login** 进行登陆\n\n默认账号密码 miyaow/123\n\n### 协助\n\n还有其他问题进群询问\n\n>转载请注明出处\n\n\n\n\n\n\n\n\n', '最简单的介绍如何运行本项目。', '1', '0', '猫爷', '2017-08-10 10:54:44', '2017-09-28 17:07:35', '59');
INSERT INTO `blog_article` VALUES ('201708091054561e23', '项目简介', '# STAR法则描述\n\n## S（场景）\n\n其实自己一直都在用CSDN写博客，想复习下基础还有练习下最新的SpringBoot框架。利用业余时间整一个博客系统用于记录自己平时工作与技术的积累，本博客系统做的可能并不是很完美，功能也不是特别的强大。有愿意一起继续根据自己的需求整合自己的版本请联系我。也欢迎大家Star主项目和fork，也可以根据自己的需求进行二次开发。意见请走[issues](https://github.com/miyaow/mi/issues)\n\n作品演示站：http://blog.miterm.com/\n源码地址： https://github.com/miyaow/mi\n\n## T（目标）\n\n希望在国庆之前完成最简单的版本与部署方案脚本。\n让大家使用上\n\n## A（执行）\n\n首先自己上网寻找资料以及查看源码去学习Springboot框架，又寻找各项前端插件以及模版，在空余时间补充自己相关缺陷的东西进行编写程序，在程序中也遇到了挺多的困难以及bug点。之后,原本想和一个朋友一起用vue前后端分离去写这个项目，但是想了下，平时时间不足，学习前端新技术成本若高，所以这个前端技术换到其他的子项目中去写，而这个项目就当作复习老技术作为铺垫的实验项目。好久没写前端的东西了，做出来可能有点粗糙。最终下定决心，开始准备有空就改改。先做到基本功能使用。后期根据自己的需求继续定制化维护就好。\n\n## R（结果）\n\n最终在预备在十月初完成第一版本上线。自己使用。\n\n## 技术栈（见主目录）\n\n使用主目录技术栈的部分技术。\n\n## 效果图\n\n首页展示部分\n\n![首页](/ex/index.jpg)\n\n文章详情页\n\n![文章详情](/ex/detail.jpg)\n\n\n后端总览界面\n\n![后台管理界面](/ex/background.jpg)\n\nmarkdown编辑器\n\n![markdown界面](/ex/markdown.jpg)\n\n\n>转载请注明博客出处\n\n本站鸣谢 翟永超 以及 hexo主题 icarus 提供材料\n\n\n\n\n\n\n', '项目背景以及简单的介绍', '1', '0', '猫爷', '2017-07-09 10:54:56', '2017-09-28 17:06:51', '113');
INSERT INTO `blog_article` VALUES ('20170928163316a489', '测试', '测试', '测试无标签', '1', '1', 'miyaow', '2017-09-28 16:33:16', '2017-09-28 17:08:19', '0');

-- ----------------------------
-- Table structure for blog_article_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_tag`;
CREATE TABLE `blog_article_tag` (
  `article_id` varchar(50) default NULL COMMENT '文章主键',
  `tag_id` varchar(50) default NULL COMMENT '标签主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章标签关联';

-- ----------------------------
-- Records of blog_article_tag
-- ----------------------------
INSERT INTO `blog_article_tag` VALUES ('201708091054561e23', 'default');
INSERT INTO `blog_article_tag` VALUES ('201708091054445915', 'default');
INSERT INTO `blog_article_tag` VALUES ('20170928163316a489', 'default');

-- ----------------------------
-- Table structure for blog_article_type
-- ----------------------------
DROP TABLE IF EXISTS `blog_article_type`;
CREATE TABLE `blog_article_type` (
  `article_id` varchar(50) default NULL COMMENT '文章主键',
  `type_id` varchar(50) default NULL COMMENT '标签主键'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章分类关联';

-- ----------------------------
-- Records of blog_article_type
-- ----------------------------
INSERT INTO `blog_article_type` VALUES ('201708091054561e23', 'default');
INSERT INTO `blog_article_type` VALUES ('201708091054445915', 'default');
INSERT INTO `blog_article_type` VALUES ('20170928163316a489', 'default');

-- ----------------------------
-- Table structure for blog_bbs
-- ----------------------------
DROP TABLE IF EXISTS `blog_bbs`;
CREATE TABLE `blog_bbs` (
  `bbs_id` int(11) NOT NULL,
  `user_id` int(11) default NULL,
  `bbs_text` varchar(2000) default NULL,
  PRIMARY KEY  (`bbs_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_bbs
-- ----------------------------
INSERT INTO `blog_bbs` VALUES ('1', '1', 'MIYAOW 的 MI - Blog Version1.0 <br> 博客上线啦！！！<br>');

-- ----------------------------
-- Table structure for blog_friendlink
-- ----------------------------
DROP TABLE IF EXISTS `blog_friendlink`;
CREATE TABLE `blog_friendlink` (
  `flink_id` varchar(50) NOT NULL COMMENT '主键',
  `site_name` varchar(100) default NULL COMMENT '站点名称',
  `site_url` varchar(200) default NULL COMMENT '站点地址',
  `site_author` varchar(50) default NULL COMMENT '站点作者',
  `site_desc` varchar(200) default NULL COMMENT '站点描述',
  `sort` int(5) default NULL COMMENT '排序',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`flink_id`),
  UNIQUE KEY `Index_size_name` (`site_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='友情链接';

-- ----------------------------
-- Records of blog_friendlink
-- ----------------------------
INSERT INTO `blog_friendlink` VALUES ('201709252102072ded', 'MIYAOW', 'http://blog.csdn.net/fjnpysh', 'miyaow', '博客', '1', '2017-09-25 21:02:07', '2017-09-25 21:06:15');
INSERT INTO `blog_friendlink` VALUES ('20170928155150c006', '百度', 'http://www.baidu.com', '百度', '百度知道', '1', '2017-09-28 15:51:50', null);

-- ----------------------------
-- Table structure for blog_log
-- ----------------------------
DROP TABLE IF EXISTS `blog_log`;
CREATE TABLE `blog_log` (
  `log_id` varchar(50) NOT NULL COMMENT '主键',
  `url` varchar(100) default NULL COMMENT '请求路径',
  `http_method` varchar(50) default NULL COMMENT '请求类型',
  `ip` varchar(20) default NULL COMMENT 'IP地址',
  `class_method` varchar(100) default NULL COMMENT '请求方法类',
  `args` varchar(200) default NULL COMMENT '请求参数',
  `user` varchar(50) default NULL COMMENT '操作者',
  `spend_time` int(11) default NULL COMMENT '执行时间(毫秒)',
  `result` varchar(1000) default NULL COMMENT '返回结果',
  PRIMARY KEY  (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='操作日志';

-- ----------------------------
-- Records of blog_log
-- ----------------------------

-- ----------------------------
-- Table structure for blog_signature
-- ----------------------------
DROP TABLE IF EXISTS `blog_signature`;
CREATE TABLE `blog_signature` (
  `s_id` varchar(50) NOT NULL COMMENT '主键',
  `user_id` varchar(100) default NULL COMMENT '用户ID外键',
  `s_text` varchar(2000) default NULL COMMENT '签名内容',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`s_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='个性签名';

-- ----------------------------
-- Records of blog_signature
-- ----------------------------

-- ----------------------------
-- Table structure for blog_sys_param
-- ----------------------------
DROP TABLE IF EXISTS `blog_sys_param`;
CREATE TABLE `blog_sys_param` (
  `sys_id` varchar(50) NOT NULL COMMENT '主键',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '修改时间',
  `sys_key` varchar(50) default NULL COMMENT '参数键',
  `sys_param` varchar(1000) default NULL COMMENT '参数值',
  `remark` varchar(200) default NULL COMMENT '备注',
  PRIMARY KEY  (`sys_id`),
  UNIQUE KEY `Index_size_name` (`sys_key`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT=' 系统参数表';

-- ----------------------------
-- Records of blog_sys_param
-- ----------------------------
INSERT INTO `blog_sys_param` VALUES ('1', '2017-09-25 21:11:44', '2017-09-25 21:11:46', 'CY_APID', '', '畅言ID');

-- ----------------------------
-- Table structure for blog_tag
-- ----------------------------
DROP TABLE IF EXISTS `blog_tag`;
CREATE TABLE `blog_tag` (
  `tag_id` varchar(50) NOT NULL COMMENT '主键',
  `tag_name` varchar(100) NOT NULL COMMENT '标签名',
  `alias_name` varchar(50) NOT NULL COMMENT '标签别名',
  `sort` int(11) default NULL COMMENT '排序',
  `create_time` datetime default NULL,
  `update_time` datetime default NULL,
  PRIMARY KEY  (`tag_id`),
  UNIQUE KEY `Index_tag_name` (`tag_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章标签';

-- ----------------------------
-- Records of blog_tag
-- ----------------------------
INSERT INTO `blog_tag` VALUES ('css', 'css', 'css', '0', '2017-09-26 19:04:20', null);
INSERT INTO `blog_tag` VALUES ('default', 'default', 'default', '0', '2017-08-02 15:12:04', null);
INSERT INTO `blog_tag` VALUES ('docker', 'Docker', 'Docker', '0', '2017-09-06 18:22:17', null);
INSERT INTO `blog_tag` VALUES ('es6', 'ES6', 'ES6', '0', '2017-09-06 18:22:07', null);
INSERT INTO `blog_tag` VALUES ('html', 'HTML', 'HTML', '0', '2017-09-06 18:20:52', null);
INSERT INTO `blog_tag` VALUES ('html5', 'HTML5', 'HTML5', '0', '2017-09-06 18:20:58', null);
INSERT INTO `blog_tag` VALUES ('javascript', 'JavaScript', 'JavaScript', '1', '2017-09-06 18:20:15', null);
INSERT INTO `blog_tag` VALUES ('jquery', 'Jquery', 'Jquery', '0', '2017-09-06 18:20:36', null);
INSERT INTO `blog_tag` VALUES ('spring-boot', 'SpringBoot', 'SpringBoot', '0', '2017-09-12 15:14:56', null);
INSERT INTO `blog_tag` VALUES ('spring-cloud', 'SpringCloud', 'SpringCloud', '0', '2017-09-01 00:54:05', null);
INSERT INTO `blog_tag` VALUES ('vue', 'Vue', 'Vue', '0', '2017-09-06 18:21:14', null);
INSERT INTO `blog_tag` VALUES ('分布式', '分布式', '分布式', '0', '2017-09-06 18:22:25', null);
INSERT INTO `blog_tag` VALUES ('运维监控', '运维监控', '运维监控', '0', '2017-09-06 18:22:34', null);

-- ----------------------------
-- Table structure for blog_type
-- ----------------------------
DROP TABLE IF EXISTS `blog_type`;
CREATE TABLE `blog_type` (
  `type_id` varchar(50) NOT NULL COMMENT '主键',
  `type_name` varchar(250) NOT NULL COMMENT '请求路径',
  `alias_name` varchar(250) NOT NULL COMMENT '请求类型',
  `sort` int(11) default NULL COMMENT '排序号',
  `create_time` datetime default NULL COMMENT '创建时间',
  `update_time` datetime default NULL COMMENT '修改时间',
  PRIMARY KEY  (`type_id`),
  UNIQUE KEY `Index_type_name` (`type_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='文章类型';

-- ----------------------------
-- Records of blog_type
-- ----------------------------
INSERT INTO `blog_type` VALUES ('20170928154842cf8b', 'Vue', 'Vue2', '1', '2017-09-28 15:48:42', null);
INSERT INTO `blog_type` VALUES ('default', '默认分类', '默认分类', '0', '2017-08-04 15:30:10', null);

-- ----------------------------
-- Table structure for blog_user
-- ----------------------------
DROP TABLE IF EXISTS `blog_user`;
CREATE TABLE `blog_user` (
  `user_id` varchar(50) NOT NULL COMMENT '主键',
  `info_id` varchar(20) default NULL COMMENT '详细ID',
  `user_name` varchar(100) NOT NULL COMMENT '登录名',
  `user_pwd` varchar(100) NOT NULL COMMENT '登录密码',
  `enabled` int(5) default '0' COMMENT '是否被禁用',
  `credential` int(5) default '0' COMMENT '凭证是否过期',
  `locked` int(5) default '0' COMMENT '是否被锁',
  `expired` int(5) default '0' COMMENT '是否过期',
  `create_time` datetime default NULL COMMENT '创建时间',
  PRIMARY KEY  (`user_id`),
  KEY `FK_Reference_5` (`info_id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`info_id`) REFERENCES `blog_user_info` (`info_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='博客用户';

-- ----------------------------
-- Records of blog_user
-- ----------------------------
INSERT INTO `blog_user` VALUES ('1', '1', 'miyaow', '123', '0', '0', '0', '0', '2017-10-01 15:27:07');
INSERT INTO `blog_user` VALUES ('2', '2', 'yesh', '123', '0', '0', '0', '0', '2017-10-02 16:35:21');

-- ----------------------------
-- Table structure for blog_user_info
-- ----------------------------
DROP TABLE IF EXISTS `blog_user_info`;
CREATE TABLE `blog_user_info` (
  `info_id` varchar(50) NOT NULL COMMENT '主键',
  `avatar_url` varchar(100) default NULL COMMENT '头像地址',
  `nick_name` varchar(100) default NULL COMMENT '昵称',
  `phone` varchar(100) default NULL COMMENT '电话',
  `qq` varchar(200) default NULL,
  `email` varchar(100) default NULL COMMENT '邮箱',
  `address` varchar(200) default NULL COMMENT '地址',
  `wechart` varchar(200) default NULL COMMENT '微信帐号',
  `wechart_img` varchar(200) default NULL COMMENT '微信二维码地址',
  `signature` varchar(200) default NULL COMMENT '个性签名',
  `announcement` varchar(200) NOT NULL COMMENT '公告',
  PRIMARY KEY  (`info_id`,`announcement`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户详细';

-- ----------------------------
-- Records of blog_user_info
-- ----------------------------
INSERT INTO `blog_user_info` VALUES ('1', 'http://ovr5hz4v2.bkt.clouddn.com/avatar.jpg', 'MIYAOW', '电话', '454514080', '454514080@qq.com', '中国-福建', '见隔壁二维码', '/image/wechar.jpg', '一只腻爱猫的程序员老爷爷。', 'MIYAOW 的 MI - Blog Version1.0 <br> 博客上线啦！！！<br>');
INSERT INTO `blog_user_info` VALUES ('2', 'http://ovr5hz4v2.bkt.clouddn.com/avatar.jpg', 'Yesh', '电话', '454514080', '454514080@qq.com', '中国-福建', '微信', '/image/wechar.jpg', '一只腻爱猫的程序员老大叔。', 'MIYAOW 的 MI - Blog Version1.0 <br> 博客上线啦！！！<br>');
