package com.example.barometer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.profilemodel;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import com.androidbegin.Imageloder.ImageLoader;

import adpter.profileadpter;
import android.app.Activity;
import android.app.ProgressDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView.FindListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;

public class stastictabbar extends Act_TabBar {

	Spinner spn;
	TextView textcountryname, textlongname, txtupdatetext, contentdata;
	Act_TabBar atb;
	String Url;
	Context mcontext;
	TextView dynamicText;
	String test, promsg, cmstxt;
	public static final String MY_PREFS_NAME = "MyPrefsFile";
	String[] name;
	ProgressDialog loading;
	
	ImageView backscreen, imageview;
	ListView listdata, conventiondata;
	String oil1, oil2, oil3, oil4, oil5, oil6, oil7, oil8, oil9;
	String countryname, countrylongname, lastupdatedata, contentinfo,
			imagepath, countrynamethree, population;
	TextView lastupdated, countrynametrty, txtpopulation, title,
			countryterriory, populationtra, txtname;
	TextView oli_a, oli_b, oli_c, oli_d, oli_e, oli_f, oli_g, oli_h, oli_i,
			ilo_tra;
	List<String> regions;
	String titles = "";
	String intr, edu, ear, pri, sec, ter, chi, ref, mino, aca, gen, child,
			footnote, trade, sel;
	String selectedItem;
	List<String> li;
	int len;
	String id2;
	Context context;
	EditText editText;
	TextView btnsubmit, profilesubmit;
	ArrayList<String> worldlist;
	JSONObject alldata = new JSONObject();
	
	RelativeLayout introduction_l,
	texteducation_l,textearlychildhood_l,
	textprimary_l,textsecondary_l,
	texttertiary_l,textspecialneed_l,
	textrefugee_l,textminority_l,
	textacademic_l,
	textgender_l,textchildlabour_l,texttradeunion_l,footnote_l;
	
	TextView introduction_t,texteducation_t,textearlychildhood_t,textprimary_t,textsecondary_t,texttertiary_t,textspecialneed_t,textrefugee_t,textminority_t,textacademic_t,
	textgender_t,textchildlabour_t,texttradeunion_t,footnote_t;
	
	TextView last_update;

	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.stasticprofile);
		atb = new Act_TabBar();
		initialize_Controls();
		initialization();
		mcontext=this;
		// Dialog=new ProgressDialog(mcontext);
		mcontext=this;
        loading=new ProgressDialog(mcontext);
		spn = (Spinner) findViewById(R.id.spinner1);

		title = (TextView) findViewById(R.id.title1);
		last_update= (TextView) findViewById(R.id.last_update);
		introduction_l= (RelativeLayout)findViewById(R.id.into_l);
		texteducation_l= (RelativeLayout)findViewById(R.id.education_l);
		textearlychildhood_l= (RelativeLayout)findViewById(R.id.early_l);
		textprimary_l= (RelativeLayout)findViewById(R.id.primary_l);
		textsecondary_l= (RelativeLayout)findViewById(R.id.secondary_l);
		texttertiary_l= (RelativeLayout)findViewById(R.id.higher_l);
		
		textspecialneed_l= (RelativeLayout)findViewById(R.id.childern_l);
		textrefugee_l= (RelativeLayout)findViewById(R.id.refugee_l);	
		textacademic_l= (RelativeLayout)findViewById(R.id.academic_l);
		textgender_l= (RelativeLayout)findViewById(R.id.gender_l);
		
		textchildlabour_l= (RelativeLayout)findViewById(R.id.childla_l);
		texttradeunion_l= (RelativeLayout)findViewById(R.id.trade_l);
		footnote_l= (RelativeLayout)findViewById(R.id.footnote_l);
		textminority_l= (RelativeLayout)findViewById(R.id.minoriti_l);
		
		introduction_t= (TextView)findViewById(R.id.into);
		
		texteducation_t= (TextView)findViewById(R.id.education);
		textearlychildhood_t= (TextView)findViewById(R.id.early);
		textprimary_t= (TextView)findViewById(R.id.primary);
		textsecondary_t= (TextView)findViewById(R.id.secondary);
		texttertiary_t= (TextView)findViewById(R.id.higher);
		
		textspecialneed_t= (TextView)findViewById(R.id.childern);
		textrefugee_t= (TextView)findViewById(R.id.refugee);
		textacademic_t= (TextView)findViewById(R.id.acadamic);
		textgender_t= (TextView)findViewById(R.id.gender);
		
		textchildlabour_t= (TextView)findViewById(R.id.childla);
		texttradeunion_t= (TextView)findViewById(R.id.trade);
		footnote_t= (TextView)findViewById(R.id.footnote);
		textminority_t= (TextView)findViewById(R.id.minoriti);
		
		
		introduction_l.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(stastictabbar.this,profiledetail.class);

				startActivity(i);
				
				
			}
		});
		
		texteducation_l.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(stastictabbar.this, acdami.class);
				startActivity(i);
				
			}
		});
		
		textearlychildhood_l.setOnClickListener(new View.OnClickListener()
		{
			
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(stastictabbar.this, early.class);
				startActivity(i);
				
			}
		});
		
		textprimary_l.setOnClickListener(new View.OnClickListener() 
		{
			
			@Override
			public void onClick(View v) 
			{
				Intent i = new Intent(stastictabbar.this, primary.class);
				startActivity(i);
				
			}
		});

			textsecondary_l.setOnClickListener(new View.OnClickListener() 
			{
	
				@Override
				public void onClick(View v) 
				{
					Intent i = new Intent(stastictabbar.this, secondary.class);
					startActivity(i);
		
				}
			});

			texttertiary_l.setOnClickListener(new View.OnClickListener() 
			{
	
				@Override
				public void onClick(View v) 
				{
	
					Intent i = new Intent(stastictabbar.this, tertiary.class);
					startActivity(i);
				}
			});
			
			textspecialneed_l.setOnClickListener(new View.OnClickListener() 
			{
	
				@Override
				public void onClick(View v) 
				{
					Intent i = new Intent(stastictabbar.this,secondarydetail.class);
					startActivity(i);

		
				}
			});
			
			textrefugee_l.setOnClickListener(new View.OnClickListener() 
			{
	
				@Override
				public void onClick(View v) 
				{
					Intent i = new Intent(stastictabbar.this,Refugee.class);
					startActivity(i);

		
				}
			});
			
			textacademic_l.setOnClickListener(new View.OnClickListener() 
			{
	
				@Override
				public void onClick(View v) 
				{
					Intent i = new Intent(stastictabbar.this,
							acdfreedom.class);
					startActivity(i);

		
				}
			});
			
			textgender_l.setOnClickListener(new View.OnClickListener() 
			{
	
				@Override
				public void onClick(View v) 
				{
					Intent i = new Intent(stastictabbar.this,
							gendereqa.class);
					startActivity(i);
		
				}
			});
			
			textchildlabour_l.setOnClickListener(new View.OnClickListener() 
			{
	
				@Override
				public void onClick(View v) 
				{
	
					Intent i = new Intent(stastictabbar.this,
							chaildlabour.class);
					startActivity(i);
				}
			});
			
			texttradeunion_l.setOnClickListener(new View.OnClickListener() 
			{
	
				@Override
				public void onClick(View v) 
				{
	
					Intent i = new Intent(stastictabbar.this, trade.class);
					startActivity(i);
				}
			});
			
			footnote_l.setOnClickListener(new View.OnClickListener() 
			{
	
				@Override
				public void onClick(View v) 
				{
					Intent i = new Intent(stastictabbar.this, footnotedetail.class);
					startActivity(i);
		
				}
			});
			textminority_l.setOnClickListener(new View.OnClickListener() 
			{
	
				@Override
				public void onClick(View v) 
				{
					Intent i = new Intent(stastictabbar.this, minoritee.class); 
					startActivity(i);

		
				}
			});
		
		

		SharedPreferences prefs = getSharedPreferences("mytitle", MODE_PRIVATE);
		String s1 = prefs.getString("profile", null);
		title.setText(s1);
		countryterriory = (TextView) findViewById(R.id.textView10);
		populationtra = (TextView) findViewById(R.id.textView11);

		Typeface myTypeface1 = Typeface.createFromAsset(getAssets(),
				"font/RBold.ttf");
		title.setTypeface(myTypeface1);

		SharedPreferences prefss1 = getSharedPreferences("profilefile",
				MODE_PRIVATE);
		String s1s = prefss1.getString("pdata", null);

		backscreen = (ImageView) findViewById(R.id.back);
		imageview = (ImageView) findViewById(R.id.imageView1);
		//listdata = (ListView) findViewById(R.id.listView1);
		lastupdated = (TextView) findViewById(R.id.intro);
		countrynametrty = (TextView) findViewById(R.id.countrynametrt);
		txtpopulation = (TextView) findViewById(R.id.population);
		
		
		
		
		txtname = (TextView) findViewById(R.id.name);

		SharedPreferences prefss = getSharedPreferences(MY_PREFS_NAME,
				MODE_PRIVATE);
		id2 = prefss.getString("ID", "ID");

		SharedPreferences.Editor editor = getSharedPreferences("pre",
				MODE_PRIVATE).edit();
		editor.putString("ID2", id2);

		editor.commit();
		SetLanguageToAll_teb();
		GetLanguageForMsg();

		try {

			loading.setMessage(promsg);
		
			loading.show();
			loading.setCancelable(false);
			
			new LongOperation().execute(Url);

		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	
		btnsubmit = (TextView) findViewById(R.id.btnsubmit);
		backscreen.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent i = new Intent(stastictabbar.this, ProfileActivity.class);

				startActivity(i);

			}
		});

		spn.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) 
			{
				selectedItem = parent.getSelectedItem().toString();
				
				SharedPreferences.Editor editor = getSharedPreferences(
						"MY_PREFS", MODE_PRIVATE).edit();
				editor.putString("selectid", spn.getSelectedItem().toString());
				editor.putString("selectcountry", titles);
				editor.commit();

				if (selectedItem.equals(sel))
				{
					
					
				} 	
				else 
				{
					Intent i = new Intent(stastictabbar.this,detailactivity.class);

					startActivity(i);
				}
				
				
				

			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		profilesubmit = (TextView) findViewById(R.id.btnsubmit1);
		profilesubmit.setOnClickListener(new OnClickListener() 
		{

			@Override
			public void onClick(View v) 
			{

				SharedPreferences.Editor editor = getSharedPreferences(
						"MY_PREFS", MODE_PRIVATE).edit();
				editor.putString("selectid", spn.getSelectedItem().toString());
				editor.putString("selectcountry", titles);
				editor.commit();

				if (selectedItem.equals(sel))
				{
					if (GetUserLang(getApplicationContext()).equalsIgnoreCase("English"))
					{

						Toast.makeText(getApplicationContext(),"Please  select Year", 20).show();
					
					} else if (GetUserLang(getApplicationContext()).equalsIgnoreCase("French"))
					{
						Toast.makeText(getApplicationContext(),"S'il vous plaît sélectionner l'année", 20).show();
					
					}
					else if (GetUserLang(getApplicationContext()).equalsIgnoreCase("Spanish")) 
					{

						Toast.makeText(getApplicationContext(),"Seleccione Año", 20).show();
						
					}
					
				} 	
				else 
				{
					Intent i = new Intent(stastictabbar.this,detailactivity.class);

					startActivity(i);
				}
			}
		});

		btnsubmit.setText(cmstxt);

		btnsubmit.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v) {

				Intent i = new Intent(stastictabbar.this, cmslistview.class);
				startActivity(i);

			}

		});

		if (GetUserLang(getApplicationContext()).equalsIgnoreCase("English")) {

			profilesubmit.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.submit_button));
		
		} else if (GetUserLang(getApplicationContext()).equalsIgnoreCase("French")) {

			profilesubmit.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.fsubmit_button));
		

		} else if (GetUserLang(getApplicationContext()).equalsIgnoreCase("Spanish")) {

			profilesubmit.setBackgroundDrawable(getResources().getDrawable(
					R.drawable.ssubmit_button));
			
		}
		
		introduction_t.setText("  "+intr);
		
		texteducation_t.setText("  "+edu);
		textearlychildhood_t.setText("  "+ear);
		textprimary_t.setText("  "+pri);
		textsecondary_t.setText("  "+sec);
		texttertiary_t.setText("  "+ter);
		
		textspecialneed_t.setText("  "+chi);
		textrefugee_t.setText("  "+ref);
		textacademic_t.setText("  "+aca);
		textgender_t.setText("  "+gen);
		
		textchildlabour_t.setText("  "+child);
		texttradeunion_t.setText("  "+trade);
		footnote_t.setText("  "+"FootNote");
		textminority_t.setText("  "+mino);


		/*li = new ArrayList<String>();
		li.add(intr);
		li.add(edu);
		li.add(ear);
		li.add(pri);
		li.add(sec);
		li.add(ter);
		li.add(chi);
		li.add(ref);
		li.add(mino);
		li.add(aca);
		li.add(gen);
		li.add(child);
		li.add(trade);
		li.add("Footnote");

		ArrayAdapter<String> adp = new ArrayAdapter<String>(getBaseContext(),
				R.layout.listrow, R.id.group_title, li);
		listdata.setAdapter(adp);

		listdata.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

				// TODO Auto-generated method stub
				if (arg2 == 0) {
					Intent i = new Intent(stastictabbar.this,
							profiledetail.class);

					startActivity(i);
				}
				if (arg2 == 1) {
					Intent i = new Intent(stastictabbar.this, acdami.class);
					startActivity(i);

				}
				if (arg2 == 2) {
					Intent i = new Intent(stastictabbar.this, early.class);
					startActivity(i);

				}
				if (arg2 == 3) {
					Intent i = new Intent(stastictabbar.this, primary.class);
					startActivity(i);
				}
				if (arg2 == 4) {
					Intent i = new Intent(stastictabbar.this, secondary.class);
					startActivity(i);

				}
				if (arg2 == 5) {
					Intent i = new Intent(stastictabbar.this, tertiary.class);
					startActivity(i);

				}
				if (arg2 == 6) {
					Intent i = new Intent(stastictabbar.this,
							secondarydetail.class);
					startActivity(i);

				}
				if (arg2 == 7) {
					Intent i = new Intent(stastictabbar.this, Refugee.class);
					startActivity(i);

				}
				if (arg2 == 8) {
					Intent i = new Intent(stastictabbar.this, minoritee.class);
					startActivity(i);

				}
				if (arg2 == 9) {
					Intent i = new Intent(stastictabbar.this, acdfreedom.class);
					startActivity(i);

				}
				if (arg2 == 10) {
					Intent i = new Intent(stastictabbar.this, gendereqa.class);
					startActivity(i);

				}
				if (arg2 == 11) {
					Intent i = new Intent(stastictabbar.this,
							chaildlabour.class);
					startActivity(i);

				}
				if (arg2 == 12) {
					Intent i = new Intent(stastictabbar.this, trade.class);
					startActivity(i);

				}
				if (arg2 == 13) {
					Intent i = new Intent(stastictabbar.this, footnotedetail.class);
					startActivity(i);

				}
			}
		});*/
		
		
		

	}

	private void initialize_Controls() {
		super.initialize_Bottombar(2);
	}

	public void initialization() {
		// spn=(ListView)findViewById(R.id.spinner1);

		textcountryname = (TextView) findViewById(R.id.countryname);

		textlongname = (TextView) findViewById(R.id.countrylongname);
		// contentdata = (TextView) findViewById(R.id.datamode);
	}

 class LongOperation extends AsyncTask<String, Void, Void>
	{

		// Required initialization

		private final HttpClient Client = new DefaultHttpClient();
		private String Content="";
		private String Error = null;
	
		String data = "";

		int sizeData = 0;
		private Context context;

		protected void onPreExecute() 
		{
			// NOTE: You can call UI Element here.

			// Start Progress Dialog (Message)

			//Dialog.setMessage(promsg);
			//Dialog.show();
			
			

		}

		// Call after onPreExecute method
		protected Void doInBackground(String... urls) 
		{
			
			/************ Make Post Call To Web Server ***********/
			BufferedReader reader = null;
			
			// Send data
			try {
				
				// Defined URL where to send data
				URL url = new URL(urls[0]);

				// Send POST data request

				URLConnection conn = url.openConnection();
				conn.setDoOutput(true);
				OutputStreamWriter wr = new OutputStreamWriter(
						conn.getOutputStream());
				wr.write(data);
				wr.flush();
				
				// Get the server response

				reader = new BufferedReader(new InputStreamReader(
						conn.getInputStream()));
				StringBuilder sb = new StringBuilder();
				String line = null;

				// Read Server Response
				while ((line = reader.readLine()) != null) {
					// Append server response in string
					sb.append(line + "\n");
				}
				
				// Append Server Response To Content String
				Content = sb.toString();
				
			} catch (Exception ex) 
			{
				Error = ex.getMessage();
				
				
			} 
			finally 
			{
				try 
				{

					reader.close();
				}

				catch (Exception ex) 
				{
					
				}
				
			}    

			/*****************************************************/
			return null;
		}

		protected void onPostExecute(Void unused) 
		{
			
			
			if (Error != null) 
			{

			} 
			else
			{

				String subtitles = "";
				String distitles = "";
				String contrytrt = "";
				String adata = "";
				String update = "";
				String t = " ";
				JSONObject jsonResponse;
			
				

				try
				{
				
					jsonResponse = new JSONObject(Content);
					JSONObject json2 = jsonResponse.getJSONObject("data");
					countryname = (String) json2.get("country_name");
					countrylongname = (String) json2.get("country_long_name");
					JSONObject json22 = json2.getJSONObject("barometer_data");
					
					imagepath = (String) json22.get("country_image_path");
					countrynamethree = (String) json22
							.get("country_territory_name");
					population = (String) json22.get("population");
					JSONArray subArraydetaile = json2
							.getJSONArray("statistics_data");
					
					
				String last_updates=(String) json22.get("last_update");
				last_update.setText(Html.fromHtml(last_updates));
				
				String introduction=(String) json22.get("introduction");
				String texteducation=(String) json22.get("texteducation");
				String textearlychildhood=(String) json22.get("textearlychildhood");
				String textprimary=(String) json22.get("textprimary");
				String textsecondary=(String) json22.get("textsecondary");
				String texttertiary=(String) json22.get("texttertiary");
				String textspecialneed=(String) json22.get("textspecialneed");
				String textrefugee=(String) json22.get("textrefugee");
				String textminority=(String) json22.get("textminority");
				
				String textacademic=(String) json22.get("textacademic");
				String textgender=(String) json22.get("textgender");
				String textchildlabour=(String) json22.get("textchildlabour");
				String texttradeunion=(String) json22.get("texttradeunion");
				String footnote=(String) json22.get("footnote");
				
				
				if(footnote.equalsIgnoreCase(""))
				{
					footnote_l.setVisibility(View.GONE);
					
				}
				else
				{
					footnote_l.setVisibility(View.VISIBLE);
				}
				
				
				if(texttradeunion.equalsIgnoreCase(""))
				{
					texttradeunion_l.setVisibility(View.GONE);
					
				}
				else
				{
					texttradeunion_l.setVisibility(View.VISIBLE);
				}
				
				if(textchildlabour.equalsIgnoreCase(""))
				{
					textchildlabour_l.setVisibility(View.GONE);
					
				}
				else
				{
					textchildlabour_l.setVisibility(View.VISIBLE);
				}
				
				if(textgender.equalsIgnoreCase(""))
				{
					textgender_l.setVisibility(View.GONE);
					
				}
				else
				{
					textgender_l.setVisibility(View.VISIBLE);
				}
				
				if(textacademic.equalsIgnoreCase(""))
				{
					textacademic_l.setVisibility(View.GONE);
					
				}
				else
				{
					textacademic_l.setVisibility(View.VISIBLE);
				}
				
				if(textminority.equalsIgnoreCase(""))
				{
					textminority_l.setVisibility(View.GONE);
					
				}
				else
				{
					textminority_l.setVisibility(View.VISIBLE);
				}
				
				if(textrefugee.equalsIgnoreCase(""))
				{
					textrefugee_l.setVisibility(View.GONE);
					
				}
				else
				{
					textrefugee_l.setVisibility(View.VISIBLE);
				}
				
				if(textspecialneed.equalsIgnoreCase(""))
				{
					textspecialneed_l.setVisibility(View.GONE);
					
				}
				else
				{
					textspecialneed_l.setVisibility(View.VISIBLE);
				}
				
				if(texttertiary.equalsIgnoreCase(""))
				{
					texttertiary_l.setVisibility(View.GONE);
					
				}
				else
				{
					texttertiary_l.setVisibility(View.VISIBLE);
				}
				
				if(textsecondary.equalsIgnoreCase(""))
				{
					textsecondary_l.setVisibility(View.GONE);
					
				}
				else
				{
					textsecondary_l.setVisibility(View.VISIBLE);
				}
				
				if(textprimary.equalsIgnoreCase(""))
				{
					textprimary_l.setVisibility(View.GONE);
					
				}
				else
				{
					textprimary_l.setVisibility(View.VISIBLE);
				}
				
				if(textearlychildhood.equalsIgnoreCase(""))
				{
					textearlychildhood_l.setVisibility(View.GONE);
					
				}
				else
				{
					textearlychildhood_l.setVisibility(View.VISIBLE);
				}
				
				if(texteducation.equalsIgnoreCase(""))
				{
					texteducation_l.setVisibility(View.GONE);
					
				}
				else
				{
					texteducation_l.setVisibility(View.VISIBLE);
				}
				
				
				if(introduction.equalsIgnoreCase(""))
				{
					introduction_l.setVisibility(View.GONE);
					
				}
				else
				{
					introduction_l.setVisibility(View.VISIBLE);
				}
				

					titles = countryname;
					subtitles = countrylongname;
					contrytrt = countrynamethree;
					

					textcountryname.setText(titles);
					SharedPreferences.Editor editor = getSharedPreferences(
							"country", MODE_PRIVATE).edit();

					editor.putString("selectcountry", titles);
					editor.commit();
					textlongname.setText(subtitles);
					countrynametrty.setText(contrytrt);
					worldlist = new ArrayList<String>();
					worldlist.add(sel);
					int lengthJsonArr = subArraydetaile.length();

					for (int i = 0; i < lengthJsonArr; i++) {

						JSONObject jsonChildNode = subArraydetaile
								.getJSONObject(i);
						worldlist.add(jsonChildNode.optString("year"));

					}

					spn.setAdapter(new ArrayAdapter<String>(stastictabbar.this,
							android.R.layout.simple_spinner_item, worldlist));

					ImageLoader imgLoader = new ImageLoader(
							getApplicationContext());
					imgLoader.DisplayImage(imagepath.toString(),
							R.drawable.lode, imageview);

					adata = population;

					txtpopulation.setText(Html.fromHtml(adata));

					JSONArray json3 = json22.getJSONArray("ilo_convetion");
					String s = json3.toString();
					String s2 = s.replace("[", "");
					s2 = s2.replace("]", "");
					s2 = s2.replace("\"", "");

					ArrayList<String> items = new ArrayList<String>(
							Arrays.asList(s2.split(",")));

					String[] stockArr = new String[items.size()];
					stockArr = items.toArray(stockArr);

					String formatedString = items.toString()

					.replace(",", System.getProperty("line.separator"))
							.replace("[", "").replace("]", "").trim();

					LinearLayout findViewById = (LinearLayout) findViewById(R.id.linear1);
					dynamicText = new TextView(stastictabbar.this);

					for (int i = 0; i < stockArr.length; i++) 
					{

						dynamicText.setText(formatedString);
						dynamicText.setTextColor(Color.GRAY);
						dynamicText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);

					}

					findViewById.addView(dynamicText);

				} 
				catch (JSONException ee) 
				{
					ee.printStackTrace();
				}
				
				loading.cancel();
			}
		}
	}



	public String GetUserLang(Context c) {
		String s_value11 = "no";
		SharedPreferences settings11 = c.getSharedPreferences("language", 0);
		String value1 = settings11.getString("u_lang", null);
		if (value1 != null) {
			return value1;
		}
		return s_value11;
	}

	public void SetData(JSONObject data) {
		try {

			JSONArray jsarray = new JSONArray();
			jsarray = data.getJSONArray("data");

			JSONObject row = jsarray.getJSONObject(0);
			Log.e("Tab data", "" + row);

			countryterriory.setText(""
					+ row.getString("Country/Territory name"));
			populationtra.setText("" + row.getString("Population"));
			ilo_tra.setText("" + row.getString("ILO Conventions"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void GetLanguageForMsg() {
		try {

			if (GetUserLang(getApplicationContext())
					.equalsIgnoreCase("English")) {

				Url = "http://app.ei-ie.org/barometer/en/barometerapi/profile_details/"
						+ id2;
				promsg = "Loading, please wait";
				cmstxt = "Latest cms";
				
				
			} else if (GetUserLang(getApplicationContext()).equalsIgnoreCase(
					"French")) {
				Url = "http://app.ei-ie.org/barometer/fr/barometerapi/profile_details/"
						+ id2;
				promsg = "Chargement en cours, s'il vous plaît patienter";
				cmstxt = "Derniers cms";
			} else if (GetUserLang(getApplicationContext()).equalsIgnoreCase(
					"Spanish")) {

				Url = "http://app.ei-ie.org/barometer/es/barometerapi/profile_details/"
						+ id2;
				promsg = "Cargando por favor espere";
				cmstxt = "últimas cms";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String GetEnglish(Context c) {
		String s_value11 = "no";
		SharedPreferences settings11 = c.getSharedPreferences("englishlang", 0);
		String value1 = settings11.getString("en_get", null);
		if (value1 != null) {
			return value1;
		}
		return s_value11;
	}

	public String GetSpanish(Context c) {
		String s_value11 = "no";
		SharedPreferences settings11 = c.getSharedPreferences("spanishlang", 0);
		String value1 = settings11.getString("sp_get", null);
		if (value1 != null) {
			return value1;
		}
		return s_value11;
	}

	public String GetFrench(Context c) {
		String s_value11 = "no";
		SharedPreferences settings11 = c.getSharedPreferences("frenchlang", 0);
		String value1 = settings11.getString("fr_get", null);
		if (value1 != null) {
			return value1;
		}
		return s_value11;
	}

	private void SetLanguageToAll_teb() {
		JSONObject alldata = new JSONObject();
		try {

			Log.e("User language", ">>>>"
					+ GetUserLang(getApplicationContext()));
			if (GetUserLang(getApplicationContext())
					.equalsIgnoreCase("English")) {
				alldata = new JSONObject(GetEnglish(getApplicationContext()));

			} else if (GetUserLang(getApplicationContext()).equalsIgnoreCase(
					"French")) {
				alldata = new JSONObject(GetFrench(getApplicationContext()));

			} else if (GetUserLang(getApplicationContext()).equalsIgnoreCase(
					"Spanish"))
			{
				alldata = new JSONObject(GetSpanish(getApplicationContext()));

			}
			SetData_tab(alldata);

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	private void SetData_tab(JSONObject data)
	{
		try {
			JSONArray jsarray;
			jsarray = new JSONArray();
			jsarray = data.getJSONArray("data");

			JSONObject row = jsarray.getJSONObject(0);

			intr = row.getString("Introduction");
			edu = row.getString("Education Rights");
			ear = row.getString("Early Childhood Education (ECE)");
			pri = row.getString("Primary Education");
			sec = row.getString("Secondary Education");
			ter = row.getString("Tertiary/Higher Education");
			chi = row.getString("Children with Special Needs");
			ref = row.getString("Refugee Children");
			mino = row.getString("Minorities and Indigenous Peoples");
			aca = row.getString("Academic Freedom");
			gen = row.getString("Gender Equality");
			child = row.getString("Child Labour");
			trade = row.getString("Trade Union Rights");
			sel = row.getString("Select Year Statistics");

			countryterriory.setText(""
					+ row.getString("Country/Territory name"));
			populationtra.setText("" + row.getString("Population"));
			txtname.setText("" + row.getString("ILO Conventions"));
		} catch (Exception e)

		{
			e.printStackTrace();
		}
	}
	@Override
	public void onStop() 
	{
	    super.onStop();

	    if(loading!= null)
	    	loading.cancel();
	}
}
