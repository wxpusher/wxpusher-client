#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
File: __init__.py
Author: huxuan
Email: i(at)huxuan.org
Description: Init for unittest.
"""
from . import exceptions

try:
    from . import config
except ImportError:
    raise exceptions.WxPusherTestNoConfigException

__all__ = ['config']
