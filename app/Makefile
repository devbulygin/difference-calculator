run-dist:
	./build/install/app/bin/app ./src/test/resources/fixtures/file1.json ./src/test/resources/fixtures/file2.json

run-dist2:
	./build/install/app/bin/app ./src/test/resources/fixtures/filepath1.yml ./src/test/resources/fixtures/filepath2.yml

run-dist3:
	./build/install/app/bin/app ./src/test/resources/fixtures/file3.json ./src/test/resources/fixtures/file4.json

clean-run: clean-install run-dist


clean-install:
	./gradlew clean installDist


install:
	./gradlew clean install


build:
	./gradlew clean build



test:
	./gradlew test

report:
	./gradlew jacocoTestReport


.PHONY: build