package chat.ry.org.chatlayoutlibrary;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

/**
 * Created by renyang on 16/3/15.
 */
public class ChatView extends FrameLayout{

    private Context context;
    private RecyclerView recyclerView;
    private Button btnSend;
    private EditText etSend;

    public ChatView(Context context) {
        super(context);
        init(context, null);
    }

    public ChatView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public ChatView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        this.context = context;
        LayoutInflater.from(context).inflate(R.layout.chat_layout,this);
        onFinishInflate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        final ChatAdapter chatAdapter = new ChatAdapter(context);
        recyclerView.setAdapter(chatAdapter);
        btnSend = (Button)findViewById(R.id.btn_send);
        etSend = (EditText)findViewById(R.id.et_send);
        btnSend.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                chatAdapter.addMessage(etSend.getText().toString());
            }
        });
    }

}
