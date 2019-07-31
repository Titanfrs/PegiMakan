package com.titanfrs.kulineran.resto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.titanfrs.kulineran.API.APIRestoEndPoint;
import com.titanfrs.kulineran.API.APIRestoService;
import com.titanfrs.kulineran.R;
import com.titanfrs.kulineran.adapter.RestoAdapter;
import com.titanfrs.kulineran.model.ItemRestoModel;
import com.titanfrs.kulineran.model.RestoModel;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestoFragment extends Fragment {
    private RestoAdapter viewAdapter;
    private List<ItemRestoModel> mItems = new ArrayList<>();
    private RecyclerView.LayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View myFragment = inflater.inflate(R.layout.fragment_resto,container,false);
        final RecyclerView recyclerView = myFragment.findViewById(R.id.feed_id_r);
        viewAdapter = new RestoAdapter(getContext(), mItems);
        mLayoutManager = new GridLayoutManager(getActivity(),2);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(viewAdapter);
        APIRestoService api = APIRestoEndPoint.getClient().create(APIRestoService.class);
        Call<RestoModel> call = api.getPegiMakan();
        call.enqueue(new Callback<RestoModel>() {
            @Override
            public void onResponse(Call<RestoModel> call, Response<RestoModel> response) {
                mItems = response.body().getItem();
                viewAdapter = new RestoAdapter(getContext(), mItems);
                recyclerView.setAdapter(viewAdapter);
            }

            @Override
            public void onFailure(Call<RestoModel> call, Throwable t) {
                Toast.makeText(getContext(), "Tidak Ada Koneksi ! ", Toast.LENGTH_SHORT).show();

            }
        });


        return myFragment;

    }


}



