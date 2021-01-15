.PHONY: pycheck
pycheck: 
	pycodestyle --max-line-length=120 --ignore W391,E121,E123,E126,E226,E24,E704,W503,W504 analyze_logs.py
.PHONY: pylint
pylint:
	pylint -E analyze_logs.py


.PHONY: test
test: test/logs-test.csv pycheck pylint
	@rm -f ./test/logs-test.json
	./analyze_logs.py -n 2 --dns -i ./test/logs-test.csv | tee /tmp/f1
	./analyze_logs.py -n 2 --dns -i ./test/logs-test.json | tee /tmp/f2
	diff -u /tmp/f1 /tmp/f2
	@rm -f /tmp/f1 /tmp/f2
