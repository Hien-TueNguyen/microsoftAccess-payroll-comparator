# GitHub Copilot Instructions

## Project Purpose

This project compares employee/work records stored in Microsoft Access databases.

The program should:

1. Connect to Microsoft Access `.accdb` or `.mdb` database files.
2. Read data from specific tables.
3. Retrieve only the columns required for comparison.
4. Use a unique employee/record ID to match records between datasets.
5. Compare selected fields, especially hours worked.
6. Identify records where the values differ.
7. Clearly report:
   - Record ID
   - Employee name when available
   - Value from the first dataset
   - Value from the second dataset
   - Difference between the values
8. Handle records that exist in one dataset but not the other.

## SQL Guidelines

When generating SQL:

- Prefer simple, readable SQL over unnecessarily complex queries.
- Select only required columns instead of using `SELECT *`.
- Use the record ID as the primary field for matching records.
- Use JOIN operations when comparing records from two tables when appropriate.
- Prefer explicit JOIN syntax.
- Use aliases when they improve readability.
- Clearly distinguish values coming from different tables.
- Account for NULL values when comparisons may involve missing data.
- Do not assume table names or column names that have not been provided.
- Remember that Microsoft Access SQL differs from SQL used by PostgreSQL, MySQL, and SQL Server.
- Use Microsoft Access-compatible SQL syntax.
- Place table or column names containing spaces or reserved words inside square brackets.

Example:

SELECT
    a.[EmployeeID],
    a.[HoursWorked] AS HoursA,
    b.[HoursWorked] AS HoursB
FROM
    [TableA] AS a
    INNER JOIN [TableB] AS b
        ON a.[EmployeeID] = b.[EmployeeID]
WHERE
    a.[HoursWorked] <> b.[HoursWorked];

## Database Connection Guidelines

- The database source is Microsoft Access.
- Do not assume Microsoft Access supports features from other SQL dialects.
- Keep database connection logic separate from comparison logic when possible.
- Use parameterized queries instead of constructing SQL with user-provided values.
- Properly close database connections, cursors, and other resources.
- Include useful error handling for failed connections, missing tables, and missing columns.
- Never hard-code passwords, credentials, or sensitive connection information.

## Comparison Logic

When comparing datasets:

- Match records using the unique ID, not employee names.
- Employee names are descriptive fields and should not be relied upon as unique identifiers.
- Compare only the fields requested by the program.
- Treat missing records separately from changed records.
- Clearly distinguish:
  - Matching records
  - Changed records
  - Records only in dataset A
  - Records only in dataset B
- When comparing numeric values such as hours worked, calculate the difference when useful.

## Code Quality

- Keep functions small and focused on one responsibility.
- Use descriptive variable and function names.
- Avoid unnecessary abstraction.
- Avoid duplicate code.
- Add comments only where the reasoning is not obvious from the code.
- Prefer straightforward solutions suitable for a student project.
- Do not introduce libraries or frameworks unless they provide a clear benefit.

## Learning Guidelines

This is a learning project.

When suggesting code:

- Explain unfamiliar concepts when introducing them.
- Prefer code that is easy to understand over clever or highly condensed code.
- Do not rewrite large portions of the project unless explicitly requested.
- When fixing an error, explain the cause before suggesting a solution.
- Preserve the existing project structure and coding style when possible.
- If multiple solutions exist, prefer the simplest reasonable solution and briefly explain alternatives.
- Do not generate functionality beyond what was requested.