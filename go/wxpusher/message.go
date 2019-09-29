package wxpusher

// private contentType 消息内容类型
type contentType int

const ContentText = contentType(1)
const ContentHtml = contentType(2)
const ContentMarkdown = contentType(3)

// Message 消息结构体
type Message struct {
	AppToken    string      `json:"appToken"`
	Content     string      `json:"content"`
	ContentType contentType `json:"contentType"`
	TopicIds    []int       `json:"topicIds"`
	UIds        []string    `json:"uids"`
	Url         string      `json:"url"`
}

func NewMessage(appToken string) *Message {
	return &Message{
		AppToken:    appToken,
		ContentType: ContentText,
	}
}

func (m *Message) SetContentType(ct contentType) *Message {
	m.ContentType = ct
	return m
}

func (m *Message) SetContent(content string) *Message {
	m.Content = content
	return m
}

func (m *Message) SetUrl(url string) *Message {
	m.Url = url
	return m
}

func (m *Message) AddUId(id string, more ...string) *Message {
	m.UIds = append(m.UIds, id)
	m.UIds = append(m.UIds, more...)
	return m
}

func (m *Message) AddTopicId(id int, more ...int) *Message {
	m.TopicIds = append(m.TopicIds, id)
	m.TopicIds = append(m.TopicIds, more...)
	return m
}

func (m Message) Send() (SendResult, error) {
	return SendMessage(m)
}
