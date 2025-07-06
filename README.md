# 🕰 British Spoken Time Converter

This project converts time from 24-hour `"HH:mm"` format into British spoken English (e.g., `"17:20"` → `"twenty past five"`).

---

## 🧰 Technologies Used

- Java 17 (JDK)
- Spring Boot 3.5.3
- Test-Driven Development (TDD)

---

## 🧪 Design Considerations

1. **Architecture**: Follows a simple `Controller → Service → Repository` layered structure.
2. **Development Approach**: Built using the TDD methodology — _Red → Green → Refactor_.
3. **Testing**: Comprehensive unit tests included for both Repository and Service layers.
4. **Input Method**: Accepts user input via the command line. (Can be easily extended to a REST API.)
5. **Simplicity**: No authentication or additional complexity to keep the application lightweight.

---

## 📐 Design Pattern

- **Strategy Pattern**: Applied for flexible and extensible time conversion logic.

---

## 🚀 How to Run

```bash
# Compile and run tests
mvn clean install

# Launch the application via command line
mvn spring-boot:run
```

![img.png](img.png)
