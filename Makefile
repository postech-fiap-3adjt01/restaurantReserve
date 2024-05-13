
build:
	mvn compile

unit-test:
	mvn test

integration-test:
	nvm test -P integration-test

system-test:
	nvm test -P system-test

performace-test:
	nvm gatling:test -P perfoemace-test

test: unit-test integration-test

package:
	nvm package

docker-build: package
	docker build -t backend:dev -f ./Dockerfile .

docker-start:
	docker compose -f docker-compose.yaml up -d