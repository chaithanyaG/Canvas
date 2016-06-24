# SpringerNature
Canvas
CanvasGenerator provides interactive functionalities to create and work with canvas in command prompt

1. Command: C w h 
		 	creates a new canvas of width w and height h.
		 	
2. Command: L x1 y1 x2 y2 
			creates a new line from (x1,y1) to (x2,y2). 
		 	Currently only horizontal or vertical lines are supported. 
		 	Horizontal and vertical lines will be drawn using the 'x' character.
		 	
3. Command: R x1 y1 x2 y2 
			Creates a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). 
		 	Horizontal and vertical lines will be drawn using the 'x' character.
		 	
4. Command: B x y c 
			Fills the entire area connected to (x,y) with character 'c'.
			
5. Command: Q 
			quits the program.
			
6. Wrong commands or command arguments will not be accepted 
7. If any other command other than C or Q is given, User is forced to create Canvas first 
8. For Lines, either x1 and x2 should be same or y1 and y2 should be same, else user is asked to enter the details again
