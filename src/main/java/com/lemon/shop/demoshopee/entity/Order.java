package com.lemon.shop.demoshopee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.*;

@Entity
@Table(name = "orders")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", columnDefinition = "BIGINT")
    private int id;

    @ManyToOne
    @JoinColumn(name = "UserId")
    @JsonIgnore
    private User user;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<OrderItem> orderItems = new ArrayList<>();

    @Column(name = "Order_date", nullable = false, columnDefinition = "DATETIME2")
    private Date order_date;

    @Column(name = "Status", nullable = false, columnDefinition = "VARCHAR(20)")
    private String status;

    @Column(name = "Total", nullable = false, columnDefinition = "DECIMAL(18,2)")
    private double total;

    @Column(name = "Method", nullable = false, columnDefinition = "NVARCHAR(50)")
    private String method;

    @Column(name = "Paid_status", nullable = false, columnDefinition = "VARCHAR(20)")
    private boolean paid_status;

    @Column(name = "Paid_at", nullable = false, columnDefinition = "DATETIME2")
    private Date paid_at;

    @Column(name = "Ship_address", nullable = false, columnDefinition = "NVARCHAR(255)")
    private String ship_address;

    @Column(name = "Delivery_status", nullable = false, columnDefinition = "VARCHAR(20)")
    private String delivery_status;

    @Column(name = "Ship_at", nullable = false, columnDefinition = "DATETIME2")
    private Date ship_at;

    public void addOrderDetail(OrderItem orderItem) {
        orderItems.add(orderItem);
        orderItem.setOrder(this);
    }

    public void removeOrderDetail(OrderItem orderItem) {
        orderItems.remove(orderItem);
        orderItem.setOrder(null);
    }

    public Order(int id, Date order_date, String status, double total) {
        this.id = id;
        this.order_date = order_date;
        this.status = status;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Date getOrder_date() {
        return order_date;
    }

    public void setOrder_date(Date order_date) {
        this.order_date = order_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public boolean isPaid_status() {
        return paid_status;
    }

    public void setPaid_status(boolean paid_status) {
        this.paid_status = paid_status;
    }

    public Date getPaid_at() {
        return paid_at;
    }

    public void setPaid_at(Date paid_at) {
        this.paid_at = paid_at;
    }

    public String getShip_address() {
        return ship_address;
    }

    public void setShip_address(String ship_address) {
        this.ship_address = ship_address;
    }

    public String getDelivery_status() {
        return delivery_status;
    }

    public void setDelivery_status(String delivery_status) {
        this.delivery_status = delivery_status;
    }

    public Date getShip_at() {
        return ship_at;
    }

    public void setShip_at(Date ship_at) {
        this.ship_at = ship_at;
    }
}
