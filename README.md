# EI-Study Programming Exercise

## Exercise-1: Design Patterns Implementation

### Compile
To compile the Java files for the different design patterns, run the following command:

```bash
javac -d bin src/behavioral/observer/*.java src/behavioral/command/*.java src/creational/singleton/*.java src/creational/factory/*.java src/structural/adapter/*.java src/structural/composite/*.java src/Main.java
```



### Run
To execute the `Main` class after compiling, use the following command:

```bash
java -cp bin Main
```

---

## Exercise-2: Smart Home System Programming Exercise

### Test Case Example

#### **Input:**

```text
Enter the number of devices:
3
Enter device type (light/thermostat/doorlock), ID, and initial status (off/on for light and doorlock, temperature for thermostat):
light, 1, off
thermostat, 2, 70
doorlock, 3, locked
```

Initial Status of Devices:
```text
Device 1 is off
Device 2 is off
Device 3 is locked
```

```text
Enter the number of commands:
3
Enter command (e.g., turnOn(1), setSchedule(2, "06:00", "Turn On"), addTrigger("temperature", ">", 75, "turnOff(1)"):
turnOn(1)
setSchedule(2, "06:00", "Turn On")
addTrigger("temperature", ">", 75, "turnOff(1)")
```

#### **Output:**

Final Status of Devices:
```text
Device 1 is on
Device 2 is off
Device 3 is locked
```

Scheduled Tasks:
```text
Device 2: 06:00 - Turn On
Automation trigger added: temperature > 75 -> turnOff(1)
```

#### **Expected Output:**

```text
Device 1 is on
Device 2 is off
Device 3 is locked
```

Scheduled Tasks:
```text
Device 2: 06:00 - Turn On
Automation trigger added: temperature > 75 -> turnOff(1)
```

---

### How to Run?

#### 1. **Compile the Java files:**

```bash
javac *.java
```

#### 2. **Run the Application:**

```bash
java SmartHomeApplication
```
```

---

