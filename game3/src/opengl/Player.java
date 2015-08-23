/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opengl;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author esmeail
 */
public class Player extends Character {

    float x;
    float y;
    float ScaleX;
    float ScaleY;

    // going up gravity v = (9.8t − 19.6) m/s
    float v = 0;
    float InitialJumpingV = 10.0f;
    float Distance = 0;
    float Gravity = 9.8f;
    float Time = 0;

    public Player(float x, float y, float ScaleX, float ScaleY) {
        this.x = x;
        this.y = y;
        this.ScaleX = ScaleX;
        this.ScaleY = ScaleY;
    }

    public void Draw() {
        float[] vertices = {(0.0f * ScaleX) + x, (0.0f * ScaleY) + y, (0.0f * ScaleX) + x, (1.0f * ScaleY) + y, (1.0f * ScaleX) + x, (1.0f * ScaleY) + y, (1.0f * ScaleX) + x, (0.0f * ScaleY) + y};
        FloatBuffer triangle = BufferUtils.createFloatBuffer(vertices.length);
        triangle.put(vertices);
        triangle.flip();
        GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
        // GL11.glColorPointer(3, GL11.GL_FLOAT, 0, triangleVertexBuffer);
        GL11.glVertexPointer(2, 0, triangle);
        GL11.glDrawArrays(GL11.GL_QUADS, 0, vertices.length / 2);
        GL11.glDisableClientState(GL11.GL_VERTEX_ARRAY);
    }

    boolean Jumping = false;

    int HowFarUp = 0;

    public void CheckDown() {

        if (Jumping == false) {
            FloatBuffer MatrixData = BufferUtils.createFloatBuffer(16);
            float[] Matrix = new float[16];
            MatrixData.rewind();
            GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, MatrixData);
            MatrixData.get(Matrix);
            for (int www = 0; Matrix.length > www; www++) {
                //System.out.print(Matrix[www] + " ");
            }
            //System.out.println();
            float Offset = 0;
            boolean z = false;
            FloatBuffer DATA = BufferUtils.createFloatBuffer(4);
            for (Offset = 0.0f; ScaleX >= Offset; Offset = Offset + 2.0f / 1920.0f) {
                DATA.rewind();
                GL11.glReadPixels((int) ((x + 1.0f + Matrix[12] + Offset) * 960.0f), (int) (((y + 1.0f - (2.0f / 1080.0f))) * 540.0f - 20.0f), 1, 1, GL11.GL_RGBA, GL11.GL_FLOAT, DATA); // 2/1920  // 2/1080
                //GL11.glReadPixels((int) ((-0.6f + 1.0f + Offset) * 960.0f), (int) (((-0.95f + 1.0f - (2.0f / 1080.0f))) * 540.0f ), 1, 1, GL11.GL_RGBA, GL11.GL_FLOAT, DATA);
                if (DATA.get() == 0.0f) {
                    z = true;
                } else {
                    Time = 0;
                    HowFarUp = 0;
                    z = false;
                    break;
                }

            }
            if (z == true) {
                Time = Time + 1.0f / 60.0f;
                y = y - (2.0f / 1080.0f) * (Gravity * Time);
            }
        } else {
           
            Time = Time + 1.0f / 60.0f;
            v = (Gravity * Time - InitialJumpingV) * -1;
            HowFarUp++;
            if (v > 0) {
                y = y + (2.0f / 1080.0f) * v;
            } else {
                //HowFarUp = 0;
                Time = 0;
                Jumping = false;
            }

        }
    }

    public void Jump() {
        if (HowFarUp == 0) {
            Jumping = true;
        }

    }

    float TimeMoveF = 0.0f;
    float Acceleration = 0.1f;
    public void MoveForward() {
         System.out.println("Time " + TimeMoveF + " v = " + TimeMoveF*Acceleration);
        TimeMoveF = TimeMoveF + 1.0f/60.0f;
        GL11.glTranslatef(-2.0f / 1920.0f - TimeMoveF*Acceleration, 0, 0);
        x = x + 2.0f / 1920.0f + TimeMoveF*Acceleration;

    }

}
