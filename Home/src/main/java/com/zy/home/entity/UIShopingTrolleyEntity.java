package com.zy.home.entity;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.home.entity
 * @ClassName: UIShopingTrolleyEntity
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/26 11:09
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/26 11:09
 * @UpdateRemark:
 * @Version: 1.0
 */
public class UIShopingTrolleyEntity extends ShopingTrolleyEntity {
    /**
     * 是否选中
     */
    private boolean isChecked=false;
    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    public UIShopingTrolleyEntity(int _id, int goodsId, String goodsName, String goodsDesc, float goodsPrice, int goodsNumber, int shopId) {
        this.id=_id;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsDesc = goodsDesc;
        this.goodsPrice = goodsPrice;
        this.goodsNumber = goodsNumber;
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "UIShopingTrolleyEntity{" +
                "isChecked=" + isChecked +
                ", id=" + id +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsDesc='" + goodsDesc + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsNumber=" + goodsNumber +
                ", totalPrice=" + totalPrice +
                ", shopId=" + shopId +
                '}';
    }
}
