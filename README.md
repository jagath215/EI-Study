﻿# EI-Study Programming Exercise

## Exercise-1
**Compile: **

javac -d bin src/behavioral/observer/*.java src/behavioral/command/*.java src/creational/singleton/*.java src/creational/factory/*.java src/structural/adapter/*.java src/structural/composite/*.java src/Main.java
** Run:**
java -cp bin Main

## Exercise-2
Smart Home System Programming Exercise

### Test Case Example
**Input**
Enter the number of devices:
3
Enter device type (light/thermostat/doorlock), ID, and initial status (off/on for light and doorlock, temperature for thermostat):
light, 1, off
thermostat, 2, 70
doorlock, 3, locked

Initial Status of Devices:
Device 1 is off
Device 2 is off
Device 3 is locked

Enter the number of commands:
3
Enter command (e.g., turnOn(1), setSchedule(2, "06:00", "Turn On"), addTrigger("temperature", ">", 75, "turnOff(1)"):
turnOn(1)
setSchedule(2, "06:00", "Turn On")
addTrigger("temperature", ">", 75, "turnOff(1)")

Final Status of Devices:
Device 1 is on
Device 2 is off
Device 3 is locked

Scheduled Tasks:
Device 2: 06:00 - Turn On

Automation trigger added: temperature > 75 -> turnOff(1)


**Output:**
Device 1 is on
Device 2 is off
Device 3 is locked
Scheduled Tasks:
Device 2: 06:00 - Turn On
Automation trigger added: temperature > 75 -> turnOff(1)


**How to Run?**
Compile the Java files:
javac *.java
Run the Application:
java SmartHomeApplication





