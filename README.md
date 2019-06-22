# blog1.0
集成SSM，开发属于自己的博客网站
## 一：需求分析，创建数据库
导入sql文件
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622211321311.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)

## 二：创建项目
1. create new Project
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622165056928.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
2. 左边选中Maven
3. 勾选Create from archetype
4. 选中 org.apache.maven.archetypes:maven-archetype-webapp
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622165228665.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
5. GroupId: 填写项目组的名字， ArtifactId: 填写项目的名字
6. 直接下一步
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622165506924.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
7. 确定路径，开工！
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622165536907.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
8. 可以开始打代码了
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622165826959.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
## 二：部署环境
### 1. 配置pom.xml
修改pom.xml为下面的代码，为了确保导入成功，右键点击pom.xml->Maven->Reimport

```
<?xml version="1.0" encoding="UTF-8"?>

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>

  <groupId>XXX</groupId>
  <artifactId>XXX</artifactId>
  <version>1.0-SNAPSHOT</version>
  <packaging>war</packaging>

  <name>XXX Maven Webapp</name>
  <!-- FIXME change it to the project's website -->
  <url>http://www.example.com</url>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>1.7</maven.compiler.source>
    <maven.compiler.target>1.7</maven.compiler.target>
    <spring.version>4.3.4.RELEASE</spring.version>
    <!--<spring.version>3.2.0.RELEASE</spring.version>-->
    <pagehelper.version>5.1.2-beta</pagehelper.version>
    <mysql.version>5.1.6</mysql.version>
    <mybatis.spring.version>1.2.3</mybatis.spring.version>
    <mybatis.version>3.1.1</mybatis.version>
    <mybatis.generator.version>1.3.5</mybatis.generator.version>
    <junit.version>4.12</junit.version>
    <jstl.version>1.2</jstl.version>
    <jsqlparser.version>1.0</jsqlparser.version>
    <jackson.version>2.1.0</jackson.version>
    <servlet-api.version>3.1.0</servlet-api.version>
    <druid.version>1.0.18</druid.version>
    <log4j.version>1.2.16</log4j.version>
    <commons-logging.version>1.2</commons-logging.version>
    <commons-fileupload.version>1.2.1</commons-fileupload.version>
    <commons-io.version>1.3.2</commons-io.version>
    <commons-lang.version>2.6</commons-lang.version>
    <aopalliance.version>1.0</aopalliance.version>
    <mybatis-generator.version>1.3.5</mybatis-generator.version>
    <basedir>com.lh</basedir>
    <jackson.version>2.5.2</jackson.version>
    <CommentUtils.version>1.7</CommentUtils.version>
  </properties>

  <dependencies>

    <!-- https://mvnrepository.com/artifact/xin.xihc/CommonUtils -->
    <dependency>
      <groupId>xin.xihc</groupId>
      <artifactId>CommonUtils</artifactId>
      <version>${CommentUtils.version}</version>
    </dependency>


    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-core</artifactId>
      <version>${jackson.version}</version>
    </dependency>

    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-databind</artifactId>
      <version>${jackson.version}</version>
    </dependency>


    <dependency>
      <groupId>com.fasterxml.jackson.core</groupId>
      <artifactId>jackson-annotations</artifactId>
      <version>${jackson.version}</version>
    </dependency>

    <dependency>
      <groupId>junit</groupId>
      <artifactId>junit</artifactId>
      <version>${junit.version}</version>
    </dependency>

    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis</artifactId>
      <version>${mybatis.version}</version>
    </dependency>

    <dependency>
      <groupId>org.mybatis</groupId>
      <artifactId>mybatis-spring</artifactId>
      <version>${mybatis.spring.version}</version>
    </dependency>

    <dependency>
      <groupId>mysql</groupId>
      <artifactId>mysql-connector-java</artifactId>
      <version>${mysql.version}</version>
    </dependency>

    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>druid</artifactId>
      <version>${druid.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aop</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-test</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-beans</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-webmvc</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-jdbc</artifactId>
      <version>${spring.version}</version>
    </dependency>

    <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-aspects</artifactId>
      <version>${spring.version}</version>
    </dependency>
    <!-- JSP相关 -->
    <dependency>
      <groupId>jstl</groupId>
      <artifactId>jstl</artifactId>
      <version>${jstl.version}</version>
    </dependency>

    <dependency>
      <groupId>javax.servlet</groupId>
      <artifactId>javax.servlet-api</artifactId>
      <version>${servlet-api.version}</version>
      <scope>provided</scope>
    </dependency>

    <!-- pageHelper -->
    <dependency>
      <groupId>com.github.pagehelper</groupId>
      <artifactId>pagehelper</artifactId>
      <version>${pagehelper.version}</version>
    </dependency>

    <!--jsqlparser-->
    <dependency>
      <groupId>com.github.jsqlparser</groupId>
      <artifactId>jsqlparser</artifactId>
      <version>${jsqlparser.version}</version>
    </dependency>
    <dependency>
      <groupId>log4j</groupId>
      <artifactId>log4j</artifactId>
      <version>${log4j.version}</version>
    </dependency>

    <dependency>
      <groupId>commons-logging</groupId>
      <artifactId>commons-logging</artifactId>
      <version>${commons-logging.version}</version>
    </dependency>

    <dependency>
      <groupId>commons-fileupload</groupId>
      <artifactId>commons-fileupload</artifactId>
      <version>${commons-fileupload.version}</version>
    </dependency>

    <dependency>
      <groupId>commons-io</groupId>
      <artifactId>commons-io</artifactId>
      <version>${commons-io.version}</version>
    </dependency>

    <dependency>
      <groupId>commons-lang</groupId>
      <artifactId>commons-lang</artifactId>
      <version>${commons-lang.version}</version>
    </dependency>

    <dependency>
      <groupId>aopalliance</groupId>
      <artifactId>aopalliance</artifactId>
      <version>${aopalliance.version}</version>
    </dependency>

    <dependency>
      <groupId>org.mybatis.generator</groupId>
      <artifactId>mybatis-generator-core</artifactId>
      <version>${mybatis-generator.version}</version>
    </dependency>
    <dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>fastjson</artifactId>
      <version>1.2.47</version>
    </dependency>
  </dependencies>

  <build>
    <finalName>com.lh.blog</finalName>
    <plugins>
      <!--配置逆向工程-->
      <plugin>
        <groupId>org.mybatis.generator</groupId>
        <artifactId>mybatis-generator-maven-plugin</artifactId>
        <version>${mybatis.generator.version}</version>
        <configuration>
          <configurationFile>src/main/resources/mybatis/generatorConfig.xml</configurationFile>
          <verbose>true</verbose>
          <overwrite>true</overwrite>
        </configuration>
        <executions>
          <execution>
            <id>Generate MyBatis Artifacts</id>
            <goals>
              <goal>generate</goal>
            </goals>
          </execution>
        </executions>
        <dependencies>
          <dependency>
            <groupId>org.mybatis.generator</groupId>
            <artifactId>mybatis-generator-core</artifactId>
            <version>${mybatis.generator.version}</version>
          </dependency>
          <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>${mysql.version}</version>
            <scope>runtime</scope>
          </dependency>

        </dependencies>
      </plugin>
    </plugins>

    <pluginManagement><!-- lock down plugins versions to avoid using Maven defaults (may be moved to parent pom) -->
      <plugins>
        <plugin>
          <artifactId>maven-clean-plugin</artifactId>
          <version>3.0.0</version>
        </plugin>
        <!-- see http://maven.apache.org/ref/current/maven-core/default-bindings.html#Plugin_bindings_for_war_packaging -->
        <plugin>
          <artifactId>maven-resources-plugin</artifactId>
          <version>3.0.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-compiler-plugin</artifactId>
          <version>3.7.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-surefire-plugin</artifactId>
          <version>2.20.1</version>
        </plugin>
        <plugin>
          <artifactId>maven-war-plugin</artifactId>
          <version>3.2.0</version>
        </plugin>
        <plugin>
          <artifactId>maven-install-plugin</artifactId>
          <version>2.5.2</version>
        </plugin>
        <plugin>
          <artifactId>maven-deploy-plugin</artifactId>
          <version>2.8.2</version>
        </plugin>
        <plugin>
          <groupId>org.apache.tomcat.maven</groupId>
          <artifactId>tomcat7-maven-plugin</artifactId>
          <version>2.2</version>
        </plugin>
      </plugins>
    </pluginManagement>

    <resources>
      <resource>
        <directory>src/main/resources</directory>
        <includes>
          <include>**/*.properties</include>
          <!--<include>spring/*</include>-->
          <!--<include>springMVC/*</include>-->
          <!--<include>mapper/*</include>-->
          <include>**/*.xml</include>
          <!--<include>**/*.tld</include>-->
        </includes>
        <filtering>false</filtering>
      </resource>
      <resource>
        <directory>src/main/java</directory>
        <includes>
          <include>**/*.properties</include>
          <include>**/*.xml</include>
        </includes>
        <filtering>false</filtering>
      </resource>
    </resources>
  </build>
</project>

```
### 2. 配置基本的项目结构
#### （1）手动创建源代码目录
右键main目录-> New->Directory->输入java->右键java->Mark Directory as-> Sources Root
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622170048892.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622170126211.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
这样就创建了存放java源文件的目录了
#### （2）创建项目包
点中源目录：java 然后菜单->File->New->Package 输入 com.lh创建包
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622171646863.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70) 

#### （3）创建bean包以及相关的实体类
根据自定义的数据库，创建每个表对应的实体类以及相关的属性、getXX()和setXX()方法
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019062217221241.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
#### （4）创建mapper包以及每个实体类对应的mapper类
对每个实体类声明基本的增删改查的业务方法
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622172830897.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
#### （5）创建service包以及每个实体类对应的service接口
对每个实体类定义基本的增删改查的业务方法
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622173044249.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
#### （6）为service接口创建对应的实现类
在service包下创建impl包，用于存放实现类
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622173145492.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
#### （7）创建controller包以及网站每个功能对应的controller类
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622173350640.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
### 3. 配置属性文件
#### （1）手动创建配置目录
右键main目录-> New->Directory->输入resources->右键resources->Mark Directory as-> Resources Root
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622201349550.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622201405897.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
#### （2）配置mapper.xml文件
 在resources目录下，新建mapper目录，为每个mapper类创建对应的mapper文件
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622201447515.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
#### （3）配置日志文件
在resources目录下新建log4j.properties
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622201600211.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
#### （4）配置数据库文件
在resources目录下新建jdbc.properties，此配置文件给出了访问数据库需要的必须信息
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622201652602.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
#### （5）配置spring
 在resources目录下，新建spring目录，配置spring的数据库连接池、业务类注解的识别以及事务
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622201956103.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
#### （6）配置springMVC.xml
 在resources目录下，新建springMVC目录，配置springMVC。开启注解的识别、开通静态资源的访问、视图定位、上传文件。
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622202137162.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
#### （7）配置web.xml
1. 指定spring的配置文件
2. 设置中文过滤器
3. 指定spring mvc配置文件
4. 文件上传

```
<!DOCTYPE web-app PUBLIC
        "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
        "http://java.sun.com/dtd/web-app_2_3.dtd" >

<web-app xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xmlns="http://java.sun.com/xml/ns/javaee" xmlns:mvc="http://www.springframework.org/schema/mvc"
         xsi:schemaLocation="http://java.sun.com/xml/ns/javaee
         http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd" id="WebApp_ID" version="3.0">
  <display-name>Blog</display-name>

  <!--post乱码过滤器-->
  <!-- 配置springMVC编码过滤器 -->
  <filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <!-- 设置过滤器中的属性值 -->
    <init-param>
      <param-name>encoding</param-name>
      <param-value>UTF-8</param-value>
    </init-param>
    <!-- 启动过滤器 -->
    <init-param>
      <param-name>forceEncoding</param-name>
      <param-value>true</param-value>
    </init-param>
  </filter>
  <!-- 过滤所有请求 -->
  <filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>

  <!--上传文件-->
  <filter>
    <filter-name>MultipartFilter</filter-name>
    <filter-class>org.springframework.web.multipart.support.MultipartFilter</filter-class>
  </filter>
  <filter-mapping>
    <filter-name>MultipartFilter</filter-name>
    <servlet-name>mvc-dispatcher</servlet-name>
  </filter-mapping>


  <!-- 使用Rest风格的URI，将页面普通的post请求转为指定的delete或者put请求 -->
  <filter>
    <filter-name>HiddenHttpMethodFilter</filter-name>
    <filter-class>org.springframework.web.filter.HiddenHttpMethodFilter</filter-class>
  </filter>
  <filter-mapping>
    <filter-name>HiddenHttpMethodFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>
  <filter>
    <filter-name>HttpPutFormContentFilter</filter-name>
    <filter-class>org.springframework.web.filter.HttpPutFormContentFilter</filter-class>
  </filter>
  <filter-mapping>
    <filter-name>HttpPutFormContentFilter</filter-name>
    <url-pattern>/*</url-pattern>
  </filter-mapping>

  <!--加载spring容器-->
  <context-param>
    <param-name>contextConfigLocation</param-name>
    <param-value>
      classpath:spring/applicationContext-*.xml
    </param-value>
  </context-param>

  <!--配置监听器，来加载spring容器-->
  <listener>
    <listener-class>
      org.springframework.web.context.ContextLoaderListener
    </listener-class>
  </listener>

  <!-- 以下3项参数与log4j的配置相关 -->
  <context-param>
    <param-name>log4jConfigLocation</param-name>
    <param-value>classpath:log4j.properties</param-value>
  </context-param>

  <context-param>
    <param-name>log4jRefreshInterval</param-name>
    <param-value>60000</param-value>
  </context-param>
  <listener>
    <listener-class>
      org.springframework.web.util.Log4jConfigListener
    </listener-class>
  </listener>

  <!--springmvc前端控制器 -->
  <servlet>
    <servlet-name>mvc-dispatcher</servlet-name>
    <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
    <init-param>
      <param-name>contextConfigLocation</param-name>
      <param-value>classpath:springMVC/springMVC.xml</param-value>
    </init-param>
  </servlet>
  <servlet-mapping>
    <servlet-name>mvc-dispatcher</servlet-name>
    <url-pattern>/</url-pattern>
  </servlet-mapping>


  <!--随时获得request-->
  <listener>
    <listener-class>
      org.springframework.web.context.request.RequestContextListener
    </listener-class>
  </listener>
  
  <welcome-file-list>
    <welcome-file>index.jsp</welcome-file>
  </welcome-file-list>
  
  <!--去掉jsp页面的空白-->
  <jsp-config>
    <jsp-property-group>
      <url-pattern>*.jsp</url-pattern>
      <trim-directive-whitespaces>true</trim-directive-whitespaces>
    </jsp-property-group>
  </jsp-config>
</web-app>

```
### 4. 导入静态资源
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622202856817.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
### 5. 设置测试类
右键main目录-> New->Directory->输入test->右键test->Mark Directory as-> Test Sources Root
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019062220440983.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
## 三：配置Tomcat
1. 点击Run→点击 Edit Configurations→然后点击+号→选Tomcat Servet→Local
![在这里插入图片描述](https://img-blog.csdnimg.cn/2019062220315484.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
2. 点击Configure，选择Tomcat的路径
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622203251485.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
3. 点击Deployment→点击加号→点击Artifact→选择生成war包或自动解压，Application context要设置为你想要访问的路径
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622203414922.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
## 四：逆向工程生成代码
用逆向工程的方式，首先保证数据库里有表，然后通过Mybatis Generator生成bean, mapper和xml。
1.  在resources目录下，新建mybaits目录，配置generatorConfig.xml
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622204030286.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622204051844.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
2. 在test目录下编写GeneratorMybatis类并运行，自动生成
```
import org.junit.Before;
import org.junit.Test;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneratorMybatis {
    private InputStream inputStream;

    @Before
    public void before() throws IOException {
        inputStream = GeneratorMybatis.class.getClassLoader().getResource("mybatis/generatorConfig.xml").openStream();
    }

    @Test
    public void test() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException {
        List<String> warnings = new ArrayList<>();
        boolean overwrite = true;
        ConfigurationParser parser = new ConfigurationParser(warnings);
        Configuration configuration = parser.parseConfiguration(inputStream);
        inputStream.close();
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration,callback,warnings);
        myBatisGenerator.generate(null);
        System.out.println("success");

    }
}

```
3. 运行成功
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622204632463.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622204709753.png)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622204745660.png)
## 五：运行成功
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190622211400808.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3dlaXhpbl8zNjkwNDU2OA==,size_16,color_FFFFFF,t_70)
