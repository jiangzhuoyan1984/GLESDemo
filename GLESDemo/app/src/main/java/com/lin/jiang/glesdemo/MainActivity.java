package com.lin.jiang.glesdemo;

import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import javax.microedition.khronos.opengles.GL10;

public class MainActivity extends AppCompatActivity implements IOpenGL {

    private GLSurfaceView mGLSurfaceView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        mGLSurfaceView = new GLSurfaceView(this);
        mGLSurfaceView.setRenderer(new OpenGLRenderer(this));
        setContentView(mGLSurfaceView);
    }

    @Override
    public void drawScene(GL10 gl) {
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        // Clears the screen and depth buffer.
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
    }

    @Override
    protected void onResume() {
        // Ideally a game should implement
        // onResume() and onPause()
        // to take appropriate action when the
        //activity looses focus
        super.onResume();
        mGLSurfaceView.onResume();
    }
    @Override
    protected void onPause() {
        // Ideally a game should implement onResume()
        //and onPause()
        // to take appropriate action when the
        //activity looses focus
        super.onPause();
        mGLSurfaceView.onPause();
    }
}
