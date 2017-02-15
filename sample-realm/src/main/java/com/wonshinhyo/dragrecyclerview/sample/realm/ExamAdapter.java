package com.wonshinhyo.dragrecyclerview.sample.realm;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wonshinhyo.dragrecyclerview.DragAdapter;
import com.wonshinhyo.dragrecyclerview.DragHolder;
import com.wonshinhyo.dragrecyclerview.DragRecyclerView;
import com.wonshinhyo.dragrecyclerview.sample.realm.item.Dummy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shinhyo
 */
class ExamAdapter extends DragAdapter {

    ExamAdapter(Context context, ArrayList<Dummy> data) {
        super(context, data);
    }

    @Override
    public DragRecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(getContext()).inflate(R.layout.row, parent, false), viewType);
    }

    @Override
    public void onBindViewHolder(DragRecyclerView.ViewHolder hol, int position) {
        super.onBindViewHolder(hol, position);
        Holder holder = (Holder) hol;
        holder.mText.setText(String.valueOf(getData().get(position).getNum()));
    }

    @Override
    public List<Dummy> getData() {
        return (List<Dummy>) super.getData();
    }

    private final class Holder extends DragHolder {
        TextView mText;

        Holder(View view, int viewType) {
            super(view);
            mText = (TextView) view.findViewById(R.id.text);
        }
    }
}
