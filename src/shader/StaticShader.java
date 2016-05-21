package shader;

import entities.Camera;
import entities.Light;
import org.lwjgl.util.vector.Matrix4f;
import toolbox.Maths;

/**
 * Created by xiaoweiwu on 4/24/16.
 */
public class StaticShader extends ShaderProgram {
    private static final String VERTEX_FILE="src/shader/vertexShader.glsl";
    private static final String FRAGMENT_FILE="src/shader/fragmentShader.glsl";
    public  StaticShader(){
        super(VERTEX_FILE,FRAGMENT_FILE);
    }
    private int location_transformationMatrix;
    private int location_projectionMatrix;
    private int location_viewMatrix;
    private int location_lightPosition;
    private int location_lightColour;
    private int location_shineDamper;
    private int location_reflectivity;


    @Override
    protected void getAllUniformLocation() {
        location_transformationMatrix=super.getUniformLocation("transformationMatrix");
        location_projectionMatrix=super.getUniformLocation("projectionMatrix");
        location_viewMatrix=super.getUniformLocation("viewMatrix");
        location_lightPosition=super.getUniformLocation("lightPosition");
        location_lightColour=super.getUniformLocation("lightColour");
        location_shineDamper=super.getUniformLocation("shineDamper");
        location_reflectivity=super.getUniformLocation("reflectivity");
    }

    @Override
    protected void bindAttributes() {
        super.bindAttributes(0,"position");
        super.bindAttributes(1,"textureCoords");
        super.bindAttributes(2,"normal");
    }

    public void loadShineVariables(float damper,float reflectivity){
        super.loadFloat(location_shineDamper,damper);
        super.loadFloat(location_reflectivity,reflectivity);
    }

    public void loadTransformationMatrix(Matrix4f matrix){
        super.loadMatrix(location_transformationMatrix,matrix);
    }
    public void loadLight(Light light){
        super.loadVector(location_lightPosition,light.getPosition());
        super.loadVector(location_lightColour,light.getColour());
    }

    public void loadViewMatrix(Camera camera){
        Matrix4f viewMatrix= Maths.createViewMatrix(camera);
        super.loadMatrix(location_viewMatrix,viewMatrix);
    }

    public void loadProjectionMatrix(Matrix4f projection){
        super.loadMatrix(location_projectionMatrix,projection);
    }
}
