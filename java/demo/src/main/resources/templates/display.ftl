<!DOCTYPE html>
<html>
<head lang="en">
  <meta charset="UTF-8"/>
  <meta name="keywords" content="微信推送,推送服务,WxPusher,消息提醒,免费推送">
  <meta name="description" content="微信消息实时推送服务[WxPusher]，可以通过API实时给个人微信推送消息。">
  <title>WxPusher-消息推送服务-演示程序</title>
  <style>
    .main {
      margin: 0 auto;
      width: 80%;
      display: flex;
      flex-direction: column;
      align-items: center;
    }

    .target {
      display: flex;
      flex-direction: row;
      justify-content: space-around;
      margin-top: 10px;
      margin-bottom: 10px;
    }

    .target a {
      font-size: 15px;
      color: #42b983;
      margin-left: 10px;
      margin-right: 10px;
    }

    .qrcode {
      width: 150px;
    }

    .link {
      color: #42b983;
      margin-left: 10px;
      cursor: pointer;
    }

    .line {
      display: flex;
      flex-direction: row;
      margin-bottom: 10px;
      padding-top: 10px;
    }

    .send {
      display: flex;
      flex-direction: column;
      margin-left: 25px;
    }

    .input {
      width: 100%;
      padding: 5px;
      height: 100px;
      margin-top: 10px;
      margin-bottom: 10px;
      outline: none;
      font-size: 15px;
      border-radius: 5px;
      border-color: #cccccc;
      border-style: solid;
    }

    .input:focus {
      border-style: solid;
      border-color: #42b983;
      border-radius: 5px;
      animation: glow 1000ms ease-out infinite alternate;
    }

    @keyframes glow {
      0% {
        border-color: #cccccc;
        box-shadow: rgba(66, 185, 131, .2);
      }
      100% {
        border-color: #42b983;
        box-shadow: 0 0 8px rgba(66, 185, 131, 0.8);
      }


  </style>
</head>
<body>
<div class="main">
  <h2>WxPusher 演示程序</h2>
  <span>使用WxPusher免费推送消息到个人微信上，更快更便捷。</span>
  <div class="target">
    <a target="_blank" href="/admin">管理后台</a> <a target="_blank" href="/docs">开发文档</a> <a target="_blank" href="https://github.com/zjiecode/wxpusher-client">开发SDK和Demo</a>
  </div>
  <img class="qrcode" src="${qrcodeUrl}"/>
  <div>
    <p id="step-1">1、请使用微信扫描上方二维码获取你的UID；</p>
    <p>2、发送消息：</p>
    <div class="send">
      <div>
        2.1、快捷发送<span style="color: #cccccc;font-size: 12px">(点击即可发送测试消息)</span>
      </div>
      <div class="line">
        <span class="link" id="send-text">发送文本消息</span><span class="link" id="send-html">发送HTML消息</span><span class="link"
                                                                                                              id="send-markdown">发送Markdown消息</span>
      </div>
      2.2、发送自定义消息
      <textarea class="input" placeholder="请输入你要发送的内容" id="input"></textarea>
      <span class="link" style="align-self: flex-end;" id="send-custom">发送消息</span>
    </div>
  </div>
</div>
</body>
</html>
<script src="https://unpkg.com/flyio/dist/fly.min.js"></script>
<script>
    var fly = new Fly;
    var uid;
    var interval = setInterval(function () {
        fly.get('/demo/getuid/${qrcodeId}')
        .then(function (response) {
            console.log(response.data.msg);
            if (response.data.data) {
                clearInterval(interval)
                uid = response.data.data;
                console.log("获取到UID：" + uid)
                var uidDom = document.getElementById("step-1");
                uidDom.innerText = "1、获取UID成功，你的UID为：" + uid
                uidDom.setAttribute("style", "color:#42b983");
            }
        }).catch(function (error) {
            console.log(error);
        })
    }, 2000);

    function send(type) {
        if (!uid) {
            alert("请先扫描二维码,获取你的UID");
            return;
        }
        fly.get('/demo/send/' + type + '/' + uid).then(function (response) {
            if (response.data.data) {
                //只有一个uid，直接取第0个的状态
                alert(response.data.data[0].status);
                return;
            } else {
                alert(response.data.msg);
            }
        })
        .catch(function (error) {
            alert(error);
            console.log(error);
        });
    }

    document.getElementById("send-text").addEventListener("click", function (ev) {
        send("text");
    })
    document.getElementById("send-html").addEventListener("click", function (ev) {
        send("html");
    })
    document.getElementById("send-markdown").addEventListener("click", function (ev) {
        send("markdown");
    })
    document.getElementById("send-custom").addEventListener("click", function (ev) {
        var text = document.getElementById("input").value;
        if (!text) {
            alert("发送内容不能为空");
            return;
        }
        fly.get('/demo/send/custom/' + uid, {content: text}).then(function (response) {
            if (response.data.data) {
                //只有一个uid，直接取第0个的状态
                alert(response.data.data[0].status);
                return;
            } else {
                alert(response.data.msg);
            }
        })
        .catch(function (error) {
            alert(error);
            console.log(error);
        });
    })

</script>
