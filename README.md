FundMyProject.com
=================

FundMyProject.com

This application is develop for coordinated of creators of apps, which want funding for the development of your project.

The application complies with the architectural model of n- layers. The persistence is implements with DAOs patterns and it use the data base HYPERSONIC. Also:

• Using architectural patterns as:
    - Model-view-controller (MVC)
    - Command
    - Façade
	- Factories
	- Business Delegate
	- DAO
• Internationalization, Spanish and English
• Vertical Scaling
• Using Struts 2 and Spring Framework (Dependency Injection )

Features:

• Count based on the use of context
• Authentication is performed using interceptors
• Validation of login forms, registration and building projects, written in JSP, which perform:
   - All fields in all forms must have value, can not be null
   - The user (registration) must have at least 5 to 50 characters
   - The password (registration) must have at least 5 to 50 characters
   - The project description may not exceed 300 characters
   - The value of the action on the project must be at least 100.0
   - The cost of the project will be a Double value
   - The percentage should be between 0.0 and 100.0


