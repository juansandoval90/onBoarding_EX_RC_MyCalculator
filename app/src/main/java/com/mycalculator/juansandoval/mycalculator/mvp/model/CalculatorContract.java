package com.mycalculator.juansandoval.mycalculator.mvp.model;


public class CalculatorContract {
    //Our view handles these methods
    public interface PublishToView {
        void showResult(String result);

        void showToastMessage(String message);
    }

    //Passes click events from our View (DisplayFragment), to the presenter
    public interface ForwardingDisplayInteractionToPresenter{
        void onDeleteShortClick();

        void onDeleteLongClick();
    }

    // Passes click events from our View (InputFragment), to the presenter
    public interface  FowardingInputInteractionToPresenter{
        void onNumberClick(int number);

        void onDecimalClick();

        void onEvaluateClick();

        void onOperatorClick(String operator);
    }
}
