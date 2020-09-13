
1. Deoplyment instructions:
	1) Make sure docker is installed on the server
	2) In the root folder deploy the proejct with the following command 
	   - docker build -f Dockerfile -t xp-managment-docker . 
	   - docker-compose up
2. Test api with postman:
	1) Import postman collection under folder ./postmancollection
	2) Call api using postman
