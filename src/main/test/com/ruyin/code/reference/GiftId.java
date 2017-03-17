package com.ruyin.code.reference;

/**
 * Created by ruyin on 2017/3/16.
 */
public class GiftId {

    private String gid;

    public GiftId() {
    }

    public GiftId(String gid) {
        this.gid = gid;
    }

    public String getGid() {
        return gid;
    }

    @Override
    public int hashCode() {
        return this.getGid().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        boolean equalsObjects = false;
        if(obj != null && this.getClass() == obj.getClass()){
            GiftId gid = (GiftId) obj;
            equalsObjects = this.getGid().equals(gid.getGid());
        }
        return equalsObjects;
    }
}
