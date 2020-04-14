package br.mvictor.app.com;
import android.*;
import android.content.*;
import android.graphics.*;
import android.os.*;
import android.support.design.widget.*;
import android.support.v7.app.*;
import android.view.*;
import android.webkit.*;
import android.widget.*;

public class Suap extends AppCompatActivity
{

	private WebView web;
	private FloatingActionButton fab, fab1, fab2, fab3;

	private boolean isFABOpen=false;
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		// TODO: Implement this method
		super.onCreate(savedInstanceState);
		setContentView(R.layout.webpage);
		
		final ProgressBar barra = (ProgressBar) findViewById(R.id.progress);
		barra.setVisibility(View.INVISIBLE);
		
		fab = (FloatingActionButton) findViewById(R.id.fab);
		fab1 = (FloatingActionButton) findViewById(R.id.fabOne);
		fab2 = (FloatingActionButton) findViewById(R.id.fabTwo);
		fab3 = (FloatingActionButton) findViewById(R.id.fabThree);
		
		fab.setOnClickListener(new FloatingActionButton.OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					if(!isFABOpen){
						showFabMenu();
					}
					else{
						closeFABMenu();
					}
				}
		});
		
		fab1.setOnClickListener(new FloatingActionButton.OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					// TODO: Implement this method
					StringBuilder texto = new StringBuilder();
					texto.append("Desenvolvido por Manoel Vitor \n");
					texto.append("\n Créditos Ifba-Irecê");
					Aviso("Sobre App", texto.toString());
				}
		});
		
		web = (WebView) findViewById(R.id.webView);
		WebSettings setting = web.getSettings();
		setting.setJavaScriptEnabled(true);
		web.loadUrl("http://suap.ifba.edu.br/");
		//web.setWebViewClient(new WebViewClient());
			
		web.setWebViewClient(new WebViewClient(){
        
		@Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            barra.setVisibility(View.VISIBLE); // mostra a progress
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            barra.setVisibility(View.INVISIBLE); // esconde a progress
        }
    });
	
		
	
		
	}
	
	@Override
	public void onBackPressed()
	{	
		if(web.canGoBack()){
			web.goBack();
		}
		else{
			super.onBackPressed();
		}
	
	}
	
	/*
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
				Aviso("Creditos", "Ifba-Instituto Federal de Ciência Técnologia \n Bahia -Irecê");
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
	*/
	
	private void closeFABMenu(){
		isFABOpen=false;
		fab1.animate().translationY(0).translationX(0);
		fab2.animate().translationY(0).translationX(0);
		fab3.animate().translationY(0).translationX(0);
	}
	private void showFabMenu(){
		isFABOpen=true;
		fab1.animate().translationX(0).translationY(-getResources().getDimension(R.dimen.fabA));
		fab2.animate().translationX(0).translationY(-getResources().getDimension(R.dimen.fabB));
		fab3.animate().translationX(0).translationY(-getResources().getDimension(R.dimen.fabC));
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
