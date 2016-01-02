/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.johnogel.astrobros.managers;

import box2dLight.Light;
import box2dLight.PointLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.johnogel.astrobros.interfaces.Controller;
import com.johnogel.astrobros.interfaces.GameObject;
import com.johnogel.astrobros.levels.Level;

/**
 *
 * @author johno-gel
 */
public class GameOverScreen extends GameScreen{
    private final BitmapFont font;
    private CharSequence game_over, timer_chars;
    private GlyphLayout layout;
    final float fontX;
    final float fontY;

    
    public GameOverScreen(GameManager mngr){
       
        super(mngr);
        
        font = new BitmapFont(Gdx.files.internal("data/score.fnt"));
        font.getData().setScale(0.3f, 0.3f);        
  
        game_over = "GAME_OVER";
        layout = new GlyphLayout(font, game_over);
        fontX =  -layout.width / 2;
        fontY =  10;
    }

    @Override
    public void update() {
        if(Gdx.input.isKeyJustPressed(Input.Keys.SPACE)){
            mngr.setLevel(mngr.getCurrentLevel());
        }
        ray_handler.setCombinedMatrix(camera.combined);
        camera.rotate(1.3f);
        camera.update();
    }

    @Override
    public void render() {
        batch.setProjectionMatrix(camera.projection);
        
        batch.begin();
        font.draw(batch, layout, fontX, fontY);
        batch.end();

        
    }

    @Override
    public void initialize() {
        initializeWorld();
        this.updateReferences();
        PointLight light = new PointLight(ray_handler, 5000, Color.RED, 700, camera.viewportWidth/2, -300 );

        
    }

    
}
