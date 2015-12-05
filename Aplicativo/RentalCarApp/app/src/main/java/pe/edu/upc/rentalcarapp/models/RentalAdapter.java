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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Aldo Pizarro on 03/12/2015.
 */
public class RentalAdapter extends RecyclerView.Adapter<RentalAdapter.ViewHolder> {
    private List<pe.edu.upc.bean.Rental> rentals;

    public RentalAdapter(List<pe.edu.upc.bean.Rental> rentals) {
        this.rentals = rentals;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CardView rentalCard;
        TextView devolutionDateTextView;
        TextView statusTextView;
        TextView totalTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            rentalCard = (CardView) itemView.findViewById(R.id.rental_card);
            devolutionDateTextView = (TextView)itemView.findViewById(R.id.devolutionDateTextView);
            statusTextView = (TextView)itemView.findViewById(R.id.statusTextView);
            totalTextView = (TextView)itemView.findViewById(R.id.totalTextView);
            //modelTextView = (TextView)itemView.findViewById(R.id.totalTextView);
            //stateTextView = (TextView)itemView.findViewById(R.id.stateTextView);
            //carCard = (CardView) itemView.findViewById(R.id.car_card);
            //nameTextView = (TextView) itemView.findViewById(R.id.nameTextView);
            //pictureImageView = (ImageView) itemView.findViewById(R.id.pictureImageView);
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rental_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;

    }


    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String reportDate = df.format(rentals.get(position).getDateDevolution());
        holder.devolutionDateTextView.setText(reportDate);
        holder.totalTextView.setText(rentals.get(position).getTotal()+"");
        holder.statusTextView.setText(rentals.get(position).getStatus() + "");

        //holder.nameTextView.setText(cars.get(position).getTrademarkCar() + " " +  cars.get(position).getModelCar());
        //holder.pictureImageView.setImageResource(Integer.parseInt(cars.get(position).getPictureUrlCar()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DateFormat df1 = new SimpleDateFormat("dd/MM/yyyy");
                    String reportDate1 = df1.format(rentals.get(position).getDateDevolution());
                    String reportDate2 = df1.format(rentals.get(position).getInitDate());
                    System.out.printf("Envio de valores: -- Selected position: %d%n", position);
                    System.out.println(reportDate1);
                    System.out.println(rentals.get(position).getTotal());
                    System.out.println(rentals.get(position).getStatus());

                    Intent itemIntent = new Intent(view.getContext(), CarActivity.class);
                    Bundle bundle = new Bundle();
                    reportDate1 = df1.format(rentals.get(position).getInitDate());
                    bundle.putString("initDate", reportDate1);
                    bundle.putDouble("days", rentals.get(position).getDays());
                    reportDate2 = df1.format(rentals.get(position).getDateDevolution());
                    bundle.putString("dateDevolution", reportDate2);
                    bundle.putString("total", rentals.get(position).getTotal()+"");
                    bundle.putString("penalty", rentals.get(position).getPenalty()+"");
                    bundle.putString("status", rentals.get(position).getStatus()+"");
                    bundle.putString("objectIdUSer", rentals.get(position).getObjectIdUSer());
                    bundle.putString("objectIdAdmRental", rentals.get(position).getObjectIdAdmRental());
                    bundle.putString("objectIdAdmDevol", rentals.get(position).getObjectIdAdmDevol());
                    bundle.putString("objectIdCar", rentals.get(position).getObjectIdCar());
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
        return rentals.size();
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }
}
