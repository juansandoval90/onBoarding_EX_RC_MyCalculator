package com.mycalculator.juansandoval.mycalculator.mvp.presenter;


import com.mycalculator.juansandoval.mycalculator.mvp.model.Calculation;
import com.mycalculator.juansandoval.mycalculator.mvp.model.CalculatorContract;

public class CalculatorPresenter implements CalculatorContract.FowardingInputInteractionToPresenter,
        CalculatorContract.ForwardingDisplayInteractionToPresenter, Calculation.CalculationResult {

    private CalculatorContract.PublishToView publishResult;
    private Calculation calc;

    //An object of DisplayFragment
    public CalculatorPresenter (CalculatorContract.PublishToView publishResult){
        this.publishResult = publishResult;
        calc = new Calculation();
        calc.setCalculationResultListener(this);
    }

    @Override
    public void onDeleteShortClick() {
        calc.deleteCharacter();
    }

    @Override
    public void onDeleteLongClick() {
        calc.deleteExpression();
    }

    @Override
    public void onNumberClick(int number) {
        calc.appendNumber(Integer.toString(number));
    }

    @Override
    public void onDecimalClick() {
        calc.appendDecimal();
    }

    @Override
    public void onEvaluateClick() {
        calc.performEvaluation();
    }

    @Override
    public void onOperatorClick(String operator) {
        calc.appendOperator(operator);
    }

    @Override
    public void onExpressionChanged(String result, boolean successful) {
        if (successful) {
            publishResult.showResult(result);
        } else {
            publishResult.showToastMessage(result);
        }
    }
}
