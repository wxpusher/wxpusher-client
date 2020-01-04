#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
File: test_create_qrcode.py
Author: huxuan
Email: i(at)huxuan.org
Description: Unittest for creating qrcode.
"""
import unittest

from wxpusher import WxPusher

from . import config


class TestCreateQRCode(unittest.TestCase):
    """Unittest for creating qrcode."""

    @classmethod
    def setUpClass(cls):
        WxPusher.default_token = config.TOKEN

    def test_create_qrcode(self):
        """Positive case for creating qrcode."""
        res = WxPusher.create_qrcode(
            self.test_create_qrcode.__doc__
        )
        self.assertIsInstance(res, dict)
        self.assertIn('code', res)
        self.assertEqual(1000, res['code'])
