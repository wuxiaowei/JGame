package toolbox;

import org.lwjgl.util.vector.Matrix4f;
import org.lwjgl.util.vector.Vector3f;

/**
 * Created by xiaoweiwu on 4/30/16.
 */
public class Maths {

    public static Matrix4f createTransformationMatrix(Vector3f translation,float rx,float ry,float rz,float scale){
        Matrix4f matrix=new Matrix4f();
        matrix.setIdentity();
        matrix.translate(translation,matrix,matrix);
        matrix.rotate((float) Math.toRadians(rx),new Vector3f(1,0,0),matrix,matrix);
        matrix.rotate((float) Math.toRadians(ry),new Vector3f(0,1,0),matrix,matrix);
        matrix.rotate((float) Math.toRadians(rz),new Vector3f(0,0,1),matrix,matrix);
        matrix.scale(new Vector3f(scale,scale,scale),matrix,matrix);
        return matrix;
    }
}
