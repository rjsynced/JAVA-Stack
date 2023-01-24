## pom xml dependency
''' java
    <dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
			<scope>runtime</scope>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>com.mysql</groupId>
			<artifactId>mysql-connector-j</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-tomcat</artifactId>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
        	<groupId>org.springframework.boot</groupId>
        	<artifactId>spring-boot-starter-validation</artifactId>
    	</dependency>
    	<dependency>
        	<groupId>org.apache.tomcat.embed</groupId>
            <artifactId>tomcat-embed-jasper</artifactId>
        </dependency>
        <dependency>
			<groupId>javax.servlet</groupId>
			<artifactId>jstl</artifactId>
		</dependency>
	</dependencies>  
'''

## bootstrap
"""
        <dependency>
        	<groupId>org.webjars</groupId>
        	<artifactId>webjars-locator</artifactId>
        	<version>0.30</version>
    	</dependency>
    
    	<!-- BOOTSTRAP DEPENDENCIES -->
    	<dependency>
        	<groupId>org.webjars</groupId>
        	<artifactId>bootstrap</artifactId>
        	<version>5.0.1</version>
    	</dependency>
    	<dependency>
        	<groupId>org.webjars</groupId>
        	<artifactId>jquery</artifactId>
        	<version>3.6.0</version>
    	</dependency>

        // links for jsp for css
        <link rel="stylesheet" href="/css/style.css">
        <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
"""

## web-inf
'''
    // for every jsp file on top
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    // for form:form
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

    // for edit page
    <%@ page isErrorPage="true" %>
'''

## application properties
'''
    spring.mvc.view.prefix=/WEB-INF/

    spring.datasource.url=jdbc:mysql://localhost:3306/<<YOUR_SCHEMA>>
    spring.datasource.username=<<dbuser>>
    spring.datasource.password=<<dbpassword>>
    spring.jpa.hibernate.ddl-auto=update

    spring.mvc.hiddenmethod.filter.enabled=true
'''

