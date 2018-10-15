-- 创建数据库 
DROP DATABASE
IF EXISTS blog;

CREATE DATABASE blog DEFAULT CHARACTER
SET utf8;

-- 创建表
USE blog;

DROP TABLE
IF EXISTS option_;

CREATE TABLE option_ (
	id INT (11) NOT NULL auto_increment,
	option_key VARCHAR (255) DEFAULT NULL,
	option_value VARCHAR (255) DEFAULT NULL,
	CONSTRAINT pk_option PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE
IF EXISTS user_;

CREATE TABLE user_ (
	id INT (11) NOT NULL auto_increment,
	user_name VARCHAR (255) DEFAULT NULL,
	user_password VARCHAR (255) DEFAULT NULL,
	user_nick_name VARCHAR (255) DEFAULT '',
	user_photo VARCHAR (255) DEFAULT '',
	user_email VARCHAR (255) DEFAULT '',
	user_url VARCHAR (255) DEFAULT '',
	user_ip VARCHAR (255) DEFAULT NULL,
	user_register_date datetime DEFAULT NULL,
	user_login_time datetime DEFAULT NULL,
	user_status INT (2) DEFAULT 1,
	user_rights INT (2) DEFAULT 1,
	CONSTRAINT pk_user PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE
IF EXISTS user_friend;

CREATE TABLE user_friend (
	id INT (11) NOT NULL auto_increment,
	uid INT (11) DEFAULT NULL,
	friend_uid INT (11) DEFAULT NULL,
	friend_status INT (2) DEFAULT 1,
	friend_note VARCHAR (255) DEFAULT NULL,
	CONSTRAINT pk_user_friend PRIMARY KEY (id),
	CONSTRAINT fk_user_friend1 FOREIGN KEY (uid) REFERENCES user_ (id),
	CONSTRAINT fk_user_friend2 FOREIGN KEY (friend_uid) REFERENCES user_ (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE
IF EXISTS category;

CREATE TABLE category (
	id INT (11) NOT NULL auto_increment,
	category_name VARCHAR (255) DEFAULT NULL,
	category_descripe VARCHAR (255) DEFAULT NULL,
	category_status INT (2) DEFAULT 1,
	pid INT (11) DEFAULT 0,
	CONSTRAINT pk_category PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT charset = utf8;

DROP TABLE
IF EXISTS article;

CREATE TABLE article (
	id INT (11) NOT NULL auto_increment,
	article_title VARCHAR (255),
	article_md_text MEDIUMTEXT,
	article_html_text MEDIUMTEXT,
	article_uid INT (11) DEFAULT NULL,
	article_cpid INT (11) DEFAULT NULL,
	article_ccid INT (11) DEFAULT NULL,
	article_create_date datetime DEFAULT NULL,
	article_update_date datetime DEFAULT NULL,
	article_status INT (2) DEFAULT 1,
	article_views BIGINT (20) DEFAULT 0,
	article_likes BIGINT (20) DEFAULT 0,
	article_comments BIGINT (20) DEFAULT 0,
	CONSTRAINT pk_article PRIMARY KEY (id),
	CONSTRAINT fk_article_user_ FOREIGN KEY (article_uid) REFERENCES user_ (id),
	CONSTRAINT fk_article_category_1 FOREIGN KEY (article_ccid) REFERENCES category (id),
	CONSTRAINT fk_article_category_2 FOREIGN KEY (article_cpid) REFERENCES category (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE
IF EXISTS tag;

CREATE TABLE tag (
	id INT (11) NOT NULL auto_increment,
	tag_name VARCHAR (255) DEFAULT NULL,
	tag_descripe VARCHAR (255) DEFAULT NULL,
	tag_status INT (2) DEFAULT 1,
	CONSTRAINT pk_tag PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE
IF EXISTS tag_article;

CREATE TABLE tag_article (
	tid INT (11) NOT NULL,
	aid INT (11) NOT NULL,
	CONSTRAINT pk_tag_arti PRIMARY KEY (tid, aid),
	CONSTRAINT fk_tag_arti1 FOREIGN KEY (tid) REFERENCES tag (id),
	CONSTRAINT fk_tag_arti2 FOREIGN KEY (aid) REFERENCES article (id)
) ENGINE = INNODB DEFAULT charset = utf8;

DROP TABLE
IF EXISTS comment_;

CREATE TABLE comment_ (
	id INT (11) NOT NULL auto_increment,
	comment_html_text MEDIUMTEXT,
	comment_md_text MEDIUMTEXT,
	comment_create_date datetime DEFAULT NULL,
	comment_ip VARCHAR (255) DEFAULT NULL,
	comment_STATUS INT (3) DEFAULT 1,
	pid INT (11) DEFAULT NULL,
	uid INT (11) DEFAULT NULL,
	aid INT (11) DEFAULT NULL,
	CONSTRAINT pk_comment PRIMARY KEY (id),
	CONSTRAINT fk_comment_user FOREIGN KEY (uid) REFERENCES user_ (id),
	CONSTRAINT fk_comment_article FOREIGN KEY (aid) REFERENCES article (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE
IF EXISTS notice;

CREATE TABLE notice (
	id INT (11) NOT NULL auto_increment,
	notice_title VARCHAR (255) DEFAULT NULL,
	notice_html_text MEDIUMTEXT DEFAULT NULL,
	notice_md_text MEDIUMTEXT DEFAULT NULL,
	notice_create_date datetime DEFAULT NULL,
	notice_update_date datetime DEFAULT NULL,
	STATUS INT (2) DEFAULT NULL,
	CONSTRAINT pk_notice PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE
IF EXISTS link;

CREATE TABLE link (
	id INT (11) NOT NULL auto_increment,
	link_url VARCHAR (255) DEFAULT NULL,
	link_name VARCHAR (255) DEFAULT NULL,
	link_describe VARCHAR (255) DEFAULT NULL,
	link_create_date datetime DEFAULT NULL,
	link_update_date datetime DEFAULT NULL,
	STATUS INT (2) DEFAULT NULL,
	CONSTRAINT pk_link PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

DROP TABLE
IF EXISTS menu;

CREATE TABLE menu (
	id INT (11) NOT NULL auto_increment,
	menu_name VARCHAR (255) DEFAULT NULL,
	menu_link VARCHAR (255) DEFAULT NULL,
	menu_icon VARCHAR(255) DEFAULT NULL,
	menu_role INT (2) DEFAULT NULL,
	menu_status INT (2) DEFAULT NULL,
	CONSTRAINT pk_link PRIMARY KEY (id)
) ENGINE = INNODB DEFAULT CHARSET = utf8;

--  插入数据
--  INSERT INTO `category`
--  VALUES
--  	(
-- 		null,'','',2,0
-- 	);
--  ALTER TABLE category
--  add CONSTRAINT fk_category_category FOREIGN KEY (pid) REFERENCES category (id);
INSERT INTO `category`
VALUES
	(
		NULL,
		'Java',
		'Java语言',
		1,
		0
	);

INSERT INTO `category`
VALUES
	(NULL, 'Java基础', '', 1, 1);

INSERT INTO `category`
VALUES
	(NULL, 'Core Java', '', 1, 1);

INSERT INTO `category`
VALUES
	(
		NULL,
		'多线程并发编程',
		'',
		1,
		1
	);

INSERT INTO `category`
VALUES
	(NULL, 'Sockets和IO', '', 1, 1);

INSERT INTO `category`
VALUES
	(
		NULL,
		'设计模式和反射',
		'',
		1,
		1
	);

INSERT INTO `category`
VALUES
	(NULL, 'JVM', '', 1, 1);

INSERT INTO `category`
VALUES
	(NULL, 'JavaWeb', '', 1, 1);

INSERT INTO `category`
VALUES
	(NULL, 'Java框架', '', 1, 1);

INSERT INTO `category`
VALUES
	(
		NULL,
		'计算机科学',
		'',
		1,
		0
	);

INSERT INTO `category`
VALUES
	(
		NULL,
		'数据结构和算法',
		'',
		1,
		10
	);

INSERT INTO `category`
VALUES
	(
		NULL,
		'操作系统',
		'',
		1,
		10
	);

INSERT INTO `category`
VALUES
	(NULL, '数据库', '', 1, 10);

INSERT INTO `category`
VALUES
	(
		NULL,
		'计算机网络',
		'',
		1,
		10
	);

INSERT INTO `category`
VALUES
	(NULL, '其他技术', '', 1, 0);

INSERT INTO `category`
VALUES
	(
		NULL,
		'消息服务',
		'',
		1,
		15
	);

INSERT INTO `category`
VALUES
	(
		NULL,
		'缓存服务',
		'',
		1,
		15
	);

INSERT INTO `user_`
VALUES
	(
		NULL,
		'admin',
		'123456',
		'Galler',
		NULL,
		'953625619@qq.com',
		'https://localhost/blog',
		'127.0.0.1:8080',
		'2018-09-22 12:00:00',
		'2018-09-22 14:55:18',
		1,
		1
	);

INSERT INTO `tag`
VALUES
	(NULL, 'Java', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, '算法', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, '数据结构', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, 'C', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, '操作系统', '', 1);

INSERT INTO `tag`
VALUES
	(
		NULL,
		'计算机网络',
		'',
		1
	);

INSERT INTO `tag`
VALUES
	(NULL, '面试题', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, '数据库', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, 'MySQL', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, 'Spring', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, 'SpringMVC', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, 'MyBatis', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, 'JVM', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, '网络编程', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, 'IO', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, 'JSP', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, 'Servlet', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, 'JavaWeb', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, 'Hibernate', '', 1);

INSERT INTO `tag`
VALUES
	(NULL, 'SQL', '', 1);

INSERT INTO `notice`
VALUES
	(
		NULL,
		'本站下载地址',
		'<p><span>本站后端基于 Spring+SpringMVC+Mybatis+JSP实现，对于初学SSM的小伙伴可以参考。</span></p>',
		'本站后端基于 Spring+SpringMVC+Mybatis+JSP实现，对于初学SSM的小伙伴可以参考。',
		'2018-09-22 13:44:35',
		'2017-09-22 21:23:28',
		1
	);

INSERT INTO `link`
VALUES
	(
		NULL,
		'localhost/blog',
		'博客',
		'一个码农的成长之路',
		'2018-10-07 16:51:03',
		'2018-10-07 16:29:35',
		1
	),
	(
		NULL,
		'http://baidu.com',
		'测试',
		'测试',
		'2018-10-07 16:51:49',
		'2018-10-07 16:51:49',
		2
	);

INSERT INTO `menu`
VALUES
	(
		NULL,
		'关于本站',
		'/aboutSite',
		'glyphicon glyphicon-info-sign',
		1,
		1
	),
	(
		NULL,
		'文章归档',
		'/articleFile',
		'glyphicon glyphicon-file',
		1,
		1
	),
	(
		NULL,
		'申请友链',
		'/applyLink',
		'glyphicon glyphicon-link',
		1,
		1
	);

INSERT INTO `option_`
VALUES
	(NULL, 'name', '博客网'),
	(
		NULL,
		'describe',
		'学习的新起点，大学最后两年的成长记录。珍惜时间，保持努力的惯性'
	),
	(NULL, 'photo', NULL),
	(
		NULL,
		'key',
		'博客,Java博客'
	),
	(NULL, 'number','1');

INSERT INTO `article`
VALUES
	(
		NULL,
		'[转载]SpringMVC中使用Interceptor拦截器',
		NULL,
		'<p>SpringMVC 中的Interceptor 拦截器也是相当重要和相当有用的，它的主要作用是拦截用户的请求并进行相应的处理。比如通过它来进行权限验证，或者是来判断用户是否登陆，或者是像12306 那样子判断当前时间是否是购票时间。</p><p><br></p><p>一、定义Interceptor实现类</p><p>SpringMVC 中的Interceptor 拦截请求是通过HandlerInterceptor 来实现的。在SpringMVC 中定义一个Interceptor 非常简单，主要有两种方式，第一种方式是要定义的Interceptor类要实现了Spring 的HandlerInterceptor 接口，或者是这个类继承实现了HandlerInterceptor 接口的类，比如Spring 已经提供的实现了HandlerInterceptor 接口的抽象类HandlerInterceptorAdaptor 接口的类，比如Spring 已经提供的实现了HandlerInterceptor 接口的抽象类HandlerInterceptorAdapter ；第二种方式是实现Spring的WebRequestInterceptor接口，或or 接口的类，比如Spring 已经提供的实现了HandlerInterceptor 接口的抽象类HandlerInterceptorAdapter ；第二种方式是实现Spring的WebRequestInterceptor接口，或者是继承实现了WebRequestInterceptor的类。</p><p><br></p><p>（一）实现HandlerInterceptor接口</p><p>HandlerInterceptor 接口中定义了三个方法，我们就是通过这三个方法来对用户的请求进行拦截处理的。</p><p><br></p><p>（1 ）preHandle (HttpServletRequest request, HttpServletResponse response, Object handle) 方法，顾名思义，该方法将在请求处理之前进行调用。SpringMVC 中的Interceptor 是链式的调用的，在一个应用中或者说是在一个请求中可以同时存在多个Interceptor 。每个Interceptor 的调用会依据它的声明顺序依次执行，而且最先执行的都是Interceptor 中的preHandle 方法，所以可以在这个方法中进行一些前置初始化操作或者是对当前请求的一个预处理，也可以在这个方法中进行一些判断来决定请求是否要继续进行下去。该方法的返回值是布尔值Boolean 类型的，当它返回为false 时，表示请求结束，后续的Interceptor 和Controller 都不会再执行；当返回值为true 时就会继续调用下一个Interceptor 的preHandle 方法，如果已经是最后一个Interceptor 的时候就会是调用当前请求的Controller 方法。</p><p><br></p><p>（2 ）postHandle (HttpServletRequest request, HttpServletResponse response, Object handle, ModelAndView modelAndView) 方法，由preHandle 方法的解释我们知道这个方法包括后面要说到的afterCompletion 方法都只能是在当前所属的Interceptor 的preHandle 方法的返回值为true 时才能被调用。postHandle 方法，顾名思义就是在当前请求进行处理之后，也就是Controller 方法调用之后执行，但是它会在DispatcherServlet 进行视图返回渲染之前被调用，所以我们可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。postHandle 方法被调用的方向跟preHandle 是相反的，也就是说先声明的Interceptor 的postHandle 方法反而会后执行，这和Struts2里面的Interceptor 的执行过程有点类型。Struts2 里面的Interceptor 的执行过程也是链式的，只是在Struts2 里面需要手动调用ActionInvocation 的invoke 方法来触发对下一个Interceptor 或者是Action 的调用，然后每一个Interceptor 中在invoke 方法调用之前的内容都是按照声明顺序执行的，而invoke 方法之后的内容就是反向的。</p><p><br></p>',
		1,
		1,
		9,
		'2018-10-07 16:51:03',
		'2018-10-07 16:29:35',
		1,
		5,
		4,
		5
	);

INSERT INTO `tag_article`
VALUES
	(13, 1);

INSERT INTO `comment_`
VALUES
	(
		NULL,
		'<p>评论测试</p>',
		'评论测试',
		'2017-10-07 16:06:34',
		'127.0.0.1',
		1,
		0,
		1,
		1
	);

