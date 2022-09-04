package com.epam.rd.autotasks;

public class CompleteByRequestTask implements Task {
    private boolean completeIsCalled;
    private boolean executeIsCalled;

    {
        completeIsCalled = false;
        executeIsCalled = false;
    }

    @Override
    public void execute() {
        if (completeIsCalled) executeIsCalled = true;
    }

    @Override
    public boolean isFinished() {
        return completeIsCalled && executeIsCalled;
    }

    public void complete() {
        completeIsCalled = true;
    }
}
