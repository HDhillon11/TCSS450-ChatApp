package tcss450.uw.edu.chatapp.chats;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import tcss450.uw.edu.chatapp.R;
import tcss450.uw.edu.chatapp.chats.ChatsFragment.OnChatListFragmentInteractionListener;
import tcss450.uw.edu.chatapp.chats.Chats.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnChatListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyChatsRecyclerViewAdapter extends RecyclerView.Adapter<MyChatsRecyclerViewAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnChatListFragmentInteractionListener mListener;

    public MyChatsRecyclerViewAdapter(List<DummyItem> items, OnChatListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_chats, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
//        holder.mContactName.setText(mValues.get(position).id);
//        holder.mLastMessage.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onChatListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mContactName;
        public final TextView mLastMessage;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mContactName = (TextView) view.findViewById(R.id.chat_contactName);
            mLastMessage = (TextView) view.findViewById(R.id.chat_lastMsg);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContactName.getText() + "'";
        }
    }
}
