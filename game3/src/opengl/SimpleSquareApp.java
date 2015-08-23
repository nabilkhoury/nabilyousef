package opengl; //package is a fold that contains SimpleSquareApp.class

//import org.lwjgl.LWJGLException; //import the required classes for SimpleSquareApp
//import org.lwjgl.opengl.Display;
import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

// class name of SimpleSquareApp
public class SimpleSquareApp {

// main method where the program starts executing
    public static void main(String arg[]) throws LWJGLException, InterruptedException {
        boolean close = false;  //close is a variable that is set to true is the window close button is clicked.
        Display.create();    //create and make visible a display frame to draw on.
        //setup the size of the display to be drawn into.
        //GL11.glViewport(0, 0, 800, 800);
        Display.setFullscreen(true);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();

   
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        Player p = new Player(-0.6f, 0.89f, 0.1f, 0.1f);
        Player[] p3 = new Player[5];
        long StartTime = System.currentTimeMillis();
        long TimeElapsed = System.currentTimeMillis();
        long DiffTime = 0;

        Map MP = new Map();
        int u = 2;
        while (!close) //loop until user clicks of frame icon.
        {
            
            if (Keyboard.isKeyDown(Keyboard.KEY_LEFT)) {
                GL11.glTranslatef(2.0f / 1920.0f, 0, 0);
                p.x = p.x - 2.0f / 1920.0f;
            }
            if (Keyboard.isKeyDown(Keyboard.KEY_RIGHT)) {
                p.MoveForward();
            }else
            {
                p.TimeMoveF = 0.0f;
            
            }
          

            if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)) {

                p.Jump();
            }

            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
            
            MP.Draw();
            p.Draw();
            Display.update();
            Display.sync(60);
            p.CheckDown();
            //Thread.sleep(1);
            close = Display.isCloseRequested();   //check for user clicking on from close icon.

        }

        Display.destroy();   //destroy the graphics frame.
        System.exit(0);  //exit java program.
    }

}
