    package com.dimaz.f55122003_perc5;
    import android.content.Intent;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.ImageView;
    import android.widget.TextView;
    import android.widget.Toast;

    import androidx.annotation.NonNull;
    import androidx.recyclerview.widget.RecyclerView;

    import java.util.ArrayList;

    public class ListHeroAdapter extends RecyclerView.Adapter<ListHeroAdapter.ListViewHolder> {
        private ArrayList<Hero> ListHero;

        private OnItemCLickCallback onItemClickCallback;
        public void setOnItemClickCallback(OnItemCLickCallback onItemClickCallback) {
            this.onItemClickCallback = onItemClickCallback;
        }
        public ListHeroAdapter(ArrayList<Hero> List) {
            this.ListHero = List;
        }

        @NonNull
        @Override
        public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate
                    (R.layout.item_row_hero, parent, false);
            return new ListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
            Hero hero = ListHero.get(position);
            holder.imgPhoto.setImageResource(hero.getPhoto());
            holder.tvName.setText(hero.getName());
            holder.tvDescription.setText(hero.getDescription());
            holder.itemView.setOnClickListener(v -> {
                Hero selectHero = ListHero.get(holder.getAdapterPosition());
                Intent intent = new Intent(holder.itemView.getContext(), activityHero.class);
                intent.putExtra("HERO_PHOTO", hero.getPhoto());
                intent.putExtra("HERO_NAME", hero.getName());
                intent.putExtra("HERO_DESCRIPTION", hero.getDescription());
                holder.itemView.getContext().startActivity(intent);
            });
        }
        public interface OnItemCLickCallback {
            void onItemClicked(Hero data);
        }


        @Override
        public int getItemCount() {
            return ListHero.size();
        }

        public class ListViewHolder extends RecyclerView.ViewHolder {
            ImageView imgPhoto;
            TextView tvName, tvDescription;

            public ListViewHolder(View itemView) {
                super(itemView);
                imgPhoto = itemView.findViewById(R.id.img_item_photo);
                tvName = itemView.findViewById(R.id.tv_item_name);
                tvDescription = itemView.findViewById(R.id.tv_item_description);
            }
        }
    }
