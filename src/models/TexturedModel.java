package models;

import textures.ModelTexture;

/**
 * Created by xiaoweiwu on 4/24/16.
 */
public class TexturedModel {
    private RawModel rawModel;
    private ModelTexture texture;

    public TexturedModel(RawModel model,ModelTexture texture){
        this.rawModel=model;
        this.texture=texture;
    }

    public RawModel getRawModel() {
        return rawModel;
    }

    public ModelTexture getTexture() {
        return texture;
    }
}
