#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
File: exceptions.py
Author: huxuan
Email: i(at)huxuan.org
Description: Custom exceptions for unittest.
"""
from wxpusher import WxPusherException


class WxPusherTestNoConfigException(WxPusherException):
    """Raised when no unittest configuration exists."""
