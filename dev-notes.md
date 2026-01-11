# 1. Visual Studio Code (VS Code)

VS Code is a **lightweight source code editor**. However, it can be considered as an Integrated Development Environment (IDE) because of its extensive extension ecosystem that allows it to offer a comprehensive set of features typically associated with a full IDE.

VS Code is also highly recommended for React development due to its features and extensions.

## 1.1. VS Code Extensions

1. **Live Server by Ritwick Dey** - live pre-viewing of the website
2. **Extension Pack for Java by Microsoft** - this bundle includes essential Java development extensions
3. **Spring Boot Extension Pack by VMware** - provides Spring Boot specific features
4. **Maven for Java by Microsoft** - provides a project explorer and shortcuts to execute Maven commands
5. **REST Client by Huachao Mao** - run HTTP requests from VS Code
6. **Markdown Preview Enhanced by Yiyi Wang** - pre-viewing of Markdown documentation
7. **Material Icon Theme by Philipp Kief** (optional) - improved file icons in VSCode interface

## 1.2. VS Code Shortcuts

`Alt + z` to wrap text in the VS Code editor interface.

`Ctrl + /` comment out code block

Using Live Server to preview page in browser:
> *Open a `.html` file > Right-click > Open with Live Server*

Using Markdown Preview to preview document:
> *Open a `.md` file > `Ctrl + k v` (side)*
> *Open a `.md` file > `Ctrl + Shift + v` (new tab)*

Running Java application:
> *Right-click the main Java file (with the @SpringBootApplication annotation)*
> *Click `Run Java` or `Debug Java` for debugging*

# 2. Dev Tools

## 2.1. Git, GitHub and Git Bash

*Definitions by AI*

Git is a free and open-source distributed version control system (DVCS) designed to handle everything from small to very large projects with speed and efficiency. Git capabilities include file version control, distributed architecture, collaboration, branching and merging, and staging. Git is a fundamental tool for modern software development, enabling efficient tracking of changes, seamless collaboration, and robust management of project history.

GitHub is a cloud-based platform built on Git that hosts software projects, allowing developers to store, manage, and collaborate on code in a user-friendly, web-based interface.

Particularly, the source code for this app is publicly available in GitHub:
- UI/Client Layer: https://github.com/ChesterT18/reservation-website
- Application Layer: https://github.com/ChesterT18/reservation-app

Git Bash is an application for Microsoft Windows environments that provides a Unix-like command-line interface (CLI) for interacting with Git and executing various shell commands.

Download from: https://git-scm.com/downloads.

> **`git --version`** ~ *verify if properly installed*

In your PC, set these environment variables:

> **System variables**
> Path: C:\Program Files\Git\cmd

## 2.2. Java Development Kit (JDK)

Download JDK25 from: https://www.oracle.com/asean/java/technologies/downloads/#jdk25-windows, choose the **x64 Installer** download link. Run the `.exe` file.

> **`java --version`** ~ *verify if properly installed*

In your PC, set these environment variables:

> **System variables**
> JAVA_HOME: C:\Program Files\Java\jdk-25

## 2.3. MySQL Server and MySQL Workbench

*Definitions by AI*

MySQL is an open-source relational database management system (RDBMS). It is widely used to store and manage data for various applications, including websites, web applications, and embedded systems. Some characteristics of MySQL:
- Relational Database: MySQL organizes data into tables, which are structured with rows and columns. Relationships can be defined between these tables, allowing for efficient data organization and retrieval.
- Structured Query Language (SQL): MySQL uses SQL as its standard language for creating, modifying, managing, and querying data within the database.
- Client-Server Model: MySQL operates on a client-server model, where a MySQL server manages the database and responds to requests from client applications.
- Scalability and Performance: It is known for its ability to handle large amounts of data and high-traffic applications, making it a popular choice for demanding environments.

Download and run MySQL Installer 8.0.43: https://dev.mysql.com/downloads/installer/ (mysql-installer-community-8.0.43.0.msi)

Run the installer and from there install
1. MySQL Server 8.0.43 (x64)
2. MySQL Workbench 8.0.43 (x64)

> **`mysql --version`** ~ *verify if properly installed*

In your PC, set these environment variables:

> &nbsp;
> **System variables**
> MYSQL_HOME: C:\Program Files\MySQL\MySQL Server 8.0\bin
> &nbsp;
> **User variables**
> Path: C:\Program Files\MySQL\MySQL Server 8.0\bin
> &nbsp;





## 2.4. Node.js (Node)

*Definition by AI*

Node.js is an open-source, cross-platform JavaScript runtime environment that allows you to execute JavaScript code outside of a web browser. It enables server-side programming and building various applications like web servers, command-line tools, and desktop applications using JavaScript.

NPM (Node Package Manager) is the default package manager for Node.js. It is automatically installed when you install Node.js. NPM facilitates the installation, management, and sharing of packages (libraries, frameworks, and other code dependencies) for your Node.js projects. It handles tasks such as package installation, version management, and resolving dependencies between packages.

NVM or Node Version Manager is a command-line tool that allows developers to manage multiple versions of Node.js on a single machine. This function offers the flexibility to work on different projects and versions of Node.js. In this guide, we'll walk you through the steps to install and use NVM on Windows OS.

Follow the instructions in this link to install nvm:
https://www.geeksforgeeks.org/installation-guide/how-to-install-and-use-nvm-on-windows/

> &nbsp;
> **`nvm -v`** ~ *confirm and check version of installed nvm*
> **`nvm install 22.20.0`** ~ *install specific node version*
> **`nvm use 22.20.0`** ~ *use specific installed node version*
> **`node -v`** ~ *confirm and check version of installed node*
> &nbsp;

In your PC, set these environment variables:

> &nbsp;
> **System variables**
> NVM_HOME: C:\Users\uuu\AppData\Local\nvm
> NVM_SYMLINK: C:\nvm4w\nodejs
> Path: %NVM_HOME% | %NVM_SYMLINK%
> &nbsp;
> **User variables**
> NVM_HOME: C:\Users\uuu\AppData\Local\nvm
> NVM_SYMLINK: C:\nvm4w\nodejs
> Path: %NVM_HOME% | %NVM_SYMLINK% | C:\Users\uuu\AppData\Roaming\npm
> &nbsp;

# 3. Libraries

## 3.1. React

*Definition by AI*

React (also known as React.js or ReactJS) is a free and open-source front-end JavaScript library for building user interfaces. React is a library for building web and native user interfaces using components and can be added to existing HTML pages. Key characteristics of ReactJS include: 

1. Component-Based Architecture: React encourages building UIs using small, isolated, and reusable pieces called components. This modular approach simplifies development, improves code organization, and promotes reusability.
2. Declarative Programming: Developers describe what the UI should look like for a given state, and React handles the efficient updating of the UI to match that state. This makes code easier to understand and reason about.
3. Virtual DOM: React uses a virtual representation of the Document Object Model (DOM) in memory. When the application's state changes, React first updates this virtual DOM and then efficiently calculates the minimal changes needed to update the actual browser DOM, leading to improved performance.
4. JSX: React uses JSX (JavaScript XML), a syntax extension that allows developers to write HTML-like structures directly within JavaScript code. This makes it easier to visualize and build UI components.
5. Unidirectional Data Flow: React typically follows a unidirectional data flow, where data flows from parent components to child components via "props" (properties). This makes data management more predictable and easier to debug.

Refer to this link for documentations: https://react.dev/

## 3.2. SpringBoot

# 4. Development Steps

## 4.1. Client Layer (UI)

### 4.1.1. Create Blank Project

For our front-end (UI), we are using ==React javascript library==. React development relies on Node.js, so ==make sure Node.js is installed==. Here, we used ==Vite to create a React project easily==.

***

*Definition by AI*

**Vite** is a modern, next-generation build tool and development server for web projects, created by Evan You, the creator of Vue.js. Vite addresses the performance bottlenecks of traditional build tools, which often struggle with slow server startup and HMR as projects grow larger. By providing a faster, leaner development experience, Vite allows developers to be more productive, see changes instantly, and maintain application state during updates, resulting in a much smoother and more enjoyable development process. 

Vite is composed of two parts:

1. A dev server that provides rich feature enhancements over native ES modules, e.g., extremely fast Hot Module Replacement (HMR), that dramatically improves the developer experience (DX).
2. A build command that bundles your code with Rollup, pre-configured to output highly optimized static assets for production.

Key features of Vite include instant server start, lightning-fast HMR (updates are applied in real-time without losing application state), on-demand compilation (only compiles the code that is currently being requested by the browser, rather than pre-bundling the entire project), native ES module support, pre-bundling dependencies (uses esbuild, a tool written in Go, to pre-bundle and optimize dependencies for faster initial load), production builds with Rollup, rich feature support, and flexible plugin system (a powerful plugin API allows for extensive customization and integration with other tools).

***

Learn more about Vite: https://vite.dev/

To create a new React project, open VS Code and go to a target folder. Run the following command in the terminal:

```
npm create vite@latest my-react-app --template react
```

This command will create a new directory named `my-react-app` with a basic React project structure. Navigate to your project directory and install dependencies:

```
cd my-react-app
npm install
```

Finally, run the development server.

```
npm run dev
```

### 4.1.2. Template

Web page template is downloaded from: https://www.tooplate.com/view/2129-crispy-kitchen. All unedited files are saved in `./templates/site`.

## 4.2. Application Layer

### 4.2.1. Create Blank Project

Create starter Spring Boot project from https://www.geeksforgeeks.org/java/how-to-create-a-spring-boot-project-in-spring-initializr-and-run-it-in-intellij-idea/.

Follow **Steps 1-3**. Add dependencies: Spring Boot DevTools, Spring Data JPA, MySQL Driver.

### 4.2.2. Setup Initial Microservice 

Follow the general steps, starting at **Step 2**, described in https://www.geeksforgeeks.org/springboot/java-spring-boot-microservices-example-step-by-step-guide/.

In src/main/resources/application.properties, make sure to add the following:

```
spring.application.name=uuu   ## any application name you like
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/reservation   ## JDBC Connection String from SQL server (no query) + schema name
spring.datasource.username=uuu   ## connection username (via MySQL Server)
spring.datasource.password=uuu   ## connection password (via MySQL Server)
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
server.port=7000   ## or any similar port
```

## 4.3. Database Layer

Open MySQL Workbench and create new connection. Test connection.

Create a new schema (e.g. reservation). Add new table (e.g. menu).

Add columns, matching the desired entity in the Application Layer.

# Others

/*# sourceMappingURL=bootstrap.min.css.map */








