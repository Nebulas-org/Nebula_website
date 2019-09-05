# nebulas
拾星云科技公司官网

[![996.icu](https://img.shields.io/badge/link-996.icu-red.svg)](https://996.icu) [![LICENSE](https://img.shields.io/badge/license-Anti%20996-blue.svg)](https://github.com/996icu/996.ICU/blob/master/LICENSE)

#### 项目介绍
拾星云公司官网主页,使用spring boot作为后台框架.

#### 软件架构
- 后台框架:Spring Boot 2.0.3.RELEASE
- 缓存:Redis
- 连接池:druid
- 接口调试:swagger
- 数据库:MySQL
- 数据库操作框架:mybatis-plus


#### 使用说明


下面这个是主页
![](https://i.imgur.com/ZI9WOrz.jpg)

下面这个是文章详情,花屏那张图其实是在播放视频,所以截图的时候看起来是花的
![](https://i.imgur.com/P8f9uLI.jpg)


管理系统:
![](https://i.imgur.com/Rw4KD33.jpg)
![](https://i.imgur.com/7BJ3ZuA.jpg)
![](https://i.imgur.com/RgG8EDv.jpg)
![](https://i.imgur.com/HtydCEJ.jpg)
![](https://i.imgur.com/cX2ZAjw.jpg)
![](https://i.imgur.com/OK0oqLP.jpg)

登陆调试注意：
- 后台登陆地址是:localhost:8080
- 后台的账号密码为--->**账号:18008085420	密码:123456**
- 登陆成功后，使用swagger调试后台接口
- swagger地址：localhost:8080/swagger-ui.html


数据表的id注意事项：
- 默认不传id，使用idwork默认生成19位Long类型id


redis，mysql配置说明:
- 详见application-dev.properties


首页大致框架图参考：
- Nebula_website\src\main\resources\static\images\首页框架图.jpg

问题建议:
- 内部联系
- 联系我的邮箱：280550256@qq.com