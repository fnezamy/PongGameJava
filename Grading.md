| Style (25) | Design (25) | Documentation (25) | Correctness/Efficiency (25) |
-----------|  ---------| ---------|---------|
| Excellent (20-25) | Code is readable, with descriptive variable names and thoughtful formatting. "Java thinking" is evident.  | Object-oriented design is carefuly done, with appropriate uses of IS-A and HAS-A, inheritance and interfaces.  | All javadoc is properly formatted, clear, concise. In-line comments are used judiciously and contribute to reader's understanding of code. "Works Cited" section is complete.  | Program works as specified; no crashes. Implementation is efficient.  |
| Adequate (10-19) | Occasional stylistic problems and/or "C-like" programming | Design doesn't always use object-oriented principles | Javadocs are present but difficult to read; in-line comments are excessive or underutilized; "Works Cited" section has problems. | Program runs, but some behavior is missing,  incorrect, or inefficiently implemented       |
| Needs Work (0-9) | Code is barely readable; no evidence of attention to style. | Little evidence of consideration of object-oriented design principles |  Javadoc, in-line comments, and/or "Works Cited" are minimal or missing.  |  Code doesn't run; program substantially fails to meet specs.        |

Style = 20. Names are OK, but formatting is really quirky in some places--strongly recommend you use Eclipse's auto-formatting to help layout your code
Design = 15. Why don't your paddles `extend GameObject`? This makes your `collide()` method difficult to implement (which may explain why the ball doesn't really bounce properly off the player's paddle)
Documentation =  18. No generated javadocs.
Correctness = 20. Ball/paddle interactions are not quite correct.

Total =   78

Extra Credit = 3. (Player one's score doesn't seem to work?)

