# Makefile

.PHONY: build

run-dist: build test lint # Build & check whether works correctly

run: # Run app
	./build/install/app/bin/app

build: # Build app
	./gradlew clean
	./gradlew installDist

test: # Run tests
	./gradlew test

lint: # Check code style
	./gradlew checkstyleMain checkstyleTest

test-report: # Check code coverage
	./gradlew jacocoTestReport

