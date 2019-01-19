import engine.SeparateAxisRectangleCollisionDetector;
import io.FileInput;
import io.FileOutput;
import io.InputChannel;
import io.OutputChannel;
import loader.RectangleJsonLoader;
import model.Intersection;
import model.Rectangle;
import renderer.RectangleStringRenderer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by malang on 17/01/19.
 */
public class RunnableMain {

    public static void main(String[] args) throws UnsupportedEncodingException {
        if (args == null || args.length < 1)
            throw new IllegalArgumentException("Please provide the input file path");

        InputChannel input = new FileInput(args[0]);
        String outputFilePath = args[1];
        OutputChannel output = new FileOutput(outputFilePath);
        //InputChannel input = new ConsoleInput();
        // OutputChannel output = new ConsoleOutput();

        RectangleJsonLoader loader = new RectangleJsonLoader(input);

        RectangleStringRenderer renderer = new RectangleStringRenderer(output);

        List<Rectangle> rectangles = loader.loadShapes(10); // load max 10 rectangles

        try(BufferedWriter bfw = new BufferedWriter(new FileWriter(outputFilePath))) {
            System.out.println("Input:");
            bfw.write("Input:\n");
            for (Rectangle r : rectangles) {
                renderer.render(r);
                String out = String.format("    %s\n", renderer.getRenderedOutput());
                System.out.print(out);
                bfw.write(out);
            }

            System.out.println("\nIntersections:");
            bfw.write("\nIntersections:\n");
            SeparateAxisRectangleCollisionDetector collisionDetector = new SeparateAxisRectangleCollisionDetector();
            List<Intersection> intersections = collisionDetector.getIntersections(rectangles);
            int currentIndex = 0;
            for(Intersection i: intersections) {
                currentIndex++;
                renderer.render(i);
                String out = String.format("    %s: %s\n", currentIndex, i);
                System.out.print(out);
                bfw.write(out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
