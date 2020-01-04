#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
File: setup.py
Author: huxuan
Email: i(at)huxuan.org
Description: Python packaging for wxpusher.
"""
from setuptools import setup

CLASSIFIERS = [
    'Development Status :: 4 - Beta',
    'Intended Audience :: Developers',
    'License :: OSI Approved :: Apache Software License',
    'Programming Language :: Python :: 3',
    'Programming Language :: Python :: 3 :: Only',
    'Topic :: Utilities'
]

INSTALL_REQUIRES = [
    'requests'
]

DEV_REQUIRES = [
    'pycodestyle',
    'pyflakes',
    'pylint'
]

TEST_REQUIRES = [
    'coverage',
    'nose'
]

EXTRAS_REQUIRE = {
    'dev': DEV_REQUIRES,
    'test': TEST_REQUIRES
}

DESCRIPTION = (
    'WxPusher Python Client.'
)


def readme():
    """Parse README for long_description."""
    with open('README.md') as fin:
        return fin.read()


setup(name='wxpusher',
      version='0.0.4',
      description=DESCRIPTION,
      long_description=readme(),
      long_description_content_type='text/markdown',
      classifiers=CLASSIFIERS,
      keywords='wxpusher wechat push-notification',
      url='https://github.com/huxuan/wxpusher-client',
      author='Xuan (Sean) Hu',
      author_email='i+wxpusher@huxuan.org',
      license='Apache License 2.0',
      packages=['wxpusher'],
      install_requires=INSTALL_REQUIRES,
      extras_require=EXTRAS_REQUIRE,
      python_requires='>=3',
      include_package_data=True)
