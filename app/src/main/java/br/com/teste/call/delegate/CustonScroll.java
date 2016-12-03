package br.com.teste.call.delegate;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.List;
import br.com.teste.call.model.Shots;

public class CustonScroll extends RecyclerView.OnScrollListener {

    private RecyclerView rcvLista;
    private List<Shots> dataSet;
    private boolean cancelRequest;
    private LoadListOnListener loadListOnListener;

    public CustonScroll(RecyclerView rcvLista, List<Shots> dataSet, boolean cancelRequest, LoadListOnListener loadListOnListener) {
        this.rcvLista = rcvLista;
        this.dataSet = dataSet;
        this.cancelRequest = cancelRequest;
        this.loadListOnListener =  loadListOnListener;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        LinearLayoutManager llm = (LinearLayoutManager) rcvLista.getLayoutManager();

        if (dataSet != null && dataSet.size() == llm.findLastCompletelyVisibleItemPosition() + 1) {

            if ( cancelRequest ) {
                cancelRequest = false;
                loadListOnListener.loadList();
            }

        }

    }



}
