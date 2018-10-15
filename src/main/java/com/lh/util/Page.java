package com.lh.util;

public class Page {
    private int start;
    private int count;
    private int total;
    private String param;

    public Page()
    {
        count = 8;
    }
    public Page(int start, int count) {
        this.start = start;
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public int getLast()
    {
        int tem = getTotal()%getCount();
        int last = 0;
        if(tem==0)
            last = getTotal()-getCount();
        else
            last = getTotal()-tem;
        return last>0?last:0;
    }


    public int getTotalPage()
    {
        int tem = getTotal()/getCount();
        if(getTotal()%getCount()!=0)
            tem+=1;
        return tem==0?1:tem;
    }

    public boolean hasPrevious()
    {
        if (getStart()==0)
            return false;
        return true;
    }

    public boolean hasNext()
    {
        if(start==getLast())
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Page{" +
                "start=" + start +
                ", count=" + count +
                ", total=" + total +
                ", param='" + param + '\'' +
                '}';
    }
}
