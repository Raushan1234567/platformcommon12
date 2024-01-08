# platformcommon12
<h3>Live server link:https://platformcommon12-production.up.railway.app/swagger-ui/index.html#/admin-controller/addRegister</h3>
<h1>Welcome here</h1>
<h2>Student Managemnt System</h2>
I designed a student management system that has two sides of functionality: the 'admin side' and the 'student side.' The admin is able to register students with their details, and students can update their information, leave the course, and also find topics

 <h2>Language used:java</h2> 

<h1>Project Technologies Used:</h1>
    <ul>
        <li>Spring Security</li>
        <li>Spring Boot</li>
        <li>Hibernate-JPA</li>
        <li>Swagger</li>
    </ul>

   <h1>Project Flow Overview:</h1>
    <ul>
        <li>Controller Layer
            <ul>
                <li>Receives HTTP requests</li>
                <li>Handles request parameters</li>
                <li>Invokes appropriate methods in the Service Layer</li>
                <li>Manages the flow of control</li>
                <li>Returns HTTP responses</li>
            </ul>
        </li>
        <li>Service Layer
            <ul>
                <li>Business logic implementation</li>
                <li>Interacts with the Repository Layer</li>
                <li>Performs data processing</li>
                <li>May involve transaction management</li>
            </ul>
        </li>
        <li>Repository Layer
            <ul>
                <li>Interacts with the database (MySQL)</li>
                <li>Executes database queries</li>
                <li>Performs CRUD operations</li>
                <li>Maps data between the database and the Entity</li>
            </ul>
        </li>
        <li>Entity (Database Model)
            <ul>
                <li>Represents the data structure in the database</li>
                <li>Defines the fields and relationships</li>
                <li>Mapped to database tables</li>
                <li>Used by the Repository Layer for database operations</li>
            </ul>
        </li>
    </ul>

Schema of my project





![Screenshot (384)](https://github.com/Raushan1234567/platformcommon12/assets/115460955/96903b92-b8b2-4b9f-8868-51a1ce01887d)
