#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
File: test_send_message.py
Author: huxuan
Email: i(at)huxuan.org
Description: Unittest for querying message.
"""
import unittest
import random

from wxpusher import WxPusher


class TestQueryMessage(unittest.TestCase):
    """Unittest for querying message."""

    def test_query_message(self):
        """Positive case for querying message."""
        res = WxPusher.query_message(random.randint(1, 999999))
        self.assertIsInstance(res, dict)
        self.assertIn('code', res)
        self.assertEqual(1000, res['code'])
