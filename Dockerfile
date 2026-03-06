# Etapa de construcción
FROM eclipse-temurin:21-jdk AS build

WORKDIR /app

# Copiar dependencias y código fuente
COPY . .

# 🔧 Dar permisos de ejecución al wrapper de Maven
RUN chmod +x mvnw

# Empaquetar la app, salteando los tests (si es necesario)
RUN mvn clean package -DskipTests

# Etapa final: imagen para producción
FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copiar el JAR desde el build
COPY --from=build /app/target/*.jar app.jar

# Exponer el puerto
EXPOSE 8080

# Comando para ejecutar

CMD ["java", "-jar", "app.jar"]
