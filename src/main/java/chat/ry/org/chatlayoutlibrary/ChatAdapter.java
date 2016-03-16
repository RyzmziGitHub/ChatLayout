package chat.ry.org.chatlayoutlibrary;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by renyang on 15/11/1.
 */
public class ChatAdapter extends BaseAdapter<ChatAdapter.ViewHolder> {

    private Context context;

    private List<String> listMessage = new ArrayList<String>();

    public ChatAdapter(Context context) {
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.chat_content_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.tvMessage.setText(listMessage.get(position));
    }

    @Override
    protected Animator[] getAnimators(View view) {
        return new Animator[]{ObjectAnimator.ofFloat(view, "translationY", view.getMeasuredHeight(), 0)
                , ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)};
    }

    @Override
    public int getItemCount() {
        return listMessage.size();
    }

    public void addMessage(String message){
        listMessage.add(message);
        notifyDataSetChanged();
    }

    public static class ViewHolder extends BaseHolder {

        private TextView tvMessage;

        public ViewHolder(View v) {
            super(v);
            tvMessage = (TextView)v.findViewById(R.id.tv_message);
        }
    }
}
