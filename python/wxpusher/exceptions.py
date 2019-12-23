#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
File: exceptions.py
Author: huxuan
Email: i(at)huxuan.org
Description: WxPusher Exceptions.
"""


class WxPusherException(Exception):
    """WxPusher specific base exception."""


class WxPusherNoneTokenException(WxPusherException):
    """Raised when both token and default token are None"""
