# Java Mock Testing

Proyecto simple de pruebas unitarias en Java, siguiendo el tutorial:   
[Dominando las Pruebas Unitarias en JAVA | Mockito](https://youtu.be/0VivFIbTZ3c?si=lgUJNYV9aC6_LWF4).  
  
## Tecnologías utilizadas  
- **Spring Boot**
- **JUnit 5** - Framework de pruebas unitarias.
- **Mockito** - Para crear mocks y testear en aislamiento.
- **JaCoCo** - Para generar reportes de cobertura de código.
- **Maven** - como herramienta de construcción.

## Cobertura de código
La cobertura de pruebas se genera con **JaCoCo** y puede visualizarse ejecutando:

```bash
    mvn jacoco:report
```  
El informe se encontrará en `target/site/jacoco/index.html`.

### Captura del reporte de cobertura
![image](https://github.com/user-attachments/assets/26bc7f0b-47ff-44d5-9131-6e374571b44c)

---
# Pasos para clonar el proyecto
```bash
    git clone https://github.com/AbrilSabatini/test  
```
```bash
    cd test
```
### Ejecutar los tests con Maven
```bash
    mvn test
```
O en `src/test/java/org/mock/service/ImplPlayerServiceTest.java`.
