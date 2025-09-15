# Practise Project

Консольное Java-приложение для работы с объектами `Computer`, `Laptop` и `Tablet`.

## Сборка проекта

1. Открой терминал в корне проекта (`practise`).  
2. Выполни команду для очистки и сборки JAR:

```bash
# Windows
.\mvnw clean package -DskipTests

# Linux/macOS
./mvnw clean package -DskipTests

```

3. После успешной сборки JAR-файл появится в папке:
```bash
target/practise-0.0.1-SNAPSHOT.jar
```
## Запуск приложения

В командной строке введите: 
```bash
java -jar target\practise-0.0.1-SNAPSHOT.jar
```
