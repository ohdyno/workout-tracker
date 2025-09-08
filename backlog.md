# Product Backlog - Workout Tracker

## User Profile

- **Primary Goal**: Track progress over time and analyze performance trends
- **Workout Style**: Push/Pull/Legs split with 4-5 exercises per session
- **Equipment**: Barbells, dumbbells, kettlebells, machines, bodyweight
- **Progression**: Double progression (8-12 rep range, increase weight when hitting 12 reps)
- **Planning Style**: Flexible planning with workout templates, substitutions as needed

## Core Value Proposition

"Super easy workout planning and capturing that enables consistent progressive overload tracking"

---

## Epic 1: Workout Planning & Templates

**Goal**: Make it effortless to plan workouts in advance while maintaining flexibility

### Must Have (P0)

- **Create workout templates** for Push/Pull/Legs days
  - Template includes 4-5 exercises with target rep ranges
  - Easy to modify template on the fly
- **Exercise library management**
  - Personal exercise library for quick substitutions
  - Categorize by muscle groups and equipment type
- **Quick exercise substitution** during workout planning
  - Replace exercise with alternatives from personal library
  - Maintain progression data when substituting similar exercises

### Should Have (P1)

- **Weekly workout scheduling** with template assignment
- **Exercise search and filtering** by equipment/muscle group
- **Template duplication** for creating variations

---

## Epic 2: Workout Execution & Tracking

**Goal**: Capture workout data quickly and accurately during gym sessions

### Must Have (P0)

- **Previous session display** for each exercise
  - Show last weight, reps, sets performed
  - Display progression targets (e.g., "Try for 12 reps" or "Increase to 135lbs")
- **Simple weight calculation** for barbell exercises
  - Input number of plates, app calculates total weight
  - Support for different plate configurations
- **Set-level annotations** for each exercise
  - Machine settings (seat height, pin position, etc.)
  - Intensity techniques (drop-set, myo-reps)
  - General notes ("felt heavy", "good form")
- **Double progression tracking**
  - Track within 8-12 rep range
  - Auto-suggest weight increase when 12 reps achieved
  - Handle failed progression attempts

### Should Have (P1)

- **Rest timer** between sets
- **Quick exercise reordering** during workout
- **Workout session notes** (overall feeling, energy level)

---

## Epic 3: Progress Analysis & Trends

**Goal**: Visualize progress and identify trends to maintain motivation

### Must Have (P0)

- **Exercise progress charts** showing weight/reps over time
- **Progressive overload validation**
  - Highlight when user is consistently progressing
  - Flag when progress has stalled
- **Session completion tracking** to maintain consistency

### Should Have (P1)

- **Volume tracking** (total weight lifted per session/week)
- **Strength ratios** between major lifts
- **Progress photos integration**

### Nice to Have (P2)

- **Training cycle planning** (periodization support)
- **Performance predictions** based on current trends

---

## Epic 4: Data Management & Flexibility

**Goal**: Ensure data is accessible and users maintain control

### Must Have (P0)

- **Workout history** with easy navigation
- **Exercise performance history** per movement
- **Data backup/restore** functionality

### Should Have (P1)

- **Export workout data** (CSV, PDF)
- **Exercise video/instruction** integration
- **Custom exercise creation**

---

## Technical Priorities

### Phase 1 (MVP)

1. Workout template creation and management
2. Exercise library with personal lists
3. Basic workout logging with previous session display
4. Set-level annotations and machine settings
5. Simple progress charts

### Phase 2 (Enhancement)

1. Advanced plate calculator
2. Double progression automation
3. Intensity technique tracking
4. Volume and trend analysis
5. Weekly planning interface

### Phase 3 (Advanced)

1. Comprehensive analytics dashboard
2. Training cycle planning
3. Data export/import
4. Performance predictions
5. Social features (optional)

---

## Success Metrics

- **Primary**: Daily active usage during workout sessions
- **Secondary**: Workout completion rate, progression consistency
- **User Satisfaction**: Ease of planning (< 2 minutes) and logging (< 30 seconds per exercise)

---

## User Stories for Immediate Development

### Story 1: Basic Workout Logging

*"As a user, I want to log my workout sets with weight, reps, and notes so that I can track my performance over time."*

**Acceptance Criteria:**
- Can enter exercise name, weight, reps for each set
- Can add notes to individual sets (machine settings, intensity techniques)
- Previous session data displays when logging same exercise
- Supports barbell weight calculation (plates + bar)

### Story 2: Workout Templates

*"As a user, I want to create reusable workout templates so that I can quickly plan my Push/Pull/Legs routine."*

**Acceptance Criteria:**
- Can create templates with 4-5 exercises
- Can set target rep ranges for each exercise
- Can easily modify template before starting workout
- Templates save for future reuse

### Story 3: Exercise Substitution

*"As a user, I want to quickly substitute exercises during my workout so that I can adapt when equipment is unavailable."*

**Acceptance Criteria:**
- Can replace any exercise in current workout
- Exercise library filtered by equipment type
- Substitution maintains workout flow and timing
- Previous data for substitute exercise displays if available
