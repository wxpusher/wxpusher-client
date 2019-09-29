package wxpusher

import "fmt"

type Error struct {
	Code  int
	Title string
	Cause error
}

func (err Error) Error() string {
	return fmt.Sprintf("%d %s %s", err.Code, err.Title, err.Cause)
}

// NewError 创建新的异常
func NewError(code int, err error) error {
	var title string
	switch code {
	case 1001:
		title = "业务异常错误"
	case 1002:
		title = "未认证"
	case 1003:
		title = "签名错误"
	case 1004:
		title = "接口不存在"
	case 1005:
		title = "服务器内部错误"
	case 1006:
		title = "和微信交互的过程中发生异常"
	case 1007:
		title = "网络异常"
	case 1008:
		title = "数据异常"
	case 1009:
		title = "未知异常"
	default:
		title = "未知异常"
	}
	return Error{
		Code:  code,
		Title: title,
		Cause: err,
	}
}

// NewBusinessError 创建业务异常
func NewBusinessError(err error) error {
	return NewError(1001, err)
}
