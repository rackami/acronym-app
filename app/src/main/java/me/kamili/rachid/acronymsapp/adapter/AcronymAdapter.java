package me.kamili.rachid.acronymsapp.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.kamili.rachid.acronymsapp.R;
import me.kamili.rachid.acronymsapp.module.LongForm;

public class AcronymAdapter extends RecyclerView.Adapter<AcronymAdapter.Holder> {

    private List<LongForm> mAcronymList = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    private OnClickListener mClickListener;


    public AcronymAdapter(LayoutInflater inflater) {
        mLayoutInflater = inflater;
    }

    @NonNull
    @Override
    public AcronymAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.acronym_item_layout, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AcronymAdapter.Holder holder, int position) {
        holder.bind(mAcronymList.get(position));
    }

    @Override
    public int getItemCount() {
        return mAcronymList.size();
    }

    public void addLongForms(List<LongForm> venueList) {
        mAcronymList.addAll(venueList);
        notifyDataSetChanged();
    }

    public void clearLongForms() {
        mAcronymList.clear();
        notifyDataSetChanged();
    }

    public void setClickListener(OnClickListener listener) {
        mClickListener = listener;
    }

    public interface OnClickListener {
        //Item in RV clicked
        void onLongFormClick(LongForm lf, int position);
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.acronym_text)
        TextView tvAcronym;
        private Context mContext;
        private LongForm mLongForm;

        public Holder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            mContext = itemView.getContext();
            ButterKnife.bind(this, itemView);
        }

        public void bind(LongForm longForm) {
            mLongForm = longForm;
            tvAcronym.setText(mLongForm.getLongform());
        }

        @Override
        public void onClick(View v) {
            if (mClickListener != null) {
                mClickListener.onLongFormClick(mLongForm, getAdapterPosition());
            }
        }
    }
}
