package com.zy.home.entity;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.home.entity
 * @ClassName: ShopingTrolleyEntity
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/26 11:05
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/26 11:05
 * @UpdateRemark:
 * @Version: 1.0
 */
public class ShopingTrolleyEntity {
    protected int id;
    protected int goodsId;
    protected String goodsName;
    protected String goodsDesc;
    protected float goodsPrice;
    protected int goodsNumber=1;
    protected float totalPrice;

    protected int shopId;

    public ShopingTrolleyEntity(){

    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(int goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public float getTotalPrice() {
        return this.goodsNumber*this.goodsPrice;
    }



    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }
}
