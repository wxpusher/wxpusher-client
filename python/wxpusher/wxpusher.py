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
    default_token = None

    @classmethod
    def send_message(cls, content, uids, token=None, **kwargs):
        """Send Message."""
        token = token or cls.default_token
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
        url = f'{BASEURL}/send/message'
        return requests.post(url, json=payload).json()
