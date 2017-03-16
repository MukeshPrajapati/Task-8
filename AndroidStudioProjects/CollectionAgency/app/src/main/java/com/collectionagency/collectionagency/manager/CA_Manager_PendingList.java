package com.collectionagency.collectionagency.manager;


public class CA_Manager_PendingList {

    public CA_Manager_PendingList(String pendinglist_item, int srno) {
        this.pendinglist_item = pendinglist_item;
        this.srno = srno;
    }

    public String getPendinglist_item() {
        return pendinglist_item;
    }

    public void setPendinglist_item(String pendinglist_item) {
        this.pendinglist_item = pendinglist_item;
    }

    public int getSrno() {
        return srno;
    }

    public void setSrno(int srno) {
        this.srno = srno;
    }

    String pendinglist_item;
    int srno;

}
