# WxPusher

[![PyPI version](https://badge.fury.io/py/wxpusher.svg)](https://badge.fury.io/py/wxpusher)

WxPusher Python client.

## Getting Started

### Installation

```shell
pip install -U wxpusher
```

### Usage

```python
from wxpusher import WxPusher
WxPusher.send_message('content', '<uids>', '<appToken>')
# Replace <uids> and <appToken> with the actual `uids` and `appToken`, note that `uids` should be a list.
```

## Running the tests

### Setup configuration

Configuration is necessary since the tests depend on VALID `appToken` and `uids`.

Frist, copy the configuration sample `config.sample.py` under `python/wxpusher/tests/` to `config.py`

```shell
cd python/wxpusher/tests
cp config.sample.py config.py
```

Then, fill in the corresponding information in `config.py`.

### Trigger the tests

With proper configuration, you can run the tests with tox

```shell
tox
```

or nose directly

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
