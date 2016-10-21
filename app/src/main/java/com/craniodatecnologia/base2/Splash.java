package com.craniodatecnologia.base2;
import android.app.*;
import android.os.*;
import android.content.*;
import android.view.animation.*;
import android.widget.*;

public class Splash extends Activity {
	
	// Timer da splash screen
	private static int SPLASH_TIME_OUT = 5000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		/*
		ImageView logoAbertura = (ImageView) findViewById(R.id.splashImagem);
		Animation animation0 = AnimationUtils.loadAnimation(Splash.this, 
		R.anim.fade);
		logoAbertura.startAnimation(animation0);
		*/
		
		TextView aguarde = (TextView)findViewById(R.id.splashTextViewAguarde);
		Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), 
		R.anim.piscar);
		aguarde.startAnimation(animation);
		
		new Handler().postDelayed(new Runnable() {
				/*
				 Exibindo splash com um timer.
				 */
				@Override
				public void run() {
					// Esse método será executado sempre que o timer acabar
					// E inicia a activity principal
					Intent i = new Intent(Splash.this, MainActivity.class);
					startActivity(i);

					// Fecha esta activity
					finish();
				}
			},
			SPLASH_TIME_OUT);
	}
}
