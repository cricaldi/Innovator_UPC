package pe.edu.upc.rentalcarapp.models;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.upc.bean.*;
import pe.edu.upc.bean.Car;
import pe.edu.upc.rentalcarapp.R;
import pe.edu.upc.rentalcarapp.activities.CarActivity;
import pe.edu.upc.rentalcarapp.activities.UserActivity;

//import com.xendacentral.darkcatalog.activities.ItemActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aldo Pizarro on 03/12/2015.
 */
public class RentAdapter extends RecyclerView.Adapter<RentAdapter.ViewHolder> {
    private List<pe.edu.upc.bean.Rent> rents;

    public RentAdapter(List<pe.edu.upc.bean.Rent> rents) {
        this.rents = rents;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView rentCard;
        TextView descriptionTextView;
        TextView pricePerHourTextView;
        TextView brandTextView;
        TextView modelTextView;
        TextView stateTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            rentCard = (CardView) itemView.findViewById(R.id.rent_card);
            descriptionTextView = (TextView)itemView.findViewById(R.id.descriptionTextView);
            pricePerHourTextView = (TextView)itemView.findViewById(R.id.pricePerHourTextView);
            brandTextView = (TextView)itemView.findViewById(R.id.brandTextView);
            modelTextView = (TextView)itemView.findViewById(R.id.modelTextView);
            stateTextView = (TextView)itemView.findViewById(R.id.stateTextView);
            //carCard = (CardView) itemView.findViewById(R.id.car_card);
            //nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            //pictureImageView = (ImageView) itemView.findViewById(R.id.pictureImageView);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rent_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.descriptionTextView.setText(rents.get(position).getDescription());
        holder.pricePerHourTextView.setText(rents.get(position).getPricePerHour() + "");
        holder.brandTextView.setText(rents.get(position).getBrand());
        holder.modelTextView.setText(rents.get(position).getModel());
        holder.stateTextView.setText(rents.get(position).getState());

        //holder.nameTextView.setText(cars.get(position).getTrademarkCar() + " " +  cars.get(position).getModelCar());
        //holder.pictureImageView.setImageResource(Integer.parseInt(cars.get(position).getPictureUrlCar()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    System.out.printf("Envio de valores: -- Selected position: %d%n", position);
                    System.out.println(rents.get(position).getDescription());
                    System.out.println(rents.get(position).getPricePerHour());
                    System.out.println(rents.get(position).getBrand());
                    System.out.println(rents.get(position).getModel());
                    System.out.println(rents.get(position).getObjectId());

                    Intent itemIntent = new Intent(view.getContext(), CarActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("description", rents.get(position).getDescription());
                    bundle.putDouble("priceperhour", rents.get(position).getPricePerHour());
                    bundle.putString("brand", rents.get(position).getBrand());
                    bundle.putString("model", rents.get(position).getModel());
                    bundle.putString("objectid", rents.get(position).getObjectId());
                    bundle.putString("state", rents.get(position).getState());
                    System.out.println(bundle);
                    itemIntent.putExtras(bundle);
                    view.getContext().startActivity(itemIntent);
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return rents.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
