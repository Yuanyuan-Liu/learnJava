# Spring Boot 2 Demo

## 项目介绍
使用spring boot集成了shiro + redis的前后端分离系统框架demo

## 运行说明
1. 导入项目后，使用maven自动下载相关jar包
2. 下载Redis并设置密码，修改application-dev.yml中的redis.password为设置的密码
3. 修改application-dev.yml的spring.datasource下面的数据库连接地址和用户名密码。
4. 运行SpringbootApplication类，项目即可启动成功。

## 项目常用地址及使用说明
* swagger(接口调试地址)：http://localhost:8080/swagger-ui.html
* druid(SQL及Spring监控地址)：http://localhost:8080/druid/index.html
* metrics(SpringBoot监控运维地址)： http://127.0.0.1:8080/browser/index.html 在Explorer输入/actuator即可

## 软件架构
● 核心框架： spring boot(含健康检查及监控框架) + spring

● mvc框架： spring mvc(全局Restful化，包含全局异常处理为Json)

● 持久层框架： [mybatis](https://blog.csdn.net/lj1314ailj/article/details/79712305)

● Sql翻页框架： [PageHelper](https://github.com/pagehelper/Mybatis-PageHelper/blob/master/wikis/zh/HowToUse.md)

● 数据库连接池： [alibaba druid](https://github.com/alibaba/druid/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98) /[Hakari](https://blog.csdn.net/user_regist/article/details/80659970)(参见[分库分表Demo](http://mayun.itc.licf.cn/80270118/SpringBoot-Sharding-Sphere-Demo/tree/feature%2FV1.0.1_hakari/))

● 数据库版本迁移框架： [flyway](https://blog.csdn.net/qiuhao9527/article/details/81070482)

● 安全框架： [apache shiro](http://www.cnblogs.com/learnhow/p/5694876.html)(采用的是Redis单点登录框架，支持集群Session)

● 缓存框架： redis

● 参数校验框架： JSR-303 验证框架(基于Hibernate Validation)

● 日志框架： [logback](https://www.cnblogs.com/lixuwu/p/5804793.html)(可无缝更换为log4j2等框架)

● 测试框架： Spring Boot Test(基于Junit 4)

● 工具类： [Apache commons-lang3](https://blog.csdn.net/f641385712/article/details/82468927)， [Google Guava](https://blog.csdn.net/songjinbin/article/details/50199649)，Hutool，easyexcel等

● 热部署工具： spring-boot-devtools/Spring Loaded

● 代码简化工具： [Lombok](https://jingyan.baidu.com/article/0a52e3f4e53ca1bf63ed725c.html)(需要在IDEA或者Eclipse中安装插件)

● 代码生成工具： mybatis-generator/[mybatis-generator-gui](https://github.com/zouzg/mybatis-generator-gui)

● 代码扫描工具： [Alibaba Java Coding Guidelines](https://blog.csdn.net/a15223142645/article/details/83088725)(强烈推荐，需要在IDEA或者Eclipse中安装插件)


## 开源组件介绍
### mybatis代码生成工具
#### mybatis-generator(已集成，不推荐使用)
官方自动代码生成工具，可生成xml，dao，实体类，idea中可点击Plugins下的mybatis-generator运行，配置文件在resources/mybatis-generator/generatorConfig.xml。
需要手动下载数据库连接库，如mysql-connector-java-5.1.47.jar,然后配置generatorConfig中jar包位置
#### mybatis-generator-gui(基于mybatis generator开发，带界面，推荐使用)
使用说明：  
```text
    git clone https://github.com/zouzg/mybatis-generator-gui
    cd mybatis-generator-gui
    mvn jfx:jar
    cd target/jfx/app/
    java -jar mybatis-generator-gui.jar
```
参见[官方文档](https://github.com/zouzg/mybatis-generator-gui/wiki/Usage-Guide)


### Hutool
#### Hutool介绍
一个Java基础工具类，对文件、流、加密解密、转码、正则、线程、XML等JDK方法进行封装，组成各种Util工具类，同时提供以下组件：
* hutool-aop JDK动态代理封装，提供非IOC下的切面支持
* hutool-bloomFilter 布隆过滤，提供一些Hash算法的布隆过滤
* hutool-cache 缓存
* hutool-core 核心，包括Bean操作、日期、各种Util等
* hutool-cron 定时任务模块，提供类Crontab表达式的定时任务
* hutool-crypto 加密解密模块
* hutool-db JDBC封装后的数据操作，基于ActiveRecord思想
* hutool-dfa 基于DFA模型的多关键字查找
* hutool-extra 扩展模块，对第三方封装（模板引擎、邮件等）
* hutool-http 基于HttpUrlConnection的Http客户端封装
* hutool-log 自动识别日志实现的日志门面
* hutool-script 脚本执行封装，例如Javascript
* hutool-setting 功能更强大的Setting配置文件和Properties封装
* hutool-system 系统参数调用封装（JVM信息等）
* hutool-json JSON实现
* hutool-captcha 图片验证码实现

#### 使用方法
默认已集成，可点击参见官方[wiki](http://hutool.mydoc.io/undefined#text_319377)

### easyexcel 
#### easyexcel介绍
JAVA解析及生成Excel工具。  
Java解析、生成Excel比较有名的框架有Apache poi、jxl。但他们都存在一个严重的问题就是非常的耗内存，poi有一套SAX模式的API可以一定程度的解决一些内存溢出的问题，但POI还是有一些缺陷，比如07版Excel解压缩以及解压后存储都是在内存中完成的，内存消耗依然很大。easyexcel重写了poi对07版Excel的解析，能够原本一个3M的excel用POI sax依然需要100M左右内存降低到KB级别，并且再大的excel不会出现内存溢出，03版依赖POI的sax模式。在上层做了模型转换的封装，让使用者更加简单方便。
#### 使用方法
参见[https://www.jianshu.com/p/3a64ade57bf2](https://www.jianshu.com/p/3a64ade57bf2)


### swagger
#### swagger2 注解说明
* @Api：用在请求的类上，表示对类的说明
```
    tags="说明该类的作用，可以在UI界面上看到的注解"
    value="该参数没什么意义，在UI界面上也看到，所以不需要配置"
    示例：
    @Api(tags="APP用户注册Controller")
```

* @ApiOperation：用在请求的方法上，说明方法的用途、作用
```
    value="说明方法的用途、作用"
    notes="方法的备注说明"
    示例：
    @ApiOperation(value="用户注册",notes="手机号、密码都是必输项，年龄随边填，但必须是数字")
```
* @ApiImplicitParams：用在请求的方法上，表示一组参数说明
* @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
```
        name：参数名
        value：参数的汉字说明、解释
        required：参数是否必须传
        paramType：参数放在哪个地方
            · header --> 请求参数的获取：@RequestHeader
            · query --> 请求参数的获取：@RequestParam
            · path（用于restful接口）--> 请求参数的获取：@PathVariable
            · body（不常用）
            · form（不常用）    
        dataType：参数类型，默认String，其它值dataType="Integer"       
        defaultValue：参数的默认值
        示例：
        @ApiImplicitParams({
            @ApiImplicitParam(name="mobile",value="手机号",required=true,paramType="form"),
            @ApiImplicitParam(name="password",value="密码",required=true,paramType="form"),
            @ApiImplicitParam(name="age",value="年龄",required=true,paramType="form",dataType="Integer")
        })
```


* @ApiResponses：用在请求的方法上，表示一组响应
* @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
```
        code：数字，例如400
        message：信息，例如"请求参数没填好"
        response：抛出异常的类
        
        @ApiOperation(value = "select1请求",notes = "多个参数，多种的查询参数类型")
        @ApiResponses({
            @ApiResponse(code=400,message="请求参数没填好"),
            @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对")
        })
```
* @ApiModel：用于响应类上，表示一个返回响应数据的信息
            （这种一般用在post创建的时候，使用@RequestBody这样的场景，
            请求参数无法使用@ApiImplicitParam注解进行描述的时候）
* @ApiModelProperty：用在属性上，描述响应类的属性

### flyway
#### flyway说明
* 数据库版本管理工具
#### Flyway 的工作原理
* flyway 需要在 DB 中先创建一个 metdata 表 (缺省表名为 flyway_schema_history), 在该表中保存着每次 migration 的记录, 记录包含 migration 脚本的版本号和 SQL 脚本的 checksum 值. 当一个新的 SQL 脚本被扫描到后, Flyway 解析该 SQL 脚本的版本号, 并和 metadata 表已 apply 的的 migration 对比, 如果该 SQL 脚本版本更新的话, 将在指定的 DB 上执行该 SQL 文件, 否则跳过该 SQL 文件.
#### flyway SQL脚本命名规则
```
prefix: 可配置，前缀标识，默认值 V 表示 Versioned, R 表示 Repeatable
version: 标识版本号, 由一个或多个数字构成, 数字之间的分隔符可用点.或下划线_
separator: 可配置, 用于分隔版本标识与描述信息, 默认为两个下划线__
description: 描述信息, 文字之间可以用下划线或空格分隔
suffix: 可配置, 后续标识, 默认为.sql

* 命名示例：V1.0.0__Init_Database.sql
* 示例解析：
    V：prefix
    1.0.0：version，增加sql只需要增加版本即可，默认按照左匹配规则
    __：separator
    Init_Database：description
    .sql：suffix
```

#### flyway 最佳实践
```
1. SQL 的文件名
开发环境和生产环境的 migration SQL 不共用. 开发过程往往是多人协作开发, DB migration 也相对比较频繁, 所以 SQL 脚本会很多. 而生产环境 DB migration 往往由 DBA 完成, 每次升级通常需要提交一个 SQL 脚本.

(1). 开发环境 SQL 文件建议采用时间戳作为版本号. 
开发环境 SQL 文件建议采用时间戳作为版本号, 多人一起开发不会导致版本号争用, 同时再加上生产环境的版本号, 这样的话, 将来手工 merge 成生产环境 V1.2d migration 脚本也比较方便, SQL 文件示例:
V20180317.10.59__V1.2_Unique_User_Names.sql
V20180317.14.59__V1.2_Add_SomeTables.sql

(2). 生产环境 SQL 文件, 应该是手动 merge 开发环境的 SQL 脚本, 版本号按照正常的版本, 比如 V2.1.5_001__Unique_User_Names.sql

2. migration 后的SQL 脚本不应该再被修改.

3. spring.flyway.outOfOrder 取值 true /false
对于开发环境, 可能是多人协作开发, 很可能先 apply 了自己本地的最新 SQL 代码, 然后发现其他同事早先时候提交的 SQL 代码还没有 apply, 所以 开发环境应该设置 spring.flyway.outOfOrder=true, 这样 flyway 将能加载漏掉的老版本 SQL 文件; 而生产环境应该设置 spring.flyway.outOfOrder=false

4. 多个系统公用要 DB schema 
很多时候多个系统公用一个 DB schema , 这时候使用 spring.flyway.table 为不同的系统设置不同的 metadata 表, 缺省为 flyway_schema_history
```
### SpringBootTest单元测试
#### 为什么要写单元测试
* 可以避免测试点的遗漏，为了更好的进行测试，可以提高测试效率
* 可以自动测试，可以在项目打包前进行测试校验
* 可以及时发现因为修改代码导致新的问题的出现，并及时解决
#### 怎么编写单元测试类
* Spring Boot中单元测试类写在在src/test/java目录下，你可以手动创建具体测试类，如果是IDEA，则可以通过IDEA自动创建测试类，如下图，也可以通过快捷键⇧⌘T(MAC)或者Ctrl+Shift+T(Window)来创建，如下：

#### Junit基本注解介绍
```
@BeforeClass 在所有测试方法前执行一次，一般在其中写上整体初始化的代码

@AfterClass 在所有测试方法后执行一次，一般在其中写上销毁和释放资源的代码

@Before 在每个测试方法前执行，一般用来初始化方法（比如我们在测试别的方法时，类中与其他测试方法共享的值已经被改变，为了保证测试结果的有效性，我们会在@Before注解的方法中重置数据）

@After 在每个测试方法后执行，在方法执行完成后要做的事情

@Test(timeout = 1000) 测试方法执行超过1000毫秒后算超时，测试将失败

@Test(expected = Exception.class) 测试方法期望得到的异常类，如果方法执行没有抛出指定的异常，则测试失败

@Ignore(“not ready yet”) 执行测试时将忽略掉此方法，如果用于修饰类，则忽略整个类

@Test 编写一般测试用例

@RunWith 在JUnit中有很多个Runner，他们负责调用你的测试代码，每一个Runner都有各自的特殊功能，你要根据需要选择不同的Runner来运行你的测试代码。
```

### 热部署
#### 第1种：修改服务器配置，使得IDEA窗口失去焦点时，更新类和资源
菜单Run -> EditConfiguration , 然后配置指定服务器下，右侧server标签下on frame deactivation = Update classes and resource。  
优点：简单  
缺点：基于JVM提供的热加载仅支持方法块内代码修改，只有debug模式下，并且是在idea失去焦点时才会出发热加载，相对加载速度缓慢
#### 使用spring-boot-devtools

##### devtools的原理(基于类加载机制来实现热加载的)
深层原理是使用了两个ClassLoader，一个Classloader加载那些不会改变的类（第三方Jar包），另一个ClassLoader加载会更改的类，称为restart ClassLoader,这样在有代码更改的时候，原来的restart ClassLoader 被丢弃，重新创建一个restart ClassLoader，由于需要加载的类相比较少，所以实现了较快的重启时间。
##### 说明
1. devtools可以实现页面热部署（即页面修改后会立即生效，这个可以直接在application.properties文件中配置spring.thymeleaf.cache=false来实现），
实现类文件热部署（类文件修改后不会立即生效），实现对属性文件的热部署。
即devtools会监听classpath下的文件变动，并且会立即重启应用（发生在保存时机），注意：因为其采用的虚拟机机制，该项重启是很快的
2. 配置了true后在修改java文件后也就支持了热启动，不过这种方式是属于项目重启（速度比较快的项目重启），会清空session中的值，也就是如果有用户登陆的话，项目重启后需要重新登陆。
3. 默认情况下，/META-INF/maven，/META-INF/resources，/resources，/static，/templates，/public这些文件夹下的文件修改不会使应用重启，但是会重新加载（devtools内嵌了一个LiveReload server，当资源发生改变时，浏览器刷新）。
4. IDEA开启项目自动编译，进入设置，勾选 Compiler-Build Project automatically
   IDEA开启项目运行时自动make, ctrl + shift + alt + /,选择Registry,勾上 Compiler autoMake allow when app running
   
### 参数校验
#### JSR-303(Bean Validation)
在任何时候，当你要处理一个应用程序的业务逻辑，数据校验是你必须要考虑和面对的事情。应用程序必须通过某种手段来确保输入进来的数据从语义上来讲是正确的。  
Hibernate Validator 是 Bean Validation 的参考实现 . Hibernate Validator 提供了 JSR 303 规范中所有内置 constraint 的实现，除此之外还有一些附加的 constraint。
Spring Boot的Web模块默认已经引入，包名为javax.validation
##### 注解说明
###### 空检查
@Null            验证对象是否为null  
@NotNull      验证对象是否不为null, 无法查检长度为0的字符串  
@NotBlank    检查约束字符串是不是Null还有被Trim的长度是否大于0,只对字符串,且会去掉前后空格.  
@NotEmpty   检查约束元素是否为NULL或者是EMPTY.  

###### Booelan检查
@AssertTrue     验证 Boolean 对象是否为 true    
@AssertFalse    验证 Boolean 对象是否为 false    

###### 长度检查
@Size(min=, max=)       验证对象（Array,Collection,Map,String）长度是否在给定的范围之内  
@Length(min=, max=)   验证约束字符串是否包含在最小和最大之间。  

###### 日期检查
@Past        验证 Date 和 Calendar 对象是否在当前时间之前，验证成立的话被注释的元素一定是一个过去的日期  
@Future     验证 Date 和 Calendar 对象是否在当前时间之后，验证成立的话被注释的元素一定是一个将来的日期  
@Pattern   验证 String 对象是否符合正则表达式的规则，被注释的元素符合制定的正则表达式，regexp:正则表达式 flags: 指定 Pattern.Flag 的数组，表示正则表达式的相关选项。
###### 数值检查
建议使用在Stirng,Integer类型，不建议使用在 int 类型上，因为表单值为 空 时无法转换为 int，  
@Min                 验证 Number 和 String 对象是否大等于指定的值  
@Max                验证 Number 和 String 对象是否小等于指定的值  
@DecimalMax  被标注的值必须不大于约束中指定的最大值. 这个约束的参数是一个通过BigDecimal定义的最大值的字符串表示.小数存在精度（ Double, float, BigDecimal ）
@DecimalMin   被标注的值必须不小于约束中指定的最小值. 这个约束的参数是一个通过BigDecimal定义的最小值的字符串表示.小数存在精度
@Digits              验证 Number 和 String 的构成是否合法  
@Digits(integer=,fraction=)   验证字符串是否是符合指定格式的数字，interger指定整数精度，fraction指定小数精度。  
@Range(min=, max=)          被指定的元素必须在合适的范围内  
@Range(min=10000,max=50000,message=”range.bean.wage”)  
@Valid      递归的对关联对象进行校验, 如果关联对象是个集合或者数组,那么对其中的元素进行递归校验,如果是一个map,则对其中的值部分进行校验.(是否进行递归验证)
@CreditCardNumber        信用卡验证  
@Email        验证是否是邮件地址，如果为null,不进行验证，算通过验证。  
@ScriptAssert(lang= ,script=, alias=)   
@URL(protocol=,host=, port=,regexp=, flags=)   

#### 如何使用 
在请求的实体类的属性上使用上述注解，在controller层的方法参数上使用@Validated注解即可,可参考BlackController下的listByPage方法。针对实体类中如有List<User>这种类型，添加@valid注解。