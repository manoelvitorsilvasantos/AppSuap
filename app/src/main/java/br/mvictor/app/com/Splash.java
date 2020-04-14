package br.mvictor.app.com;
import android.*;
import android.content.*;
import android.os.*;
import android.support.v7.app.*;

public class Splash extends AppCompatActivity
{
	private static int Time_ShutDown = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
	
		new Handler().postDelayed(new Runnable(){
				@Override
				public void run()
				{
					Intent intent = new Intent(Splash.this, Suap.class);
					startActivity(intent);
					// TODO: Implement this method
					finish();
				}
			
		}, Time_ShutDown);
	}
}
