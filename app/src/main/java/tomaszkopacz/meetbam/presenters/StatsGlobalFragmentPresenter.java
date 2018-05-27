package tomaszkopacz.meetbam.presenters;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tomaszkopacz.meetbam.activities.StatsGlobalFragment;
import tomaszkopacz.meetbam.model.UserResult;
import tomaszkopacz.meetbam.service.UserAdapter;
import tomaszkopacz.meetbam.service.UserViewHolder;
import tomaszkopacz.meetbam.service.WebService;

/**
 * Created by tomas on 02.03.2018.
 */

public class StatsGlobalFragmentPresenter implements RecyclerViewPresenter{

    private StatsGlobalFragment fragment;
    private WebService mWebService;

    // users list
    private UserAdapter adapter;
    private List<UserResult> results = new ArrayList<>();

    /**
     * Constructor.
     */
    public StatsGlobalFragmentPresenter(StatsGlobalFragment fragment, WebService service){
        this.fragment = fragment;
        this.mWebService = service;

        this.adapter = new UserAdapter(this);
    }

    /**
     * Downloads users and send them to activity.
     */
    public void downloadResults(){
        // remove previous elements
        results.clear();

        // when new elements downloaded
        Call call = mWebService.getGlobalResults();
        call.enqueue(new Callback<List<UserResult>>() {

            @Override
            public void onResponse(Call<List<UserResult>> call, Response<List<UserResult>> response) {

                // assign response objects to list
                results = response.body();

                // send users to activity
                fragment.putResults(adapter);
            }

            @Override
            public void onFailure(Call<List<UserResult>> call, Throwable t) {

            }
        });
    }

    @Override
    public void onItemBoundAtPosition(RecyclerView.ViewHolder holder, int position) {
        UserResult result = results.get(position);
        ((UserViewHolder)holder).getUsername()
                .setText(position + 1 + ". " + result.getName() + " " + result.getSurname());

        ((UserViewHolder)holder).getResult()
                .setText(result.getResult() + " posts");
    }

    @Override
    public void onItemClick(View view) {

    }

    @Override
    public int getItemCount() {
        return results.size();
    }
}
