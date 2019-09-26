package test

import (
	"github.com/zjiecode/wxpusher-client/go/wxpusher"
	"testing"
)

func TestQueryMessage(t *testing.T) {
	messageId := 600
	result, err := wxpusher.QueryMessageStatus(messageId)
	if err != nil {
		t.Fatal(err)
	}
	t.Log(result)
}
