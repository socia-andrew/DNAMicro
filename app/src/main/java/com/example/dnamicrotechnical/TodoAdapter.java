package com.example.dnamicrotechnical;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.dnamicrotechnical.model.Todo;

import java.util.List;

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TaskViewHolder> {


    Context mContext;
    private List<Todo> mTodo;
    final private ItemClickListener mItemClickListener;

    public TodoAdapter(Context context, ItemClickListener listener) {
        mContext = context;
        mItemClickListener = listener;
    }

    public interface ItemClickListener {
        void onItemClickListener(int itemId);
    }


    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the task_layout to a view
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.item_todo, parent, false);

        return new TaskViewHolder(view);
    }


    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        // Determine the values of the wanted data
        Todo todo = mTodo.get(position);
        String todoItem = todo.getTodo();
        holder.tvTodo.setText(todoItem);


    }

    @Override
    public int getItemCount() {
        if (mTodo == null) {
            return 0;
        }
        return mTodo.size();
    }

    /**
     * When data changes, this method updates the list of taskEntries
     * and notifies the adapter to use the new values on it
     */
    public void setTodos(List<Todo> todos) {
        mTodo = todos;
        notifyDataSetChanged();
    }

    public List<Todo> getTasks() {
        return mTodo;
    }



    // Inner class for creating ViewHolders
    class TaskViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView tvTodo;


        public TaskViewHolder(View itemView) {
            super(itemView);

            tvTodo = itemView.findViewById(R.id.tv_todo);
        }


        @Override
        public void onClick(View v) {

        }
    }
}