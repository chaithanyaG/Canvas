package canvas;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class CanvasGenerator {

	/** Initiating static variables **/
	public static int WIDTH = 0;
	public static int HEIGHT = 0;
	public static String canvas = "";

	public static void main(String[] args) {

		/**
		 * Guiding user with the supported commands
		 */
		System.out.println("C w h-> New Canvas");
		System.out.println("L x1 y1 x2 y2-> To draw line in canvas");
		System.out.println("R x1 y1 x2 y2 -> To draw Rectangle in canvas");
		System.out.println("B x y c -> To fill with character c");
		System.out.println("Q -> to Quit");
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.print("Enter command: ");
			String command = scanner.next();

			if ("C".equalsIgnoreCase(command)) {
				try {
					WIDTH = Integer.parseInt(scanner.next());
					HEIGHT = Integer.parseInt(scanner.next());
					// System.out.println(WIDTH + " " + HEIGHT);
					WIDTH = WIDTH + 2;

				} catch (Exception e) {
					System.out.println("please insert as C W H");
				}

				canvas = createCanvas();
				System.out.println(canvas);
				readUserInput();
			} else if ("Q".equalsIgnoreCase(command)) {
				System.out.println("Terminated");

			} else {
				System.out.println("Please create canvas first");
				readUserInput();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}

	}

	/**
	 * Creates canvas with given co-ordinates
	 * 
	 * @return
	 */
	protected static String createCanvas() {

		StringBuilder shape = new StringBuilder();

		StringBuilder line = new StringBuilder();
		StringBuilder space = new StringBuilder();
		try {
			// upper line
			for (int i = 0; i < WIDTH; i++) {
				line.append("-");
				space.append(" ");

			}
			space.setLength(WIDTH - 2);

			shape.append(line.toString());
			// side lines
			line = new StringBuilder();
			for (int i = 0; i < HEIGHT; i++) {
				line.append("\n|");
				line.append(space).append("|");
			}
			shape.append(line.toString());
			shape.append("\n");

			// bottom line
			line = new StringBuilder();
			for (int i = 0; i < WIDTH; i++) {
				line.append("-");
			}
			shape.append(line.toString());
		} catch (Exception e) {
			System.out.println("Error while creating Canvas");
			e.printStackTrace();
		}
		return shape.toString();

	}

	/***
	 * Reads user input using scanner
	 */
	protected static void readUserInput() {

		Scanner scanner = new Scanner(System.in);
		String command = "";
		String shape = "";
		System.out.print("Enter Command: ");
		try {
			command = scanner.next();
			if (command != null && command.equals("Q")) {
				System.out.println("Terminated");
			} else {
				if (command != null && ("C".equals(command))) {
					try {
						WIDTH = Integer.parseInt(scanner.next());
						HEIGHT = Integer.parseInt(scanner.next());
						// System.out.println(WIDTH + " " + HEIGHT);
						WIDTH = WIDTH + 2;

					} catch (Exception e) {
						System.out.println("please insert as C W H");
					}

					canvas = createCanvas();
					System.out.println(canvas);
					readUserInput();
				} else if ("L".equalsIgnoreCase(command)) {
					if (!canvas.equalsIgnoreCase("")) {
						shape = drawLine(scanner);
						if (!"".equalsIgnoreCase(shape)) {
							canvas = shape;
						} else {
							shape = canvas;
						}
						readUserInput();
					} else {
						System.out.println("Please create canvas first");
						readUserInput();
					}
				} else if ("R".equalsIgnoreCase(command)) {
					if (!canvas.equalsIgnoreCase("")) {
						shape = drawRect(scanner);
						if (!"".equalsIgnoreCase(shape)) {
							canvas = shape;
						} else {
							shape = canvas;
						}
						readUserInput();
					} else {
						System.out.println("Please create canvas first");
						readUserInput();
					}
				} else if ("B".equalsIgnoreCase(command)) {
					if (!canvas.equalsIgnoreCase("")) {
						shape = fillColor(scanner);
						if (!"".equalsIgnoreCase(shape)) {
							canvas = shape;
						} else {
							shape = canvas;
						}
						readUserInput();
					} else {
						System.out.println("Please create canvas first");
						readUserInput();
					}
				} else {
					System.out.println("Please provide proper commands");
					readUserInput();
				}
			}
		} catch (Exception e) {
			System.out.println("Error while reading user Input");
			e.printStackTrace();

		} finally {
			scanner.close();
		}

	}

	/**
	 * Drawing Rectangle
	 * 
	 * @param scanner
	 * @return
	 */
	protected static String drawLine(Scanner scanner) {
		String shape = "";

		if (WIDTH == 0 || HEIGHT == 0) {
			System.out.print("please give commands for creating canvas");
			readUserInput();
		} else {
			try {

				int x1 = scanner.nextInt();
				int y1 = scanner.nextInt();
				int x2 = scanner.nextInt();
				int y2 = scanner.nextInt();

				boolean flag = validate(x1, y1, x2, y2);

				if (flag) {
					StringTokenizer st = new StringTokenizer(canvas, "\n");
					Map<Integer, String> lineMap = new HashMap<Integer, String>();
					int key = 0;
					while (st.hasMoreTokens()) {
						lineMap.put(key, st.nextToken());
						key++;
					}

					if (y1 == y2) {
						/** creating horizontal line **/
						String currentLine = lineMap.get(y1);
						StringBuilder horiz = new StringBuilder();
						String str = lineMap.get(0).replace("-", "X");
						str = str.substring(0, str.length() - 2);
						horiz.append(str, x1, x2 + 1);

						StringBuilder line = new StringBuilder();
						line.append(currentLine);
						line.replace(x1, x2 + 1, horiz.toString());

						lineMap.replace(new Integer(y1), currentLine,
								line.toString());
						for (Map.Entry<Integer, String> entry : lineMap
								.entrySet()) {
							shape = shape + "\n" + entry.getValue();
						}
						// Removing new line character
						if (shape.contains("\n"))
							shape = shape.substring(1);
						System.out.println(shape);

					} else if (x1 == x2) {
						/** creating Vertical line **/
						Set<Entry<Integer, String>> entrySet = lineMap
								.entrySet();
						for (Entry<Integer, String> entry : entrySet) {
							int key1 = entry.getKey();
							if (key1 >= y1 && key1 <= y2) {
								String value = entry.getValue();
								StringBuilder str = new StringBuilder();
								str.append(value);
								str.setCharAt(x1, 'X');
								lineMap.put(key1, str.toString());
							}
						}
						for (Map.Entry<Integer, String> entry : lineMap
								.entrySet()) {
							shape = shape + "\n" + entry.getValue();
						}
						// Removing new line character
						if (shape.contains("\n"))
							shape = shape.substring(1);
						System.out.println(shape);

					} else {
						System.out
								.println("only horizontal or vertical lines supported for command L");

					}
				}
			} catch (Exception e) {
				System.out.println("Error during Line creation");
				e.printStackTrace();
			}
		}

		return shape;
	}

	/**
	 * Drawing Rectangle
	 * 
	 * @param scanner
	 * @return
	 */
	protected static String drawRect(Scanner scanner) {

		String shape = "";
		if (WIDTH == 0 || HEIGHT == 0) {
			System.out.print("please give commands for creating canvas");
		} else {
			try {
				int x1 = scanner.nextInt();
				int y1 = scanner.nextInt();
				int x2 = scanner.nextInt();
				int y2 = scanner.nextInt();
				boolean flag = validate(x1, y1, x2, y2);
				if (flag) {
					/** Creating Rectangle **/
					StringTokenizer st = new StringTokenizer(canvas, "\n");
					Map<Integer, String> lineMap = new HashMap<Integer, String>();
					int key = 0;
					while (st.hasMoreTokens()) {
						lineMap.put(key, st.nextToken());
						key++;
					}

					if (x1 == x2 || y1 == y2) {
						System.out
								.println("Please enter correct values for rectangle");
					} else {
						// System.out.println("creating Rectangle");
						String firstLine = lineMap.get(y1);
						String lastLine = lineMap.get(y2);
						StringBuilder horiz = new StringBuilder();
						String str = lineMap.get(0).replace("-", "X");
						horiz.append(str, 0, x2 - x1);
						// System.out.println("String len: "+horiz.toString());

						StringBuilder upperLine = new StringBuilder();
						upperLine.append(firstLine);
						upperLine.replace(x1, x2, horiz.toString());

						StringBuilder lowerLine = new StringBuilder();
						lowerLine.append(lastLine);
						lowerLine.replace(x1, x2, horiz.toString());
						// System.out.println("horizontal size: "
						// +lowerLine.toString());

						lineMap.replace(new Integer(y1), firstLine,
								upperLine.toString());
						lineMap.replace(new Integer(y2), lastLine,
								lowerLine.toString());

						Set<Entry<Integer, String>> entrySet = lineMap
								.entrySet();
						for (Entry<Integer, String> entry : entrySet) {
							int key1 = entry.getKey();
							if (key1 >= y1 && key1 <= y2) {
								String value = entry.getValue();
								StringBuilder strBuilder = new StringBuilder();
								strBuilder.append(value);
								strBuilder.setCharAt(x1, 'X');
								strBuilder.setCharAt(x2, 'X');

								lineMap.put(key1, strBuilder.toString());
							}
						}

						for (Map.Entry<Integer, String> entry : lineMap
								.entrySet()) {
							shape = shape + "\n" + entry.getValue();
						}
						// Removing new line character
						if (shape.contains("\n"))
							shape = shape.substring(1);
						System.out.println("Rect \n" + shape);
					}
				}
			} catch (Exception e) {
				System.out.println("Error during Rectangle creation");
				e.printStackTrace();
			}

		}
		return shape;

	}

	/**
	 * To fill color in canvas
	 * 
	 * @param scanner
	 * @return
	 */
	protected static String fillColor(Scanner scanner) {

		String shape = "";
		if (WIDTH == 0 || HEIGHT == 0) {
			System.out.print("please give commands for creating canvas");
		} else {
			try {
				int x = scanner.nextInt();
				int y = scanner.nextInt();

				boolean flag = validate(x, y, x, y);
				String color = scanner.next();
				if (flag) {
					StringTokenizer st = new StringTokenizer(canvas, "\n");
					Map<Integer, String> lineMap = new HashMap<Integer, String>();
					int key = 0;
					while (st.hasMoreTokens()) {
						lineMap.put(key, st.nextToken());
						key++;
					}

					int line = y;
					while (line <= HEIGHT) {
						String row = lineMap.get(line);
						StringBuilder str = new StringBuilder();
						str.append(row);
						int col = x;
						while (row.charAt(col) != 'X' && col < WIDTH - 1) {
							str.setCharAt(col, color.charAt(0));
							col++;
						}
						col = x;
						while (row.charAt(col) != 'X' && col >= 1) {
							str.setCharAt(col, color.charAt(0));
							col--;
						}
						lineMap.put(line, str.toString());
						line++;
					}

					line = y;
					while (line > 0) {
						String row = lineMap.get(line);
						StringBuilder str = new StringBuilder();
						str.append(row);
						int col = x;
						while (row.charAt(col) != 'X' && col < WIDTH - 1) {
							str.setCharAt(col, color.charAt(0));
							col++;
						}
						col = x;
						while (row.charAt(col) != 'X' && col >= 1) {
							str.setCharAt(col, color.charAt(0));
							col--;
						}
						lineMap.put(line, str.toString());
						line--;
					}

					for (Map.Entry<Integer, String> entry : lineMap.entrySet()) {
						shape = shape + "\n" + entry.getValue();
					}
					// Removing new line character
					if (shape.contains("\n"))
						shape = shape.substring(1);
					System.out.println(shape);
				}
			} catch (Exception e) {
				System.out.println("Error while filling color");
				e.printStackTrace();
			}
		}

		return shape;

	}

	private static boolean validate(int x1, int y1, int x2, int y2) {
		if (x1 < 1) {
			System.out.print("x1 should not be less than 1");
			return false;
		}
		if (x2 > WIDTH - 2) {
			System.out.print("x2 should not be greater than " + (WIDTH - 2));
			return false;
		}
		if (y1 < 0) {
			System.out.print("y1 should not be less than 0");
			return false;
		}
		if (y2 > HEIGHT) {
			System.out.print("y2 should not be greater than " + (HEIGHT - 1));
			return false;
		}
		return true;
	}

}
