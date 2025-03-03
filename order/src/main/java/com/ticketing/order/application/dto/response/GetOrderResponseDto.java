package com.ticketing.order.application.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ticketing.order.domain.model.Order;
import java.util.List;
import java.util.UUID;
import lombok.Builder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public record GetOrderResponseDto(
        UUID orderId,
        String userId,
        UUID performanceId,
        List<SeatDetail> seats,
        Integer totalAmount,
        String orderStatus,
        String paymentMethod
) {

    public static record SeatDetail(
            UUID seatId,
            Integer seatNum,
            Integer seatRow,
            String seatType
    ) {

    }

    public static GetOrderResponseDto from(Order order, List<SeatDetail> seats) {
        return GetOrderResponseDto.builder()
                .orderId(order.getId())
                .userId(order.getUserId())
                .performanceId(order.getPerformanceId())
                .seats(seats)
                .totalAmount(order.getTotalAmount())
                .orderStatus(String.valueOf(order.getOrderStatus()))
                .paymentMethod(String.valueOf(order.getPaymentMethod()))
                .build();
    }

}
