# Demo Application for DevOps Practice
*This repository is a copy of the* `HelloFrontController` *demo we recently delpoyed on an AWS EC2 Instance*.

<br>

1. Clone your personal repo onto your local machine and open it in your IDE.
2. Go to `connection.properties`.  Modify the `host` in the `JDBC URL` so that it reflects the endpoint to your RDS.
3. We will first build a test suite to test our service layer within the `src/test/java` folder.
5. After building the test suite, push all changes to this remore repository.

<br>

After setting up the test suite for our dummy application, we will add a Github webhook so that every time a change is pushed to the remote repo of this app, it will trigger a Jenkins Build Job that runs our tests. 🤖 

<br>

> *THIS IS CALLED **CONTINUOUS INTEGRATION***
