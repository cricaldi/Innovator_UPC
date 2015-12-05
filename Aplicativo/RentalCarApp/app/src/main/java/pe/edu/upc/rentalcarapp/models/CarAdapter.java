package pe.edu.upc.rentalcarapp.models;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import pe.edu.upc.rentalcarapp.R;
import pe.edu.upc.rentalcarapp.activities.CarActivity;

//import com.xendacentral.darkcatalog.activities.ItemActivity;

import java.util.List;

/**
 * Created by Aldo Pizarro on 03/12/2015.
 */
public class CarAdapter extends RecyclerView.Adapter<CarAdapter.ViewHolder> {
    private List<pe.edu.upc.bean.Car> cars;

    public CarAdapter(List<pe.edu.upc.bean.Car> cars) {
        this.cars = cars;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView carCard;
        TextView descriptionTextView;
        TextView pricePerHourTextView;
        TextView brandTextView;
        TextView modelTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            carCard = (CardView) itemView.findViewById(R.id.car_card);
            descriptionTextView = (TextView)itemView.findViewById(R.id.descriptionTextView);
            pricePerHourTextView = (TextView)itemView.findViewById(R.id.pricePerHourTextView);
            brandTextView = (TextView)itemView.findViewById(R.id.brandTextView);
            modelTextView = (TextView)itemView.findViewById(R.id.modelTextView);
            //carCard = (CardView) itemView.findViewById(R.id.car_card);
            //nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            //pictureImageView = (ImageView) itemView.findViewById(R.id.pictureImageView);
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
        holder.descriptionTextView.setText(cars.get(position).getDescription());
        holder.pricePerHourTextView.setText(cars.get(position).getPricePerHour() + "");
        holder.brandTextView.setText(cars.get(position).getBrand());
        holder.modelTextView.setText(cars.get(position).getModel());

        //holder.nameTextView.setText(cars.get(position).getTrademarkCar() + " " +  cars.get(position).getModelCar());
        //holder.pictureImageView.setImageResource(Integer.parseInt(cars.get(position).getPictureUrlCar()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    System.out.printf("Envio de valores: -- Selected position: %d%n", position);
                    System.out.println(cars.get(position).getDescription());
                    System.out.println(cars.get(position).getPricePerHour());
                    System.out.println(cars.get(position).getBrand());
                    System.out.println(cars.get(position).getModel());
                    System.out.println(cars.get(position).getObjectId());

                    Intent itemIntent = new Intent(view.getContext(), CarActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("description", cars.get(position).getDescription());
                    bundle.putDouble("priceperhour", cars.get(position).getPricePerHour());
                    bundle.putString("brand", cars.get(position).getBrand());
                    bundle.putString("model", cars.get(position).getModel());
                    bundle.putString("objectid", cars.get(position).getObjectId());
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
