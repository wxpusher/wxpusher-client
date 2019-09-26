package test

import (
	"github.com/tmaize/wxpusher-client/go/wxpusher"
	"testing"
)

func TestSendMessageError(t *testing.T) {
	message := wxpusher.Message{}
	t.Log(message.Send())
	message.AppToken = "testToken"
	t.Log(message.Send())
	message.ContentType = wxpusher.ContentText
	t.Log(message.Send())
	message.Content = "testContent"
	t.Log(message.Send())
	message.AddUId("testUId")
	t.Log(message.Send())
}

func TestSendMessage(t *testing.T) {
	appToken := "AT_*********"
	uId := "UID_********"
	result, err := wxpusher.NewMessage(appToken).SetContent("文本消息").AddUId(uId).Send()
	if err != nil {
		t.Fatal(err)
	}
	t.Log(result)
}
