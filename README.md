# PaseandoAPancho

## Project Overview

PaseandoAPancho is a comprehensive software engineering project developed as part of the Fundamentos de Ingenieria del Software course at Universidad Politecnica de Madrid (UPM).

The project simulates a platform connecting pet owners with pet sitters in the Community of Madrid. While the theoretical design outlines a full-scale web application complying with GDPR and accessibility standards, this repository houses the backend implementation and business logic, operated via a Command Line Interface (CLI).

The primary goal of this repository is to demonstrate the practical application of software engineering principles, from requirements analysis to validation.

## Key Features

The implementation covers complex business logic scenarios required by the case study:

* **Role Management:** distinct profiles for Users acting as Owners and Sitters.
* **Gamification Logic:** Algorithms to calculate "Panchopuntos" (rewards) based on service parameters.
* **External Service Simulation:** Mock implementations of external APIs (RIAC - Pet Registry) for data validation.
* **Persistence Layer:** A custom, file-based persistence module that handles data storage (serialization/CSV) without external database dependencies.

## Core Competencies

This project serves as a practical demonstration of the following technical and methodological skills:

* **Object-Oriented Programming (OOP):** Applied advanced Java concepts including polymorphism, inheritance, and encapsulation to model complex domain entities (Owners, Pets, Sitters).
* **Software Architecture & Design:**
    * **UML Modeling:** Created detailed Class, Component, and Deployment diagrams to structure the system before implementation.
    * **Design Patterns:** Implemented industry-standard patterns (Factory, Strategy, Repository) to solve common design problems and ensure maintainability.
    * **Modular Architecture:** Designed a decoupled system with separate modules for logic, persistence, and user interface.
* **Requirements Engineering:** Analyzed user needs and functional requirements (e.g., dual-role users, gamification systems) to define the system scope.
* **Verification & Validation (V&V):**
    * **Unit Testing:** Developed a Black Box testing suite using JUnit to verify business logic correctness.
    * **Acceptance Testing:** Defined criteria to validate that the software meets the initial requirements.
* **Build Automation & Tools:**
    * **Maven:** Managed project lifecycle, dependencies, and build configurations.
    * **Git:** Utilized version control for source code management and team collaboration.

## Repository Structure

```plaintext
PaseandoAPancho/
├── 📂 docs/                # UML Design diagrams (Classes, Components, Deployment).
├── 📂 ejemplos/            # Executable scripts and usage demos.
├── 📂 persistenciaFile/    # Custom module for File I/O (CSV/Serialization).
├── 📂 src/                 # Source code.
│   ├── main/java           # Business logic (Owners, Pets, RIAC Validators).
│   └── test/java           # JUnit Black Box tests.
├── 📄 pom.xml              # Maven configuration.
└── 📄 README.md            # Project documentation.
```
## Installation & Usage

### Prerequisites
* Java JDK 11 or higher
* Maven 3.6+

## Software Development Life Cycle (SDLC)

This project strictly followed a structured SDLC:
1.  **Analysis:** Requirements gathering and specification.
2.  **Design:** Architectural modeling using UML.
3.  **Implementation:** Java coding adhering to the defined design.
4.  **Testing:** Verification through unit tests and validation against requirements.
