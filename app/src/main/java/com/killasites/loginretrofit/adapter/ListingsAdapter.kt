package nyumba.killasites.com.thenyumbaapp.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import nyumba.killasites.com.thenyumbaapp.LisitngsDetailsActivity
import nyumba.killasites.com.thenyumbaapp.R
import nyumba.killasites.com.thenyumbaapp.network.networkcalls.ListingsResponse

class ListingAdapter(private val listings : List<ListingsResponse>) : RecyclerView.Adapter<ListingAdapter.ViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.listing_lists, parent, false)
        view.setOnClickListener {
            val intent = Intent(parent.context, LisitngsDetailsActivity :: class.java)
            parent.context.startActivity(intent)
        }
        return ViewHolder(view)

    }

    override fun getItemCount() = listings.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //holder.title.text = listings[position].title
        //holder.locality.text = listings[position].locality
        holder.amount.text = listings[position].amount.toString()
        holder.description.text = listings[position].description

    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val amount : TextView = itemView.findViewById(R.id.listingamount)
        val photo : ImageView = itemView.findViewById(R.id.listingimage)
        val title : TextView = itemView.findViewById(R.id.title_text)
        val description : TextView = itemView.findViewById(R.id.descripftion)
        val locality : TextView = itemView.findViewById(R.id.listinglocality)

    }
}