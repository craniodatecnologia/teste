package com.craniodatecnologia.base2;
import android.app.*;
import android.os.*;
import android.content.*;
import android.view.animation.*;
import android.widget.*;

public class Splash extends Activity implements Runnable, Animation.AnimationListener
{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash);
		
		ImageView logoAbertura = (ImageView) findViewById(R.id.splashImagem);
		//Animation animation0 = AnimationUtils.loadAnimation(Splash.this, 
		//R.anim.fade);
		//logoAbertura.startAnimation(animation0);
		
		TextView aguarde = (TextView)findViewById(R.id.splashTextViewAguarde);
		//Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), 
		//R.anim.fade);
		//aguarde.startAnimation(animation1);
		
		TextView textView1 = (TextView)findViewById(R.id.splashTextView1);
		//Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), 
		//R.anim.fade);
		//textView1.startAnimation(animation2);
		
		
		TranslateAnimation localTranslateAnimation = new TranslateAnimation(0, -200.0F, 0, 0.0F, 0, 0.0F, 0, 0.0F);
		localTranslateAnimation.setInterpolator(new BounceInterpolator());
		localTranslateAnimation.setDuration(1500L);
		textView1.setAnimation(localTranslateAnimation);
		localTranslateAnimation.start();
		
		ScaleAnimation localScaleAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
		localScaleAnimation.setInterpolator(new OvershootInterpolator(2.0F));
		localScaleAnimation.setAnimationListener(this);
		localScaleAnimation.setDuration(1500L);
		logoAbertura.setAnimation(localScaleAnimation);
		localScaleAnimation.start();
		
		}
		
	@Override
	public void run()
	{
		Intent i = new Intent(Splash.this, MainActivity.class);
		startActivity(i);

		// Fecha esta activity
		finish();
	}
	
	
	@Override
	public void onAnimationStart(Animation p1)
	{
		// TODO: Implement this method
	}

	@Override
	public void onAnimationEnd(Animation p1)
	{
		new Handler().postDelayed(this, 500L);
	}

	@Override
	public void onAnimationRepeat(Animation p1)
	{
		// TODO: Implement this method
	}
}
