package pe.edu.upc.rentalcarapp.models;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import pe.edu.upc.rentalcarapp.R;
import pe.edu.upc.rentalcarapp.activities.CarActivity;
import pe.edu.upc.rentalcarapp.activities.UserActivity;

//import com.xendacentral.darkcatalog.activities.ItemActivity;

import java.util.ArrayList;

/**
 * Created by Aldo Pizarro on 03/12/2015.
 */
public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    private ArrayList<Car> cars;

    public CarAdapter(ArrayList<Car> cars) {
        this.cars = cars;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        ImageView pictureImageView;
        CardView carCard;

        public ViewHolder(View itemView) {
            super(itemView);
            carCard = (CardView) itemView.findViewById(R.id.car_card);
            nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            pictureImageView = (ImageView) itemView.findViewById(R.id.pictureImageView);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.nameTextView.setText(cars.get(position).getTrademarkCar() + " " +
                cars.get(position).getModelCar());
        holder.pictureImageView.setImageResource(
                Integer.parseInt(cars.get(position).getPictureUrlCar()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {


                    System.out.printf("Envio de valores: -- Selected position: %d%n", position);
                    System.out.println(cars.get(position).getTrademarkCar());
                    System.out.println(cars.get(position).getModelCar());
                    System.out.println(cars.get(position).getPictureUrlCar());
                    System.out.println(cars.get(position).getDescriptionCar());
                    Intent itemIntent = new Intent(view.getContext(), CarActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("trademarkCar", cars.get(position).getTrademarkCar());
                    bundle.putString("modelCar", cars.get(position).getModelCar());
                    bundle.putString("pictureUrlCar", cars.get(position).getPictureUrlCar());
                    bundle.putString("descriptionCar", cars.get(position).getDescriptionCar());
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
        return cars.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
