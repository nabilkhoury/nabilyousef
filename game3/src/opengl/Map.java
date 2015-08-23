/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package opengl;

import java.nio.FloatBuffer;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;

/**
 *
 * @author esmeail
 */
public class Map {

    public Map() {
    }
    
    
        
    public void Draw()
    {
    
        float[] vertices = {-1.0f, -1.0f,-1.0f, -0.8f,0.7f, -0.8f,0.7f, -1.0f,
        1.0f, -1.0f     ,1.0f, -0.2f        ,10000.7f, -0.97f         ,10000.7f, -1.0f
        };
        FloatBuffer triangle= BufferUtils.createFloatBuffer( vertices.length );
        triangle.put(vertices);
        triangle.flip();
            GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
           // GL11.glColorPointer(3, GL11.GL_FLOAT, 0, triangleVertexBuffer);
            GL11.glVertexPointer(2, 0, triangle);
            GL11.glDrawArrays(GL11.GL_QUADS, 0, vertices.length/2);
            GL11.glDisableClientState(GL11.GL_VERTEX_ARRAY);
    
    }
    
}
