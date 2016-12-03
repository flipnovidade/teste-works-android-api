package br.com.teste.call.activity;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import java.util.List;

import br.com.teste.call.AppActivity;
import br.com.teste.call.AppConstant;
import br.com.teste.call.R;
import br.com.teste.call.adapter.ListaRegisterRecyclerViewAdapter;
import br.com.teste.call.api.CallApi;
import br.com.teste.call.delegate.ClickItemRecyclerViewOnListener;
import br.com.teste.call.delegate.CustonScroll;
import br.com.teste.call.delegate.LoadListOnListener;
import br.com.teste.call.model.Shots;
import br.com.teste.call.utils.ActivityUtils;
import br.com.teste.call.utils.DividerItemDecoration;
import br.com.teste.call.utils.LogUtils;

public class MainActivity extends AppActivity implements View.OnClickListener, CallApi.CallOnListener, ClickItemRecyclerViewOnListener, LoadListOnListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int PERMISSIONS_LOCATION = 100;
    private RecyclerView rcvLista;
    private List<Shots> dataSet;
    private LinearLayoutManager rcvLayoutManager;
    private ListaRegisterRecyclerViewAdapter rcvAdapter;
    private Menu mOptionsMenu;
    private boolean someFlag = false;
    private int page = 1;
    private int per_page = 5;
    ProgressBar pbLoading;
    private boolean cancelRequest = false;
    private boolean firstRequest = true;
    private static int SPLASH_TIME_OUT = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configToolbar(false, true, false);
        setViews();
        callList();
    }

    private void callList(){
        pbLoading.setVisibility(View.VISIBLE);
        CallApi callApi = new CallApi(MainActivity.this);
        callApi.callApi(AppConstant.Dribbble.Token, String.valueOf(page), String.valueOf(per_page) );
    }

    private void setViews() {
        rcvLista = (RecyclerView) findViewById(R.id.rcvLista);
        pbLoading = (ProgressBar) findViewById(R.id.pbLoading);
        pbLoading.setVisibility(View.VISIBLE);
        pbLoading.getIndeterminateDrawable().setColorFilter(ContextCompat.getColor(MainActivity.this, R.color.amarelo_claro), PorterDuff.Mode.SRC_IN);
    }

    // MENU ----------------------------------------------------------------------------------------
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        try {
            MenuInflater inflater = getMenuInflater();
            mOptionsMenu = menu;
            inflater.inflate(R.menu.menu_principal, menu);
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        try {
            switch (item.getItemId()) {
                case android.R.id.home: {
                    break;
                }
                case R.id.action_sincronizar: {
                    setRefreshActionButtonState(true);
                    callList();
                    break;
                }
                case R.id.action_email: {

                    break;
                }
                default: {
                    return super.onOptionsItemSelected(item);
                }
            }
        } catch (Exception e) {
            LogUtils.e(TAG, e.getMessage());
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onClick(View view) {

    }

    private void setupAdapter() {

        rcvLista.setHasFixedSize(true);
        rcvLayoutManager = new LinearLayoutManager(this);
        rcvLista.setLayoutManager(rcvLayoutManager);
        rcvLista.addItemDecoration(new DividerItemDecoration(this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }


    public void setRefreshActionButtonState(boolean refreshing) {
        if (mOptionsMenu == null || Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            return;
        }

        final MenuItem refreshItem = mOptionsMenu.findItem(R.id.action_sincronizar);
        if (refreshItem != null) {
            if (refreshing) {
                refreshItem.setActionView(R.layout.actionbar_indeterminate_progress);
            } else {
                refreshItem.setActionView(null);
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    public void ResponseOK(List<Shots> objectList) {

        if(firstRequest && rcvLista.getAdapter() == null){

            page++;
            cancelRequest = true;
            setupAdapter();
            dataSet = objectList;
            rcvAdapter = new ListaRegisterRecyclerViewAdapter(MainActivity.this, dataSet, MainActivity.this);
            rcvLista.setAdapter(rcvAdapter);
            rcvLista.setOnScrollListener( new CustonScroll( rcvLista, dataSet, cancelRequest, MainActivity.this ) );
            pbLoading.setVisibility(View.INVISIBLE);

        }else{
            rcvAdapter.addList(objectList);
            rcvLista.setOnScrollListener( new CustonScroll( rcvLista, dataSet, cancelRequest, MainActivity.this ) );
            pbLoading.setVisibility(View.INVISIBLE);
            page++;
            cancelRequest = true;
            setRefreshActionButtonState(false);
        }



    }

    @Override
    public void ResponseFail() {
        if( firstRequest ){
            pbLoading.setVisibility(View.INVISIBLE);
        }
        cancelRequest = true;
        setRefreshActionButtonState(false);
    }

    @Override
    public void onItemClicked(Shots shot) {
        Intent intent = new Intent(MainActivity.this, DetailShotActivity.class);
        intent.putExtra("Bean", shot);
        startActivity( intent );
        ActivityUtils.openWithSlide(MainActivity.this);
    }

    @Override
    public void loadList() {
        firstRequest = false;
        cancelRequest = true;
        callList();
    }
}
