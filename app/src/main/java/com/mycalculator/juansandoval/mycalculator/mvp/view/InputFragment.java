package com.mycalculator.juansandoval.mycalculator.mvp.view;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mycalculator.juansandoval.mycalculator.R;
import com.mycalculator.juansandoval.mycalculator.mvp.model.CalculatorContract;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class InputFragment extends Fragment {

    private CalculatorContract.FowardingInputInteractionToPresenter fowardInteraction;

    public void setPresenter(CalculatorContract.FowardingInputInteractionToPresenter fowardInteraction){
        this.fowardInteraction = fowardInteraction;
    }

    @OnClick({R.id.btn_number_one, R.id.btn_number_two, R.id.btn_number_three, R.id.btn_number_four,
            R.id.btn_number_five, R.id.btn_number_six, R.id.btn_number_seven, R.id.btn_number_eight,
            R.id.btn_number_nine, R.id.btn_number_zero})
    public void onNumberClick(Button v){
        fowardInteraction.onNumberClick(
                Integer.parseInt(v.getText().toString())
        );
    }

    @OnClick({R.id.btn_operator_add, R.id.btn_operator_divide, R.id.btn_operator_multiply,
            R.id.btn_operator_subtract})
    public void onOperatorClick(Button v){
        fowardInteraction.onOperatorClick(v.getText().toString());
    }

    @OnClick (R.id.btn_decimal)
    public void onDecimalClick(Button v){
        fowardInteraction.onDecimalClick();
    }

    @OnClick (R.id.btn_evaluate)
    public void onEvaluateClick(Button v){
        fowardInteraction.onEvaluateClick();
    }

    public InputFragment() {

    }

    public static InputFragment newInstance(){
        return new InputFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input, container, false);
        ButterKnife.bind(this, v);

        return v;
    }

}
