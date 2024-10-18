package com.nhom2.detail.deleteInvoice;

import javax.swing.JFrame;

import com.nhom2.detail.observer.Subscriber;

public class DeleteInvoiceView extends JFrame implements Subscriber {
    private ModelView modelView;

    public DeleteInvoiceView(ModelView modelView) {
        this.modelView = modelView;
    }

    @Override
    public void update() {
        
    }

}
