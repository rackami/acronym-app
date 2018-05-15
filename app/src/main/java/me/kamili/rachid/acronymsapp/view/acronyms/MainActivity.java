package me.kamili.rachid.acronymsapp.view.acronyms;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import me.kamili.rachid.acronymsapp.R;
import me.kamili.rachid.acronymsapp.adapter.AcronymAdapter;
import me.kamili.rachid.acronymsapp.injection.component.DaggerAcronymComponent;
import me.kamili.rachid.acronymsapp.injection.module.AcronymsModule;
import me.kamili.rachid.acronymsapp.module.LongForm;
import me.kamili.rachid.acronymsapp.view.base.BaseActivity;

public class MainActivity extends BaseActivity implements MainView, AcronymAdapter.OnClickListener {

    @Inject
    protected MainPresenter mPresenter;

    @BindView(R.id.et_search)
    EditText mSearchEditText;

    @BindView(R.id.rvAcronymList)
    RecyclerView mRecyclerView;

    private AcronymAdapter mAdapter;

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void resolveDaggerDependency() {
        DaggerAcronymComponent.builder()
                .applicationComponent(getApplicationComponent())
                .acronymsModule(new AcronymsModule(this))
                .build().inject(this);
    }

    @Override
    protected void onActivityReady(Bundle savedInstanceState, Intent intent) {
        initiateRecyclerView();
    }

    private void initiateRecyclerView() {
        mRecyclerView.setHasFixedSize(true);

        // using a linear layout manager
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify the adapter
        mAdapter = new AcronymAdapter(getLayoutInflater());
        mAdapter.setClickListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @OnClick(R.id.search_btn)
    public void onSearch(Button button) {
        hideKeyboard();
        mPresenter.getAcronyms(mSearchEditText.getText().toString());
    }

    @Override
    public void onAcronymsLoaded(List<LongForm> acronyms) {
        mAdapter.addLongForms(acronyms);
    }

    @Override
    public void onClear() {
        mAdapter.clearLongForms();
    }

    @Override
    public void onClearSearch() {
        mSearchEditText.setText("");
    }

    @Override
    public void onLongFormClick(LongForm lf, int position) {
        onShowSnackbar(lf.getLongform() + " is clicked");
    }

    @Override
    public void onShowDialog(String message) {
        showDialog(message);
    }

    @Override
    public void onHideDialog() {
        hideDialog();
    }

    @Override
    public void onShowSnackbar(String message) {
        Snackbar.make(mRecyclerView, message, Snackbar.LENGTH_LONG).show();
    }

    public void hideKeyboard(){
        View view = getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            if (imm != null) {
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        }
    }

}
