package uk.co.ribot.androidboilerplate.ui.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import uk.co.ribot.androidboilerplate.R;
import uk.co.ribot.androidboilerplate.data.model.Profile;
import uk.co.ribot.androidboilerplate.data.model.Profiles;

public class SuperHerosAdapter extends RecyclerView.Adapter<SuperHerosAdapter.SuperHeroViewHolder> {

    private List<Profile> msuperhero_avs;

    @Inject
    public SuperHerosAdapter() {
        msuperhero_avs = new ArrayList<>();
    }

    public void setRibots(List<Profile> superhero_avs) {
        msuperhero_avs = superhero_avs;
    }

    @Override
    public SuperHeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ribot, parent, false);
        return new SuperHeroViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final SuperHeroViewHolder holder, int position) {
        Profile ribot = msuperhero_avs.get(position);
        holder.nameTextView.setText(String.format("%s %s",
                ribot.name(), " "+ribot.realName()));
        holder.emailTextView.setText(ribot.realName());
    }

    @Override
    public int getItemCount() {
        return msuperhero_avs.size();
    }

    class SuperHeroViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.view_hex_color) View hexColorView;
        @BindView(R.id.text_name) TextView nameTextView;
        @BindView(R.id.text_email) TextView emailTextView;

        public SuperHeroViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
