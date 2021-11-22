package com.zy.home.entity;

/**
 * @ProjectName: MVVMZG51905
 * @Package: com.zy.home.entity
 * @ClassName: RecommendType
 * @Description:
 * @Author: 张跃 企鹅：444511958
 * @CreateDate: 2021/11/22 13:50
 * @UpdateUser: 张跃
 * @UpdateDate: 2021/11/22 13:50
 * @UpdateRemark:
 * @Version: 1.0
 */
public class RecommendTypeEntity {
    public RecommendTypeEntity() {
    }

    public RecommendTypeEntity(int id, int category_id, int parent_id, String category_name) {
        this.id = id;
        this.category_id = category_id;
        this.parent_id = parent_id;
        this.category_name = category_name;
    }

    private int id;
    private int category_id;
    private int parent_id;
    private String category_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "RecommendTypeEntity{" +
                "id=" + id +
                ", category_id=" + category_id +
                ", parent_id=" + parent_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
