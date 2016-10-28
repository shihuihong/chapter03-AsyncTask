package com.example.asynctask;
import android.graphics.Color;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;


public class DownTask extends AsyncTask <Integer,Integer,String>{
	private TextView tv;
	private ProgressBar pb;
	DownTask(TextView tv,ProgressBar pb){
		this.tv=tv;
		this.pb=pb;
		
	}
	public DownTask(){

}
	protected String doInBackground(Integer...param){
		for(int i=0;i<=100;i++){
			publishProgress(i);
			try{
				Thread.sleep(param[0]);
				
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
		return"�������";
		
	}
	protected void onPreExecute(){
		super.onPreExecute();
		
	}
     protected void onPreExecute(String result){
    	 tv.setText(result);
    	 tv.setTextColor(Color.RED);
    	 tv.setTextSize(20);
    	 pb.setVisibility(View.INVISIBLE);
    	 super.onPostExecute(result);
    	 
    	 
     }
     protected void onProgressUpdate(Integer...param){
    	 tv.setText("��ǰ��������"+param[0]+"%"); 
    	 pb.setProgress(param[0]);
    	 tv.setVisibility(View.VISIBLE);
    	 pb.setVisibility(View.VISIBLE);
    	 super.onProgressUpdate(param);
     }
     
}
    