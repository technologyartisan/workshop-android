package id.technologyartisan.workshopandroid;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import id.technologyartisan.workshopandroid.model.Contact;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    private Context context;
    private List<Contact> contacts;

    public RecyclerViewAdapter(Context context, List<Contact> contacts) {
        this.context = context;
        this.contacts = contacts;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view=LayoutInflater.from(context).inflate(R.layout.list_contact,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Contact contact=contacts.get(i);
        viewHolder.tvContactName.setText(contact.getName());
        viewHolder.tvContactNumber.setText(contact.getNumber());
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        CircleImageView imgContact;
        TextView tvContactName,tvContactNumber;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgContact=itemView.findViewById(R.id.img_contact);
            tvContactName=itemView.findViewById(R.id.tv_contact_name);
            tvContactNumber=itemView.findViewById(R.id.tv_contact_number);
        }
    }
}
