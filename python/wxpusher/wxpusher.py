#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
File: wxpusher.py
Author: huxuan
Email: i(at)huxuan.org
Description: WxPusher Python Client.
"""
import requests

from . import exceptions

BASEURL = 'http://wxpusher.zjiecode.com/api'


class WxPusher():
    """WxPusher Python Client."""
    def __init__(self, default_token=None):
        """Initialization of WxPusher Client."""
        self.default_token = default_token

    def send_message(self, content, uids, **kwargs):
        """Send Message."""
        token = kwargs.get('token') or self.default_token
        if not token:
            raise exceptions.WxPusherNoneTokenException()

        payload = {
            'appToken': token,
            'content': content,
            'contentType': kwargs.get('content_type', 1),
            'topicIds': kwargs.get('topic_ids', []),
            'uids': uids,
            'url': kwargs.get('url')
        }
        print(payload)
        url = f'{BASEURL}/send/message'
        return requests.post(url, json=payload).json()
