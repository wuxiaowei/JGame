package engineTester;

import entities.Entity;
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
		Renderer renderer=new Renderer();
		StaticShader shader=new StaticShader();

		float[] vertices={
				-0.5f,0.5f,0f,
				-0.5f,-0.5f,0f,
				0.5f,-0.5f,0f,
				0.5f,0.5f,0f,				
		};
		int[] indices={
				0,1,3,
				3,1,2
		};

		float[] textureCoords={
				0,0,
				0,1,
				1,1,
				1,0
		};
		
		
		RawModel model=loader.loadToVAO(vertices,textureCoords,indices);
		ModelTexture texture=new ModelTexture(loader.loadTexture("image"));
		TexturedModel texturedModel=new TexturedModel(model,texture);

		Entity entity=new Entity(texturedModel,new Vector3f(-1,0,0),0,0,0,1);


		while(!Display.isCloseRequested()){
			renderer.prepare();
			shader.start();
			renderer.render(entity,shader);
			shader.stop();
			DisplayManager.updateDisplay();
		}
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();
	}

}
