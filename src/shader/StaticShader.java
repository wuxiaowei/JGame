package shader;

import org.lwjgl.util.vector.Matrix4f;

/**
 * Created by xiaoweiwu on 4/24/16.
 */
public class StaticShader extends ShaderProgram {
    private static final String VERTEX_FILE="src/shader/vertexShader.txt";
    private static final String FRAGMENT_FILE="src/shader/fragmentShader.txt";
    public  StaticShader(){
        super(VERTEX_FILE,FRAGMENT_FILE);
    }
    private int location_transformationMatrix;
    @Override
    protected void getAllUniformLocation() {
        location_transformationMatrix=super.getUniformLocation("transformationMatrix");
    }

    @Override
    protected void bindAttributes() {
        super.bindAttributes(0,"position");
        super.bindAttributes(1,"textureCoords");
    }

    public void loadTransformationMatrix(Matrix4f matrix){
        super.loadMatrix(location_transformationMatrix,matrix);
    }
}
