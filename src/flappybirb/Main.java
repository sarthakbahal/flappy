package flappybirb;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import static org.lwjgl.opengl.GL11.*;
import org.lwjgl.opengl.PixelFormat;

public class Main implements Runnable {

	private int width = 1280;
	private int height = 800 ;
	private String title = "Flappy";
	
	private boolean running = false;
	private Thread thread;
	
	public void start() {
		running = true;
		thread = new Thread(this, "Display");
		thread.start();
		 
	}
	
	private void init(){
		String version = glGetString(GL_VERSION);
		System.out.println("OpenGL" + version);
		
		glClearColor(1.0f,1.0f,1.0f,1.0f);
	}	
	public void run() {
		try {
			Display.setDisplayMode(new DisplayMode(width, height));
			Display.setTitle(title);
			ContextAttribs context = new ContextAttribs(3,3);
			Display.create(new PixelFormat(), context.withProfileCore(true));
		} catch (LWJGLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		init();
		
		while(running) {
			Display.update();
			if(Display.isCloseRequested())running = false;
			
			
			
		}
		 Display.destroy();
		 
	}
	
	private void render() {
		glClear(GL_COLOR_BUFFER_BIT);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main().start();
		
		

	}

}
