#!/usr/bin/env python
# -*- coding: utf-8 -*-
"""
File: setup.py
Author: huxuan
Email: i(at)huxuan.org
Description: Python packaging for wxpusher.
"""
from setuptools import find_packages
from setuptools import setup

DESCRIPTION = (
    'WxPusher Python Client.'
)


def readme():
    with open('README.md') as fin:
        return fin.read()


setup(name='wxpusher',
      version='0.0.1',
      description=DESCRIPTION,
      long_description=readme(),
      long_description_content_type='text/markdown',
      classifiers=[
          'Development Status :: 3 - Alpha',
          'Intended Audience :: Developers',
          'License :: OSI Approved :: MIT License',
          'Programming Language :: Python :: 3',
          'Programming Language :: Python :: 3 :: Only',
          'Topic :: Utilities'
      ],
      keywords='wxpusher wechat push-notification',
      url='https://github.com/huxuan/wxpusher-client',
      author='Xuan (Sean) Hu',
      author_email='i@huxuan.org',
      license='MIT',
      packages=['wxpusher'],#find_packages(exclude=['tests']),
      install_requires=['requests'],
      test_suite='nose.collector',
      tests_require=['nose'],
      python_requires='>=3',
      include_package_data=True)
