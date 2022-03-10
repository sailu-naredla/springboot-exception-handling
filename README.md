# springboot-exception-handling

Springboot provides us many ways to handle the exceptions and this Project covers below topics

1. Create new customer.

http://localhost:8080/api/customers/

POST

http://localhost:8080/api/customers/

Request:

{
    "name":"Demo Customer",
    "location":"Demo Location"
}

Response

{
    "id": 1,
    "name": "Demo Customer",
    "location": "Demo Location"
}



2. @ResponseStatus - access API using invalid Customer ID.

Allows us to modify the HTTP status of the response.

http://localhost:8080/api/customers/2

GET

Response:

{
    "timestamp": "2022-03-10T09:55:37.991+00:00",
    "status": 404,
    "error": "Not Found",
    "message": "Customer Not Found With ID 2",
    "path": "/api/customers/2"
}

3. @ExceptionHandler

Allows us to modify/customize the response filed names for specific controller method

4. @ControllerAdvice - Access PUT api with empty/null values for mandatory fields

Controller advice classes allow us to apply the exception handlers on one or all controllers of the application

http://localhost:8080/api/customers/

PUT

Request

{
    "id": 1,
    "name": "Demo Customer",
    "location": ""
}

Response

{
    "statusCode": 400,
    "timestamp": "2022-03-10T09:59:38.255+00:00",
    "message": "Customer location is missed",
    "description": "uri=/api/customers/"
}
