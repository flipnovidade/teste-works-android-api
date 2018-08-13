package br.com.teste.call.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import br.com.teste.call.R;
import br.com.teste.call.model.Shots;
import br.com.teste.call.utils.ActivityUtils;

public class DetailShotActivity extends AppCompatActivity{

    public static final int REQUEST_INVITE = 0;
    private ImageView imageView;
    private LinearLayout llSliderGalery;
	private TextView txvTitulo, txvSubtitulo, txvDescricao, tvFonte;
	private Handler handler;
    private float mActionBarHeight;
    public static final String EXTRA_IMAGE = "DetailNewsActivity";
    private ViewGroup mRoot;
    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private CoordinatorLayout coordinatorLayout;
    private FragmentManager fm;
    private Shots news;
    private Typeface fontArial;
    private String TAG = DetailShotActivity.class.getName();

	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
 		setContentView(R.layout.activity_detail_shot);
        //getActionBar().hide();

		Intent i = DetailShotActivity.this.getIntent();
		Bundle b = i.getExtras();
        news = (Shots) b.getSerializable("Bean");
        String titulo = news.getTitle();

        fm = getSupportFragmentManager();

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.myCoordinatorLayout);
        mToolbar = (Toolbar) findViewById(R.id.tb_main);
        setSupportActionBar(mToolbar);
        mCollapsingToolbarLayout.setTitle(titulo);
        mCollapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(R.color.branco));

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mRoot = (ViewGroup) findViewById(R.id.ll_tv_description);

		imageView = (ImageView) findViewById(R.id.imageViewAvatar);
		txvTitulo = (TextView) findViewById(R.id.textViewTitle);
		txvSubtitulo = (TextView) findViewById(R.id.textViewSubTitle);
		txvDescricao = (TextView) findViewById(R.id.textViewDescription);
        tvFonte = (TextView) findViewById(R.id.textViewFonte);
        llSliderGalery = (LinearLayout) findViewById(R.id.llslidergalery);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        mRoot.setVisibility(View.VISIBLE);
        llSliderGalery.setVisibility(View.GONE);

		if(news.getTeam() != null){
			// TODO set image
		}else{
			imageView.setVisibility(View.GONE);
		}
		
		if(news.getTitle() != null){
			txvTitulo.setText(Html.fromHtml( news.getTitle() ) );
		}else{
			txvTitulo.setVisibility(View.GONE);
		}
		
		if(news.getDescription() != null){
			txvSubtitulo.setText(Html.fromHtml( news.getDescription() ) );
		}else{
			txvSubtitulo.setVisibility(View.GONE);
		}
		
		if(news.getCommentCount() > 0){
			txvDescricao.setText(Html.fromHtml("<b>Comments: </b>" + news.getCommentCount()));
		}else{
			txvDescricao.setVisibility(View.GONE);
		}

        if(news.getLikesCount() > 0 ){
            tvFonte.setText(Html.fromHtml("<b>Likes: </b>" + news.getLikesCount()));
        }else{
            tvFonte.setVisibility(View.GONE);
        }


	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_main, menu);
		return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == android.R.id.home) {
			finish();
		}
		return super.onOptionsItemSelected(item);
	}

    @Override
    public void finish() {
        super.finish();
		ActivityUtils.closeWithFade(DetailShotActivity.this);
    }

}
