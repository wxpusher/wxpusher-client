# WxPusher
微信消息实时推送服务[WxPusher]，可以通过API实时给个人微信推送消息.[http://wxpusher.dingliqc.com/](http://wxpusher.dingliqc.com/)

本功能会一直**免费提供**使用，并且**没有次数限制**，但是请注意，不要发送敏感词！！
# 使用说明
- 请关注微信公众号“开发者服务”(wxpusher)
- 点击菜单中的“我的ID”，获取到你的身份ID，请注意，此ID不能泄漏 ，否则别人可以随意给你发送消息。
- 使用API给微信推送消息。

更详细的使用说明，请在官网阅读 ，欢迎访问：[http://wxpusher.dingliqc.com/](http://wxpusher.dingliqc.com/)

# 调用SDK
为了方便集成和调用，节省大家事件，可以直接通过集成SDK的方式调用。

目前只封装了Java的SDK，其他语言请直接通过http调用，[API文档](http://wxpusher.dingliqc.com/#part-3)
## Java版本
[ ![version](https://img.shields.io/static/v1.svg?label=version&message=1.0.3&color=brightgreen) ](https://bintray.com/zjiecode/maven/wxpusher-client/1.0.0/link)

### gradle中使用

你需要添加Jcenter库，在“build.grade”中配置：
```groovy
dependencies {
    ......
    compile 'com.zjiecode:wxpusher-client:version'//使用上面的版本号
    ......
}
```

###  在maven中使用
在*pom.xml*文件中添加：
```xml
<dependency>
  <groupId>com.zjiecode</groupId>
  <artifactId>wxpusher-client</artifactId>
  <version>version</version>
  <type>pom</type>
</dependency>
```
最后可以在你需要的地方，直接调用方法，即可实时推送消息到微信上了，比如下面这样：
```java
//替换成你的userId,微信关注“wxpusher”可以获取你自己的id
WxPusher.send("这是一个测试消息","userId");
```
有没有很简单，一行代码即可。
当然，如果你要求稍微高一些，需要定制化一些东西，也可以使用复杂一点的API：
```java
List<String> ids = new ArrayList<>();
ids.add("userId");//替换成你的userId,微信关注“wxpusher”可以获取你自己的id
Map<String, MessageDataValueItem> data = new HashMap<>();
data.put("first", new MessageDataValueItem("标题", "#FF0000"));//字段内容和文字颜色
data.put("keyword1", new MessageDataValueItem("keyword1", "#000000"));
data.put("keyword2", new MessageDataValueItem("keyword2", "#000000"));
data.put("keyword3", new MessageDataValueItem("keyword3", "#000000"));
data.put("remark", new MessageDataValueItem("remark"));
Message message = new Message();
message.setUserIds(ids);
message.setData(data);
//模版ID在 http://wxpusher.dingliqc.com/#part-4 可以查看。
message.setTemplate_id("lpO9UoVZYGENPpuND3FIofNueSMJZs0DMiU7Bl1eg2c");
Result result = WxPusher.send(message);
if (result.isSuccess()) {
    //成功
    System.out.println("发送成功：" + result.getMsg());
} else {
    //失败
    System.out.println("发送失败：" + result.getMsg());
}

```

使用就是这么简单，有需要就看快来试试吧。