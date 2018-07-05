This is the Web Calculator REST API that exposes the seven most used mathematical operations as REST web services, through the use of Spring Boot libraries and configurations.
The necessary conditions to run this applications are as follows:

1. Make sure you have Java 8 installed
2. Locate the JAR file named WebCalculator-v1.0.jar
3. Run it with the following command:
   java -jar -Xms256m -Xmx256m -Dspring.profiles.active=dev WebCalculator-v1.0.jar
   This way we avoid garbage collections in a frecuent fashion as the heap does not need to grow beyond the max heap size.
4. For other environments, aka, dev o staging, you can use:
   java -jar -Xms32m -Xmx32m -Dspring.profiles.active=prod WebCalculator-v1.0.jar
   This way we avoid garbage collections in a frecuent fashion as the heap does not need to grow beyond what a Vanilla Spring Boot app needs to.
5. Navigate to http://localhost:8080/swagger-ui.html
6. You will find there the entire API endpoint specification inside a dashboard that lets you test the endpoints with the required arguments
7. You can also navigate to http://localhost:8080/webcalculator/v1/ or directly use the following endpoints:
   - http://localhost:8080/webcalculator/v1/add/double/double/double -- the last two, optional
   - http://localhost:8080/webcalculator/v1/subtract/double/double/double -- the last two, optional
   - http://localhost:8080/webcalculator/v1/multiply/double/double/double -- the last two, optional
   - http://localhost:8080/webcalculator/v1/divide/long/long
   - http://localhost:8080/webcalculator/v1/power/long
   - http://localhost:8080/webcalculator/v1/square/double
   - http://localhost:8080/webcalculator/v1/percentage/double/double

QUALITY ATTRIBUTES AND HA DEPLOYMENT CONSIDERATIONS:   
For a business-critical app as this, it is necessary to guarantee availability, scalability and resilience. For these, a load balancer configured, for instance, in Nginx, could be placed in front of 2 or 3 nodes (like AWS instances). This same architecture could be places in another 3 or 4 instances (1 load balancer and 2 or 3 nodes running the above mentioned JAR file) in a different region or even different zone, so it is always available and scales up by simply creating more load-based instances based on an image that has already the JAR file in it. Resilience could be achieved through Hystrix, but for now, is achieved by the fact of stateless services that work in tandem with an infrastructure than could be enhanced with an orquestration management solution like Kubernetes.
Various lines of improvement could be thought of after an initial deployment in production, like types of memories for calculations, more mathematical functions in the form of different services that can be "weaved" together with a configuration server, and Eureka for service registration and discovery together with Redis for inter-service communication. Even Hystrix for service health monitoring and dependency management.

Spring Boot Caching comes with annotations that enable endpoints or resources like repositories, to cache results based on a unique key related to the parameters; so for pure functions like those implemented in the WebCalculator, the same inputs always are gonna return the same output, so recomputation is needed. This is achieved through Aspect Oriented Programming that advices before method invocation to see if the same arguments are given so the cached result is returned.