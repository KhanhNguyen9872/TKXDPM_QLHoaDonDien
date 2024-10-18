package com.nhom2.detail.addInvoice;

import javax.swing.JFrame;

import com.nhom2.detail.observer.Subscriber;

public class AddInvoiceView extends JFrame implements Subscriber {
    private ModelView modelView;

    public AddInvoiceView(ModelView modelView) {
        this.modelView = modelView;
    }

    @Override
    public void update() {
        
    }
}
