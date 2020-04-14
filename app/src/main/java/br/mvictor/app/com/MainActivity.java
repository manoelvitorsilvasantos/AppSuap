package br.mvictor.app.com;

import android.hardware.*;
import android.hardware.Camera.*;
import android.webkit.*;
import android.support.v7.app.*;
import android.widget.*;
import android.os.*;
import android.content.*;
import android.view.*;

public class MainActivity extends AppCompatActivity 
{
	
	
	private ToggleButton btn;
	private Camera mCamera;
	private TextView site, suap;
	private WebView web;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		btn = (ToggleButton) findViewById(R.id.btn);
		site = (TextView) findViewById(R.id.site);
		suap = (TextView) findViewById(R.id.suap);
		
		site.setOnClickListener(new TextView.OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					Intent site = new Intent(getApplicationContext(), Suap.class);
					startActivity(site);
				}
		});
		
    }
	
	public void flash(View view){ 
		if(btn.isChecked()){
			ligar();
		}
		else{
			desligar();
		}
	}
	
	

	@Override
	protected void onResume()
	{
		// TODO: Implement this method
		super.onResume();
		try{
			mCamera = Camera.open();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	protected void onPause()
	{
		// TODO: Implement this method
		if(mCamera != null){
			mCamera.release();
			mCamera = null;
		}
		super.onPause();
	}
	
	/**
	* Metodo responsavel por ligar o led.
	*/
	private void ligar(){
		if( mCamera != null ){
            Parameters params = mCamera.getParameters();
            params.setFlashMode( Parameters.FLASH_MODE_TORCH);
            mCamera.setParameters(params);
			mCamera.startPreview();
        }
	}
	
	/**
	* Metodo responsavel por desligae o led.
	*/
	private void desligar(){
		if( mCamera != null ){
            Parameters params = mCamera.getParameters();
            params.setFlashMode( Parameters.FLASH_MODE_OFF);
            mCamera.setParameters(params);
			mCamera.stopPreview();
        }
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		getMenuInflater().inflate(R.menu.menu, menu);
		// TODO: Implement this method
		return super.onCreateOptionsMenu(menu);
	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item)
	{
		switch(item.getItemId()){
			case R.id.about:
				Aviso("Sobre Aplicativo", "Desenvolvido por Victor BenYeshuati");
				break;
			case R.id.Credits:
				Aviso("Creditos", "Ifba-Irecê");
				break;
			case R.id.flash:
				startActivity(new Intent(getApplicationContext(), MainActivity.class));
				break;
			case R.id.exit:
				finish();
				break;
		}
		// TODO: Implement this method
		return super.onOptionsItemSelected(item);
	}

	private void Aviso(String titulo, String msg){
		AlertDialog.Builder alerta = new AlertDialog.Builder(this);
		alerta.setTitle(titulo);
		alerta.setMessage(msg);
		alerta.setOnDismissListener(new DialogInterface.OnDismissListener(){
				@Override
				public void onDismiss(DialogInterface p1)
				{
					// TODO: Implement this method
					p1.dismiss();
				}
		});
		alerta.create();
		alerta.show();	
	}
	
	
	
}
