package shader;

import entities.Camera;
import org.lwjgl.util.vector.Matrix4f;
import toolbox.Maths;

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
    private int location_projectionMatrix;
    private int location_viewMatrix;

    @Override
    protected void getAllUniformLocation() {
        location_transformationMatrix=super.getUniformLocation("transformationMatrix");
        location_projectionMatrix=super.getUniformLocation("projectionMatrix");
        location_viewMatrix=super.getUniformLocation("viewMatrix");
    }

    @Override
    protected void bindAttributes() {
        super.bindAttributes(0,"position");
        super.bindAttributes(1,"textureCoords");
    }

    public void loadTransformationMatrix(Matrix4f matrix){
        super.loadMatrix(location_transformationMatrix,matrix);
    }

    public void loadViewMatrix(Camera camera){
        Matrix4f viewMatrix= Maths.createViewMatrix(camera);
        super.loadMatrix(location_viewMatrix,viewMatrix);
    }

    public void loadProjectionMatrix(Matrix4f projection){
        super.loadMatrix(location_projectionMatrix,projection);
    }
}
