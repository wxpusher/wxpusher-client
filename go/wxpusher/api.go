package wxpusher

import (
	"bytes"
	"encoding/json"
	"errors"
	"io/ioutil"
	"net/http"
	"strconv"
	"strings"
)

const UrlBase = "http://wxpusher.zjiecode.com"
const UrlSendMessage = UrlBase + "/api/send/message"
const UrlMessageStatus = UrlBase + "/api/send/query/${messageId}"

// VerifyMessage 消息参数验证
func VerifyMessage(message Message) error {
	if len(message.AppToken) == 0 {
		return NewBusinessError(errors.New("appToken不能为空"))
	}
	if message.ContentType == 0 {
		return NewBusinessError(errors.New("必须指定contentType"))
	}
	if len(message.Content) == 0 {
		return NewBusinessError(errors.New("content内容不能为空"))
	}
	if len(message.UIds) == 0 {
		return NewBusinessError(errors.New("必须添加uid"))
	}
	return nil
}

// SendMessage 发送消息
func SendMessage(message Message) (SendResult, error) {
	var result SendResult
	if VerifyMessage(message) != nil {
		return result, VerifyMessage(message)
	}
	requestBody, err := json.Marshal(message)
	if err != nil {
		return result, NewBusinessError(err)
	}
	resp, err := http.Post(UrlSendMessage, "application/json", bytes.NewReader(requestBody))
	if err != nil {
		return result, NewBusinessError(err)
	}
	defer resp.Body.Close()
	respBody, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		return result, NewBusinessError(err)
	}
	err = json.Unmarshal(respBody, &result)
	if err != nil {
		return result, NewBusinessError(err)
	}
	return result, result.Error()
}

// QueryMessageStatus 查询消息发送状态
func QueryMessageStatus(messageId int) (QueryResult, error) {
	var result QueryResult
	url := strings.ReplaceAll(UrlMessageStatus, "${messageId}", strconv.Itoa(messageId))
	resp, err := http.Get(url)
	if err != nil {
		return result, NewBusinessError(err)
	}
	defer resp.Body.Close()
	respBody, err := ioutil.ReadAll(resp.Body)
	if err != nil {
		return result, NewBusinessError(err)
	}
	err = json.Unmarshal(respBody, &result)
	if err != nil {
		return result, NewBusinessError(err)
	}
	return result, result.Error()
}
