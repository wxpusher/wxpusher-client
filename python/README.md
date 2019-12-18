# WxPusher

WxPusher Python client.

## Getting Started

### Installation

```shell
pip install -U wxpusher
```

### Usage

```python
from wxpusher import WxPusher
wp = WxPusher('<appToken>')
# Replace <appToken> with the actual `appToken`.
wp.send_message('content', '<uids>')
# Replace <uids> with the actual `uids`, note that it should be a list.
```

## Running the tests

You can run the tests with tox

```shell
tox
```

or use nose directly

```shell
nosetests
```

## TODO

- [x] Basic structure with pypi uploaded.
- [x] Send Message.
- [ ] Query Message.
- [ ] Create QRCode.
- [ ] WxUser.
- [ ] Command line scripts.
- [ ] Better documentation.
- [ ] More robust unittest.

## Contribution

- Comments or suggestions via github issues.
- Pull requests are welcome absolutely.
