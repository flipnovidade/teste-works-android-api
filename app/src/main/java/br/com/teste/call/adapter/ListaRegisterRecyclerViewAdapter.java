package br.com.teste.call.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.teste.call.AppConstant;
import br.com.teste.call.R;
import br.com.teste.call.delegate.ClickItemRecyclerViewOnListener;
import br.com.teste.call.model.Shots;

public class ListaRegisterRecyclerViewAdapter extends RecyclerView.Adapter<ListaRegisterRecyclerViewAdapter.ViewHolder> {

    //================================================================================
    // PROPERTIES
    //================================================================================
    private static List<Shots> mDataset;
    private static ClickItemRecyclerViewOnListener clickItemRecyclerViewOnListener;
    private Context context;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class ViewHolder extends RecyclerView.ViewHolder {

        //PROPERTIES
        public TextView txvLinhaUm;
        public TextView txtLinhaDois;
        public TextView txtLinhaTres;
        public TextView txvLinhaUmDireita;
        public ImageView imgavatar;
        public ProgressBar myProgress;

        public ViewHolder(View v) {
            super(v);
            txvLinhaUm = (TextView) v.findViewById(R.id.txv_linha_um);
            txtLinhaDois = (TextView) v.findViewById(R.id.txv_linha_dois);
            txtLinhaTres = (TextView) v.findViewById(R.id.txv_linha_tres);
            txvLinhaUmDireita = (TextView) v.findViewById(R.id.txv_linha_um_direita);
            imgavatar = (ImageView) v.findViewById(R.id.imgAvatar);
            myProgress = (ProgressBar) v.findViewById(R.id.itemProgress);

            v.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    if( clickItemRecyclerViewOnListener != null){
                        clickItemRecyclerViewOnListener.onItemClicked( mDataset.get( getAdapterPosition() ) );
                    }
                }
            });
        }
    }

    //================================================================================
    // CONSTRUCTOR
    //================================================================================
    // Provide a suitable constructor (depends on the kind of dataset)
    public ListaRegisterRecyclerViewAdapter(Context context, List<Shots> myDataset, ClickItemRecyclerViewOnListener clickItemRecyclerViewOnListener) {
        mDataset = myDataset;
        this.clickItemRecyclerViewOnListener = clickItemRecyclerViewOnListener;
        this.context = context;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public ListaRegisterRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                          int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.line_recycler_view_lista_register, parent, false);

        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        SimpleDateFormat sdf = new SimpleDateFormat(AppConstant.Format.DATA_HORA_US, AppConstant.Localizacao.PTBR);
        SimpleDateFormat nsdf = new SimpleDateFormat(AppConstant.Format.DATA_BR_AMIGAVEL, AppConstant.Localizacao.PTBR);

        Shots ha = mDataset.get(position);

//        String dataAmigavel = "";
//        try {
//            dataAmigavel = nsdf.format(sdf.parse(ha.getDate()));
//        } catch (Exception ignore) {
//        }

        holder.txvLinhaUm.setText(Html.fromHtml( ha.getTitle() ));
        holder.txtLinhaDois.setText(Html.fromHtml( ha.getDescription() ));
        holder.txtLinhaTres.setText(Html.fromHtml("<b>Likes: </b>" + ha.getLikesCount()));
//        holder.txvLinhaUmDireita.setText(dataAmigavel);
        holder.txvLinhaUmDireita.setVisibility(View.GONE);

        if(ha.getTeam() != null){
            Picasso.with( context ).load( ha.getImages().getNormal() ).into(holder.imgavatar, new Callback() {
                @Override
                public void onSuccess() {
                    holder.myProgress.setVisibility(View.GONE);
                }

                @Override
                public void onError() {

                }
            });
        }


    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        if( mDataset == null){
            return 0;
        }else{
            return mDataset.size();
        }

    }

    public void addList(List<Shots> newlist) {
//        mDataset.addAll(newlist);
//        this.notifyDataSetChanged();

        for( Shots dribbble : newlist){

            if(mDataset == null){
                mDataset = new ArrayList<>();
            }

            mDataset.add(dribbble);
            this.notifyItemChanged( mDataset.size() -1 );

        }
    }
}



