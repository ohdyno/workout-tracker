# Domain Requirements - Workout Tracker

## Set Recording Requirements

### Core Set Data

A **set** records the following essential information:
- **Reps**: Number of repetitions performed
- **Weight**: Composed of implement weight + plates loaded

### Weight Recording Model

Athletes think about weight in terms of **plates per side** for barbell or plate-loaded machines, not total weight.

Weight is recorded as three separate components:
- **Implement**: The TYPE of equipment being used (e.g., "barbell", "ez bar", "dumbbell", "machine")
- **Implement Weight**: The weight of that specific piece of equipment (e.g., 20 kg for a standard Olympic barbell, 15 kg for a women's bar, 126 lb for a specific machine)
- **Plates Per Side**: A LIST of individual plates loaded on each side (e.g., [45 lb, 25 lb, 5 lb])

**Example - Deadlift:**
- Implement: "barbell"
- Implement weight: 20 kg
- Plates per side: [45 lb, 25 lb, 5 lb]
- Total weight: 20 kg + 2 × (45 + 25 + 5) lb = 20 kg + 150 lb

Tracking plates as individual items (rather than a sum) enables the plate calculation assistant to tell the athlete exactly which plates to load.

### Set Completion Types

1. **Normal Completion**: Hitting the target reps cleanly with full range of motion maintained throughout
2. **Technical Failure**: When range of motion is reduced compared to the first rep in the set
   - **Must record**: How many reps were completed before technical failure occurred

### Notes and Annotations

- **Format**: Free-form text
- **Purpose**: Must be readable for the athlete
- **Content Examples**:
  - Machine settings (seat position, pin number)
  - Form cues that worked well
  - Intensity techniques (drop sets, myo-reps, rest-pause sets)
  - Observations about difficulty or performance

**Intensity techniques** (drop sets, myo-reps, rest-pause) are recorded as **annotations on a single set**, not as multiple sets.

### Recording Workflow

**Typical pattern**: Record data immediately after each set

**Fallback pattern**: Sometimes athletes forget and batch-record all sets before moving to the next exercise

**System must support both patterns.**

### User Experience Requirements

#### Auto-Population

Each set in the current session should be **auto-populated** with information from:
1. Previous session's corresponding set (if available)
2. Previous set in current session (if available) - takes precedence

This reduces manual data entry and makes it easy to repeat or progress from previous performance.

#### Plate Calculation Assistant

The system must automatically calculate what plates are needed to:
- Match previous weight
- Increase from previous weight

This eliminates mental math during workouts and reduces errors in plate loading.

### Domain Language

- **Implement**: The TYPE of equipment (e.g., "barbell", "ez bar", "dumbbell", "machine")
- **Implement weight**: The weight of the specific piece of equipment being used
- **Plates per side**: A list of individual weight plates loaded on one side of the barbell/machine
- **Technical failure**: Loss of range of motion compared to first rep
- **Set**: A continuous series of repetitions of an exercise

