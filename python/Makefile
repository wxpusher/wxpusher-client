.PHONY: clean deps lint pycodestyle pyflakes pylint test

clean:
	find . -name '*.pyc' -print0 | xargs -0 rm -f
	find . -name '*.swp' -print0 | xargs -0 rm -f
	find . -name '__pycache__' -print0 | xargs -0 rm -rf
	-rm -rf build dist *.egg-info .eggs .tox *.spec

deps:
	pip install -r requirements.txt

install:
	python setup.py install

lint: pycodestyle pyflakes pylint

pycodestyle:
	-pycodestyle wxpusher

pyflakes:
	-pyflakes wxpusher

pylint:
	-pylint wxpusher

test:
	tox
