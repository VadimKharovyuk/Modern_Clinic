# Используем официальный образ OpenJDK как базовый образ
FROM openjdk:17-jdk-slim

# Устанавливаем рабочий каталог
WORKDIR /app

# Копируем JAR файл из монтируемого каталога
COPY target/Spring_Security-0.0.1-SNAPSHOT.jar app.jar

# Определяем команду для запуска приложения
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
