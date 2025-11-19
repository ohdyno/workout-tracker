# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Commands

### Build and Test

- `./mvnw clean compile` - Clean and compile the project
- `./mvnw test` - Run all tests including Cucumber feature tests
- `./mvnw test -Dtest=FeatureSuiteRunner` - Run only Cucumber feature tests
- `./mvnw verify` - Run full verification including tests and code quality checks

### Code Quality

- `./mvnw spotless:apply` - Apply code formatting automatically (runs automatically on compile)
- `./mvnw spotless:check` - Check code formatting without applying changes

### Running the Application

- `./mvnw spring-boot:run -pl web` - Start the Spring Boot web application
- Application runs on port 8080 by default
- Access the web interface at http://localhost:8080/workouts

### Development

- `./mvnw versions:display-dependency-updates` - Check for dependency updates
- Git hooks are automatically configured via `git-build-hook-maven-plugin`

## Architecture

This is a multi-module Maven project implementing a workout tracking application using Domain-Driven Design (DDD) and Event Sourcing patterns.

### Project Structure

- **Root**: Multi-module Maven project with shared dependencies and build configuration
- **domain module**: Contains the core business logic, domain models, and event sourcing implementation
- **web module**: Spring Boot web application providing HTTP endpoints and web UI

### Key Architectural Patterns

- **Event Sourcing**: Uses a custom `simple-event-store` library for persisting domain events
- **CQRS**: Commands are handled through `WorkoutCommandService`, events are applied to aggregates
- **Domain Models**: `Workout` and `Athlete` are aggregate roots extending `BaseAggregate`
- **Value Objects**: `WorkoutId`, `AthleteId`, `Email`, `WorkoutName` for type safety
- **Clear Layer Separation**: Maintain a strict boundary between domain layer and presentation layer (currently server-side rendered web)

### Domain Model

- **Aggregates**: `Workout`, `Athlete`
- **Commands**: `CreateWorkout`, `DefineAthlete`, plus new workout set commands
- **Events**: `WorkoutCreated`, `AthleteDefined`, plus new workout set events
- **Services**: `WorkoutCommandService` handles command processing

### Web Layer

- **Spring Boot**: Web application with Spring MVC controllers
- **JStach**: Template engine for server-side rendering (replacing Mustache)
- **Controllers**: `WorkoutController` handles workout-related HTTP endpoints
- **Models**: `WorkoutModel` for view data binding

### Testing

- **Cucumber**: BDD tests located in `domain/src/test/resources/features/`
- **Test Structure**: Step definitions in `step.definitions` package with shared `TestState`
- **Feature Tests**: Cover workout planning scenarios including creating workouts and managing sets

### Development Approach

- **TDD/BDD Preferred**: All new features should be developed using Test-Driven Development
- **Gherkin First**: Write failing Gherkin scenarios before implementation
- **Red-Green-Refactor**: Follow the TDD cycle with BDD scenarios driving the implementation

### Code Quality

- **Spotless**: Automated code formatting with Palantir Java Format
- **Git Hooks**: Pre-commit hook automatically runs `spotless:apply` and stages formatted files
- **Maven Enforcer**: Requires Maven 3.9.9+
- **Java 21**: Target JVM version
- Maintain a clear boundary between the domain layer of the workout tracker and the presentation layer, which currently is via a server-side rendered web application.

