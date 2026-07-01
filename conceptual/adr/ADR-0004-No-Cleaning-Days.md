# ADR 0004: No Cleaning Days

## Status

Accepted

---

## Context

CleanList automatically generates cleaning schedules based on the configured rotation and assignment rules. However, there are dates on which no cleaning activities should take place, such as public holidays, church events, conferences, retreats, maintenance periods, or other exceptional occasions.

The system requires a flexible mechanism to prevent task generation on specific dates without limiting the feature to official holidays.

---

## Decision

CleanList introduces the concept of **No Cleaning Days**.

A No Cleaning Day represents a calendar date on which no cleaning tasks may be scheduled for a specific cleaning list.

Each No Cleaning Day belongs to a single cleaning list and includes:

- Date
- Reason
- Optional annual recurrence
- Audit information (creator and timestamps)

Only users with administrative permissions for the cleaning list (Owner or Admin) may create, update, or delete No Cleaning Days.

During schedule generation, the scheduling engine must verify whether a date is marked as a No Cleaning Day before assigning any cleaning tasks. If the date is blocked, task generation is skipped.

---

## Rationale

Using the term **No Cleaning Day** instead of **Holiday** provides greater flexibility because not every blocked date is an official holiday.

Examples include:

- National holidays
- Local holidays
- Church conferences
- Retreats
- Special services
- Building maintenance
- Community events
- Any custom date defined by list administrators

This approach better represents the business rule: **no cleaning should occur on the specified date**, regardless of the reason.

---

## Consequences

### Positive

- Flexible representation of non-cleaning dates
- Supports both public holidays and custom events
- Simple scheduling logic
- Easy for administrators to manage
- Future support for recurring dates
- Improves schedule accuracy and prevents unwanted assignments

### Negative

- Requires an additional validation step during schedule generation
- Administrators are responsible for maintaining blocked dates

---

## Future Enhancements

Possible future improvements include:

- Annual recurring No Cleaning Days
- Date range support (multiple consecutive days)
- Integration with public holiday providers
- Google Calendar synchronization
- Automatic notifications when schedules are affected

---

## Decision Summary

CleanList adopts **No Cleaning Days** as the standard mechanism for preventing cleaning task generation on specific dates. This solution provides a flexible, maintainable, and extensible approach that supports both official holidays and organization-specific events while keeping the scheduling engine simple and predictable.