package canvas;

import java.util.Scanner;

public class TestCanvas {

	public static void main(String[] args) {

		testCreateCanvas();
		testCreateLine();
		testCreateRect();
		testFillColor();
		testNegativeCreateLine();
		
	}
	
	public static void testCreateCanvas() {
		String methodName = "testCreateCanvas";
		Scanner scanner = new Scanner("C 20 5");
		
		//CanvasGenerator canvas = new CanvasGenerator();
		String command = scanner.next();
		CanvasGenerator.WIDTH =  scanner.nextInt() + 2;
		CanvasGenerator.HEIGHT = scanner.nextInt();
		String output = CanvasGenerator.createCanvas();
		StringBuilder builder = new StringBuilder();
		
		builder.append("----------------------\n");
		builder.append("|                    |\n");
		builder.append("|                    |\n");
		builder.append("|                    |\n");
		builder.append("|                    |\n");
		builder.append("|                    |\n");
		builder.append("----------------------");
		
		if(builder.toString().equalsIgnoreCase(output)){
			System.out.println(methodName + ": Test passed");
		} else {
			System.out.println(methodName + ": Test Failed");

		}


	}
	
	public static void testCreateLine() {
		String methodName = "testCreateLine";
		Scanner scanner = new Scanner("L 1 2 5 2");
		
		StringBuilder canvasBuilder = new StringBuilder();
		canvasBuilder.append("----------------------\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("----------------------");
		
		String command = scanner.next();
		CanvasGenerator.WIDTH =  22;
		CanvasGenerator.HEIGHT = 5;
		CanvasGenerator.canvas = canvasBuilder.toString();
		String output = CanvasGenerator.drawLine(scanner);

		StringBuilder testOutput = new StringBuilder();
		testOutput.append("----------------------\n");
		testOutput.append("|                    |\n");
		testOutput.append("|XXXXX               |\n");
		testOutput.append("|                    |\n");
		testOutput.append("|                    |\n");
		testOutput.append("|                    |\n");
		testOutput.append("----------------------");
		if(testOutput.toString().equalsIgnoreCase(output)){
			System.out.println(methodName + ": Test passed");
		} else {
			System.out.println(methodName + ": Test Failed");

		}
	}
	
	public static void testCreateRect() {
		String methodName = "testCreateRect";
		Scanner scanner = new Scanner("R 15 2 20 4");
		
		StringBuilder canvasBuilder = new StringBuilder();
		canvasBuilder.append("----------------------\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("----------------------");
		
		String command = scanner.next();
		CanvasGenerator.WIDTH =  22;
		CanvasGenerator.HEIGHT = 5;
		CanvasGenerator.canvas = canvasBuilder.toString();
		String output = CanvasGenerator.drawRect(scanner);

		StringBuilder testOutput = new StringBuilder();
		testOutput.append("----------------------\n");
		testOutput.append("|                    |\n");
		testOutput.append("|              XXXXXX|\n");
		testOutput.append("|              X    X|\n");
		testOutput.append("|              XXXXXX|\n");
		testOutput.append("|                    |\n");
		testOutput.append("----------------------");
		if(testOutput.toString().equalsIgnoreCase(output)){
			System.out.println(methodName + ": Test passed");
		} else {
			System.out.println(methodName + ": Test Failed");

		}


	}

	public static void testFillColor() {
		String methodName = "testFillColor";
		Scanner scanner = new Scanner("B 2 2 o");
		
		StringBuilder canvasBuilder = new StringBuilder();
		canvasBuilder.append("----------------------\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("|              XXXXXX|\n");
		canvasBuilder.append("|              X    X|\n");
		canvasBuilder.append("|              XXXXXX|\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("----------------------");
		
		String command = scanner.next();
		CanvasGenerator.WIDTH =  22;
		CanvasGenerator.HEIGHT = 5;
		CanvasGenerator.canvas = canvasBuilder.toString();
		String output = CanvasGenerator.fillColor(scanner);

		StringBuilder testOutput = new StringBuilder();
		testOutput.append("----------------------\n");
		testOutput.append("|oooooooooooooooooooo|\n");
		testOutput.append("|ooooooooooooooXXXXXX|\n");
		testOutput.append("|ooooooooooooooX    X|\n");
		testOutput.append("|ooooooooooooooXXXXXX|\n");
		testOutput.append("|oooooooooooooooooooo|\n");
		testOutput.append("----------------------");
		if(testOutput.toString().equalsIgnoreCase(output)){
			System.out.println(methodName + ": Test passed");
		} else {
			System.out.println(methodName + ": Test Failed");

		}


	}

	public static void testNegativeCreateLine() {
		String methodName = "testNegativeCreateLine";
		Scanner scanner = new Scanner("L 1 2 5 4");
		
		StringBuilder canvasBuilder = new StringBuilder();
		canvasBuilder.append("----------------------\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("|                    |\n");
		canvasBuilder.append("----------------------");
		
		String command = scanner.next();
		CanvasGenerator.WIDTH =  22;
		CanvasGenerator.HEIGHT = 5;
		CanvasGenerator.canvas = canvasBuilder.toString();
		String output = CanvasGenerator.drawLine(scanner);

		StringBuilder testOutput = new StringBuilder();
		testOutput.append("----------------------\n");
		testOutput.append("|                    |\n");
		testOutput.append("|XXXXX               |\n");
		testOutput.append("|                    |\n");
		testOutput.append("|                    |\n");
		testOutput.append("|                    |\n");
		testOutput.append("----------------------");
		if(testOutput.toString().equalsIgnoreCase(output)){
			System.out.println(methodName + ": Test passed");
		} else {
			System.out.println(methodName + ": Test Failed");

		}
	}

}
