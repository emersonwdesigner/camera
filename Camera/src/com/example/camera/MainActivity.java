package com.example.camera;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.util.Log;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnDragListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

@SuppressLint("NewApi")
public class MainActivity extends Activity {
	 
    private ImageView imageView, foto;
    //private ViewGroup dropedArea;
    private LinearLayout draggedArea, conteudo, dropedArea;
    private TextView numero;
 
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        imageView = (ImageView)findViewById(R.id.imageViewDragged);
        foto = (ImageView)findViewById(R.id.foto);
        numero = (TextView)findViewById(R.id.numero);
        //imageView.setOnTouchListener(new TouchListener()); 
 
        draggedArea = (LinearLayout)findViewById(R.id.dragged_area);
        conteudo  = (LinearLayout)findViewById(R.id.conteudo);
        dropedArea = (LinearLayout)findViewById(R.id.drop_area);
        
        foto.setY(-100);
        
      //  dropedArea.setOnDragListener(new DragListener());
        
        /**
        dropedArea.setOnTouchListener(new OnTouchListener() {
        	@Override
        	public boolean onTouch(View v, MotionEvent evento) {
        		numero.setText(String.valueOf((int) evento.getX()));
        		return false;
        	}
        });
        **/
    }
    
    public void img(View v){
    	
    	conteudo.setOrientation(LinearLayout.VERTICAL);
    	//conteudo.animate().y(200);
    	dropedArea.animate().y(300);
    	
    	new Thread(new Runnable() {
            @Override
            public void run() {
   	try {   
   		Thread.sleep(500);
   	////imageView.animate().rotationX(180);
    	//imageView.animate().rotationY(180);
    	imageView.animate().scaleY(5);
    	imageView.animate().x(50);
    	imageView.animate().y(100);
   	}catch(Exception e){
   		
   	}
            }
            }).start();
    	
    	
    	
    }
 /**
    @Override
    public boolean onTouchEvent(final MotionEvent event) {
      final float x = event.getX();
      final float y = event.getY();
      numero.setText(String.valueOf((int) event.getX()));
      imageView.setMinimumHeight((int) event.getX());
      draggedArea.setMinimumHeight((int) event.getX());
    switch (event.getAction()) {
    
     case MotionEvent.ACTION_DOWN:
        Log.i("ON TOUCH EVENT", "DOWN + X: " + x + " Y " + y);
     break;
    
     case MotionEvent.ACTION_MOVE:
       Log.i("ON TOUCH EVENT", "MOVE + X: " + x + " Y " + y);
     break;
    
     case MotionEvent.ACTION_UP:
        Log.i("ON TOUCH EVENT", "UP + X: " + x + " Y " + y);
     break;
    
     default:
     break;
   }
    
    return super.onTouchEvent(event);
   }
   **/
}
