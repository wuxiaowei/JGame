package engineTester;

import entities.Camera;
import entities.Entity;
import entities.Light;
import models.RawModel;
import models.TexturedModel;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.vector.Vector3f;
import renderEngine.*;

import renderEngine.DisplayManager;
import shader.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DisplayManager.createDisplay();
		
		Loader loader=new Loader();
		StaticShader shader=new StaticShader();
		Renderer renderer=new Renderer(shader);

//		float[] vertices={
//				-0.5f,0.5f,0f,
//				-0.5f,-0.5f,0f,
//				0.5f,-0.5f,0f,
//				0.5f,0.5f,0f,
//		};
//		int[] indices={
//				0,1,3,
//				3,1,2
//		};
//
//		float[] textureCoords={
//				0,0,
//				0,1,
//				1,1,
//				1,0
//		};
		
		
		RawModel model=OBJLoader.loadObjModel("stall",loader);
		TexturedModel texturedModel=new TexturedModel(model,new ModelTexture(loader.loadTexture("image")));

		ModelTexture texture=texturedModel.getTexture();
		texture.setShineDamper(10);
		texture.setReflectivity(1);

		Entity entity=new Entity(texturedModel,new Vector3f(0,0,-25),0,0,0,1);
		Light light=new Light(new Vector3f(0,0,-20),new Vector3f(1,1,1));

		Camera camera=new Camera();

		while(!Display.isCloseRequested()){
//			entity.increasePosition(0,0,-0.1f);
			entity.increaseRotation(0,1,0);
			camera.move();
			renderer.prepare();
			shader.start();
			shader.loadLight(light);
			shader.loadViewMatrix(camera);
			renderer.render(entity,shader);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
