# Basic Web Application
Based on Spring in Action 4

### Spring on Web
* Spring MVC
* How to take model data produced in controllers and render it as HTML
* JSP (JavaServer Page), Apache Tiles, Thymeleaf template for rendering
* Some advanced techniques to use when building web application
  - Custom Spring MVC configuration options
  - Handling multipart file uploads
  - Dealing with exceptions
  - Passing data across requests using flash attributes
* Spring Web Flow
* Spring Security

##### Life of a request
1. Send request to DispatcherServlet
2. Handling Mapping: figure out appropriate controller
3. Send request to the controller (get payloads and process the information)
4. Send model and view name to DispatcherServlet
5. Consult a view resolver to map the logical view name to a specific view implementation
6. View implementation is the next stop
7. Response object

##### Spittr application
* Simple Micro-blogging application 
* Two essential domain concepts:
  - Spitters: the users of the application
  - Spittles: the brief status updates that users publish

### Configure Tomcat:
Follows the guide in the link: https://www.jetbrains.com/help/idea/configuring-and-managing-application-server-integration.html
* Download Apache Tomcat
* Define a server (Tomcat in the case) in the Settings dialog 
* Click on box on the left of run icon
* Choose Edit Configurations...
* Click "+" button to add new configuration
* Choose Tomcat, local
* Switch to Deployment tab, add "exploded" version
* Change name to Tomcat and then press OK to apply configuration
* Press Run and open localhost:8080 to access the application

### Take note about Core Spring
* A framework - provide a standard way to build and deploy application
* Spring container: application context or bean factories
  - Creates objects
  - Wires them together
  - Configures them
  - Manages their complete lifecycle
* XML configuration or Java-based configuration
* Application context loads beans definitions and wires them together
  - Various type based on how it loads its configuration
  - AnnotationConfigApplicationContext: Loads a Spring application context
  from one or more Java-based configuration classes
  - AnnotationConfigWebApplicationContext: Loads a Spring web application
  context from one or more Java-based configuration classes
  - ClassPathXmlApplicationContext: Loads a context definition from one or
  more XML files located in the classpath, treating context-definition files as classpath resources
  - FileSystemXmlApplicationContext: Loads a context definition from one or
  more XML files in the filesystem
  - XmlWebApplicationContext: Loads context definitions from one or more
  XML files contained in a web application
* Dependency Injection (DI)
  - Benefits: loose coupling
* Template to eliminate boilerplate
* Spring modules:
  - Data access & integration:
    + JDBC
    + OXM
    + Transaction
    + Messaging
    + ORM
    + JMS
  - Web and remoting
    + Web
    + Web servlet
    + Web portlet
    + WebSocket
  - Aspect-oriented programming
    + AOP
    + Aspects
  - Instrumentation
    + Instrument
    + Instrument Tomcat
  - Core Spring container
    + Beans
    + Core
    + Context
    + Expression
    + Context support
  - Testing
    + Test
* String portfolio:
  - Spring Web Flow
  - Spring Web Service
  - Spring Security
  - Spring Integration
  - Spring Batch
  - Spring Data
  - Spring Social
  - Spring Mobile
  - Spring For Android
  - Spring Boot
* Automatically wiring beans
  - Component scanning
  - Autowiring
* Annotation
  - @Bean(name): declare a Bean
  - @Primary: default bean
  - @Qualifier(string)
  - @Component(name): declare a Component (a type of Bean)
  - @Controller: declare a Controller (based on @Component)
  - @Configuration: configuration class
  - @ComponentScan(basePackages = {strings or classes}): scan the same package
  - @Autowired: 
  - @ContextConfiguration(class = ...config.class) - test support
  - @RunWith(SpringJUnit4ClassRunner.class) - test support
  - @Profile(env): declare profile environment (class or method level)
  - @ActiveProfiles(env)
  - @Conditional(class): implement child of Condition interface
  ```
  boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata);
  ```
  - @PropertySource("classpath:.../app.properties")
  - @Scope(): config scope of bean
    + Singleton
    + Prototype
    + Session
    + Request
  
  
   
