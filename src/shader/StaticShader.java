package shader;

/**
 * Created by xiaoweiwu on 4/24/16.
 */
public class StaticShader extends ShaderProgram {
    private static final String VERTEX_FILE="src/shader/vertexShader.txt";
    private static final String FRAGMENT_FILE="src/shader/fragmentShader.txt";
    public  StaticShader(){
        super(VERTEX_FILE,FRAGMENT_FILE);
    }
    @Override
    protected void bindAttributes() {
        super.bindAttributes(0,"position");
        super.bindAttributes(1,"textureCoords");
    }
}
