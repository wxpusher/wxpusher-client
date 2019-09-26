package wxpusher

import "errors"

// SendResult
type SendResult struct {
	Code int    `json:"code"`
	Msg  string `json:"msg"`
	Data []struct {
		Uid       string `json:"uid"`
		TopicId   string `json:"topicId"`
		MessageId int    `json:"messageId"`
		Code      int    `json:"code"`
		Status    string `json:"status"`
	} `json:"data"`
	Success bool `json:"success"`
}

// Error 判断结果是否异常
func (result *SendResult) Error() error {
	if result.Success {
		return nil
	}
	if result.Code == 1000 {
		return nil
	}
	if result.Code == 0 {
		return NewBusinessError(errors.New("解析返回数据失败"))
	}
	return NewError(result.Code, errors.New(result.Msg))
}

type QueryResult struct {
	Code    int    `json:"code"`
	Msg     string `json:"msg"`
	Data    int    `json:"data"`
	Success bool   `json:"success"`
}

func (result *QueryResult) Error() error {
	if result.Success {
		return nil
	}
	if result.Code == 1000 {
		return nil
	}
	if result.Code == 0 {
		return NewBusinessError(errors.New("解析返回数据失败"))
	}
	return NewError(result.Code, errors.New(result.Msg))
}
