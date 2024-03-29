# Bus Ticketing System RESTful API

This is a simple RESTful API for a bus ticketing system I did to practice my API development skills. This is intended to be used for a frontend which I plan to develop in the future.
<div align="left">
  
  ![IntelliJ IDEA](https://img.shields.io/badge/IntelliJ_IDEA-000000.svg?style=for-the-badge&logo=intellij-idea&logoColor=white)
  ![MySQL](https://img.shields.io/badge/MySQL-005C84?style=for-the-badge&logo=mysql&logoColor=white)
  ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white)
  ![Spring Boot](https://img.shields.io/badge/Spring_Boot-F2F4F9?style=for-the-badge&logo=spring-boot)
  ![VSCode](https://img.shields.io/badge/VSCode-0078D4?style=for-the-badge&logo=visual%20studio%20code&logoColor=white)

</div>


## Steps to Setup
Instructions format copied from https://github.com/osopromadze/Spring-Boot-Blog-REST-API

**1. Clone the application**

```bash
git clone https://github.com/Adr029/busticketing-api.git
```

**2. Create MySQL database**
```bash
mysql -u your_username -p -e "CREATE DATABASE busreservationdatabase;"
```
- schema is provided in `src/main/resources/schema.sql`
- sample data is provided in `src/main/resources/data.sql`


**3. Change MySQL username and password as per your installation**

+ open `src/main/resources/application.properties`
+ change `spring.datasource.username` and `spring.datasource.password` as per your MySQL installation

**4. Run the app using maven**

```bash
mvn spring-boot:run
```
The app will start running at <http://localhost:8080>

## API Endpoints

The endpoints are currently simple and has limited features. I plan to expand them in the future.


### Admin Methods

| Method | Url | Description | Request Parameters|
| ------ | --- | ---------- | -----------------|
| GET  | /admin/login | Login admin credentials | 'username' String <br> 'password' String
| GET  | /admin/logout | Logout of admin functionalities | 
| GET  | /admin/displaytrips | Display all available trips | 
| GET  | /admin/displayreservations | Display all reserved trips | 


### Reservation Methods

| Method | Url | Description | Request Parameters| Request Body |
| ------ | --- | ---------- | -----------------| ---------------|
| GET  | /trips/{origin}/{destination} | Display trips from specified origin to destination on specified date | 'departureDate' String |
| POST | /trips/{origin}/{destination}/book | Book a trip | 'selectedTrip' int | [JSON](#booktrip)


### Verification Methods

| Method | Url | Description | Request Parameters| Request Body |
| ------ | --- | ---------- | -----------------| ---------------|
| GET  | /verify/{ticketnumber} | Verify customer booking | 'lastName' String |
| PATCH | /verify/{ticketnumber}/rebook | Rebook ticket| 'date' String  <br>'time' String <br>'newTripId' int | 
| DELETE | /verify/{ticketnumber}/cancel | Cancel booking|  

### Example Request Body

##### <a id="booktrip">Book Trip -> /trips/{origin}/{destination}/book</a>

**Sample Path Variables:**
- `{origin}`: cubao
- `{destination}`: baguio
```json
{
  "quantity": 3,
  "firstName": "John",
  "lastname": "Doe",
  "notes": "Special request",
  "date": "2022-01-15",
  "time": "14:30:00"
}

```

