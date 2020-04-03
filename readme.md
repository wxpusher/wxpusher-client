微信消息实时推送服务[WxPusher]，一个可以通过API实时给个人微信推送消实用服务。

# 1、WxPusher
微信消息实时推送服务[WxPusher]，可以通过API实时给个人微信推送消息，你可以点击这里使用Demo体验功能[http://wxpusher.zjiecode.com/demo](http://wxpusher.zjiecode.com/demo)。

**本仓库是WxPusher所有模块的汇总，你可以在这里找到所有WxPusher相关的文档和仓库。**

# 2、功能和规划
目前WxPusher已经支持的和计划支持的功能。

- [x] 消息单发（给单个人发送消息）
- [x] 消息群发（通过Topic主题推送）
- [x] 用户关注回调（用户关注以后回调UID）
- [x] 创建带参数的二维码（用于识别用户来源）
- [x] 查询消息发送状态
- [x] 查询关注应用的用户列表
- [ ] 添加消息摘要（较多用户反馈，内信和模版消息显示摘要即可，直接截取消息体验不好）
- [ ] 统计和显示topic的关注用户数量

# 3、平台介绍
## 3.1、功能演示Dome 
[http://wxpusher.zjiecode.com/demo](http://wxpusher.zjiecode.com/demo)

 这是采用Java开发的一个demo功能，集成了WxPusher，可以用来体验一下WxPusher的功能。本Dome的源代码你可以在[这里找到](https://github.com/wxpusher/wxpusher-sdk-java)，可以了解部分开发细节。

## 3.2、开发说明文档
[http://wxpusher.zjiecode.com/docs](http://wxpusher.zjiecode.com/docs)

这是WxPusher的功能说明文档，包括API接口介绍，使用流程等，如果多个文档有不一致的，以这个文档为准。

## 3.3、WxPusher管理后台
[http://wxpusher.zjiecode.com/admin](http://wxpusher.zjiecode.com/admin)

这是WxPusher的管理中心，你可以在这里创建你的应用，主题，参看WxPusher的使用数据等。使用WxPusher，必须现在这里创建应用 ，获取appToken。

# 4、调用方式
WxPusher目前的接入方式已经比家里完善了，你可以选择下面任意一种方式接入，各种SDK可能更新不够及时，以[接口说明文档](http://wxpusher.zjiecode.com/docs/#/?id=http%e8%b0%83%e7%94%a8)的接口描述为准。也欢迎你提交PR，一起完善WxPusher。

## 4.1、http接口调用
直接通过http调用，适用范围比较广，目前支持GET、POST2种调用方式，POST方式更加完善，推荐使用POST方式调用，具体可以参考[接口说明文档](http://wxpusher.zjiecode.com/docs/#/?id=http%e8%b0%83%e7%94%a8)

## 4.2、Java SDK
Java SDK是官方开发，稳定可靠，推荐使用。SDK地址在这里 [https://github.com/wxpusher/wxpusher-sdk-java](https://github.com/wxpusher/wxpusher-sdk-java)，参考说明使用。

## 4.3、Go SDK
Go SDK由 _@TMaize_ 等主要贡献，地址在这里 [https://github.com/wxpusher/wxpusher-sdk-go](https://github.com/wxpusher/wxpusher-sdk-go)，参考说明文档使用，也欢迎提交PR来完善。

## 4.4、Python SDK
Python SDK由 _@huxuan_ 等主要贡献，地址在这里 [https://github.com/wxpusher/wxpusher-sdk-python](https://github.com/wxpusher/wxpusher-sdk-python)，参考说明文档使用，也欢迎提交PR来完善。

## 4.5、PHP SDK
PHP SDK由 _@meloncn_ 等主要贡献，地址在这里 [https://github.com/wxpusher/wxpusher-sdk-php](https://github.com/wxpusher/wxpusher-sdk-php)，参考说明文档使用，也欢迎提交PR来完善。

