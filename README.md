環境需求:
- Java 17 或以上版本
- Maven 3.8+
- Node.js 18+（建議 Node.js 20+）
- npm 9+ 或 yarn
- MySQL 8.0+

1. 確認已啟動 MySQL
2. 在本機建立資料庫（若不存在）：
   ```sql
   CREATE DATABASE employee_seat_system;
3.匯入 db/employee_seat_system_dump.sql：
mysql -u youruser -p employee_seat_system < db/employee_seat_system_dump.sql

application.properties起始***************

spring.datasource.url=jdbc:mysql://localhost:3306/employee_seat_system?useSSL=false&serverTimezone=Asia/Taipei
spring.datasource.username=你的使用者名稱
spring.datasource.password=你的密碼
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=validate
spring.jpa.hibernate.naming.implicit-strategy=org.hibernate.boot.model.naming.ImplicitNamingStrategyLegacyJpaImpl
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

server.port=8080

application.properties結尾***************

powershell執行:

cd至backend
.\mvnw.cmd spring-boot:run

cd至frontend
npm install
npm run dev